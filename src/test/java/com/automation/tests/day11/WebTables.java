package com.automation.tests.day11;

import com.automation.tests.day5.BrowersUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class WebTables {
    private static Object BrowserUtils;


        private WebDriver driver;

        @BeforeMethod
        public void setup() {
            WebDriverManager.chromedriver().version("79").setup();
            ChromeOptions chromeOptions=new ChromeOptions();
            // headless mode makes execution twice faster
            // it does everything except file uploading
            // set it to tru to make it work

            chromeOptions.setHeadless(false); // to run browser without GUI. Makes browser invisible
            driver = new ChromeDriver(chromeOptions);

            driver.get("http://practice.cybertekschool.com/tables");
            driver.manage().window().maximize();
            BrowersUtils.wait(3);
        }

        @AfterMethod
        public void teardown() {
            BrowersUtils.wait(3);
            driver.quit();
        }

        @Test
        public void getColumnNames(){
            // th -- represents table header cells
            List<String> expected= Arrays.asList("Last Name","First Name", "Email", "Due", "Web Site", "Action");
            List<WebElement> columnNames=driver.findElements(By.xpath("//table[1]//th"));

            Assert.assertEquals(BrowersUtils.getTextFromWebElement(columnNames),expected);


        }

        @Test
        public void verifyRowCount(){
            // tbody // tr - to get all rows from table body, excluding table header
            List<WebElement> rows=driver.findElements(By.xpath("//table[1]//tbody//tr"));
            // if we will get a size of this collection, it automatically equals to number of elements
            Assert.assertEquals(rows.size(),4);
        }

        @Test
        public void getSpecificColumn(){
            // td[5] -- column with links
            List<WebElement> links=driver.findElements(By.xpath("//table[1]//tr//td[5]"));
            System.out.println(links.stream().map(x -> x.getText()).collect(Collectors.toList()));
        }

        @Test
        public void Delete(){
          driver.findElement(By.xpath("//table[1]//td[text()='jsmith@gmail.com']/..//a[2]")).click();

            List<WebElement> rows=driver.findElements(By.xpath("//table[1]//tbody//tr"));

            Assert.assertEquals(rows.size(),3);

            List<WebElement> links=driver.findElements(By.xpath("//table[1]//tr//td[5]"));
            List<String> emails=links.stream().map(x -> x.getText()).collect(Collectors.toList());
            Assert.assertFalse(emails.contains("jsmith@gmail.com"));
        }

        @Test
        public void getColumnIndexByName(){
            String columnName="Email";

            List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));

            int index=0;
            for(int i=0; i<columnNames.size();i++){
                String actualColumnName= columnNames.get(i).getText();

                System.out.println(String.format("Column name: %s, position %s", actualColumnName,i));
                if(actualColumnName.equals(columnName)){
                    index = i+1;
                    break;
                }
            }

            Assert.assertEquals(index,3);
        }

        @Test
        public void getSpecificCell () {
            String expected ="http://www.jdoe.com";

            int row =3;
            int column =5;

            String xpath="//table[1]//tbody//tr["+row+"]//td["+column+"]";
            WebElement cell = driver.findElement(By.xpath(xpath));

            Assert.assertEquals(cell.getText(), expected);
        }




}

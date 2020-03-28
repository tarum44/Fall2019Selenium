package com.automation.tests.day12;

import com.automation.tests.day5.BrowersUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebOrders {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createADriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);
    }
    /*
    * Go to web orders page
    * Click on "Check All" button
    * Verify that all records are selected
     */
    @Test
    public void checkBoxTest(){
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();

        BrowersUtils.wait(2);

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        for (WebElement checkbox : checkboxes) {
            Assert.assertTrue(checkbox.isSelected());
        }
    }


    /*
    *  Go to web orders page
    *  Verify that Steve Johns zip code is 21233
    *  Then update his zip code to 200002
    *  Then verify that Steve Johns zip code is 200002
     */

    @Test
    public void updateZipCode(){

        //   td[text()='Steve Johns']//following-sibling::td[7]   ---- sibling xpath
        driver.findElement(By.xpath("//table//table//tr[4]//td[13]")).click();

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).clear();

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("20002");


        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();

        String afterChange=driver.findElement(By.xpath("//table//table//tr[4]//td[9]")).getText();
        String zip="20002";

        System.out.println(afterChange);
        Assert.assertEquals(afterChange,zip);





    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}

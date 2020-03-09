package com.automation.tests.day6;

import com.automation.tests.day5.BrowersUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();

        BrowersUtils.wait(2);

        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement simpleDropdown=driver.findElement(By.id("dropdown"));

        // Using Select class to choose one of the options
        Select selectSimpleDropdown=new Select(simpleDropdown);


        // selectbyVisibleText --- it choose from options listed in the visible text
        selectSimpleDropdown.selectByVisibleText("Option 2");
        BrowersUtils.wait(3);
        // and select option 1
        selectSimpleDropdown.selectByVisibleText("Option 1");

        BrowersUtils.wait(2);
        Select selectYear=new Select(driver.findElement(By.id("year")));
        Select selectMonth=new Select(driver.findElement(By.id("month")));
        Select selectDay=new Select(driver.findElement(By.id("day")));

        selectYear.selectByValue("2010");
        selectMonth.selectByValue("1");
        selectDay.selectByValue("28");
        BrowersUtils.wait(2);

        List<WebElement> months=selectMonth.getOptions();

        for(WebElement eachMonths:months){
            String monthName=eachMonths.getText();
            selectMonth.selectByVisibleText(monthName);
            BrowersUtils.wait(1);

        }

        Select selectState=new Select(driver.findElement(By.id("state")));
        selectState.selectByVisibleText("Iowa");
        BrowersUtils.wait(1);

        // to get currently selected element
        // getFirstSelectedOption () -- returns a webelement, that's why we need to call getText
        // getText() retrieves visible text from the webelement

        String selectedState=selectState.getFirstSelectedOption().getText();

        if(selectedState.equals("Iowa")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        List<WebElement> states=selectState.getOptions();
        for(WebElement stateOption:states){
            System.out.println(stateOption.getText());
        }
        BrowersUtils.wait(3);

        BrowersUtils.wait(2);
        driver.quit();
    }
}

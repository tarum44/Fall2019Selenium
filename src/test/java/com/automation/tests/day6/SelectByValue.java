package com.automation.tests.day6;

import com.automation.tests.day5.BrowersUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByValue {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowersUtils.wait(3);
        Select stateSelect=new Select(driver.findElement(By.id("state")));
        stateSelect.selectByValue("DC");

        String expected="District of Columbia" ;
        String actual=stateSelect.getFirstSelectedOption().getText();

        if(expected.equalsIgnoreCase(actual)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

    }
}

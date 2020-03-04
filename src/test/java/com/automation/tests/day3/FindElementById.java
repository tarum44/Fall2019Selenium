package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementById {
    public static void main(String[] args) throws Exception{
        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
       Thread.sleep(2000);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("12345");
        Thread.sleep(2000);
        WebElement signUp=driver.findElement(By.name("wooden_spoon"));
        Thread.sleep(2000);
        signUp.click();
        Thread.sleep(2000);
        driver.quit();

    }
}

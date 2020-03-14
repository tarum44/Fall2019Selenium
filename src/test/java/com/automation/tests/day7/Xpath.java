package com.automation.tests.day7;

import com.automation.tests.day5.BrowersUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Xpath {
    static String userNameLocator="//label[text()='Username']/following-sibling::input";
    static String passwordLocator="//label[text()='Password']/following-sibling::input";
    static String loginBtnLocator="//button[contains(text(),'Login')]";
    public static void main(String[] args){



        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        BrowersUtils.wait(3);
        driver.findElement(By.xpath(userNameLocator)).sendKeys("tomsmith");
        driver.findElement(By.xpath(passwordLocator)).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath(loginBtnLocator)).click();

        BrowersUtils.wait(3);
        driver.quit();
    }
}

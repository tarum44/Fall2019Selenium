package com.automation.tests.day7;

import com.automation.tests.day5.BrowersUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssSelector {
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        // . means class name in css selector syntax
        WebElement heading=driver.findElement(By.cssSelector(".h3"));
        WebElement home=driver.findElement(By.cssSelector(".nav-link"));
        WebElement btn1=driver.findElement(By.cssSelector("[onclick='button1()']"));
        WebElement btn2=driver.findElement(By.cssSelector("[name='button2']"));
        // starts with
        WebElement btn3=driver.findElement(By.cssSelector("[id^='button_']"));
        WebElement btn4=driver.findElement(By.cssSelector("[onclick='button4()']"));
        WebElement btn5=driver.findElement(By.cssSelector("[onclick='button5()']"));
        WebElement btn6=driver.findElement(By.cssSelector("#disappearing_button"));

        btn1.click();
        BrowersUtils.wait(2);
        btn2.click();
        BrowersUtils.wait(2);
        btn3.click();
        BrowersUtils.wait(2);
        btn4.click();
        BrowersUtils.wait(2);
        btn5.click();
        BrowersUtils.wait(2);
        btn6.click();
        BrowersUtils.wait(2);

        BrowersUtils.wait(2);
        driver.quit();

    }
}

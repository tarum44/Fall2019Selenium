package com.automation.tests.day6;

import com.automation.tests.day5.BrowersUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Driver;

public class Xpath {
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowersUtils.wait(3);


        // if you dont know the tag name, or want to skip tag name, use *
        // for example //*[@onclick='button1()'] | * means any tag name
        WebElement btn1=driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/button[1]"));
        btn1.click();


        BrowersUtils.wait(3);
        driver.quit();
    }
}

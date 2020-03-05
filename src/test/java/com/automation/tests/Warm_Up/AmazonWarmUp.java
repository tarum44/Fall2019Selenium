package com.automation.tests.Warm_Up;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.DriverManager;

public class AmazonWarmUp {
    public static void main(String[] args) {

        //go to amazon
        //Go to ebay
        //enter search term
        //click on search button
        //verify title contains search term

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.com");

        driver.findElement(By.name("field-keywords")).sendKeys("macbook", Keys.ENTER);


        if(driver.getTitle().contains("macbook")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        driver.quit();

    }
}

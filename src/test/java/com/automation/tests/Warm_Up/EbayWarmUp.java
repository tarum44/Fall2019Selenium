package com.automation.tests.Warm_Up;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EbayWarmUp {
    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.ebay.com");

        driver.findElement(By.name("_nkw")).sendKeys("macbook");

        driver.findElement(By.id("gh-btn")).click();

        System.out.println(driver.findElement(By.tagName("h1")).getText());

        driver.quit();


    }
}

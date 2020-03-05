package com.automation.tests.Warm_Up;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikipediaWarmUp {
    public static void main(String[] args) {
//        Go to wikipedia.org
//        enter search term `selenium webdriver`
//        click on search button
//        click on search result `Selenium (software)`
//        verify url ends with `Selenium_(software)`

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.wikipedia.org");

        driver.findElement(By.name("search")).sendKeys("selenium webdriver", Keys.RETURN);

        if(driver.getCurrentUrl().contains("selenium")){
            System.out.println("TEST PASSSED");
        }else{
            System.out.println("TEST FAILED");
        }

        driver.quit();
    }
}
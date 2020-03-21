package com.automation.tests.day9;

import com.automation.tests.day5.BrowersUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {
   // private WebDriver driver;
    private RemoteWebDriver driver;

    @BeforeMethod
    public void setup(){
       // driver= DriverFactory.createADriver("chrome");
        WebDriverManager.chromedriver().version("79").setup();
        driver =new ChromeDriver();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void scrollTest(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();
       // We are casting here since we use WebDriver to create "driver"
        // if we use RemoteWebDriver, we do not need the casting

        // By casting the WebDriver isntance to a JavaScriptExecutor interface, we can
        // execute the JavaScript code in Selenium WebDriver

        //  JavascriptExecutor js=(JavascriptExecutor) driver;
        for(int i=0;i<10;i++){
            driver.executeScript("window.scrollBy(0,250)");
            // scroll down 250 pixels
            // x , y
            BrowersUtils.wait(3);
        }
        BrowersUtils.wait(3);
    }

    @Test
    public void scrollToElementTest(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();
        WebElement link=driver.findElement(By.linkText("Cybertek School"));
        // scrollIntoView - javascript method
        // arguments[0] - means 1st webelement after comma
        driver.executeScript("arguments[0].scrollIntoView(true)",link);

    }
}

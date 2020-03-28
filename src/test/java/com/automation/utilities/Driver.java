package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
    // DriverFactory -- gives you every time new webdriver object;
    // Driver class -- gives you always same webdriver object. Every single test, will use same webdriver object
    // configurationreader -- to read parameters from properties file (URLS,browser type, credentials, etc..)
    // webdriverManager -- setup browser driver (middleman between java code and browser)


    // same for everyone
    private static WebDriver driver;

    // so no one can create object for Driver class
    // everyone should call static getter method instead

    private Driver(){ }

    public static WebDriver getDriver(){
        // if WebDriver object doesn't exist
        // create it
        if(driver==null){
            String browser=ConfigurationReader.getProperty("browser");
            switch(browser){
                case "chrome":
                    WebDriverManager.chromedriver().version("79").setup();
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Wrong browser name!");
            }
        }
        return driver;

    }

    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver=null;
        }
    }



}

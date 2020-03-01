package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) {
        // to start selenium script we need
        // setup webdriver (browser driver) and create webdriver object
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver=new ChromeDriver();

        // In selenium, everything starts from WebDriver interface
        driver.get("https://www.google.com/");

    }
}

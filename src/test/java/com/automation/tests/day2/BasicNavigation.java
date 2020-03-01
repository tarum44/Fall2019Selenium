package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception{
        // to start selenium script we need
        // setup webdriver (browser driver) and create webdriver object
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver=new ChromeDriver();

        // In selenium, everything starts from WebDriver interface
        // ChromeDriver extends RemoteWebDriver -->> implements WebDriver
        driver.get("https://www.google.com/"); // to open a website

        Thread.sleep(3000); // for demo, wait 3 seconds

        // method that return page title
        // you can also see it as as tab name, in the browser

        String title= driver.getTitle(); // returns <title> Some title </title> text
        String expectedTitle="Google";

        System.out.println("Title is..."+title);

        if(expectedTitle.equalsIgnoreCase(title)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        driver.close(); // to close browser

    }
}

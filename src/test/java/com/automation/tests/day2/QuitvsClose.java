package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitvsClose {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromiumdriver().setup();

        WebDriver driver=new ChromeDriver();


        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(4000);

//        driver.close(); will close only one window
        driver.quit();


    }
}

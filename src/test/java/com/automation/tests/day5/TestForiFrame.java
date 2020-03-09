package com.automation.tests.day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestForiFrame {
    public static void main(String[] args) {

            WebDriverManager.chromedriver().setup();
            WebDriver driver=new ChromeDriver();

            driver.get("http://practice.cybertekschool.com/iframe");

            BrowersUtils.wait(2);
            // before looking for that element, we need to jump to that frame
            // iframe id
            driver.switchTo().frame("mce_0_ifr");
            BrowersUtils.wait(2);
            // now, this content will be visible
            WebElement textInput=driver.findElement(By.id("tinymce"));

            System.out.println(textInput.getText());

            textInput.clear();
            textInput.sendKeys("Hello World");
            // exit from the frame
            BrowersUtils.wait(2);
            driver.switchTo().defaultContent();

            WebElement heading = driver.findElement(By.tagName("h3"));
            System.out.println(heading.getText());

            System.out.println();
             BrowersUtils.wait(2);
            driver.quit();
        }
}


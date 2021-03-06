package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementById {
    public static void main(String[] args) throws Exception{
        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
       Thread.sleep(2000);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        Thread.sleep(2000);
        WebElement signUp=driver.findElement(By.id("wooden_spoon"));
        Thread.sleep(2000);
        signUp.click();

        String expected="Welcome to the Secure Area. When you are done click logout below.";

        String actual=driver.findElement(By.tagName("h4")).getText();

        if(expected.equalsIgnoreCase(actual)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        // let's click on Logout button. It looks like a button, but it's actually a link
        // every element with <a> tag is a link
        // if you have a couple spaces in text, just use partialLinkText instead of linkText
        // linkTest - equals ()
        // partialLinkText - contains() -- complete match doesn't required
        // dont put space
        Thread.sleep(2000);
        WebElement logout=driver.findElement(By.partialLinkText("Logout"));


        String href=logout.getAttribute("href");
        String className=logout.getAttribute("class");
        System.out.println(href);
        System.out.println(className);

        logout.click();
        Thread.sleep(2000);

        driver.findElement(By.name("username")).sendKeys("wrong");
        driver.findElement(By.name("password")).sendKeys("wrong");
        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(2000);

        // To print messages for negative tests
        WebElement errorMessage = driver.findElement(By.id("flash-messages"));
        System.out.println(errorMessage.getText());


        driver.quit();

    }
}

package com.automation.tests.day6;

import com.automation.tests.day5.BrowersUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createADriver("chrome");

        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowersUtils.wait(3);

        List<WebElement> buttons=driver.findElements(By.tagName("button"));

        buttons.get(0).click();
        BrowersUtils.wait(3);


        // to get the text from pop-up message;
        String actualMessage=driver.switchTo().alert().getText();
        System.out.println(actualMessage);


        // to click pop-up message
        driver.switchTo().alert().accept();


        // compare the pop-up message with the same with the expected message
        String expected="You successfully clicked an alert";
        String actual=driver.findElement(By.id("result")).getText();

        if(expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
            System.out.println("Expected"+expected);
            System.out.println("Actual"+actual);
        }

        BrowersUtils.wait(3);

        buttons.get(1).click();
        BrowersUtils.wait(3);

        // to click cancel
        driver.switchTo().alert().dismiss();

        String expected2="You clicked: Cancel";
        String actual2=driver.findElement(By.id("result")).getText();

        if(expected2.equals(actual2)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
            System.out.println("Expected"+expected2);
            System.out.println("Actual"+actual2);
        }

        // TASK: click on button #3
        // Enter some text: Hello, World!
        // Verify that result text ends with Hello, World

        buttons.get(2).click();

        BrowersUtils.wait(3);

        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Hello, World!");

        alert.accept();

        String actual3=driver.findElement(By.id("result")).getText();
        String expected3="Hello, World!";

        if(expected3.equals(actual2)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
            System.out.println("Expected"+expected3);
            System.out.println("Actual"+actual3);
        }







        BrowersUtils.wait(3);
        driver.quit();
    }
}

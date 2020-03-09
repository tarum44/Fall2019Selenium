package com.automation.tests.day5;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonTest {
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        BrowersUtils.wait(2);

        WebElement blackbutton=driver.findElement(By.id("black"));

        blackbutton.click();

        // how do we verify that button clicked
        // return true, if button clicked
        if(blackbutton.isDisplayed() && blackbutton.isEnabled()){
            System.out.println("CLICKED ON BLACK BUTTON");
            blackbutton.click();
        }else{
            System.out.println("FAILED TO CLICK TO BUTTON");
        }
        BrowersUtils.wait(2);

        if(blackbutton.isSelected()){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }




        driver.quit();
    }
}

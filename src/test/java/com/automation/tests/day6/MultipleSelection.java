package com.automation.tests.day6;

import com.automation.tests.day5.BrowersUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MultipleSelection {
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowersUtils.wait(3);
        Select languagesSelect=new Select(driver.findElement(By.name("Languages")));
        boolean isMultiple=languagesSelect.isMultiple();
        System.out.println("isMultiple = " + isMultiple);


        languagesSelect.selectByVisibleText("Java");
        languagesSelect.selectByVisibleText("JavaScript");
        languagesSelect.selectByVisibleText("Python");

        // let's get all selected option
        
        List<WebElement> selectedLanguages=languagesSelect.getAllSelectedOptions();

        for(WebElement languages:selectedLanguages){
            System.out.println(languages.getText());
        }

        languagesSelect.deselectByVisibleText("Java");
        languagesSelect.deselectAll();

        BrowersUtils.wait(3);
        driver.quit();
    }
}

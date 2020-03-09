package com.automation.tests.day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/checkboxes");

        BrowersUtils.wait(2);

        List<WebElement> boxesCheck=driver.findElements(By.tagName("input"));

//        boxesCheck.get(0).click();

        BrowersUtils.wait(2);
        for (int i=0;i<boxesCheck.size();i++) {
            if ((boxesCheck.get(i).isDisplayed()) && (!boxesCheck.get(i).isSelected()) && (boxesCheck.get(i).isEnabled())) {
                boxesCheck.get(i).click();
                System.out.println(i+1+" checkbox clicked");
            }else{
                System.out.println(i+1+" checkbox wasn't clicked!");
            }
        }



        BrowersUtils.wait(2);

        driver.quit();




    }
}

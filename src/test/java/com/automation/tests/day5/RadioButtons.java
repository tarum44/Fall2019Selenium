package com.automation.tests.day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtons {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();

        BrowersUtils.wait(2);
        // <input type="radio"
        List<WebElement> radioButtons= driver.findElements(By.tagName("input"));



        for(WebElement radioButton:radioButtons){
            // to check if button can be clicked
            if(radioButton.isEnabled()){
                radioButton.click();
                System.out.println("Clicked on : "+radioButton.getAttribute("id"));
                BrowersUtils.wait(1);
            }else{
                System.out.println("Button is disabled, not clicked");
            }
            System.out.println();
        }
        driver.quit();
    }
}

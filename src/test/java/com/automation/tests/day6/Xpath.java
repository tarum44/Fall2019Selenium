package com.automation.tests.day6;

import com.automation.tests.day5.BrowersUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Driver;

public class Xpath {
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowersUtils.wait(3);


        // if you dont know the tag name, or want to skip tag name, use *
        // for example //*[@onclick='button1()'] | * means any tag name
        // two slashed refers to the relative xpath
        // / one slashed refers to the absolute xpath
        WebElement btn1=driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/button[1]"));
        btn1.click();

        WebElement result=driver.findElement(By.id("result"));
        System.out.println(result.getText());

        // // getting xpath from browser is not reliable
        // better to write the xpath
        // check out classNote to check out how to write the tag 3/8/2020
        WebElement btn2=driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/button[2]"));
        btn2.click();
        System.out.println(result.getText());


        WebElement btn3=driver.findElement(By.xpath(("//button[starts-with(@id,'button_')]")));
        btn3.click();
        System.out.println(result.getText());

        WebElement btn4=driver.findElement(By.xpath(("//button[starts-with(@id,'button_')]")));
        btn4.click();
        System.out.println(result.getText());

        WebElement btn5=driver.findElement(By.xpath("//button[contains(text(),'5')]"));
        btn5.click();
        System.out.println(result.getText());

        btn1.click();
        BrowersUtils.wait(3);
        driver.quit();
    }
}

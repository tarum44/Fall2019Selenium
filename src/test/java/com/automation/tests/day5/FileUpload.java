package com.automation.tests.day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/upload");
        BrowersUtils.wait(5);

        WebElement upload=driver.findElement(By.id("file-upload"));
        String filePath=System.getProperty("user.dir")+"/pom.xml";

        upload.sendKeys(filePath);

        driver.findElement(By.id("file-submit")).click();

        BrowersUtils.wait(5);
        driver.quit();



    }
}

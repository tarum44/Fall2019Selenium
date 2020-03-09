package com.automation.tests.day6;

import com.automation.tests.day5.BrowersUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByIndex {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();

        BrowersUtils.wait(2);
        driver.get("http://practice.cybertekschool.com/dropdown");
        Select stateSelect=new Select(driver.findElement(By.id("state")));

        // index starts from 0
        stateSelect.selectByIndex(9);
        BrowersUtils.wait(3);

        // select last option
        stateSelect.selectByIndex(stateSelect.getOptions().size()-1);
        BrowersUtils.wait(2);
        driver.quit();
    }
}

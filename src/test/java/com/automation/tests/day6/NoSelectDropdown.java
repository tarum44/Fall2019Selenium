package com.automation.tests.day6;

import com.automation.tests.day5.BrowersUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class NoSelectDropdown {
    public static void main(String[] args) {

        // there are two types of drop-downs: select and other
        // To handle select drop-downs, use Select class from Selenium and you can select by:
        // text, value, text

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();
        BrowersUtils.wait(3);

        driver.findElement(By.id("dropdownMenuLink")).click(); // to expand dropdown
        BrowersUtils.wait(2);
        driver.findElement(By.linkText("Amazon")).click();


        BrowersUtils.wait(2);

        List<WebElement> allLinks=driver.findElements(By.className("dropdown-item"));
        for(WebElement link:allLinks){
            System.out.println(link.getText()+" : "+link.getAttribute("href"));
        }

        BrowersUtils.wait(3);
        driver.quit();

    }
}

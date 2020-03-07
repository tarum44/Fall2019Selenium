package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");

        Thread.sleep(3000);

        // how to collect all links from the page?
        // you can use findElements method to find 0+ elements
        // In case of findElement - only 1 element. If there is not element by given locator -NoSuchElementException
        List<WebElement> links=driver.findElements(By.tagName("a"));




        // SteleElementReferenceException -- means that selenium cannot find previously located element
        // It happens, when you are trying to interact with element after page refresh or navigation

        for(WebElement link:links){
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
            System.out.println();
           
//            Thread.sleep(2000);
//            driver.navigate().back();         The first button get us always the home page
        }


        // it doesn't work becuase whenever we use the same code
//        // links element created again
//
//        for(int i=1;i<links.size();i++) {
//            links.get(i).click();
//            Thread.sleep(2000);
//            driver.navigate().back();
//        }
//
             for(int i=1;i<links.size();i++) {
                 links.get(i).click();
                 driver.navigate().back();
                 // refresh list
                 links=driver.findElements(By.tagName("a"));
         }
//
             driver.quit();


             // what happens if elements wasn't found, in case of findElement?
             // NoSuchElementException
             // what happens if element wasn't found, in case of findElements?
    }
}

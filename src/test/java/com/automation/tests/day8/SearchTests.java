package com.automation.tests.day8;

import com.automation.tests.day5.BrowersUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {

    private WebDriver driver;

    @Test
    public void googleSearchTest(){
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("java");
        List<WebElement> searchItems=driver.findElements(By.tagName("h3"));
        for(WebElement searchItem: searchItems){
            String var=searchItem.getText();
            // if there is a text -- print it
            if(! var.isEmpty()){
                System.out.println(var);
                // verify that every search result contains java
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }
        }
    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }

    @AfterMethod
    public void teardown(){
        // close browser and destroy webdriver object
        driver.quit();
    }

    @Test(description = "Search for Java Book on Amazon")
    public void amazonSearchTest(){
        driver.get("http://amazon.com");
        BrowersUtils.wait(5);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java", Keys.ENTER);
        BrowersUtils.wait(5);

        List<WebElement> searchItems = driver.findElements(By.xpath("//h2//a"));

        //click on the first item
        searchItems.get(0).click();
        BrowersUtils.wait(5);

        WebElement productTitle = driver.findElement(By.id("title"));
        String productTitleString = productTitle.getText();
        System.out.println(productTitleString);

        Assert.assertTrue(productTitleString.contains("Java"));

        // so h2 elements are not clickable, even though they contain links
        // that's why, instead of collection all h2 elements
        // we collected all hyperlinks
        // every hyperlink represent some search item
    }



}

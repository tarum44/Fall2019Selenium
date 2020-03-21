package com.automation.tests.fleet;

import com.automation.tests.day5.BrowersUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class VehiclesPageTests {
    private WebDriver driver;
    private String username="storemanager85";
    private String password="UserUser123";
    private String URL="https://app.vytrack.com/user/login";
    private By usernameBy=By.id("prependedInput");
    private By passwordBy=By.id("prependedInput2");
    private By fleetBy=By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span");
    private By pageNumberBy=By.cssSelector("input[type='number']");


    @Test
    public void subTitle(){
//        driver.findElement(usernameBy).sendKeys(username);
//        driver.findElement(passwordBy).sendKeys(password,Keys.ENTER);
//
//        BrowersUtils.wait(5);
//        // click on fleet
//
//        // driver.findElement(fleetBy).click();
//
//        // Action class is used for more advanced browser interactions
//        Actions actions=new Actions(driver);
//        actions.moveToElement(driver.findElement(fleetBy)).perform();
        // perform - to execute command
        // every action should end with perform()

        BrowersUtils.wait(5);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]/a/span")).click();


        BrowersUtils.wait(10);
        String Expected="All Cars";
        String Actual=driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(Actual,Expected,"results is not same");

    }

    @Test
    public void verifyPageNumber(){
       String expected="1";
       String actual=driver.findElement(pageNumberBy).getAttribute("value");
       Assert.assertEquals(expected,actual);


    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password,Keys.ENTER);

        BrowersUtils.wait(5);
        // click on fleet

        // driver.findElement(fleetBy).click();

        // Action class is used for more advanced browser interactions
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(fleetBy)).perform();
    }

    @AfterMethod
    public void teardown(){
        // if webdriver object alive
        if(driver != null){
            // close browser, close session
            driver.quit();
            // destroy driver object for sure
            driver = null;
        }
    }
}

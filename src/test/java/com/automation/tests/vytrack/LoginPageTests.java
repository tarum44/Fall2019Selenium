package com.automation.tests.vytrack;

import com.automation.tests.day5.BrowersUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// STATIC IMPORT OF ALL ASSERTIONS
import static org.testng.Assert.*;

public class LoginPageTests {
    private WebDriver driver;
    // https is a secured version of http protocol
    // http - it's hypertext transfer protocol that every single website is using nowadays
    // https - data encrypted, no chance for hackers to retrieve info
    // http - data as a plain text, very easy to hack it
    private String URL="https://app.vytrack.com/user/login";
    private By usernameBy=By.id("prependedInput");
    private By passwordBy=By.id("prependedInput2");
    private String username="storemanager85";
    private String password="UserUser123";
    private By warningMessageBy=By.xpath("//*[@id=\"login-form\"]/fieldset/div[1]/div");


    @Test(description="Verify that warning message displays when user enters invalid username")
    public void invalidUserName(){
        driver.findElement(usernameBy).sendKeys("invalidusername");
        driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        WebElement warningElement=driver.findElement(warningMessageBy);
        assertTrue(warningElement.isDisplayed());
    }

    @Test(description = "Login as store manager and verify that tile equals to Dashboard")
    public void loginAsStoreManager(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowersUtils.wait(2);

        String expected="Dashboard";
        String actual=driver.getTitle();

        assertEquals(actual,expected,"page title is not correct");
    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
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

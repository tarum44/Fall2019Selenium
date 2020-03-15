package com.automation.tests.day8;

import com.automation.tests.day5.BrowersUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class PracticeTests {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        // INTERVIEW QUESTION: HOW TO HANDLE SSL ISSUES IN SELENIUM??
        // ChromeOptions - use to customize browser fo tests
        ChromeOptions chromeOptions=new ChromeOptions();
        // to ignore "Your connection is not private issue"
        chromeOptions.setAcceptInsecureCerts(true);
        // provide chromeOptions object into chromedriver constructor
        driver=new ChromeDriver();
       // driver.get("http://practice.cybertekschool.com/login");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeItDown(){
     driver.quit();
    }

    @Test
    public void loginTest(){
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.id("wooden_spoon")).click();
        String expected="Welcome to the Secure Area. When you are done click logout below.";
        String actual=driver.findElement(By.tagName("h4")).getText();
        // if assertion fails, it will throw excepton and method will be printed
        Assert.assertEquals(expected,actual,"Subheader message is not mathcing");

    }

    @Test
    public void forgotPasswordTest(){
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.findElement(By.xpath("//*[@id=\"forgot_password\"]/div/div/input")).sendKeys("abc@gmail.com", Keys.ENTER);
        String actual=driver.findElement(By.tagName("h4")).getText();
        String expected= "Your e-mail's been sent!";
        Assert.assertEquals(actual,expected,"Message does not match");
    }

    @Test
    public void checkBoxes(){
        driver.get("http://practice.cybertekschool.com/checkboxes");
        List<WebElement> checkBoxes=driver.findElements(By.tagName("input"));
        System.out.println(checkBoxes);
        BrowersUtils.wait(2);
        checkBoxes.get(0).click();
        BrowersUtils.wait(2);
        Assert.assertTrue(checkBoxes.get(0).isSelected());
    }
}




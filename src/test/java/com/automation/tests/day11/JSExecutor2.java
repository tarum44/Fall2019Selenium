package com.automation.tests.day11;

import com.automation.tests.day5.BrowersUtils;
import com.automation.utilities.DriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.chrono.JapaneseChronology;

public class JSExecutor2 {

    private WebDriver driver;


    @Test
    public void verifyTitle(){
        WebElement title=driver.findElement(By.xpath("//title"));
        System.out.println(title.getText());

        String expected="Practice";
        JavascriptExecutor js=(JavascriptExecutor) driver;

        // executeScript - this method executes javascript code
        // we provide js code as a string
        // js.executeScript returns Object -- We need to cast to get the string
        // there are two ways for these

       // 1 String actual = (String) js.executeScript("return document.title");
       //2 - upper casting needs to be specified -- down casting does not need casting - it happens automatically
        String actual=js.executeScript("return document.title").toString();

        Assert.assertEquals(actual,expected);

    }

    @Test
    public void clickTest(){
        WebElement link = driver.findElement(By.linkText("Multiple Buttons"));
        // link.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // after you can list webelements that will be used
        // as part of your javascript code
        // it's varargs, so you can list 0+
        // arguments - listed after
        // use index to get specific webelement
        // WebElement arguments = {element, link, link2}
        // from left - to right
        js.executeScript("arguments[0].click()", link);

        BrowersUtils.wait(2);

        WebElement button6=driver.findElement(By.id("disappearing_button"));

        // [0] because it is the first WebElement after comma
        // [0] is related to after comma in our code
        js.executeScript("arguments[0].click()", button6);

        BrowersUtils.wait(2);

        WebElement result=driver.findElement(By.id("result"));

        Assert.assertEquals(result.getText(), "Now it's gone!");
    }


    @Test
    public void textInputText(){
        driver.findElement(By.linkText("Form Authentication")).click();

        BrowersUtils.wait(3);

        WebElement username=driver.findElement(By.name("username"));
        WebElement password=driver.findElement(By.name("password"));
        WebElement loginbtn=driver.findElement(By.id("wooden_spoon"));

        JavascriptExecutor js=(JavascriptExecutor) driver;

        // to get text from input box - read attribute "value"
        // to enter text -- set attribute "value"

        js.executeScript("arguments[0].setAttribute('value','tomsmith')",username);
        js.executeScript("arguments[0].setAttribute('value','SuperSecretPassword')",password);
        js.executeScript("arguments[0].click()",loginbtn);

        BrowersUtils.wait(4);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String subheader = js.executeScript("return document.getElementsByClassName('subheader')[0].textContent").toString();

        Assert.assertEquals(subheader,expected);

    }

    @Test
    public void scrollToElement(){
        BrowersUtils.wait(5);

        // href = link ,URL
        WebElement link=driver.findElement(By.linkText("Cybertek School"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        // scrollIntoView -- it goes to the WebElement
        js.executeScript("arguments[0].scrollIntoView(true)",link);
        BrowersUtils.wait(5);

    }

    @Test
    public void scrollTest(){
        driver.navigate().to("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        for(int i=0;i<15;i++){
            js.executeScript("window.scrollBy(0,1000)");
            BrowersUtils.wait(1);
        }

    }

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createADriver("chrome");
        driver. get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }



}

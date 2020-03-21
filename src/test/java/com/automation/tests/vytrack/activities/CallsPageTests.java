package com.automation.tests.vytrack.activities;

import com.automation.tests.day5.BrowersUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
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

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CallsPageTests {
    private WebDriver driver;
    private String username="storemanager85";
    private String password="UserUser123";
    private By userNameBy=By.id("prependedInput");
    private By passwordBy=By.id("prependedInput2");
    private Actions actions;
    private By activitiesBy=By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By logCallBtnBy=By.cssSelector("a[title='Log call']");
    private By calendarButtonBy=By.cssSelector("a[title='Create Calendar event']");
    // # refers the id as cssSelector
    private By currentUserBy=By.cssSelector("#user-menu >a");
    private By ownerBy=By.id("s2id_oro_calendar_event_form_calendar");
    private By titleBy=By.cssSelector("[name='oro_calendar_event_form[title]']");
    private By startDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid']");
    private By startTimeBy = By.cssSelector("[id*='time_selector_oro_calendar_event_form_start-uid']");

    @Test
    public void verifyLogButton(){
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowersUtils.wait(2);
        driver.findElement(By.linkText("Calls")).click();
        BrowersUtils.wait(5);
        Assert.assertTrue(driver.findElement(logCallBtnBy).isDisplayed());


    }

    @Test
    public void CalendarButton(){
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowersUtils.wait(2);

        driver.findElement(By.linkText("Calendar Events")).click();
        BrowersUtils.wait(5);
        Assert.assertTrue(driver.findElement(calendarButtonBy).isDisplayed());
    }

    @Test(description = "Default options")
    public void verifyDefaultValues(){

        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowersUtils.wait(2);
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowersUtils.wait(3);
        driver.findElement(calendarButtonBy).click();
        BrowersUtils.wait(4);

        // Default owner name should be current user
        String currentUserName=driver.findElement(currentUserBy).getText().trim();
        String defaultOwnerName=driver.findElement(ownerBy).getText().trim();
        Assert.assertEquals(currentUserName,defaultOwnerName);

        WebElement title=driver.findElement(titleBy);
        Assert.assertTrue(title.getAttribute("value").isEmpty());

        // Default start date should be current date
        String expectedDate= LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        String actualDate=driver.findElement(startDateBy).getAttribute("value");
        Assert.assertEquals(expectedDate,actualDate);

        // We are getting current time from already existed Java package
        String expectedTime=LocalTime.now(ZoneId.of("GMT-7")).format(DateTimeFormatter.ofPattern("h:m a"));
        String actualTime=driver.findElement(startTimeBy).getAttribute("value");

        Assert.assertEquals(expectedTime,actualTime);

    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get("https://app.vytrack.com/user/login");
        driver.manage().window().maximize();
        actions=new Actions(driver);

        BrowersUtils.wait(3);

        driver.findElement(userNameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);

        BrowersUtils.wait(5);

//        actions.moveToElement(driver.findElement(activitiesBy)).perform();
//        BrowersUtils.wait(2);
//        driver.findElement(By.linkText("Calls")).click();
//        BrowersUtils.wait(5);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}

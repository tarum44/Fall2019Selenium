package com.automation.tests.vytrack;

import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


// Test base is class and a blueprint for all test classes

public abstract class TestBase {
    // will be visible in the subclass, regardless on subclass location (same package or no)
    protected WebDriverWait wait;
    protected Actions actions;


    // when we use singleton webdriver (or static webdriver), it only use the same webdriver
    // instead of opening a new webdriver each time
    @BeforeMethod
    public void setup(){
        String URL= ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 15);
        actions=new Actions(Driver.getDriver());
    }

    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
    }


}

package com.automation.tests.practice;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class March22 {

    @Test
    public void test(){
        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");


        // tr -- table row
        // td -- table data -- column
        // th -- table header

        // table[1] --get the first table
        // table[1]//tr -- get all rows from first table
        // table[1]//tbody//tr -- get all rows from the first table excluding table header
        // table//tbody//td[1] -- get first column
        // table//tbody//tr[1] -- get first row
        // table//tbody//tr[2]//td[1] -- get data from second row, first column
        // table// th// -- get all columns names (header)
        // table//tbody//td[last()] -- get last column
        // table//tbody//tr[last()] -- get last raw

        List<WebElement> lastNames=driver.findElements(By.xpath("//table[1]//tbody//td[1]"));

        for(int i=0;i<lastNames.size()-1;i++){
            String value=lastNames.get(i).getText();
            String nextValue=lastNames.get(i+1).getText();

            //if difference is negative - order value is before nextValue in alphabetic order
            //if difference is positive - order value is after nextValue in alphabetic order
            //if difference is 0 - value and nextValue are equals

            System.out.println(value.compareTo(nextValue));
            Assert.assertTrue(value.compareTo(nextValue) <= 0);
            /*
     *  This method is coming from Comparable interface.
     *  If you want ot be able to sort collection of some class
     *  you need to implement this interface
     *  and override compareTo method
     *
            "a".compareTo("b") = -1
            61 - 62 = -1
            a is before b
            "a".compareTo("a")
            61 - 61 = 0
            0 means 2 strings are equals
                    *
     */
        }

        driver.quit();
    }
}

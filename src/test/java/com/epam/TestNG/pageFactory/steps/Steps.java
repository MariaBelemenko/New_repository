package com.epam.TestNG.pageFactory.steps;

import com.epam.TestNG.customAnnotation.ClassName;
import com.epam.TestNG.pageFactory.pageObjects.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Mariya_Belemenko on 6/23/2016.
 */
public class Steps {
    private final static String QUERY = "cheese";
    private final static String TITLE = "Google";
    private WebDriver driver;

    @BeforeMethod
    public void init() {
        driver = new FirefoxDriver();
        driver.get("http://www.google.com");
    }

    @ClassName
    @Test
    public void doSearch() {
        PageObject page = new PageObject(driver);
        page.editSearch(QUERY);
        page.submitSearch();
        Assert.assertEquals(driver.getTitle(), TITLE);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

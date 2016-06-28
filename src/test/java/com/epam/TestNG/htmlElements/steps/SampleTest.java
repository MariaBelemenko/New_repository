package com.epam.TestNG.htmlElements.steps;

import com.epam.TestNG.htmlElements.pageObjects.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Mariya_Belemenko on 6/26/2016.
 */
public class SampleTest {

    private WebDriver driver = new FirefoxDriver();
    private final String SEARCH_QUERY = "cheese";
    private final String URL = "http://google.com";

    @BeforeMethod
    public void loadPage() {
        driver.get(URL);
    }

    @Test
    public void executeLogic() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.search(SEARCH_QUERY);
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

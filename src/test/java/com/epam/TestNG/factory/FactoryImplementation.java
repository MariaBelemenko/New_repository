package com.epam.TestNG.factory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * Created by Mariya_Belemenko on 6/22/2016.
 */
public class FactoryImplementation {
    private WebDriverCreator creator = new ChromeDriverCreator();
    private WebDriver driver = creator.createWebDriver();

    @Test
    public void testGithub() {
        driver.get("http://www.github.com/");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

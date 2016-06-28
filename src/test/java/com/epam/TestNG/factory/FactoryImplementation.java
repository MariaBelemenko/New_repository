package com.epam.TestNG.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * Created by Mariya_Belemenko on 6/22/2016.
 */
public class FactoryImplementation {
    private WebDriverCreator creator = new ChromeDriverCreator();
    private WebDriver driver = creator.createWebDriver();
    private static final Logger LOG = LogManager.getLogger(FactoryImplementation.class.getName());

    @Test
    public void testGithub() {
        LOG.info("Starting browser");
        driver.get("http://www.github.com/");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            LOG.info("Stopping browser");
            driver.quit();
        }
    }
}

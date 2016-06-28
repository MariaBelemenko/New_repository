package com.epam.TestNG.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Mariya_Belemenko on 6/22/2016.
 */
public class FirefoxDriverCreator extends WebDriverCreator {

    private static final Logger LOG = LogManager.getLogger(FirefoxDriverCreator.class.getName());

    @Override
    public synchronized WebDriver createWebDriver() {
        WebDriver driver = new FirefoxDriver();
        LOG.info("FF driver is returning");
        return driver;
    }
}

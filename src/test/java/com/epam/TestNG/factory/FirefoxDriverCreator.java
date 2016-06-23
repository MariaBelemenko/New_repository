package com.epam.TestNG.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Mariya_Belemenko on 6/22/2016.
 */
public class FirefoxDriverCreator extends WebDriverCreator {

    @Override
    public synchronized WebDriver createWebDriver() {
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
}

package com.epam.TestNG.factory;

import org.openqa.selenium.WebDriver;

/**
 * Created by Mariya_Belemenko on 6/22/2016.
 */
public abstract class WebDriverCreator {

    protected WebDriver driver;
    protected abstract WebDriver createWebDriver();
}

package com.epam.TestNG.singltone;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Mariya_Belemenko on 6/22/2016.
 */
public class FirefoxDriverSingltone {
    private static WebDriver instance;

    private FirefoxDriverSingltone() {

    }

    public static WebDriver getWebDriver() {
        if (instance == null) {
            synchronized (FirefoxDriverSingltone.class) {
                if (instance == null) {
                    instance = new FirefoxDriver();
                }
            }
        }
        return instance;
    }
}

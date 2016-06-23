package com.epam.TestNG.singltone;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Mariya_Belemenko on 6/22/2016.
 */
public class ChromeDriverSingltone {
    private static WebDriver instance;

    private ChromeDriverSingltone() {

    }

    public static WebDriver getWebDriver() {
        if (instance == null) {
            synchronized (ChromeDriverSingltone.class) {
                if (instance == null) {
                    instance = new ChromeDriver();
                }
            }
        }
        return instance;
    }
}

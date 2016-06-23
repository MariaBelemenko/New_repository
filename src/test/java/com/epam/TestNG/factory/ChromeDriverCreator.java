package com.epam.TestNG.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;
import java.io.IOException;

/**
 * Created by Mariya_Belemenko on 6/22/2016.
 */
public class ChromeDriverCreator extends WebDriverCreator {
    public static final String PATH_TO_CHROMEDRIVER = "c:\\Users\\Mariya_Belemenko\\drivers\\chromedriver.exe";

    @Override
    public synchronized WebDriver createWebDriver() {
        ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(
                new File(PATH_TO_CHROMEDRIVER)).build();
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = new ChromeDriver(service);
       /* System.setProperty("Path to ChromeDriver", PATH_TO_CHROMEDRIVER);
        WebDriver driver = new ChromeDriver();*/
        return driver;
    }
}

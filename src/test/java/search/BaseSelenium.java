package search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Mariya_Belemenko on 3/23/2016.
 */
public class BaseSelenium {
    protected static WebDriver driver;
    private final static String BASE_URL = "http://ebay.com";

    public static void startBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    public static void stopBrowser() {
        try {
            driver.quit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            driver = null;
        }
    }
}

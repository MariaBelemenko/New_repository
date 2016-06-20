package search;

import cucumber.api.java.After;
import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.IOException;

/**
 * Created by Mariya_Belemenko on 4/11/2016.
 */
public class TakingScreenshots extends BaseSelenium {
    @After
    public void takeScreenshotInCaseOfFailure(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            try {
                File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(srcFile, new File("target/screenshots/fail_image.png"));
            } catch (WebDriverException somePlatformsDoesNotSupportScreenshots) {
                System.err.println(somePlatformsDoesNotSupportScreenshots.getMessage());
            }
        }
    }
}

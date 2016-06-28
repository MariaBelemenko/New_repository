package tests;

import com.epam.TestNG.singltone.FirefoxDriverSingltone;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

/**
 * Created by Mariya_Belemenko on 6/21/2016.
 */
public class Listener implements ITestListener {

    protected WebDriver driver = FirefoxDriverSingltone.getWebDriver();
    private static final Logger LOG = LogManager.getLogger(Listener.class.getName());

    public void onTestStart(ITestResult result) {
        LOG.info("On test start");
    }

    public void onTestSuccess(ITestResult result) {
        LOG.info("On test success");
    }

    public void onTestFailure(ITestResult result) {
        LOG.info("After each test method");
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("\\target\\testScreenShot.jpg"));
        } catch (IOException e) {
            LOG.info("IOException occured");
        }
    }

    public void onTestSkipped(ITestResult result) {
        LOG.info("On test skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        LOG.info("On test failed but within success percentage");
    }

    public void onStart(ITestContext context) {
        LOG.info("On start");
    }

    public void onFinish(ITestContext context) {
        LOG.info("On finish");
    }
}

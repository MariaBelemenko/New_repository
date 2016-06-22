package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

/**
 * Created by Mariya_Belemenko on 6/21/2016.
 */
public class Listener implements ITestListener {
    protected WebDriver driver = new FirefoxDriver();

    public void onTestStart(ITestResult result) {
        System.out.println("On test start");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("On test success");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("After each test method");
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("\\target\\testScreenShot.jpg"));
        } catch (IOException e) {
            System.out.println("IOException occured");
        }
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("On test skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("On test failed but within success percentage");
    }

    public void onStart(ITestContext context) {
        System.out.println("On start");
    }

    public void onFinish(ITestContext context) {
        System.out.println("On finish");
    }
}

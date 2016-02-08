package com.thomsonreuters.pageobjects.pages.fastDraft;

import com.thomsonreuters.driver.framework.AbstractPage;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class FormEPage extends AbstractPage {

    private static final String SIGN_ON_BUTTON_LOCATOR = "//*[@id='co_form_e_signon' and @value='Sign On']";
    private static final String LOG_IN_AS_SINGLE_USER_BUTTON_LOCATOR = "//*[@id='co_form_e_signon' and @value='Log in as single user']";

    private CommonMethods comMethods = new CommonMethods();

    public WebElement startHereFormE() {
        return comMethods.waitForElementToBeVisible(By.xpath("//*[@id='co_form_e_submit' and @value='Start here']"), 10000);
    }

    public WebElement uploadFormE() {
        return comMethods.waitForElementToBeVisible(By.xpath("//*[@id='co_form_e_upload' and @value='Upload']"), 10000);
    }

    public WebElement formEUserGuide(String userGuide) {
        return waitForExpectedElement(By.xpath("//a[@href='" + userGuide
                + "' and text()='how to use the Fastdraft Form E generally, click here']"));
    }

    public void checkStartHereButtonWithMessagePresents() {
        WebElement button = null;
        try {
            button = comMethods.waitForElementToBeVisible(By
                    .xpath("//div[@class='pluk-form-e-submit-form' and contains(.,'Create a new Form E')]"
                            + "//*[@id='co_form_e_submit' and @value='Start here']"), 10000);
            button.isDisplayed();
        } catch (NullPointerException e) {
            throw new RuntimeException("Start here button with message absents", e.getCause());
        }
    }

    public void checkUploadButtonWithMessagePresents() {
        WebElement button = null;
        try {
            button = comMethods
                    .waitForElementToBeVisible(
                            By.xpath("//div[@class='pluk-form-e-upload-form' and contains(.,'Upload client changes to an existing Form E')]"
                                    + "//*[@id='co_form_e_upload' and @value='Upload']"), 10000
                    );
            button.isDisplayed();
        } catch (NullPointerException e) {
            throw new RuntimeException("Upload button with message absents", e.getCause());
        }
    }

    public void checkSignOnButtonWithMessagePresents() {
        WebElement button = null;
        try {
            button = findElement(By
                    .xpath("//div[@class='pluk-form-e-widget' and contains(.,'Create a new Form E or upload client changes to an existing Form E') "
                            + "and contains(.,'individual username and password are required')]"
                            + SIGN_ON_BUTTON_LOCATOR));
            button.isDisplayed();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Sign On button with message absents", e.getCause());
        }
    }

    public WebElement signOnButton() {
        return waitForExpectedElement(By.xpath(SIGN_ON_BUTTON_LOCATOR));
    }

    public void checkLogInAsSingleUserButtonWithMessagePresents() {
        WebElement button = null;
        try {
            button = findElement(By
                    .xpath("//div[@class='pluk-form-e-widget' and contains(.,'Create a new Form E or upload client changes to an existing Form E') "
                            + "and contains(.,'individual username and password are required')]"
                            + LOG_IN_AS_SINGLE_USER_BUTTON_LOCATOR));
            button.isDisplayed();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Log in as single user button with message absents", e.getCause());
        }
    }

    public WebElement logInAsSingleUserButton() {
        return waitForExpectedElement(By.xpath(LOG_IN_AS_SINGLE_USER_BUTTON_LOCATOR));
    }
}
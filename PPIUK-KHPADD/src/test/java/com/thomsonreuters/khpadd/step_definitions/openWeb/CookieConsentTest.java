package com.thomsonreuters.khpadd.step_definitions.openWeb;

import com.thomsonreuters.khpadd.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawHomepage;
import com.thomsonreuters.pageobjects.pages.login.OnepassLogin;
import com.thomsonreuters.pageobjects.pages.onePass.OnePassLogoutPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CookieConsentTest extends BaseStepDef {

    private PracticalLawHomepage plcHomePage = new PracticalLawHomepage();
    private WLNHeader wlnHeader = new WLNHeader();
    private OnepassLogin onepassLogin = new OnepassLogin();
    private PageActions pageActions = new PageActions();
    private WLNHeader header = new WLNHeader();
    private OnePassLogoutPage onePassLogoutPage = new OnePassLogoutPage();

    @When("^the user '(is|is not)' presented with the cookie consent message$")
    public void theUserIsPresentedWithTheCookieConsentMessage(String arg1) throws Throwable {
        if (arg1.equalsIgnoreCase("is")) {
            plcHomePage.cookieConsentMessage().isDisplayed();
        } else if (arg1.equalsIgnoreCase("is not")) {
            boolean cookieMessageDisplayed = true;
            try {
                plcHomePage.cookieConsentMessage().isDisplayed();
            } catch (Exception e) {
                cookieMessageDisplayed = false;
            }
            assertFalse(cookieMessageDisplayed);
        }
    }

    @When("^the user clicks on Sign On link on the header$")
    public void theUserClicksOnSignOnLinkOnTheHeader() throws Throwable {
        wlnHeader.signInLink().click();
        onepassLogin.waitForPageToLoad();
    }

    @When("^the user clicks on the \"(.*?)\" link on the cookie consent message$")
    public void theUserClicksOnTheLinkOnTheCookieConsentMessage(String arg1) throws Throwable {
        plcHomePage.cookieConsentLink(arg1).click();
    }

    @Then("^user sign out$")
    public void userSignOut() throws Throwable {
        pageActions.mouseOver(header.usernameIcon());
        header.signOutSubLink().click();
        header.waitForPageToLoadAndJQueryProcessing();
        onePassLogoutPage.signOffPageSignOnButton().click();
    }

    @When("^the user clicks on close button on the cookie consent message$")
    public void theUserClicksOnCloseButtonOnTheCookieConsentMessage() throws Throwable {
        plcHomePage.closeCookieConsentMessage();
    }

}

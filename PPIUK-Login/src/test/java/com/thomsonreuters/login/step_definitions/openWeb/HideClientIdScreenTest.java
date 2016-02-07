package com.thomsonreuters.login.step_definitions.openWeb;

import com.thomsonreuters.login.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.WelcomePage;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawHomepage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HideClientIdScreenTest extends BaseStepDef {

    private WLNHeader wlnHeader = new WLNHeader();
    private PracticalLawHomepage practicalLawHomepage = new PracticalLawHomepage();
    private WelcomePage welcomePage = new WelcomePage();

    @When("^the user clicks Log in button$")
    public void theUserClicksLogInButton() throws Throwable {
        wlnHeader.signInLink().click();
    }

    @Then("^it gets redirected to the home page$")
    public void itGetsRedirectedToTheHomePage() throws Throwable {
        assertTrue("Home page not displayed..!", practicalLawHomepage.browseHeadingTitle().isDisplayed());
    }

    @Then("^he is not prompted to enter its Client ID$")
    public void heIsNotPromptedToEnterItsClientID() throws Throwable {
        boolean isClientIDScreenVisible = true;
        try {
            welcomePage.clientID();
        } catch (NoSuchElementException | TimeoutException nse) {
            isClientIDScreenVisible = false;
        }
        assertFalse("ClienID screen is visible for user", isClientIDScreenVisible);
    }

}

package com.thomsonreuters.login.step_definitions.timeout;

import com.thomsonreuters.login.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawHomepage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AbilityToContinueSessionFromTimeOutScreenTest extends BaseStepDef {

    private PracticalLawHomepage practicalLawHomepage = new PracticalLawHomepage();

    private String expectedPageUrl;
    private String expectedPageTitle;

    @When("^he sees the timed out pop up screen$")
    public void heSeesTheTimedOutPopUpScreen() throws Throwable {
        expectedPageTitle = practicalLawHomepage.getPageTitle();
        expectedPageUrl = practicalLawHomepage.getCurrentUrl();
        Thread.sleep(70000);
        assertTrue("Session time out pop up is not visible", practicalLawHomepage.isTimeoutPopUpPresent(50));
    }

    @When("^he clicks on the continue session button$")
    public void heClicksOnTheContinueSessionButton() throws Throwable {
        practicalLawHomepage.continueSessionButton().click();
    }

    @Then("^the pop up screen dissappears$")
    public void thePopUpScreenDissappears() throws Throwable {
        assertFalse("Session time out pop up is visible", practicalLawHomepage.isTimeoutPopUpPresent(30));
    }

    @Then("^the user is redirected to the page that he was visiting$")
    public void theUserIsRedirectedToThePageThatHeWasVisiting() throws Throwable {
        String currentPageTitle = practicalLawHomepage.getPageTitle();
        String currentPageUrl = practicalLawHomepage.getCurrentUrl();
        assertTrue("User was redirected to another page after continue session",
                expectedPageTitle.equals(currentPageTitle) && expectedPageUrl.equals(currentPageUrl));
    }

}

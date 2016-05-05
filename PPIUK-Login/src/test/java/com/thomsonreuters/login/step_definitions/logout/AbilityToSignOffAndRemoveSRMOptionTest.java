package com.thomsonreuters.login.step_definitions.logout;

import com.thomsonreuters.login.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.onePass.OnePassLogoutPage;
import com.thomsonreuters.pageobjects.pages.login.OnepassLogin;
import com.thomsonreuters.pageobjects.utils.CobaltUser;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class AbilityToSignOffAndRemoveSRMOptionTest extends BaseStepDef {

    private WLNHeader wlnHeader = new WLNHeader();
    private OnePassLogoutPage onePassLogoutPage = new OnePassLogoutPage();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private OnepassLogin onepassLoginPage = new OnepassLogin();
    private String baseUrl = System.getProperty("base.url");

    @When("^this logged in user clicks on Sign off$")
    public void thisLoggedInUserClicksOnSignOff() throws Throwable {
        /** TODO: this is a workaround to click sign off twice before 'Return to Sign In' Link appears it is by design at the moment
        confirmed by Robert Foster and Jacqueline Auma */
        wlnHeader.signOff();
        wlnHeader.waitForPageToLoad();
        onePassLogoutPage.signOffPageSignOnButton().click();
        onePassLogoutPage.waitForPageToLoad();
        wlnHeader.signOff();
        wlnHeader.waitForPageToLoad();
    }

    @When("^he is redirected to a log out confirmation page$")
    public void heIsRedirectedToALogOutConfirmationPage() throws Throwable {
        assertTrue("User was not redirected to log out page", wlnHeader.getPageTitle().contains("Sign Off - Practical Law"));
    }

    @Then("^user selects the option to forget the remember me cookie$")
    public void userSelectsTheOptionToForgetTheRememberMeCookie() throws Throwable {
        onePassLogoutPage.signInWithDifferentAccountLink().click();
        onePassLogoutPage.waitForPageToLoad();
        currentUser = new CobaltUser();
    }

    @Then("^the next time that he tries to connect to PL\\+$")
    public void theNextTimeThatHeTriesToConnectToPL() throws Throwable {
        navigationCobalt.navigateToPLUKPlus();
        navigationCobalt.waitForPageToLoad();
    }

    @Then("^he should be logged out from system$")
    public void heWillBePromptedToEnterHisUsernameAndPasswordAgain() throws Throwable {
    /** The commented out code should be updated and used in case Open WEb will be turned OFF on some environment */
     /*   if (baseUrl.equals("hotprod")) {
        	assertTrue("User was not logged out", onepassLoginPage.updateExistingOnePassProfileLink().isDisplayed());
        } else { */
        	assertTrue("User was not logged out", wlnHeader.isSignInLinkPresent());
     //   }        
    }

}

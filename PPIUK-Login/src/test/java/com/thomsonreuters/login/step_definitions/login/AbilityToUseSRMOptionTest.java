package com.thomsonreuters.login.step_definitions.login;

import com.thomsonreuters.login.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawHomepage;
import com.thomsonreuters.pageobjects.pages.login.OnepassLogin;
import com.thomsonreuters.pageobjects.pages.onePass.OnePassLogoutPage;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertFalse;

public class AbilityToUseSRMOptionTest extends BaseStepDef {

    private OnePassLogoutPage onePassLogoutPage = new OnePassLogoutPage();
    private WLNHeader wlnHeader = new WLNHeader();
    private OnepassLogin onepassLogin = new OnepassLogin();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private PracticalLawHomepage practicalLawHomepage = new PracticalLawHomepage();

    @Then("^he clicks the sign in button on the log out page$")
    public void heClicksTheSignInButtonOnTheLogOutPage() throws Throwable {
        onePassLogoutPage.signOffPageSignOnButton().click();
    }

    @Then("^he will be automatically authenticated$")
    public void heWillBeAutomaticallyAuthenticated() throws Throwable {
        assertFalse("User is not logged in", wlnHeader.isSignInLinkPresent());
    }

    @Then("^he will not see the Log in page$")
    public void heWillNotSeeTheLogInPage() throws Throwable {
        String ONEPASS_LOGIN_PAGE_TITLE = "PLC UK Signon";
        assertFalse("User is able to see login page", onepassLogin.getPageTitle().contains(ONEPASS_LOGIN_PAGE_TITLE));
    }

    @Then("^he tries to access PL\\+$")
    public void heTriesToAccessPL() throws Throwable {
        navigationCobalt.navigateToPLUKPlus();
        practicalLawHomepage.waitForPageToLoad();
    }

}

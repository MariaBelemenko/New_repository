package com.thomsonreuters.smoke.step_definitions;

import com.thomsonreuters.pageobjects.common.ExcelFileReader;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawHomepage;
import com.thomsonreuters.pageobjects.pages.login.OnepassLogin;
import com.thomsonreuters.pageobjects.pages.onePass.OnePassLogoutPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.DocumentRightPanelPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.utils.CobaltUser;
import com.thomsonreuters.pageobjects.utils.OnepassLoginUtils;
import cucumber.api.Transpose;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProdLoginTest extends BaseStepDef {

    private KHResourcePage resourcePage = new KHResourcePage();
    private WLNHeader header = new WLNHeader();
    private DocumentRightPanelPage rightPanelPage = new DocumentRightPanelPage();
    private OnepassLoginUtils onePassLoginUtils = new OnepassLoginUtils();
    private OnepassLogin onePassLogin = new OnepassLogin();
    private PracticalLawHomepage practicalLawHomepage = new PracticalLawHomepage();
    private OnePassLogoutPage onePassLogoutPage = new OnePassLogoutPage();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();

    @Then("^the user is navigated to the logged in view of the PL\\+ homepage$")
    public void theUserIsNavigatedToTheLoggedInViewOfThePLHomepage() throws Throwable {
        assertThat(header.favouritesLink().isDisplayed(), Is.is(true));
        assertThat(header.foldersLink().isDisplayed(), Is.is(true));
        assertThat(header.historyLink().isDisplayed(), Is.is(true));
        assertThat(resourcePage.waitAndFindElement(By.linkText("Employment")).isDisplayed(), Is.is(true));
    }

    @Then("^the user is navigated to the logged in view of the document$")
    public void theUserIsNavigatedToTheLoggedInViewOfTheDocument() throws Throwable {
        try {
            assertThat("User is not logged in and hence cannot view the document", resourcePage.signInLink().isDisplayed(), Is.is(false));
            assertThat("User is not logged in and hence cannot view the document", resourcePage.requestAFreeTrial().isDisplayed(), Is.is(false));
        } catch (TimeoutException npe) {
            LOG.debug("User is logged in and viewing the document");
        }
        assertThat(rightPanelPage.viewResourceHistoryLink().isDisplayed(), Is.is(true));
    }

    @Then("^the user is provided with an option to sign-in or register for free trial$")
    public void theUserIsProvidedWithAnOptionToSignInOrRegisterForFreeTrial() throws Throwable {
        assertThat("Sign In Link is not displayed on the document body", resourcePage.signInLink().isDisplayed(), Is.is(true));
        assertThat("Request a free trial is not displayed on the document body", resourcePage.requestAFreeTrial().isDisplayed(), Is.is(true));
    }

    @When("^a PPI user enter its username and password$")
    public void aPPIUserEnterItsUsernameAndPassword(@Transpose List<CobaltUser> plPlusUserList) throws Throwable {
        CobaltUser plPlusUser = CobaltUser.updateMissingFields(plPlusUserList.get(0));
        onePassLoginUtils.enterUserNameAndPassword(plPlusUser.getUserName(), ExcelFileReader.getCobaltPassword(plPlusUser.getUserName()));
        currentUser = plPlusUser;
    }

    @When("^user selects Save my Username and Password checkbox$")
    public void userSelectsSaveMyUsernameAndPasswordCheckbox() throws Throwable {
        onePassLoginUtils.selectSaveMyUsernameAndPasswordCheckBox();
        assertFalse("Save my username checkbox was not unchecked", onePassLogin.saveMyUsernameCheckBox().isSelected());
    }

    @When("^clicks on Sign in$")
    public void clicksOnSignIn() throws Throwable {
        onePassLogin.signOnButton().click();
        practicalLawHomepage.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^user logs out$")
    public void userLogsOut() throws Throwable {
        header.signOff();
        onePassLogin.waitForPageToLoad();
    }

    @Then("^user tries to log in again$")
    public void userTriesToLogInAgain() throws Throwable {
        onePassLogoutPage.signOffPageSignOnButton().click();
        onePassLogin.waitForPageToLoad();
    }

    @Then("^he will see the username box in the log in page populated with his username$")
    public void heWillSeeTheUsernameBoxInTheLogInPagePopulatedWithHisUsername() throws Throwable {
        assertTrue("Username field is not correct", onePassLogin.getTextFromInputOrTextarea(onePassLogin.usernameTextField()).equals(onePassLoginUtils.getUserName()));
    }

    @Then("^his password will be populated in the password box$")
    public void hisPasswordWillBePopulatedInThePasswordBox() throws Throwable {
        assertFalse("Password field is empty", onePassLogin.getTextFromInputOrTextarea(onePassLogin.passwordTextField()).isEmpty());
    }

    @Then("^his password will not be readable in the screen and only asterisks will be visible$")
    public void hisPasswordWillNotBeReadableInTheScreenAndOnlyAsterisksWillBeVisible() throws Throwable {
        assertTrue("Password field is not secure", onePassLogin.getTextFromInputOrTextarea(onePassLogin.passwordTextField()).equals("____SAVED____"));
    }

    @When("^he selects the option to be remembered on this computer$")
    public void heSelectsTheOptionToBeRememberedOnThisComputer() throws Throwable {
        onePassLogin.rememeberMeCheckBox().click();
    }

    @Then("^he activates the super remember me cookie$")
    public void heActivatesTheSuperRememberMeCookie() throws Throwable {
        onePassLogin.signOnButton().click();
        practicalLawHomepage.waitForPageToLoad();
    }

    @Then("^when the user logs out$")
    public void whenTheUserLogsOut() throws Throwable {
        header.signOff();
        currentUser = new CobaltUser();
        onePassLogin.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^he tries to access PL\\+$")
    public void heTriesToAccessPL() throws Throwable {
        navigationCobalt.navigateToPLUKPlus();
        practicalLawHomepage.waitForPageToLoad();
    }

    @Then("^he will be automatically authenticated$")
    public void heWillBeAutomaticallyAuthenticated() throws Throwable {
        assertFalse("User is not logged in", header.isSignInLinkPresent());
    }

    @Then("^he will not see the Log in page$")
    public void heWillNotSeeTheLogInPage() throws Throwable {
        String ONEPASS_LOGIN_PAGE_TITLE = "PLC UK Signon";
        assertFalse("User is able to see login page", onePassLogin.getPageTitle().contains(ONEPASS_LOGIN_PAGE_TITLE));
    }

}

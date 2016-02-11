package com.thomsonreuters.khpadd.step_definitions.openWeb;

import com.thomsonreuters.khpadd.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.login.OnepassLogin;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.DocumentDeliveryOptionsPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.DocumentRightPanelPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.utils.CobaltUser;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;

public class KhpaddOpenWebTest extends BaseStepDef {

    private WLNHeader header = new WLNHeader();
    private KHResourcePage resourcePage = new KHResourcePage();
    private DocumentDeliveryOptionsPage documentDeliveryOptionsPage = new DocumentDeliveryOptionsPage();
    private OnepassLogin onepassLogin = new OnepassLogin();
    private DocumentRightPanelPage rightPanelPage = new DocumentRightPanelPage();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();

    @Then("^the user is navigated to the PL\\+ homepage anonymous view$")
    public void theUserIsNavigatedToThePLHomepageAnonymousView() throws Throwable {
        try {
            header.favouritesLink().isDisplayed();
            header.foldersLink().isDisplayed();
            header.historyLink().isDisplayed();
        } catch (Exception e) {
            LOG.debug("User is logged in anonymous mode");
        }
        resourcePage.waitAndFindElement(By.linkText("Arbitration")).isDisplayed();
    }

    @Then("^the user is provided with an option to sign-in or register for free trial$")
    public void theUserIsProvidedWithAnOptionToSignInOrRegisterForFreeTrial() throws Throwable {
        assertThat("Sign In Link is not displayed on the document body", resourcePage.signInLink().isDisplayed(), Is.is(true));
        assertThat("Request a free trial is not displayed on the document body", resourcePage.requestAFreeTrial().isDisplayed(), Is.is(true));
    }

    @Then("^he does not see in the document page any link related to delivery options \\(email, download, print\\)$")
    public void heDoesNotSeeInTheDocumentPageAnyLinkRelatedToDeliveryOptionsEmailDownloadPrint() throws Throwable {
        assertFalse("Delivery options are visible for user", documentDeliveryOptionsPage.isDownloadPresent() & documentDeliveryOptionsPage.isPrintPresent() & documentDeliveryOptionsPage.isEmailPresent());
    }

    @Then("^Sign On link is not shown to user$")
    public void signOnLinkIsNotShownToUser() throws Throwable {
        assertFalse("Sign On link is visible", header.isSignInLinkPresent());
    }

    @Then("^the user is navigated to the logged in view of the PL\\+ homepage$")
    public void theUserIsNavigatedToTheLoggedInViewOfThePLHomepage() throws Throwable {
        assertThat(header.favouritesLink().isDisplayed(), Is.is(true));
        assertThat(header.foldersLink().isDisplayed(), Is.is(true));
        assertThat(header.historyLink().isDisplayed(), Is.is(true));
        assertThat(resourcePage.waitAndFindElement(By.linkText("Employment")).isDisplayed(), Is.is(true));
    }

    @Then("^when the user logs out$")
    public void whenTheUserLogsOut() throws Throwable {
        header.signOff();
        currentUser = new CobaltUser();
        onepassLogin.waitForPageToLoadAndJQueryProcessing();
    }

    @When("^the user clicks on the Sign in link on the document$")
    public void theUserClicksOnTheSignInLinkOnTheDocument() throws Throwable {
        resourcePage.signInLink().click();
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

    @When("^user navigates directly to document with plcref \"(.*?)\"$")
    public void userNavigatesDirectlyToDocumentWithPlcref(String plcRef) throws Throwable {
        navigationCobalt.navigateToWLNSpecificResourcePage("/" + plcRef);
        resourcePage.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^the user is provided with an option to Upgrade or register for free access$")
    public void theUserIsProvidedWithAnOptionToUpgradeOrRegisterForFreeAccess() throws Throwable {
        assertThat("Upgrade Text is not displayed", resourcePage.upgradeText().isDisplayed(), Is.is(true));
        assertThat("Register for free access option is not provided", resourcePage.registerForFreeAccess().isDisplayed(), Is.is(true));
    }

}

package com.thomsonreuters.login.step_definitions.document;

import com.thomsonreuters.login.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.ExcelFileReader;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawHomepage;
import com.thomsonreuters.pageobjects.pages.login.OnepassLogin;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.documentNavigation.AnnotationPage;
import com.thomsonreuters.pageobjects.utils.CobaltUser;
import com.thomsonreuters.pageobjects.utils.OnepassLoginUtils;
import cucumber.api.Transpose;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginDocumentTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private AnnotationPage annotationPage = new AnnotationPage();
    private WLNHeader wlnHeader = new WLNHeader();
    private OnepassLoginUtils onepassLoginUtils = new OnepassLoginUtils();
    private OnepassLogin onepassLogin = new OnepassLogin();
    private PracticalLawHomepage practicalLawHomepage = new PracticalLawHomepage();

    private String expectedPageTitle;

    @Then("^he does not see in the document page any link related to annotations$")
    public void heDoesNotSeeInTheDocumentPageAnyLinkRelatedToAnnotations() throws Throwable {
        assertFalse("User is able to use Add to Folder", annotationPage.isAnnotationWidgetsPresent() & annotationPage.isAnnotationIconsPresent());
    }

    @Then("^he is not able to use annotations$")
    public void heIsNotAbleToUseAnnotations() throws Throwable {
        annotationPage.makeTextSelectionToOpenCreateAnnotationLightBox(By.xpath("//h1[contains(@class,'co_title')]"), By.xpath("//div[@class='co_productname']"));
        assertFalse(annotationPage.isCreateAnnotationsWidgetPresent());
    }

    @Given("^a username/password user in the login screen$")
    public void aUsernamePasswordUserInTheLoginScreen(@Transpose List<CobaltUser> plPlusUserList) throws Throwable {
        wlnHeader.signInLink().click();
        CobaltUser plPlusUser = CobaltUser.updateMissingFields(plPlusUserList.get(0));
        plPlusUser.setUserName(!"None".equalsIgnoreCase(System.getProperty("username")) ? System.getProperty("username") : plPlusUser.getUserName());
        onepassLoginUtils.enterUserNameAndPassword(plPlusUser.getUserName(), ExcelFileReader.getCobaltPassword(plPlusUser.getUserName()));
    }

    @When("^he selects the option to be remembered on this computer$")
    public void heSelectsTheOptionToBeRememberedOnThisComputer() throws Throwable {
        onepassLogin.rememeberMeCheckBox().click();
    }

    @Then("^he activates the super remember me cookie$")
    public void heActivatesTheSuperRememberMeCookie() throws Throwable {
        onepassLogin.signOnButton().click();
        practicalLawHomepage.waitForPageToLoad();
    }

    @Then("^when the user logs out$")
    public void whenTheUserLogsOut() throws Throwable {
        wlnHeader.signOff();
        currentUser = new CobaltUser();
        onepassLogin.waitForPageToLoadAndJQueryProcessing();
    }

    @When("^he has a session open and timed out$")
    public void heHasASessionOpenAndTimedOut() throws Throwable {
        expectedPageTitle = navigationCobalt.getPageTitle();
        /** This sleep is needed to emulate user idle within system please do not remove! */
        Thread.sleep(200000);
    }

    @Then("^user gets redirected to the document page that he was visiting and is logged in$")
    public void userGetsRedirectedToTheDocumentPageThatHeWasVisiting() throws Throwable {
        navigationCobalt.waitForPageToLoad();
        String currentPageTitle = navigationCobalt.getPageTitle();
        assertTrue("User was redirected to another page after new session from page was started", expectedPageTitle.equals(currentPageTitle) && !wlnHeader.isSignInLinkPresent());
    }

}

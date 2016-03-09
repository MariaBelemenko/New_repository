package com.thomsonreuters.smoke.step_definitions;

import com.thomsonreuters.pageobjects.pages.ask.AskResourcePage;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.pages.researchBrowse.RBContentTypePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class ProdEmailPrintDownloadTest extends BaseStepDef {

    private HomePage homePage = new HomePage();
    private RBContentTypePage contentTypePage = new RBContentTypePage();
    private AskResourcePage askResourcePage = new AskResourcePage();

    @When("^the user clicks on the resources tab on the home page$")
    public void theUserClicksOnTheResourcesTabOnTheHomePage() throws Throwable {
        homePage.resourcesLink().click();
    }

    @When("^user clicks on the \"(.*?)\" Practice Area Link$")
    public void userClicksOnThePracticeAreaLink(String link) throws Throwable {
        contentTypePage.practiceAreaLink(link.trim()).click();
    }

    @When("^the user clicks '(download|print|email)' widget on the document page$")
    public void theUserClicksWidgetOnTheDocumentPage(String widgetType) throws Throwable {
        switch (widgetType) {
            case "download":
                askResourcePage.downloadWidget().click();
                break;
            case "print":
                askResourcePage.printWidget().click();
                break;
            case "email":
                askResourcePage.emailWidget().click();
                break;
            default:
                break;
        }
    }

    @Then("^the user verifies that '(Download|Email|Print)' Window is displayed$")
    public void theUserVerifiesThatDownloadWindowIsDisplayed(String window) throws Throwable {
        assertThat("The " + window + " This Document window NOT displayed", askResourcePage.overlayHeader().getText(), containsString(window + " This Document"));
    }

    @When("^the user clicks '(Download|Email|Print)' on '(download|email|print)' overlay$")
    public void theUserClicksDownloadOnDownloadOverlay(String button, String overlay) throws Throwable {
        assertThat("The " + button + " Button  is NOT displayed", askResourcePage.overlayClickButton().getAttribute("value"), containsString(button));
        askResourcePage.overlayClickButton().click();
    }

    @Then("^the user verifies that '(Ready For Email|Ready For Download|Preparing For Print|Preparing For Email|Preparing For Download)' is displayed on the overlay$")
    public void theUserVerifiesThatReadyForEmailIsDisplayOnOverlay(String header) throws Throwable {
        if (header.contains("Ready")) {
            assertThat("The " + header + " is NOT displayed", askResourcePage.readyMessageOverlayHeader().getText(), containsString(header));
        } else {
            assertThat("The " + header + " is NOT displayed", askResourcePage.prepareMessageOverlayHeader().getText(), containsString(header));
        }
    }

    @When("^the user clicks download on ready to download overlay$")
    public void theUserClicksDownloadOnReadyToDownloadOverlay() throws Throwable {
        askResourcePage.downloadInReadyForDownloadOverlayButton().click();
    }

}

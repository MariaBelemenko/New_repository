package com.thomsonreuters.ipusers.step_definitions.firmStyle;

import com.thomsonreuters.ipusers.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.FileActions;
import com.thomsonreuters.pageobjects.common.WindowHandler;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.PracticalLawToolsPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import com.thomsonreuters.pageobjects.rest.DeliveryBaseUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BaseFirmStyletBehaviour extends BaseStepDef {

    private StandardDocumentPage standardDocumentPage;
    private WindowHandler windowHandler;
    private FileActions fileActions;
    private PracticalLawToolsPage practicalLawToolsPage;
    private DeliveryBaseUtils deliveryBaseUtils;

    private final static String DOWNLOADED_FILE_PATH = System.getProperty("user.home") + "/Downloads";
    private File downloadedFile = null;

    public BaseFirmStyletBehaviour() {
        standardDocumentPage = new StandardDocumentPage();
        windowHandler = new WindowHandler();
        fileActions = new FileActions();
        practicalLawToolsPage = new PracticalLawToolsPage();
        deliveryBaseUtils = new DeliveryBaseUtils();
    }

    @Then("^the user sees the Firm Style link$")
    public void checkFirmStyleLinkPresent() throws Throwable {
        standardDocumentPage.waitForPageToLoad();
        assertTrue("Open in Firm Style button absents", standardDocumentPage.isFirmStyleButtonPresent());
    }

    @Then("^the user does not see the Firm Style link$")
    public void checkFirmStyleLinkAbsent() throws Throwable {
        standardDocumentPage.waitForPageToLoad();
        assertFalse("Open in Firm Style button presents", standardDocumentPage.isFirmStyleButtonPresent());
    }

    @When("^the user clicks Firm Style link$")
    public void clickFirmStyleLink() throws Throwable {
        standardDocumentPage.firmStyle().click();
        standardDocumentPage.waitForPageToLoad();
    }

    @Then("^Firm Style Tools page is displayed$")
    public void checkToolsPageDisplayed() throws Throwable {
        practicalLawToolsPage.waitForPageToLoad();
        String learnMoreLink = "/About/PracticalLawTools";
        String currentUrl = getDriver().getCurrentUrl();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(currentUrl.contains(learnMoreLink))
                .overridingErrorMessage(
                        "Expected current URL contains link '" + learnMoreLink + "', current is '" + currentUrl + "'")
                .isTrue();
        softly.assertThat(practicalLawToolsPage.isFirmStyleTabActive())
                .overridingErrorMessage("Firmstyle tab is not active").isTrue();
        softly.assertAll();
    }

    @Then("^Firm Style download box appiars$")
    public void checkDownloadboxAppiars() throws Throwable {
        standardDocumentPage.waitForPageToLoad();
        standardDocumentPage.checkDownloadboxAppiars();
        standardDocumentPage.waitForPageToLoad();
    }

    @When("the user clicks Firm Style link and download a document")
    public void clickFirmStyleAndDownloadDocument() throws Throwable {
        downloadFirmStyle();
    }

    @Then("^the file \"([^\"]*)\" should be downloaded to the users machine$")
    public void fileShouldDownloadToTheUsersMachine(String name) throws Throwable {
        assertTrue("File was not downloaded", downloadedFile != null && downloadedFile.exists());
    }

    @Then("^the file \"([^\"]*)\" should be removed$")
    public void deleteDownloadedDocFile(String name) throws Throwable {
        fileActions.deleteFile(downloadedFile);
    }

    @When("the user clicks on FS download link \"([^\"]*)\"")
    public void clickDownloadFSFile(String linkName) throws Throwable {
        standardDocumentPage.downloadFSFile(linkName).click();
    }

    @When("the user clicks on Home page")
    public void clickHomePage() throws Throwable {
        standardDocumentPage.homePage().click();
        standardDocumentPage.waitForPageToLoad();
    }

    private void downloadFirmStyle() {
        downloadedFile = deliveryBaseUtils.downloadFsDocument();
    }

}
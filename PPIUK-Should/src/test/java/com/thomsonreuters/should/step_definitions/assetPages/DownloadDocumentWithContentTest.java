package com.thomsonreuters.should.step_definitions.assetPages;

import com.thomsonreuters.pageobjects.pages.delivery.DownloadOptionsPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.rest.DeliveryBaseUtils;
import com.thomsonreuters.pageobjects.rest.model.request.delivery.initiateDelivery.InitiateDelivery;
import com.thomsonreuters.pageobjects.utils.form.CheckBoxOrRadioButton;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;
import com.thomsonreuters.should.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DownloadDocumentWithContentTest extends BaseStepDef {

    private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();
    private DownloadOptionsPage downloadOptionsDialog = new DownloadOptionsPage();
    private DeliveryBaseUtils deliveryBaseUtils = new DeliveryBaseUtils();
    private AssetPageUtils assetPageUtils = new AssetPageUtils();

    @Then("^the user see Download icon in delivery options in right hand side$")
    public void theUserSeeDownloadIconInDeliveryOptionsInRightHandSide() throws Throwable {
        assertTrue("The user doesn't see the download icon",
                assetDocumentPage.isElementDisplayed(assetDocumentPage.downloadIcon()));
    }

    @When("^the user click on Download icon$")
    public void theUserClickOnDownloadIcon() throws Throwable {
        assetDocumentPage.downloadIcon().click();
    }

    @When("^the user click on the \"(.*?)\" tab$")
    public void theUserClickOnTheTab(String contentToAppendText) throws Throwable {
        assetDocumentPage.contentToAppendTab(contentToAppendText).click();
    }

    @Then("^the user see the \"(.*?)\" check box$")
    public void theUserSeeTheCheckBox(String relatedAssetPageText) throws Throwable {
        assertTrue("The user doesn't see the Content To Append Tub",
                assetDocumentPage.isElementDisplayed(assetDocumentPage.relatedAssetPageCheckBox(relatedAssetPageText)));
    }

    @Then("^the user click on \"(.*?)\" check box$")
    public void theUserClickOnCheckBox(String relatedAssetPageText) throws Throwable {
        assetDocumentPage.relatedAssetPageCheckBox(relatedAssetPageText).click();
    }

    @Then("^document download with content references$")
    public void documentDownloadWithContentReferences() throws Throwable {
        deliveryOptionsSetTableOfContents("selected");
        downloadDocumentInExtension("Pdf");
    }

    @When("^the user sets Table of Contents option to '(selected|unselected)' state$")
    public void deliveryOptionsSetTableOfContents(String state) throws Throwable {
        new CheckBoxOrRadioButton().editValue(assetDocumentPage.inputCheckboxTableOfContent(), state);
    }

    @Then("^download document in \"(.*?)\" extension$")
    public void downloadDocumentInExtension(String extension) throws Throwable {
        selectDocFormatInDeliveryOptionsWindow(extension);
        clickDownloadInDeliveryOptionsWindow();
        assertDocumentReadyToDownload();
        InitiateDelivery.DocFormat docFormat = InitiateDelivery.DocFormat.getFormatIgnoreCase(extension);
        assertTrue("Document not downloaded",
                deliveryBaseUtils.isDocDownloadedAndChecked(docFormat, false));
    }

    @When("^the user selects '(.*)' document format in delivery options window$")
    public void selectDocFormatInDeliveryOptionsWindow(String format) throws Throwable {
        InitiateDelivery.DocFormat docFormat = InitiateDelivery.DocFormat.getFormatIgnoreCase(format);
        assertNotNull("Unknown document format: " + format, docFormat);
        new Select(downloadOptionsDialog.formatDropdown()).selectByValue(docFormat.toString());
    }

    @When("^the user clicks Download button in delivery options window$")
    public void clickDownloadInDeliveryOptionsWindow() throws Throwable {
        downloadOptionsDialog.waitForElementToBeClickable(downloadOptionsDialog.downloadButton());
        downloadOptionsDialog.downloadButton().click();
    }

    @Then("^the downloaded document contain \"(.*?)\" section$")
    public void theDownloadedDocumentContainSection(String contentReferringText) throws Throwable {
        assertTrue("The downloaded pdf document '" + deliveryBaseUtils.getDownloadedDoc().getName() +
                        "' doesn't contain Content reffering section",
                assetPageUtils.isThedownloadedDocumentContainContentRefferingSection(contentReferringText,
                        deliveryBaseUtils.getDownloadedDoc()));
    }

    private void assertDocumentReadyToDownload() {
        assertTrue("Download button absent", downloadOptionsDialog.getDownloadButtonWhenDocReadyToDownload().isDisplayed());
        assertTrue("Document is not ready to download", downloadOptionsDialog.getReadyForDownloadWindow().getText().contains("ready"));
    }

}

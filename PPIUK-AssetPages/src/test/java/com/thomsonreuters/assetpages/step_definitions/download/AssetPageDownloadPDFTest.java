package com.thomsonreuters.assetpages.step_definitions.download;

import com.thomsonreuters.assetpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.WindowHandler;
import com.thomsonreuters.pageobjects.pages.delivery.DownloadOptionsPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.documentNavigation.DocumentDeliveryPage;
import com.thomsonreuters.pageobjects.rest.DeliveryBaseUtils;
import com.thomsonreuters.pageobjects.rest.model.request.delivery.initiateDelivery.InitiateDelivery;
import com.thomsonreuters.pageobjects.utils.form.CheckBoxOrRadioButton;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.File;

import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AssetPageDownloadPDFTest extends BaseStepDef {

    private AssetPageUtils assetPageUtils = new AssetPageUtils();
    private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();
    private WindowHandler windowHandler = new WindowHandler();
    private DocumentDeliveryPage documentDeliveryPage = new DocumentDeliveryPage();
    private DeliveryBaseUtils deliveryBaseUtils = new DeliveryBaseUtils();
    private DownloadOptionsPage downloadOptionsDialog = new DownloadOptionsPage();

    @Then("^the user see Download icon in delivery options in right hand side$")
    public void theUserSeeDownloadIconInDeliveryOptionsInRightHandSide() throws Throwable {
        assertTrue("The user doesn't see the download icon",
                assetDocumentPage.isElementDisplayed(assetDocumentPage.downloadIcon()));
    }

    @When("^the user click on Download icon$")
    public void theUserClickOnDownloadIcon() throws Throwable {
        assetDocumentPage.downloadIcon().click();
    }

    @Then("^the download window opens$")
    public void theDownloadWindowOpens() throws Throwable {
        assertTrue("The user doesn't see the download icon",
                assetDocumentPage.isElementDisplayed(assetDocumentPage.downloadWindow()));
    }

    @Then("^the download window should be absent$")
    public void theDeliveryWindowShouldBeAbsent() throws Throwable {
        assertTrue("The user sees the delivery window", assetDocumentPage.isDeliveryWindowAbsent());
    }

    @Then("^the user see download button$")
    public void theUserSeeDownloadButton() throws Throwable {
        assertTrue("The user doesn't see the download button",
                assetDocumentPage.isElementDisplayed(assetDocumentPage.downloadButton()));
    }

    @When("^the user click on download button$")
    public void theUserClickOnDownloadButton() throws Throwable {
        assetDocumentPage.downloadButton().click();
    }

    @Then("^the user see \"(.*?)\" Ready For Download window$")
    public void theUserSeeReadyForDownloadWindow(String readyForDownloadText) throws Throwable {
        assertTrue("The user doesn't see ready for download window",
                assetDocumentPage.isElementDisplayed(assetDocumentPage.readyForDownloadWindow(readyForDownloadText)));
    }

    @Then("^the user see name of file for download$")
    public void theUserSeeNameOfFileForDownload() throws Throwable {
        assertTrue("The user doesn't see ready for download window", assetPageUtils.isTheUserSeeNameOfFileForDownload());
    }

    @Then("^the user see download button in Ready For Download window$")
    public void theUserSeeDownloadButtonInReadyForDownloadWindow() throws Throwable {
        assetDocumentPage.waitForElementVisible(assetDocumentPage.downloadButtonInReadyForDownloadWindow(), 10);
        assertTrue("The user doesn't see ready for download window",
                assetDocumentPage.isElementDisplayed(assetDocumentPage.downloadButtonInReadyForDownloadWindow()));
    }

    @When("^the user click on download button in Ready For Download window$")
    public void theUserClickOnDownloadButtonInReadyForDownloadWindow() throws Throwable {
        assetDocumentPage.downloadButtonInReadyForDownloadWindow().click();
    }

    @Then("^the user click ok to save document$")
    public void theUserClickOkToSaveDocument() throws Throwable {
        assetPageUtils.clickOkOnDownloadBrowserWindow();
    }

    @Then("^the user click ok browser button to save document$")
    public void theUserClickOkBrowserButtonToSaveDocument() throws Throwable {
        windowHandler.fileDownload(assetDocumentPage.downloadButtonInReadyForDownloadWindow());
    }

    @Then("^the PDF document downloaded$")
    public void thePDFDocumentDownloaded() throws Throwable {
        assertTrue("The pdf document is not downloaded", assetPageUtils.isThePDFDocumentDownloaded());
    }

    @Then("^the downloaded PDF document contain hyperlink to \"(.*?)\" Bailii$")
    public void theDownloadedPDFDocumentContainHyperlinkToBailii(String bailiiLinkText) throws Throwable {
        assertTrue("The downloaded PDF document doesn't contain hyperlink to Bailii",
                assetPageUtils.isTheDownloadedPDFDocumentContainHyperlinkToExternalWebSite(assetDocumentPage
                                .bailiiLink(bailiiLinkText).getAttribute("href"), bailiiLinkText,
                        deliveryBaseUtils.getDownloadedDoc()
                )
        );
    }

    @Then("^the downloaded PDF document contain hyperlink to \"(.*?)\" Westlaw UK$")
    public void theDownloadedPDFDocumentContainHyperlinkToWestlawUK(String wetslawUKLinkText) throws Throwable {
        assertTrue("The downloaded PDF document doesn't contain hyperlink to WestlawUK",
                assetPageUtils.isTheDownloadedPDFDocumentContainHyperlinkToExternalWebSite(assetDocumentPage
                                .westlawUkLink(wetslawUKLinkText).getAttribute("href"), wetslawUKLinkText,
                        deliveryBaseUtils.getDownloadedDoc()
                )
        );
    }

    @Then("^the document is removed$")
    public void theDocumentIsRemoved() throws Throwable {
        assetPageUtils.deleteFile();
    }

    @Then("^the downloaded document does not contain \"(.*?)\" section$")
    public void theDownloadedDocumentDoesNotContainSection(String contentReferringText) throws Throwable {
        assertFalse("The downloaded pdf document '" + deliveryBaseUtils.getDownloadedDoc().getName() +
                        "' doesn't contain Content reffering section",
                assetPageUtils.isThedownloadedDocumentContainContentRefferingSection(contentReferringText,
                        deliveryBaseUtils.getDownloadedDoc())
        );
    }

    @Then("^the user see the \"(.*?)\" tab$")
    public void theUserSeeTheTab(String contentToAppendText) throws Throwable {
        assertTrue("The user doesn't see the Content To Append Tub",
                assetDocumentPage.isElementDisplayed(assetDocumentPage.contentToAppendTab(contentToAppendText)));
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

    @Then("^the downloaded document contain \"(.*?)\" section$")
    public void theDownloadedDocumentContainSection(String contentReferringText) throws Throwable {
        assertTrue("The downloaded pdf document '" + deliveryBaseUtils.getDownloadedDoc().getName() +
                        "' doesn't contain Content reffering section",
                assetPageUtils.isThedownloadedDocumentContainContentRefferingSection(contentReferringText,
                        deliveryBaseUtils.getDownloadedDoc())
        );
    }

    @Then("^the downloaded PDF document contain \"(.*?)\" hyperlink$")
    public void theDownloadedPDFDocumentContainHyperlink(String linkText) throws Throwable {
        assertTrue("The downloaded PDF document doesn't contain hyperlink",
                assetPageUtils.isTheDownloadedPDFDocumentContainHyperlinkToExternalWebSite(assetDocumentPage
                                .linkInAssetPage(linkText).getAttribute("href"), linkText,
                        deliveryBaseUtils.getDownloadedDoc()
                )
        );
    }

    @When("^the hyperlink \"(.*?)\" in downloaded document contain text \"(.*?)\"$")
    public void theHyperlinkInDownloadedDocumentContainText(String linkText, String text) throws Throwable {
        assertTrue("The hyperlink of downloaded document doesn't contain specific parameters",
                assetPageUtils.isTheHyperlinkOfDownloadedDocumentContainSpecificParameters(linkText, text,
                        deliveryBaseUtils.getDownloadedDoc())
        );
    }

    @When("^the hyperlink \"(.*?)\" in downloaded PDF document does not exists$")
    public void checkThatDownloadedDocNotContainsLink(String linkText) throws Throwable {
        File downloadedDocFile = deliveryBaseUtils.getDownloadedDoc();
        String docFileName = downloadedDocFile.getName();
        if (!linkText.isEmpty() && docFileName.toLowerCase().endsWith(".pdf")) {
            assertFalse("The downloaded document '" + docFileName + "' contains link '" + linkText + "'",
                    assetPageUtils.isLinkExistsInThePdfDocument(linkText, downloadedDocFile));
        }
    }

    @Then("^the user sees \"(.*?)\" tab$")
    public void theUserSeesTab(String tabName) throws Throwable {
        assetDocumentPage.waitForPageToLoad();
        assertTrue("The user doesn't see the Content To Append Tab",
                assetDocumentPage.isElementDisplayed(assetDocumentPage.tabInDownloadWindow(tabName)));
    }

    @When("^the user clicks on \"(.*?)\" tab$")
    public void theUserClicksOnTab(String tabName) throws Throwable {
        assetDocumentPage.tabInDownloadWindow(tabName).click();
    }

    @Then("^the user sees dropdown box with the format to download the document$")
    public void theUserSeesDropdownBoxWithTheFormatToDownloadTheDocument() throws Throwable {
        assertTrue("The user doesn't see the Dropdown Box with the format to download the document",
                assetDocumentPage.isElementDisplayed(assetDocumentPage.dropdownBoxWithTheFormatToDownloadTheDocument()));
    }

    @Then("^the user clicks on \"(.*?)\" format$")
    public void theUserClicksOnFormat(String formatName) throws Throwable {
        assetPageUtils.chooseDropdownBox(formatName, assetDocumentPage.dropdownBoxWithTheFormatToDownloadTheDocument());
    }

    @Then("^the document downloaded in \"(.*?)\" format$")
    public void theDocumentDownloadedInFormat(String formatName) throws Throwable {
        assertTrue("The document is not downloaded", assetPageUtils.isTheDocumentDownloadedInFormat(formatName));
    }

    @Then("^the user sees \"(.*?)\" checkbox$")
    public void theUserSeesCheckbox(String checkboxName) throws Throwable {
        assertTrue("The user doesn't see the Dropdown Box with the format to download the document",
                assetDocumentPage.isElementDisplayed(assetDocumentPage.checkboxTableOfContent())
                        && assetDocumentPage.checkboxTableOfContent().getText().equals(checkboxName)
        );
    }

    @Then("^the user select checkbox$")
    public void theUserSelectCheckbox() throws Throwable {
        assetPageUtils.selectCheckbox(assetDocumentPage.inputCheckboxTableOfContent());
    }

    @Then("^downloaded document contain \"(.*?)\" link$")
    public void downloadedDocumentContainLink(String linkText) throws Throwable {
        assertTrue("The downloaded document doesn't contain " + linkText + " link",
                assetPageUtils.isTheDownloadedDocumentContainTableOfContent(linkText, deliveryBaseUtils.getDownloadedDoc()));
    }

    @Then("^downloaded document contains the right number of bullets$")
    public void downloadedDocumentContainsTheRightNumberOfBullets() throws Throwable {
        assertTrue("The downloaded document doesn't contain right number of bullets",
                assetPageUtils.isTheDownloadedDocumentContainRightNumberOfBullets(deliveryBaseUtils.getDownloadedDoc()));
    }

    @Then("^the downloaded document contains \"(.*?)\" in \"(.*?)\" color$")
    public void theDownloadedDocumentContainsInColor(String textToFingFromPdf, String fontColor) throws Throwable {
        assertTrue("The downloaded document doesn't contain text with " + fontColor + " font Color",
                assetPageUtils.getColorFromPDFLinks(deliveryBaseUtils.getDownloadedDoc(), textToFingFromPdf).toString().equals(fontColor));
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
    public void selectDocFormatInDeliveryOptionsWindow(String format) {
        InitiateDelivery.DocFormat docFormat = InitiateDelivery.DocFormat.getFormatIgnoreCase(format);
        assertNotNull("Unknown document format: " + format, docFormat);
        new Select(downloadOptionsDialog.formatDropdown()).selectByValue(docFormat.toString());
    }
    
    @When("^the user clicks Download button in delivery options window$")
    public void clickDownloadInDeliveryOptionsWindow() {
        downloadOptionsDialog.waitForElementToBeClickable(downloadOptionsDialog.downloadButton());
        downloadOptionsDialog.downloadButton().click();
    }
    
    private void assertDocumentReadyToDownload() {
        assertTrue("Download button absent", downloadOptionsDialog.getDownloadButtonWhenDocReadyToDownload().isDisplayed());
        assertTrue("Document is not ready to download", downloadOptionsDialog.getReadyForDownloadWindow().getText().contains("ready"));
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

}

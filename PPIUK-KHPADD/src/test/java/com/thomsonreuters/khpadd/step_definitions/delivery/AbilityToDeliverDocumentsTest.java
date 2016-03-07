package com.thomsonreuters.khpadd.step_definitions.delivery;

import com.thomsonreuters.khpadd.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.SeleniumKeyboard;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.ask.AskResourcePage;
import com.thomsonreuters.pageobjects.pages.delivery.DownloadOptionsPage;
import com.thomsonreuters.pageobjects.pages.delivery.EmailOptionsPage;
import com.thomsonreuters.pageobjects.pages.delivery.PrintOptionsPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesBasePage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.DocumentDeliveryOptionsPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import com.thomsonreuters.pageobjects.rest.DeliveryBaseUtils;
import com.thomsonreuters.pageobjects.rest.model.request.delivery.initiateDelivery.InitiateDelivery;
import com.thomsonreuters.pageobjects.utils.delivery.DeliveryFormField;
import com.thomsonreuters.pageobjects.utils.email.EmailMessageUtils;
import com.thomsonreuters.pageobjects.utils.email.Mailbox;
import com.thomsonreuters.pageobjects.utils.email.MailboxFactory;
import com.thomsonreuters.pageobjects.utils.form.CheckBoxOrRadioButton;
import com.thomsonreuters.pageobjects.utils.form.FormUtils;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import javax.mail.Message;
import java.io.File;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

public class AbilityToDeliverDocumentsTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private KHResourcePage resourcePage = new KHResourcePage();
    private DocumentDeliveryOptionsPage deliveryOptionsPage = new DocumentDeliveryOptionsPage();
    private EmailOptionsPage email = new EmailOptionsPage();
    private PrintOptionsPage print = new PrintOptionsPage();
    private DownloadOptionsPage download = new DownloadOptionsPage();
    private SeleniumKeyboard seleniumKeyboard = new SeleniumKeyboard();
    private DeliveryBaseUtils deliveryBaseUtils = new DeliveryBaseUtils();
    private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();
    private LegalUpdatesBasePage legalUpdatesBasePage = new LegalUpdatesBasePage();
    private AssetPageUtils assetPageUtils = new AssetPageUtils();
    private FormUtils formUtils = new FormUtils();
    private AskResourcePage askResourcePage = new AskResourcePage();
    private EmailMessageUtils emailMessageUtils = new EmailMessageUtils();
    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();

    private String messageBody;
    private File downloadedFile = null;

    @Given("^user navigates directly to document with guid \"(.*?)\"$")
    public void userNavigatesDirectlyToDocumentWithGuid(String guid) throws Throwable {
        navigationCobalt.navigateToWLNSpecificResourcePage("/Document/" + guid + "/View/FullText.html");
        resourcePage.waitForPageToLoadAndJQueryProcessingWithCustomTimeOut(30);
    }

    @When("^clicks on (email|Print|Download) delivery option for the document$")
    public void clicksOnEmailDeliveryOptionForTheDocument(String deliveryOption) throws Throwable {
        switch (deliveryOption) {
            case "email":
                deliveryOptionsPage.email().click();
                email.basicTab().isDisplayed();
                email.emailButton().isDisplayed();
                break;
            case "Print":
                deliveryOptionsPage.print().click();
                print.printButton().isDisplayed();
                break;
            case "Download":
                deliveryOptionsPage.download().click();
                download.basicTab().isDisplayed();
                download.downloadButton().isDisplayed();
                break;
            default:
                break;
        }
    }

    @Then("^the user download printable document with option '(.*)' and verifies that it contains '(.*)' and not contains '(.*)'$")
    public void downloadPrintableAndCheck(String whatToDeliverOptionString, String phrasesToExists, String phrasesToAbsent) throws Throwable {
        selectWhatToDeliverOptionInDeliveryOptionsWindow(whatToDeliverOptionString);
        clickPrintInDeliveryOptionsWindow();
        download.waitForPageToLoadAndJQueryProcessing();
        seleniumKeyboard.sendEscape();
        File downloadedDocument = deliveryBaseUtils.downloadAndGetDocument(true);
        assertTrue("Document was not downloaded", downloadedDocument != null && downloadedDocument.exists());
        assertTrue(deliveryBaseUtils.isDocContainsOrNotContains(downloadedDocument,
                InitiateDelivery.DocFormat.Pdf, phrasesToExists, phrasesToAbsent));
    }

    @When("^the user selects '(.*)' option in What To Deliver block in delivery options window$")
    public void selectWhatToDeliverOptionInDeliveryOptionsWindow(String whatToDeliverOptionString) throws Throwable {
        if (download.getWhatToDeliverBlock() != null) {
            download.getWhatToDeliverRadioButton(whatToDeliverOptionString).click();
        }
    }

    @When("^the user clicks Print button in delivery options window$")
    public void clickPrintInDeliveryOptionsWindow() throws Throwable {
        download.waitForElementToBeClickable(print.printButton());
        print.printButton().click();
    }

    @Then("^user closes the delivery box by clicking on the cancel button$")
    public void userClosesTheDeliveryBoxByClickingOnTheButton() throws Throwable {
        email.cancelButton().click();
    }

    @Then("^the download window should be absent$")
    public void theDeliveryWindowShouldBeAbsent() throws Throwable {
        assertTrue("The user sees the delivery window", assetDocumentPage.isDeliveryWindowAbsent());
    }

    @Then("^the delivery options dialog is present and What To Deliver option presence is '(yes|no)'$")
    public void checkDeliveryOptionsDialogPresenceWithOption(String whatToDeliverOptionPresence) throws Throwable {
        assertTrue("Delivery Options dialog is absent", legalUpdatesBasePage.emailDeliveryWidget().isDisplayed());
        boolean withWhatToDeliver = whatToDeliverOptionPresence.equalsIgnoreCase("yes");
        if (withWhatToDeliver) {
            assertNotNull("What To Deliver option is absent", download.getWhatToDeliverBlock());
        } else {
            assertNull("What To Deliver option is present", download.getWhatToDeliverBlock());
        }
    }

    @When("^the user sets Table of Contents option to '(selected|unselected)' state$")
    public void deliveryOptionsSetTableOfContents(String state) throws Throwable {
        new CheckBoxOrRadioButton().editValue(assetDocumentPage.inputCheckboxTableOfContent(), state);
    }

    @Then("^the user downloads document in format '(.*)' with option '(.*)' and verifies that it contains '(.*)' and not contains '(.*)'$")
    public void downloadDocDocumentAndCheck(String format, String whatToDeliverOptionString, String phrasesToExists, String phrasesToAbsent) throws Throwable {
        selectWhatToDeliverOptionInDeliveryOptionsWindow(whatToDeliverOptionString);
        selectDocFormatInDeliveryOptionsWindow(format);
        clickDownloadInDeliveryOptionsWindow();
        assertDocumentReadyToDownload();
        File downloadedDocument = deliveryBaseUtils.downloadAndGetDocument(false);
        assertTrue("Document was not downloaded", downloadedDocument != null && downloadedDocument.exists());
        assertTrue("Document text does not meet the expectations",
                deliveryBaseUtils.isDocContainsOrNotContains(downloadedDocument,
                        InitiateDelivery.DocFormat.valueOf(format), phrasesToExists, phrasesToAbsent));
    }

    @When("^the user selects '(.*)' document format in delivery options window$")
    public void selectDocFormatInDeliveryOptionsWindow(String format) throws Throwable {
        InitiateDelivery.DocFormat docFormat = InitiateDelivery.DocFormat.getFormatIgnoreCase(format);
        assertNotNull("Unknown document format: " + format, docFormat);
        new Select(download.formatDropdown()).selectByValue(docFormat.toString());
    }

    @When("^the user clicks Download button in delivery options window$")
    public void clickDownloadInDeliveryOptionsWindow() throws Throwable {
        download.waitForElementToBeClickable(download.downloadButton());
        download.downloadButton().click();
    }

    @When("^the hyperlink \"(.*?)\" in downloaded PDF document does not exists$")
    public void checkThatDownloadedDocNotContainsLink(String linkText) throws Throwable {
        File downloadedDocFile =  deliveryBaseUtils.getDownloadedDoc();
        String docFileName = downloadedDocFile.getName();
        if (!linkText.isEmpty() && docFileName.toLowerCase().endsWith(".pdf")) {
            assertFalse("The downloaded document '" + docFileName + "' contains link '" + linkText +"'",
                    assetPageUtils.isLinkExistsInThePdfDocument(linkText, downloadedDocFile));
        }
    }

    @Then("^the user should be able to see (Email|Print|Download) (basic|advanced) tab options as follows$")
    public void theUserShouldBeAbleToSeeEmailBasicTabOptionsAsFollows(String deliveryType, String tabType, DataTable dataTable) throws Throwable {
        for (Map.Entry<String, String> entry : dataTable.asMap(String.class, String.class).entrySet()) {
            String value;
            try {
                value = formUtils.getValue(DeliveryFormField.getByFieldDisplayName(entry.getKey())).trim();
            } catch (Exception e) {
                throw new Exception("Could not find or modify field '" + entry.getKey() + "'", e);
            }
            assertThat(value, Is.is(entry.getValue().trim()));
        }
    }

    @Then("^the user edits the (basic|advanced) (email|print|download) options as follows$")
    public void theUserEditsTheBasicEmailOptionsAsFollows(String tabType, String deliveryType, DataTable dataTable) throws Throwable {
        for (Map.Entry<String, String> entry : dataTable.asMap(String.class, String.class).entrySet()) {
            try {
                formUtils.editValue(DeliveryFormField.getByFieldDisplayName(entry.getKey()), entry.getValue());
            } catch (Exception e) {
                throw new Exception("Could not find or modify field '" + entry.getKey() + "'", e);
            }
        }
    }

    @When("^Email button is clicked$")
    public void emailButtonIsClicked() throws Throwable {
        Thread.sleep(1000);
        email.emailButton().click();
    }

    @Then("^the user verifies that '(Ready For Email|Ready For Download|Preparing For Print|Preparing For Email|Preparing For Download)' is displayed on the overlay$")
    public void the_user_verifies_that_Ready_For_Email_is_display_on_overlay(String header) throws Throwable {
        if (header.contains("Ready")) {
            Thread.sleep(1000);
            assertThat("The " + header + " is NOT displayed", askResourcePage.readyMessageOverlayHeader().getText(), containsString(header));
        } else {
            assertThat("The " + header + " is NOT displayed", askResourcePage.prepareMessageOverlayHeader().getText(), containsString(header));
        }
    }

    @Then("^user receives an email at \"(.*?)\" with document in (Microsoft Word|PDF|Word Processor \\(RTF\\)) format and with subject \"(.*?)\"(| and downloads the document)$")
    public void userReceivesAnEmailWithDocument(String email, String format, String subject, String download) throws Throwable {
        Mailbox mailbox = MailboxFactory.getMailboxByEmail(email);
        Message message = mailbox.waitForMessageWithTitle(subject, 120, 10);
        String extension = emailMessageUtils.getAttachmentExtension(message);
        switch (format) {
            case "Microsoft Word":
                Assert.assertTrue("File extension is not Microsoft Word: " + extension,
                        extension.equalsIgnoreCase("doc") || extension.equalsIgnoreCase("doc"));
                break;
            case "PDF":
                Assert.assertTrue("File extension is not PDF: " + extension, extension.equalsIgnoreCase("pdf"));
                break;
            case "Word Processor (RTF)":
                Assert.assertTrue("File extension is not RTF: " + extension, extension.equalsIgnoreCase("rtf"));
                break;
        }
        if (!download.trim().isEmpty()) {
            downloadedFile = emailMessageUtils.downloadAttachment(message);
        }
    }

    @Then("^user receives an email at \"(.*?)\" without attachments and with link to the (AU|UK) document \"(.*?)\" and with subject \"(.*?)\"$")
    public void userReceivesAnEmailWithoutAttachmentsWithLink(String email, String country, String link, String subject) throws Throwable {
        Mailbox mailbox = MailboxFactory.getMailboxByEmail(email);
        Message message = mailbox.waitForMessageWithTitle(subject, 120, 10);
        String expectedUrl = country + ".practicallaw." + System.getProperty("base.url") + ".thomsonreuters.com";
        String expectedParams = "/View/FullText.html";
        messageBody = emailMessageUtils.getMessageBody(message);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(emailMessageUtils.hasAttachment(message)).overridingErrorMessage("Email contains attachment").isFalse();
        softly.assertThat(emailMessageUtils.isEmailContainsText(message, expectedUrl))
                .overridingErrorMessage("Email does not contain expected link: %s", expectedUrl).isTrue();
        softly.assertThat(emailMessageUtils.isEmailContainsText(message, link))
                .overridingErrorMessage("Email does not contain expected document id: %s", link).isTrue();
        softly.assertThat(emailMessageUtils.isEmailContainsText(message, expectedParams))
                .overridingErrorMessage("Email does not contain expected link parts: %s", expectedParams).isTrue();
        softly.assertAll();
    }

    @Then("^user copies the link in valid format from email into the browser$")
    public void userCopiesLinkFromEmailIntoBrowser() throws Throwable {
        Pattern p = Pattern.compile("(<a href=.+>)(https:\\/\\/a?\\.?au\\.practicallaw\\..+\\.thomsonreuters\\.com\\/.-\\d{3}-\\d{4})(<\\/a>)");
        Matcher m = p.matcher(messageBody);
        if (m.find()){
            String url = m.group(2);
            deliveryOptionsPage.navigate(url);
        }
        else{
            Assert.assertTrue("URL does not match the pattern: \n" + messageBody, false);
        }
    }

    @Then("^user should be presented with proper document \"(.*?)\"$")
    public void userShouldBePresentedWithProperDocument(String documentTitle) throws Throwable {
        assertTrue("Document title is incorrect. Actual title: " + standardDocumentPage.documentTitle().getText().trim(), standardDocumentPage.documentTitle().getText().trim().contains(documentTitle));
    }

    private void assertDocumentReadyToDownload() {
        assertTrue("Download button absent", download.getDownloadButtonWhenDocReadyToDownload().isDisplayed());
        assertTrue("Document is not ready to download", download.getReadyForDownloadWindow().getText().contains("ready"));
    }

}

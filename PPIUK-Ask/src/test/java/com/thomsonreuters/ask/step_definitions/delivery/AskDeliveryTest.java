package com.thomsonreuters.ask.step_definitions.delivery;

import com.thomsonreuters.ask.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.FileActions;
import com.thomsonreuters.pageobjects.common.WindowHandler;
import com.thomsonreuters.pageobjects.pages.delivery.DownloadOptionsPage;
import com.thomsonreuters.pageobjects.pages.delivery.EmailOptionsPage;
import com.thomsonreuters.pageobjects.pages.delivery.PrintOptionsPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.DocumentDeliveryOptionsPage;
import com.thomsonreuters.pageobjects.utils.delivery.DeliveryFormField;
import com.thomsonreuters.pageobjects.utils.email.EmailMessageUtils;
import com.thomsonreuters.pageobjects.utils.email.Mailbox;
import com.thomsonreuters.pageobjects.utils.email.MailboxFactory;
import com.thomsonreuters.pageobjects.utils.form.FormUtils;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import javax.mail.Message;
import java.io.File;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class AskDeliveryTest extends BaseStepDef {

    private DocumentDeliveryOptionsPage deliveryOptionsPage = new DocumentDeliveryOptionsPage();
    private EmailOptionsPage email = new EmailOptionsPage();
    private PrintOptionsPage print = new PrintOptionsPage();
    private DownloadOptionsPage download = new DownloadOptionsPage();
    private FormUtils formUtils = new FormUtils();
    private WindowHandler windowHandler = new WindowHandler();
    private FileActions fileActions = new FileActions();
    private EmailMessageUtils emailMessageUtils = new EmailMessageUtils();

    private final static String DOWNLOADED_FILE_PATH = System.getProperty("user.home") + "/Downloads";
    private File downloadedFile = null;

    @When("^the user deletes all files with name \"([^\"]*)\" and extension \"([^\"]*)\" from Downloads$")
    public void deleteFilesFormDownloads(String name, String extension) throws Throwable {
        File dir = new File(DOWNLOADED_FILE_PATH);
        List<File> files = (List<File>) FileUtils.listFiles(dir, TrueFileFilter.INSTANCE, null);
        for (File file : files) {
            if (file.getName().contains(name) && file.getName().contains(extension)) {
                file.delete();
            }
        }
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

    @When("^user (downloads|prints|exports) the document with name \"(.*?)\" and extension \"(.*?)\"$")
    public void userDownloadsTheDocument(String action, String name, String extension) throws Throwable {
        Thread.sleep(1000);
        WebElement downloadOrConfirmationButton = null;
        switch (action) {
            case "downloads":
                download.downloadButton().click();
                download.waitForPageToLoad();
                downloadOrConfirmationButton = download.confirmDownloadButton();
                break;
            case "exports":
                download.exportButton().click();
                download.waitForPageToLoadAndJQueryProcessing();
                downloadOrConfirmationButton = download.confirmDownloadButton();
                break;
            default:
                downloadOrConfirmationButton = print.printButton();
                break;
        }
        if (extension.contains("pdf")) {
            windowHandler.fileDownloadAutomatically(downloadOrConfirmationButton);
        } else {
            windowHandler.fileDownload(downloadOrConfirmationButton);
        }
        downloadedFile = fileActions.findFile(name, extension, DOWNLOADED_FILE_PATH);
        assertTrue("File was not downloaded", downloadedFile != null && downloadedFile.exists());
    }

    @Then("^the user should be able to see (Email|Print|Download) (basic|advanced) tab options as follows$")
    public void theUserShouldBeAbleToSeeEmailBasicTabOptionsAsFollows(String deliveryType, String tabType, DataTable dataTable)
            throws Throwable {
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

    @When("^Email button is clicked$")
    public void emailButtonIsClicked() throws Throwable {
        email.emailButton().click();
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

}

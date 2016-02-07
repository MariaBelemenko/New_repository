package com.thomsonreuters.fastdraft.step_definitions.common;

import com.thomsonreuters.fastdraft.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.FileActions;
import com.thomsonreuters.pageobjects.common.WindowHandler;
import com.thomsonreuters.pageobjects.pages.fastDraft.ChangesInUploadedPDF;
import com.thomsonreuters.pageobjects.pages.fastDraft.DraftViewPage;
import com.thomsonreuters.pageobjects.pages.fastDraft.FormEPage;
import com.thomsonreuters.pageobjects.pages.widgets.CategoryPage;
import com.thomsonreuters.pageobjects.utils.fastDraft.FastDraftUtils;
import com.thomsonreuters.pageobjects.utils.pdf.PDFBoxUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class WorkWithFormETest extends BaseStepDef {

    private CategoryPage categoryPage = new CategoryPage();
    private FormEPage formEpage = new FormEPage();
    private DraftViewPage draftViewPage = new DraftViewPage();
    private WindowHandler windowHandler = new WindowHandler();
    private PDFBoxUtil pdfBoxUtil = new PDFBoxUtil();
    private FileActions fileActions = new FileActions();
    private FastDraftUtils fastDraftUtils = new FastDraftUtils();
    private ChangesInUploadedPDF changesInUploadedPDF = new ChangesInUploadedPDF();

    private final static String DOWNLOADED_FILE_PATH = System.getProperty("user.home") + "/Downloads";
    private File downloadedFile = null;
    private static final String DRAFT = "draft";

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

    @When("^the user opens Form E page$")
    public void openFormE() throws Throwable {
        categoryPage.formE().click();
        categoryPage.waitForPageToLoad();
    }

    @When("^the user starts here Form E$")
    public void submitFormE() throws Throwable {
        formEpage.startHereFormE().click();
        formEpage.waitForPageToLoad();
    }

    @When("^the user exports Form E as editable PDF with changes$")
    public void exportEditablePDFWithChanges() throws Throwable {
        Thread.sleep(10000);
        draftViewPage.export().click();
        windowHandler.fileDownloadAutomatically(draftViewPage.exportEditablePDF());
    }

    @Then("^draft file with extension \"([^\"]*)\" should download to the users machine$")
    public void fileShouldDownloadToTheUsersMachine(String extension) throws Throwable {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        downloadedFile = fileActions.findFile(DRAFT, extension, DOWNLOADED_FILE_PATH);
        assertTrue("File was not downloaded", downloadedFile != null && downloadedFile.exists());
    }

    @When("^the user updates PFD with new name \"([^\"]*)\", new date \"([^\"]*)\", new month \"([^\"]*)\" and new year \"([^\"]*)\" in Date of birth$")
    public void changeFormEField(String newName, String newDate, String newMonth, String newYear) throws Throwable {
        PDDocument document = pdfBoxUtil.readDocument(downloadedFile.getAbsolutePath());
        pdfBoxUtil.editName(document, newName);
        pdfBoxUtil.editBirthDate(document, newDate, newMonth, newYear);
        pdfBoxUtil.save(document, downloadedFile.getAbsolutePath());
    }

    @When("^the user uploads edited PDF to the document name \"([^\"]*)\"$")
    public void uploadEditedPDF(String documentName) throws Throwable {
        fastDraftUtils.uploadFormEFromFD(documentName, downloadedFile.getAbsolutePath());
    }

    @Then("^the user is redirected to Changes in the uploaded PDF page$")
    public void checkChangesInUploadedPDF() throws Throwable {
        changesInUploadedPDF.waitForPageToLoad();
        changesInUploadedPDF.checkChangesInUploadedPDFDisplayed();
        assertTrue("Changes in the uploaded PDF page is not displayed", changesInUploadedPDF.getCurrentUrl().contains("uploadPDF"));
    }

    @Then("^there is a section \"([^\"]*)\" with original \"([^\"]*)\" and reviced \"(.*?)\"$")
    public void checkSectionHasOriginalAndRevicedValues(String sectionName, String originalValue, String revisedValue) throws Throwable {
        changesInUploadedPDF.checkChangesInUploadedPDFDisplayed();
        changesInUploadedPDF.checkSectionHasOriginalAndRevicedValues(sectionName, originalValue, revisedValue);
    }

    @When("^the user deselects \"([^\"]*)\" section$")
    public void deselectSection(String sectionName) throws Throwable {
        WebElement checkBox = changesInUploadedPDF.section(sectionName);
        if (checkBox.isSelected()) {
            checkBox.click();
        }
    }

    @When("the users clicks accept changes on Changes in the uploaded PDF page")
    public void acceptChanges() throws Throwable {
        changesInUploadedPDF.acceptChanges().click();
    }

    @When("^the user Uploads Form E for Form E page$")
    public void uploadFormE() throws Throwable {
        fastDraftUtils.uploadFormEFromFormEPage(downloadedFile.getAbsolutePath());
    }

    @Then("^the user is redirected to document page with upload error$")
    public void checkDocumentPageWithErrorPresents() throws Throwable {
        assertTrue("Document page with upload error is not displayed", changesInUploadedPDF.isDocumentPageWithErrorPresents());
    }

    @When("^the user uploads new file with name \"([^\"]*)\" end extension \"([^\"]*)\" to the document name \"([^\"]*)\"$")
    public void uploadNewFile(String name, String extension, String documentName) throws Throwable {
        String path = DOWNLOADED_FILE_PATH + "/" + name + extension;
        createTestFile(path);
        fastDraftUtils.uploadFormEFromFD(documentName, FileSystems.getDefault().getPath(path).toString());
    }

    @Then("^the user is redirected to document page with upload not the correct type error$")
    public void checkDocumentPageWithUploadNotCorrectTypeErrorPresents() throws Throwable {
        assertTrue("Document page with upload not the correct type error is not displayed", changesInUploadedPDF.isDocumentPageWithUploadNotCorrectTypeErrorPresents());
    }

    @Then("^the file should be removed$")
    public void deleteDownloadedDocFile() throws Throwable {
        fileActions.deleteFile(downloadedFile);
    }

    private void createTestFile(String path) {
        try {
            PrintWriter writer = new PrintWriter(path, "UTF-8");
            writer.println("The first line");
            writer.println("The second line");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

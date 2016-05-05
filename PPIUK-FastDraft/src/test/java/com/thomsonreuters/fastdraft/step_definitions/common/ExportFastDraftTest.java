package com.thomsonreuters.fastdraft.step_definitions.common;

import com.thomsonreuters.fastdraft.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.FdDeliveryDocument;
import com.thomsonreuters.pageobjects.common.FileActions;
import com.thomsonreuters.pageobjects.pages.fastDraft.ChangesInUploadedPDF;
import com.thomsonreuters.pageobjects.pages.fastDraft.DraftViewPage;
import com.thomsonreuters.pageobjects.pages.fastDraft.FormEPage;
import com.thomsonreuters.pageobjects.pages.widgets.CategoryPage;
import com.thomsonreuters.pageobjects.utils.fastDraft.FastDraftUtils;
import com.thomsonreuters.pageobjects.utils.pdf.PDFBoxUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;

import static org.junit.Assert.assertTrue;

public class ExportFastDraftTest extends BaseStepDef {

    private CategoryPage categoryPage = new CategoryPage();
    private FormEPage formEpage = new FormEPage();
    private DraftViewPage draftViewPage = new DraftViewPage();
    private PDFBoxUtil pdfBoxUtil = new PDFBoxUtil();
    private FileActions fileActions = new FileActions();
    private FastDraftUtils fastDraftUtils = new FastDraftUtils();
    private ChangesInUploadedPDF changesInUploadedPDF = new ChangesInUploadedPDF();

    private final static String DOWNLOADED_FILE_PATH = System.getProperty("basedir") + "/target";
    private File downloadedFile = null;
    private FdDeliveryDocument fdDeliveryDocument;

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

    @Then("^the user exports Form E as editable PDF with changes$")
    public void exportEditablePDFWithChanges() throws Throwable {
        draftViewPage.export().click();
        // Just ensure that we have ability to export fast draft document
        assertTrue("Export as editable PDF menu is not clickable", draftViewPage.exportEditablePDF().isDisplayed());
        fdDeliveryDocument = FdDeliveryDocument.PDF_FORM_EDITABLE;
        downloadFastDraft();
    }

    @Then("^draft file with extension \"([^\"]*)\" should download to the users machine$")
    public void fileShouldDownloadToTheUsersMachine(String extension) throws Throwable {
        assertTrue("File was not downloaded",
                downloadedFile != null && downloadedFile.exists() && downloadedFile.getName().endsWith(extension));
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

    @When("^the user clicks Word document and saves .doc file$")
    public void clickWordDocument() throws Throwable {
        // Just ensure that we have ability to export fast draft document
        assertTrue("Export as editable PDF menu is not clickable", draftViewPage.wordDocument().isDisplayed());
        fdDeliveryDocument = FdDeliveryDocument.WORD_FORM;
        downloadFastDraft();
    }

    @When("^the user exports Form E as editable PDF$")
    public void exportEditablePDF() throws Throwable {
        exportEditablePDFWithChanges();
    }

    @When("^the user exports Form E as printable PDF$")
    public void exportPrintablePDF() throws Throwable {
        draftViewPage.export().click();
        // Just ensure that we have ability to export fast draft document
        assertTrue("Export as editable PDF menu is not clickable", draftViewPage.exportPrintablePDF().isDisplayed());
        fdDeliveryDocument = FdDeliveryDocument.PDF_FORM_PRINTABLE;
        downloadFastDraft();
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

    /**
     * Download export version of fast draft document.
     * WARNING! Export type should be set by steps. {@link this#fdDeliveryDocument}
     */
    private void downloadFastDraft() {
        downloadedFile = fastDraftUtils.downloadFdAndGetFile(fdDeliveryDocument);
    }
}

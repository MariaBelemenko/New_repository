package com.thomsonreuters.ffh.step_definitions.common;

import com.thomsonreuters.ffh.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.common.SeleniumKeyboard;
import com.thomsonreuters.pageobjects.otherPages.GlossaryPage;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.delivery.DownloadOptionsPage;
import com.thomsonreuters.pageobjects.pages.delivery.PrintOptionsPage;
import com.thomsonreuters.pageobjects.pages.folders.NewFolderPopup;
import com.thomsonreuters.pageobjects.pages.folders.ResearchOrganizerPage;
import com.thomsonreuters.pageobjects.pages.folders.RestoreFromTrashPopup;
import com.thomsonreuters.pageobjects.pages.folders.SaveToPopup;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawHomepage;
import com.thomsonreuters.pageobjects.pages.landingPage.ResourcesPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesBasePage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.CommonResourcePage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.DocumentRightPanelPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.documentNavigation.DocumentDeliveryPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.pageobjects.pages.urls.plcuk.KHDocumentPage;
import com.thomsonreuters.pageobjects.rest.DeliveryBaseUtils;
import com.thomsonreuters.pageobjects.rest.DocumentBaseUtils;
import com.thomsonreuters.pageobjects.rest.model.request.delivery.initiateDelivery.InitiateDelivery;
import com.thomsonreuters.pageobjects.utils.Linking.LinkingUtils;
import com.thomsonreuters.pageobjects.utils.Product;
import com.thomsonreuters.pageobjects.utils.document.ContentType;
import com.thomsonreuters.pageobjects.utils.document.Document;
import com.thomsonreuters.pageobjects.utils.document.content.Section;
import com.thomsonreuters.pageobjects.utils.document.metadata.Jurisdiction;
import com.thomsonreuters.pageobjects.utils.folders.FoldersUtils;
import com.thomsonreuters.pageobjects.utils.form.CheckBoxOrRadioButton;
import com.thomsonreuters.pageobjects.utils.legalUpdates.CalendarAndDate;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BaseDocumentBehaviorTest extends BaseStepDef {

    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private ResearchOrganizerPage researchOrganizerPage = new ResearchOrganizerPage();
    private DocumentBaseUtils restSteps = new DocumentBaseUtils();
    private DocumentDeliveryPage documentDeliveryPage = new DocumentDeliveryPage();
    private CommonMethods comMethods = new CommonMethods();
    private FoldersUtils foldersUtils = new FoldersUtils();
    private DeliveryBaseUtils deliveryBaseUtils = new DeliveryBaseUtils();
    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();
    private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();
    private GlossaryPage glossaryPage = new GlossaryPage();
    private LinkingUtils linkingUtils = new LinkingUtils();
    private CommonResourcePage commonResourcePage = new CommonResourcePage();
    private DocumentRightPanelPage rhsPanel = new DocumentRightPanelPage();
    private DownloadOptionsPage downloadOptionsDialog = new DownloadOptionsPage();
    private LegalUpdatesBasePage legalUpdatesBasePage = new LegalUpdatesBasePage();
    private PrintOptionsPage printOptionsPage = new PrintOptionsPage();
    private SeleniumKeyboard seleniumKeyboard = new SeleniumKeyboard();
    private Document singleDocument = new Document();
    private SaveToPopup saveToPopup = new SaveToPopup();
    private NewFolderPopup newFolderPopup = new NewFolderPopup();
    private RestoreFromTrashPopup restoreFromTrashPopup = new RestoreFromTrashPopup();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private KHDocumentPage documentPagePLCUK = new KHDocumentPage();
    private PracticalLawHomepage practicalLawHomepage = new PracticalLawHomepage();
    private ResourcesPage resourcesPage = new ResourcesPage();

    private List<Document> documents = new ArrayList<Document>();

    private String jumpLinkSection;
    private String folderName;

    @When("^the user opens '(.+)' link in the search result and store its title and guid$")
    public void openSearchResultLinkAtPositionAndStore(String linkPosition) throws Throwable {
        openSearchResultLinkAtPositionAndStoreItsTitleAndGuid(linkPosition);
    }

    // TODO: to rewrite
    @When("^the user waits search result to load$")
    public void waitSearchResults() throws Throwable {
        Thread.sleep(5000);
        searchResultsPage.waitForPageToLoad();
        Thread.sleep(5000);
    }

    @Then("^the '(.+)' link contains the document title and guid$")
    public void linkContainsDocumentNameAndGuid(String position) throws Throwable {
        String title = singleDocument.getTitle();
        String guid = singleDocument.getGuid();
        linkContainsTextAndHrefAttribute(position, title, guid);
    }

    @Then("^the '(.+)' link contains text \"([^\"]*)\" and url '(.+)'$")
    public void linkContainsTextAndHref(String position, String text, String url) throws Throwable {
        linkContainsTextAndHrefAttribute(position, text, url);
    }

    @Then("^the '(.+)' link contains event type '(.+)'$")
    public void checkEventType(String position, String eventType) throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        String actualEventType = researchOrganizerPage.getEventTypeAtRowPosition(position).getText();
        assertEquals("Event Type is incorrect", eventType, actualEventType);
    }

    @Then("^the '(.+)' link contains the document Content Type$")
    public void linkContainsDocumentContentType(String position) throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        String expectedContentType = ContentType.getContentTypeByMetaInfoName(restSteps.getDocumentContentType(singleDocument.getGuid())).getPLCUKName();
        String currentContentType = researchOrganizerPage.getContentTypeAtRowPosition(position).getText();
        if (!currentContentType.equals(expectedContentType)) {
            throw new RuntimeException("Current Content Type is not correct!");
        }
    }

    @Then("^the '(.+)' link contains the document Resource Type$")
    public void linkContainsDocumentResourceType(String position) throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        String expectedResourceType = restSteps.getDocumentResourceType(singleDocument.getGuid());
        String currentResourceType = researchOrganizerPage.getResourceTypeAtRowPosition(position).getText();
        if (!currentResourceType.equals(expectedResourceType)) {
            throw new RuntimeException("Current Resource Type is not correct!");
        }
    }

    @Then("^the '(.+)' link contains ClientId and date$")
    public void linkContainsDocumentClientIdAndDate(String position) throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        String actualClientId = researchOrganizerPage.getClientIdAtRowPosition(position).getText();
        String actualDate = researchOrganizerPage.getDateAtRowPosition(position).getText();
        String expectedDate = CalendarAndDate.getCurrentDate();
        if (!actualClientId.equals(getClientID())) {
            throw new RuntimeException("Current ClientId is not correct, actual: " + actualClientId + " while expected: " + getClientID());
        }
        if (!actualDate.contains(expectedDate) || !actualDate.contains(":")) {
            throw new RuntimeException("Current date is not correct: " + actualDate + " while expected " + expectedDate);
        }
    }

    @And("^the user adds current document to \"([^\"]*)\" folder$")
    public void addDocumentToFolderFromDocumentView(String folder) throws Throwable {
        documentDeliveryPage.clickOnAddToFolderLink();
        String folderName = saveToFolder(folder);
        researchOrganizerPage.waitForPageToLoad();
        String message = searchResultsPage.folderingPopupMessage().getText();
        assertEquals("Message is incorrect", singleDocument.getTitle() + " saved to '" + folderName + "'.", message);
    }

    @And("^the user adds current document to new \"([^\"]*)\" folder with parent folder \"([^\"]*)\"$")
    public void addDocumentToFolderFromDocumentView(String folder, String parentFolder) throws Throwable {
        documentDeliveryPage.clickOnAddToFolderLink();
        Thread.sleep(1000);
        saveToNewFolder(folder, parentFolder);
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
        String message = searchResultsPage.folderingPopupMessage().getText();
        assertEquals("Message is incorrect", singleDocument.getTitle() + " saved to '" + folder + "'.", message);
    }

    @When("^the user deletes the document from \"([^\"]*)\" folder$")
    public void deleteDocument(String folder) throws Throwable {
        foldersUtils.openFolder(folder);
        researchOrganizerPage.waitForPageToLoad();
        researchOrganizerPage.documentCheckbox(singleDocument.getGuid()).click();
        researchOrganizerPage.deleteButton().click();
        researchOrganizerPage.waitForPageToLoad();
        String message = searchResultsPage.folderingPopupMessage().getText();
        String expectedMessage = singleDocument.getTitle() + " moved to Trash. Undo";
        assertEquals("Message is incorrect", expectedMessage, message);
        researchOrganizerPage.waitForPageToLoad();
    }

    @When("^the user deletes all documents from \"([^\"]*)\" folder$")
    public void deleteAllDocuments(String folder) throws Throwable {
        foldersUtils.openFolder(folder);
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
        researchOrganizerPage.selectAllDocumentsCheckbox().click();
        researchOrganizerPage.deleteButton().click();
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
        String message = searchResultsPage.folderingPopupMessage().getText();
        String expectedMessage = " moved to Trash. Undo";
        if (!message.contains(expectedMessage)) {
            throw new RuntimeException("Message is incorrect");
        }
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^the folder \"([^\"]*)\" is empty$")
    public void checkFolderIsEmpty(String folder) throws Throwable {
        foldersUtils.openFolder(folder);
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
        try {
            researchOrganizerPage.linkToDocument().isDisplayed();
        } catch (NoSuchElementException e) {
            return;
        }
        throw new RuntimeException("There is a document in the folder");
    }

    @When("^the user opens the link to the glossary term \"([^\"]*)\" and store its title and guid$")
    public void openGlossaryTermAndStoreItsTitleAndGuid(String position) throws Throwable {
        singleDocument = new Document();
        /** Wait for this document to load */
        // TODO to remove
        Thread.sleep(25000);
        glossaryPage.waitForPageToLoad();
        glossaryPage.waitForPageToLoadAndJQueryProcessing();
        glossaryPage.glossaryTermLinkByPosition(position).click();
        glossaryPage.waitForPageToLoadAndJQueryProcessing();
        singleDocument.setTitle(standardDocumentPage.documentTitle().getText());
        singleDocument.setGuid(getDocumentGUID());
        /** Wait for this document appears in History. If it is to quickly the document could be missing */
        Thread.sleep(20000);
    }

    @Then("^the document Content type is correct$")
    public void checkDocumentContentType() throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        String actualContentType = researchOrganizerPage.getContentType(singleDocument.getGuid());
        String expectedContentType = ContentType.getContentTypeByMetaInfoName(restSteps.getDocumentContentType(singleDocument.getGuid())).getPLCUKName();
        assertEquals("Content type is incorrect", expectedContentType, actualContentType);
    }

    @Then("^the document Content type in Trash is correct$")
    public void checkDocumentContentTypeInTrash() throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        String actualContentType = researchOrganizerPage.getContentTypeInTrash(singleDocument.getTitle());
        String expectedContentType = ContentType.getContentTypeByMetaInfoName(restSteps.getDocumentContentType(singleDocument.getGuid())).getPLCUKName();
        assertEquals("Content type is incorrect", expectedContentType, actualContentType);
    }

    @Then("^the document Resource type is correct$")
    public void checkDocumentResourceType() throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        String actualResourceType = researchOrganizerPage.getResourceType(singleDocument.getGuid());
        String currentResourceType = restSteps.getDocumentResourceType(singleDocument.getGuid());
        assertEquals("Resource type is incorrect, the current resource " + currentResourceType + " is not the same as the actual resource " + actualResourceType, currentResourceType, actualResourceType);
    }

    @Then("^the document date is correct$")
    public void checkDocumentDate() throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        String actualDate = researchOrganizerPage.getDate(singleDocument.getGuid());
        String expectedDate = CalendarAndDate.getCurrentDate();
        assertEquals("Date is incorrect", expectedDate, actualDate);
    }

    @Then("^the document date in Trash is correct$")
    public void checkDocumentDateInTrash() throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        String actualDate = researchOrganizerPage.getDateInTrash(singleDocument.getTitle());
        String expectedDate = CalendarAndDate.getCurrentDate();
        assertEquals("Date is incorrect", expectedDate, actualDate);
    }

    @Then("^document present in the \"([^\"]*)\" folder$")
    public void checkDocumentPresent(String folder) throws Throwable {
        assertTrue("Document is '" + singleDocument.getTitle() + "' absent", checkDocumentPresence(folder));
    }

    @Then("^document does not present in the \"([^\"]*)\" folder$")
    public void checkDocumentAbsent(String folder) throws Throwable {
        if (checkDocumentPresence(folder)) {
            throw new RuntimeException("Document '" + singleDocument.getTitle() + "' present");
        }
    }

    @Then("^the user checks history is empty$")
    public void checkHistoryIsEmpty() throws Throwable {
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
        researchOrganizerPage.waitForPageToLoad();
        researchOrganizerPage.getHistoryEmpty();
    }

    @Then("^the user checks Faceting is absent$")
    public void checkFacetingIsAbsent() throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
        researchOrganizerPage.checkFacetingIsAbsent();
    }

    @When("^the user opens '(.+)' link in the search result and store its details$")
    public void openDocumentAndSaveDetails(String linkPosition) throws Throwable {
        openSearchResultLinkAtPositionAndStoreItsTitleAndGuid(linkPosition);
        singleDocument.setContentType(ContentType.getContentTypeByMetaInfoName(restSteps.getDocumentContentType(singleDocument.getGuid())).getPLCUKName());
        documents.add(singleDocument);
    }

    @Then("^the following documents content type present only$")
    public void checkDocumentsWithContentTypesPresentOnly(List<String> expectedContentTypes) throws Throwable {
        StringBuffer error = new StringBuffer();
        int actualDocumentsCount = researchOrganizerPage.getDocumentCountInFolders();
        List<Document> documentsWithExpectedContentTypes = getExpectedDisplayedDocument(expectedContentTypes);
        int expectedDocumentsCount = documentsWithExpectedContentTypes.size();
        /** Check actual and expect documents quantity are equal */
        if (actualDocumentsCount != expectedDocumentsCount) {
            error.append("Actual document count is wrong. Expected '" + expectedDocumentsCount + "'. Actual '"
                    + actualDocumentsCount + "'");
        }
        /** Check expected documents present */
        for (int i = 0; i < expectedDocumentsCount; i++) {
            Document docToCheck = documentsWithExpectedContentTypes.get(i);
            try {
                researchOrganizerPage.linkToDocumentContentType(docToCheck.getGuid(), docToCheck.getContentType());
            } catch (NoSuchElementException e) {
                error.append("Document '" + docToCheck.getGuid() + "' is absent\n");
            }
        }
        if (error.length() > 0) {
            throw new RuntimeException(error.toString());
        }
    }

    @Then("^the user finds the same document and checks it has got foldered sign$")
    public void checkFolderedSignPresent() throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        assertTrue("Document '" + singleDocument.getTitle() + "' has not got foldered sign", researchOrganizerPage.hasDocumentFolderedSign(singleDocument.getGuid()));
    }

    @Then("^the user finds the same document and checks it has not got foldered sign$")
    public void checkFolderedSignAbsent() throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        assertFalse("Document '" + singleDocument.getTitle() + "' has got foldered sign", researchOrganizerPage.hasDocumentFolderedSign(singleDocument.getGuid()));
    }

    @Then("^the user finds the same document and checks it has got previously viewed sign$")
    public void checkPreviouslyViewedSignPresent() throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        assertTrue("Document '" + singleDocument.getTitle() + "' has not got previously viewed sign", researchOrganizerPage.hasDocumentPreviouslyViewedSign(singleDocument.getGuid()));
    }

    @Then("^the user finds the same document and checks it has not got previously viewed sign$")
    public void checkPreviouslyViewedSignAbsent() throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        assertFalse("Document '" + singleDocument.getTitle() + "' has got previously viewed sign", researchOrganizerPage.hasDocumentPreviouslyViewedSign(singleDocument.getGuid()));
    }

    @Then("^there is no the document title and guid in recently used documents drop down$")
    public void checkDocumentAbsentInRecenltyUsedDropDown() throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        comMethods.mouseOver(researchOrganizerPage.recentHistoryDropdown());
        try {
            researchOrganizerPage.linkToDocumentInRecentDropdown(singleDocument.getGuid(), singleDocument.getTitle()).isDisplayed();
        } catch (NoSuchElementException e) {
            return;
        }
        throw new RuntimeException("Document '" + singleDocument.getTitle() + "' is present in recently used documents drop down");
    }

    @Then("^there is no the '(.+)' in recently used searches drop down$")
    public void checkSearchAbsentInRecenltyUsedDropDown(String search) throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        comMethods.mouseOver(researchOrganizerPage.recentHistoryDropdown());
        try {
            researchOrganizerPage.linkToSearchInRecentDropdown(search).isDisplayed();
        } catch (NoSuchElementException e) {
            return;
        }
        throw new RuntimeException("Search '" + search + "' is present in recently used documents drop down");
    }

    @When("^user clicks on '([^\"]*)' user folder with multiple documents in it$")
    public void openFolderWithMultipleDocs(String folderName) throws Throwable {
        openFolder(folderName);
    }

    @When("^the user clicks on result with number \"(\\d+)\" and title \"(.*?)\"$")
    public void openDocWithResultNumberAndTitle(String resultNumber, String title) throws Throwable {
        searchResultsPage.clickOnDocumentWithTitleAndNumber(resultNumber, title);
    }

    @When("^the user clicks on result with title \"(.*?)\"$")
    public void openDocWithResultTitle(String title) throws Throwable {
        searchResultsPage.getResultItemByTitle(title).click();
        searchResultsPage.waitForPageToLoad();
    }

    @When("^the user clicks on the R\\.H\\.S Actions sub-link \"(.*?)\" link")
    public void clickOnRhsLink(String linkText) throws Throwable {
        standardDocumentPage.clickOnRhsLink(linkText);
    }

    @Then("^it should take user to the Resource History section at the bottom of the page")
    public void checkThatUserSeeResourceHistory() throws Throwable {
        assertTrue("User was not scrolled to Resource History section", standardDocumentPage.isResourceHistoryDisplayed());
    }

    @When("^the user expands the resource history section by clicking \"View All\" link and then clicking on \"(.*?)\" link$")
    public void clickOnLinkInResourceHistorySection(String linkText) throws Throwable {
        standardDocumentPage.clickViewAllResourceHistory();
        standardDocumentPage.clickResourceHistoryLink(linkText);
        this.jumpLinkSection = linkText;
    }

    @Then("^it should take user to the corresponding link$")
    public void checkThatUsersSeeCorrespondedSectionFromResourceHistory() throws Throwable {
        assertTrue("User was not scrolled to corresponding section from Jump Link '" + jumpLinkSection + "'",
                standardDocumentPage.isDocumentSectionDisplayed(jumpLinkSection));
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

    @Then("^the user download printable document with option '(.*)' and verifies that it contains '(.*)' and not contains '(.*)'$")
    public void downloadPrintableAndCheck(String whatToDeliverOptionString, String phrasesToExists, String phrasesToAbsent) throws Throwable {
        selectWhatToDeliverOptionInDeliveryOptionsWindow(whatToDeliverOptionString);
        clickPrintInDeliveryOptionsWindow();
        downloadOptionsDialog.waitForPageToLoadAndJQueryProcessing();
        /** Minimize delivery window to prevent Download browser pop-up showing up */
        seleniumKeyboard.sendEscape();
        File downloadedDocument = deliveryBaseUtils.downloadAndGetDocument(true);
        assertTrue("Document was not downloaded", downloadedDocument != null && downloadedDocument.exists());
        assertTrue(deliveryBaseUtils.isDocContainsOrNotContains(
                downloadedDocument, InitiateDelivery.DocFormat.Pdf, phrasesToExists, phrasesToAbsent));
    }

    @When("^the user selects the document and moves back to original folder \"([^\"]*)\"$")
    public void selectDocumentAndRestore(String folderName) throws Throwable {
        researchOrganizerPage.getDocumentCheckbox(singleDocument.getTitle()).click();
        researchOrganizerPage.getSaveToFolderButton().click();
        moveToFolderAndGetTargetFolderName("root", folderName);
    }

    @Then("^the document should be removed from Trash and be moved to folder \"([^\"]*)\"$")
    public void docShouldBeInOriginalFolder(String folderName) throws Throwable {
        SoftAssertions softAssertions = new SoftAssertions();
//        softAssertions.assertThat(researchOrganizerPage.isDocumentAbsent(singleDocument.getTitle())).isTrue()
//                .withFailMessage("Document '" + singleDocument.getTitle() + "' present in the Trash");
//        openFolder(folderName);
//        softAssertions.assertThat(researchOrganizerPage.isDocumentExists(singleDocument.getTitle())).isTrue()
//                .withFailMessage("Document '" + singleDocument.getTitle() + "' absent in original folder");
//        softAssertions.assertAll();
    }

    @Then("^the user store title and guid of primary source document$")
    public void theUserStoreTitleAndGuidOfPrimarySourceDocument() throws Throwable {
        singleDocument = new Document();
        singleDocument.setTitle(standardDocumentPage.documentTitle().getText());
        singleDocument.setGuid(getDocumentGUID());
    }

    @When("^the user clicks on '(.*)' link in table of contents$")
    public void theUserClicksOnLinkSectionLinkInTableOfContents(String linkName) throws Throwable {
        jumpLinkSection = linkName;
        standardDocumentPage.getLinkInTableOfContents(linkName).click();
    }

    @When("^the user clicks on '(.*)' link in '(.*)' section of the document$")
    public void theUserClicksOnPracticeNoteLinLinkInSectionLinkSectionOfTheDocument(String linkName, String sectionName) throws Throwable {
        WebElement sectionLinkElement = standardDocumentPage.getLinkFromSection(sectionName, linkName);
        sectionLinkElement.click();
        standardDocumentPage.waitForPageToLoad();
    }

    // Get PL REF from current opened document, get XML structure of it from prod legacy and compare it with info on the page
    @Then("^the user verifies MetaData and Sections$")
    public void theUserVerifiesMetaDataAndSections() throws Throwable {
        SoftAssertions softAssertions = new SoftAssertions();
        Document docMetaData = linkingUtils.getDocumentMetaDataAndSectionsFromFatWire(commonResourcePage.plcRef().getText());
        List<String> documentSections = (standardDocumentPage.isContainsSection()) ?
                comMethods.getTextsFromWebElements(commonResourcePage.allHeadings()) : new ArrayList<String>();
        List<String> productsMetadata = comMethods.getTextsFromWebElements(standardDocumentPage.getProductsFromMetadata(), ",");
        List<String> jurisdictionsMetadata = rhsPanel.getVisibleJurisdictions();
        List<String> xmlSections = getSectionTitlesFromXml(docMetaData.getSections());
        List<String> xmlProducts = getProductNamesFromXml(docMetaData.getProducts());
        List<String> xmlJurisdictions = getJurisdictionNamesFromXml(docMetaData.getJurisdictions());

        // XML data is expected, page data - is actual. So, let's remove actual results from expected.
        // And if result list will be with 0 elements than all necessary data are present on the page.
        xmlSections.removeAll(documentSections);
        xmlProducts.removeAll(productsMetadata);
        xmlJurisdictions.removeAll(jurisdictionsMetadata);
//        softAssertions.assertThat(xmlSections)
//                .withFailMessage("Following sections from XML are absent on the page: " + xmlSections)
//                .isEmpty();
//        softAssertions.assertThat(xmlProducts)
//                .withFailMessage("Following products from XML meta-data are absent on the page: " + xmlProducts)
//                .isEmpty();
//        softAssertions.assertThat(xmlJurisdictions)
//                .withFailMessage("Following jurisdictions from XML meta-data are absent on the page: " + xmlJurisdictions)
//                .isEmpty();
//
//        // Verify doc resource type
//        // Sometimes resource type can be obtained with unnecessary space which should be removed by .trim() method
//        softAssertions.assertThat(rhsPanel.resourceTypeText().getText().trim())
//                .isEqualTo(docMetaData.getResourceType().trim());
//        softAssertions.assertAll();
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
                deliveryBaseUtils.isDocContainsOrNotContains(
                        downloadedDocument, InitiateDelivery.DocFormat.valueOf(format), phrasesToExists, phrasesToAbsent)
        );
    }

    @When("^the user selects '(.*)' option in What To Deliver block in delivery options window$")
    public void selectWhatToDeliverOptionInDeliveryOptionsWindow(String whatToDeliverOptionString) {
        /** Need this check for document without drafting notes due to it hasn't "what to deliver" option
         If you want to ensure that "what to deliver" block present, please use the step
         checkDeliveryOptionsDialogPresenceWithOption(String) */
        if (downloadOptionsDialog.getWhatToDeliverBlock() != null) {
            downloadOptionsDialog.getWhatToDeliverRadioButton(whatToDeliverOptionString).click();
        }
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

    @When("^the user clicks Print button in delivery options window$")
    public void clickPrintInDeliveryOptionsWindow() {
        downloadOptionsDialog.waitForElementToBeClickable(printOptionsPage.printButton());
        printOptionsPage.printButton().click();
    }

    @Then("^the delivery options dialog is present and What To Deliver option presence is '(yes|no)'$")
    public void checkDeliveryOptionsDialogPresenceWithOption(String whatToDeliverOptionPresence) {
        assertTrue("Delivery Options dialog is absent", legalUpdatesBasePage.emailDeliveryWidget().isDisplayed());
        boolean withWhatToDeliver = whatToDeliverOptionPresence.equalsIgnoreCase("yes");
        if (withWhatToDeliver) {
            assertNotNull("What To Deliver option is absent", downloadOptionsDialog.getWhatToDeliverBlock());
        } else {
            assertNull("What To Deliver option is present", downloadOptionsDialog.getWhatToDeliverBlock());
        }
    }

    @When("^the user sets Table of Contents option to '(selected|unselected)' state$")
    public void deliveryOptionsSetTableOfContents(String state) {
        new CheckBoxOrRadioButton().editValue(assetDocumentPage.inputCheckboxTableOfContent(), state);
    }

    @When("^the user opens document with (.+) guid$")
    public void theUserOpensDocumentWithGuid(String guid) throws Throwable {
        navigationCobalt.navigateToPLCUKPlusSpecificURL("/Document/" + guid + "/View/FullText.html");
        navigationCobalt.waitForPageToLoad();
    }

    @Then("^the user click on View Document button$")
    public void theUserClickOnViewDocumentButton() throws Throwable {
        standardDocumentPage.clickOnViewDocumentButton();
    }

    @Then("^the document opens correctly$")
    public void theDocumentOpensCorrectly() throws Throwable {
        assertTrue("Document not present", documentPagePLCUK.isDocumentBlockPresent());
    }

    @When("^the user is on the glossary tool page$")
    public void theUserIsOnTheGlossaryToolPage() throws Throwable {
        practicalLawHomepage.resourcesLink().click();
        resourcesPage.glossaryLink().click();
    }

    private String saveToFolder(String folder) {
        String folderName = null;
        saveToPopup.waitForPageToLoad();
        saveToPopup.waitForPageToLoadAndJQueryProcessing();
        if (folder.equals("root")) {
            saveToPopup.selectRootFolder().click();
            folderName = saveToPopup.selectRootFolder().getText();
        } else {
            saveToPopup.waitForPageToLoadAndJQueryProcessing();
            try {
                saveToPopup.expandRootFolderWait().click();
                saveToPopup.selectFolderWait(folder).click();
            } catch (NoSuchElementException e) {
                throw new RuntimeException("Folder '" + folder + "'doesn't present");
            }
        }
        saveToPopup.save().click();
        return folderName;
    }

    private String saveToNewFolder(String newFolderName, String parentFolder) {
        String folderName = null;
        saveToPopup.waitForPageToLoad();
        saveToPopup.waitForPageToLoadAndJQueryProcessing();
        saveToPopup.newFolder().click();
        saveToPopup.waitForPageToLoadAndJQueryProcessing();
        folderName = createNewFolder(newFolderName, parentFolder);
        saveToPopup.waitForPageToLoadAndJQueryProcessing();
        saveToPopup.waitFolderSelected(newFolderName);
        saveToPopup.save().click();
        return folderName;
    }

    private String createNewFolder(String newFolderName, String parentFolder) {
        newFolderPopup.waitForPageToLoad();
        newFolderPopup.waitForPageToLoadAndJQueryProcessing();
        newFolderPopup.newFolderInput().sendKeys(newFolderName);
        if (parentFolder.equals("root")) {
            newFolderPopup.selectRootFolder().click();
            parentFolder = newFolderPopup.selectRootFolder().getText();
        } else {
            newFolderPopup.selectFolder(parentFolder).click();
        }
        newFolderPopup.waitForPageToLoadAndJQueryProcessing();
        newFolderPopup.save().click();
        newFolderPopup.waitForPageToLoadAndJQueryProcessing();
        return parentFolder;
    }

    private void openFolder(String folderName) {
        foldersUtils.openFolder(folderName);
        this.folderName = folderName;
    }

    /**
     * Get list with product names from the product list, which got from Legacy Fatwire
     *
     * @return List with product names
     */
    private List<String> getProductNamesFromXml(List<com.thomsonreuters.pageobjects.utils.document.metadata.Product> products) {
        List<String> result = new ArrayList<>();
        for (com.thomsonreuters.pageobjects.utils.document.metadata.Product product : products) {
            result.add(product.getName());
        }
        return result;
    }

    /**
     * Get list with section titles from the section list, which got from Legacy Fatwire
     *
     * @param sections List with {@link Section}s
     * @return List with section titles
     */
    private List<String> getSectionTitlesFromXml(List<Section> sections) {
        List<String> result = new ArrayList<>();
        for (Section section : sections) {
            result.add(section.getTitle());
        }
        return result;
    }

    /**
     * Get list with jurisdiction names from the jurisdiction list, which got from Legacy Fatwire
     *
     * @param jurisdictions List with {@link Jurisdiction}s
     * @return List with jurisdiction names
     */
    private List<String> getJurisdictionNamesFromXml(List<Jurisdiction> jurisdictions) {
        List<String> result = new ArrayList<>();
        for (Jurisdiction jurisdiction : jurisdictions) {
            result.add(jurisdiction.getName());
        }
        return result;
    }

    private void assertDocumentReadyToDownload() {
        assertTrue("Download button absent", downloadOptionsDialog.getDownloadButtonWhenDocReadyToDownload().isDisplayed());
        assertTrue("Document is not ready to download", downloadOptionsDialog.getReadyForDownloadWindow().getText().contains("ready"));
    }

    private void openSearchResultLinkAtPositionAndStoreItsTitleAndGuid(String linkPosition) throws Throwable {
        searchResultsPage.waitForPageToLoad();
        singleDocument = new Document();
        searchResultsPage.searchResultPosition(linkPosition).click();
        /** The following page object documentTitle is being used to ensure the document has rendered */
        standardDocumentPage.documentTitle().isDisplayed();
        /** Now store the title and guid */
        singleDocument.setTitle(standardDocumentPage.documentTitle().getText());
        singleDocument.setGuid(getDocumentGUIDFromURL());
    }

    private void linkContainsTextAndHrefAttribute(String position, String text, String url) throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        WebElement actualDocument = researchOrganizerPage.getLinkToDocumentAtRowPosition(position);
        String currentText = actualDocument.getText();
        System.out.println("currentText: " + currentText);
        String currentUrl = actualDocument.getAttribute("href");
        System.out.println("currentUrl: " + currentUrl);
        if (!currentUrl.contains(url) || !currentText.contains(text)) {
            throw new RuntimeException("Current url or text is not correct!");
        }
    }

    private String getDocumentGUID() {
        return standardDocumentPage.documentMetaInfo().getAttribute("id").split("_")[3];
    }

    private String getDocumentGUIDFromURL() {
        String urlString[] = getDriver().getCurrentUrl().split("/Document/");
        String guid[] = urlString[1].split("/");
        return guid[0];
    }

    private boolean checkDocumentPresence(String folder) {
        foldersUtils.openFolder(folder);
        researchOrganizerPage.waitForPageToLoad();
        try {
            if (folder.equals("Trash")) {
                researchOrganizerPage.linkToDocumentInTrash(singleDocument.getTitle()).isDisplayed();
            } else {
                researchOrganizerPage.linkToDocument(singleDocument.getGuid(), singleDocument.getTitle()).isDisplayed();
            }
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    /**
     * Get documents with expected Content types
     *
     * @param expectedContentTypes
     * @return List of documents
     */
    private List<Document> getExpectedDisplayedDocument(List<String> expectedContentTypes) {
        List<Document> expectedDocuments = new ArrayList<Document>();
        int expectedDocumentsCount = documents.size();
        for (int i = 0; i < expectedDocumentsCount; i++) {
            Document doc = documents.get(i);
            for (String expectedContentType : expectedContentTypes) {
                if (expectedContentType.equals(doc.getContentType())) {
                    expectedDocuments.add(doc);
                }
            }
        }
        return expectedDocuments;
    }

    private String getClientID() {
        if (currentUser.getProduct() == Product.ANZ) {
            return "PRACTICAL LAW AU";
        }
        return "PRACTICAL LAW";
    }

    /**
     * Select target folder and click "Move" button to move document to it
     *
     * @param folderNames Folder names and target folder name should be passed latest. Root folder name shold be passed
     *                    as first argument "root".
     *                    Example1: there is need to select folder "root/Folder1/Subfolder2/TargetFolder" and in this case
     *                    arguments should be: "root", "Folder1", "Subfolder2", "TargetFolder".
     *                    <p/>
     *                    Example2: there is need to select root folder only. In this case only one argument "root" is
     *                    necessary.
     *                    <p/>
     *                    Example3: root folder already expanded and there is need to select folder "root/Folder1/Subfolder2/TargetFolder"
     *                    and in this case arguments should be: "Folder1", "Subfolder2", "TargetFolder".
     * @return Target folder name (for "root" only it will be as "USER's Research")
     */
    public String moveToFolderAndGetTargetFolderName(String... folderNames) {
        String targetFolderName = folderNames[folderNames.length - 1];
        restoreFromTrashPopup.waitForPageToLoad();
        restoreFromTrashPopup.expandRootFolder();
        if (folderNames.length == 1 && folderNames[0].equals("root")) {
            restoreFromTrashPopup.clickMoveButton();
            return restoreFromTrashPopup.getRootFolderName();
        } else {
            restoreFromTrashPopup.selectFolder(targetFolderName, false, folderNames);
            restoreFromTrashPopup.clickMoveButton();
            return targetFolderName;
        }
    }


}
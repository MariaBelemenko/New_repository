package com.thomsonreuters.should.step_definitions.ffh;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.folders.HistoryTabs;
import com.thomsonreuters.pageobjects.pages.folders.ResearchOrganizerPage;
import com.thomsonreuters.pageobjects.pages.folders.SaveToPopup;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawUKCategoryPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.documentNavigation.DocumentDeliveryPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.pageobjects.pages.widgets.CategoryPage;
import com.thomsonreuters.pageobjects.rest.DocumentBaseUtils;
import com.thomsonreuters.pageobjects.rest.FolderBaseUtils;
import com.thomsonreuters.pageobjects.utils.document.ContentType;
import com.thomsonreuters.pageobjects.utils.document.Document;
import com.thomsonreuters.should.step_definitions.BaseStepDef;
import com.thomsonreuters.should.step_definitions.CommonLoginNaviagtionSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AbilityToHaveFacetedViewColumnOnFoldersTest extends BaseStepDef {

    private FolderBaseUtils restSteps = new FolderBaseUtils();
    private CommonLoginNaviagtionSteps commonLoginNaviagtionSteps = new CommonLoginNaviagtionSteps();
    private CategoryPage categoryPage = new CategoryPage();
    private PracticalLawUKCategoryPage practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();
    private PageActions pageActions = new PageActions();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private DocumentBaseUtils documentBaseUtils = new DocumentBaseUtils();
    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();
    private DocumentDeliveryPage documentDeliveryPage = new DocumentDeliveryPage();
    private ResearchOrganizerPage researchOrganizerPage = new ResearchOrganizerPage();
    private SaveToPopup saveToPopup = new SaveToPopup();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private WLNHeader header = new WLNHeader();
    private CommonMethods comMethods = new CommonMethods();

    private Document singleDocument;
    private java.util.List<Document> documents = new ArrayList<Document>();

    @When("^API cleans all folders and history and user relogs in$")
    public void apiCleansAllFoldersAndHistoryAndUserRelogsIn() throws Throwable {
        restSteps.doSuperDelete();
        commonLoginNaviagtionSteps.userRelogsIn();
    }

    @When("^the user opens '(.+)' link$")
    public void openLink(String linkName) throws Throwable {
        categoryPage.openPageByText(linkName);
    }

    @When("^the user runs a free text search for the query \"(.*)\"$")
    public void theUserRunsAFreeTextSearchForTheQuery(String query) throws Throwable {
        StringSelection stringSelection = new StringSelection(query);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        practicalLawUKCategoryPage.searchButton().isDisplayed();
        practicalLawUKCategoryPage.freeTextField().clear();
        if (query.contains("(") || query.contains(")") || query.contains("&")) {
            clpbrd.setContents(stringSelection, null);
            practicalLawUKCategoryPage.freeTextField().sendKeys(Keys.CONTROL + "v");
        } else {
            practicalLawUKCategoryPage.freeTextField().sendKeys(query);
        }
        if (practicalLawUKCategoryPage.getClass().equals(ChromeDriver.class)) {
            pageActions.keyPress(Keys.ENTER);
        } else {
            practicalLawUKCategoryPage.searchButton().click();
        }
        theUserVerifiesThatTheResultsListPageIsDisplayed();
    }

    @When("^the user verifies that the results list page is displayed$")
    public void theUserVerifiesThatTheResultsListPageIsDisplayed() throws Throwable {
        Robot robot = new Robot();
        robot.delay(5000);
        try {
            searchResultsPage.resultsListHeader().isDisplayed();
            searchResultsPage.filterHeader().isDisplayed();
        } catch (Exception e) {
        }
    }

    @When("^the user waits search result to load$")
    public void waitSearchResults() throws Throwable {
        Thread.sleep(5000);
        searchResultsPage.waitForPageToLoad();
        Thread.sleep(5000);
    }

    @When("^the user opens '(.+)' link in the search result and store its details$")
    public void openDocumentAndSaveDetails(String linkPosition) throws Throwable {
        openSearchResultLinkAtPositionAndStoreItsTitleAndGuid(linkPosition);
        singleDocument.setContentType(ContentType.getContentTypeByMetaInfoName(documentBaseUtils.getDocumentContentType(singleDocument.getGuid())).getPLCUKName());
        documents.add(singleDocument);
    }

    @And("^the user adds current document to \"([^\"]*)\" folder$")
    public void addDocumentToFolderFromDocumentView(String folder) throws Throwable {
        documentDeliveryPage.clickOnAddToFolderLink();
        String folderName = saveToFolder(folder);
        researchOrganizerPage.waitForPageToLoad();
        String message = searchResultsPage.folderingPopupMessage().getText();
        assertEquals("Message is incorrect", singleDocument.getFullTitle() + " saved to '" + folderName + "'.", message);
    }

    @When("^the user come back on to Home page$")
    public void userComeBackOnToHomePage() throws Throwable {
        navigationCobalt.waitForPageToLoad();
        if (!isHomePage()) {
            navigationCobalt.navigateToHomePage();
            navigationCobalt.waitForPageToLoad();
        }
    }

    @When("^the user clicks on '(.+)' link on the header$")
    public void theUserClicksOnLinkOnTheHeader(String linkName) throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        switch (linkName) {
            case "Folders":
                header.foldersLink().click();
                break;
            case "History":
                header.historyLink().click();
                break;
            case "Favourites":
                header.favouritesLink().click();
                break;
            default:
        }
        researchOrganizerPage.waitForPageToLoad();
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
    }

    @When("^the user clicks Select Multiple Filters$")
    public void multipleFilters() throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
        researchOrganizerPage.selectMultipleFilters1();
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
    }

    @When("^the user selects '(.+)' Type$")
    public void selectType(String type) throws Throwable {
        researchOrganizerPage.facetedViewSelectType(type).click();
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
    }

    @When("^the user selects '(.+)' Content type$")
    public void selectContentTypes(String contentType) throws Throwable {
        researchOrganizerPage.facetedViewSelectContentType(contentType).click();
        researchOrganizerPage.waitForPageToLoad();
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
    }

    @When("^the user clicks Apply Filters$")
    public void applyFilters() throws Throwable {
        researchOrganizerPage.applyFilters1().click();
        researchOrganizerPage.waitForPageToLoad();
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^the following documents content type present only$")
    public void checkDocumentsWithContentTypesPresentOnly(List<String> expectedContentTypes) throws Throwable {
        StringBuffer error = new StringBuffer();
        int actualDocumentsCount = researchOrganizerPage.getDocumentCountInFolders();
        List<Document> documentsWithExpectedContentTypes = getExpectedDisplayedDocument(expectedContentTypes);
        int expectedDocumentsCount = documentsWithExpectedContentTypes.size();
        if (actualDocumentsCount != expectedDocumentsCount) {
            error.append("Actual document count is wrong. Expected '" + expectedDocumentsCount + "'. Actual '"
                    + actualDocumentsCount + "'");
        }
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

    @When("^the user clicks Cancel Filters$")
    public void cancelFilters() throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
        WebElement cancel = researchOrganizerPage.cancelFilters1();
        comMethods.mouseOver(cancel);
        cancel.click();
        researchOrganizerPage.waitForPageToLoad();
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
    }

    @When("^the user clicks on '(.+)' tab on the History page$")
    public void theUserClicksOnTabOnHistoryPage(String tabName) throws Throwable {
        HistoryTabs tab = HistoryTabs.valueOf(tabName);
        openHistoryTab(tab);
    }

    @When("^the user selects '(.+)' Client ID$")
    public void selectClientID(String clientID) throws Throwable {
        researchOrganizerPage.facetedViewSelectClientID(clientID).click();
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
    }

    private void openSearchResultLinkAtPositionAndStoreItsTitleAndGuid(String linkPosition) {
        searchResultsPage.waitForPageToLoad();
        singleDocument = new Document();
        searchResultsPage.searchResultPosition(linkPosition).click();
        standardDocumentPage.documentTitle().isDisplayed();
        singleDocument.setTitle(standardDocumentPage.documentTitle().getText());
        singleDocument.setGuid(getDocumentGUIDFromURL());
    }

    private String getDocumentGUIDFromURL() {
        String urlString[] = comMethods.getDriver().getCurrentUrl().split("/Document/");
        String guid[] = urlString[1].split("/");
        return guid[0];
    }

    public String saveToFolder(String folder) {
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
            } catch (org.openqa.selenium.NoSuchElementException e) {
                throw new RuntimeException("Folder '" + folder + "'doesn't present");
            }
        }
        saveToPopup.save().click();
        return folderName;
    }

    private boolean isHomePage() {
        if (!(categoryPage.getCurrentUrl().contains("/Search/Home.html")
                || categoryPage.getCurrentUrl().contains("/Search/BrowseRoot.html") || categoryPage.getCurrentUrl()
                .contains("Home/Home"))) {
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

    protected void openHistoryTab(HistoryTabs tab) {
        researchOrganizerPage.waitForPageToLoad();
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
        WebElement historyTabNonClicked = researchOrganizerPage.findElement(tab.getId());
        WebElement historyTabClicked = researchOrganizerPage.findElement(tab.getIdClickable());
        if (historyTabNonClicked.isDisplayed()) {
            historyTabNonClicked.click();
            researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
        }
        if (historyTabClicked.isDisplayed()) {
            researchOrganizerPage.waitForElementPresent(tab.getPageHeader());
        } else {
            throw new RuntimeException("History tab '" + tab.getName() + "' absent!");
        }
    }

}

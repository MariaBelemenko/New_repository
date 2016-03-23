package com.thomsonreuters.should.step_definitions.ffh;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.folders.NewFolderPopup;
import com.thomsonreuters.pageobjects.pages.folders.ResearchOrganizerPage;
import com.thomsonreuters.pageobjects.pages.folders.SaveToPopup;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.documentNavigation.DocumentDeliveryPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.pageobjects.pages.widgets.CategoryPage;
import com.thomsonreuters.pageobjects.rest.FolderBaseUtils;
import com.thomsonreuters.pageobjects.utils.document.Document;
import com.thomsonreuters.pageobjects.utils.folders.FoldersUtils;
import com.thomsonreuters.should.step_definitions.BaseStepDef;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

public class AbilityToSeeFolderingSignsTest extends BaseStepDef {

    private FolderBaseUtils restSteps = new FolderBaseUtils();
    private FoldersUtils foldersUtils = new FoldersUtils();
    private ResearchOrganizerPage researchOrganizerPage = new ResearchOrganizerPage();
    private NewFolderPopup newFolderPopup = new NewFolderPopup();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private CategoryPage categoryPage = new CategoryPage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();
    private DocumentDeliveryPage documentDeliveryPage = new DocumentDeliveryPage();
    private SaveToPopup saveToPopup = new SaveToPopup();
    private CommonMethods commonMethods = new CommonMethods();

    private Document singleDocument;

    @When("^API cleans all folders and history$")
    public void apiCleansAllFoldersAndHistory() throws Throwable {
        restSteps.doSuperDelete();
    }

    @When("^the user creates new folder \"([^\"]*)\" in \"([^\"]*)\" folder$")
    public void createFolder(String folderName, String parentFolder) throws Throwable {
        foldersUtils.openFolder(parentFolder);
        researchOrganizerPage.createNewFolderButton().click();
        createNewFolder(folderName, parentFolder);
    }

    @Then("^the folder \"([^\"]*)\" appears in the \"([^\"]*)\" folder$")
    public void checkFolderPresent(String folderName, String parentFolder) throws Throwable {
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
        if (!researchOrganizerPage.isFolderPresentInLeftFrame(folderName, parentFolder)) {
            throw new RuntimeException("Folder '" + folderName + "' is absent in '" + parentFolder + "'");
        }
    }

    @When("^the user come back on to WLN Home page$")
    public void userComeBackOnToWLNHomePage() throws Throwable {
        navigationCobalt.waitForPageToLoad();
        if (!isHomePage()) {
            navigationCobalt.navigateToWLNHomePage();
        }
    }

    @When("^the user opens '(.+)' link in the search result and store its title and guid$")
    public void openSearchResultLinkAtPositionAndStore(String linkPosition) throws Throwable {
        openSearchResultLinkAtPositionAndStoreItsTitleAndGuid(linkPosition);
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

    @Then("^the user finds the same document and checks it has got foldered sign$")
    public void checkFolderedSignPresent() throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        assertTrue("Document '" + singleDocument.getTitle() + "' has not got foldered sign", researchOrganizerPage.hasDocumentFolderedSign(singleDocument.getGuid()));
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

    @Then("^the user finds the same document and checks it has not got foldered sign$")
    public void checkFolderedSignAbsent() throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        assertFalse("Document '" + singleDocument.getTitle() + "' has got foldered sign", researchOrganizerPage.hasDocumentFolderedSign(singleDocument.getGuid()));
    }

    public String createNewFolder(String newFolderName, String parentFolder) {
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

    public boolean isHomePage() {
        if (!(categoryPage.getCurrentUrl().contains("/Search/Home.html")
                || categoryPage.getCurrentUrl().contains("/Search/BrowseRoot.html") || categoryPage.getCurrentUrl()
                .contains("Home/Home"))) {
            return false;
        }
        return true;
    }

    private void openSearchResultLinkAtPositionAndStoreItsTitleAndGuid(String linkPosition) throws Throwable {
        searchResultsPage.waitForPageToLoad();
        singleDocument = new Document();
        searchResultsPage.searchResultPosition(linkPosition).click();
        standardDocumentPage.documentTitle().isDisplayed();
        singleDocument.setTitle(standardDocumentPage.documentTitle().getText());
        singleDocument.setGuid(getDocumentGUIDFromURL());
    }

    private String getDocumentGUIDFromURL() {
        String urlString[] = commonMethods.getDriver().getCurrentUrl().split("/Document/");
        String guid[] = urlString[1].split("/");
        return guid[0];
    }

    public String saveToNewFolder(String newFolderName, String parentFolder) {
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

}

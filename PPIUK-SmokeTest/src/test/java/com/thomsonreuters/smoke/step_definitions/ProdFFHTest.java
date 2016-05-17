package com.thomsonreuters.smoke.step_definitions;

import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.pages.folders.*;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.DocumentRightPanelPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.documentNavigation.DocumentDeliveryPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.pageobjects.pages.widgets.CategoryPage;
import com.thomsonreuters.pageobjects.utils.Product;
import com.thomsonreuters.pageobjects.utils.document.Document;
import com.thomsonreuters.pageobjects.utils.folders.FoldersUtils;
import com.thomsonreuters.pageobjects.utils.legalUpdates.CalendarAndDate;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProdFFHTest extends BaseStepDef {

    private ResearchOrganizerPage researchOrganizerPage = new ResearchOrganizerPage();
    private WLNHeader header = new WLNHeader();
    private FoldersUtils foldersUtils = new FoldersUtils();
    private DeleteFolderPopup deleteFolderPopup = new DeleteFolderPopup();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();
    private DocumentDeliveryPage documentDeliveryPage = new DocumentDeliveryPage();
    private NewFolderPopup newFolderPopup = new NewFolderPopup();
    private SaveToPopup saveToPopup = new SaveToPopup();
    private CategoryPage categoryPage = new CategoryPage();
    private FavouritesPage favouritesPage = new FavouritesPage();
    private PageActions pageActions = new PageActions();
    private DocumentRightPanelPage rightPanelPage = new DocumentRightPanelPage();

    private Document singleDocument;
    private List<String> guids;
    private List<String> titles;
    private int documentCount;
    private int counterForDeletionOfFavouritePage;

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
			throw new UnsupportedOperationException(
					"The linkname '"
							+ linkName
							+ "' is undefined. Only Folders, History and Favourites page were identified. Please add your page with expected result");
		}
        researchOrganizerPage.waitForPageToLoad();
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
    }

    @When("^the user deletes the folder \"([^\"]*)\" if it exists$")
    public void userDeleteFolderIfExists(String folderName) throws Throwable {
        deleteFolderIfExists(folderName);
    }

    @When("^the user opens '(.+)' link in the search result and store its title and guid$")
    public void openSearchResultLinkAtPositionAndStore(String linkPosition) throws Throwable {
        openSearchResultLinkAtPositionAndStoreItsTitleAndGuid(linkPosition);
    }

    @And("^the user adds current document to new \"([^\"]*)\" folder with parent folder \"([^\"]*)\"$")
    public void addDocumentToFolderFromDocumentView(String folder, String parentFolder) throws Throwable {
        documentDeliveryPage.clickOnAddToFolderLink();
        saveToNewFolder(folder, parentFolder);
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
        String message = searchResultsPage.folderingPopupMessage().getText();
        assertEquals("Message is incorrect", singleDocument.getTitle() + " saved to '" + folder + "'.", message);
    }

    @Then("^'(.+)' page opens$")
    public void pageOpens(String pageName) throws Throwable {
		switch (pageName) {
		case "Folders":
			String actualFoldersClassAttributeValue = researchOrganizerPage.foldersTab().getAttribute("class");
			assertEquals("Folders tab is not active", researchOrganizerPage.getExpectedClassAttributeValueForTabs(),
					actualFoldersClassAttributeValue);
			break;
		case "History":
			String actualHistoryClassAttributeValue = researchOrganizerPage.historyTab().getAttribute("class");
			assertEquals("History tab is not active", researchOrganizerPage.getExpectedClassAttributeValueForTabs(),
					actualHistoryClassAttributeValue);
			break;
		default:
			throw new UnsupportedOperationException(
					"The pageName '"
							+ pageName
							+ "' is undefined. Only Folders and History page were identified. Please add your page with expected result");
		}
    }

    @Then("^the folder \"([^\"]*)\" appears in the \"([^\"]*)\" folder$")
    public void checkFolderPresent(String folderName, String parentFolder) throws Throwable {
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
        if (!researchOrganizerPage.isFolderPresentInLeftFrame(folderName, parentFolder)) {
            throw new RuntimeException("Folder '" + folderName + "' is absent in '" + parentFolder + "'");
        }
    }

    @Then("^all documents present in the \"([^\"]*)\" folder$")
    public void checkDocuments(String folder) throws Throwable {
        StringBuffer error = new StringBuffer();
        foldersUtils.openFolder(folder);
        researchOrganizerPage.waitForPageToLoad();
        for (int i = 1; i <= documentCount; i++) {
            String guid = guids.get(i - 1);
            String documentName = titles.get(i - 1);
            LOG.info("Check document with name '" + documentName + "' presents");
            try {
                researchOrganizerPage.linkToDocument(guid, documentName).isDisplayed();
            } catch (NoSuchElementException e) {
                error.append("Document is '" + documentName + "' absent\n");
            }
        }
        if (error.length() > 0) {
            throw new RuntimeException(error.toString());
        }
    }

    @When("^the user adds page to favourites group '(.+)'$")
    public void addPageToGroup(String groupName) throws Throwable {
        categoryPage.addToFavourites(groupName);
    }

    @Then("^the user checks that '(.+)' link presents in favourites group '(.+)' on Favourites page$")
    public void checkPagePresentsInFavouritesOnFavouritesPage(String linkName, String groupName) throws Throwable {
        favouritesPage.waitForPageToLoad();
        assertTrue("Favourite page is absent in group '" + groupName + "'",
				favouritesPage.isFavouritePageInGroupPresent(linkName, groupName));
    }

    @When("^the user deletes the favourites group '(.+)'$")
    public void deleteFavoriteGroup(String groupName) throws Throwable {
        favouritesPage.organize().click();
        pageActions.mouseOver(favouritesPage.favouriteGroup(groupName));
        favouritesPage.waitForPageToLoad();
        favouritesPage.deleteFavouriteGroupButton(groupName).click();
        favouritesPage.doneOrganizing().click();
    }

    @When("^the user deletes the favourites page '(.+)'$")
    public void deleteFavoritePage(String pageName) throws Throwable {
        favouritesPage.organize().click();
        pageActions.mouseOver(favouritesPage.pageInFavourite(pageName));
        pageActions.mouseOverAndClickElement(favouritesPage.deletePageFromFavourite(pageName));
        favouritesPage.doneOrganizing().click();
    }

    @When("^the user clicks on the (View Resource History|View Related Content) link on right hand panel$")
    public void theUserClicksOnTheViewLinkOnRightHandPanel(String linkText) throws Throwable {
        if (linkText.equalsIgnoreCase("View Resource History")) {
            rightPanelPage.relatedOrHistoryLink(linkText).click();
        } else if (linkText.equalsIgnoreCase("View Related Content")) {
            rightPanelPage.relatedContentLink().click();
        }
    }

    @Then("^the '(.+)' link contains the document title and guid$")
    public void linkContainsDocumentNameAndGuid(String position) throws Throwable {
        String title = singleDocument.getTitle();
        String guid = singleDocument.getGuid();
        linkContainsTextAndHrefAttribute(position, title, guid);
    }

    @Then("^the '(.+)' link contains event type '(.+)'$")
    public void checkEventType(String position, String eventType) throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        String actualEventType = researchOrganizerPage.getEventTypeAtRowPosition(position).getText();
        assertEquals("Event Type is incorrect", eventType, actualEventType);
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

    @Then("^the '(.+)' link contains text \"([^\"]*)\" and url '(.+)'$")
    public void linkContainsTextAndHref(String position, String text, String url) throws Throwable {
        linkContainsTextAndHrefAttribute(position, text, url);
    }   

    private void deleteFolderIfExists(String folderName) {
        if (foldersUtils.doesFolderExist(folderName)) {
            foldersUtils.openFolder(folderName);
            researchOrganizerPage.optionsButton().click();
            researchOrganizerPage.deleteOptionButton().click();
            researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
            researchOrganizerPage.waitForPageToLoad();
            deleteFolderPopup.clickOK().click();
            deleteFolderPopup.waitForPageToLoad();
            String actualMessage = deleteFolderPopup.getDeletedMessage().getText();
            String expectedMessage = "The contents of '" + folderName + "' were moved to Trash.";
            assertEquals("Message is incorrect", actualMessage, expectedMessage);
            deleteFolderPopup.clickOK().click();
            deleteFolderPopup.waitForPageToLoad();
        }
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
        String urlString[] = searchResultsPage.getCurrentUrl().split("/Document/");
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

    private void linkContainsTextAndHrefAttribute(String position, String text, String url) throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        WebElement actualDocument = researchOrganizerPage.getLinkToDocumentAtRowPosition(position);
        String currentText = actualDocument.getText();
        String currentUrl = actualDocument.getAttribute("href");
        text = foldersUtils.makeDocumentShorterForFoldersAndHistoryChecks(text);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(currentUrl)
                .withFailMessage("Current URL '" + currentUrl + "' does not contain expected '" + url + "'")
                .contains(url);
        softAssertions
                .assertThat(currentText)
                .withFailMessage(
                        "Current document title '" + currentText + "' does not contain expected text '" + text + "'")
                .contains(text);
        softAssertions.assertAll();
    }

    private String getClientID() {
        if (currentUser.getProduct() == Product.ANZ) {
            return "PRACTICAL LAW AU";
        }
        return "PRACTICAL LAW";
    }

}

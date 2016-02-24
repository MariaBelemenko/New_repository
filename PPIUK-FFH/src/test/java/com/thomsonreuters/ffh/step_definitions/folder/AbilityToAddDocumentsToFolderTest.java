package com.thomsonreuters.ffh.step_definitions.folder;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.thomsonreuters.ffh.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.folders.NewFolderPopup;
import com.thomsonreuters.pageobjects.pages.folders.ResearchOrganizerPage;
import com.thomsonreuters.pageobjects.pages.folders.SaveToPopup;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.pageobjects.utils.folders.FoldersUtils;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AbilityToAddDocumentsToFolderTest extends BaseStepDef {

    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private SaveToPopup saveToPopup = new SaveToPopup();
    private ResearchOrganizerPage researchOrganizerPage = new ResearchOrganizerPage();
    private FoldersUtils foldersUtils = new FoldersUtils();
    private NewFolderPopup newFolderPopup = new NewFolderPopup();

    private List<String> guids;
    private List<String> titles;
    private int documentCount;

    @When("^the user selects '(.+)' documents, stores its titles and guids and saves to \"([^\"]*)\" folder$")
    public void selectDocumentsAndSave(String count, String folder) throws Throwable {
        selectDocuments(count);
        searchResultsPage.saveToFolder().click();
        String folderName = saveToFolder(folder);
        searchResultsPage.waitForPageToLoad();
        String message = searchResultsPage.folderingPopupMessage().getText();
        LOG.info(message);
		if (Integer.valueOf(count) > 1) {
			assertEquals("Message is incorrect", count + " of " + count + " items saved to '" + folderName + "'.", message);
		} else {
			assertEquals("Message is incorrect", titles.get(0) + " saved to '" + folderName + "'.", message);
		}
    }

    @When("^the user selects '(.+)' documents, stores its titles and guids and saves to new \"([^\"]*)\" folder with parent folder \"([^\"]*)\"$")
    public void selectDocumentsAndSaveToNewFolder(String count, String folder, String parentFolder) throws Throwable {
        selectDocuments(count);
        searchResultsPage.saveToFolder().click();
        saveToNewFolder(folder, parentFolder);
        searchResultsPage.waitForPageToLoad();
        searchResultsPage.waitForPageToLoadAndJQueryProcessing();
        String message = searchResultsPage.folderingPopupMessage().getText();
        LOG.info(message);
		if (Integer.valueOf(count) > 1) {
			assertEquals("Message is incorrect", count + " of " + count + " items saved to '" + folder + "'.", message);
		} else {
			assertEquals("Message is incorrect", titles.get(0) + " saved to '" + folder + "'.", message);
		}
    }

    @Then("^the user selects '(.+)' documents and checks \"([^\"]*)\" folder is absent in root folder$")
    public void selectDocumentsAndChecksFolderAbsent(String count, String folder) throws Throwable {
        selectDocuments(count);
        searchResultsPage.saveToFolder().click();
        checksFolderAbsent(folder);
    }

    private void selectDocuments(String count) {
        documentCount = Integer.parseInt(count);
        guids = new ArrayList<String>();
        titles = new ArrayList<String>();
        searchResultsPage.waitForPageToLoad();
        for (int i = 1; i <= documentCount; i++) {
            searchResultsPage.searchResultPositionCheckbox(i).click();
            WebElement document = searchResultsPage.searchResultPosition(String.valueOf(i));
            String guid = document.getAttribute("docguid");
            String documentName = document.getText();
            LOG.info("Document guid is '" + guid + "'. Document name is '" + documentName + "'");
            guids.add(guid);
            titles.add(documentName);
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

    private void checksFolderAbsent(String folderName) {
        saveToPopup.waitForPageToLoad();
        saveToPopup.waitForPageToLoad();
        try {
            saveToPopup.expandRootFolder().click();
            saveToPopup.selectFolder(folderName).click();
        } catch (NoSuchElementException e) {
            return;
        }
        throw new RuntimeException("Folder '" + folderName + "' presents");
    }

}

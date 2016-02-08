package com.thomsonreuters.ffh.step_definitions.folder;

import com.thomsonreuters.ffh.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.folders.DeleteFolderPopup;
import com.thomsonreuters.pageobjects.pages.folders.NewFolderPopup;
import com.thomsonreuters.pageobjects.pages.folders.RenameFolderPopup;
import com.thomsonreuters.pageobjects.pages.folders.ResearchOrganizerPage;
import com.thomsonreuters.pageobjects.utils.folders.FoldersUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class AbilityToCreateFolderTest extends BaseStepDef {

    private ResearchOrganizerPage researchOrganizerPage = new ResearchOrganizerPage();
    private NewFolderPopup newFolderPopup = new NewFolderPopup();
    private DeleteFolderPopup deleteFolderPopup = new DeleteFolderPopup();
    private RenameFolderPopup renameFolderPopup = new RenameFolderPopup();
    private FoldersUtils foldersUtils = new FoldersUtils();

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

    @Then("^the user creates new folder \"([^\"]*)\" in \"([^\"]*)\" folder and gets cannot create duplicates error$")
    public void checkCannotCreateDuplicates(String folderName, String parentFolder) throws Throwable {
        foldersUtils.openFolder(parentFolder);
        researchOrganizerPage.createNewFolderButton().click();
        String parentFolderName = createNewFolder(folderName, parentFolder);
        String actualError = newFolderPopup.getErrorMessage().getText();
        String expectedError = "Another '" + folderName + "' cannot be added to '" + parentFolderName + "'";
        assertEquals("Error is incorrect", actualError, expectedError);
        newFolderPopup.clickCancel().click();
        newFolderPopup.waitForPageToLoad();
    }

    @When("^the user deletes the folder \"([^\"]*)\"$")
    public void userDeleteFolder(String folderName) throws Throwable {
        deleteFolder(folderName);
        deleteFolderPopup.clickOK().click();
        deleteFolderPopup.waitForPageToLoad();
        String actualMessage = deleteFolderPopup.getDeletedMessage().getText();
        String expectedMessage = "The contents of '" + folderName + "' were moved to Trash.";
        assertEquals("Message is incorrect", actualMessage, expectedMessage);
        deleteFolderPopup.clickOK().click();
        deleteFolderPopup.waitForPageToLoad();
    }

    @When("^the user deletes the folder \"([^\"]*)\" if it exists$")
    public void userDeleteFolderIfExists(String folderName) throws Throwable {
        deleteFolderIfExists(folderName);
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

    @Then("^the folder \"([^\"]*)\" disappear from \"([^\"]*)\" folder$")
    public void checkFolderDissappears(String folderName, String parentFolder) throws Throwable {
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
        if (researchOrganizerPage.isFolderPresentInLeftFrame(folderName, parentFolder)) {
            throw new RuntimeException("Folder '" + folderName + "' present in '" + parentFolder + "'");
        }
    }

    @When("^the user renames folder \"([^\"]*)\" to \"([^\"]*)\" by double click$")
    public void renameFolderByDoubleClick(String folderName, String newFolderName) throws Throwable {
        renameFolderDoubleClick(folderName);
        renameFolderPopup.waitForPageToLoad();
        renameFolderPopup.renameFolder().clear();
        renameFolderPopup.renameFolder().sendKeys(newFolderName);
        renameFolderPopup.save().click();
        renameFolderPopup.waitForPageToLoad();
    }

    @When("^the user renames folder \"([^\"]*)\" to \"([^\"]*)\"$")
    public void renameFolder(String folderName, String newFolderName) throws Throwable {
        renameFolder(folderName);
        renameFolderPopup.waitForPageToLoad();
        renameFolderPopup.renameFolder().clear();
        renameFolderPopup.renameFolder().sendKeys(newFolderName);
        renameFolderPopup.save().click();
        renameFolderPopup.waitForPageToLoad();
    }

    @Then("^the folder \"([^\"]*)\" with parent folder \"([^\"]*)\" is absent$")
    public void checkFolderAbsent(String folderName, String parentFolder) throws Throwable {
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
        if (researchOrganizerPage.isFolderPresentInLeftFrame(folderName, parentFolder)) {
            throw new RuntimeException("Folder '" + folderName + "' present in '" + parentFolder + "'");
        }
    }

    private void deleteFolder(String folderName) {
        foldersUtils.openFolder(folderName);
        researchOrganizerPage.optionsButton().click();
        researchOrganizerPage.deleteOptionButton().click();
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
        researchOrganizerPage.waitForPageToLoad();
    }

    private void renameFolderDoubleClick(String folderName) {
        researchOrganizerPage.waitForPageToLoad();
        researchOrganizerPage.rootFolderLinkLeftFrame().click();
        researchOrganizerPage.folderLinkLeftFrame(folderName).click();
        researchOrganizerPage.folderLinkLeftFrame(folderName).click();
    }

    private void renameFolder(String folderName) {
        foldersUtils.openFolder(folderName);
        researchOrganizerPage.optionsButton().click();
        researchOrganizerPage.renameOptionButton().click();
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

}
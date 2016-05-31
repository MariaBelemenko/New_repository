package com.thomsonreuters.searchwhatsmarket.step_definitions.whatsMarketSearchResults;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.common.SortOptions;
import com.thomsonreuters.pageobjects.folders.FolderOptionsPage;
import com.thomsonreuters.pageobjects.pages.ask.AskResourcePage;
import com.thomsonreuters.pageobjects.pages.folders.DeleteFolderPopup;
import com.thomsonreuters.pageobjects.pages.folders.NewFolderPopup;
import com.thomsonreuters.pageobjects.pages.folders.ResearchOrganizerPage;
import com.thomsonreuters.pageobjects.pages.folders.SaveToPopup;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.documentNavigation.DocumentDeliveryPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.WhatsMarketComparisonReportPage;
import com.thomsonreuters.pageobjects.pages.search.WhatsMarketSearchResultsPage;
import com.thomsonreuters.pageobjects.utils.folders.FoldersUtils;
import com.thomsonreuters.searchwhatsmarket.step_definitions.BaseStepDef;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

public class WhatsMarketComparisonToolTest extends BaseStepDef {

    private WhatsMarketComparisonReportPage whatsMarketComparisonReportPage = new WhatsMarketComparisonReportPage();
    private WhatsMarketSearchResultsPage whatsMarketSearchResultsPage = new WhatsMarketSearchResultsPage();
    private CommonMethods commonMethods = new CommonMethods();
    private DocumentDeliveryPage documentDeliveryPage = new DocumentDeliveryPage();
    private SaveToPopup saveToPopup = new SaveToPopup();
    private ResearchOrganizerPage researchOrganizerPage = new ResearchOrganizerPage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private NewFolderPopup newFolderPopup = new NewFolderPopup();
    private WLNHeader header = new WLNHeader();
    private FoldersUtils foldersUtils = new FoldersUtils();
    private DeleteFolderPopup deleteFolderPopup = new DeleteFolderPopup();
    private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();
    private AskResourcePage askResourcePage = new AskResourcePage();
    private FolderOptionsPage folderOptionsPage = new FolderOptionsPage();

    @When("^the user ensures that the left hand column select is displayed$")
    public void theUserEnsuresThatTheTheLeftHandColumnIsDisplayed() throws Throwable {
        /** If the toggle isn't already open, then open it */
        whatsMarketComparisonReportPage.menuToggleButton().isDisplayed();
        String returnLink = whatsMarketComparisonReportPage.returnToSearchLink().getText();
        assertTrue(returnLink.contains("Return To"));
        if (!whatsMarketComparisonReportPage.leftHandPaneToggleButtonActive()) {
            whatsMarketComparisonReportPage.menuToggleButton().click();
        }
        whatsMarketComparisonReportPage.leftHandColumnSelect().isDisplayed();
    }

    @When("^the user selects the profile option to display \"([^\"]*)\"$")
    public void theUserSelectsTheProfileOptionToDisplay(String profileName) throws Throwable {
        whatsMarketComparisonReportPage.whatsMarketCheckboxByName(profileName).click();
    }

    @When("^the user verifies the presence of a column entitled \"([^\"]*)\"$")
    public void theUserVerifiesThePresenceOfAColumnEntitled(String arg1) throws Throwable {
        whatsMarketComparisonReportPage.columnHeader(arg1).isDisplayed();
    }

    @When("^the user verifies the presence of the error message You can only compare deals of the same type$")
    public void theUserVerifiesThePresenceOfTheErrorMessageYouCanOnlyCompareDealsOfTheSameType() throws Throwable {
        whatsMarketSearchResultsPage.errorMessage().isDisplayed();
    }

    @When("^the user selects OK$")
    public void theUserSelectsOK() throws Throwable {
        whatsMarketSearchResultsPage.okButton().click();
    }

    @When("^the user selects the option to Select All$")
    public void theUserSelectsTheOptionToSelectAll() throws Throwable {
        whatsMarketComparisonReportPage.selectAllCheckbox().click();
    }

    @When("^the user selects the save option$")
    public void theUserSelectsTheSaveOption() throws Throwable {
        whatsMarketComparisonReportPage.saveReportProfile().click();
    }

    @Then("^the user verifies the presence of a pop up entitled 'Save Report Profile'$")
    public void theUserVerifiesThePresenceOfAPopUpEntitledSaveReportProfile() throws Throwable {
        assertTrue("There is no pop up", whatsMarketComparisonReportPage.newProfilePopUpHeader().isDisplayed());
    }

    @When("^the user enters text into the profile name field \"([^\"]*)\"$")
    public void theUserEntersTextIntoTheProfileNameField(String arg1) throws Throwable {
        whatsMarketComparisonReportPage.profileTextEntryField().sendKeys(arg1);
    }

    @When("^the user selects the save option on the pop up$")
    public void theUserSelectsTheSaveOptionOnThePopUp() throws Throwable {
        whatsMarketComparisonReportPage.saveOptionOnPopUp().click();
        whatsMarketComparisonReportPage.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^the user verifies the absence of a pop up entitled 'Save Report Profile' after saving$")
    public void theUserVerifiesTheAbsenceOfPopUpEntitledSaveReportProfileAfterSaving() throws Throwable {
        assertFalse("Pop up is still displayed", whatsMarketComparisonReportPage.isSaveReportProfilePopUpPresent());
    }

    @When("^the user selects the report profile dropdown$")
    public void theUserSelectsTheReportProfileDropdown() throws Throwable {
        whatsMarketComparisonReportPage.reportProfileDropdown().click();
    }

    @When("^the user selects the report profile entitled \"([^\"]*)\"$")
    public void theUserSelectsTheReportProfileEntitled(String arg1) throws Throwable {
        Select selectedOption = new Select
                (whatsMarketComparisonReportPage.reportProfileDropdown());
        selectedOption.selectByVisibleText(arg1);
    }

    @When("^the user verifies that the report profile dropdown (does|does not) include the profile entitled \"([^\"]*)\"$")
    public void theUserVerifiesThatTheReportProfileDropdownIncludesTheProfileEntitled(String doesDoesNot, String arg1) throws Throwable {
        if (doesDoesNot.equalsIgnoreCase("does")) {
            assertTrue(whatsMarketComparisonReportPage.isReportProfileDropdownOptionDisplayed(arg1));
        } else if (doesDoesNot.equalsIgnoreCase("does not")) {
            assertFalse(whatsMarketComparisonReportPage.isReportProfileDropdownOptionDisplayed(arg1));
        }
    }

    @When("^the user selects the delete option$")
    public void theUserSelectsTheDeleteOption() throws Throwable {
        whatsMarketComparisonReportPage.deleteReportProfile().click();
    }

    @When("^the user verifies the presence of a pop up entitled Delete Report Profile$")
    public void theUserVerifiesThePresenceOfAPopUpEntitledDeleteReportProfile() throws Throwable {
        whatsMarketComparisonReportPage.deleteProfilePopUpHeader().isDisplayed();
    }

    @When("^the user selects the report profile entitled \"([^\"]*)\" on Delete Report Profile popup$")
    public void theUserSelectsTheReportProfileEntitledOnDeleteReportProfilePopup(String arg1) throws Throwable {
        whatsMarketComparisonReportPage.reportProfileOnDeleteProfilePopup(arg1).click();
    }

    @When("^the user selects the delete button on Delete Report Profile popup$")
    public void theUserSelectsTheDeleteButtonOnDeleteReportProfilePopup() throws Throwable {
        whatsMarketComparisonReportPage.deleteButtonOnDeleteProfilePopup().click();
        whatsMarketComparisonReportPage.waitForPageToLoadAndJQueryProcessing();
    }

    @When("^the user verifies the Comparison Terms selector (is|is not) displayed$")
    public void theUserVerifiesTheComparisonTermsSelector(String isIsNot) throws Throwable {
        whatsMarketComparisonReportPage.organizeColumnsButton(isIsNot).isDisplayed();
    }

    @When("^the user selects the menu icon$")
    public void theUserSelectsTheMenuIcon() throws Throwable {
        whatsMarketComparisonReportPage.menuToggleButton().click();
    }

    @When("^the user verifies the absence of a column entitled \"([^\"]*)\"$")
    public void theUserVerifiesTheAbsenceOfAColumnEntitled(String arg1) throws Throwable {
        Boolean isPresent = false;
        try {
            WebElement text = whatsMarketComparisonReportPage.columnHeader(arg1);
            text.isDisplayed();
            isPresent = true;
        } catch (Exception e) {
            LOG.info("context", e);
        }
        assertFalse(isPresent);
    }

    @When("^the user clicks on the column entitled \"(.*?)\"$")
    public void theUserClicksOnTheColumnEntitled(String arg1) throws Throwable {
        whatsMarketComparisonReportPage.columnHeader(arg1).click();
    }

    @Then("^the user verifies the deals are sorted alphabetically by \"(.*?)\"$")
    public void theUserVerifiesTheDealsAreSortedAlphabeticallyBy(String arg1) throws Throwable {
        List<String> deal = whatsMarketComparisonReportPage.getDealComparisonReportDeal();
        assertTrue(commonMethods.isSorted(deal, SortOptions.ASC));
    }

    @Then("^the user verifies the deals are sorted by 'Date administrators appointed'$")
    public void theUserVerifiesTheDealsAreSortedByDateAdministratorsAppointed() throws Throwable {
        List<String> date = whatsMarketComparisonReportPage.getDealComparisonReportDateAdminAppointed();
        assertTrue(commonMethods.isSorted(date, SortOptions.ASC));
    }

    @When("^the user clicks the 'Organize Columns' button on deal comparison report$")
    public void theUserClicksTheOrganizeColumnsButtonOnDealComparisonReport() throws Throwable {
        whatsMarketComparisonReportPage.organizeColumns().click();
    }

    @When("^the user clicks on column \"(.*?)\" on Organize Columns popup$")
    public void theUserClicksOnColumnOnOrganizeColumnsPopup(String arg1) throws Throwable {
        whatsMarketComparisonReportPage.columnOption(arg1).click();
    }

    @When("^the user clicks the \"(.*?)\" button on Organize Columns popup$")
    public void theUserClicksTheButtonOnOrganizeColumnsPopup(String arg1) throws Throwable {
        whatsMarketComparisonReportPage.organizeOptionLink(arg1).click();
    }

    @When("^the user verifies column \"(.*?)\" is in position \"(.*?)\" on Organize Columns popup$")
    public void theUserVerifiesColumnIsInPositionOnOrganizeColumnsPopup(String column, int position) throws Throwable {
        List<String> columns = whatsMarketComparisonReportPage.getColumnsOrganizeColumns();
        assertTrue(columns.get(position - 1).equals(column));
    }

    @When("^the user clicks the 'Save' button on Organize Columns popup$")
    public void theUserClicksTheSaveButtonOnOrganizeColumnsPopup() throws Throwable {
        whatsMarketComparisonReportPage.saveButtonOrganizeColumns().click();
    }

    @When("^the user verifies the Organize Columns popup is closed$")
    public void theUserVerifiesTheOrganizeColumnsPopupIsClosed() throws Throwable {
        Boolean popupPresent = false;
        try {
            whatsMarketComparisonReportPage.organizeColumnsLightBox().isDisplayed();
            popupPresent = true;
        } catch (TimeoutException e) {
            LOG.info("'Orginize Columns' popup is absent", e);
        }
        assertFalse(popupPresent);
    }

    @Then("^the user verifies heading \"(.*?)\" is in column \"(.*?)\" on the Deal Comparison Report$")
    public void theUserVerifiesHeadingIsInColumnOnTheDealComparisonReport(String columnName, Integer position) throws Throwable {
        assertTrue(whatsMarketComparisonReportPage.headerColumns(position).equalsIgnoreCase(columnName));
    }

    @When("^the user clicks the 'Cancel' button on Organize Columns popup$")
    public void theUserClicksTheCancelButtonOnOrganizeColumnsPopup() throws Throwable {
        whatsMarketComparisonReportPage.cancelButtonOrganizeColumns().click();
    }

    @When("^the user clicks the 'Close' button on Organize Columns popup$")
    public void theUserClicksTheCloseButtonOnOrganizeColumnsPopup() throws Throwable {
        whatsMarketComparisonReportPage.closeButtonOrganizeColumns().click();
    }

    @When("^the user clicks the next arrow on deal comparison report$")
    public void theUserClicksTheNextArrowOnDealComparisonReport() throws Throwable {
        whatsMarketComparisonReportPage.nextArrow().click();
    }

    @When("^the user clicks the previous arrow on deal comparison report$")
    public void theUserClicksThePreviousArrowOnDealComparisonReport() throws Throwable {
        whatsMarketComparisonReportPage.previousArrow().click();
    }

    @When("^the user verifies all Comparison Terms checkboxes are checked for Administration deal type$")
    public void theUserVerifiesAllComparisonTermsCheckboxesAreCheckedForAdministrationDealType() throws Throwable {
        assertTrue(whatsMarketComparisonReportPage.selectAllCheckbox().isSelected());
        assertTrue(whatsMarketComparisonReportPage.whatsMarketCheckboxByName("Deal").isSelected());
        assertTrue(whatsMarketComparisonReportPage.whatsMarketCheckboxByName("Company name").isSelected());
        assertTrue(whatsMarketComparisonReportPage.whatsMarketCheckboxByName("Company number").isSelected());
        assertTrue(whatsMarketComparisonReportPage.whatsMarketCheckboxByName("Industry sector").isSelected());
        assertTrue(whatsMarketComparisonReportPage.whatsMarketCheckboxByName("Nature of business").isSelected());
        assertTrue(whatsMarketComparisonReportPage.whatsMarketCheckboxByName("Administrators: firm name").isSelected());
        assertTrue(whatsMarketComparisonReportPage.whatsMarketCheckboxByName("Administrators: individuals").isSelected());
        assertTrue(whatsMarketComparisonReportPage.whatsMarketCheckboxByName("Administrators: location").isSelected());
        assertTrue(whatsMarketComparisonReportPage.whatsMarketCheckboxByName("Ultimate holding company").isSelected());
        assertTrue(whatsMarketComparisonReportPage.whatsMarketCheckboxByName("Related appointments").isSelected());
        assertTrue(whatsMarketComparisonReportPage.whatsMarketCheckboxByName("Related appointments: details").isSelected());
        assertTrue(whatsMarketComparisonReportPage.whatsMarketCheckboxByName("Other points to note").isSelected());
        assertTrue(whatsMarketComparisonReportPage.whatsMarketCheckboxByName("Public documents").isSelected());
    }

    @When("^the user verifies all Comparison Terms checkboxes are unchecked$")
    public void theUserVerifiesAllComparisonTermsCheckboxesAreUnchecked() throws Throwable {
        assertFalse(whatsMarketComparisonReportPage.selectAllCheckbox().isSelected());
        boolean checkboxDisplayed = true;
        try {
            whatsMarketComparisonReportPage.firstDealComparisonTermsCheckedOn().isDisplayed();
        } catch (Exception e) {
            LOG.info("The first 'Deal Comparison Terms' checkbox is absent", e);
            checkboxDisplayed = false;
        }
        assertFalse(checkboxDisplayed);
    }

    @When("^the user clicks the 'clear selected' button$")
    public void theUserClicksTheClearSelectedButton() throws Throwable {
        whatsMarketComparisonReportPage.clearSelected().click();
        whatsMarketComparisonReportPage.waitForPageToLoadAndJQueryProcessing();
    }

    @And("^the user adds whats market deal comparison report to new \"([^\"]*)\" folder with parent folder \"([^\"]*)\"$")
    public void addDocumentToFolderFromDocumentView(String folder, String parentFolder) throws Throwable {
        documentDeliveryPage.clickOnAddToFolderLink();
        /** Use the save button to help determine the pop-up has rendered as the test wasn't waiting before */
        saveToPopup.saveButton().isDisplayed();
        saveToNewFolder(folder, parentFolder);
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
        String message = searchResultsPage.folderingPopupMessage().getText();
        LOG.info(message);
        assertEquals("Message is incorrect", message, "Deal Comparison Report | Administrations | 3 Records saved to '" + folder + "'.");
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

    @Then("^the folder \"([^\"]*)\" appears in the \"([^\"]*)\" folder$")
    public void checkFolderPresent(String folderName, String parentFolder) throws Throwable {
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
        assertTrue("Folder '" + folderName + "' is absent in '" + parentFolder + "'",
                researchOrganizerPage.isFolderPresentInLeftFrame(folderName, parentFolder));

    }

    @Then("^the user verifies the whats market deal comparison report is present in the \"(.*?)\" folder$")
    public void theUserVerifiesTheWhatsMarketDealComparisonReportIsPresentInTheFolder(String folder) throws Throwable {
        foldersUtils.openFolder(folder);
        folderOptionsPage.folderDocumentLink("Deal Comparison Report | Administrations | 3 Records").isDisplayed();
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

    @When("^the user selects the download icon on the comparison report page$")
    public void theUserSelectsTheDownloadIconOnTheComparisonReportPage() throws Throwable {
        whatsMarketComparisonReportPage.downloadIcon().click();
    }

    @When("^the user verifies the presence of a pop up entitled '(Download Report|Email Report)'$")
    public void theUserVerifiesThePresenceOfAPopUpEntitledDownloadReport(String header) throws Throwable {
        whatsMarketComparisonReportPage.downloadEmailReportPopUpHeader(header).isDisplayed();
    }

    @When("^the user verifies the presence of a dropdown entitled Format$")
    public void theUserVerifiesThePresenceOfADropdownEntitledFormat() throws Throwable {
        assertTrue(searchResultsPage.formatDropdownDocuments().isDisplayed());
    }

    @When("^the user selects the format option entitled \"([^\"]*)\"$")
    public void theUserVSelectsTheFormatOptionEntitled(String arg1) throws Throwable {
        searchResultsPage.formatDropdownOptionDocuments(arg1).click();
    }

    @When("^the user click on download button$")
    public void theUserClickOnDownloadButton() throws Throwable {
        assetDocumentPage.downloadButton().click();
    }

    @Then("^the user verifies that '(Ready For Email|Ready For Download|Preparing For Print|Preparing For Email|Preparing For Download)' is displayed on the overlay$")
    public void theUserVerifiesThatReadyForEmailIsDisplayOnOverlay(String header) throws Throwable {
            WebElement overlayHeader = (header.contains("Ready")) ? askResourcePage.readyMessageOverlayHeader()
                : askResourcePage.prepareMessageOverlayHeader();
        assertTrue("The " + header + " is NOT displayed", overlayHeader.isDisplayed());

    }

    @When("^the user verifies 'Download' button is displayed on Ready For Download overlay$")
    public void theUserVerifiesDownloadButtonIsDisplayedOnReadyForDownloadOverlay() throws Throwable {
        askResourcePage.downloadInReadyForDownloadOverlayButton().isDisplayed();
    }

    @When("^the user selects the Email icon on the comparison report page$")
    public void theUserSelectsTheEmailIconOnTheComparisonReportPage() throws Throwable {
        whatsMarketComparisonReportPage.emailIcon().click();
    }

    @When("^the user verifies the presence of the following comparison options")
    public void theUserVerifiesThePresenceOfTheFollowingComparisonOptions(List<String> optionList) throws Throwable {
        for (String option : optionList) {
            whatsMarketComparisonReportPage.comparisonTermsOptions(option).isDisplayed();
        }
    }

    @When("^the user verifies the presence of a 'Back To Search Results' button$")
    public void theUserVerifiesThePresenceOfABackToSearchResultsButton() throws Throwable {
        whatsMarketComparisonReportPage.returnToSearchResultsLink().isDisplayed();
    }

    @When("^the user clicks the 'Back To Search Results' button$")
    public void theUserClicksTheBackToSearchResultsButton() throws Throwable {
        whatsMarketComparisonReportPage.returnToSearchResultsLink().click();
        whatsMarketComparisonReportPage.waitForPageToLoadAndJQueryProcessing();
    }

    @When("^the user verifies the checkbox associated with whats market result \"([^\"]*)\" is checked$")
    public void theUserVerifiesTheCheckboxAssociatedWithWhatsMarketResultIsChecked(String arg1) throws Throwable {
        searchResultsPage.resultCheckboxWhatsMarket(arg1).isSelected();
    }

    @When("^the user selects the select all option on the results page$")
    public void theUserSelectsTheSelectAllOptionOnTheResultsPage() throws Throwable {
        searchResultsPage.selectAllCheckbox().click();
    }

    @When("^the user selects the home node icon$")
    public void theUserSelectsTheHomeNodeIcon() throws Throwable {
        whatsMarketComparisonReportPage.homeNode().click();
    }

    @When("^the user verifies that the comparison option \"(.*?)\" is still selected$")
    public void theUserVerifiesThatTheComparisonOptionIsStillSelected(String arg1) throws Throwable {
        whatsMarketComparisonReportPage.whatsMarketCheckboxByName(arg1).isSelected();
    }

    private String saveToNewFolder(String newFolderName, String parentFolder) {
        String folderName = null;
        saveToPopup.newFolder().click();
        folderName = createNewFolder(newFolderName, parentFolder);
        saveToPopup.waitFolderSelected(newFolderName);
        saveToPopup.save().click();
        return folderName;
    }

    public String createNewFolder(String newFolderName, String parentFolder) {
        newFolderPopup.newFolderInput().sendKeys(newFolderName);
        if (parentFolder.equals("root")) {
            newFolderPopup.selectRootFolder().click();
            parentFolder = newFolderPopup.selectRootFolder().getText();
        } else {
            newFolderPopup.selectFolder(parentFolder).click();
        }
        newFolderPopup.save().click();
        return parentFolder;
    }

    private void deleteFolder(String folderName) {
        foldersUtils.openFolder(folderName);
        researchOrganizerPage.optionsButton().click();
        researchOrganizerPage.deleteOptionButton().click();
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
        researchOrganizerPage.waitForPageToLoad();
    }

    @Then("^the user deletes the report profile \"([^\"]*)\" from dropdown if it exists$")
    public void userDeleteReportProfileIfExists(String arg1) throws Throwable {
        if (whatsMarketComparisonReportPage.isReportProfileDropdownOptionDisplayed(arg1)) {
            whatsMarketComparisonReportPage.deleteReportProfile().click();
            whatsMarketComparisonReportPage.reportProfileOnDeleteProfilePopup(arg1).click();
            whatsMarketComparisonReportPage.deleteButtonOnDeleteProfilePopup().click();
            whatsMarketComparisonReportPage.waitForPageToLoadAndJQueryProcessing();
        }
        assertFalse("The report profile " + arg1 + " still exist", whatsMarketComparisonReportPage.isReportProfileDropdownOptionDisplayed(arg1));
    }
}

package com.thomsonreuters.searchknowhow.step_definitions.knowHowDelivery;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawUKCategoryPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.searchknowhow.step_definitions.BaseStepDef;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KnowHowDeliveryTest extends BaseStepDef {

    private PracticalLawUKCategoryPage practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();
    private PageActions pageActions = new PageActions();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private CommonMethods commonMethods = new CommonMethods();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();

    Integer[] resultArray = new Integer[10];

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

    @When("^the user selects the checkbox associated with result \"([^\"]*)\"$")
    public void theUserSelectsTheCheckboxAssociatedWithResult(String arg1) throws Throwable {
        searchResultsPage.resultCheckbox(arg1).click();
    }

    @When("^the user selects the download delivery option$")
    public void theUserSelectsTheDownloadDeliveryOption() throws Throwable {
        searchResultsPage.downloadDeliveryIcon().click();
    }

    @Then("^the user pauses for \"(.*?)\" seconds$")
    public void theUserPausesForSeconds(Integer timeToWait) throws Throwable {
        Robot robot = new Robot();
        timeToWait = timeToWait * 1000;
        robot.delay(timeToWait);
    }

    @When("^the user verifies the presence of a pop up entitled Download Documents$")
    public void theUserVerifiesThePresenceOfAPopUpEntitledDownloadDocuments() throws Throwable {
        assertTrue(searchResultsPage.downloadDocumentsPopUp().isDisplayed());
    }

    @When("^the user verifies the presence of a basic tab$")
    public void theUserVerifiesThePresenceOfABasicTab() throws Throwable {
        assertTrue(searchResultsPage.basicTab().isDisplayed());
    }

    @When("^the user verifies that the basic option is selected by default$")
    public void theUserVerifiesThatTheBasicOptionIsSelectedByDefault() throws Throwable {
        assertTrue(searchResultsPage.whatToDeliverHeader().isDisplayed());
    }

    @When("^the user verifies the presence of an option entitled List of Items$")
    public void theUserVerifiesThePresenceOfAnOptionEntitledListOfItems() throws Throwable {
        assertTrue(searchResultsPage.listOfItemsOption().isDisplayed());
    }

    @When("^the user verifies the presence of an option on the pop up entitled Documents$")
    public void verifyPresenceOfOptionOnPopUpTitledDocuments() throws Throwable {
        assertTrue(searchResultsPage.documentsOption().isDisplayed());
    }

    @When("^the user selects the list of items option$")
    public void theUserSelectsTheListOfItemsOption() throws Throwable {
        Boolean isSelected = true;
        if (!searchResultsPage.listOfItemsOption().isSelected()) {
            searchResultsPage.listOfItemsOption().click();
        }
    }

    @When("^the user verifies the presence of a list of items dropdown option entitled Format$")
    public void theUserVerifiesThePresenceOfAListOfItemsDropdownOptionEntitledFormat() throws Throwable {
        assertTrue(searchResultsPage.formatDropdownList().isDisplayed());
    }

    @When("^the user verifies the presence of a list of items format option entitled$")
    public void theUserVerifiesThePresenceOfAListOfItemsFormatOptionEntitled(DataTable table) throws Throwable {
        java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
        searchResultsPage.formatDropdownList().click();
        searchResultsPage.formatDropdownOptionList(data.get(0).get("formatOption")).isDisplayed();
        searchResultsPage.formatDropdownOptionList(data.get(1).get("formatOption")).isDisplayed();
        searchResultsPage.formatDropdownOptionList(data.get(2).get("formatOption")).isDisplayed();
        searchResultsPage.formatDropdownOptionList(data.get(3).get("formatOption")).isDisplayed();
    }

    @When("^the user verifies the presence of a Download option$")
    public void theUserVerifiesThePresenceOfADownloadOption() throws Throwable {
        assertTrue(searchResultsPage.downloadButton().isDisplayed());
    }

    @When("^the user verifies the presence of a Cancel option$")
    public void theUserVerifiesThePresenceOfACancelOption() throws Throwable {
        assertTrue(searchResultsPage.cancelButton().isDisplayed());
    }

    @When("^the user selects the Documents option$")
    public void theUserSelectsTheDocumentsOption() throws Throwable {
        if (!searchResultsPage.documentsOption().isSelected()) {
            searchResultsPage.documentsOption().click();
        }
    }

    @When("^the user verifies the presence of a checkbox for inclusion of table of contents$")
    public void theUserVerifiesThePresenceOfACheckboxForInclusionOfTableOfContents() throws Throwable {
        searchResultsPage.tableOfContentsOption().isDisplayed();
    }

    @When("^the user verifies the presence of a dropdown option entitled As$")
    public void theUserVerifiesThePresenceOfADropdownOptionEntitledAs() throws Throwable {
        assertTrue(searchResultsPage.asDropdown().isDisplayed());
    }

    @When("^the user verifies the presence of an option entitled \"([^\"]*)\"$")
    public void theUserVerifiesThePresenceOfAnOptionEntitled(String arg1) throws Throwable {
        searchResultsPage.asDropdown().click();
        searchResultsPage.asDropdownOption(arg1).isDisplayed();
    }

    @When("^the user selects the option entitled documents$")
    public void theUserSelectsTheOptionEntitledDocuments() throws Throwable {
        searchResultsPage.documentsOption().click();
    }

    @When("^the user selects the link to the advanced tab$")
    public void theUserSelectsTheLinkToTheAdvancedTab() throws Throwable {
        searchResultsPage.advancedTab().click();
    }

    @When("^the user verifies the presence of an option entitled Term Highlighting$")
    public void theUserVerifiesThePresenceOfAnOptionEntitledTermHighlighting() throws Throwable {
        searchResultsPage.termHighlightingCheckbox().isDisplayed();
    }

    @When("^the user verifies that the option entitled Term Highlighting is selected by default$")
    public void theUserVerifiesThatTheOptionEntitledTermHighlightingIsSelectedByDefault() throws Throwable {
        searchResultsPage.termHighlightingCheckbox().isSelected();
    }

    @When("^the user verifies the presence of an option entitled Expanded Margin for Notes$")
    public void theUserVerifiesThePresenceOfAnOptionEntitledExpandedMarginForNotes() throws Throwable {
        searchResultsPage.expandedMarginCheckbox().isDisplayed();
    }

    @When("^the user verifies the presence of an option entitled Cover Page$")
    public void theUserVerifiesThePresenceOfAnOptionEntitledCoverPage() throws Throwable {
        searchResultsPage.coverPageCheckbox().isDisplayed();
    }

    @When("^the user selects the option entitled Cover Page$")
    public void theUserSelectsTheOptionEntitledCoverPage() throws Throwable {
        searchResultsPage.coverPageCheckbox().click();
    }

    @When("^the user verifies the presence of a field entitled Cover Page Note$")
    public void theUserVerifiesThePresenceOfAFieldEntitledCoverPageNote() throws Throwable {
        searchResultsPage.coverPageField().isDisplayed();
    }

    @When("^the user verifies the presence of a dropdown entitled Font Size$")
    public void theUserVerifiesThePresenceOfADropdownEntitledFontSize() throws Throwable {
        searchResultsPage.fontSizeDropdown().isDisplayed();
    }

    @When("^the user verifies the presence of a font sub option \"([^\"]*)\"$")
    public void theUserVerifiesThePresenceOfAFontSubOption(String arg1) throws Throwable {
        searchResultsPage.fontSizeDropdownOption(arg1).isDisplayed();
    }

    @When("^the user verifies the presence of a dropdown entitled Links$")
    public void theUserVerifiesThePresenceOfADropdownEntitledLinks() throws Throwable {
        searchResultsPage.linksDropdown().isDisplayed();
    }

    @When("^the user verifies the presence of a links sub option \"([^\"]*)\"$")
    public void theUserVerifiesThePresenceOfALinksSubOption(String arg1) throws Throwable {
        searchResultsPage.linksDropdownOption(arg1).isDisplayed();
    }

    @When("^the user verifies the presence of a checkbox entitled Underline$")
    public void theUserVerifiesThePresenceOfACheckboxEntitledUnderline() throws Throwable {
        searchResultsPage.underlineCheckbox().isDisplayed();
    }

    @When("^the user selects the Basic tab$")
    public void theUserSelectsTheBasicTab() throws Throwable {
        searchResultsPage.basicTab().click();
    }

    @When("^the user selects the advanced tab$")
    public void theUserSelectsTheAdvancedTab() throws Throwable {
        searchResultsPage.advancedTab().click();
    }

    @When("^the user verifies that the option entitled Expanded Margin for Notes is no longer present$")
    public void theUserVerifiesThatTheOptionEntitledExpandedMarginForNotesIsNoLongerPresent() throws Throwable {
        Boolean isPresent = false;
        try {
            searchResultsPage.expandedMarginCheckbox().isDisplayed();
            isPresent = true;
        } catch (Exception e) {
        }
        assertFalse(isPresent);
    }

    @When("^the user selects the list of items format option \"([^\"]*)\"$")
    public void theUserSelectsTheFormatOption(String arg1) throws Throwable {
        Select option = new Select(searchResultsPage.formatDropdownList());
        option.selectByVisibleText(arg1);
    }

    @When("^the user selects the Download option$")
    public void theUserSelectsTheDownloadOption() throws Throwable {
        searchResultsPage.downloadButton().click();
    }

    @When("^the user verifies that the request is processed and a message displayed that the items are ready to download$")
    public void theUserVerifiesThatTheRequestIsProcessedAndAMessageDisplayedThatTheItemsAreReadyToDownload() throws Throwable {
        searchResultsPage.downloadReadyMessage().isDisplayed();
    }

    @When("^the user selects the documents format option \"([^\"]*)\"$")
    public void theUserSelectsTheDocumentsFormatOption(String arg1) throws Throwable {
        Select option = new Select(searchResultsPage.formatDropdownDocuments());
        option.selectByVisibleText(arg1);
    }

    @When("^the user selects the email delivery option$")
    public void theUserSelectsTheEmailDeliveryOption() throws Throwable {
        searchResultsPage.emailDeliveryIcon().click();
    }

    @When("^the user verifies the presence of a pop up entitled Email Documents$")
    public void theUserVerifiesThePresenceOfAPopUpEntitledEmailDocuments() throws Throwable {
        assertTrue(searchResultsPage.emailDocumentsPopUp().isDisplayed());
    }

    @When("^the user verifies the presence of a field entitled To$")
    public void theUserVerifiesThePresenceOfAFieldEntitledTo() throws Throwable {
        searchResultsPage.emailToField().isDisplayed();
    }

    @When("^the user verifies the presence of a field entitled Subject$")
    public void theUserVerifiesThePresenceOfAFieldEntitledSubject() throws Throwable {
        searchResultsPage.emailSubjectField().isDisplayed();
    }

    @When("^the user verifies the presence of a field entitled Email Note$")
    public void theUserVerifiesThePresenceOfAFieldEntitledEmailNote() throws Throwable {
        searchResultsPage.emailNoteField().isDisplayed();
    }

    @When("^the user verifies the presence of an Email option$")
    public void theUserVerifiesThePresenceOfAnEmailOption() throws Throwable {
        searchResultsPage.emailButton().isDisplayed();
    }

    @When("^the user verifies the presence of an As option entitled \"([^\"]*)\"$")
    public void theUserVerifiesThePresenceOfAnAsOptionEntitled(String arg1) throws Throwable {
        searchResultsPage.asDropdownOption(arg1).isDisplayed();
    }

    @When("^the user enters \"([^\"]*)\" into the email To field$")
    public void theUserEntersIntoTheEmailToField(String arg1) throws Throwable {
        searchResultsPage.emailToField().clear();
        searchResultsPage.emailToField().sendKeys(arg1);
    }

    @When("^the user enters \"([^\"]*)\" into the email Subject field$")
    public void theUserEntersIntoTheEmailSubjectField(String arg1) throws Throwable {
        searchResultsPage.emailSubjectField().clear();
        searchResultsPage.emailSubjectField().sendKeys(arg1);
    }

    @When("^the user enters \"([^\"]*)\" into the email note field$")
    public void theUserEntersIntoTheEmailNoteField(String arg1) throws Throwable {
        searchResultsPage.emailNoteField().sendKeys(arg1);
    }

    @When("^the user selects the Email option$")
    public void theUserSelectsTheEmailOption() throws Throwable {
        searchResultsPage.emailButton().click();
    }

    @When("^the user selects the print delivery option$")
    public void theUserSelectsThePrintDeliveryOption() throws Throwable {
        searchResultsPage.printDeliveryIcon().click();
    }

    @When("^the user verifies the presence of a pop up entitled Print Documents$")
    public void theUserVerifiesThePresenceOfAPopUpEntitledPrintDocuments() throws Throwable {
        commonMethods.acceptDialogIfAppears();
        searchResultsPage.printDocumentsPopUp().isDisplayed();
    }

    @When("^the user verifies the presence of a Print option$")
    public void theUserVerifiesThePresenceOfAPrintOption() throws Throwable {
        searchResultsPage.printButton().isDisplayed();
    }

    @When("^the user verifies the presence of the Print delivery request button$")
    public void theUserVerifiesThePresenceOfThePrintDeliveryRequestButton() throws Throwable {
        searchResultsPage.printButton().isDisplayed();
    }

    @When("^the user checks the attribute for the print dialog$")
    public void theUserChecksTheAttributeForThePrintDialog() throws Throwable {
        String text = searchResultsPage.printButton().getAttribute("onclick");
        assertTrue(text.contains("Cobalt.Delivery.DeliveryOptionsDialog.Instance().SubmitAndCloseForm(false)"));
    }

    @When("^the user verifies that a pop up entitled Download This Document is displayed to the user$")
    public void theUserVerifiesThatAPopUpEntitledDownLoadThisDocumentIsDisplayedToTheUser() throws Throwable {
        searchResultsPage.downloadSingleDocumentPopUp().isDisplayed();
    }

    @When("^the user verifies that the single request is processed and a message displayed that the items are ready to download$")
    public void theUserVerifiesThatTheSingleRequestIsProcessedAndAMessageDisplayedThatTheItemsAreReadyToDownload() throws Throwable {
        searchResultsPage.downloadSingleDocReadyMessage().isDisplayed();
    }

    @When("^the user selects the print option$")
    public void theUserSelectsThePrintOption() throws Throwable {
        searchResultsPage.printButton().click();
    }

}

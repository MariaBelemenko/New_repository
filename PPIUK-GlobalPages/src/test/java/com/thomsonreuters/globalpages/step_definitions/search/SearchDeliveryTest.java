package com.thomsonreuters.globalpages.step_definitions.search;

import com.thomsonreuters.globalpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.common.SortOptions;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawUKCategoryPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.awt.*;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class SearchDeliveryTest extends BaseStepDef {

    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private CommonMethods commonMethods = new CommonMethods();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private PracticalLawUKCategoryPage practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();

    private List<String> actualSuggestions;
    private String searchTerm;

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

    @When("^the user verifies the presence of a dropdown option entitled As$")
    public void theUserVerifiesThePresenceOfADropdownOptionEntitledAs() throws Throwable {
        assertTrue(searchResultsPage.asDropdown().isDisplayed());
    }

    @When("^the user verifies the presence of an option entitled \"([^\"]*)\"$")
    public void theUserVerifiesThePresenceOfAnOptionEntitled(String arg1) throws Throwable {
        searchResultsPage.asDropdown().click();
        searchResultsPage.asDropdownOption(arg1).isDisplayed();
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

    @When("^the user verifies the presence of a checkbox for inclusion of table of contents$")
    public void theUserVerifiesThePresenceOfACheckboxForInclusionOfTableOfContents() throws Throwable {
        searchResultsPage.tableOfContentsOption().isDisplayed();
    }

    @When("^the user verifies the presence of an As option entitled \"([^\"]*)\"$")
    public void theUserVerifiesThePresenceOfAnAsOptionEntitled(String arg1) throws Throwable {
        searchResultsPage.asDropdownOption(arg1).isDisplayed();
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

    @Then("^the user should be presented with the below search suggestions$")
    public void theUserShouldBePresentedWithTheBelowSearchSuggestions(java.util.List<String> expectedSuggestions) {
        actualSuggestions = knowHowSearchResultsPage.getSearchSuggestions();
        for (String suggestion : expectedSuggestions) {
            assertTrue(actualSuggestions.contains(suggestion.toUpperCase()));
        }
    }

    @Then("^the suggested search terms are displayed in alphabetical order$")
    public void theUserShouldBePresentedWithTheSearchSuggestionsInAlphabeticalOrder() {
        assertTrue(commonMethods.isSorted(actualSuggestions, SortOptions.ASC));
    }

    @When("^the user selects the suggested term \"(.*?)\"$")
    public void theUserSelectsTheSuggestedTerm(String arg1) throws Throwable {
        practicalLawUKCategoryPage.suggestedTerm(arg1).click();
        knowHowSearchResultsPage.waitForSearchResults();
        searchTerm = arg1;
    }

    @When("^the user verifies that the term \"(.*?)\" appears in the search box$")
    public void theUserVerifiesThatTheTermAppearsInTheSearchBox(String arg1) throws Throwable {
        assertTrue(practicalLawUKCategoryPage.freeTextField().getAttribute("value").equals(arg1));
    }

}

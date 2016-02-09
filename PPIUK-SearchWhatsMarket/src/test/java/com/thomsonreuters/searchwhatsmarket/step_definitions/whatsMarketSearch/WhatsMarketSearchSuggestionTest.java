package com.thomsonreuters.searchwhatsmarket.step_definitions.whatsMarketSearch;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.common.SortOptions;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawUKCategoryPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowDocumentPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.WhatsMarketSearchResultsPage;
import com.thomsonreuters.searchwhatsmarket.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class WhatsMarketSearchSuggestionTest extends BaseStepDef {

    private PracticalLawUKCategoryPage practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private CommonMethods commonMethods = new CommonMethods();
    private WhatsMarketSearchResultsPage whatsMarketSearchResultsPage = new WhatsMarketSearchResultsPage();
    private KnowHowDocumentPage knowHowDocumentPage = new KnowHowDocumentPage();

    private List<String> actualSuggestions;
    private String searchTerm;

    @When("^the user enters (\\d+) characters into the search box \"(.*?)\"$")
    public void theUserEntersCharactersIntoTheSearchBox(int arg1, String arg2) throws Throwable {
        practicalLawUKCategoryPage.freeTextField().sendKeys(arg2);
    }

    @Then("^the user should be presented with the below search suggestions$")
    public void theUserShouldBePresentedWithTheBelowSearchSuggestions(List<String> expectedSuggestions) {
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

    @Then("^the user edits the text of the suggested search term and add additional text \"(.*?)\"$")
    public void theUserEditsTheTextOfTheSuggestedSearchTermAndAddAdditionalText(String arg1) throws Throwable {
        practicalLawUKCategoryPage.freeTextField().sendKeys(" " + arg1);
    }

    @Then("^the user can submit the search request$")
    public void theUserCanSubmitTheSearchRequest() throws Throwable {
        practicalLawUKCategoryPage.searchButton().click();
        knowHowSearchResultsPage.waitForSearchResults();
    }

    @Then("^the user can open the first whats market search result \"(.*?)\"$")
    public void theUserCanOpenTheFirstWhatsMarketSearchResult(String arg1) throws Throwable {
        whatsMarketSearchResultsPage.whatsMarketSearchResultTitle(arg1).click();
    }

    @Then("^the user can verify that the full text of the know how document contains the search terms \"(.*?)\" and \"(.*?)\"$")
    public void theUserCanVerifyThatTheFullTextOfTheKHDocumentContainsTheSearchTermsAnd(String firstTerm, String secondTerm) throws Throwable {
        String docText = null;
        docText = knowHowDocumentPage.getFullText().toLowerCase();
        for (String term : firstTerm.toLowerCase().split(" ")) {
            assertTrue(docText.contains(term));
        }
        for (String term : secondTerm.toLowerCase().split(" ")) {
            assertTrue(docText.contains(term));
        }
    }

}

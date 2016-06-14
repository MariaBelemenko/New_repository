package com.thomsonreuters.searchknowhow.step_definitions.knowHowSearch;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.common.SortOptions;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawUKCategoryPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchSearch.BaseResultsPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowDocumentPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchHomePage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.pageobjects.utils.search.SearchUtils;
import com.thomsonreuters.searchknowhow.step_definitions.BaseStepDef;
import com.thoughtworks.selenium.SeleneseTestBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KnowHowSearchSuggestionsTest extends BaseStepDef {

    private PracticalLawUKCategoryPage practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private CommonMethods commonMethods = new CommonMethods();
    private KnowHowDocumentPage knowHowDocumentPage = new KnowHowDocumentPage();
    private SearchHomePage searchHomePage = new SearchHomePage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private SearchUtils searchUtils = new SearchUtils();
    private BaseResultsPage baseResultPage = new BaseResultsPage();

    private List<String> actualSuggestions;
    private String searchTerm;

    @When("^the user enters (\\d+) characters into the search box \"(.*?)\"$")
    public void theUserEntersCharactersIntoTheSearchBox(int arg1, String arg2) throws Throwable {
        practicalLawUKCategoryPage.freeTextField().sendKeys(arg2);
    }

    @Then("^the user should be presented with the below search suggestions$")
    public void theUserShouldBePresentedWithTheBelowSearchSuggestions(List<String> expectedSuggestions) throws Throwable {
        actualSuggestions = knowHowSearchResultsPage.getSearchSuggestions();
        for (String suggestion : expectedSuggestions) {
            assertTrue(actualSuggestions.contains(suggestion.toUpperCase()));
        }
    }

    @And("^the suggested search terms are displayed in alphabetical order$")
    public void theUserShouldBePresentedWithTheSearchSuggestionsInAlphabeticalOrder() throws Throwable {
        assertTrue(commonMethods.isSorted(actualSuggestions, SortOptions.ASC));
    }

    @When("^the user selects the suggested term \"(.*?)\"$")
    public void theUserSelectsTheSuggestedTerm(String arg1) throws Throwable {
        practicalLawUKCategoryPage.suggestedTerm(arg1).click();
        knowHowSearchResultsPage.waitForSearchResults();
        searchTerm = arg1;
    }

    @Then("^the user verifies that the term \"(.*?)\" appears in the search box$")
    public void theUserVerifiesThatTheTermAppearsInTheSearchBox(String arg1) throws Throwable {
        assertTrue(practicalLawUKCategoryPage.freeTextField().getAttribute("value").equals(arg1));
    }

    @When("^the user edits the text of the suggested search term and add additional text \"(.*?)\"$")
    public void theUserEditsTheTextOfTheSuggestedSearchTermAndAddAdditionalText(String arg1) throws Throwable {
        practicalLawUKCategoryPage.freeTextField().sendKeys(" " + arg1);
    }

    @And("^the user can submit the search request$")
    public void theUserCanSubmitTheSearchRequest() throws Throwable {
        practicalLawUKCategoryPage.searchButton().click();
        knowHowSearchResultsPage.waitForSearchResults();
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

    @Then("^the user should not be presented with the below search suggestions$")
    public void theUserShouldNotBePresentedWithTheBelowSearchSuggestions(List<String> expectedSuggestions) throws Throwable {
        actualSuggestions = knowHowSearchResultsPage.getSearchSuggestions();
        for (String suggestion : expectedSuggestions) {
            assertFalse(actualSuggestions.contains(suggestion.toUpperCase()));
        }
    }

    @When("^the user starts typing the term \"(.*?)\"$")
    public void theUserStartTypingThe(String term) throws Throwable {
        searchHomePage.enterSearchText(term);
    }

    @Then("^the user should see auto suggestion list$")
    public void theUserShouldSeeAutoSuggestionList() throws Throwable {
        SeleneseTestBase.assertTrue("Auto suggestion list is absent", searchHomePage.suggestionList().isDisplayed());
    }

    @Then("^the search results should be shown according to the search term selected$")
    public void theSearchResultShouldBeShownAccordingToTheSearchTermSelected() throws Throwable {
        searchResultsPage.moreOrLessDetailAnchor().click();
        searchResultsPage.moreDetailOption().click();
        assertTrue("One of results does not contains search term '" + searchTerm + "'",
                searchUtils.isEveryResultContains(baseResultPage.getResultListWithFullText(), Arrays.asList(searchTerm.split("\\s+"))));
    }

}

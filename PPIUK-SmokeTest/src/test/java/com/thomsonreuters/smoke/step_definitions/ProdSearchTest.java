package com.thomsonreuters.smoke.step_definitions;

import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawUKCategoryPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchSearch.BaseResultsPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchHomePage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.pageobjects.utils.search.SearchUtils;
import com.thoughtworks.selenium.SeleneseTestBase;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class ProdSearchTest extends BaseStepDef {

    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private PracticalLawUKCategoryPage practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();
    private SearchHomePage searchHomePage = new SearchHomePage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private BaseResultsPage baseResultPage = new BaseResultsPage();
    private SearchUtils searchUtils = new SearchUtils();

    private String searchTerm;

    @When("^the user verifies that the know how facet is selected \"(.*?)\"$")
    public void theUserVerifiesThatTheKnowHowFacetIsSelected(String arg1) throws Throwable {
        assertTrue(knowHowSearchResultsPage.knowHowFacetCheckbox(arg1).isSelected());
    }

    @When("^the user enters (\\d+) characters into the search box \"(.*?)\"$")
    public void theUserEntersCharactersIntoTheSearchBox(int arg1, String arg2) throws Throwable {
        practicalLawUKCategoryPage.freeTextField().sendKeys(arg2);
    }

    @Then("^the user should see auto suggestion list$")
    public void theUserShouldSeeAutoSuggestionList() throws Throwable {
        SeleneseTestBase.assertTrue("Auto suggestion list is absent", searchHomePage.suggestionList().isDisplayed());
    }

    @When("^the user selects the suggested term \"(.*?)\"$")
    public void theUserSelectsTheSuggestedTerm(String arg1) throws Throwable {
        practicalLawUKCategoryPage.suggestedTerm(arg1).click();
        knowHowSearchResultsPage.waitForSearchResults();
        searchTerm = arg1;
    }

    @Then("^the search results should be shown according to the search term selected$")
    public void theSearchResultShouldBeShownAccordingToTheSearchTermSelected() throws Throwable {
        searchResultsPage.moreOrLessDetailAnchor().click();
        searchResultsPage.moreDetailOption().click();
        assertTrue("One of results does not contains search term '" + searchTerm + "'",
                searchUtils
                        .isEveryResultContains(baseResultPage.getResultListWithFullText(), Arrays.asList(searchTerm.split("\\s+"))));
    }

}
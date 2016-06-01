package com.thomsonreuters.globalpages.step_definitions.search;

import com.thomsonreuters.globalpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GlobalPagesLessMoreMostTest extends BaseStepDef {

    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();

    private String firstResultItem;
    private String secondResultItem;
    private String thirdResultItem;

    @Then("^the user can select the option to show less detail$")
    public void theUserCanSelectTheOptionToShowLessDetail() throws Throwable {
        searchResultsPage.moreOrLessDetailAnchor().click();
        searchResultsPage.lessDetailOption().click();
    }

    @Then("^the user can verify that the less detail icon is displayed$")
    public void theUserCanVerifyThatTheLessDetailIconForTermsInContextIsDisplayed() throws Throwable {
        assertTrue(searchResultsPage.isSliderSelectorDisplayed(SearchResultsPage.SliderSelector.LESS));
    }

    @When("^the user should verify the presence of following search structure for \"(.*)\" option$")
    public void theUserObtainsTheTitleOfTheFirstResultAndStoresIt(String option, List<String> searchStructure) throws Throwable {
        for (String structure : searchStructure) {
            switch (structure.toLowerCase()) {
                case "title":
                    assertTrue(structure + " is not displayed..!", searchResultsPage.firstResultTitle().isDisplayed());
                    break;
                case "resource type":
                    assertTrue(structure + " is not displayed..!", searchResultsPage.resourceTypeDescription().isDisplayed());
                    break;
                case "jurisdiction":
                    assertTrue(structure + " is not displayed..!", searchResultsPage.jurisdictionsForFirstResult().isDisplayed());
                    break;
                case "status":
                    String statusText = searchResultsPage.statusForFirstResult().getText();
                    assertTrue(structure + " is not displayed..!", statusText.contains("Maintained") || statusText.contains("Published") || statusText.contains("Law stated as at"));
                    break;
            }
            switch (option.toLowerCase()){
                case "less":
                    assertFalse("In " + option + " abstact is displayed..!", searchResultsPage.firstResultAbstractText().isDisplayed());
                    assertFalse("In " + option + " first snippet is displayed..!", searchResultsPage.firstSnippetPara().isDisplayed());
                    break;
                case "more":
                    assertTrue("In " + option + " abstact is not displayed..!", searchResultsPage.firstResultAbstractText().isDisplayed());
                    assertTrue("In " + option + " first snippet not displayed..!", searchResultsPage.firstSnippetPara().isDisplayed());
                    assertFalse("In " + option + " second snippet is displayed..!", searchResultsPage.secondSnippetPara().isDisplayed());
                    break;
                case "most":
                    assertTrue("In " + option + " abstact is not displayed..!", searchResultsPage.firstResultAbstractText().isDisplayed());
                    assertTrue("In " + option + " first snippet is not displayed..!", searchResultsPage.firstSnippetPara().isDisplayed());
                    assertTrue("In " + option + " second snippet is not displayed..!", searchResultsPage.secondSnippetPara().isDisplayed());
                    break;
            }
        }
    }

    @When("^the user can select the option to show more detail$")
    public void theUserCanSelectTheOptionToShowMoreDetail() throws Throwable {
        searchResultsPage.moreOrLessDetailAnchor().click();
        searchResultsPage.moreDetailOption().click();
    }

    @Then("^the user can verify that the more detail icon is displayed$")
    public void theUserCanVerifyThatTheMoreDetailIconForTermsInContextIsDisplayed() throws Throwable {
        assertTrue(searchResultsPage.isSliderSelectorDisplayed(SearchResultsPage.SliderSelector.MORE));
    }

    @Then("^the user can select the option to show most detail$")
    public void theUserCanSelectTheOptionToShowMostDetail() throws Throwable {
        searchResultsPage.moreOrLessDetailAnchor().click();
        searchResultsPage.mostDetailOption().click();
    }

    @Then("^the user can verify that the most detail icon is displayed$")
    public void theUserCanVerifyThatTheMostDetailIconForTermsInContextIsDisplayed() throws Throwable {
        assertTrue(searchResultsPage.isSliderSelectorDisplayed(SearchResultsPage.SliderSelector.MOST));
    }

    @When("^the user verifies that the option for sorting by relevance is displayed by default$")
    public void theUserVerifiesThatTheOptionForSortingByRelevanceIsDisplayedByDefault() throws Throwable {
        assertTrue(searchResultsPage.sortByDropdownSelectedOption().getText().trim().equals("Relevance"));
    }

    @When("^the user obtains the title of the first, second and third result and stores it$")
    public void theUserObtainsTheTitleOfTheFirstResultAndStoresIt() throws Throwable {
        firstResultItem = searchResultsPage.getResultItem("1");
        secondResultItem = searchResultsPage.getResultItem("2");
        thirdResultItem = searchResultsPage.getResultItem("3");
    }

    @Then("^the user can select the option to sort by \"(.*?)\"$")
    public void the_user_can_select_the_option_to_sort_by_(String sortOption) throws Throwable {
        searchResultsPage.sortByDropdownLink().click();
        searchResultsPage.sortByDropDownOption(sortOption).click();
        knowHowSearchResultsPage.waitForSearchResults();
    }

    @When("^the user can verify that the title of the first, second and third results should not be the same as the stored values$")
    public void theUserCanVerifyThatTheTitleOfTheFirstResultIsNotTheSameAsTheStoredValue() throws Throwable {
        assertFalse(searchResultsPage.getResultItem("1").trim().equals(firstResultItem));
        assertFalse(searchResultsPage.getResultItem("2").trim().equals(secondResultItem));
        assertFalse(searchResultsPage.getResultItem("3").trim().equals(thirdResultItem));
    }

    @Then("^the user is able to verify that the title of the first,second and third results should be the same as the stored values$")
    public void theUserIsAbleToVerifyThatTheTitleOfTheFirstResultIsTheSameAsTheStoredValue() throws Throwable {
        assertTrue(searchResultsPage.getResultItem("1").trim().equals(firstResultItem));
        assertTrue(searchResultsPage.getResultItem("2").trim().equals(secondResultItem));
        assertTrue(searchResultsPage.getResultItem("3").trim().equals(thirdResultItem));
    }

}

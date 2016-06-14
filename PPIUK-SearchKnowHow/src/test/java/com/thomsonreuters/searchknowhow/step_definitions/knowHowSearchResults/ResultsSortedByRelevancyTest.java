package com.thomsonreuters.searchknowhow.step_definitions.knowHowSearchResults;

import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.searchknowhow.step_definitions.BaseStepDef;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class ResultsSortedByRelevancyTest extends BaseStepDef {

    private SearchResultsPage searchResultsPage = new SearchResultsPage();

    private String firstResultItem;
    private String secondResultItem;
    private String thirdResultItem;

    @Then("^the user verifies that the option for sorting by relevance is displayed by default$")
    public void theUserVerifiesThatTheOptionForSortingByRelevanceIsDisplayedByDefault() throws Throwable {
        assertTrue(searchResultsPage.sortByDropdownSelectedOption().getText().trim().equals("Relevance"));
    }

    @When("^the user obtains the title of the first result and stores it$")
    public void theUserObtainsTheTitleOfTheFirstResultAndStoresIt() throws Throwable {
        firstResultItem = searchResultsPage.getResultItem("1");
    }

    @And("^the user obtains the title of the second result and stores it$")
    public void theUserObtainsTheTitleOfTheSecondResultAndStoresIt() throws Throwable {
        secondResultItem = searchResultsPage.getResultItem("2");
    }

    @And("^the user obtains the title of the third result and stores it$")
    public void theUserObtainsTheTitleOfTheThirdResultAndStoresIt() throws Throwable {
        thirdResultItem = searchResultsPage.getResultItem("3");
    }

    @And("^the user is able to select the link to whats market results$")
    public void theUserIsAbleToSelectTheLinkToWhatsMarketResults() throws Throwable {
        searchResultsPage.whatsMarketLink().click();
    }

    @And("^the user is able to select the link to know how results$")
    public void theUserIsAbleToSelectTheLinkToKnowHowResults() throws Throwable {
        searchResultsPage.knowHowLink().click();
    }

    @Then("^the user is able to verify that the title of the first result is the same as the stored value$")
    public void theUserIsAbleToVerifyThatTheTitleOfTheFirstResultIsTheSameAsTheStoredValue() throws Throwable {
        assertTrue(searchResultsPage.getResultItem("1").equals(firstResultItem));
    }

    @And("^the user is able to verify that the title of the second result is the same as the stored value$")
    public void theUserIsAbleToVerifyThatTheTitleOfTheSecondResultIsTheSameAsTheStoredValue() throws Throwable {
        assertTrue(searchResultsPage.getResultItem("2").equals(secondResultItem));
    }

    @And("^the user is able to verify that the title of the third result is the same as the stored value$")
    public void theUserIsAbleToVerifyThatTheTitleOfTheThirdResultIsTheSameAsTheStoredValue() throws Throwable {
        assertTrue(searchResultsPage.getResultItem("3").equals(thirdResultItem));
    }

}

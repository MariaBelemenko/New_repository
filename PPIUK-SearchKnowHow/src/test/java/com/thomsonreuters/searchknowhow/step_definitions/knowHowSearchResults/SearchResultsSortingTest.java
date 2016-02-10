package com.thomsonreuters.searchknowhow.step_definitions.knowHowSearchResults;

import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.searchknowhow.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SearchResultsSortingTest extends BaseStepDef {

    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();

    private String firstResultItem;
    private String secondResultItem;
    private String thirdResultItem;

    @Then("^the user clears all text from the search field$")
    public void theUserClearsAllTextFromTheSearchField() throws Throwable {
        searchResultsPage.freeTextSearchField().clear();
    }

    @Then("^the user can select the option to sort by \"(.*?)\"$")
    public void theUserCanSelectTheOptionToSortBy(String sortOption) throws Throwable {
        searchResultsPage.sortByDropdownLink().click();
        searchResultsPage.sortByDropDownOption(sortOption).click();
        knowHowSearchResultsPage.waitForSearchResults();
    }

    @When("^the user verifies that the option for sorting by date is displayed$")
    public void theUserVerifiesThatTheOptionForSortingByDateIsDisplayed() throws Throwable {
        WebElement dropdown = searchResultsPage.sortByDropdownSelectedOption();
        assertTrue(dropdown.getText().trim().equals("Date"));
    }

    @Then("^the user verifies that the result in position is maintained$")
    public void userVerifiesThatTheResultInPostionIsMaintained(List<String> positions) throws Throwable {
        for (String position : positions) {
            assertTrue(searchResultsPage.getWholeResultItem(position).contains("Maintained"));
        }
    }

    @When("^the user can verify that the title of the first result is not the same as the stored value$")
    public void theUserCanVerifyThatTheTitleOfTheFirstResultIsNotTheSameAsTheStoredValue() throws Throwable {
        assertFalse(searchResultsPage.getResultItem("1").equals(firstResultItem));
    }

    @When("^the user can verify that the title of the second result is not the same as the stored value$")
    public void theUserCanVerifyThatTheTitleOfTheSecondResultIsNotTheSameAsTheStoredValue() throws Throwable {
        assertFalse(searchResultsPage.getResultItem("2").equals(secondResultItem));
    }

    @When("^the user can verify that the title of the third result is not the same as the stored value$")
    public void theUserCanVerifyThatTheTitleOfTheThirdResultIsNotTheSameAsTheStoredValue() throws Throwable {
        assertFalse(searchResultsPage.getResultItem("3").equals(thirdResultItem));
    }

    @When("^the user verifies that the know how Jurisdiction facets appear in bespoke order$")
    public void theUserVerifiesThatTheKnowHowJurisdictionFacetsAppearInBespokeOrder() throws Throwable {
        String currentJurisdiction;
        List<String> actualJurisctions = knowHowSearchResultsPage.getJurisdictionFacets();
        currentJurisdiction = actualJurisctions.get(0);
        Assert.assertTrue(currentJurisdiction.equals("Any UK jurisdiction"));
        Assert.assertTrue(actualJurisctions.get(1).equals("England"));
        Assert.assertTrue(actualJurisctions.get(2).equals("Northern Ireland"));
        Assert.assertTrue(actualJurisctions.get(3).equals("Scotland"));
        Assert.assertTrue(actualJurisctions.get(4).equals("United Kingdom"));
    }

}

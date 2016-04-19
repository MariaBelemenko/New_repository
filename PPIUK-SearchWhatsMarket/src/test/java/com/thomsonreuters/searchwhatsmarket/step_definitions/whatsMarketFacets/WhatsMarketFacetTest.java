package com.thomsonreuters.searchwhatsmarket.step_definitions.whatsMarketFacets;

import com.thomsonreuters.pageobjects.pages.search.CasesSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.WhatsMarketSearchResultsPage;
import com.thomsonreuters.searchwhatsmarket.step_definitions.BaseStepDef;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WhatsMarketFacetTest extends BaseStepDef {

    private WhatsMarketSearchResultsPage whatsMarketSearchResultsPage = new WhatsMarketSearchResultsPage();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private CasesSearchResultsPage casesSearchResultsPage = new CasesSearchResultsPage();

    private Integer[] resultArray = new Integer[10];
    private Map<String, Integer> facetsMapWithCountValues;

    @When("^the user expands the whats market facet \"(.*?)\"$")
    public void theUserExpandsTheWhatsMarketFacet(String arg1) throws Throwable {
        whatsMarketSearchResultsPage.expandWhatsMarketFacet(arg1).click();
    }

    @Then("^the user is able to select the option to collapse the facet entitled \"(.*?)\"$")
    public void theUserIsAbleToSelectTheOptionToCollapseTheFacetEntitled(String arg1) throws Throwable {
        knowHowSearchResultsPage.collapseFacet(arg1).click();
    }

    @When("^the user verifies the presence of the whats market facet \"(.*?)\"$")
    public void theUserVerifiesThePresenceOfWhatsMarketFacet(String arg1) throws Throwable {
        whatsMarketSearchResultsPage.whatsMarketFacetName(arg1).isDisplayed();
    }

    @When("^the user verifies the presence of an associated whats market facet \"(.*?)\" count$")
    public void theUserVerifiesThePresenceOfAnAssociatedWhatsMarketFacetCount(String arg1) throws Throwable {
        whatsMarketSearchResultsPage.whatsMarketFacetCount(arg1).isDisplayed();
    }

    @When("^the user gets the know how facet \"(.*?)\" count and stores it as count \"(.*?)\"$")
    public void theUserGetsTheKnowHowFacetCountAndStoresItAsCount(String arg1, Integer count) throws Throwable {
        /** Captures the page object text value and stores it in the "numberReturnedFromWebsite" string */
        String numberReturnedFromWebsite = knowHowSearchResultsPage.facetCount(arg1).getText();
        /** To make sure the string is only a number we remove any non-numeric characters */
        numberReturnedFromWebsite = numberReturnedFromWebsite.replaceAll("[^0-9]", "");
        /** Stores the value from "numberReturnedFromWebsite" in the resultArray whilst at the same time converting it to a number */
        resultArray[count] = Integer.parseInt(numberReturnedFromWebsite);
    }

    @When("^the user verifies that the whats market facet count \"(.*?)\" is less than \"(.*?)\"$")
    public void theUserVerifiesThatTheWhatsMarketFacetCountIsLessThan(Integer count1, Integer count2) throws Throwable {
        assertTrue(resultArray[count1] < resultArray[count2]);
    }

    @And("^the user gets all the facet counts for the displayed$")
    public void getFacetCounts() throws Throwable {
        facetsMapWithCountValues = searchResultsPage.getAllFacetsWithCountValues();
    }

    @Then("^the user verifies that the facet count for all the individual facets has a value of 1 or greater$")
    public void verifyTheFacetsWithCountIsGreaterThanOne() throws Throwable {
        assertTrue(facetsMapWithCountValues.keySet().size() > 0);
        for (String key : facetsMapWithCountValues.keySet()) {
            assertTrue(facetsMapWithCountValues.get(key).intValue() > 0);
        }
    }

    @Then("^the user verifies no facets will be displayed$")
    public void noFacetsDisplayed() throws Throwable {
        facetsMapWithCountValues = searchResultsPage.getAllFacetsWithCountValues();
        assertTrue(facetsMapWithCountValues.keySet().size() == 0);
    }

    @And("^the user verifies no facet type headers will be displayed$")
    public void noFacetHeaders() throws Throwable {
        assertFalse(searchResultsPage.isFacetTypeHeadersDisplayed());
    }

    @Then("^the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is$")
    public void theUserIsAbleToCheckWhetherTheOptionToApplyFiltersIsDisplayedAndIfNotToEnsureThatItIs() {
        Boolean isPresent = false;
        try {
            if (knowHowSearchResultsPage.selectMultipleFiltersButton().isDisplayed()) {
                isPresent = true;
            }
        } catch (NoSuchElementException | TimeoutException e) {
            LOG.info("'Select Multiple Filters' button is absent", e);
        }
        if (isPresent = true) {
            knowHowSearchResultsPage.clickOnSelectMultipleFilters();
        }
    }

    @When("^the user gets the whats market search result count and stores it as count \"(.*?)\"$")
    public void theUserGetsTheWhatsMarketSearchResultCountAndStoresItAsCount(Integer count) throws Throwable {
        String numberReturnedFromWebsite = knowHowSearchResultsPage.knowHowSearchResultCount().getText();
        numberReturnedFromWebsite = numberReturnedFromWebsite.replaceAll("[^0-9]", "");
        resultArray[count] = Integer.parseInt(numberReturnedFromWebsite);
    }

    @When("^the user selects the whats market facet \"(.*?)\"$")
    public void theUserSelectsTheWhatsMarketFacet(String arg1) throws Throwable {
        whatsMarketSearchResultsPage.whatsMarketFacetCheckbox(arg1).click();
    }

    @When("^the user selects the option to apply filters$")
    public void theUserSelectsTheOptionToApplyFilters() throws Throwable {
        casesSearchResultsPage.applyFiltersButton().click();
        knowHowSearchResultsPage.waitForSearchResults();
        knowHowSearchResultsPage.clickOnSelectMultipleFilters();
    }

    @When("^the user verifies that the whats market search result count \"(.*?)\" is less than \"(.*?)\"$")
    public void theUserVerifiesThatTheWhatsMarketSearchResultCountIsLessThan(Integer count1, Integer count2) throws Throwable {
        assertTrue(resultArray[count1] < resultArray[count2]);
    }

    @When("^the user deselects the whats market facet \"(.*?)\"$")
    public void theUserDeselectsTheWhatsMarketFacet(String arg1) throws Throwable {
        whatsMarketSearchResultsPage.whatsMarketFacetCheckbox(arg1).click();
    }

    @When("^the user verifies that the whats market search result count \"(.*?)\" equals the search result count \"(.*?)\"$")
    public void theUserVerifiesThatTheWhatsMarketSearchResultCountEqualsTheSearchResultCount(Integer count1, Integer count2) throws Throwable {
        assertTrue(resultArray[count1] == resultArray[count2]);
    }

    @When("^the user verifies the presence of the whats market facet groups$")
    public void theUserVerifiesThePresenceOfTheWhatsMarketFacetGroups(List<String> actualFacets) throws Throwable {
        for(String facet : actualFacets) {
            assertTrue(whatsMarketSearchResultsPage.whatsMarketFacetGroupName(facet).isDisplayed());
        }
    }

}

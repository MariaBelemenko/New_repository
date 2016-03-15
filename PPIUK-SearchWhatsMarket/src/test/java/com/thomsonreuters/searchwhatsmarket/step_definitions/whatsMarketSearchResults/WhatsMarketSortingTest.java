package com.thomsonreuters.searchwhatsmarket.step_definitions.whatsMarketSearchResults;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.common.SortOptions;
import com.thomsonreuters.pageobjects.pages.landingPage.WhatsMarketHomePage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.WhatsMarketSearchResultsPage;
import com.thomsonreuters.searchwhatsmarket.step_definitions.BaseStepDef;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class WhatsMarketSortingTest extends BaseStepDef {

    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private WhatsMarketSearchResultsPage whatsMarketSearchResultsPage = new WhatsMarketSearchResultsPage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private WhatsMarketHomePage whatsMarketHomePage = new WhatsMarketHomePage();
    private CommonMethods commonMethods = new CommonMethods();

    @When("^the user selects the know how parent facet \"(.*?)\"$")
    public void theUserSelectsTheKnowHowParentFacet(String arg1) throws Throwable {
        knowHowSearchResultsPage.knowHowFacetCheckbox(arg1).click();
    }

    @Then("^the results displayed with date in \"(.*?)\" format$")
    public void isDateFormatCorrect(String dateFormat) throws Throwable {
        String dateString;
        List<WebElement> searchResultsDates = whatsMarketSearchResultsPage.searchResultPublishedDates();
        for (int loopCount=0; loopCount<searchResultsDates.size(); loopCount++) {
            dateString = searchResultsDates.get(loopCount).getText();
            dateString = dateString.replace("Published on ","");
            //System.out.println("Result date is: " + dateString);
            assertTrue(commonMethods.isDateInValidFormat(dateString, dateFormat));
        }
    }

    @Then("^results date should contain 0 if day has single digit in date$")
    public void isResultsDateContainingZero() throws Throwable {
        searchResultsPage.moreOrLessDetailAnchor().click();
        searchResultsPage.moreDetailOption().click();
        List<WebElement> datesToCheck = whatsMarketSearchResultsPage.searchResultPublishedDates();
        assertTrue(commonMethods.isDateStartsWithZeroForSingleDigitDay(datesToCheck));
    }

    @Then("^the results displayed with sorted by date with most recent first$")
    public void resultsDisplayedDateOrder() throws Throwable {
        List<WebElement> datesToCheck = whatsMarketSearchResultsPage.searchResultPublishedDates();
        assertTrue(commonMethods.isResultsSortedByDate(datesToCheck,SortOptions.DESC));
    }

    @Given("^the user selects the more link for the facet group \"(.*?)\"$")
    public void theUserSelectsTheMoreLinkForTheFacetGroup(String facetGroup) throws Throwable {
        whatsMarketHomePage.waitForPageToLoadAndJQueryProcessing();
        whatsMarketSearchResultsPage.clickMoreOption(facetGroup);
    }

    @Given("^the user selects the whats market facet \"(.*?)\" on popup$")
    public void theUserSelectsTheWhatsMarketFacetOnPopup(String facet) throws Throwable {
        whatsMarketSearchResultsPage.facetOnPopup(facet).click();
    }

    @Given("^the user clicks the filter button on more facet group popup$")
    public void theUserClicksTheFilterButtonOnMoreFacetGroupPopup() throws Throwable {
        whatsMarketSearchResultsPage.filterButtonOnPopup().click();
        whatsMarketHomePage.waitForPageToLoadAndJQueryProcessing();
    }

    @Given("^the user verifies \"(.*?)\" facets appear in alphabetical order$")
    public void theUserVerifiesKnowHowPracticeAreaFacetsAppearInAlphabeticalOrder(String arg1) throws Throwable {
        Boolean isAlphabeticalOrder = true;
        List<String> actualPracticeArea = knowHowSearchResultsPage.getMainPracticeAreaFacets(arg1);
        if (actualPracticeArea.contains("EU")) {
            int index = actualPracticeArea.indexOf("EU");
            actualPracticeArea.set(index, actualPracticeArea.get(index).replace('U', 'u'));
        }
        assertTrue(commonMethods.isSorted(actualPracticeArea, SortOptions.ASC));
    }

    @When("^the user selects the option to clear all filters$")
    public void theUserSelectsTheOptionToClearAllFilters() throws Throwable {
        searchResultsPage.clearAllFilters().click();
    }

    @Given("^the user verifies Main Market is listed first then AIM under 'Market' facet group$")
    public void theUserVerifiesMainMarketsIsListedFirstThenAIMUnderMarketFacetGroup() throws Throwable {
        List<String> marketFacets = knowHowSearchResultsPage.getMainPracticeAreaFacets("Market on which target shares traded");
        assertTrue(marketFacets.get(0).equalsIgnoreCase("Main Market"));
        assertTrue(marketFacets.get(1).equalsIgnoreCase("AIM"));
    }

    @Given("^the user verifies Yes is listed before No under 'Underwritten' facet group$")
    public void theUserVerifiesYesIsListedBeforeNoUnderUnderwrittenFacetGroup() throws Throwable {
        List<String> underwrittenFacets = knowHowSearchResultsPage.getMainPracticeAreaFacets("Underwritten");
        assertTrue(commonMethods.isSorted(underwrittenFacets, SortOptions.DESC));
    }

    @Given("^the user verifies facets under 'Value' are ordered from smallest to largest$")
    public void theUserVerifiesFacetsUnderValueGroupAreOrderedFromSmallestToLargest() throws Throwable {
        List<String> valueFacets = knowHowSearchResultsPage.getMainPracticeAreaFacets("Value");
        assertTrue(valueFacets.get(0).contains("0-"));
        assertTrue(valueFacets.get(1).contains("100 million"));
        assertTrue(valueFacets.get(2).contains("1 billion"));
    }

    @Given("^the user verifies facets under '(.+)' are ordered by decreasing facet count$")
    public void theUserVerifiesFacetsUnderDealTypeAreOrderedByDecreasingFacetCount(String facetGroup) throws Throwable {
        List<Integer> facetGroupChildCounts = knowHowSearchResultsPage.getFacetCounts(facetGroup);
        assertTrue(commonMethods.isSorted(facetGroupChildCounts, SortOptions.DESC));
    }

    @Given("^the user verifies facets under 'Date' are ordered most recent first$")
    public void theUserVerifiesFacetsUnderDateAreOrderedMostRecentFirst() throws Throwable {
        List<String> dateFacets = knowHowSearchResultsPage.getMainPracticeAreaFacets("Date");
        assertTrue(commonMethods.isSorted(dateFacets, SortOptions.DESC));
    }

}

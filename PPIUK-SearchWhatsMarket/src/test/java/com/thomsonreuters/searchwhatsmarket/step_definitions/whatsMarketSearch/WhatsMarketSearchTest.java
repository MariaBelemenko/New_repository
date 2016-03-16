package com.thomsonreuters.searchwhatsmarket.step_definitions.whatsMarketSearch;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.WhatsMarketSearchResultsPage;
import com.thomsonreuters.searchwhatsmarket.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WhatsMarketSearchTest extends BaseStepDef {

    private WhatsMarketSearchResultsPage whatsMarketSearchResultsPage = new WhatsMarketSearchResultsPage();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private CommonMethods commonMethods = new CommonMethods();

    @Then("^the user is able to verify that the result in position (\\d+) is whats market content because it contains at least one of the following transaction types$")
    public void theUserIsAbleToVerifyThatTheResultInPositionIsWhatsMarketContentBecauseItContainsAtLeastOneOfTheFollowingTransactionTypes(String result) throws Throwable {
        String item = whatsMarketSearchResultsPage.getResultItemMetaData(result);
        assertTrue((item.contains("Administrations")) || (item.contains("Secondary issues")) || (item.contains("Listing Rules transactions"))
                || (item.contains("Public M&A deals")) || (item.contains("AGMs: FTSE 350: 2014")) || (item.contains("AGMs: FTSE 350: 2013"))
                || (item.contains("AGMs: FTSE 350: 2011")) || (item.contains("AGMs: FTSE 350: 2012")) || (item.contains("AGMs: FTSE 350: 2010"))
                || (item.contains("AGMs: FTSE 350: 2009")) || (item.contains("De-listings: AIM")) || (item.contains("Returns of value to shareholders"))
                || (item.contains("IPOs: AIM")) || (item.contains("IPOs: Main Market")) || (item.contains("Joint ventures")) || (item.contains("Reorganisations and schemes"))
                || (item.contains("AGMs: AIM: 2009")) || (item.contains("De-listings: Main Market")) || (item.contains("AGMs: AIM 50: 2011"))
                || (item.contains("Convertible bonds")) || (item.contains("AGMs: AIM 50: 2012")) || (item.contains("AGMs: AIM 50: 2013"))
                || (item.contains("AGMs: AIM 50: 2014")) || (item.contains("Transfers to the Main Market from AIM")) || (item.contains("Listed company restructurings"))
                || (item.contains("AGMs: AIM: 2010")) || (item.contains("AIM Rules: Reverse takeovers")) || (item.contains("Demergers")));
    }

    @Then("the user is able to verify that the facets by default 5 facets are displayed/expanded per facet type with an option to see more")
    public void verifyTheFacetsLimit() throws Throwable {
        for (String facetGroupName : whatsMarketSearchResultsPage.getFacetGroupNames()) {
            int childFacets = whatsMarketSearchResultsPage.getChildFacetsSize(facetGroupName);
            assertFalse(childFacets > 5);
            if (childFacets == 5) {
                if (whatsMarketSearchResultsPage.isMoreOptionAvailable(facetGroupName)) {
                    whatsMarketSearchResultsPage.clickMoreOption(facetGroupName);
                    childFacets = whatsMarketSearchResultsPage.getChildFacetsSize(facetGroupName);
                    assertTrue(childFacets > 5);
                }
            }
            assertFalse(whatsMarketSearchResultsPage.isMoreOptionAvailable(facetGroupName));
        }
    }

    @When("^the user verifies that the whats market facet \"(.*?)\" is selected$")
    public void theUserVerifiesThatTheWhatsMarketFacetIsSelected(String arg1) throws Throwable {
        assertTrue(whatsMarketSearchResultsPage.whatsMarketFacetCheckbox(arg1).isSelected());
    }

    @When("^the user clicks on clear all link$")
    public void theUserClicksOnClearAllLink() throws Throwable {
        commonMethods.moveToElementUsingJSThenClick(knowHowSearchResultsPage.clearAllLink());
    }

    @When("^the user verifies that the whats market facet \"(.*?)\" is not selected$")
    public void theUserVerifiesThatWhatsMarketFacetIsNotSelected(String arg1) throws Throwable {
        assertFalse(whatsMarketSearchResultsPage.whatsMarketFacetCheckbox(arg1).isSelected());
    }

    @Then("^the user is able to verify that the result in result position is whats market content because it contains one of the whats market resource types$")
    public void verifyTheResultPositionValue(List<String> resultPositions) throws Throwable {
        for (String position : resultPositions) {
            theUserIsAbleToVerifyThatTheResultInPositionIsWhatsMarketContentBecauseItContainsOneOfTheWhatsMarketResourceTypes(position);
        }
    }

    @Then("^the user is able to verify that the result in position \"(.*?)\" is whats market content because it contains one of the whats market resource types$")
    public void theUserIsAbleToVerifyThatTheResultInPositionIsWhatsMarketContentBecauseItContainsOneOfTheWhatsMarketResourceTypes(String resultposition) throws Throwable {
        String item = whatsMarketSearchResultsPage.getResultItemMetaData(resultposition);
        assertTrue((item.contains("Administrations")) || (item.contains("Secondary issues")) || (item.contains("Listing Rules transactions"))
                || (item.contains("Public M&A deals")) || (item.contains("AGMs: FTSE 350:"))
                || (item.contains("De-listings: AIM")) || (item.contains("Demergers")
                || (item.contains("IPOs: AIM")) || (item.contains("Joint ventures"))
                || (item.contains("IPOs: Main Market")) || (item.contains("Reorganisations and schemes"))
                || (item.contains("Returns of value to shareholders"))
                || (item.contains("AGMs: AIM:")) || (item.contains("De-listings: Main Market"))
                || (item.contains("AGMs: AIM 50:")) || (item.contains("Convertible bonds"))
                || (item.contains("Transfers to the Main Market from AIM"))
                || (item.contains("Listed company restructurings")) || (item.contains("AIM Rules: Reverse takeovers"))));
    }

    @When("^the user verifies that the result at position in the result list has the deal type$")
    public void theUserVerifiesThatTheResultAtPositionInTheResultListHasTheDealType(Map<String, String> map) throws Throwable {
        for (String position : map.keySet()) {
            assertTrue(whatsMarketSearchResultsPage.isWhatsMarketResultTextPresent(position, map.get(position)));
        }
    }

}

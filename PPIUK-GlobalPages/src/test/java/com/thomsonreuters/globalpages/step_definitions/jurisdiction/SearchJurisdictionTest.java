package com.thomsonreuters.globalpages.step_definitions.jurisdiction;

import com.thomsonreuters.globalpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.WhatsMarketSearchResultsPage;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertFalse;

public class SearchJurisdictionTest extends BaseStepDef {

    private WhatsMarketSearchResultsPage resultsPage = new WhatsMarketSearchResultsPage();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private static final int facetsNumber = 5;

    @Then("the user is able to verify that the jurisdiction facets by default 5 facets are displayed")
    public void verifyTheJurisdictionFacetsLimit() {
        for (String facetGroupName : resultsPage.getFacetGroupNames()) {
            if (facetGroupName.equalsIgnoreCase("Jurisdiction")) {
                int childFacets = resultsPage.getChildFacetsSize(facetGroupName);
                assertFalse(childFacets > facetsNumber);
                if (childFacets < facetsNumber) {
                    assertFalse(knowHowSearchResultsPage.isMoreOptionAvailableForKnowHowJurisdiction());
                }
            }
        }
    }

}

package com.thomsonreuters.globalpages.step_definitions.jurisdiction;

import com.thomsonreuters.globalpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.WhatsMarketSearchResultsPage;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertFalse;

public class SearchJurisdictionTest extends BaseStepDef {

    private WhatsMarketSearchResultsPage resultsPage = new WhatsMarketSearchResultsPage();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();

    @Then("the user is able to verify that the jurisdiction facets by default 5 facets are displayed")
    public void verifyTheJurisdictionFacetsLimit() {
        for (String facetGroupName : resultsPage.getFacetGroupNames()) {
            if (facetGroupName.equalsIgnoreCase("Jurisdiction")) {
                int childFacets = resultsPage.getChildFacetsSize(facetGroupName);
                assertFalse(childFacets > 5);
                if (childFacets < 5) {
                    assertFalse(knowHowSearchResultsPage.isMoreOptionAvailableForKnowHowJurisdiction());
                }
            }
        }
    }

}

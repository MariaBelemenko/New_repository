package com.thomsonreuters.legalupdate.step_definitions.search;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class OrphanPageForLUResultsPageTest extends BaseStepDef {

    private NavigationCobalt navigation = new NavigationCobalt();

    private final String ORPHAN_PAGE_URL = "/Browse/Home/UnitedKingdomLegalUpdates";
    private String LEGAL_UPDATES_TITLE = "United Kingdom: Legal Updates - WestlawNext";

    @Given("^a User types the Orphan page URL into their browser$")
    public void aUserTypesTheOrphanPageUrlIntoTheirBrowser() throws Throwable {
        navigation.navigateToPLCUKPlusSpecificURL(ORPHAN_PAGE_URL);
    }

    @Then("^they should be presented with the correct Orphan page$")
    public void theyShouldBePresentedWithTheCorrectOrphanPage() throws Throwable {
        navigation.waitForPageTitle(LEGAL_UPDATES_TITLE);
    }

}

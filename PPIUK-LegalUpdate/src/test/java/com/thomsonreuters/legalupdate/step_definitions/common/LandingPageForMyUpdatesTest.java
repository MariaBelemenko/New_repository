package com.thomsonreuters.legalupdate.step_definitions.common;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LandingPageForMyUpdatesTest extends BaseStepDef {

    private NavigationCobalt navigation = new NavigationCobalt();

    private final String MY_UPDATES_PAGE_URL = "/MyUpdates";
    private String MY_UPDATES_TITLE = "My Updates - Practical Law";

    @Given("^a user has navigated to the MyUpdates page$")
    public void aUserHasNavigatedToTheMyUpdatesPage() throws Throwable {
        navigation.navigateToPLCUKPlusSpecificURL(MY_UPDATES_PAGE_URL);
    }

    @Then("^the user should be presented with a landing page$")
    public void theUserShouldBePresentedWithALandingPage() throws Throwable {
        navigation.waitForPageTitle(MY_UPDATES_TITLE);
    }

}

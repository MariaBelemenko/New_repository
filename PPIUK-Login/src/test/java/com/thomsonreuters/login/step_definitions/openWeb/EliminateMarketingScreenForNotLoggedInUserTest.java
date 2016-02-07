package com.thomsonreuters.login.step_definitions.openWeb;

import com.thomsonreuters.login.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawHomepage;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertNull;

public class EliminateMarketingScreenForNotLoggedInUserTest extends BaseStepDef {

    private PracticalLawHomepage practicalLawHomepage = new PracticalLawHomepage();

    @Then("^the user should not be presented with the marketing screen lightbox$")
    public void theUserShouldNotBePresentedWithTheMarketingScreenLightbox() throws Throwable {
        assertNull("Welcome screen is displayed for a not logged in user", practicalLawHomepage.welcomeBox());
    }

}
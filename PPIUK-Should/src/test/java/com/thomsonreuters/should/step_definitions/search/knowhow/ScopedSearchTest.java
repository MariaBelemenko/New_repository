package com.thomsonreuters.should.step_definitions.search.knowhow;

import com.thomsonreuters.pageobjects.pages.landingPage.PracticeAreaLandingPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowDocumentPage;
import com.thomsonreuters.should.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class ScopedSearchTest extends BaseStepDef {

    private KnowHowDocumentPage knowHowDocumentPage = new KnowHowDocumentPage();
    private PracticeAreaLandingPage practiceAreaLandingPage = new PracticeAreaLandingPage();


    @When("^the user verifies that the product detail contains the topic area \"([^\"]*)\"$")
    public void theUserVerifiesThatTheProductDetailContainsTheTopicArea(String arg1) throws Throwable {
        assertTrue(knowHowDocumentPage.topicInformation(arg1).isDisplayed());
    }

    @Then("^the user selects the link to Media and Telecoms$")
    public void theUserSelectsTheLinkToMediaAndTelecoms() throws Throwable {
        practiceAreaLandingPage.mediaAndTelecomsLink().click();
    }

    @Then("^the user selects the link to Social Media$")
    public void theUserSelectsTheLinkToSocialMedia() throws Throwable {
        practiceAreaLandingPage.socialMediaLink().click();
    }
}

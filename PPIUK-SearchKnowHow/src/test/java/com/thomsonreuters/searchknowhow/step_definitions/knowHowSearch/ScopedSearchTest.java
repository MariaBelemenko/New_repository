package com.thomsonreuters.searchknowhow.step_definitions.knowHowSearch;

import com.thomsonreuters.pageobjects.pages.generic.PPIGenericDocDisplay;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticeAreaLandingPage;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowDocumentPage;
import com.thomsonreuters.pageobjects.pages.search.WhatsMarketSearchResultsPage;
import com.thomsonreuters.searchknowhow.step_definitions.BaseStepDef;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class ScopedSearchTest extends BaseStepDef {

    private PracticeAreaLandingPage practiceAreaLandingPage = new PracticeAreaLandingPage();
    private KnowHowDocumentPage knowHowDocumentPage = new KnowHowDocumentPage();
    private HomePage homePage = new HomePage();
    private PPIGenericDocDisplay ppiGenericDocDisplay = new PPIGenericDocDisplay();
    private WhatsMarketSearchResultsPage whatsMarketSearchResultsPage = new WhatsMarketSearchResultsPage();

    @Then("^the user selects the link to Media and Telecoms$")
    public void theUserSelectsTheLinkToMediaAndTelecoms() throws Throwable {
        practiceAreaLandingPage.mediaAndTelecomsLink().click();
    }

    @Then("^the user selects the link to Social Media$")
    public void theUserSelectsTheLinkToSocialMedia() throws Throwable {
        practiceAreaLandingPage.socialMediaLink().click();
    }

    @When("^the user verifies that the product detail contains the topic area \"([^\"]*)\"$")
    public void theUserVerifiesThatTheProductDetailContainsTheTopicArea(String arg1) throws Throwable {
        assertTrue(knowHowDocumentPage.topicPageLink(arg1).isDisplayed());
    }

    @Given("^has selected the link to the What's Market homepage$")
    public void hasSelectedTheLinkToTheWhatSMarketHomepage() throws Throwable {
        homePage.selectResourceTab();
        /** Ensure the page components have rendered */
        ppiGenericDocDisplay.categoryTab().isDisplayed();
        ppiGenericDocDisplay.rightColumn().isDisplayed();
        homePage.selectLinkPresentOnTab("What's Market");
        ppiGenericDocDisplay.searchPageLabel().getText().equals("What's Market");
        /** Ensure the page components have rendered */
        ppiGenericDocDisplay.categoryTab().isDisplayed();
        ppiGenericDocDisplay.rightColumn().isDisplayed();
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

}

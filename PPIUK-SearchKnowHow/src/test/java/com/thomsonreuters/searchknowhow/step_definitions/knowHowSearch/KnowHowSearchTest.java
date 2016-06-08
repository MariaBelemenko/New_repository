package com.thomsonreuters.searchknowhow.step_definitions.knowHowSearch;

import com.thomsonreuters.pageobjects.pages.landingPage.DemoUnitedKingdomLandingPage;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.pageobjects.pages.widgets.CategoryPage;
import com.thomsonreuters.searchknowhow.step_definitions.BaseStepDef;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class KnowHowSearchTest extends BaseStepDef {

    private HomePage homePage = new HomePage();
    private DemoUnitedKingdomLandingPage demoUnitedKingdomLandingPage = new DemoUnitedKingdomLandingPage();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private CategoryPage categoryPage = new CategoryPage();

    @Given("^has selected the Know How - (.*) link$")
    public void hasSelectedTheLinkToKnowHowUsUkGlobal(String region) throws Throwable {
        switch (region) {
            case "US":
                homePage.selectInternationalTab();
                homePage.selectLinkPresentOnTab("United States");
                break;
            case "UK":
                break;
            case "GLOBAL":
                demoUnitedKingdomLandingPage.knowHowGlobalLink().click();
            default:
                LOG.info("Default search");
        }
    }

    @Then("^the user is able to verify that a page of search results is displayed$")
    public void theUserIsAbleToVerifyThatAPageOfSearchResultsIsDisplayed() throws Throwable {
        knowHowSearchResultsPage.knowHowSearchResultTitle("1").isDisplayed();
    }

    @Then("^the user can select the option to show most detail$")
    public void theUserCanSelectTheOptionToShowMostDetail() throws Throwable {
        searchResultsPage.moreOrLessDetailAnchor().click();
        searchResultsPage.mostDetailOption().click();
    }

    @Then("^the user is able to verify the presence of the title of the first result$")
    public void theUserIsAbleToVerifyThePresenceOfTheTitleOfTheFirstResult() throws Throwable {
        searchResultsPage.firstResultTitle().isDisplayed();
    }

    @Then("^the user is able to verify the presence of a resource type description$")
    public void theUserIsAbleToVerifyThePresenceOfAResourceTypeDescription() throws Throwable {
        searchResultsPage.resourceTypeDescription().isDisplayed();
    }

    @Then("^the user is able to verify a brief description of the content$")
    public void theUserIsAbleToVerifyABriefDescriptionOfTheContent() throws Throwable {
        assertTrue(searchResultsPage.firstResultAbstractText().isDisplayed());
    }

    @Then("^the user is able to verify that jurisdiction information (is|is not) displayed$")
    public void theUserIsAbleToVerifyThatJurisdictionInformationIsDisplayed(String option) throws Throwable {
    	if(option.equals("is not")){
    		assertFalse(searchResultsPage.jurisdictionsForFirstResult().getText().equals("Jurisdiction"));
    	} else if(option.equals("is")) {
    		assertTrue(searchResultsPage.jurisdictionsForFirstResult().isDisplayed());
    	}
        
    }

    @Then("^the user is able to verify that the content is either maintained or non maintained$")
    public void theUserIsAbleToVerifyThatTheContentIsEitherMaintainedOrNonMaintained() throws Throwable {
        String statusText = searchResultsPage.statusForFirstResult().getText();
        assertTrue(statusText.contains("Maintained") || statusText.contains("Published") || statusText.contains("Law"));
    }

    @Then("^the user is notified that the search does not match any of the know how resources$")
    public void theUserIsNotifiedThatTheSearchDoesNotMatchAnyOfTheKnowHowResources() throws Throwable {
        assertTrue(searchResultsPage.sorryNoResultsMessage().isDisplayed());
    }
    
    @When("^the user opens '(.+)' link$")
    public void openLink(String linkName) throws Throwable {
        categoryPage.openPageByText(linkName);
    }

}

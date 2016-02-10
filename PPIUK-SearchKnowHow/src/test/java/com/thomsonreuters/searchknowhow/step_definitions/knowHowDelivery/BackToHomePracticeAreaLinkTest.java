package com.thomsonreuters.searchknowhow.step_definitions.knowHowDelivery;


import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawHomepage;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawUKCategoryPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.searchknowhow.step_definitions.BaseStepDef;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BackToHomePracticeAreaLinkTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private PracticalLawUKCategoryPage practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private PracticalLawHomepage practicalLawHomepage = new PracticalLawHomepage();

    @Given("^the user is on the home page$")
    public void aUserIsOnTheHomePage() throws Throwable {
        navigationCobalt.navigateToHomePage();
    }

    @When("^the user runs a free text cobalt search with query \"(.*?)\"$")
    public void theUserRunsAFreeTextCobaltSearch(String query) throws Throwable {
        practicalLawUKCategoryPage.freeTextField().clear();
        practicalLawUKCategoryPage.freeTextField().sendKeys(query);
        practicalLawUKCategoryPage.searchButton().click();
        knowHowSearchResultsPage.waitForSearchResults();
        knowHowSearchResultsPage.clickOnSelectMultipleFilters();
    }

    @Then("^the user verifies the presence of the link entitled \"(.*?)\"$")
    public void theUserVerifiesThePresenceOfTheLinkEntitled(String arg1) throws Throwable {
        searchResultsPage.backToLink(arg1).isDisplayed();
    }

    @When("^has selected the link to the practice area \"([^\"]*)\"$")
    public void hasSelectedTheLinkToThePracticeArea(String arg1) throws Throwable {
        practicalLawHomepage.practiceAreaLink(arg1).click();
    }

}

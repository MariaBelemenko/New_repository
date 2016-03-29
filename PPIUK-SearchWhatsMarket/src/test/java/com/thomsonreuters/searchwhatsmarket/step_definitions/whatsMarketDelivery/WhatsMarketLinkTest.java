package com.thomsonreuters.searchwhatsmarket.step_definitions.whatsMarketDelivery;

import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.generic.PPIGenericDocDisplay;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawUKCategoryPage;
import com.thomsonreuters.pageobjects.pages.landingPage.WhatsMarketHomePage;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.searchwhatsmarket.step_definitions.BaseStepDef;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;

public class WhatsMarketLinkTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private HomePage homePage = new HomePage();
    private PPIGenericDocDisplay ppiGenericDocDisplay = new PPIGenericDocDisplay();
    private PracticalLawUKCategoryPage practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private WhatsMarketHomePage whatsMarketHomePage = new WhatsMarketHomePage();
    private SoftAssertions softAssertions;

    @Given("^the user is on the home page$")
    public void aUserIsOnTheHomePage() throws Throwable {
        navigationCobalt.navigateToHomePage();
    }

    @Given("^has selected the link to the What's Market homepage$")
    public void hasSelectedTheLinkToTheWhatSMarketHomepage() throws Throwable {
        softAssertions= new SoftAssertions();

        homePage.selectResourceTab();
        /** Ensure the page components have rendered */
        softAssertions.assertThat(ppiGenericDocDisplay.categoryTab().isDisplayed());
        softAssertions.assertThat(ppiGenericDocDisplay.rightColumn().isDisplayed());
        homePage.selectLinkPresentOnTab("What's Market");
        softAssertions.assertThat(ppiGenericDocDisplay.searchPageLabel().getText().equals("What's Market"));
        /** Ensure the page components have rendered */
        softAssertions.assertThat(ppiGenericDocDisplay.categoryTab().isDisplayed());
        softAssertions.assertThat(ppiGenericDocDisplay.rightColumn().isDisplayed());
        softAssertions.assertAll();
    }

    @And("^has selected the link to the What's Market homepage by selecting Practice Area page$")
    public void hasSelectedTheLinkToTheWhatSMarketHomepageBySelectingPracticeAreaPage() throws Throwable {
        softAssertions= new SoftAssertions();

        practicalLawUKCategoryPage.practiceAreaLink("Corporate");
        homePage.selectResourceTab();
        softAssertions.assertThat(ppiGenericDocDisplay.categoryTab().isDisplayed());
        softAssertions.assertThat(ppiGenericDocDisplay.rightColumn().isDisplayed());
        homePage.selectLinkPresentOnTab("What's Market");
        softAssertions.assertThat(ppiGenericDocDisplay.searchPageLabel().getText().equals("What's Market"));
        softAssertions.assertThat(ppiGenericDocDisplay.categoryTab().isDisplayed());
        softAssertions.assertThat(ppiGenericDocDisplay.rightColumn().isDisplayed());
        softAssertions.assertAll();
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

    @When("^has selected the link to \"(.*?)\"$")
    public void hasSelectedTheLinkToWMDealTypeTest(String linkName) throws Throwable {
        whatsMarketHomePage.selectLinkOnWhatsMarketHome(linkName);
        knowHowSearchResultsPage.waitForSearchResults();
    }

}

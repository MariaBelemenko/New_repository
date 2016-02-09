package com.thomsonreuters.searchwhatsmarket.step_definitions.whatsMarketSearch;

import com.thomsonreuters.pageobjects.pages.landingPage.SearchScopeControl;
import com.thomsonreuters.pageobjects.pages.landingPage.WhatsMarketHomePage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.WhatsMarketComparisonReportPage;
import com.thomsonreuters.pageobjects.pages.search.WhatsMarketSearchResultsPage;
import com.thomsonreuters.searchwhatsmarket.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class WhatsMarketScopedSearchDropdownTest extends BaseStepDef {

    private SearchScopeControl searchScopeControl = new SearchScopeControl();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private WhatsMarketHomePage whatsMarketHomePage = new WhatsMarketHomePage();
    private WhatsMarketSearchResultsPage whatsMarketSearchResultsPage = new WhatsMarketSearchResultsPage();
    private WhatsMarketComparisonReportPage whatsMarketComparisonReportPage = new WhatsMarketComparisonReportPage();

    @When("^the user can verify that the scoped search dropdown states \"([^\"]*)\"$")
    public void theUserCanVerifyThatTheScopedSearchDropdownStates(String expectedText) throws Throwable {
        String returnedText;
        expectedText = expectedText.replaceAll("\\s+", "");
        returnedText = searchScopeControl.scopedSearchDropdownTitle().getText().replaceAll("\\s+", "");
        assertTrue(returnedText.equals(expectedText));
    }

    @When("^the user can (display|close) the scoped search dropdown menu options$")
    public void theUserCanDisplayTheScopedSearchDropdownMenuOptions(String arg1) throws Throwable {
        searchScopeControl.scopedSearchDropdownMenuButton().click();
    }

    @When("^the user can verify that the dropdown options include \"([^\"]*)\"$")
    public void theUserCanVerifyThatTheDropdownOptionsInclude(String arg1) throws Throwable {
        searchScopeControl.scopedSearchDropdownOptions(arg1).isDisplayed();
    }

    @When("^the user can verify that the title listed above the search results is \"([^\"]*)\"$")
    public void theUserCanVerifyThatTheTitleListedAboveTheSearchResultsIs(String arg1) throws Throwable {
        arg1 = "\"" + arg1 + "\"";
        searchResultsPage.resultPageTitle(arg1).isDisplayed();
    }

    @Then("^the user can select the option to show most detail$")
    public void theUserCanSelectTheOptionToShowMostDetail() throws Throwable {
        searchResultsPage.moreOrLessDetailAnchor().click();
        searchResultsPage.mostDetailOption().click();
    }

    @When("^has selected the link to the deal type \"([^\"]*)\"$")
    public void hasSelectedTheLinkToTheDealType(String arg1) throws Throwable {
        if (arg1.equals("Administrations")) {
            whatsMarketHomePage.Administrations().click();
        } else if (arg1.equals("Public M & A"))
            whatsMarketHomePage.PublicMandALink().click();
    }

    @When("^the user is able to verify that the result in position \"([^\"]*)\" has the deal type \"([^\"]*)\"$")
    public void theUserIsAbleToVerifyThatTheResultInPositionHasTheDealType(String arg1, String arg2) throws Throwable {
        whatsMarketSearchResultsPage.resultDealType(arg1, arg2).isDisplayed();
    }

    @When("^the user selects the compare button$")
    public void theUserSelectsTheCompareButton() throws Throwable {
        whatsMarketSearchResultsPage.compareButton().click();
    }

    @When("^the user verifies the presence of the heading Deal Comparison Report$")
    public void theUserVerifiesThePresenceOfTheHeadingDealComparisonReport() throws Throwable {
        whatsMarketComparisonReportPage.dealComparisonReportHeader().isDisplayed();
    }

}

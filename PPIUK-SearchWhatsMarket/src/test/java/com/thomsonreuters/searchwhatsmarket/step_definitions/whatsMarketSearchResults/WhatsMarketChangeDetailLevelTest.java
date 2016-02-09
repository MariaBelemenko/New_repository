package com.thomsonreuters.searchwhatsmarket.step_definitions.whatsMarketSearchResults;

import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.WhatsMarketSearchResultsPage;
import com.thomsonreuters.searchwhatsmarket.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WhatsMarketChangeDetailLevelTest extends BaseStepDef {

    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private WhatsMarketSearchResultsPage whatsMarketSearchResultsPage = new WhatsMarketSearchResultsPage();

    @When("^the user can select the option to show more detail$")
    public void theUserCanSelectTheOptionToShowMoreDetail() throws Throwable {
        searchResultsPage.moreOrLessDetailAnchor().click();
        searchResultsPage.moreDetailOption().click();
    }

    @Then("^the user can verify that the more detail icon is displayed$")
    public void theUserCanVerifyThatTheMoreDetailIconForTermsInContextIsDisplayed() throws Throwable {
        assertTrue(searchResultsPage.isSliderSelectorDisplayed(SearchResultsPage.SliderSelector.MORE));
    }

    @When("^the user is able to verify the presence of the resource title for the first result \"([^\"]*)\"$")
    public void theUserIsAbleToVerifyThePresenceOfTheResourceTitleForTheFirstResult(String arg1) throws Throwable {
        whatsMarketSearchResultsPage.whatsMarketSearchResultTitle(arg1).isDisplayed();
    }

    @When("^the user is able to verify the presence of a date of announcement for the first result \"([^\"]*)\"$")
    public void theUserIsAbleToVerifyThePresenceOfADateOfAnnouncementForTheFirstResult(String arg1) throws Throwable {
        whatsMarketSearchResultsPage.resultDate(arg1).isDisplayed();
    }

    @When("^the user is able to verify the presence of the deal value for the first result \"([^\"]*)\"$")
    public void theUserIsAbleToVerifyThePresenceOfTheDealValueForTheFirstResult(String arg1) throws Throwable {
        whatsMarketSearchResultsPage.resultValue(arg1).isDisplayed();
    }

    @When("^the user is able to verify that a deal summary for the first result is not displayed \"([^\"]*)\"$")
    public void theUserIsAbleToVerifyThatADealSummaryForTheFirstResultIsNotDisplayed(String arg1) throws Throwable {
        Boolean isPresent = false;
        try {
            WebElement text = whatsMarketSearchResultsPage.resultSummary(arg1);
            text.isDisplayed();
            isPresent = true;
        } catch (Exception e) {
            LOG.info("context", e);
        }
        assertFalse(isPresent);
    }

    @Then("^the user can verify that the most detail icon is displayed$")
    public void theUserCanVerifyThatTheMostDetailIconForTermsInContextIsDisplayed() throws Throwable {
        assertTrue(searchResultsPage.isSliderSelectorDisplayed(SearchResultsPage.SliderSelector.MOST));
    }

    @When("^the user is able to verify the presence of a deal summary for the first result \"([^\"]*)\"$")
    public void theUserIsAbleToVerifyThePresenceOfADealSummaryForTheFirstResult(String arg1) throws Throwable {
        whatsMarketSearchResultsPage.resultSummary(arg1).isDisplayed();
    }

    @Then("^the user can select the option to show less detail$")
    public void theUserCanSelectTheOptionToShowLessDetail() throws Throwable {
        searchResultsPage.moreOrLessDetailAnchor().click();
        searchResultsPage.lessDetailOption().click();
    }

    @Then("^the user can verify that the less detail icon is displayed$")
    public void theUserCanVerifyThatTheLessDetailIconForTermsInContextIsDisplayed() throws Throwable {
        assertTrue(searchResultsPage.isSliderSelectorDisplayed(SearchResultsPage.SliderSelector.LESS));
    }

    @When("^the user is able to verify that a date of announcement for the first result is not displayed \"([^\"]*)\"$")
    public void theUserIsAbleToVerifyThatADateOfAnnouncementForTheFirstResultIsNotDisplayed(String arg1) throws Throwable {
        Boolean isPresent = false;
        try {
            WebElement text = whatsMarketSearchResultsPage.resultDate(arg1);
            text.isDisplayed();
            isPresent = true;
        } catch (Exception e) {
            LOG.info("context", e);
        }
        assertFalse(isPresent);
    }

    @When("^the user is able to verify that a deal value for the first result is not displayed \"([^\"]*)\"$")
    public void theUserIsAbleToVerifyThatADealValueForTheFirstResultIsNotDisplayed(String arg1) throws Throwable {
        Boolean isPresent = false;
        try {
            WebElement text = whatsMarketSearchResultsPage.resultValue(arg1);
            text.isDisplayed();
            isPresent = true;
        } catch (Exception e) {
            LOG.info("context", e);
        }
        assertFalse(isPresent);
    }

}

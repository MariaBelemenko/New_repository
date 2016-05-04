package com.thomsonreuters.khpadd.step_definitions.international;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.globalPage.GlobalCategoryPage;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.TopicPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Pavel_Ardenka on 03/05/2016.
 */
public class InternationalTest {

    private HomePage homePage = new HomePage();
    private CommonMethods commonMethods = new CommonMethods();
    private TopicPage topicPage = new TopicPage();
    private GlobalCategoryPage globalCategoryPage = new GlobalCategoryPage();

    @When("^the user selects \"(.*?)\" tab$")
    public void theUserSelectsTab(String tab) throws Throwable {
        homePage.specificTab(tab).click();
    }

    @When("^the user clicks on \"(.*?)\" link$")
    public void theUserClicksOnLink(String linkText) {
        commonMethods.clickLink(linkText);
        homePage.waitForPageToLoad();
        homePage.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^the user is presented with a page with header \"(.*?)\"$")
    public void theUserIsPresentedWithPageWithHeader(String header) {
        String topicPageHeader = topicPage.getPageHeaderLabel().getText();
        assertTrue(
                "Page header '" + topicPageHeader + "' does not contain expected text '" + header + "'",
                topicPageHeader.toLowerCase().contains(header.toLowerCase()));
    }

    @When("^the user clicks on the '(.*)' link on active tab$")
    public void clickLinkOnActiveTab(String linkText) {
        homePage.getActiveTabLink(linkText).click();
        homePage.waitForPageToLoad();
    }

    @Then("^the search results contains '(.*)' jurisdiction in each result$")
    public void checkThatSearchResultsContainsJurisdiction(String jurisdiction) {
        List<WebElement> resultsJurisdictions = globalCategoryPage.jurisdictionsInTheReturnedSearchResults();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(resultsJurisdictions.size())
                .withFailMessage("There are no search results")
                .isGreaterThan(0);
        // Just a counter for search results begins from the first result
        int i = 1;
        for (WebElement resultJurisdiction : resultsJurisdictions) {
            softAssertions.assertThat(resultJurisdiction.getText())
                    .withFailMessage("Result #" + i + " does not contain jurisdiction '" + jurisdiction + "'")
                    .contains(jurisdiction);
            i++;
        }
        softAssertions.assertAll();
    }
}

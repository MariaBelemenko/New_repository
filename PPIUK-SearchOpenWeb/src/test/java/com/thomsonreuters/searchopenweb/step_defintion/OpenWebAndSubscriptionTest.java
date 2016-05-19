package com.thomsonreuters.searchopenweb.step_defintion;

import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.pages.generic.PPIGenericDocDisplay;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawUKCategoryPage;
import com.thomsonreuters.pageobjects.pages.landingPage.ResourcesPage;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowDocumentPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.WhatsMarketSearchResultsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import static org.junit.Assert.assertFalse;

public class OpenWebAndSubscriptionTest extends BaseStepDef {

    private HomePage homePage;
    private ResourcesPage resourcesPage;
    private PracticalLawUKCategoryPage practicalLawUKCategoryPage;
    private PageActions pageActions;
    private SearchResultsPage searchResultsPage;
    private KnowHowSearchResultsPage knowHowSearchResultsPage;
    private KnowHowDocumentPage knowHowDocumentPage;
    private PPIGenericDocDisplay ppiGenericDocDisplay;
    private WhatsMarketSearchResultsPage whatsMarketSearchResultsPage;

    public OpenWebAndSubscriptionTest() {
        homePage = new HomePage();
        resourcesPage = new ResourcesPage();
        practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();
        pageActions = new PageActions();
        searchResultsPage = new SearchResultsPage();
        knowHowSearchResultsPage = new KnowHowSearchResultsPage();
        knowHowDocumentPage = new KnowHowDocumentPage();
        ppiGenericDocDisplay = new PPIGenericDocDisplay();
        whatsMarketSearchResultsPage = new WhatsMarketSearchResultsPage();
    }

    @Given("^the user selects the link to the Resource tab$")
    public void theUserSelectsTheLinkToTheResourceTab() throws Throwable {
        homePage.selectResourceTab();
    }

    @Given("^the user can verify that no link entitled \"(.*?)\" is present$")
    public void theUserCanVerifyThatNoLinkEntitledIsPresent(String arg1) throws Throwable {
        Boolean isPresent = false;
        try {
            WebElement text = resourcesPage.whatsMarketLink(arg1);
            text.isDisplayed();
            isPresent = true;
        } catch (Exception e) {
            LOG.info("context", e);
        }
        assertFalse(isPresent);
    }

    @Given("^the user can verify that a link entitled \"(.*?)\" is present$")
    public void theUserCanVerifyThataLinkEntitledIsPresent(String arg1) throws Throwable {
        resourcesPage.whatsMarketLink(arg1).isDisplayed();
    }

    @When("^the user runs a free text search for the query \"(.*)\"$")
    public void theUserRunsAFreeTextSearchForTheQuery(String query) throws Throwable {
        /**Paste string into the system clipboard instead*/
        StringSelection stringSelection = new StringSelection(query);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        /**Ensure the search button has rendered*/
        practicalLawUKCategoryPage.searchButton().isDisplayed();
        practicalLawUKCategoryPage.freeTextField().clear();
        /**SendKeys isn't always working*/
        /**Paste the clipboard text if the query contains brackets or ampersand*/
        if (query.contains("(") || query.contains(")") || query.contains("&")) {
            clpbrd.setContents(stringSelection, null);
            practicalLawUKCategoryPage.freeTextField().sendKeys(Keys.CONTROL + "v");
        } else {
            practicalLawUKCategoryPage.freeTextField().sendKeys(query);
        }
        if (practicalLawUKCategoryPage.getClass().equals(ChromeDriver.class)) {
            pageActions.keyPress(Keys.ENTER);
        } else {
            practicalLawUKCategoryPage.searchButton().click();
        }
        /**Wait for the results list to display*/
        theUserVerifiesThatTheResultsListPageIsDisplayed();
    }

    @When("^the user verifies that the results list page is displayed$")
    public void theUserVerifiesThatTheResultsListPageIsDisplayed() throws Throwable {
        SoftAssertions softly = new SoftAssertions();
        searchResultsPage.waitForPageToLoadAndJQueryProcessing();
        softly.assertThat(searchResultsPage.resultsListHeader().isDisplayed()).isTrue();
        softly.assertAll();
    }

    @Then("^the user can open the first know how search result \"(.*)\"$")
    public void theUserCanOpenTheFirstKnowHowSearchResult(String arg1) throws Throwable {
        knowHowSearchResultsPage.knowHowSearchResultTitle(arg1).click();
    }

    @Then("^the user is able to verify that a page of search results is displayed$")
    public void theUserIsAbleToVerifyThatAPageOfSearchResultsIsDisplayed() throws Throwable {
        knowHowSearchResultsPage.knowHowSearchResultTitle("1").isDisplayed();
    }

    @When("^the user is presented with a message offering a free trial in order to access the full resource$")
    public void theUserIsPresentedWithAMessageOfferingAFreeTrialInOrderToAccessTheFullResource() throws Throwable {
        knowHowDocumentPage.requestFreeTrialMessage().isDisplayed();
    }

    @Given("^has selected the link to the What's Market homepage$")
    public void hasSelectedTheLinkToTheWhatSMarketHomepage() throws Throwable {
        homePage.selectResourceTab();
        /**Ensure the page components have rendered*/
        ppiGenericDocDisplay.categoryTab().isDisplayed();
        ppiGenericDocDisplay.rightColumn().isDisplayed();
        homePage.selectLinkPresentOnTab("What's Market");
        ppiGenericDocDisplay.searchPageLabel().getText().equals("What's Market");
        /**Ensure the page components have rendered*/
        ppiGenericDocDisplay.categoryTab().isDisplayed();
        ppiGenericDocDisplay.rightColumn().isDisplayed();
    }

    @Then("^the user is presented with a message confirming that the user needs a whats market subscription to view the results$")
    public void theUserIsPresentedWithAMessageConfirmingThatTheUserNeedsAWhatsMarketSubscriptionToViewTheResults() throws Throwable {
        whatsMarketSearchResultsPage.subscriptionErrorMessage().isDisplayed();
    }

    @Then("^the user pauses for \"(.*?)\" seconds$")
    public void theUserPausesForSeconds(Integer timeToWait) throws Throwable {
        Robot robot = new Robot();
        timeToWait = timeToWait * 1000;
        robot.delay(timeToWait);
    }

    @When("^the user can verify that the document contains the header Also Found In$")
    public void theUserCanVerifyThatTheDocumentContainsTheHeaderAlsoFoundIn() throws Throwable {
        knowHowDocumentPage.getRelatedContentTopicsHeader().isDisplayed();
    }

}
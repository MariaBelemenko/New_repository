package com.thomsonreuters.linking.step_definitions;

import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawUKCategoryPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.TopicPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowDocumentPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import cucumber.api.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import static org.junit.Assert.assertTrue;

public class NavigateFromDocToTopicPgTest extends BaseStepDef {

    private PracticalLawUKCategoryPage practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();
    private PageActions pageActions = new PageActions();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private KnowHowDocumentPage knowHowDocumentPage = new KnowHowDocumentPage();
    private TopicPage topicPage = new TopicPage();

    @When("^the user runs a free text search for the query \"(.*)\"$")
    public void theUserRunsAFreeTextSearchForTheQuery(String query) throws Throwable {
        StringSelection stringSelection = new StringSelection(query);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        practicalLawUKCategoryPage.searchButton().isDisplayed();
        practicalLawUKCategoryPage.freeTextField().clear();
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
        theUserVerifiesThatTheResultsListPageIsDisplayed();
    }

    @When("^the user verifies that the results list page is displayed$")
    public void theUserVerifiesThatTheResultsListPageIsDisplayed() throws Throwable {
        Robot robot = new Robot();
        robot.delay(5000);
        try {
            searchResultsPage.resultsListHeader().isDisplayed();
            searchResultsPage.filterHeader().isDisplayed();
        } catch (Exception e) {
        }
    }

    @When("^the user opens the result in position \"(.*?)\"$")
    public void theUserOpenTheResultInPosition(String resultIndex) {
        knowHowSearchResultsPage.clickOnResultItem(Integer.parseInt(resultIndex));
    }

    @When("^the user verifies the presence of the Also Found In heading$")
    public void theUserVerifiesThePresenceOfTheAlsoFoundInHeading() throws Throwable {
        knowHowDocumentPage.alsoFoundInHeader().isDisplayed();
    }

    @When("^the user verifies the presence of a link entitled \"(.*)\"$")
    public void theUserVerifiesThePresenceOfALinkEntitled(String link) throws Throwable {
        knowHowDocumentPage.topicPageLink(link).isDisplayed();
    }

    @When("^the user selects the link entitled \"(.*)\"$")
    public void theUserSelectsTheLinkEntitled(String link) throws Throwable {
        knowHowDocumentPage.topicPageLink(link).click();
    }

    @When("^the user validates that the left hand table of contents is displayed$")
    public void theUserValidatesThatTheLeftHandTableOfContentsIsDisplayed() throws Throwable {
        knowHowDocumentPage.tableOfContentLeftHandTable().isDisplayed();
    }

    @When("^the user verifies that the topic page entitled \"(.*)\" is displayed to the user$")
    public void theUserVerifiesThatTheTopicPageEntitledIsDisplayedToTheUser(String topic) throws Throwable {
        String text = topicPage.topicPageTitle().getText();
        assertTrue(text.equals(topic));
    }

}

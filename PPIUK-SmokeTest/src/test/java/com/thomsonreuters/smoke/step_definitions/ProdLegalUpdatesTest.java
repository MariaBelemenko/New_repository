package com.thomsonreuters.smoke.step_definitions;

import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesPracticeAreaPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesResultsPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesTopicPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesWidget;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.CommonResourcePage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.documentNavigation.DocumentNavigationPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;
import java.lang.Thread;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ProdLegalUpdatesTest extends BaseStepDef {

    private LegalUpdatesWidget luWidget = new LegalUpdatesWidget();
    private LegalUpdatesResultsPage legalUpdatesResultsPage = new LegalUpdatesResultsPage();
    private DocumentNavigationPage documentNavigationPage = new DocumentNavigationPage();
    private CommonResourcePage commonResourcePage = new CommonResourcePage();
    private HomePage homepage = new HomePage();
    private LegalUpdatesTopicPage legalUpdatesTopicPage = new LegalUpdatesTopicPage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private LegalUpdatesPracticeAreaPage legalUpdatesPracticeAreaPage = new LegalUpdatesPracticeAreaPage();
    private WLNHeader wlnHeader = new WLNHeader();
    Thread thread;

    private String carousalDocumentName;

    @When("^the user clicks on the 'View all' link of the LU widget$")
    public void theUserClicksOnTheViewAllLinkOfTheLUWidget() throws Throwable {
        luWidget.veiwAllUpdatesLink().click();
        legalUpdatesResultsPage.waitForPageToLoad();
    }

    @Then("^the user should be presented with a list of LU documents$")
    public void theUserShouldBePresentedWithAListOfLUDocuments() throws Throwable {
        assertTrue("Results list is not displayed", legalUpdatesResultsPage.isResultsListDisplayed());
    }

    @Then("^the results should be sorted by date \\(most recent first\\)$")
    public void theResultsShouldBeSortedByDateMostRecentFirst() throws Throwable {
        List<Date> actualDates = legalUpdatesResultsPage.getPublishingDatesFromStatuses(legalUpdatesResultsPage.legalUpdatesStatuses());
        List<Date> expectedDates = actualDates;
        Collections.sort(expectedDates, Collections.reverseOrder());
        assertTrue("Dates on UI are not equal with sorted dates", actualDates.equals(expectedDates));
    }

    @Then("^the results should be from the relevant PA \"(.*?)\"$")
    public void theResultsShouldBeFromTheRelevantPA(String practiceAreaTag) throws Throwable {
        assertTrue("Results are not from relevant PA. Expected PA: " + practiceAreaTag + " actual PA: " + legalUpdatesResultsPage.headerMetaDataTagText(), legalUpdatesResultsPage.headerMetaDataTagText().contains(practiceAreaTag));
    }

    @When("^User is not able to see previous link in left hand side as carosal$")
    public void userIsNotAbleToSeePreviousDocumentNameLinkInLeftHandSideAsCarosal() throws Throwable {
        assertFalse(documentNavigationPage.isLeftCarosalLinkAvailable());
    }

    @Then("^the user stores title of (next|previous) legal update on carousal$")
    public void theUserStoresTitleOfNextPreviousLegalUpdateOnCarousal(String nextPrevious) throws Throwable {
        if (nextPrevious.equals("next")) {
            carousalDocumentName = documentNavigationPage.getDocumentNamePresentOnRightCarosal();
        } else if (nextPrevious.equals("previous")) {
            carousalDocumentName = documentNavigationPage.getDocumentNamePresentOnLeftCarosal();
        }
        LOG.info("Next legal update title is '" + carousalDocumentName + "'");
    }

    @When("^User clicks on next link in right hand side as carosal$")
    public void userClicksOnNextDocumentNameLinkInRightHandSideAsCarosal() throws Throwable {
        documentNavigationPage.clickOnRightCarosalLink();
    }

    @Then("^the user verifies he is on correct legal update on carousal$")
    public void theUserVerifiesHeIsOnCorrectLegalUpdateOnCarousal() throws Throwable {
        String pageTitle = commonResourcePage.title().getText().trim();
        assertThat(pageTitle, Is.is(carousalDocumentName));
    }

    @Then("^User is able to see previous link in left hand side as carosal$")
    public void userIsAbleToSeePreviousDocumentNameLinkInLeftHandSideAsCarosal() throws Throwable {
        assertTrue(documentNavigationPage.isRightCarosalLinkAvailable());
    }

    @When("^User clicks on previous link in left hand side as carosal$")
    public void userClicksOnPreviousDocumentNameLinkInLeftHandSideAsCarosal() throws Throwable {
        documentNavigationPage.clickOnLeftCarosalLink();
    }

    @Given("^a user navigate to a \"(.*?)\" Topic page from a \"(.*?)\" Practice Area page$")
    public void aUserNavigateToATopicPageFromAPracticeAreaPage(String topicName, String paName) throws Throwable {
        homepage.selectLinkPresentOnTab(paName);
        homepage.waitForPageToLoad();
        legalUpdatesTopicPage.topicsLink(topicName).click();
        legalUpdatesTopicPage.waitForPageToLoad();
    }

    @When("^the specific Subject Area \"([^\"]*)\" and its parent Practice Area \"([^\"]*)\" are displayed$")
    public void theSpecificSubjectAreaAndItsParentPracticeAreaAreDisplayed(String arg1, String arg2) throws Throwable {
        searchResultsPage.waitForPageToLoadAndJQueryProcessing();
        assertTrue(searchResultsPage.practiceAreaFacetHeader(arg1).isDisplayed());
        assertTrue(searchResultsPage.practiceAreaFacetHeader(arg2).isDisplayed());
    }

    @When("^the user is able to verify that the search result in position \"(.*?)\" within the result list has the resource type \"(.*?)\"$")
    public void theUserIsAbleToVerifyThatTheSearchResultInPositionWithinTheResultListHasTheResourceType(String arg1, String arg2) throws Throwable {
        String text = searchResultsPage.getWholeResultItemKnowHow(arg1);
        assertTrue(text.contains(arg2));
    }

    @Given("^a user is on the Legal Updates Home page$")
    public void aUserIsOnTheLegalUpdatesHomePage() throws Throwable {
        homepage.selectResourceTab();
        homepage.legalUpdatesContentLink().click();
        legalUpdatesPracticeAreaPage.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^the user verifies that the current PageTitle contains '(.*)'$")
    public void theUserVerifiesThatTheCurrentPageTitleContainsPageTitle(String pageTitle) throws Throwable {
        assertTrue("The Expected Page Title " + pageTitle + " is  NOT displayed", wlnHeader.pageHeaderLabel().getText().contains(pageTitle));
    }

    @When("^the user is able to verify that the search result in position \"(.*?)\" within the result list has the jurisdiction \"(.*?)\"$")
    public void theUserIsAbleToVerifyThatTheSearchResultInPositionWithinTheResultListHasTheJurisdictionJurisdiction(String arg1, String arg2) throws Throwable {
    	thread.sleep(5000);
        String text = searchResultsPage.getWholeResultItemKnowHow(arg1);
        thread.sleep(5000);
        assertTrue(text.contains(arg2));
    }

}

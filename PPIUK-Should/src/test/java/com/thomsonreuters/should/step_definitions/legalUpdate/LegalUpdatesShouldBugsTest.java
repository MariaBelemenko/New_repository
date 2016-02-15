package com.thomsonreuters.should.step_definitions.legalUpdate;

import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesPracticeAreaPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesResultsPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesTopicPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesWidget;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.should.step_definitions.BaseStepDef;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class LegalUpdatesShouldBugsTest extends BaseStepDef {

    private HomePage homepage = new HomePage();
    private LegalUpdatesTopicPage legalUpdatesTopicPage = new LegalUpdatesTopicPage();
    private LegalUpdatesPracticeAreaPage legalUpdatesPracticeAreaPage = new LegalUpdatesPracticeAreaPage();
    private LegalUpdatesWidget luWidget = new LegalUpdatesWidget();
    private LegalUpdatesResultsPage legalUpdatesResultsPage = new LegalUpdatesResultsPage();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();

    private List<String> updatesTitles;
    private List<String> updatesDates;

    @Given("^a user navigate to a \"(.*?)\" Topic page from a \"(.*?)\" Practice Area page$")
    public void aUserNavigateToATopicPageFromAPracticeAreaPage(String topicName, String paName) throws Throwable {
        homepage.selectLinkPresentOnTab(paName);
        homepage.waitForPageToLoad();
        legalUpdatesTopicPage.topicsLink(topicName).click();
        legalUpdatesTopicPage.waitForPageToLoad();
    }

    @Given("^the user is presented with the Legal Updates widget$")
    public void theUserIsPresentedWithTheLegalUpdatesWidget() throws Throwable {
        assertTrue("Legal Updates Widget is not displayed", legalUpdatesPracticeAreaPage.legalUpdatesWidget().isDisplayed());
    }

    @Given("^the user should see (\\d+) updates on a \"(.*?)\" widget$")
    public void theUserShouldSeeUpdatesOnAWidget(int titlesCount, String widgetName) throws Throwable {
        updatesTitles = luWidget.getAll5UpdatesTitles(widgetName);
        assertTrue("Titles count is more or less than 5. Actual titles count: " + updatesTitles.size(), updatesTitles.size() == titlesCount);
    }

    @Given("^\"(.*?)\" widget should display publication dates of documents$")
    public void widgetShouldDisplayPublicationDatesOfDocuments(String widgetName) throws Throwable {
        int result = 0;
        updatesDates = luWidget.getAllDatesFromWidget(widgetName);
        for (String date : updatesDates) {
            if (date.isEmpty()) {
                result++;
            }
        }
        assertTrue("Some dates from widget are not visible", updatesTitles.size() == updatesDates.size() && result == 0);
    }

    @When("^the user clicks on the 'View all' link of the \"(.*?)\" widget$")
    public void theUserClicksOnTheViewAllLinkOfTheWidget(String widgetName) throws Throwable {
        luWidget.veiwAllUpdatesLink(widgetName).click();
        legalUpdatesResultsPage.waitForPageToLoad();
    }

    @Then("^the user should be taken to the \"(.*?)\" Topic LU results list$")
    public void theUserShouldBeTakenToTheTopicLUResultsList(String topicName) throws Throwable {
        assertTrue("Topic name is incorrect. Actual: " + legalUpdatesResultsPage.headerMetaDataTagText(), legalUpdatesResultsPage.headerMetaDataTagText().contains(topicName));
    }

    @Then("^the user should be presented with a list of LU documents$")
    public void theUserShouldBePresentedWithAListOfLUDocuments() throws Throwable {
        assertTrue("Results list is not displayed", legalUpdatesResultsPage.isResultsListDisplayed());
    }

    @Then("^the user should see first five updates same as on widget$")
    public void theUserShouldSeeFirstFiveUpdatesSameAsOnWidget() throws Throwable {
        knowHowSearchResultsPage.waitForSearchResults();
        List<String> luTitlesFromResultsPage = legalUpdatesResultsPage.getFirstLU5Titles();
        assertTrue("First 5 updates on results page are inconsistent with updates from widget.Updates from widget: " + updatesTitles.toString() + " updates from LU page: " + luTitlesFromResultsPage.toString(), luTitlesFromResultsPage.containsAll(updatesTitles));
    }

    @Given("^a user is on the Legal Updates Home page$")
    public void aUserIsOnTheLegalUpdatesHomePage() throws Throwable {
        homepage.selectResourceTab();
        homepage.legalUpdatesContentLink().click();
        legalUpdatesPracticeAreaPage.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^the results should be from the relevant PA \"(.*?)\"$")
    public void theResultsShouldBeFromTheRelevantPA(String practiceAreaTag) throws Throwable {
        assertTrue("Results are not from relevant PA. Expected PA: " + practiceAreaTag + " actual PA: " + legalUpdatesResultsPage.headerMetaDataTagText(), legalUpdatesResultsPage.headerMetaDataTagText().contains(practiceAreaTag));
    }

}

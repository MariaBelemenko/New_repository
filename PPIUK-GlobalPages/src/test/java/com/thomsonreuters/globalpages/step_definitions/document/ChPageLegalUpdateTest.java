package com.thomsonreuters.globalpages.step_definitions.document;

import com.thomsonreuters.globalpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesPracticeAreaPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesResultsPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesWidget;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowDocumentPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ChPageLegalUpdateTest extends BaseStepDef {

    private LegalUpdatesWidget luWidget = new LegalUpdatesWidget();
    private LegalUpdatesResultsPage legalUpdatesResultsPage = new LegalUpdatesResultsPage();
    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();
    private LegalUpdatesPracticeAreaPage legalUpdatesPracticeAreaPage = new LegalUpdatesPracticeAreaPage();
    private LegalUpdatesWidget legalUpdatesWidget = new LegalUpdatesWidget();
    private KnowHowDocumentPage knowHowDocumentPage = new KnowHowDocumentPage();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();

    private final String RSS_PAGE_TITLE = "Subscribe to Practical Law updates via RSS";
    private List<String> updatesTitles;
    private List<String> updatesDates;

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

    @Given("^the user is presented with a 'RSS' link in the result page toolbar$")
    public void theUserIsPresentedWithARSSLinkInTheResultPageToolbar() throws Throwable {
        assertTrue("RSS link is absent on Legal Updates Results Page", legalUpdatesResultsPage.rssLink().isDisplayed());
    }

    @When("^the user clicks on this link$")
    public void theUserClicksOnThisLink() throws Throwable {
        legalUpdatesResultsPage.rssLink().click();
        standardDocumentPage.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^the user should be presented with the RSS information page$")
    public void theUserShouldBePresentedWithTheRSSInformationPage() throws Throwable {
        assertTrue("RSS button is absent on Legal Updates Widget", standardDocumentPage.documentTitle().getText().equals(RSS_PAGE_TITLE));
    }

    @Given("^the user is presented with the Legal Updates widget$")
    public void theUserIsPresentedWithTheLegalUpdatesWidget() throws Throwable {
        assertTrue("Legal Updates Widget is not displayed", legalUpdatesPracticeAreaPage.legalUpdatesWidget().isDisplayed());
    }

    @Given("^the user should be presented with an 'RSS' Link$")
    public void theUserShouldBePresentedWithAnRSSLink() throws Throwable {
        assertTrue("RSS button is absent on Legal Updates Widget", legalUpdatesWidget.isRssButtonDisplayed());
    }

    @When("^the user clicks on the RSS link$")
    public void theUserClicksOnTheRSSLink() throws Throwable {
        legalUpdatesWidget.rssButton().click();
        standardDocumentPage.waitForPageToLoadAndJQueryProcessing();
    }

    @When("^the user verifies that the product detail contains the practice area \"([^\"]*)\"$")
    public void theUserVerifiesThatTheProductDetailContainsThePracticeArea(String arg1) throws Throwable {
        assertTrue(knowHowDocumentPage.knowHowProductCodes(arg1).isDisplayed());
    }

    @Then("^the user should see first five updates same as on widget$")
    public void theUserShouldSeeFirstFiveUpdatesSameAsOnWidget() throws Throwable {
        knowHowSearchResultsPage.waitForSearchResults();
        List<String> luTitlesFromResultsPage = legalUpdatesResultsPage.getFirstLU5Titles();
        assertTrue("First 5 updates on results page are inconsistent with updates from widget.Updates from widget: " + updatesTitles.toString() + " updates from LU page: " + luTitlesFromResultsPage.toString(), luTitlesFromResultsPage.containsAll(updatesTitles));
    }

}

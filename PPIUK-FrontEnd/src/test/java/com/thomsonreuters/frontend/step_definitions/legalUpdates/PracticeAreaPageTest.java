package com.thomsonreuters.frontend.step_definitions.legalUpdates;

import com.thomsonreuters.frontend.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesPracticeAreaPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesResultsPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesTopicPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesWidget;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class PracticeAreaPageTest extends BaseStepDef {

    private LegalUpdatesPracticeAreaPage legalUpdatesPracticeAreaPage = new LegalUpdatesPracticeAreaPage();
    private LegalUpdatesTopicPage legalUpdatesTopicPage = new LegalUpdatesTopicPage();
    private LegalUpdatesWidget luWidget = new LegalUpdatesWidget();
    private LegalUpdatesResultsPage legalUpdatesResultsPage = new LegalUpdatesResultsPage();
    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();

    @Given("^a user is on a \"(.*?)\" PA page$")
    public void aUserIsOnAPAPage(String practiceArea) throws Throwable {
        legalUpdatesPracticeAreaPage.specificPracticeAreaLink(practiceArea).click();
        legalUpdatesTopicPage.waitForPageToLoad();
    }

    @When("^the user clicks on the 'View all' link of the LU widget$")
    public void theUserClicksOnTheViewAllLinkOfTheLUWidget() throws Throwable {
        luWidget.veiwAllUpdatesLink().click();
        legalUpdatesResultsPage.waitForPageToLoad();
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
        String RSS_PAGE_TITLE = "Subscribe to Practical Law updates via RSS";
        assertTrue("RSS button is absent on Legal Updates Widget", standardDocumentPage.documentTitle().getText().equals(RSS_PAGE_TITLE));
    }

}

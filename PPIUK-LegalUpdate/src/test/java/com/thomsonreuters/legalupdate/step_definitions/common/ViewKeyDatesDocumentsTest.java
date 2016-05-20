package com.thomsonreuters.legalupdate.step_definitions.common;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesPracticeAreaPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesTopicPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class ViewKeyDatesDocumentsTest extends BaseStepDef {

    private LegalUpdatesPracticeAreaPage legalUpdatesPracticeAreaPage = new LegalUpdatesPracticeAreaPage();
    private LegalUpdatesTopicPage legalUpdatesTopicPage = new LegalUpdatesTopicPage();
    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();

    @Given("^a user is on a \"(.*?)\" PA page$")
    public void aUserIsOnAPAPage(String practiceArea) throws Throwable {
        legalUpdatesPracticeAreaPage.specificPracticeAreaLink(practiceArea).click();
        legalUpdatesTopicPage.waitForPageToLoad();
    }

    @When("^the user clicks on the tab \"(.*?)\"$")
    public void theUserClicksOnTheTab(String tabName) throws Throwable {
        legalUpdatesTopicPage.specifiedTab(tabName).click();
        legalUpdatesTopicPage.waitForPageToLoad();
    }

    @When("^clicks on document link \"(.*?)\"$")
    public void clicksOnDocumentLink(String documentLink) throws Throwable {
        legalUpdatesTopicPage.linkOnTab(documentLink).click();
        legalUpdatesTopicPage.waitForPageToLoad();
    }

    @Then("^user should be presented with proper document \"(.*?)\"$")
    public void userShouldBePresentedWithProperDocument(String documentTitle) throws Throwable {
        assertTrue("Document title is incorrect. Actual title: " + standardDocumentPage.documentTitle().getText().trim(),
                standardDocumentPage.documentTitle().getText().trim().contains(documentTitle));
    }

}

package com.thomsonreuters.legalupdate.step_definitions.rss;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesResultsPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class LinkToRssFromLUResultsPageTest extends BaseStepDef {

    private LegalUpdatesResultsPage legalUpdatesResultsPage = new LegalUpdatesResultsPage();
    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();

    @Given("^the user is presented with a 'RSS' link in the result page toolbar$")
    public void theUserIsPresentedWithARSSLinkInTheResultPageToolbar() throws Throwable {
        assertTrue("RSS link is absent on Legal Updates Results Page", legalUpdatesResultsPage.rssLink().isDisplayed());
    }

    @When("^the user clicks on this link$")
    public void theUserClicksOnThisLink() throws Throwable {
        legalUpdatesResultsPage.rssLink().click();
        standardDocumentPage.waitForPageToLoadAndJQueryProcessing();
    }

}

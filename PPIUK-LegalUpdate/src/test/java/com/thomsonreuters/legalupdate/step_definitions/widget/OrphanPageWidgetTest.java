package com.thomsonreuters.legalupdate.step_definitions.widget;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawHomepage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesPracticeAreaPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class OrphanPageWidgetTest extends BaseStepDef {

    private PracticalLawHomepage practicalLawHomepage = new PracticalLawHomepage();
    private LegalUpdatesPracticeAreaPage legalUpdatesPracticeAreaPage = new LegalUpdatesPracticeAreaPage();

    @When("^a User is on a Orphan Practice Area browse page$")
    public void aUserIsOnAOrphanPracticeAreaBrowsePage() throws Throwable {
        practicalLawHomepage.legalUpdatesContentLink().click();
        legalUpdatesPracticeAreaPage.waitForPageToLoadAndJQueryProcessing();
        legalUpdatesPracticeAreaPage.legalUpdatesAllWidgetsLink().click();
        legalUpdatesPracticeAreaPage.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^they should be presented with a legal Updates widget on a Orphan Practice Area browse page$")
    public void theyShouldBePresentedWithALegalUpdatesWidgetOnAOrphanPracticeAreaBrowsePage() throws Throwable {
        assertTrue(legalUpdatesPracticeAreaPage.legalUpdatesWidget().isDisplayed());
    }

    @When("^User is on a Orphan Topic browse page$")
    public void userIsOnAOrphanTopicBrowsePage() throws Throwable {
    }

    @Then("^they should be presented with a legal Updates widget on a Orphan Topic browse page$")
    public void theyShouldBePresentedWithALegalUpdatesWidgetOnAOrphanTopicBrowsePage() throws Throwable {
    }

}

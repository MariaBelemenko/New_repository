package com.thomsonreuters.legalupdate.step_definitions.rss;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesPracticeAreaPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesResultsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;

public class ViewFeedBasedOnPATest extends BaseStepDef {

    private LegalUpdatesPracticeAreaPage legalUpdatesPracticeAreaPage = new LegalUpdatesPracticeAreaPage();
    private LegalUpdatesResultsPage legalUpdatesResultsPage = new LegalUpdatesResultsPage();

    @Given("^the legal updates page is based on a particular Practice area tag \"(.*?)\"$")
    public void theLegalUpdatesPageIsBasedOnAParticularPracticeAreaTag(String linkText) throws Throwable {
        legalUpdatesPracticeAreaPage.specificPracticeAreaLink(linkText).click();
        legalUpdatesResultsPage.waitForPageToLoad();
    }

    @Then("^the user should be displayed a feed of Legal Updates for that Practice Area \"(.*?)\"$")
    public void theUserShouldBeDisplayedAFeedOfLegalUpdatesForThatPracticeArea(String practiceAreaTag) throws Throwable {
        assertTrue("LU are not for that PA. Actual PA is: " + legalUpdatesResultsPage.headerMetaDataTagText(),
                legalUpdatesResultsPage.headerMetaDataTagText().contains(practiceAreaTag));
    }

    @Then("^the 'Practice Area' facets should be pre-scoped to the \"(.*?)\" PA that the user had come from$")
    public void thePracticeAreaFacetsShouldBePreScopedToThePAThatTheUserHadComeFrom(String practiceArea) throws Throwable {
        assertTrue("Prescoped value for practice are is incorrect. Actual value: " + legalUpdatesResultsPage.getfacetSubTitleText(),
                legalUpdatesResultsPage.getfacetSubTitleText().contains(practiceArea));
    }

}

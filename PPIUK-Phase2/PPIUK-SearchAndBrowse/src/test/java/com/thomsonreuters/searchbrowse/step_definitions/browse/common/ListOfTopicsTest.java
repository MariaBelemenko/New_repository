package com.thomsonreuters.searchbrowse.step_definitions.browse.common;

import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawHomepage;
import com.thomsonreuters.pageobjects.pages.researchBrowse.RBContentTypePAPage;
import com.thomsonreuters.pageobjects.pages.researchBrowse.RBPLHomePage;
import com.thomsonreuters.pageobjects.utils.researchBrowse.PATopicLinks;
import com.thomsonreuters.pageobjects.utils.researchBrowse.ResearchContentTypeEnum;
import com.thomsonreuters.searchbrowse.step_definitions.BaseStepDef;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class ListOfTopicsTest extends BaseStepDef {

    private NavigationCobalt navigation = new NavigationCobalt();
    private PracticalLawHomepage practicalLawHomepage = new PracticalLawHomepage();
    private RBPLHomePage rbplHomePage = new RBPLHomePage();
    private RBContentTypePAPage contentTypePAPage = new RBContentTypePAPage();

    @Given("^user navigates to RB PLC Home Page$")
    public void userNavigatesToRBPLCHomePage() throws Throwable {
        navigation.navigateToPLCUKPlusSpecificURL("/Browse/Home/RBHome");
        practicalLawHomepage.waitForPageToLoadAndJQueryProcessing();
        assertThat(rbplHomePage.pageHeading().getText().trim(), Is.is("RBHome"));
    }

    @When("^user navigates directly to (.*) Page$")
    public void userNavigatesDirectlyToJournalsTaxPracticeAreaPage(ResearchContentTypeEnum researchPracticeArea) throws Throwable {
        navigation.navigateToPLCUKPlusSpecificURL(researchPracticeArea.getRelativeUrl());
        practicalLawHomepage.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^topic links for Tax Practice Area are displayed$")
    public void topicLinksForTaxPracticeAreaAreDisplayed() throws Throwable {
        Map<String, List> actual = contentTypePAPage.listOfTopicsWithHeadings();
        assertThat(actual, Is.is(PATopicLinks.TAX));
    }

}

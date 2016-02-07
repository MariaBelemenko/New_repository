package com.thomsonreuters.legalupdate.step_definitions.search;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesResultsPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrescopingFacetsAndSortingByDateOnResultsPageTest extends BaseStepDef {

    private LegalUpdatesResultsPage legalUpdatesResultsPage = new LegalUpdatesResultsPage();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();

    private List<Date> actualDates;
    private List<Date> expectedDates;

    @Then("^the user should be presented with a list of LU documents$")
    public void theUserShouldBePresentedWithAListOfLUDocuments() throws Throwable {
        assertTrue("Results list is not displayed", legalUpdatesResultsPage.isResultsListDisplayed());
    }

    @Then("^the results should be from the relevant PA \"(.*?)\"$")
    public void theResultsShouldBeFromTheRelevantPA(String practiceAreaTag) throws Throwable {
        assertTrue("Results are not from relevant PA. Expected PA: " + practiceAreaTag + " actual PA: " + legalUpdatesResultsPage.headerMetaDataTagText(),
                legalUpdatesResultsPage.headerMetaDataTagText().contains(practiceAreaTag));
    }

    @Then("^the user should be displayed the child topics of that practice area$")
    public void theUserShouldBeDisplayedTheChildTopicsOfThatPracticeArea() throws Throwable {
        assertTrue("Child topics menu is not displayed", legalUpdatesResultsPage.isChildTopicsFacetsDisplayed());
    }

    @Then("^the user should be able to select the child topics of that practice area to filter the results$")
    public void theUserShouldBeAbleToSelectTheChildTopicsOfThatPracticeAreaToFilterTheResults() throws Throwable {
        int result = 0;
        knowHowSearchResultsPage.clickOnSelectMultipleFilters();
        List<WebElement> childFacetsCheckboxes = legalUpdatesResultsPage.allPAFacetsChildCheckBoxes();
        for (WebElement chekcbox : childFacetsCheckboxes)
            if (!legalUpdatesResultsPage.isCheckBoxSelectable(chekcbox)) {
                result++;
            }
        assertTrue("One of checkboxes for is not editable", result == 0);
    }

    @Then("^the results should be sorted by date \\(most recent first\\)$")
    public void theResultsShouldBeSortedByDateMostRecentFirst() throws Throwable {
        actualDates = legalUpdatesResultsPage.getPublishingDatesFromStatuses(legalUpdatesResultsPage.legalUpdatesStatuses());
        expectedDates = actualDates;
        Collections.sort(expectedDates, Collections.reverseOrder());
        assertTrue("Dates on UI are not equal with sorted dates", actualDates.equals(expectedDates));
    }

    @Then("^the user should not be presented with the sort order drop down$")
    public void theUserShouldNotBePresentedWithTheSortOrderDropDown() throws Throwable {
        assertFalse("Sort dropdown is visible", legalUpdatesResultsPage.isSortDropDownDisplayed());
    }

    @Then("^the user should not be presented with any 'Resource type' faceting$")
    public void theUserShouldNotBePresentedWithAnyResourceTypeFaceting() throws Throwable {
        assertFalse("Resource Type faceting is visible", legalUpdatesResultsPage.isResourceTypeFilterDisplayed());
    }

    @Then("^the user should be taken to the \"(.*?)\" Topic LU results list$")
    public void theUserShouldBeTakenToTheTopicLUResultsList(String topicName) throws Throwable {
        assertTrue("Topic name is incorrect. Actual: " + legalUpdatesResultsPage.headerMetaDataTagText(),
                legalUpdatesResultsPage.headerMetaDataTagText().contains(topicName));
    }

    @Then("^the 'Practice Area' facets should be pre-scoped to the \"(.*?)\" Topic that the user had come from$")
    public void thePracticeAreaFacetsShouldBePreScopedToTheTopicThatTheUserHadComeFrom(String topicName) throws Throwable {
        assertTrue("Prescoped value for topic is incorrect. Actual is: " + legalUpdatesResultsPage.getfacetSubTitleText(),
                legalUpdatesResultsPage.getfacetSubTitleText().contains(topicName));
    }

}

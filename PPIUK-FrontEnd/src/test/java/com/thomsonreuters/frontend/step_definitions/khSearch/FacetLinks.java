package com.thomsonreuters.frontend.step_definitions.khSearch;

import com.thomsonreuters.frontend.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.folders.ResearchOrganizerPage;
import com.thomsonreuters.pageobjects.pages.search.CasesSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FacetLinks extends BaseStepDef {

    private CommonMethods commonMethods = new CommonMethods();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private ResearchOrganizerPage researchOrganizerPage = new ResearchOrganizerPage();
    private CasesSearchResultsPage casesSearchResultsPage = new CasesSearchResultsPage();

    @When("^the user selects the know how following parent facets$")
    public void theUserSelectsTheKnowHowFollowingParentFacets(List<String> facets) throws Throwable {
        WebElement multipleFilterButton = commonMethods.waitForElementToBeVisible(researchOrganizerPage.selectMultipleByFilters(), 1000);
        if (multipleFilterButton != null) {
            multipleFilterButton.click();
        }
        for (String facet : facets) {
            knowHowSearchResultsPage.knowHowFacetCheckbox(facet).click();
            assertTrue("Check box not selected..!", isCheckboxSelected(facet));
        }
    }

    @When("^the user selects the know how option to apply filters$")
    public void theUserSelectsTheKnowHowOptionToApplyFilters() throws Throwable {
        knowHowSearchResultsPage.executeScript("scroll(250,0);");
        knowHowSearchResultsPage.applyFiltersButton().click();
        knowHowSearchResultsPage.waitForSearchResults();
    }

    @When("^the user verifies that the know how following facet is selected$")
    public void theUserVerifiesThatTheKnowHowFollowingFacetIsSelected(List<String> facets) throws Throwable {
        for (String facet : facets) {
            assertTrue(knowHowSearchResultsPage.knowHowFacetCheckbox(facet).isSelected());
        }
    }

    @When("^the user clicks on clear all link$")
    public void theUserClicksOnClearAllLink() throws Throwable {
        knowHowSearchResultsPage.executeScript("scroll(250,0);");
        knowHowSearchResultsPage.clearAllLink().click();
    }

    @Then("^the user verifies that the following parent facets are not selected$")
    public void theUserVerifiesThatTheFollowingParentFacetsIsNotSelected(List<String> facets) throws Throwable {
        commonMethods.waitForElement(knowHowSearchResultsPage.resourceTypeFacetGroupByTitle(), 2000);
        for (String facet : facets) {
            assertFalse(facet + " is still Selected..!", casesSearchResultsPage.facetCheckbox(facet).isSelected());
        }
    }

    private boolean isCheckboxSelected(String facet) {
        for (int i = 0; i < 3; i++) {
            if (!knowHowSearchResultsPage.knowHowFacetCheckbox(facet).isSelected()) {
                knowHowSearchResultsPage.practiceAreaFacetLabel().click();
                knowHowSearchResultsPage.knowHowFacetCheckbox(facet).click();
            } else {
                return true;
            }
        }
        return false;
    }

}

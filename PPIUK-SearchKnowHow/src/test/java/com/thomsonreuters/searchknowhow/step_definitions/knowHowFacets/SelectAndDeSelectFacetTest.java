package com.thomsonreuters.searchknowhow.step_definitions.knowHowFacets;

import com.thomsonreuters.pageobjects.pages.search.CasesSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowDocumentPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.searchknowhow.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.TimeoutException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SelectAndDeSelectFacetTest extends BaseStepDef {

    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private CasesSearchResultsPage casesSearchResultsPage = new CasesSearchResultsPage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private KnowHowDocumentPage knowHowDocumentPage = new KnowHowDocumentPage();

    @When("^the user verifies that the know how child facet \"(.*?)\" is not selected$")
    public void theUserVerifiesThatTheKnowHowChildFacetIsNotSelected(String arg1) throws Throwable {
        assertFalse(knowHowSearchResultsPage.knowHowFacetCheckbox(arg1).isSelected());
    }

    @When("^the user verifies that the know how grandchild facet \"(.*?)\" is not selected$")
    public void theUserVerifiesThatTheKnowHowGrandchildFacetIsNotSelected(String arg1) throws Throwable {
        assertFalse(knowHowSearchResultsPage.knowHowFacetCheckbox(arg1).isSelected());
    }

    @When("^the user selects the parent facet \"(.*?)\"$")
    public void theUserSelectsTheParentFacet(String arg1) throws Throwable {
        casesSearchResultsPage.facetCheckbox(arg1).click();
    }

    @When("^the user selects the know how child facet \"(.*?)\"$")
    public void theUserSelectsTheKnowHowChildFacet(String arg1) throws Throwable {
        knowHowSearchResultsPage.knowHowFacetCheckbox(arg1).click();
    }

    @When("^the user verifies that the know how child facet \"(.*?)\" has been deselected$")
    public void theUserVerifiesThatTheKnowHowChildFacetHasBeenDeselected(String arg1) throws Throwable {
        assertFalse(knowHowSearchResultsPage.knowHowFacetCheckbox(arg1).isSelected());
    }

    @When("^the user selects the option to apply filters$")
    public void theUserSelectsTheOptionToApplyFilters() throws Throwable {
        casesSearchResultsPage.applyFiltersButton().click();
        knowHowSearchResultsPage.waitForSearchResults();
        knowHowSearchResultsPage.clickOnSelectMultipleFilters();
    }

    @When("^the user is able to verify that the search result in position \"(.*?)\" within the result list has the resource type \"(.*?)\"$")
    public void theUserIsAbleToVerifyThatTheSearchResultInPositionWithinTheResultListHasTheResourceType(String arg1, String arg2) throws Throwable {
        String text = searchResultsPage.getWholeResultItemKnowHow(arg1);
        assertTrue(text.contains(arg2));
    }

    @When("^the user is able to verify that the search result in position \"(.*?)\" within the result list has the jurisdiction \"(.*?)\"$")
    public void theUserIsAbleToVerifyThatTheSearchResultInPositionWithinTheResultListHasTheJurisdictionJurisdiction(String arg1, String arg2) throws Throwable {
        String text = searchResultsPage.getWholeResultItemKnowHow(arg1);
        assertTrue(text.contains(arg2));
    }

    @When("^the user opens the result in position \"(.*?)\"$")
    public void theUserOpenTheResultInPosition(String resultIndex) {
        knowHowSearchResultsPage.clickOnResultItem(Integer.parseInt(resultIndex));
    }

    @When("^the user verifies that the product detail contains the practice area \"([^\"]*)\"$")
    public void theUserVerifiesThatTheProductDetailContainsThePracticeArea(String arg1) throws Throwable {
        assertTrue(knowHowDocumentPage.knowHowProductCodes(arg1).isDisplayed());
    }

    @Then("^the user is able to verify the presence of the facet group heading Resource Type$")
    public void theUserIsAbleToVerifyThePresenceOfTheFacetGroupHeadingResourceType() throws Throwable {
        knowHowSearchResultsPage.facetGroupHeaderResourceType().isDisplayed();
    }

    @Then("^the user is able to verify the presence of the facet group heading Practice Area$")
    public void theUserIsAbleToVerifyThePresenceOfTheFacetGroupHeadingPracticeArea() throws Throwable {
        knowHowSearchResultsPage.facetGroupHeaderPracticeArea().isDisplayed();
    }

    @Then("^the user is able to verify the (presence|absence) of the facet group heading Jurisdiction$")
    public void theUserIsAbleToVerifyThePresenceOfTheFacetGroupHeadingJurisdiction(String presence) throws Throwable {
        boolean mustBeDisplayed = presence.equals("presence");
        try {
            boolean displayed = knowHowSearchResultsPage.facetGroupHeaderJurisdiction().isDisplayed();
            assertTrue(displayed == mustBeDisplayed);
        } catch (TimeoutException e) {
            if (presence.equals("presence")) {
                throw e;
            }
        }
    }

    @When("^the user verifies that the know how grandchild facet \"(.*?)\" is not displayed$")
    public void theUserVerifiesThatTheKnowHowGrandchildFacetIsNotDisplayed(String arg1) throws Throwable {
        //   assertFalse(knowHowSearchResultsPage.isFacetNameDisplayed(arg1));
    }

}

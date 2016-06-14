package com.thomsonreuters.searchknowhow.step_definitions.knowHowFacets;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.common.SortOptions;
import com.thomsonreuters.pageobjects.pages.search.CasesSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchHomePage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.pageobjects.utils.search.SearchUtils;
import com.thomsonreuters.searchknowhow.step_definitions.BaseStepDef;
import com.thomsonreuters.searchknowhow.step_definitions.knowHowDelivery.KnowHowDeliveryTest;
import cucumber.api.Transpose;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Keys;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KnowHowFacetsFunctionalityTest extends BaseStepDef {

    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private CommonMethods commonMethods = new CommonMethods();
    private SearchHomePage searchHomePage = new SearchHomePage();
    private SearchUtils searchUtils = new SearchUtils();
    private CasesSearchResultsPage casesSearchResultsPage = new CasesSearchResultsPage();
    public Map<String,String> facetsInputMap;
    Integer[] resultArray = new Integer[10];
    private int facetsDocsCount = 0;
    private PageActions pageActions = new PageActions();

    @Then("^the user is able to check whether the option to apply filters is displayed and  if not to ensure that it is$")
    public void theUserIsAbleToCheckWhetherTheOptionToApplyFiltersIsDisplayedAndIfNotToEnsureThatItIs() {
        boolean isVisible;
        try {
            if (knowHowSearchResultsPage.selectMultipleFiltersButton().isDisplayed()) {
                isVisible = true;
                assertTrue("The option to apply filters is not present", isVisible);
                knowHowSearchResultsPage.clickOnSelectMultipleFilters();
            }
        } catch (Exception e) {
            LOG.info("The option to apply filters is not displayed or it is absent", e);
        }
    }

    @When("^the user selects the know how parent facet \"(.*?)\"$")
    public void theUserSelectsTheKnowHowParentFacet(String arg1) throws Throwable {
        knowHowSearchResultsPage.knowHowFacetCheckbox(arg1).click();
    }

    @Then("^the user verifies that the know how facet is selected \"(.*?)\"$")
    public void theUserVerifiesThatTheKnowHowFacetIsSelected(String arg1) throws Throwable {
        assertTrue(knowHowSearchResultsPage.knowHowFacetCheckbox(arg1).isSelected());
    }

    @And("^the user selects the know how option to apply filters$")
    public void theUserSelectsTheKnowHowOptionToApplyFilters() throws Throwable {
       // ((JavascriptExecutor) knowHowSearchResultsPage).executeScript("scroll(250,0);");
        knowHowSearchResultsPage.applyFiltersButton().click();
        knowHowSearchResultsPage.waitForSearchResults();
    }

    @And("^the user gets the know how facet \"(.*?)\" count and stores it as count \"(.*?)\"$")
    public void theUserGetsTheKnowHowFacetCountAndStoresItAsCount(String arg1, Integer count) throws Throwable {
        /** Captures the page object text value and stores it in the "numberReturnedFromWebsite" string */
        String numberReturnedFromWebsite = knowHowSearchResultsPage.facetCount(arg1).getText();
        /** To make sure the string is only a number we remove any non-numeric characters */
        numberReturnedFromWebsite = numberReturnedFromWebsite.replaceAll("[^0-9]", "");
        /** Stores the value from "numberReturnedFromWebsite" in the resultArray whilst at the same time converting it to a number */
        resultArray[count] = Integer.parseInt(numberReturnedFromWebsite);
    }

    @Then("^the user verifies that the know how search result count \"(.*?)\" equals facet count \"(.*?)\"$")
    public void theUserVerifiesThatTheKnowHowSearchResultCountEqualsFacetCount(Integer count1, Integer count2) throws Throwable {
        LOG.info(Integer.toString(resultArray[count1]));
        LOG.info(Integer.toString(resultArray[count2]));
        assertTrue(resultArray[count1] == resultArray[count2]);
    }

    @When("^the user deselects the know how facet \"(.*?)\"$")
    public void theUserDeselectsTheKnowHowFacet(String arg1) throws Throwable {
        knowHowSearchResultsPage.facetName(arg1).click();
    }

    @Then("^the user verifies that the know how parent facet \"(.*?)\" is not selected$")
    public void theUserVerifiesThatTheKnowHowParentFacetIsNotSelected(String arg1) throws Throwable {
        assertFalse(knowHowSearchResultsPage.knowHowFacetCheckbox(arg1).isSelected());
    }

    @When("^the user verifies the presence of the know how facet groups$")
    public void theUserVerifiesThePresenceOfTheKnowHowFacetGroups() throws Throwable {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(knowHowSearchResultsPage.facetGroupHeaderResourceType().isDisplayed()).withFailMessage("The facet group header resource type is not present");
        softly.assertThat(knowHowSearchResultsPage.facetGroupHeaderPracticeArea().isDisplayed()).withFailMessage("The facet group header practice area is not present");
        softly.assertThat(knowHowSearchResultsPage.facetGroupHeaderJurisdiction().isDisplayed()).withFailMessage("The facet group header jurisdiction is not present");
        softly.assertAll();
    }

    @And("^the user runs a search with below queries and verify that discards all selected facets$")
    public void testFacetSelectionWithMultipleSearch(List<String> queryStrings) throws Throwable {
        KnowHowDeliveryTest knowHowDeliveryTest = new KnowHowDeliveryTest();

        for (String queryString : queryStrings) {
            knowHowDeliveryTest.theUserRunsAFreeTextSearchForTheQuery(queryString);

            if (facetsInputMap != null) {
                for (String key : facetsInputMap.keySet()) {
                    assertFalse(knowHowSearchResultsPage.isFacetSelected(key, facetsInputMap.get(key).split("_")));
                }
            }
        }
    }

    @Then("^the user verifies that know how \"(.*?)\" facet \"(.*?)\" is not selected$")
    public void isFacetNotSelected(String facetType, String facet) throws Throwable {
        assertFalse(knowHowSearchResultsPage.isFacetSelected(facetType, facet.split("_")));
    }

    @And("^the user selects the know how \"(.*?)\" facet \"(.*?)\"$")
    public void theUserSelectsTheFacet(String facetType, String facet) throws Throwable {
        knowHowSearchResultsPage.selectFacetCheckBox(facetType, facet.split("_"));
    }


    @And("^the user verifies that know how \"(.*?)\" facet \"(.*?)\" is selected$")
    public void isFacetSelected(String facetType, String facet) throws Throwable {
        if(facetsInputMap == null){
            facetsInputMap = new HashMap<String, String>();
        }
        facetsInputMap.put(facetType,facet);
        assertTrue(knowHowSearchResultsPage.isFacetSelected(facetType, facet.split("_")));
    }

    @And("^the user can select the filter mode cancel option$")
    public void theUserCanSelectTheFilterModeCancelOption() throws Throwable {
        searchResultsPage.cancelFilters().click();
    }

    @Then("^the user can verify the presence of the option entitled select multiple filters$")
    public void theUserCanVerifyThePresenceOfTheOptionEntitledSelectMultipleFilters() throws Throwable {
        searchResultsPage.selectMultipleFilters().isDisplayed();
    }

    @And("^the user verifies that the facet count for all the individual facets is not \"(.*?)\"$")
    public void theUserVerifiesThatTheFacetCountForAllTheIndividualFacetsIsNot(String arg1) throws Throwable {
        assertFalse(knowHowSearchResultsPage.isFacetCountPresent(arg1));
    }

    @And("^the user verifies that the facet count for all the individual facets does not contain \"(.*?)\"$")
    public void theUserVerifiesThatTheFacetCountForAllTheIndividualFacetsDoesNotContains(String arg1) throws Throwable {
        assertFalse(knowHowSearchResultsPage.isFacetCountPresent(arg1));
    }

    @Then("^the user is able to verify the presence of the know how facets$")
    public void theUserIsAbleToVerifyThePresenceOfTheKnowHowFacet(List<String> list) throws Throwable {
        for (String facet : list) {
            assertTrue(knowHowSearchResultsPage.facetName(facet).isDisplayed());
        }
    }

    @And("^the user verifies \"(.*?)\" facets appear in alphabetical order$")
    public void theUserVerifiesKnowHowPracticeAreaFacetsAppearInAlphabeticalOrder(String arg1) throws Throwable {
        Boolean isAlphabeticalOrder = true;
        List<String> actualPracticeArea = knowHowSearchResultsPage.getMainPracticeAreaFacets(arg1);
        if (actualPracticeArea.contains("EU")) {
            int index = actualPracticeArea.indexOf("EU");
            actualPracticeArea.set(index, actualPracticeArea.get(index).replace('U', 'u'));
        }
        assertTrue(commonMethods.isSorted(actualPracticeArea, SortOptions.ASC));
    }

    @When("^the user expands the know how facet \"(.*?)\"$")
    public void theUserExpandsTheKnowHowFacet(String arg1) throws Throwable {
        knowHowSearchResultsPage.expandFacet(arg1).click();
    }

    @And("^the user is able to verify the presence of the know how facet \"(.*?)\"$")
    public void theUserIsAbleToVerifyThePresenceOfTheKnowHowFacet(String arg1) throws Throwable {
        knowHowSearchResultsPage.facetName(arg1).isDisplayed();
    }

    @And("^the user verifies know how child Practice Area \"(.*?)\" facets appear in alphabetical order$")
    public void theUserVerifiesKnowHowChildPracticeAreaFacetsAppearInAlphabeticalOrder(String arg1) throws Throwable {
        Boolean isAlphabeticalOrder = true;
        List<String> actualPracticeArea = knowHowSearchResultsPage.getChildPracticeAreaFacets(arg1);
        String previous = ""; // empty string: guaranteed to be less than or equal to any other
        for (final String current : actualPracticeArea) {
            if (current.compareTo(previous) < 0)
                isAlphabeticalOrder = false;
            previous = current;
        }
        assertTrue(isAlphabeticalOrder);
    }

    @And("^the user verifies know how grandchild Practice Area \"(.*?)\" facets appear in alphabetical order$")
    public void theUserVerifiesKnowHowGrandchildPracticeAreaFacetsAppearInAlphabeticalOrder(String arg1) throws Throwable {
        Boolean isAlphabeticalOrder = true;
        List<String> actualPracticeArea = knowHowSearchResultsPage.getGrandchildPracticeAreaFacets(arg1);
        /** Empty string: guaranteed to be less than or equal to any other */
        String previous = "";
        for (final String current : actualPracticeArea) {
            if (current.compareTo(previous) < 0)
                isAlphabeticalOrder = false;
            previous = current;
        }
        assertTrue(isAlphabeticalOrder);
    }

    @Then("^the user can verify the presence of a child topic entitled \"(.*?)\"$")
    public void theUserCanVerifyThePresenceOfAChildTopicEntitled(String arg1) throws Throwable {
        knowHowSearchResultsPage.facetName(arg1).isDisplayed();
    }

    @When("^the user collapses the know how facet \"(.*?)\"$")
    public void theUserCollapsesTheKnowHowFacet(String arg1) throws Throwable {
        knowHowSearchResultsPage.collapseFacet(arg1).click();
    }

    @Then("^the user can verify that the topic is no longer displayed \"(.*?)\"$")
    public void theUserCanVerifyThatTheTopicIsNoLongerDisplayed(String arg1) throws Throwable {
        boolean isVisible = false;
        try {
            isVisible = knowHowSearchResultsPage.facetName(arg1).isDisplayed();
        } catch (Exception e) {
            LOG.info("The user can't verify the topic is no longer present", e);
        }
        assertFalse(isVisible);
    }

    @And("^the user verifies the presence of the know how facet \"(.*?)\"$")
    public void theUserVerifiesThePresenceOfTheKnowHowFacet(String arg1) throws Throwable {
        knowHowSearchResultsPage.facetName(arg1).isDisplayed();
    }

    @Then("^the user verifies the presence of the know how child facet \"(.*?)\"$")
    public void theUserVerifiesThePresenceOfTheKnowHowChildFacet(String arg1) throws Throwable {
        knowHowSearchResultsPage.facetName(arg1).isDisplayed();
    }

    @And("^the user verifies that the know how child facet \"(.*?)\" is not displayed$")
    public void theUserVerifiesThatTheKnowHowChildFacetIsNotDisplayed(String arg1) throws Throwable {
        //     assertFalse(knowHowSearchResultsPage.isFacetNameDisplayed(arg1));
    }

    @When("^the user starts a new record of facet counts$")
    public void theUserStartsANewRecordOfFacetCounts() throws Throwable {
        Arrays.fill(resultArray, null);
    }

    @And("^the user verifies that the know how facet count \"(.*?)\" is less than \"(.*?)\"$")
    public void theUserVerifiesThatTheKnowHowFacetCountIsLessThan(Integer count1, Integer count2) throws Throwable {
        System.out.println(Integer.toString(resultArray[count2]) + " **********");
        assertTrue(resultArray[count1] < resultArray[count2]);
    }

    @And("^the user gets the know how search result count and stores it as count \"(.*?)\"$")
    public void theUserGetsTheKnowHowSearchResultCountAndStoresItAsCount(Integer count) throws Throwable {
        String numberReturnedFromWebsite = knowHowSearchResultsPage.knowHowSearchResultCount().getText();
        numberReturnedFromWebsite = numberReturnedFromWebsite.replaceAll("[^0-9]", "");
        resultArray[count] = Integer.parseInt(numberReturnedFromWebsite);
        LOG.info("Storing count " + Integer.toString(resultArray[count]) + " in result " + Integer.toString(count) + " **********");
    }

    @And("^the user verifies the presence of an associated know how facet \"(.*?)\" count$")
    public void theUserVerifiesThePresenceOfAnAssociatedKnowHowFacetCount(String arg1) throws Throwable {
        knowHowSearchResultsPage.facetCount(arg1).isDisplayed();
    }

    @And("^the user verifies that the know how search result count \"(.*?)\" exceeds facet count \"(.*?)\"$")
    public void theUserVerifiesThatTheKnowHowSearchResultCountExceedsFacetCount(Integer count1, Integer count2) throws Throwable {
        assertTrue(resultArray[count1] > resultArray[count2]);
    }

    @And("^the user verifies that the know how facet count \"(.*?)\" equals count \"(.*?)\"$")
    public void theUserVerifiesThatTheKnowHowFacetCountEqualsCount(Integer count1, Integer count2) throws Throwable {
        assertTrue(resultArray[count1] == resultArray[count2]);
    }

    @When("^the user searches for \"(.*?)\"$")
    public void searchFor(String searchQuery) {
        searchHomePage.enterSearchText(searchQuery);
        pageActions.keyPress(Keys.ENTER);
        searchHomePage.waitForPageToLoad();
        searchHomePage.waitForPageToLoadAndJQueryProcessing();
    }

    @And("^the user applies multiple filters$")
    public void selectCoupleOfFilters(@Transpose List<String> filterNames) {
        for (String filterName : filterNames) {
            knowHowSearchResultsPage.getFacetCheckbox(filterName).click();
            facetsDocsCount += commonMethods.getIntFromString(knowHowSearchResultsPage.facetCount(filterName).getText());
        }
        if (!knowHowSearchResultsPage.isCancelButtonExists()) { // Filter state can be stored after previous sessions
            knowHowSearchResultsPage.selectMultipleFiltersButton().click();
        }
        knowHowSearchResultsPage.applyFiltersButton().click();
        knowHowSearchResultsPage.waitForPageToLoad();
        knowHowSearchResultsPage.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^the user sees the search result count updated accordingly$")
    public void theUserSeeTheSearchResultCountUpdatedAccordingly() throws Throwable {
        assertTrue("Results count was not updated after filtering",
                searchUtils.getSearchResultsCountAsInt() <= facetsDocsCount);
    }

    @Then("^the user verifies that the facet is instantly applied and the search result count updated accordingly$")
    public void theUserVerifiesThatTheFacetIsInstantlyAppliedAndTheSearchResultCountUpdatedAccordingly() throws Throwable {
        searchResultsPage.facetCheckbox("Family").isSelected();
        theUserGetsTheCasesSearchResultCountAndStoresItAsCount(2);
        theUserVerifiesThatTheKnowHowSearchResultCountIsLessThan(2, 1);
    }

    @When("^the user gets the cases search result count and stores it as count \"(.*?)\"$")
    public void theUserGetsTheCasesSearchResultCountAndStoresItAsCount(Integer count) throws Throwable {
        String numberReturnedFromWebsite = casesSearchResultsPage.casesSearchResultCount().getText();
        numberReturnedFromWebsite = numberReturnedFromWebsite.replaceAll("[^0-9]", "");
        resultArray[count] = Integer.parseInt(numberReturnedFromWebsite);
    }

    @Then("^the user verifies that the know how search result count \"(.*?)\" is less than \"(.*?)\"$")
    public void theUserVerifiesThatTheKnowHowSearchResultCountIsLessThan(Integer count1, Integer count2) throws Throwable {
        assertTrue(resultArray[count1] <= resultArray[count2]);
    }

}

package com.thomsonreuters.login.step_definitions.search;

import com.thomsonreuters.login.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawUKCategoryPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class Ts3SearchResultsTest extends BaseStepDef {

    private PracticalLawUKCategoryPage practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private WLNHeader wlnHeader = new WLNHeader();

    private String expectedPageTitle;

    @When("^the user runs a free text cobalt search with query \"(.*?)\"$")
    public void theUserRunsAFreeTextCobaltSearch(String query) throws Throwable {
        practicalLawUKCategoryPage.freeTextField().clear();
        practicalLawUKCategoryPage.freeTextField().sendKeys(query);
        practicalLawUKCategoryPage.searchButton().click();
        knowHowSearchResultsPage.waitForSearchResults();
        knowHowSearchResultsPage.clickOnSelectMultipleFilters();
    }

    @When("^the user expands the know how facet \"(.*?)\"$")
    public void theUserExpandsTheKnowHowFacet(String arg1) throws Throwable {
        knowHowSearchResultsPage.expandFacet(arg1).click();
    }

    @When("^the user selects the know how child facet \"(.*?)\"$")
    public void theUserSelectsTheKnowHowChildFacet(String arg1) throws Throwable {
        knowHowSearchResultsPage.knowHowFacetCheckbox(arg1).click();
    }

    @When("^the user selects the know how option to apply filters$")
    public void theUserSelectsTheKnowHowOptionToApplyFilters() throws Throwable {
        knowHowSearchResultsPage.executeScript("scroll(250,0);");
        knowHowSearchResultsPage.applyFiltersButton().click();
        knowHowSearchResultsPage.waitForSearchResults();
    }

    @Then("^he should stay on same document page as OpenWeb user$")
    public void heShouldStayOnSameDocumentPageAsOpenWebUser() throws Throwable {
        navigationCobalt.waitForPageToLoad();
        String currentPageTitle = navigationCobalt.getPageTitle();
        assertTrue("User was redirected to another page after timed out session",
                expectedPageTitle.equals(currentPageTitle) && wlnHeader.isSignInLinkPresent());
    }

    @When("^the user verifies that the know how facet is selected \"(.*?)\"$")
    public void theUserVerifiesThatTheKnowHowFacetIsSelected(String arg1) throws Throwable {
        assertTrue(knowHowSearchResultsPage.knowHowFacetCheckbox(arg1).isSelected());
    }

}

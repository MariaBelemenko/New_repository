package com.thomsonreuters.legalupdate.step_definitions.common;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesPracticeAreaPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UseLessMoreMostDetailsTest extends BaseStepDef {

    private NavigationCobalt navigation = new NavigationCobalt();
    private LegalUpdatesPracticeAreaPage legalUpdatesPracticeAreaPage = new LegalUpdatesPracticeAreaPage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private LegalUpdatesResultsPage legalUpdateResultsPage = new LegalUpdatesResultsPage();

    @Given("^that a user is viewing a specific legal updates page \"(.*?)\"$")
    public void thatAUserIsViewingASpecificLegalUpdatesPage(String allLegalUpdatesPage) throws Throwable {
        navigation.navigateToPLCUKPlusSpecificURL(allLegalUpdatesPage);
        legalUpdatesPracticeAreaPage.waitForPageToLoad();
    }

    @Then("^the user should be presented with a Less/More/Most dropdown$")
    public void theUserShouldBePresentedWithALessMoreMostDropdown() throws Throwable {
        assertTrue("More Or Less detail control is not displayed", searchResultsPage.ismoreOrLessDetailAnchorDisplayed());
    }

    @Then("^the User can click on Less option to see less detail in result list$")
    public void theUserCanClickOnLessOptionToSeeLessDetailInResultList() throws Throwable {
        searchResultsPage.moreOrLessDetailAnchor().click();
        searchResultsPage.lessDetailOption().click();
        assertFalse("More detail box is diaplyed", legalUpdateResultsPage.ismoreDetailBoxDisplayed());
    }

    @Then("^the User can click on More option to see more detail in result list$")
    public void theUserCanClickOnMoreOptionToSeeMoreDetailInResultList() throws Throwable {
        searchResultsPage.moreOrLessDetailAnchor().click();
        searchResultsPage.moreDetailOption().click();
        assertTrue("More detail box is not diaplyed", legalUpdateResultsPage.ismoreDetailBoxDisplayed());
    }

    @Then("^the User can click on Most option to see most detail in result list$")
    public void theUserCanClickOnMostOptionToSeeMostDetailInResultList() throws Throwable {
    }

}

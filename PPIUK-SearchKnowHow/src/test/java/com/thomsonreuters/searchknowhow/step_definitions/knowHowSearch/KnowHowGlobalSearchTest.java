package com.thomsonreuters.searchknowhow.step_definitions.knowHowSearch;

import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.searchknowhow.step_definitions.BaseStepDef;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class KnowHowGlobalSearchTest extends BaseStepDef {

    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private HomePage homePage = new HomePage();

    @And("^opens the link associated with the first result$")
    public void opensTheLinkAssociatedWithTheFirstResult() throws Throwable {
        searchResultsPage.firstResultTitle().click();
    }

    @When("^the user selects the link to Know How Spain$")
    public void theUserSelectsTheLinkToKnowHowSpain() throws Throwable {
        homePage.selectInternationalTab();
        homePage.selectLinkPresentOnTab("Spain");
    }

    @Then("^the user is able to verify that result \"(.*?)\" is filtered to the relevant jurisdiction \"(.*?)\"$")
    public void theUserIsAbleToVerifyThatResultIsFilteredToTheRelevantJurisdiction(String arg1, String arg2) throws Throwable {
        String result = searchResultsPage.getWholeResultItemKnowHow(arg1);
        assertTrue(result.contains(arg2));
    }

    @When("^the user selects the link to the PLC magazine page$")
    public void theUserSelectsTheLinkToThePLCMagazinePage() throws Throwable {
        homePage.selectResourceTab();
        homePage.selectLinkPresentOnTab("PLC Magazine");
    }


}

package com.thomsonreuters.frontend.step_definitions.khSearch;

import com.thomsonreuters.frontend.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class SearchGuideConnectorsTest extends BaseStepDef {

    private WLNHeader header = new WLNHeader();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();

    @When("^user clicks on the \"(.*?)\"$")
    public void userClicksOnThe(String icon) throws Throwable {
        header.searchGuideIcon().click();
    }

    @Then("^user should see the search guide popup$")
    public void userShouldSeeTheSearchGuidePopup() throws Throwable {
        assertTrue("Search Guide Help not Open..!", header.searchGuideCloseButton().isDisplayed());
    }

    @Then("^user should see \"(.*?)\" character with \"(.*?)\" explanation$")
    public void userShouldSeeTheCharacterWithExplanation(String character, String charExplaination) throws Throwable {
        int charPostion = -1;
        for (int i = 0; i <= header.connectorsCharactersList().size(); i++) {
            if (header.connectorsCharactersList().get(i).getText().trim().equalsIgnoreCase(character)) {
                charPostion = i;
                break;
            }
        }
        assertTrue(character + " not Found..!", header.connectorsCharactersList().get(charPostion).getText().trim().equalsIgnoreCase(character));
        assertTrue(charExplaination + " not Found..!", header.connectorsExplanationList().get(charPostion).getText().trim().equalsIgnoreCase(charExplaination));
        header.searchGuideCloseButton().click();
    }

    @Then("^the user can select the option to show less detail$")
    public void theUserCanSelectTheOptionToShowLessDetail() throws Throwable {
        searchResultsPage.moreOrLessDetailAnchor().click();
        searchResultsPage.lessDetailOption().click();
    }

}

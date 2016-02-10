package com.thomsonreuters.searchknowhow.step_definitions.knowHowSearch;

import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.searchknowhow.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;

public class PracticeAreaSearchTest extends BaseStepDef {

    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();

    @Then("^the user can open the first know how search result \"(.*)\"$")
    public void theUserCanOpenTheFirstKnowHowSearchResult(String arg1) throws Throwable {
        knowHowSearchResultsPage.knowHowSearchResultTitle(arg1).click();
    }

}

package com.thomsonreuters.should.step_definitions.search;

import com.thomsonreuters.pageobjects.pages.search.KnowHowDocumentPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.should.step_definitions.BaseStepDef;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;


public class OpenWebAndSubscriptionTest extends BaseStepDef {

    private KnowHowSearchResultsPage knowHowSearchResultsPage;
    private KnowHowDocumentPage knowHowDocumentPage;

    public OpenWebAndSubscriptionTest() {
        knowHowSearchResultsPage = new KnowHowSearchResultsPage();
        knowHowDocumentPage = new KnowHowDocumentPage();
    }

    @Then("^the user is able to verify that a page of search results is displayed$")
    public void theUserIsAbleToVerifyThatAPageOfSearchResultsIsDisplayed() throws Throwable {
        knowHowSearchResultsPage.knowHowSearchResultTitle("1").isDisplayed();
    }

    @And("^the user can verify that the document contains the header Also Found In$")
    public void theUserCanVerifyThatTheDocumentContainsTheHeaderAlsoFoundIn() throws Throwable {
        knowHowDocumentPage.getRelatedContentTopicsHeader().isDisplayed();
    }

}
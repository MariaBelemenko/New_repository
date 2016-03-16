package com.thomsonreuters.should.step_definitions.search.knowhow;

import com.thomsonreuters.pageobjects.pages.search.KnowHowDocumentPage;
import com.thomsonreuters.should.step_definitions.BaseStepDef;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class SelectAndDeSelectFacetTest extends BaseStepDef {

    private KnowHowDocumentPage knowHowDocumentPage = new KnowHowDocumentPage();

    @When("^the user verifies that the product detail contains the practice area \"([^\"]*)\"$")
    public void theUserVerifiesThatTheProductDetailContainsThePracticeArea(String arg1) throws Throwable {
        assertTrue(knowHowDocumentPage.knowHowProductCodes(arg1).isDisplayed());
    }

}

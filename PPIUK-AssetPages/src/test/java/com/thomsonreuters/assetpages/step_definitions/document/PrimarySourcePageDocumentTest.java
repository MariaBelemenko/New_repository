package com.thomsonreuters.assetpages.step_definitions.document;

import com.thomsonreuters.assetpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.PrimarySourceDocumentPage;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;

public class PrimarySourcePageDocumentTest extends BaseStepDef {

    private PrimarySourceDocumentPage primarySourceDocumentPage = new PrimarySourceDocumentPage();

    @Then("^the primary source title is displayed$")
    public void thePrimarySourceTitleIsDisplayed() throws Throwable {
        assertTrue("The primary source title doesn't displayed",
                primarySourceDocumentPage.isElementDisplayed(primarySourceDocumentPage.documentTitle()));
    }

}

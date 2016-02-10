package com.thomsonreuters.assetpages.step_definitions.link;

import com.thomsonreuters.assetpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.PrimarySourceDocumentPage;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;

public class LinksOfrelatedDocTest extends BaseStepDef {

    private PrimarySourceDocumentPage primarySourceDocumentPage = new PrimarySourceDocumentPage();

    @Then("^this link \"(.*?)\" belong to document \"(.*?)\" type$")
    public void thisLinkBelongToDocumentType(String linkText, String documentTupeText) throws Throwable {
        assertTrue("Link doesn't belong to document type",
                primarySourceDocumentPage.isElementDisplayed(primarySourceDocumentPage.linkOfSpecificDocumentType(
                        linkText, documentTupeText))
        );
    }

}
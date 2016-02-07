package com.thomsonreuters.firmstyle.step_definitions.link;

import com.thomsonreuters.firmstyle.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;

public class ToSeeFirmStyleLinkTest extends BaseStepDef {

    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();

    @Then("^the user sees the Firm Style link$")
    public void checkFirmStyleLinkPresent() throws Throwable {
        standardDocumentPage.waitForPageToLoad();
        assertTrue("Open in Firm Style button absents", standardDocumentPage.isFirmStyleButtonPresent());
    }

}

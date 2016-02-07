package com.thomsonreuters.firmstyle.step_definitions.link;

import com.thomsonreuters.firmstyle.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertFalse;

public class NotToSeeFirmStyleLinkTest extends BaseStepDef {

    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();

    @Then("^the user does not see the Firm Style link$")
    public void checkFirmStyleLinkAbsent() throws Throwable {
        standardDocumentPage.waitForPageToLoad();
        assertFalse("Open in Firm Style button presents", standardDocumentPage.isFirmStyleButtonPresent());
    }

}

package com.thomsonreuters.researchdocdisplay.step_definitions;

import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import cucumber.api.java.en.Then;

public class CommonDocumentSteps extends BaseStepDef {

    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();

    @Then("^the user click on View Document button$")
    public void theUserClickOnViewDocumentButton() throws Throwable {
        standardDocumentPage.clickOnViewDocumentButton();
    }

}

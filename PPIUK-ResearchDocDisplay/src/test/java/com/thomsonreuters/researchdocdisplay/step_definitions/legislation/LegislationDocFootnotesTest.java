package com.thomsonreuters.researchdocdisplay.step_definitions.legislation;

import static org.junit.Assert.assertTrue;

import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.LegislationDocumentPage;
import com.thomsonreuters.researchdocdisplay.step_definitions.BaseStepDef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LegislationDocFootnotesTest extends BaseStepDef {

	protected PageActions pageActions = new PageActions();
	private LegislationDocumentPage legislationDocumentPage = new LegislationDocumentPage();

	@When("^the mouse moves on \"([^\"]*)\" footnote reference$")
	public void theMouseMovesOnFootnoteReference(String number) throws Throwable {
		pageActions.mouseOver(legislationDocumentPage.footnoteReference(number));
	}

	@Then("^the \"([^\"]*)\" is displayed in the lightbox$")
	public void theIsDisplayedInTheLightbox(String text) throws Throwable {
		assertTrue("The lightbox doesn't appears", legislationDocumentPage.footnoteText(text).isDisplayed());
	}

}

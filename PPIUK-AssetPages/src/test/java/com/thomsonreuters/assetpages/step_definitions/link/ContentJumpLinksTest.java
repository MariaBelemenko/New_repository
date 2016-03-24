package com.thomsonreuters.assetpages.step_definitions.link;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.thomsonreuters.assetpages.step_definitions.BaseStepDef;
import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.PrimarySourceDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContentJumpLinksTest extends BaseStepDef {

	private PrimarySourceDocumentPage primarySourceDocumentPage = new PrimarySourceDocumentPage();
	private AssetPageUtils assetPageUtils = new AssetPageUtils();
	private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();
	private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();

	@Then("^text added to the document$")
	public void textAddedToTheDocument() throws Throwable {
		primarySourceDocumentPage.waitForPageToLoadAndJQueryProcessing();
		assetPageUtils.addTextToTheDocumentPage();
	}

	@Then("^the user does not see \"(.*?)\" jump link$")
	public void theUserDoesNotSeeJumpLink(String jumpLinkText) throws Throwable {
		try {
			assertFalse("The user sees jump links in the left hand navigation panel",
					assetDocumentPage.jumpLink(jumpLinkText).isDisplayed());
		} catch (PageOperationException poe) {
			LOG.info("context", poe);
		}
	}

	@When("^the user does not see \"(.*?)\" section$")
	public void theUserDoesNotSeeSection(String jumpLinkText) throws Throwable {
		try {
			assertFalse("The user sees jump link section", assetDocumentPage.junpLinkSection(jumpLinkText)
					.isDisplayed());
		} catch (PageOperationException poe) {
			LOG.info("context", poe);
		}
	}

	@Then("^the user is taken to the \"([^\"]*)\" part of the document$")
	public void theUserIsTakenToThePartOfTheDocument(String section) throws Throwable {
		assertTrue("The user is not taken to the " + section + " part of document",
				assetDocumentPage.isViewScrolledToElement(standardDocumentPage.headerOnTheDocument(section)));
	}

}

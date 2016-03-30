package com.thomsonreuters.assetpages.step_definitions.link;

import static org.junit.Assert.assertFalse;

import com.thomsonreuters.assetpages.step_definitions.BaseStepDef;
import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.PrimarySourceDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContentJumpLinksTest extends BaseStepDef {

	private PrimarySourceDocumentPage primarySourceDocumentPage = new PrimarySourceDocumentPage();
	private AssetPageUtils assetPageUtils = new AssetPageUtils();
	private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();

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

}

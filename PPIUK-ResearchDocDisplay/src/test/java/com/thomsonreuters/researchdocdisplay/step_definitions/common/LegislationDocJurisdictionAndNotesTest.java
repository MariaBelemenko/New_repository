package com.thomsonreuters.researchdocdisplay.step_definitions.common;

import static org.junit.Assert.assertTrue;

import org.assertj.core.api.SoftAssertions;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.LegislationDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.ProvisionPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.ProvisionPageUtils;
import com.thomsonreuters.researchdocdisplay.step_definitions.BaseStepDef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LegislationDocJurisdictionAndNotesTest extends BaseStepDef {

	private ProvisionPage provisionPage = new ProvisionPage();
	private ProvisionPageUtils provisionPageUtils = new ProvisionPageUtils();
	protected PageActions pageActions = new PageActions();
	private CommonMethods commonMethods = new CommonMethods();
	private LegislationDocumentPage legislationDocumentPage = new LegislationDocumentPage();
	private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();


	@Then("^the notes have numbers and description$")
	public void theNotesHaveNumbersAndDescription() throws Throwable {
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(
				legislationDocumentPage.amendmentsNumbers().size() == legislationDocumentPage.amendmentsDescription()
						.size()).overridingErrorMessage("The number of descriptions and numbers is not equals")
				.isTrue();
		for (int i = 0; i < legislationDocumentPage.amendmentsNumbers().size(); i++) {
			softly.assertThat(legislationDocumentPage.amendmentsNumbers().get(i).isDisplayed())
					.overridingErrorMessage("There is no notes number").isTrue();

			softly.assertThat(legislationDocumentPage.amendmentsDescription().get(i).isDisplayed())
					.overridingErrorMessage("There is no notes description").isTrue();
		}
		softly.assertAll();
	}

	@When("^the user clicks on \"(.*?)\" in \"(.*?)\" section$")
	public void theUserClicksOnInSection(String link, String section) throws Throwable {
		assetDocumentPage.linkInLegalUpdatesSection(link, section).click();
	}

	@When("^the mouse move on footnote reference$")
	public void theMouseMoveOnFootnoteReference() throws Throwable {
		pageActions.mouseOver(provisionPage.footnoteReference());
	}

	@Then("^a lightbox will appear$")
	public void aLightboxWillAppear() throws Throwable {
		assertTrue("The lightbox didn't appear on document", provisionPage.isElementDisplayed(provisionPage.lightbox()));
	}

	@Then("^the text \"(.*?)\" will be displayed to the users$")
	public void theTextWillBeDisplayedToTheUsers(String lightboxText) throws Throwable {
		assertTrue("The text didnt' display to the user",
				provisionPage.isElementDisplayed(provisionPage.lightboxText(lightboxText)));
	}

	@Then("^the light box contains links to internal documents$")
	public void theLightBoxContainsLinksToInternalDocuments() throws Throwable {
		assertTrue("The text didnt' display to the user",
				provisionPage.isElementDisplayed(provisionPage.lightboxInternalLink()));
	}

	@When("^the user click on the link$")
	public void theUserClickOnTheLink() throws Throwable {
		String url = provisionPageUtils.clickOnInternalLinkInLightbox();
	}

	@When("^the user clicks on \"(.*?)\" link$")
	public void theUserClicksOnLink(String linkText) {
		commonMethods.clickLink(linkText);
	}

}

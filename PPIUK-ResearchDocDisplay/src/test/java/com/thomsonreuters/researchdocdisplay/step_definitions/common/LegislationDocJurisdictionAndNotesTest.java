package com.thomsonreuters.researchdocdisplay.step_definitions.common;

import org.assertj.core.api.SoftAssertions;

import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.LegislationDocumentPage;
import com.thomsonreuters.researchdocdisplay.step_definitions.BaseStepDef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LegislationDocJurisdictionAndNotesTest extends BaseStepDef {

	protected PageActions pageActions = new PageActions();
	private LegislationDocumentPage legislationDocumentPage = new LegislationDocumentPage();
	private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();
	private WLNHeader header = new WLNHeader();
	private NavigationCobalt navigationCobalt = new NavigationCobalt();

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

	@Then("^the user selects \"(.*?)\"$")
	public void theUserSelects(String link) throws Throwable {
		header.countryLink(link).click();
		navigationCobalt.waitForPageToLoad();
	}

}

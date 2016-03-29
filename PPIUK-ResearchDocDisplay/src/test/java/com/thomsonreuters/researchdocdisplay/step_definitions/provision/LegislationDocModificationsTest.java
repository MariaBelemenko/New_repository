package com.thomsonreuters.researchdocdisplay.step_definitions.provision;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.LegislationDocumentPage;
import com.thomsonreuters.researchdocdisplay.step_definitions.BaseStepDef;

import cucumber.api.java.en.Then;

public class LegislationDocModificationsTest extends BaseStepDef {

	private LegislationDocumentPage legislationDocumentPage = new LegislationDocumentPage();
	
	private static final String PRACTICALLAW_URL = "https://uk.practicallaw";
	private static final String URL_OF_INTERNAL_LINK = "thomsonreuters.com/Link/Document/";

	@Then("^the internal links are displayed in \"([^\"]*)\" section$")
	public void theInternalLinksAreDisplayedInSection(String section) throws Throwable {
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(legislationDocumentPage.linksInSection(section).isEmpty())
				.overridingErrorMessage("There is link in the " + section + " section").isFalse();
		for (WebElement element : legislationDocumentPage.linksInSection(section)) {
			softly.assertThat(element.isDisplayed()).overridingErrorMessage("The link is not displayed").isTrue();
			softly.assertThat(
					element.getAttribute("href").contains(PRACTICALLAW_URL)
							&& element.getAttribute("href").contains(URL_OF_INTERNAL_LINK))
					.overridingErrorMessage("The link is not internal").isTrue();
		}
		softly.assertAll();
	}

}

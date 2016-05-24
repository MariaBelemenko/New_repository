package com.thomsonreuters.research.step_definitions.journals;

import static org.junit.Assert.assertTrue;

import org.assertj.core.api.SoftAssertions;

import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.JournalDocumentPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JournalAbstractDocDisplayTest {

	private JournalDocumentPage journalDocumentPage = new JournalDocumentPage();

	@Then("^the autor is displayed in the document$")
	public void theAutorIsDisplayedInTheDocument() throws Throwable {
		assertTrue("The autor is not displayed in the document", journalDocumentPage.author().isDisplayed());
	}

	@Then("^the Provided by Westlaw UK icon is displayed$")
	public void theProvidedByWestlawUKIconIsDisplayed() throws Throwable {
		assertTrue("The WLUK icon is not displayed", journalDocumentPage.providedByWlukIcon().isDisplayed());
	}

	@Then("^the \"([^\"]*)\" subsection is displayed with value$")
	public void theSubsectionIsDisplayedWithValue(String subsection) throws Throwable {
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(journalDocumentPage.documentSubsection(subsection).isDisplayed())
				.overridingErrorMessage("The %s subsection is not displayed", subsection).isTrue();

		softly.assertThat(journalDocumentPage.valueOfSubsection(subsection).getText().isEmpty())
				.overridingErrorMessage("The %s subsection has no value", subsection).isFalse();
		softly.assertAll();
	}

	@When("^the user clicks on link \"([^\"]*)\" in subsection \"([^\"]*)\"$")
	public void theUserClicksOnLinkInSubsection(String linkText, String subsection) throws Throwable {
		journalDocumentPage.linkInSubsection(linkText, subsection).click();
	}

	@Then("^document title is displayed as \"(.*?)\"$")
	public void titleIsDisplayedAs(String title) throws Throwable {
		assertTrue("Document title is not '" + title + "' but '" + journalDocumentPage.getPageTitle() + "'",
				journalDocumentPage.getPageTitle().contains(title));
	}
}

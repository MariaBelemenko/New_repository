package com.thomsonreuters.research.step_definitions.journals;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.assertj.core.api.SoftAssertions;

import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.JournalDocumentPage;
import com.thomsonreuters.pageobjects.utils.globalPage.GlobalPageUtils;
import com.thomsonreuters.pageobjects.utils.plResearch.DocumentPageUtils;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JournalDocMetadataTest {

	private static final String XML_TAG = "md.infotype";
	private JournalDocumentPage journalDocumentPage = new JournalDocumentPage();
	private DocumentPageUtils documentPageUtils = new DocumentPageUtils();
	private GlobalPageUtils globalPageUtils = new GlobalPageUtils();

	@Then("^the metadata contains document type \"([^\"]*)\"$")
	public void theMetadataContainsDocumentType(String type) throws Throwable {
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(journalDocumentPage.journalDocumentType().isDisplayed())
				.overridingErrorMessage("The document type is not displayed").isTrue();
		softly.assertThat(journalDocumentPage.journalDocumentType().getText().equals(type))
				.overridingErrorMessage("The metadata doesn't contain %s of the document", type).isTrue();
		softly.assertAll();
	}

	@Then("^the metadata contains field \"([^\"]*)\" with value$")
	public void theMetadataContainsFieldWithValue(String field) throws Throwable {
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(journalDocumentPage.fieldInMetadata(field).isDisplayed())
				.overridingErrorMessage("The %s field is not displayed", field).isTrue();
		softly.assertThat(journalDocumentPage.valueOfFieldInMetadata(field).getText().isEmpty())
				.overridingErrorMessage("The %s field has no value", field).isFalse();
		softly.assertThat(journalDocumentPage.valueOfFieldInMetadata(field).isDisplayed())
				.overridingErrorMessage("The value of %s is not displayed", field).isTrue();
		softly.assertAll();
	}

	@When("^the user clicks on publication link in metadata$")
	public void theUserClicksOnPublicationLinkInMetadata() throws Throwable {
		journalDocumentPage.publicationLinkInMetadata().click();
	}

	@Then("^the user is taken to the document with type \"([^\"]*)\"$")
	public void theUserIsTakenToTheDocumentWithType(String type) throws Throwable {
		journalDocumentPage.waitForPageToLoad();
		assertTrue("The user is not taken to the document with type " + type, globalPageUtils
				.getValuesOfTagFromXMLOfTheDocument(XML_TAG, documentPageUtils.getDocumentGUID()).get(0).toString()
				.equals(type));
	}

	@When("^the user clicks on citation link in metadata$")
	public void theUserClicksOnCitationLinkInMetadata() throws Throwable {
		journalDocumentPage.citationLinkInMetadata().click();
	}

	@Then("^the metadata in not displayed in the document$")
	public void theMetadataInNotDisplayedInTheDocument() throws Throwable {
		assertFalse("The metadata is not displayed in the right hand side of the central column",
				documentPageUtils.isMetadataPresent());
	}

	@Then("^the metadata contains citation$")
	public void theMetadataContainsCitation() throws Throwable {
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(journalDocumentPage.citationTextInMetadata().isDisplayed())
				.overridingErrorMessage("The citation is not displayed").isTrue();

		softly.assertThat(journalDocumentPage.citationTextInMetadata().getText().isEmpty())
				.overridingErrorMessage("The citation has no value").isFalse();
		softly.assertAll();
	}

}

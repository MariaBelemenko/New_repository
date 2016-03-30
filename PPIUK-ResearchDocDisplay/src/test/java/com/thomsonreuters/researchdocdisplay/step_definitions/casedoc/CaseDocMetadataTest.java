package com.thomsonreuters.researchdocdisplay.step_definitions.casedoc;

import static org.junit.Assert.assertTrue;

import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.CaseDocumentPage;
import com.thomsonreuters.researchdocdisplay.step_definitions.BaseStepDef;

import cucumber.api.java.en.Then;

public class CaseDocMetadataTest extends BaseStepDef {

	private CaseDocumentPage caseDocumentPage = new CaseDocumentPage();
	private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();

	@Then("^the left hand navigation menu is displayed$")
	public void theLeftHandNavigationMenuIsDisplayed() throws Throwable {
		assertTrue("The left hand navigation menu is not displayed", caseDocumentPage.columnForTheLeftHandNavigation()
				.isDisplayed());
	}

	@Then("^the content column is displayed$")
	public void theContentColumnIsDisplayed() throws Throwable {
		assertTrue("The content column is not displayed", caseDocumentPage.contentColumn().isDisplayed());
	}

	@Then("^the status icon is displayed$")
	public void theStatusIconIsDisplayed() throws Throwable {
		assertTrue("The status icon is not displayed", caseDocumentPage.statusIcon().isDisplayed());
	}

	@Then("^the status description is displayed$")
	public void theStatusDescriptionIsDisplayed() throws Throwable {
		assertTrue("The status description is not displayed", caseDocumentPage.statusDescription().isDisplayed());
	}

	@Then("^delivery options are displayed$")
	public void deliveryOptionsAreDisplayed() throws Throwable {
		assertTrue("The delivery options are not displayed", caseDocumentPage.deliveryOptions().isDisplayed());
	}

	@Then("^the metadata is displayed in the right hand side of the central column$")
	public void theMetadataIsDisplayedInTheRightHandSideOfTheCentralColumn() throws Throwable {
		assertTrue("The metadata is not displayed in the right hand side of the central column", assetDocumentPage
				.caseMetadata().isDisplayed());
	}

	@Then("^the metadata contains \"(.*?)\"$")
	public void theMetadataContains(String field) throws Throwable {
		assertTrue("The metadata doesn't contain " + field + "field", assetDocumentPage.metaDataField(field)
				.isDisplayed());
	}

}

package com.thomsonreuters.research.step_definitions.common;

import static org.junit.Assert.assertTrue;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.pages.urls.plcuk.KHDocumentPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CommonDocumentStepTest {

	private NavigationCobalt navigationCobalt = new NavigationCobalt();
	private KHDocumentPage documentPagePLCUK = new KHDocumentPage();
	private CommonMethods commonMethods = new CommonMethods();
	private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();

	@When("^the user opens document with guid \"([^\"]*)\"$")
	public void theUserOpensDocumentWithGuid(String guid) throws Throwable {
		navigationCobalt.navigateToPLCUKPlusSpecificURL("/Document/" + guid + "/View/FullText.html");
		navigationCobalt.waitForPageToLoad();
	}

	@Then("^the document block is displayed$")
	public void theDocumentBlockIsDisplayed() throws Throwable {
		assertTrue("Document not present", documentPagePLCUK.isDocumentBlockPresent());
	}

	@When("^the user clicks on link \"([^\"]*)\"$")
	public void theUserClicksOnLink(String link) throws Throwable {
		commonMethods.clickLink(link);
	}

	@Then("^the title is displayed in the document$")
	public void theTitleIsDisplayedInTheDocument() throws Throwable {
		assertTrue("The title is not displayed", assetDocumentPage.documentTitle().isDisplayed());
	}
}

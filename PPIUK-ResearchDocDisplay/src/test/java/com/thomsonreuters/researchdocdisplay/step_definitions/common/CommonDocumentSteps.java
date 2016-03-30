package com.thomsonreuters.researchdocdisplay.step_definitions.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import com.thomsonreuters.pageobjects.pages.urls.plcuk.KHDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.CaseDocumentPageUtils;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.LegislationDocumentPageUtils;
import com.thomsonreuters.researchdocdisplay.step_definitions.BaseStepDef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CommonDocumentSteps extends BaseStepDef {

	private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();
    private CommonMethods commonMethods = new CommonMethods();
    private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();
    private KHDocumentPage documentPagePLCUK = new KHDocumentPage();
	private CaseDocumentPageUtils caseDocumentPageUtils = new CaseDocumentPageUtils();
	private LegislationDocumentPageUtils provisionPageUtils = new LegislationDocumentPageUtils();
	private WLNHeader header = new WLNHeader();

    @Then("^the user click on View Document button$")
    public void theUserClickOnViewDocumentButton() throws Throwable {
        standardDocumentPage.clickOnViewDocumentButton();
    }

    @When("^the user opens document with (.+) guid$")
    public void theUserOpensDocumentWithGuid(String guid) throws Throwable {
        navigationCobalt.navigateToPLCUKPlusSpecificURL("/Document/" + guid + "/View/FullText.html");
        navigationCobalt.waitForPageToLoad();
    }
    
    @When("^the user clicks on \"(.*?)\" link$")
	public void theUserClicksOnLink(String linkText) {
		commonMethods.clickLink(linkText);
	}
    
    @Then("^the user is taken to the \"([^\"]*)\" part of the document$")
	public void theUserIsTakenToThePartOfTheDocument(String section) throws Throwable {
		assertTrue("The user is not taken to the " + section + " part of document",
				assetDocumentPage.isViewScrolledToElement(standardDocumentPage.headerOnTheDocument(section)));
	}
    
    @Then("^the document opens correctly$")
    public void theDocumentOpensCorrectly() throws Throwable {
        assertTrue("Document not present", documentPagePLCUK.isDocumentBlockPresent());
    }
    

	@Then("^the \"([^\"]*)\" link is not displayed$")
	public void theLinkIsNotDisplayed(String link) throws Throwable {
		assertFalse("The " + link + " is displayed on the document", caseDocumentPageUtils.isTheLinkPresent(link));
	}
	
	@Then("^the \"(.*?)\" section is not displayed$")
	public void theSectionIsNotDisplayed(String section) throws Throwable {
		assertFalse("The annotated status section is displayed on the document",
				provisionPageUtils.isTheSectionPresent(section));
	}
	
	@Then("^the table of contents is displayed$")
	public void theTableOfContentsIsDisplayed() throws Throwable {
		assertTrue("Teble of content is not displayed", assetDocumentPage.tableOfContentSection().isDisplayed());
	}
    
	@Then("^the user selects \"(.*?)\"$")
	public void theUserSelects(String link) throws Throwable {
		header.countryLink(link).click();
		navigationCobalt.waitForPageToLoad();
	}
	
    @Then("^the title is displayed on the document$")
    public void theTitleIsDisplayedOnTheDocument() throws Throwable {
    	 assertTrue("The title is not displayed", assetDocumentPage.partyNames().isDisplayed());
    }
	
}

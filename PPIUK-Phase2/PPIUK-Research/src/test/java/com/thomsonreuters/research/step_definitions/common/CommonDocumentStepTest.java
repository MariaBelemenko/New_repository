package com.thomsonreuters.research.step_definitions.common;

import static org.junit.Assert.assertTrue;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.generic.PPIGenericDocDisplay;
import com.thomsonreuters.pageobjects.pages.globalPage.GlobalCategoryPage;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawUKCategoryPage;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.pageobjects.pages.urls.plcuk.KHDocumentPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.util.*;
import java.util.List;

public class CommonDocumentStepTest {


	private PracticalLawUKCategoryPage practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();
	private PageActions pageActions = new PageActions();
	private SearchResultsPage searchResultsPage = new SearchResultsPage();
	private NavigationCobalt navigationCobalt = new NavigationCobalt();
	private KHDocumentPage documentPagePLCUK = new KHDocumentPage();
	private CommonMethods commonMethods = new CommonMethods();
	private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();
    private HomePage homePage = new HomePage();
    private WLNHeader wlnHeader = new WLNHeader();
    private GlobalCategoryPage globalCategoryPage = new GlobalCategoryPage();
    private PPIGenericDocDisplay ppiGenericDocDisplay = new PPIGenericDocDisplay();

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

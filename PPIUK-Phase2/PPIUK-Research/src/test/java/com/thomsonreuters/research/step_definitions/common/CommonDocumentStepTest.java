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


	@When("^the user verifies that the results list page is displayed$")
	public void theUserVerifiesThatTheResultsListPageIsDisplayed() throws Throwable {
		Robot robot = new Robot();
		robot.delay(5000);
		try {
			searchResultsPage.resultsListHeader().isDisplayed();
			searchResultsPage.filterHeader().isDisplayed();
		} catch (Exception e) {
		}
	}


	@When("^the user runs a free text search for the query \"(.*)\"$")
	public void theUserRunsAFreeTextSearchForTheQuery(String value) throws Throwable {
		/** Ensure the search button has rendered */
		practicalLawUKCategoryPage.searchButton().isDisplayed();
		practicalLawUKCategoryPage.freeTextField().clear();
		/** Use Javascript executor instead of sendkeys for characters that won't type due to a Selenium bug */
		if (value.contains("(") || value.contains(")") || value.contains("&")) {
			practicalLawUKCategoryPage.freeTextFieldJavaScript(value);
			practicalLawUKCategoryPage.freeTextField().sendKeys(" ");
		} else {
			practicalLawUKCategoryPage.freeTextField().sendKeys(value);
		}

		if (practicalLawUKCategoryPage.getClass().equals(ChromeDriver.class)) {
			pageActions.keyPress(Keys.ENTER);
		} else {
			practicalLawUKCategoryPage.searchButton().click();
		}

		/** Wait for the results list to display */
		theUserVerifiesThatTheResultsListPageIsDisplayed();
	}

    @When("^the user selects the link entitled Whats Market UK Home$")
    public void theUserSelectsTheLinkEntitledWhatsMarketUkHome() throws Throwable {
        homePage.selectResourceTab();
        homePage.selectLinkPresentOnTab("What's Market");
    }

    @And("^the user is in page '(.*)' with page Title '(.*)'$")
    public void theUserIsInPageResourcecsBooksOnlineWithPageTitle(String pages, String expectedTitle) throws Throwable {
        java.util.List<String> links = Arrays.asList(pages.split(">"));
        for (String link : links) {
            if (link.contains("/")) {
                navigationCobalt.navigateToRelativeURL(link);
            } else {
                if (link.equalsIgnoreCase("Browse Menu")) {
                    wlnHeader.browseMenuButton().click();
                } else {
                    navigationCobalt.waitForElementPresent(By.linkText(link)).click();
                }
                navigationCobalt.waitForPageToLoad();
            }
        }
        assertTrue(wlnHeader.pageHeaderLabel().getText().equals(expectedTitle));
    }

    @When("^the user selects \"(.*?)\" tab and clicks on \"(.*?)\" link in \"(.*?)\" section$")
    public void theUserSelectsTabAndClicksOnLinkInSection(String tab, String linkText, String sectionName)
            throws Throwable {
        globalCategoryPage.waitForPageToLoad();
        homePage.specificTab(tab).click();
        globalCategoryPage.linkInSection(linkText, sectionName).click();
    }

    @Then("^the Category Page opens correctly$")
    public void theCategoryPageOpensCorrectly() throws Throwable {
        globalCategoryPage.waitForPageToLoad();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(!globalCategoryPage.header().isEmpty()).overridingErrorMessage("Header is empty").isTrue();
        softly.assertThat(!globalCategoryPage.globalPageHeader().isEmpty())
                .overridingErrorMessage("Page header is empty").isTrue();
        softly.assertThat(!globalCategoryPage.globalPageBody().isEmpty()).overridingErrorMessage("Page body is empty")
                .isTrue();
        softly.assertThat(!globalCategoryPage.globalPageFooter().isEmpty()).overridingErrorMessage("Footer is empty")
                .isTrue();
        softly.assertAll();
    }

    @Then("^the user clicks through the \"(.*?)\" links that are displayed on the Home Page$")
    public void theUserClicksThroughTheTabLinksThatAreDisplayedOnTheHomePage(String subMenuLink, List<String> links) throws Throwable {
        String pageTitle = "";
        String linkToClick = "";
        String headerToFind = "";
        String stringToSplit[] ;

        homePage.homepageTabHeadingLink(subMenuLink).click();

        List<String> linksRetrieved = homePage.getLinksInHomepageMainMenu();
        //System.out.println("...Found " + Integer.toString(homePage.getLinksInHomepageMainMenu().size()) + " links");
        for (String link : links) {
            //System.out.println("The current link being checked is: " + link);

            if (!link.contains(" ~ ")) {
                homePage.homepageTabLink(link).click();
            } else {
                stringToSplit=link.split(" ~ ");
                headerToFind=stringToSplit[0];
                linkToClick=stringToSplit[1] ;
                link=linkToClick;
                homePage.tabLinkAfterHeader(headerToFind,linkToClick).click();
            }
            assertTrue("The '" + subMenuLink + "' link " + link + " is NOT displayed in Browse Menu", linksRetrieved.contains(link));
            pageTitle = ppiGenericDocDisplay.searchPageLabel().getText();
            Boolean testPass = false;
            if (link.toLowerCase().contains(pageTitle.toLowerCase())) {
                testPass = true;
            }
            if (pageTitle.toLowerCase().contains(link.toLowerCase())) {
                testPass = true;
            }
            //System.out.println("The link text is "+link+" and the page title is "+pageTitle);
            assertTrue(testPass);
            commonMethods.browserGoBack();
            homePage.homepageTabHeadingLink(subMenuLink).isDisplayed();
            homePage.homepageTabHeadingLink(subMenuLink).click();
        }
    }



}

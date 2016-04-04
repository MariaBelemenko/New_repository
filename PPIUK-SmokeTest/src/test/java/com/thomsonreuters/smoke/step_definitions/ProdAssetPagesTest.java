package com.thomsonreuters.smoke.step_definitions;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawUKCategoryPage;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.DocumentRightPanelPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.PrimarySourceDocumentPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.pageobjects.pages.widgets.CategoryPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class ProdAssetPagesTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private WLNHeader header = new WLNHeader();
    private CategoryPage categoryPage = new CategoryPage();
    private PracticalLawUKCategoryPage practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();
    private PageActions pageActions = new PageActions();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private HomePage homePage = new HomePage();
    private CommonMethods commonMethods = new CommonMethods();
    private KHResourcePage resourcePage = new KHResourcePage();
    private DocumentRightPanelPage rightPanelPage = new DocumentRightPanelPage();
    private AssetPageUtils assetPageUtils = new AssetPageUtils();
    private PrimarySourceDocumentPage primarySourceDocumentPage = new PrimarySourceDocumentPage();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();

    @When("^the user come back on to Home page$")
    public void userComeBackOnToHomePage() throws Throwable {
        navigationCobalt.waitForPageToLoad();
        if (!isHomePage()) {
            navigationCobalt.navigateToHomePage();
            navigationCobalt.waitForPageToLoad();
        }
    }

	@When("^the user come back on to Home page as logged in user$")
	public void userComeBackOnToHomePageAsLoggedInUser() throws Throwable {
		navigationCobalt.waitForPageToLoad();
		if (!isHomePage()) {
			navigationCobalt.navigateToHomePage();
			navigationCobalt.waitForPageToLoad();
		}
        assertThat(header.favouritesLink().isDisplayed(), Is.is(true));
        assertThat(header.foldersLink().isDisplayed(), Is.is(true));
        assertThat(header.historyLink().isDisplayed(), Is.is(true));
        assertThat(resourcePage.waitAndFindElement(By.linkText("Employment")).isDisplayed(), Is.is(true));
	}

    @When("^the user runs a free text search for the query \"(.*)\"$")
    public void theUserRunsAFreeTextSearchForTheQuery(String query) throws Throwable {
        /** Paste string into the system clipboard instead */
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        /** Ensure the search button has rendered */
        practicalLawUKCategoryPage.searchButton().isDisplayed();
        practicalLawUKCategoryPage.freeTextField().clear();
        /** Paste the clipboard text if the query contains brackets or ampersand */
        if (query.contains("(") || query.contains(")") || query.contains("&")) {
            StringSelection stringSelection = new StringSelection(query);
            clpbrd.setContents(stringSelection, null);
            practicalLawUKCategoryPage.freeTextField().sendKeys(Keys.CONTROL + "v");
        } else {
            practicalLawUKCategoryPage.freeTextField().sendKeys(query);
        }
        if (practicalLawUKCategoryPage.getClass().equals(ChromeDriver.class)) {
            pageActions.keyPress(Keys.ENTER);
        } else {
            practicalLawUKCategoryPage.searchButton().click();
        }
        /** Wait for the results list to display */
        theUserVerifiesThatTheResultsListPageIsDisplayed();
    }

    @When("^the user verifies that the results list page is displayed$")
    public void theUserVerifiesThatTheResultsListPageIsDisplayed() throws Throwable {
        Robot robot = new Robot();
        robot.delay(5000);
        try {
            searchResultsPage.resultsListHeader().isDisplayed();
            searchResultsPage.filterHeader().isDisplayed();
        } catch (Exception ignored) {
        }
    }

    @When("^the user clicks link '(.*)' on '(.*)' page$")
    public void theUserClicksLinkOnPage(String link, String page) throws Throwable {
        if (!link.equals("")) {
            if (page.contains("Browse")) {
                homePage.findChildElement(homePage.getPracticeAreasBrowseMenuContainer(), By.linkText((link))).click();
            } else {
                try {
                    homePage.waitForExpectedElement(By.linkText(link), 2).click();
                } catch (Exception e) {
                    homePage.waitForExpectedElement(By.partialLinkText(link), 5).click();
                }
            }
            homePage.waitForPageToLoad();
        }
    }

    @When("^the user clicks on \"(.*?)\" link$")
    public void theUserClicksOnLink(String linkText) throws Throwable {
        commonMethods.clickLink(linkText);
    }

    @Then("^document title is displayed as \"(.*?)\"$")
    public void titleIsDisplayedAs(String title) throws Throwable {
        assertThat(resourcePage.title().getText().trim().replaceAll("\\n", " "), Is.is(title.replaceAll("\\\\n", " ")));
    }

    @Then("^resource type is displayed as \"(.*?)\" on right hand panel$")
    public void documentTypeIsDisplayedAsArticles(String documentType) throws Throwable {
        rightPanelPage.waitForPageToLoadAndJQueryProcessing();
        assertThat(rightPanelPage.resourceTypeText().getText().trim(), Is.is(documentType));
    }

    @Then("^the user see links to \"(.*?)\" Bailii$")
    public void theUserSeeLinksToBailii(String bailiiLink) throws Throwable {
        assertTrue("The user doesn't see links to Bailii", assetPageUtils.isTheUserSeeLinksToBailii(bailiiLink));
    }

    @When("^the user click on \"(.*?)\" Bailii link$")
    public void theUserClickOnBailiiLink(String bailiiLink) throws Throwable {
        assetPageUtils.clickOnBailiiLink(bailiiLink);
    }

    @Then("^the user is taken to \"(.*?)\" resource$")
    public void theUserIsTakenToResource(String linkText) throws Throwable {
        primarySourceDocumentPage.waitForPageToLoad();
        assetPageUtils.getBaseParameters();
        assertTrue("The user doesn't taken to the selected resource",
                assetPageUtils.isTheUserTakenToTheSelectedResource(linkText));
    }

    @Then("^the user can open the first know how search result \"(.*)\"$")
    public void theUserCanOpenTheFirstKnowHowSearchResult(String arg1) throws Throwable {
        knowHowSearchResultsPage.knowHowSearchResultTitle(arg1).click();
    }

    @Then("^the user see link to \"(.*?)\" Westlaw UK$")
    public void theUserSeeLinkToWestlawUK(String westlawUkLinkText) throws Throwable {
        assertTrue("The user doesn't see link to westlawUk",
                assetPageUtils.isTheUserSeeLinkToWestlawUK(westlawUkLinkText));
    }

    @When("^the user click on link to \"(.*?)\" Westlaw UK$")
    public void theUserClickOnLinkToWestlawUK(String westlawUkLinkText) throws Throwable {
        assetDocumentPage.waitForPageToLoad();
        assetPageUtils.clickOnLinkToWestlawUK(westlawUkLinkText);
    }

    @Then("^the user is taken to the login page in Westlaw UK$")
    public void theUserIsTakenToTheLoginPageInWestlawUK() throws Throwable {
        assetDocumentPage.waitForPageToLoad();
        assertTrue("The user doesn't taken to the login page in WestlawUk",
                assetPageUtils.isTheUserTakenToTheLoginPageInWestlawUkDocument());
    }

    @Then("^the user close the current window$")
    public void theUserCloseTheCurrentWindow() throws Throwable {
        assetDocumentPage.switchToWindow(assetDocumentPage.getWindowHandle());
        assetDocumentPage.close();
    }

    @Then("^the user go back to previous window$")
    public void theUserGoBackToPreviousWindow() throws Throwable {
        assetPageUtils.goBackToThePreviousWindow();
    }

    @Then("^the user see links to \"(.*?)\" Legislation$")
    public void theUserSeeLinksToLegislation(String legislationLinkText) throws Throwable {
        primarySourceDocumentPage.refreshPage();
        primarySourceDocumentPage.waitForPageToLoad();
        assertTrue("The primary source title doesn't displayed",
                primarySourceDocumentPage.isElementDisplayed(primarySourceDocumentPage
                        .legislationLink(legislationLinkText)));
    }

    @When("^the user click on \"(.*?)\" Legislation link$")
    public void theUserClickOnLegislationLink(String legislationLinkText) throws Throwable {
        assetPageUtils.getBaseParameters();
        primarySourceDocumentPage.legislationLink(legislationLinkText).click();
    }

    private boolean isHomePage() {
        return categoryPage.getCurrentUrl().contains("/Search/Home.html")
                || categoryPage.getCurrentUrl().contains("/Search/BrowseRoot.html")
                || categoryPage.getCurrentUrl().contains("Home/Home");
    }

}

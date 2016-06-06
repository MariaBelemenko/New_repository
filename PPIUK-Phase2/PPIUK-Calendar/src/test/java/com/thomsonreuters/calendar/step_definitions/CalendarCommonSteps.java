package com.thomsonreuters.calendar.step_definitions;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.ask.AskResourcePage;
import com.thomsonreuters.pageobjects.pages.folders.CreateGroupPopup;
import com.thomsonreuters.pageobjects.pages.folders.FavouritesPage;
import com.thomsonreuters.pageobjects.pages.footer.WLNFooter;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawUKCategoryPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesResultsPage;
import com.thomsonreuters.pageobjects.pages.onePass.OnePassLogoutPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.CommonResourcePage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.TopicPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.WhatsMarketSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.widgets.CategoryPage;
import com.thomsonreuters.pageobjects.rest.FolderBaseUtils;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CalendarCommonSteps extends BaseStepDef {

    private WLNFooter footer = new WLNFooter();
    private WLNHeader header = new WLNHeader();
    private CommonMethods commonMethods = new CommonMethods();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private CommonResourcePage commonResourcePage = new CommonResourcePage();
    private LegalUpdatesResultsPage legalUpdatesResultsPage = new LegalUpdatesResultsPage();
    private CategoryPage categoryPage = new CategoryPage();
    private KHResourcePage resourcePage = new KHResourcePage();
    private TopicPage topicPage = new TopicPage();
    private PageActions pageActions = new PageActions();
    private OnePassLogoutPage onePassLogoutPage = new OnePassLogoutPage();
    private PracticalLawUKCategoryPage practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();
    private NavigationCobalt navigationCobalt= new NavigationCobalt();

    @When("^the user clicks on \"(.*?)\" link$")
    public void theUserClicksOnLink(String linkText) {
        commonMethods.clickLink(linkText);
    }


    @Then("^user sign out$")
    public void userSignOut() throws Throwable {
        pageActions.mouseOver(header.usernameIcon());
        header.signOutSubLink().click();
        header.waitForPageToLoadAndJQueryProcessing();
        onePassLogoutPage.signOffPageSignOnButton().click();
    }

    @When("^user clicks the \"(.*?)\" link$")
    public void userClicksTheUnitedKingdomLink(String linkText) throws Throwable {
        commonMethods.waitElementByLinkText(linkText);
        commonMethods.clickLink(linkText);
        header.waitForPageToLoad();
    }

    @Then("^the user selects the \"(.*?)\" from per page dropdown$")
    public void theUserSelectsThePerPagefromPerPageDropdown(String perPageNo) throws Throwable {
        if (!legalUpdatesResultsPage.resultsPerPageLink().getText().contains(perPageNo)) {
            knowHowSearchResultsPage.searchPerPageDrodownLink().click();
            for (WebElement link : knowHowSearchResultsPage.searchPerPageDrodownListItemLinks()) {
                if (link.getText().trim().contains(perPageNo)) {
                    link.click();
                    break;
                }
            }
            assertTrue("Count is not right..!", commonMethods.isTextPresent(knowHowSearchResultsPage.searchResultByCountLabel(), perPageNo));
        }
    }

    @Then("^user verifies the \"(.*?)\" present$")
    public void userVerifiesThePresent(String linkText) throws Throwable {
        boolean present = false;
        for (WebElement link : knowHowSearchResultsPage.searchPaginationItemLinks()) {
            if (link.getText().trim().equalsIgnoreCase(linkText)) {
                present = true;
                break;
            }
        }
        assertTrue(linkText + " not present..!", present);
    }

    @Then("^clicks on the \"(.*?)\" pagination link$")
    public void clicksOnThePaginationLink(String pageNoOrText) throws Throwable {
        for (WebElement link : knowHowSearchResultsPage.searchPaginationItemLinks()) {
            if (link.getText().trim().equalsIgnoreCase(pageNoOrText)) {
                link.click();
                break;
            }
        }
    }

    @Then("^user should see the label \"(.*?)\" in the search result heading$")
    public void userShouldSeetheLabelInTheSearchResultHeading(String label) throws Throwable {
        assertTrue(label + " not displayed..!", knowHowSearchResultsPage.searchResultHeadingWithString(label).isDisplayed());
    }

    @Then("^the user should be seeing \"(.*?)\" per page$")
    public void userShouldbeSeeingPerPage(String perPageNo) throws Throwable {
        int expectedNoOfResults = Integer.parseInt(perPageNo);
        commonMethods.waitForElement(knowHowSearchResultsPage.searchResultsItemsList().get(0), 5000);
        commonMethods.scrollUpOrDown(70000);
        int actualNoOfResults = knowHowSearchResultsPage.searchResultsItemsList().size();
        if (actualNoOfResults > expectedNoOfResults) {
            assertTrue("Number of results not matching: expected " + expectedNoOfResults + " , actual " + actualNoOfResults,
                    expectedNoOfResults == actualNoOfResults);
        }
    }

    @Then("^user should see the \"(.*?)\" page$")
    public void userShouldseethePage(String pageDesc) throws Throwable {
        assertTrue("No Of Results Not matching..!", standardDocumentPage.documentTitle().getText().trim().contains(pageDesc));
    }

    @Then("^user should not see any filters on the left hand side$")
    public void userShouldNotSeeAnyFiltersOnLeft() throws Throwable {
        try {
            if (knowHowSearchResultsPage.searchFilterFacet().isDisplayed()) {
                assertTrue(false);
            }
        } catch (Exception e) {
            assertTrue(true);
        }
    }


    @Then("^user should not see any \"(.*)\" link$")
    public void userShouldNotSeeAnyLink(String linkText) throws Throwable {
        assertFalse(linkText + " is still visible..!", commonMethods.isLinkTextPresent(linkText, 2000));
    }

    @When("^the user scrolls down the page \"(.*?)\"$")
    public void theUserScrollsDownThePage(String amountText) throws Throwable {
        if (amountText.equalsIgnoreCase("a bit")) {
            commonMethods.scrollUpOrDown(1000);
        } else if (amountText.equalsIgnoreCase("more")) {
            commonMethods.scrollUpOrDown(3000);
        } else if (amountText.equalsIgnoreCase("way down")) {
            commonMethods.scrollUpOrDown(5000);
        }
    }

    @When("^the user navigates to \"(.*)\" resource Page$")
    public void the_user_navigates_to_whats_Market_Page(String resourceType) throws Throwable {
        header.browseMenuButton().click();
        assertTrue("Browse Menu not displayed..!", header.browseMenuPopup().isDisplayed());
        commonMethods.clickLink("Resources");
        commonMethods.waitElementByLinkText(resourceType).click();
    }

    @When("^the user navigating to topic page \"(.*)\" of practice area \"(.*)\"$")
    public void the_user_navigates_to_topicpage_of_Practice_area(String topicName, String PAName) throws Throwable {
        header.browseMenuButton().click();
        assertTrue("Browse Menu not displayed..!", header.browseMenuPopup().isDisplayed());
        commonMethods.clickLink(PAName);
        assertTrue(PAName + " not displayed..!", header.pageHeaderLabel().getText().contains(PAName));
        for (WebElement tab : footer.pageTabLinks()) {
            if (tab.getText().trim().contains("Topics")) {
                tab.click();
                commonMethods.waitForElement(tab, 2000);
                break;
            }
        }
        commonMethods.clickLink(topicName);
        assertTrue(topicName + " not displayed..!", header.pageHeaderLabel().getText().contains(topicName));
    }

    @Then("^the user should see the page no \"(.*?)\"$")
    public void userShouldseethePageNo(String pageNo) throws Throwable {
        assertTrue("Page No " + pageNo + " not displayed..!", topicPage.currentPageSelected().trim().contains(pageNo));
    }

    /**
     * The user varifies each page by navigates through each of the following pages
     */
    @Then("^the user varifies each page by navigates through each of the following pages$")
    public void theUserVarifiesEachPageByNavigatesThroughEachOfFollowingPage(List<String> pageNos) throws Throwable {
        for (String pageNo : pageNos) {
            if (!pageNo.equalsIgnoreCase("Pages")) {
                commonMethods.clickLink(pageNo);
                assertTrue("Page No " + pageNo + " not displayed..!", topicPage.currentPageSelected().trim().contains(pageNo));
            }
        }
    }

    @Then("^the footer is displayed below the end of the document$")
    public void theFooterIsDisplayedBelowTheEndOfTheDocument() {
        boolean footerBelowDoc = resourcePage.compareElementsLocationByHeight(standardDocumentPage.endOfDocument(), footer.footerWidget()) < 0;
        assertTrue("Footer is overlapping the document body", footerBelowDoc);
    }

    @When("^the user searches for term \"(.*)\"$")
    public void theUserRunsAFreeTextSearchForTheQuery(String query) throws Throwable {
        practicalLawUKCategoryPage.searchButton().isDisplayed();
        practicalLawUKCategoryPage.freeTextField().clear();
        practicalLawUKCategoryPage.freeTextField().sendKeys(query);
        if (commonMethods.waitForElementToBeVisible(practicalLawUKCategoryPage.suggestedByTerm(query.toUpperCase()), 1000) != null) {
            practicalLawUKCategoryPage.suggestedTerm(query.toUpperCase()).click();
        } else {
            practicalLawUKCategoryPage.freeTextField().sendKeys(Keys.ENTER);
        }
    }

    @When("^the user navigates to practice area \"(.*)\"$")
    public void the_user_navigates_to_Practice_area(String PAName) throws Throwable {
        header.browseMenuButton().click();
        assertTrue("Browse Menu not displayed..!", header.browseMenuPopup().isDisplayed());
        commonMethods.clickLink(PAName);
        assertTrue(PAName + " not displayed..!", header.pageHeaderLabel().getText().contains(PAName));
     }

    @When("^the user navigates to \"(.+)\" url$")
    public void theUserOpensUrlOnPLCUKSite(String url) throws Throwable {
        navigationCobalt.navigateToPLUKPlus(url);
        navigationCobalt.waitForPageToLoadAndJQueryProcessingWithCustomTimeOut(90);

    }

}
package com.thomsonreuters.sitestructure.step_definitions;

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

public class SiteStructureCommonSteps extends BaseStepDef {

    private WLNFooter footer = new WLNFooter();
    private WLNHeader header = new WLNHeader();
    private CommonMethods commonMethods = new CommonMethods();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private CommonResourcePage commonResourcePage = new CommonResourcePage();
    private LegalUpdatesResultsPage legalUpdatesResultsPage = new LegalUpdatesResultsPage();
    private CategoryPage categoryPage = new CategoryPage();
    private FavouritesPage favouritesPage = new FavouritesPage();
    private TopicPage topicPage = new TopicPage();
    private PageActions pageActions = new PageActions();
    private OnePassLogoutPage onePassLogoutPage = new OnePassLogoutPage();
    private AskResourcePage askResourcePage = new AskResourcePage();
    private PracticalLawUKCategoryPage practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();
    private NavigationCobalt navigationCobalt= new NavigationCobalt();
    private WLNHeader wlnHeader= new WLNHeader();
    private CommonMethods comMethods= new CommonMethods();

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

    @Then("^user should see footer$")
    public void userShouldSeeFooter() throws Throwable {
        commonMethods.scrollUpOrDown(1300);
        assertTrue("Footer is not displayed..!", footer.footerWidget().isDisplayed());
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
        String pageTitle =standardDocumentPage.documentTitle().getText().trim();
        assertTrue(pageTitle + " Not matching..!", pageTitle.contains(pageDesc));
    }

    @Then("^user should have suggestion i.e. \"(.*?)\"$")
    public void userShouldHaveSuggestion(String pageDesc) throws Throwable {
        String didYouMeanText = knowHowSearchResultsPage.searchNoResultParagraph().getText();
        didYouMeanText = didYouMeanText.replaceAll("\\r\\n|\\r|\\n", " ");
        assertTrue("Did you mean Not Matching..!", didYouMeanText.contains(pageDesc));
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

    @Then("^the user clicks on search result \"(.*)\" title link$")
    public void theUserClicksOnSearchResultTitleLink(String titleLinkText) throws Throwable {
        for (WebElement titleLink : searchResultsPage.getAllSearchTitleLinks()) {
            if (titleLink.getText().trim().equalsIgnoreCase(titleLinkText)) {
                titleLink.click();
                break;
            }
        }
        assertTrue(titleLinkText + " not found..!", commonResourcePage.title().getText().trim().contains(titleLinkText));
    }

    @Then("^user clicks the Home Icon to make it as Start Page$")
    public void userClicksTheHomeIcon() throws Throwable {
        categoryPage.makeThisMyStartPage();
        categoryPage.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^user clicks the Home Icon to remove it as Start Page$")
    public void userClicksTheHomeIcontoRemoveItasStartPage() throws Throwable {
        categoryPage.removeThisAsMyStartPage();
        categoryPage.waitForPageToLoadAndJQueryProcessing();
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

    @When("^user clicks on \"(.*?)\" button$")
    public void userClicksOnButton(String buttonText) throws Throwable {
        if (buttonText.equalsIgnoreCase("ButtonTextToAdd")) {
            favouritesPage.organize().click();
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


    @Then("^the user should see the \"Add reply\" link next to question$")
    public void theUserShouldSeeTheAddReplyLinkNextToQuestion() throws Throwable {
        Is.is(askResourcePage.addReplyNextToHeaderLink().isDisplayed());
    }

    @When("^user should see the stricken through group '(.+)'$")
    public void userShouldSeeTheStrickenThroughGroup(String groupName) throws Throwable {
        assertTrue(groupName + " not stricken through..!", favouritesPage.favouriteStrickenThroughGroup(groupName).isDisplayed());
    }

    @When("^user should see the stricken through group link '(.+)'$")
    public void userShouldSeeTheStrickenThroughGroupLink(String groupName) throws Throwable {
        assertTrue(groupName + " not stricken through..!", favouritesPage.favouriteStrickenThroughGroup(groupName).isDisplayed());
    }

    @When("^user hovers over the fav group '(.*)' link '(.*)'$")
    public void UsercHoversOveTheGroupLink(String groupName, String linkText) throws Throwable {
        commonMethods.mouseOver(favouritesPage.favouriteGroupLink(groupName, linkText));
    }

    @When("^user should see the stricken through link '(.*)' of group '(.*)'$")
    public void UserShouldSeeTheStrickenThroughLink(String linkText, String groupName) throws Throwable {
        assertTrue(linkText + " not stricken through..!", favouritesPage.favouriteStrickenThroughGroupLink(groupName, linkText).isDisplayed());
    }

    @When("^user adds practice area '(.*)' to favourite group '(.*)'$")
    public void userAddsPAToFavouriteGroup(String paLinkText, String groupName) throws Throwable {
        header.companyLogo().click();
        commonMethods.waitElementByLinkText(paLinkText).click();
        categoryPage.addToFavourites(groupName);
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

    @When("^the user deletes the start page$")
    public void deleteStartPage() {
   //     folderBaseUtils.deleteStartPage();
    }

    @When("^the user opens \"(.+)\" url on plcuk website$")
    public void theUserOpensUrlOnPLCUKSite(String url) throws Throwable {
        navigationCobalt.navigateToPLCUKPlusSpecificURL(url);
        navigationCobalt.waitForPageToLoadAndJQueryProcessingWithCustomTimeOut(90);

    }

    @When("^user should see the page with heading \"(.*)\"$")
    public void userShouldSeeThePageWithHeading(String pageDesc) throws Throwable {
        String pageTitle =wlnHeader.pageHeaderLabel().getText().trim();
        assertTrue(pageTitle + " Not matching..!", pageTitle.contains(pageDesc));


    }
    @Then("^user should see the error page$")
    public void userShouldSeeTheErrorPage() throws Throwable {

    }

    @When("^the user is viewing \"(.*)\" homepage$")
    public void theUserIsViewingHomePage(String prodName) throws Throwable {
        comMethods.mouseOver(wlnHeader.compartmentToggleDropDown());

        if(prodName.equalsIgnoreCase("PL")){
            wlnHeader.compartmentToggleDropDownLink("pluk").click();
        }else if(prodName.equalsIgnoreCase("WLUK")){
            wlnHeader.compartmentToggleDropDownLink("wluk").click();
        }else if(prodName.equalsIgnoreCase("Commentary")){
            wlnHeader.compartmentToggleDropDownLink("library").click();
        }

        navigationCobalt.waitForPageToLoadAndJQueryProcessingWithCustomTimeOut(90);

    }
    @Then("^user should see the \"([^\"]*)\" home page$")
    public void userShouldSeeTheHomePage(String prodName) throws Throwable {
        if(prodName.equalsIgnoreCase("Practical Law")){
           assertTrue("Practical Law log is not displayed..!", wlnHeader.practicalLawLogo().isDisplayed());
        }else if(prodName.equalsIgnoreCase("Westlaw")){
           assertTrue("West Law UK header is not displayed..!",wlnHeader.westLawLogo().isDisplayed());
        }else if(prodName.equalsIgnoreCase("Commentary")){
           assertTrue("Commentary header is not displayed..!",wlnHeader.commentaryLogo().isDisplayed());
        }
    }

    @When("^the user opens url \"(.*)\" in the browser$")
    public void theUserOpensUrlInTheBrowser(String url) throws Throwable {
        navigationCobalt.navigateToPLUKPlus(url);
        navigationCobalt.waitForPageToLoadAndJQueryProcessingWithCustomTimeOut(90);

    }

 }
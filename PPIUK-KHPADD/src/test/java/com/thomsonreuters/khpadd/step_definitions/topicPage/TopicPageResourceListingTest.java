package com.thomsonreuters.khpadd.step_definitions.topicPage;

import com.thomsonreuters.khpadd.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.pages.folders.FavouritesPage;
import com.thomsonreuters.pageobjects.pages.folders.ResearchOrganizerPage;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.TopicPage;
import com.thomsonreuters.pageobjects.pages.widgets.CategoryPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TopicPageResourceListingTest extends BaseStepDef {

    private TopicPage topicPage = new TopicPage();
    private KHResourcePage resourcePage = new KHResourcePage();
    private CommonMethods commonMethods = new CommonMethods();
    private CategoryPage categoryPage = new CategoryPage();
    private ResearchOrganizerPage researchOrganizerPage = new ResearchOrganizerPage();
    private WLNHeader header = new WLNHeader();
    private FavouritesPage favouritesPage = new FavouritesPage();
    private PageActions pageActions = new PageActions();

    @Then("^the user is presented with a topic page with title \"(.*?)\"$")
    public void theUserIsPresentedWithATopicPageWithTitle(String titleName) throws Throwable {
        assertTrue(topicPage.topicPageTitle().getText().equals(titleName));
    }

    @Then("^the number of resources displayed on the first page is (\\d+)$")
    public void theNumberOfResourcesDisplayedOnTheFirstPageIs(int maxNoOfResources) throws Throwable {
        resourcePage.waitForPageToLoad();
        commonMethods.waitForElement(topicPage.resourceDocByTitle(), 5000);
        Thread.sleep(100);
        int size = topicPage.totalResourcesOnFirstPage();
        assertThat(topicPage.totalResourcesOnFirstPage(), Is.is(maxNoOfResources));
    }

    @When("^the user clicks on the resource link \"(.*?)\" under Practice Notes resource type$")
    public void theUserClicksOnTheResourceLinkUnderPracticeNotesResourceType(String resourceName) throws Throwable {
        topicPage.clickTopicLinkOnPAPage(resourceName).click();
    }

    @When("^the facet ordering along with corresponding resource count is as follows$")
    public void theFacetOrderingAlongWithCorrespondingResourceCountIsAsFollows(List<TopicPageFacets> expectedFacets) throws Throwable {
        Map<String, String> actualFacetList = topicPage.getTopicPageFacetsAsMap();
        for (TopicPageFacets facet : expectedFacets) {
            String expectedFacetName = facet.getFacetName();
            String expectedFacetCount = facet.getFacetCount();
            String actualFacetCount = actualFacetList.get(expectedFacetName);
            assertFalse(facet.getFacetName() + " is not present in Facet Listing", null == facet.getFacetName());
            assertTrue(expectedFacetCount.equals(actualFacetCount));
        }
    }

    @When("^following optional blocks are not displayed on the right hand side$")
    public void followingOptionalBlocksAreNotDisplayedOnTheRightHandSide(List<String> expectedHeaders) throws Throwable {
        for (String blockTitle : topicPage.optionalBlockTitle()) {
            int count = 0;
            for (String expectedTitle : expectedHeaders) {
                if (!blockTitle.equals(expectedTitle)) {
                    count++;
                }
            }
            assertTrue(blockTitle + "is present", count > 0);
        }
    }

    @Then("^following optional blocks are displayed on the right hand side$")
    public void optionalBlockIsDisplayedOnTheRightHandSide(List<String> expectedHeaders) throws Throwable {
        for (String blockTitle : topicPage.optionalBlockTitle()) {
            int count = 0;
            for (String expectedTitle : expectedHeaders) {
                if (blockTitle.equals(expectedTitle)) {
                    count++;
                    break;
                }
            }
            assertTrue(blockTitle + "is not present", count > 0);
        }
    }

    @When("^the user clicks on '(.+)' link on the header$")
    public void theUserClicksOnLinkOnTheHeader(String linkName) throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        switch (linkName) {
            case "Folders":
                header.foldersLink().click();
                break;
            case "History":
                header.historyLink().click();
                break;
            case "Favourites":
                header.favouritesLink().click();
                break;
            default:
        }
        researchOrganizerPage.waitForPageToLoad();
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
    }

    @When("^the user adds page to favourites group '(.+)'$")
    public void addPageToGroup(String groupName) throws Throwable {
        categoryPage.addToFavourites(groupName);
    }

    @Then("^the user checks that '(.+)' link presents in favourites group '(.+)' on Favourites page$")
    public void checkPagePresentsInFavouritesOnFavouritesPage(String linkName, String groupName) throws Throwable {
        favouritesPage.waitForPageToLoad();
        favouritesPage.checkCategoryPagePresents(linkName, groupName);
    }

    @When("^the user clicks '(.+)' link on Favourites page$")
    public void openLinkOnFavouritesPage(String pageName) throws Throwable {
        favouritesPage.openPage(pageName).click();
        favouritesPage.waitForPageToLoad();
    }

    @When("^the user deletes the favourites group '(.+)'$")
    public void deleteFavoriteGroup(String groupName) throws Throwable {
        favouritesPage.organize().click();
        pageActions.mouseOver(favouritesPage.favouriteGroup(groupName));
        favouritesPage.waitForPageToLoad();
        favouritesPage.deleteFavouriteGroupButton(groupName).click();
        favouritesPage.doneOrganizing().click();
    }

    @Then("^the favourites group '(.+)' is absent on Favourites page$")
    public void checkFavoriteGroupAbsent(String groupName) throws Throwable {
        Thread.sleep(500);
        favouritesPage.checkFavouriteGroupIsAbsent(groupName);
    }

    @When("^clicks on the facet group \"(.*?)\"$")
    public void clicksOnTheFacetGroup(String facetName) throws Throwable {
        topicPage.facetNameLink(facetName).click();
        topicPage.waitForPageToLoad();
        Thread.sleep(1000);
    }

    @Then("^the documents listed under resource group \"(.*?)\" should be alphabetically ordered as below$")
    public void theDocumentsListedUnderResourceGroupShouldBeAlphabeticallyOrderedAsBelow(String resourceType, List<String> expectedResources) throws Throwable {
        if (resourceType.equals("Practice note: overview")) {
            resourceType = "Practice_note:_overview";
        } else if (resourceType.equals("Practice notes")) {
            resourceType = "Practice_notes";
        }
        assertTrue(expectedResources.equals(topicPage.getResourcesList(resourceType)));
    }

    public class TopicPageFacets {
        private String facetName;
        private String facetCount;

        public String getFacetName() {
            return facetName;
        }

        public String getFacetCount() {
            return facetCount;
        }
    }

}
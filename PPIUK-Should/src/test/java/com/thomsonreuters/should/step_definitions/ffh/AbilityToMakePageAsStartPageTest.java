package com.thomsonreuters.should.step_definitions.ffh;

import com.thomsonreuters.pageobjects.pages.folders.FavouritesPage;
import com.thomsonreuters.pageobjects.pages.widgets.CategoryPage;
import com.thomsonreuters.should.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

public class AbilityToMakePageAsStartPageTest extends BaseStepDef {

    private CategoryPage categoryPage = new CategoryPage();
    private FavouritesPage favouritesPage = new FavouritesPage();

    @When("^the user makes page as My Start Page$")
    public void addPageToGroup() throws Throwable {
        categoryPage.makeThisMyStartPage();
    }

    @Then("^the user checks that '(.+)' link presents in favourites group '(.+)' on Favourites page$")
    public void checkPagePresentsInFavouritesOnFavouritesPage(String linkName, String groupName) throws Throwable {
        favouritesPage.waitForPageToLoad();
		assertTrue("Favourite page is absent in group '" + groupName + "'",
				favouritesPage.isFavouritePageInGroupPresent(linkName, groupName));
    }

    @When("^the user clicks '(.+)' link on Favourites page$")
    public void openLinkOnFavouritesPage(String pageName) throws Throwable {
        favouritesPage.openPage(pageName).click();
        favouritesPage.waitForPageToLoad();
    }

    @Then("page '(.+)' opens$")
    public void checkPageOpens(String pageName) throws Throwable {
        categoryPage.checkPageOpens(pageName);
    }

    @Then("^the user clicks the Start Page to remove it from Start Page$")
    public void userClicksTheHomeIcontoRemoveItasStartPage() throws Throwable {
        categoryPage.removeThisAsMyStartPage();
    }

    @Then("^the user checks that '(.+)' link is not in favourites group '(.+)' on Favourites page$")
    public void checkPageIsNotInFavouritesOnFavouritesPage(String linkName, String groupName) throws Throwable {
        favouritesPage.waitForPageToLoad();
		assertFalse("Favourite page is present in group '" + groupName + "'",
				favouritesPage.isFavouritePageInGroupPresent(linkName, groupName));
    }

}

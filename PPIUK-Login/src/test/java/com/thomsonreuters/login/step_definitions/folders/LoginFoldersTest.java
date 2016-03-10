package com.thomsonreuters.login.step_definitions.folders;

import static org.junit.Assert.assertFalse;

import com.thomsonreuters.login.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.documentNavigation.DocumentDeliveryPage;
import com.thomsonreuters.pageobjects.pages.widgets.CategoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginFoldersTest extends BaseStepDef {

    private DocumentDeliveryPage documentDeliveryPage = new DocumentDeliveryPage();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private CategoryPage categoryPage = new CategoryPage();

    @Then("^he does not see in the document page Add To Folder link$")
    public void heDoesNotSeeInTheDocumentPageAddToFolderLink() throws Throwable {
        assertFalse("Add to Folder is visible", documentDeliveryPage.isAddToFolderLinkPresent());
    }

    @When("^he navigate to a page \"(.*?)\" eligible to be selected as Favourite$")
    public void heNavigateToAPageEligibleToBeSelectedAsFavourite(String url) throws Throwable {
        navigationCobalt.navigateToPLCUKPlusSpecificURL(url);
        categoryPage.waitForPageToLoad();
    }

    @Then("^he does not see any favourites icon/link$")
    public void heDoesNotSeeAnyFavouritesIconLink() throws Throwable {
		assertFalse("Add to Favorites is visible for user", categoryPage.addToFavouritesLinkPresent());
    }

    @Then("^he is not able to add it to Favourites$")
    public void heIsNotAbleToAddItToFavourites() throws Throwable {
        boolean isPageAddedToFavorites = true;
        try {
            categoryPage.addToFavoritesLink().click();
        } catch (NullPointerException npe) {
            LOG.info("User is not able to add page to favorites");
            isPageAddedToFavorites = false;
        }
        assertFalse("User is able to add page to favorites", isPageAddedToFavorites);
    }

}

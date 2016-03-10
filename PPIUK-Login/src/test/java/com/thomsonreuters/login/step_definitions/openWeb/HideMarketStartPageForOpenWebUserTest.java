package com.thomsonreuters.login.step_definitions.openWeb;

import static org.junit.Assert.assertFalse;

import com.thomsonreuters.login.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.widgets.CategoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HideMarketStartPageForOpenWebUserTest extends BaseStepDef {

    private CategoryPage categoryPage = new CategoryPage();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();

    @When("^he navigates to a page \"(.*?)\" eligible to be selected as Start Page$")
    public void heNavigatesToAPageEligibleToBeSelectedAsStartPage(String url) throws Throwable {
        navigationCobalt.navigateToPLCUKPlusSpecificURL(url);
        categoryPage.waitForPageToLoad();
    }

    @Then("^he does not see any Start Page icon/link$")
    public void heDoesNotSeeAnyStartPageIconLink() throws Throwable {
		assertFalse("Make this my start page link is visible for user", categoryPage.makeThisMyStartPageLinkPresent());
    }

    @Then("^he is not able to select the page as start page$")
    public void heIsNotAbleToSelectThePageAsStartPage() throws Throwable {
        boolean isPageSelectedAsStartPage = true;
        try {
            categoryPage.addToFavoritesLink().click();
        } catch (NullPointerException npe) {
            LOG.info("User is not able to select page as start page");
            isPageSelectedAsStartPage = false;
        }
        assertFalse("User is able select page as start page", isPageSelectedAsStartPage);
    }

}

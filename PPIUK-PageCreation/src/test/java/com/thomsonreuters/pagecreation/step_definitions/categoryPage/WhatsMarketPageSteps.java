package com.thomsonreuters.pagecreation.step_definitions.categoryPage;

import com.thomsonreuters.pagecreation.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.pages.widgets.CategoryPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WhatsMarketPageSteps  extends BaseStepDef {

    private HomePage homePage;
    private CategoryPage categoryPage;

    public WhatsMarketPageSteps() {
        homePage = new HomePage();
        categoryPage = new CategoryPage();
    }

    @When("^the user clicks on the resources tab on the home page$")
    public void theUserClicksOnTheResourcesTabOnTheHomePage() throws Throwable {
        homePage.resourcesLink().click();
    }

    @When("^the whats market link is clicked$")
    public void theWhatsMarketLinkIsClicked() throws Throwable {
        homePage.whatsMarketLink().click();
    }

    @Then("^the whats market page is displayed correctly$")
    public void theWhatsMarketPageIsDisplayedCorrectly() throws Throwable {
        categoryPage.mainColumn().isDisplayed();
    }

}
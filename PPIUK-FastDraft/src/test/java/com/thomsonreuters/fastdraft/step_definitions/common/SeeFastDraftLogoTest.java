package com.thomsonreuters.fastdraft.step_definitions.common;

import com.thomsonreuters.fastdraft.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import com.thomsonreuters.pageobjects.pages.widgets.CategoryPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SeeFastDraftLogoTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private CategoryPage categoryPage = new CategoryPage();
    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();

    @When("^the user come back on to Home page$")
    public void userComeBackOnToHomePage() throws Throwable {
        navigationCobalt.waitForPageToLoad();
        if (!isHomePage()) {
            navigationCobalt.navigateToHomePage();
            navigationCobalt.waitForPageToLoad();
        }
    }

    @When("^the user opens '(.+)' link$")
    public void openLink(String linkName) throws Throwable {
        categoryPage.openPageByText(linkName);
    }

    @When("^the user opens \"([^\"]*)\" link$")
    public void openLinkFromList(String linkName) throws Throwable {
        categoryPage.openPageByText(linkName);
    }

    @Then("^the user sees the FastDraft logo for \"([^\"]*)\" document$")
    public void checkFastDraftLogo(String document) throws Throwable {
        standardDocumentPage.checkDocumentHasFastDratLogo(document);
    }

    private boolean isHomePage() {
        if (!(categoryPage.getCurrentUrl().contains("/Search/Home.html")
                || categoryPage.getCurrentUrl().contains("/Search/BrowseRoot.html") || categoryPage.getCurrentUrl()
                .contains("Home/Home"))) {
            return false;
        }
        return true;
    }

}

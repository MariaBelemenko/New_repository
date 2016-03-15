package com.thomsonreuters.globalpages.step_definitions.search;

import org.assertj.core.api.SoftAssertions;

import com.thomsonreuters.globalpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.globalPage.GlobalCategoryPage;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.pages.search.SearchHomePage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ChinaPageSearchContentTest extends BaseStepDef {

    private NavigationCobalt navigation = new NavigationCobalt();
    private HomePage homePage = new HomePage();
    private GlobalCategoryPage globalCategoryPage = new GlobalCategoryPage();
    private SearchHomePage searchHomePage = new SearchHomePage();

    private static final String PATH_TO_CHINA_PAGE = "/Browse/Home/International/ChinaGlobal";

    @When("^the user navigates to the China Category Page$")
    public void theUserNavigatesToTheChinaCategoryPage() throws Throwable {
        navigation.navigateToPLCUKPlusSpecificURL(PATH_TO_CHINA_PAGE);
    }

    @Then("^the China Category Page opens correctly$")
    public void theChinaCategoryPageOpensCorrectly() throws Throwable {
        theCategoryPageOpensCorrectly();
    }

    @When("^the user selects \"(.*?)\" tab$")
    public void theUserSelectsTab(String tab) throws Throwable {
    	globalCategoryPage.waitForPageToLoad();
        homePage.specificTab(tab).click();
    }

    private void theCategoryPageOpensCorrectly() throws Throwable {
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

    @When("^the user searches for \"([^\"]*)\"$")
    public void theUserSearchesFor(String searchQuery) throws Throwable {
    	searchHomePage.enterSearchText(searchQuery);
        searchHomePage.searchButton().click();
        searchHomePage.waitForPageToLoad();
        searchHomePage.waitForPageToLoadAndJQueryProcessing();
    }
}

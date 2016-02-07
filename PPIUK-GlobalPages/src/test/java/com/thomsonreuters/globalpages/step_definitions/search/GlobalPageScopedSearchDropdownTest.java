package com.thomsonreuters.globalpages.step_definitions.search;

import com.thomsonreuters.globalpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.globalPage.GlobalCategoryPage;
import com.thomsonreuters.pageobjects.pages.landingPage.SearchScopeControl;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.TopicPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.pageobjects.utils.globalPage.GlobalPageUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class GlobalPageScopedSearchDropdownTest extends BaseStepDef {

    private GlobalCategoryPage globalCategoryPage = new GlobalCategoryPage();
    private GlobalPageUtils globalPageUtils = new GlobalPageUtils();
    private CommonMethods commonMethods = new CommonMethods();
    private SearchScopeControl searchScopeControl = new SearchScopeControl();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private TopicPage page = new TopicPage();

    private List<String> initialListOfCountries;

    @Then("^the scoped search drop down contains the following countries$")
    public void theScopedSearchDropDownContainsTheFollowingCountries(List<String> countries) throws Throwable {
        initialListOfCountries = new ArrayList<String>();
        initialListOfCountries.addAll(countries);
        theUserCanDisplayTheScopedSearchDropdownMenuOptions("display");
//        SoftAssertions softly = new SoftAssertions();
//        softly.assertThat(globalCategoryPage.fullListOfContriesInTheSSDD().size() == countries.size())
//                .overridingErrorMessage("Size of list of countries is not right").isTrue();
//        for (int i = 0; i < globalCategoryPage.fullListOfContriesInTheSSDD().size(); i++) {
//            softly.assertThat(
//                    globalCategoryPage.fullListOfContriesInTheSSDD().get(i).getText().equals(countries.get(i)))
//                    .overridingErrorMessage(
//                            globalCategoryPage.fullListOfContriesInTheSSDD().get(i).getText() + " not equals to "
//                                    + countries.get(i)
//                    ).isTrue();
//            softly.assertThat(globalCategoryPage.fullListOfContriesInTheSSDD().get(i).isDisplayed())
//                    .overridingErrorMessage(
//                            globalCategoryPage.fullListOfContriesInTheSSDD().get(i) + " is not displayed");
//        }
//        softly.assertAll();
    }

    @Then("^the countries are sorted in alphabetical order$")
    public void theCountriesAreSortedInAlphabeticalOrder() throws Throwable {
        assertTrue("Countries are not sorted in alphabetical order",
                globalPageUtils.isTheListSortedInAlphabeticalOrder(commonMethods
                        .getTextsFromWebElements(globalCategoryPage.theFollowingItemsForTheFirstSixInTheSSDD()))
        );
    }

    @Then("^the scoped search drop down contains the initial list of countries$")
    public void theScopedSearchDropDownContainsTheInitialListOfCountries() throws Throwable {
        theUserCanDisplayTheScopedSearchDropdownMenuOptions("display");
        assertTrue(
                "Current list of countries not equals the initial list of countries",
                commonMethods.getTextsFromWebElements(globalCategoryPage.fullListOfContriesInTheSSDD()).equals(
                        initialListOfCountries)
        );
    }

    @Then("^the scoped search dropdown states \"(.*?)\"$")
    public void theScopedSearchDropdownStates(String param) throws Throwable {
        theUserCanVerifyThatTheScopedSearchDropdownStates(param);
    }

    @When("^the user can verify that the scoped search dropdown states \"([^\"]*)\"$")
    public void theUserCanVerifyThatTheScopedSearchDropdownStates(String expectedText) throws Throwable {
        String returnedText;
        expectedText = expectedText.replaceAll("\\s+", "");
        returnedText = searchScopeControl.scopedSearchDropdownTitle().getText().replaceAll("\\s+", "");
        assertTrue(returnedText.equals(expectedText));
    }

    @When("^user selects the dropdown option \"(.*?)\"$")
    public void userSelectsTheDropdownOption(String option) throws Throwable {
        searchScopeControl.scopedSearchDropdownOptions(option).click();
    }

    @When("^the user can verify that the title listed above the search results is \"([^\"]*)\"$")
    public void theUserCanVerifyThatTheTitleListedAboveTheSearchResultsIs(String arg1) throws Throwable {
        arg1 = "\"" + arg1 + "\"";
        searchResultsPage.resultPageTitle(arg1).isDisplayed();
    }

    @Then("^the user is presented with a page with header \"(.*?)\"$")
    public void theUserIsPresentedWithPageWithhHeader(String header) {
        Assert.assertTrue(
                String.format("Page header '%s' does not contain expected text '%s'", page.getPageHeaderLabel().getText(), header), page
                        .getPageHeaderLabel().getText().toLowerCase().contains(header.toLowerCase())
        );
    }

    private void theUserCanDisplayTheScopedSearchDropdownMenuOptions(String arg1) throws Throwable {
        searchScopeControl.scopedSearchDropdownMenuButton().click();
    }

}

package com.thomsonreuters.should.step_definitions.search.knowhow;

import com.thomsonreuters.pageobjects.pages.landingPage.SearchScopeControl;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.should.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ScopedSearchDropdownTest extends BaseStepDef {

    private SearchScopeControl searchScopeControl = new SearchScopeControl();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();

    @When("^the user can verify that the scoped search dropdown states \"([^\"]*)\"$")
    public void theUserCanVerifyThatTheScopedSearchDropdownStates(String expectedText) throws Throwable {
        String returnedText;
        /** Strip spaces from the string */
        expectedText = expectedText.replaceAll("\\s+", "");
        /** Strip spaces from the string */
        returnedText = searchScopeControl.scopedSearchDropdownTitle().getText().replaceAll("\\s+", "");
        assertTrue(returnedText.equals(expectedText));
    }

    @When("^the user can (display|close) the scoped search dropdown menu options$")
    public void theUserCanDisplayTheScopedSearchDropdownMenuOptions(String arg1) throws Throwable {
        searchScopeControl.scopedSearchDropdownMenuButton().click();
    }

    @When("^the user can verify that the title listed above the search results is \"([^\"]*)\"$")
    public void theUserCanVerifyThatTheTitleListedAboveTheSearchResultsIs(String arg1) throws Throwable {
        arg1="\"" + arg1 +"\"";
        searchResultsPage.resultPageTitle(arg1).isDisplayed();
    }

    @Then("^the search drop down options provided on \"(.*?)\" are as below$")
    public void theSearchDropDownOptionsProvidedOnAreAsBelow(String currentPage, List<String> expectedOptions) throws Throwable {
        for (String option : searchScopeControl.scopedSearchDropdownOptionsList()) {
            int count = 0;
            for (String expectedOption : expectedOptions) {
                if (option.equals(expectedOption)) {
                    count++;
                    break;
                }
            }
            assertTrue(option + "is not present", count > 0);
        }
    }

    @When("^user selects the dropdown option \"(.*?)\"$")
    public void userSelectsTheDropdownOption(String option) throws Throwable {
        searchScopeControl.scopedSearchDropdownOptions(option).click();
    }

}

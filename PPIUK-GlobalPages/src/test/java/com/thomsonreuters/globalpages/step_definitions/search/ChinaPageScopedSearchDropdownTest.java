package com.thomsonreuters.globalpages.step_definitions.search;

import com.thomsonreuters.globalpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.globalPage.ChinaCategoryPage;
import com.thomsonreuters.pageobjects.pages.landingPage.SearchScopeControl;
import cucumber.api.java.en.Then;

import java.util.ArrayList;
import java.util.List;

public class ChinaPageScopedSearchDropdownTest extends BaseStepDef {

    private SearchScopeControl searchScopeControl = new SearchScopeControl();
    private ChinaCategoryPage chinaCategoryPage = new ChinaCategoryPage();

    @Then("^the scoped search drop down contains the practice areas as below$")
    public void theScopedSearchDropDownContainsThePracticeAreasAsBelow(List<String> items) throws Throwable {
        chinaCategoryPage.waitForPageToLoad();
        List<String> initialListOfPracticeAreas = new ArrayList<String>();
        initialListOfPracticeAreas.addAll(items);
        theUserCanDisplayTheScopedSearchDropdownMenuOptions("display");
//        SoftAssertions softly = new SoftAssertions();
//        softly.assertThat(searchScopeControl.scopedSearchDropdownOptionsList().size() == items.size())
//                .overridingErrorMessage("Size of list of practice areas is not right").isTrue();
//        for (int i = 0; i < searchScopeControl.scopedSearchDropdownOptionsList().size(); i++) {
//            softly.assertThat(searchScopeControl.scopedSearchDropdownOptionsList().get(i).equals(items.get(i)))
//                    .overridingErrorMessage(
//                            searchScopeControl.scopedSearchDropdownOptionsList().get(i) + " not equals to "
//                                    + items.get(i)
//                    ).isTrue();
//        }
//        softly.assertAll();
    }

    private void theUserCanDisplayTheScopedSearchDropdownMenuOptions(String arg1) throws Throwable {
        searchScopeControl.scopedSearchDropdownMenuButton().click();
    }

}

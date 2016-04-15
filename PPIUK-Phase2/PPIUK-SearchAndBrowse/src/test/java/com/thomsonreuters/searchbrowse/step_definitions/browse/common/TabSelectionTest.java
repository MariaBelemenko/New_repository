package com.thomsonreuters.searchbrowse.step_definitions.browse.common;

import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.pages.widgets.CategoryPage;
import com.thomsonreuters.pageobjects.utils.document.StandardDocumentUtils;
import com.thomsonreuters.searchbrowse.step_definitions.BaseStepDef;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class TabSelectionTest extends BaseStepDef {

    private CategoryPage categoryPage = new CategoryPage();
    private HomePage homePage = new HomePage();
    private StandardDocumentUtils standardDocumentUtils = new StandardDocumentUtils();

    @When("^the user opens '(.+)' link$")
    public void openLink(String linkName) throws Throwable {
        categoryPage.openPageByText(linkName);
    }

    @When("^the user opens \"([^\"]*)\" link$")
    public void openLinkFromList(String linkName) throws Throwable {
        categoryPage.openPageByText(linkName);
    }

//    @Then("^the Practice Area section links are present and the first '(.*)' related links are valid for every PA section$")
//    public void thePracticeAreaSectionLinksArePresentAndAllRelatedLinksAreValidForEveryPASection(int linksCountToCheck) {
//        SoftAssertions softAssertions = new SoftAssertions();
//        List<WebElement> sectionsLinks = homePage.getSelectedSectionLinks();
//        for (WebElement sectionLink : sectionsLinks) {
//            softAssertions.assertThat(standardDocumentUtils.isLinksAreValidInSection(sectionLink, linksCountToCheck))
//                    .withFailMessage(standardDocumentUtils.getPracticeAreaLinksErrMsg())
//                    .isTrue();
//        }
//        softAssertions.assertAll();
//    }

    @And("^the user verifies that default Tab is '(.*)'$")
    public void theUserVerifiesThatDefaultTabIsTab(String tabName) throws Throwable {
        assertTrue("The 'default' tab is NOT " + tabName, homePage.activeTab().getText().contains(tabName));
    }

}

package com.thomsonreuters.globalpages.step_definitions.common;

import com.thomsonreuters.globalpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.company.MeetTheTeam;
import com.thomsonreuters.pageobjects.pages.globalPage.ChinaCategoryPage;
import com.thomsonreuters.pageobjects.pages.globalPage.GlobalCategoryPage;
import com.thomsonreuters.pageobjects.pages.urls.plcuk.KHDocumentPage;
import com.thomsonreuters.pageobjects.utils.globalPage.GlobalPageUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class GlPageTabTest extends BaseStepDef {

    private GlobalPageUtils globalPageUtils = new GlobalPageUtils();
    private GlobalCategoryPage globalCategoryPage = new GlobalCategoryPage();
    private ChinaCategoryPage chinaCategoryPage = new ChinaCategoryPage();
    private MeetTheTeam meetTheTeam = new MeetTheTeam();
    private CommonMethods commonMethods = new CommonMethods();
    private KHDocumentPage khDocumentPage = new KHDocumentPage();
    private NavigationCobalt navigation = new NavigationCobalt();

    private static final String PATH_TO_GLOBAL_PAGE = "/Browse/Home/Global";

    @Then("^international guide opens correctly$")
    public void internationalGuideOpensCorrectly() throws Throwable {
//        SoftAssertions softly = new SoftAssertions();
//        for (WebElement element : meetTheTeam.contributorProfiles()) {
//            if (!element.getText().isEmpty()) {
//                softly.assertThat(element.isDisplayed())
//                        .overridingErrorMessage(element.getText() + " is not distplayed").isTrue();
//            }
//        }
//        softly.assertAll();
    }

    @When("^the list of links is present below the \"(.*?)\" header$")
    public void theListOfLinksIsPresentBelowTheHeader(String header) throws Throwable {
//        SoftAssertions softly = new SoftAssertions();
//        for (WebElement element : chinaCategoryPage.linksUnderTheHeadersInTheResourcesTab(header)) {
//            softly.assertThat(element.isDisplayed()).overridingErrorMessage("link is not distplayed").isTrue();
//        }
//        softly.assertAll();
    }

    @When("^all \"(.*?)\" links opens correctly$")
    public void allLinksOpensCorrectly(String header) throws Throwable {
        List<String> featuredContentLinks = globalPageUtils.getLinkNamesFromWebElementList(chinaCategoryPage
                .linksUnderTheHeadersInTheResourcesTab(header));
        for (int i = 0; i < featuredContentLinks.size(); i++) {
            if (!featuredContentLinks.get(i).equals("View all PL standard documents and clauses")) {
                globalCategoryPage.waitForPageToLoad();
                globalCategoryPage.waitForPageToLoadAndJQueryProcessing();
                LOG.info("link: " + featuredContentLinks.get(i));
                commonMethods.clickLink(featuredContentLinks.get(i));
                assertTrue("Document not present", khDocumentPage.isDocumentBlockPresent());
                theUserNavigatesToTheGlobalPage();
            }
        }
    }

    @Then("^the \"(.*?)\" header is displayed$")
    public void theHeaderIsDisplayed(String header) throws Throwable {
        globalCategoryPage.waitForPageToLoad();
        assertTrue("The " + header + " header is not displayed", globalCategoryPage.linksHeader(header).isDisplayed());
    }

    @Then("^the list of countries includes the following countries$")
    public void theListOfCountriesIncludesTheFollowingCountries(List<String> items) throws Throwable {
//        SoftAssertions softly = new SoftAssertions();
//        List<String> countries = globalPageUtils.getLinkNamesFromWebElementList(globalCategoryPage.countriesTabLinks());
//        for (int i = 0; i < items.size(); i++) {
//            softly.assertThat(countries.contains(items.get(i)))
//                    .overridingErrorMessage(items.get(i) + " is not present in the list of countries").isTrue();
//        }
//        softly.assertAll();
    }

    @Then("^the list of global guides is present as below$")
    public void theListOfGlobalGuidesIsPresentAsBelow(List<String> items) throws Throwable {
//        SoftAssertions softly = new SoftAssertions();
//        softly.assertThat(globalCategoryPage.globalGuides().size() == items.size())
//                .overridingErrorMessage("Size of list of global guides is not right").isTrue();
//        for (int i = 0; i < globalCategoryPage.globalGuides().size(); i++) {
//            softly.assertThat(globalCategoryPage.globalGuides().get(i).getText().equals(items.get(i)))
//                    .overridingErrorMessage(
//                            globalCategoryPage.globalGuides().get(i).getText() + " not equals to " + items.get(i))
//                    .isTrue();
//        }
//        softly.assertAll();
    }

    @When("^the user clicks on \"(.*?)\" link$")
    public void theUserClicksOnLink(String linkText) {
        commonMethods.clickLink(linkText);
    }

    private void theUserNavigatesToTheGlobalPage() throws Throwable {
        navigation.navigateToPLCUKPlusSpecificURL(PATH_TO_GLOBAL_PAGE);
        globalCategoryPage.waitForPageToLoad();
    }

}

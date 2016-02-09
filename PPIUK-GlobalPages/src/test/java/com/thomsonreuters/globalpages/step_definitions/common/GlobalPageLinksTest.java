package com.thomsonreuters.globalpages.step_definitions.common;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.slf4j.LoggerFactory;

import com.thomsonreuters.globalpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.common.ExcelFileReader;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.globalPage.GlobalCategoryPage;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.CaseDocumentPage;
import com.thomsonreuters.pageobjects.pages.urls.plcuk.KHDocumentPage;
import com.thomsonreuters.pageobjects.utils.CobaltUser;
import com.thomsonreuters.pageobjects.utils.OnepassLoginUtils;
import com.thomsonreuters.pageobjects.utils.globalPage.GlobalPageUtils;

import cucumber.api.Transpose;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GlobalPageLinksTest extends BaseStepDef {

    protected static final org.slf4j.Logger LOG = LoggerFactory.getLogger(CommonMethods.class);

    private GlobalCategoryPage globalCategoryPage = new GlobalCategoryPage();
    private GlobalPageUtils globalPageUtils = new GlobalPageUtils();
    private WLNHeader wlnHeader = new WLNHeader();
    private CommonMethods commonMethods = new CommonMethods();
    private CaseDocumentPage caseDocumentPage = new CaseDocumentPage();
    private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();
    private HomePage homePage = new HomePage();
    private OnepassLoginUtils onepassLoginUtils = new OnepassLoginUtils();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private KHDocumentPage documentPagePLCUK = new KHDocumentPage();

    @When("^the user navigates to the main PLCUK page$")
    public void theUserNavigatesToTheMainPLCUKPage() throws Throwable {
        navigationCobalt.navigateToPLUKPlus();
        navigationCobalt.waitForPageToLoad();
    }

    @Then("^the document opens correctly$")
    public void theDocumentOpensCorrectly() throws Throwable {
        assertTrue("Document not present", documentPagePLCUK.isDocumentBlockPresent());
    }

    @Then("^the user verifies that the current PageTitle contains '(.*)'$")
    public void theUserVerifiesThatTheCurrentPageTitleContainsPageTitle(String pageTitle) throws Throwable {
        assertTrue("The Expected Page Title " + pageTitle + " is  NOT displayed", wlnHeader.pageHeaderLabel().getText().contains(pageTitle));
    }

    @When("^the user selects \"(.*?)\" tab and clicks on \"(.*?)\" link in \"(.*?)\" section$")
    public void theUserSelectsTabAndClicksOnLinkInSection(String tab, String linkText, String sectionName)
            throws Throwable {
        globalCategoryPage.waitForPageToLoad();
        homePage.specificTab(tab).click();
        globalCategoryPage.linkInSection(linkText, sectionName).click();
    }

    @When("^the user clicks on browse menu and selects International tab$")
    public void theUserClicksOnBrowseMenuAndSelectsInternationalTab() throws Throwable {
        wlnHeader.browseMenuButton().click();
        homePage.selectInternationalTab();
    }

    @Then("^the user clicks on \"(.*?)\" link in \"(.*?)\" section$")
    public void theUserClicksOnLinkInSection(String linkText, String sectionName) throws Throwable {
        globalCategoryPage.linkInInterSubscriptionsSectionInBrowseMenu(linkText, sectionName).click();
    }

    @Then("^the user is taken to the \"(.*?)\" with the \"(.*?)\" title in the same window and tab$")
    public void theUserIsTakenToTheWithTheTitleInTheSameWindowAndTab(String webSite, String title) throws Throwable {
        globalCategoryPage.waitForPageToLoad();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(globalCategoryPage.getCurrentUrl().contains(webSite))
                .overridingErrorMessage("The user is taken to the %s web site", globalCategoryPage.getCurrentUrl())
                .isTrue();
        softly.assertThat(globalCategoryPage.getPageTitle().contains(title))
                .overridingErrorMessage("The current page title is %s", globalCategoryPage.getPageTitle()).isTrue();
        softly.assertAll();
    }

    @Then("^the user is taken to the \"(.*?)\" web site in the same window and tab$")
    public void theUserIsTakenToTheWebSiteInTheSameWindowAndTab(String webSite) throws Throwable {
        globalCategoryPage.waitForPageToLoad();
        SoftAssertions softly = new SoftAssertions();
        String url = globalCategoryPage.getCurrentUrl();
        LOG.info("Current Url" + globalCategoryPage.getCurrentUrl());
        softly.assertThat(globalCategoryPage.getCurrentUrl().contains(webSite))
                .overridingErrorMessage("The user is taken to the %s web site", globalCategoryPage.getCurrentUrl())
                .isTrue();
        softly.assertAll();
    }

    @When("^the \"(.*?)\" settings icon is displayed$")
    public void theSettingsIconIsDisplayed(String icon) throws Throwable {
        globalCategoryPage.waitForPageToLoad();
        assertTrue("The Sign off button is not displayed ", globalPageUtils.toggleProfileSettingsIcon(icon)
                .isDisplayed());
    }

    @Then("^the user is taken on the comparison tool page with header \"(.*?)\"$")
    public void theUserIsTakenOnTheComparisonToolPageWithHeader(String header) throws Throwable {
        Assert.assertTrue(String.format("Page header '%s' does not contain expected text '%s'", caseDocumentPage
                .partyNamesInCaseLaw().getText(), header), caseDocumentPage.partyNamesInCaseLaw().getText()
                .toLowerCase().contains(header.toLowerCase()));
    }

    @When("^the user clicks on \"(.*?)\" in \"(.*?)\" section$")
    public void theUserClicksOnInSection(String link, String section) throws Throwable {
        assetDocumentPage.linkInLegalApdatesSection(link, section).click();
    }

    @When("^the user logged in PLUS in the login screen$")
    public void theUserLoggedInPLUSInTheLoginScreen(@Transpose List<CobaltUser> plPlusUserList) throws Throwable {
        CobaltUser plPlusUser = CobaltUser.updateMissingFields(plPlusUserList.get(0));
        plPlusUser.setUserName(!"None".equalsIgnoreCase(System.getProperty("username")) ? System
                .getProperty("username") : plPlusUser.getUserName());
        onepassLoginUtils.loginToOnePassSettings(plPlusUser.getUserName(),
                ExcelFileReader.getCobaltPassword(plPlusUser.getUserName()));
    }

    @When("^the user clicks on Continue button$")
    public void theUserClicksOnContinueButton() throws Throwable {
        globalCategoryPage.waitForPageToLoad();
        globalPageUtils.clickOnContinueButton();
    }

}

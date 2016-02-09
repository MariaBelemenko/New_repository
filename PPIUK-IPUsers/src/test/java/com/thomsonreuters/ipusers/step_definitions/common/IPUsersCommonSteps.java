package com.thomsonreuters.ipusers.step_definitions.common;

import com.thomsonreuters.ipusers.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.common.ExcelFileReader;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.adestra.SubscriptionPreferencePage;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawHomepage;
import com.thomsonreuters.pageobjects.pages.login.OnepassLogin;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.documentNavigation.AnnotationPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.documentNavigation.DocumentDeliveryPage;
import com.thomsonreuters.pageobjects.pages.search.SearchHomePage;
import com.thomsonreuters.pageobjects.pages.widgets.CategoryPage;
import com.thomsonreuters.pageobjects.utils.CobaltUser;
import com.thomsonreuters.pageobjects.utils.OnepassLoginUtils;
import cucumber.api.Transpose;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by uc186961 on 05/02/2016.
 */
public class IPUsersCommonSteps extends BaseStepDef {

    private WLNHeader wlnHeader;
    private OnepassLogin onepassLogin;
    private PracticalLawHomepage practicalLawHomepage;
    private OnepassLoginUtils onePassLoginUtils;
    private NavigationCobalt navigationCobalt;
    private CategoryPage categoryPage;
    private DocumentDeliveryPage documentDeliveryPage;
    private AnnotationPage annotationPage;
    private SearchHomePage searchHomePage;
    private CommonMethods commonMethods;
    private SubscriptionPreferencePage subscriptionPreferencePage;

    public IPUsersCommonSteps(){
        wlnHeader = new WLNHeader();
        onepassLogin = new OnepassLogin();
        practicalLawHomepage = new PracticalLawHomepage();
        onepassLogin = new OnepassLogin();
        navigationCobalt = new NavigationCobalt();
        categoryPage = new CategoryPage();
        documentDeliveryPage = new DocumentDeliveryPage();
        annotationPage = new AnnotationPage();
        searchHomePage = new SearchHomePage();
        commonMethods = new CommonMethods();
        subscriptionPreferencePage = new SubscriptionPreferencePage();
    }


    @When("^the user clicks on Sign in with a Different Account link on the header$")
    public void theUserClicksOnSignInWithADifferentAccountLinkOnTheHeader() throws Throwable {
        wlnHeader.signInWithDifferentAccount();
        onepassLogin.waitForPageToLoad();
    }

    @When("^a PPI user enter its username and password$")
    public void aPPIUserEnterItsUsernameAndPassword(@Transpose List<CobaltUser> plPlusUserList) throws Throwable {
        CobaltUser plPlusUser = CobaltUser.updateMissingFields(plPlusUserList.get(0));
        onePassLoginUtils.enterUserNameAndPassword(plPlusUser.getUserName(), ExcelFileReader.getCobaltPassword(plPlusUser.getUserName()));
        currentUser = plPlusUser;
    }

    @When("^clicks on Sign in$")
    public void clicksOnSignIn() throws Throwable {
        onepassLogin.signOnButton().click();
        practicalLawHomepage.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^the user is able to see default client id \"(.*?)\"$")
    public void theUserIsAbleToSeeDefaultClientId(String defaultClientID) throws Throwable {
        assertTrue("Default Client Id is not visible", wlnHeader.isDefaultClientIdLinkPresent(defaultClientID));
    }

    @When("^the user come back on to Home page$")
    public void userComeBackOnToHomePage() throws Throwable {
        navigationCobalt.waitForPageToLoad();
        if (!isHomePage()) {
            navigationCobalt.navigateToHomePage();
            navigationCobalt.waitForPageToLoad();
        }
    }

    public boolean isHomePage() {
        if (!(categoryPage.getCurrentUrl().contains("/Search/Home.html")
                || categoryPage.getCurrentUrl().contains("/Search/BrowseRoot.html") || categoryPage.getCurrentUrl()
                .contains("Home/Home"))) {
            return false;
        }
        return true;
    }
//    @When("^the user opens \"([^\"]*)\" link$")
//    public void openLinkFromList(String linkName) throws Throwable {
//        categoryPage.openPageByText(linkName);
//    }


    @When("^the user opens '(.+)' link$")
    public void openLink(String linkName) throws Throwable {
        categoryPage.openPageByText(linkName);
    }

    @When("^the user opens \"([^\"]*)\" link$")
    public void openLinkFromList(String linkName) throws Throwable {
        categoryPage.openPageByText(linkName);
    }

    @When("^he is viewing a free document \"(.*?)\"$")
    public void heIsViewingAFreeDocument(String documentURL) throws Throwable {
        navigationCobalt.navigateToPLCUKPlusSpecificURL(documentURL);
        navigationCobalt.waitForPageToLoad();
    }

    @Then("^he does not see in the document page Add To Folder link$")
    public void heDoesNotSeeInTheDocumentPageAddToFolderLink() throws Throwable {
        assertFalse("Add to Folder is visible", documentDeliveryPage.isAddToFolderLinkPresent());
    }

    @Then("^he does not see in the document page any link related to annotations$")
    public void heDoesNotSeeInTheDocumentPageAnyLinkRelatedToAnnotations() throws Throwable {
        assertFalse("User is able to use Add to Folder", annotationPage.isAnnotationWidgetsPresent() & annotationPage.isAnnotationIconsPresent());
    }

    @Then("^he is not able to use annotations$")
    public void heIsNotAbleToUseAnnotations() throws Throwable {
        annotationPage.makeTextSelectionToOpenCreateAnnotationLightBox(By.xpath("//h1[contains(@class,'co_title')]"), By.xpath("//div[@class='co_productname']"));
        assertFalse(annotationPage.isCreateAnnotationsWidgetPresent());
    }
    @When("^the user navigates to the main PLCUK page$")
    public void theUserNavigatesToTheMainPLCUKPage() throws Throwable {
        navigationCobalt.navigateToPLUKPlus();
        navigationCobalt.waitForPageToLoad();
    }

    @When("^he does a search \"(.*?)\"$")
    public void heDoesASearch(String searchText) throws Throwable {
        searchHomePage.enterSearchText(searchText);
        searchHomePage.searchButton().click();
        searchHomePage.waitForPageToLoad();
    }

    @Then("^he does not see in the search results page any link related to FFH$")
    public void heDoesNotSeeInTheSearchResultsPageAnyLinkRelatedToFFH(List<String> ffhLinks) throws Throwable {
        checkIfLinksVisible(ffhLinks);
    }

    private void checkIfLinksVisible(List<String> ffhLinks) {
        int result = 0;
        for (String ffhLink : ffhLinks) {
            if (commonMethods.getElementByLinkText(ffhLink) != null) {
                LOG.info(ffhLink + " link is visvible for user");
                result++;
            }
        }
        assertTrue("FFH is visvible for user", result == 0);
    }

    @When("^he looks at the header , no matter which page he is at$")
    public void heLooksAtTheHeaderNoMatterWhichPageHeIsAt() throws Throwable {
        assertTrue("Header is not visible", wlnHeader.header().isDisplayed());
    }

    @Then("^he does not see in the header any link related to FFH$")
    public void heDoesNotSeeInTheHeaderAnyLinkRelatedToFFH() throws Throwable {
        int result = 0;
        if (wlnHeader.isFavoritesLinkPresent()) {
            result++;
        }
        if (wlnHeader.isFoldersLinkPresent()) {
            result++;
        }
        if (wlnHeader.isHistoryLinkPresent()) {
            result++;
        }
        assertTrue("FFH is visible for user", result == 0);
    }

    @Then("^he does not see in the document page any link related to FFH$")
    public void heDoesNotSeeInTheDocumentPageAnyLinkRelatedToFFH(List<String> ffhLinks) throws Throwable {
        checkIfLinksVisible(ffhLinks);
    }

    @When("^the user opens (.+) url on plcuk website$")
    public void theUserOpensUrlOnPLCUKSite(String url) throws Throwable {
        navigationCobalt.navigateToPLCUKPlusSpecificURL(url);
        navigationCobalt.waitForPageToLoadAndJQueryProcessingWithCustomTimeOut(90);
    }

    @When("^the user navigates to the email preference page$")
    public void theUserNavigatesToTheEmailPreferencePage() throws Throwable {
        wlnHeader.openEmailPreferences();
        subscriptionPreferencePage.waitForPageToLoadAndJQueryProcessingWithCustomTimeOut(90);
    }
}

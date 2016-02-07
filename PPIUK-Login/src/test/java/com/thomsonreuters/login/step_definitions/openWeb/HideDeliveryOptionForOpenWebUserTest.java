package com.thomsonreuters.login.step_definitions.openWeb;

import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.login.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesResultsPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.DocumentDeliveryOptionsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchHomePage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.assertFalse;

public class HideDeliveryOptionForOpenWebUserTest extends BaseStepDef {

    private DocumentDeliveryOptionsPage documentDeliveryOptionsPage = new DocumentDeliveryOptionsPage();
    private SearchHomePage searchHomePage = new SearchHomePage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private LegalUpdatesResultsPage legalUpdatesResultsPage = new LegalUpdatesResultsPage();

    @Then("^he does not see in the document page any link related to delivery options \\(email, download, print\\)$")
    public void heDoesNotSeeInTheDocumentPageAnyLinkRelatedToDeliveryOptionsEmailDownloadPrint() throws Throwable {
        assertFalse("Delivery options are visible for user", documentDeliveryOptionsPage.isDownloadPresent() & documentDeliveryOptionsPage.isPrintPresent() & documentDeliveryOptionsPage.isEmailPresent());
    }

    @Then("^he is not able to use these features on document page$")
    public void heIsNotAbleToUseTheseFeaturesOnDocumentPage() throws Throwable {
        try {
            documentDeliveryOptionsPage.download().click();
            Assert.fail("User is able to click on download");
        }
        catch (PageOperationException poe) {
        }

        try {
            documentDeliveryOptionsPage.print().click();
            Assert.fail("User is able to click on print");
        }
        catch (PageOperationException poe) {
        }

        try {
            documentDeliveryOptionsPage.email().click();
            Assert.fail("User is able to click on email");
        }
        catch (PageOperationException poe) {
        }
    }

    @When("^he does a search \"(.*?)\"$")
    public void heDoesASearch(String searchText) throws Throwable {
        searchHomePage.enterSearchText(searchText);
        searchHomePage.searchButton().click();
        searchHomePage.waitForPageToLoad();
    }

    @Then("^he does not see in the search results page any link related to delivery options \\(email, download, print\\)$")
    public void heDoesNotSeeInTheSearchResultsPageAnyLinkRelatedToDeliveryOptionsEmailDownloadPrint() throws Throwable {
        assertFalse("Delivery options are visible for user", searchResultsPage.isDeliveryDropButtonPresent() & searchResultsPage.isDownloadDeliveryOptionPresent() & searchResultsPage.isPrintDeliveryOptionPresent() & searchResultsPage.isEmailDeliveryOptionPresent());
    }

    @Then("^he is not able to use these features on search page$")
    public void heIsNotAbleToUseTheseFeaturesOnSearchPage() throws Throwable {
        boolean isUserAbleToUseDeliveryOptions = true;
        try {
            searchResultsPage.deliveryDropButton().click();
        } catch (PageOperationException poe) {
            isUserAbleToUseDeliveryOptions = false;
        }
        assertFalse("User is not able to use delivery options", isUserAbleToUseDeliveryOptions);
    }

    @Given("^a user is on a legal updates results page \"(.*?)\"$")
    public void aUserIsOnALegalUpdatesResultsPage(String legalUpdatesResultsPageUrl) throws Throwable {
        navigationCobalt.navigateToPLCUKPlusSpecificURL(legalUpdatesResultsPageUrl);
        navigationCobalt.waitForPageToLoad();
    }

    @Then("^he does not see on a legal updates results page any link related to delivery options \\(email, download, print\\)$")
    public void heDoesNotSeeOnALegalUpdatesResultsPageAnyLinkRelatedToDeliveryOptionsEmailDownloadPrint() throws Throwable {
        assertFalse("Delivery options are visible for user", legalUpdatesResultsPage.isDeliveryMethodLinkPresent() & searchResultsPage.isDownloadDeliveryOptionPresent() & searchResultsPage.isPrintDeliveryOptionPresent() & searchResultsPage.isEmailDeliveryOptionPresent());
    }

    @Then("^he is not able to use these features on legal updates results page$")
    public void heIsNotAbleToUseTheseFeaturesOnLegalUpdatesResultsPage() throws Throwable {
        boolean isUserAbleToUseDeliveryOptions = true;
        try {
            legalUpdatesResultsPage.deliveryMethodLink().click();
        } catch (PageOperationException poe) {
            isUserAbleToUseDeliveryOptions = false;
        }
        assertFalse("User is not able to use delivery options", isUserAbleToUseDeliveryOptions);
    }

}

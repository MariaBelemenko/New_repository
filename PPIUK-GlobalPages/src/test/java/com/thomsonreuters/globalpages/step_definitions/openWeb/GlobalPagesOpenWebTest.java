package com.thomsonreuters.globalpages.step_definitions.openWeb;

import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.globalpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesResultsPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.DocumentDeliveryOptionsPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GlobalPagesOpenWebTest extends BaseStepDef {

    private DocumentDeliveryOptionsPage documentDeliveryOptionsPage = new DocumentDeliveryOptionsPage();
    private LegalUpdatesResultsPage legalUpdatesResultsPage = new LegalUpdatesResultsPage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private CommonMethods comMethods = new CommonMethods();
    private WLNHeader header = new WLNHeader();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();

    @Then("^he does not see in the document page any link related to delivery options \\(email, download, print\\)$")
    public void heDoesNotSeeInTheDocumentPageAnyLinkRelatedToDeliveryOptionsEmailDownloadPrint() throws Throwable {
        assertFalse("Delivery options are visible for user", documentDeliveryOptionsPage.isDownloadPresent() & documentDeliveryOptionsPage.isPrintPresent() & documentDeliveryOptionsPage.isEmailPresent());
    }

    @Then("^he is not able to use these features on document page$")
    public void heIsNotAbleToUseTheseFeaturesOnDocumentPage() throws Throwable {
        try {
            documentDeliveryOptionsPage.download().click();
            Assert.fail("User is able to click on download");
        } catch (PageOperationException poe) {
        }
        try {
            documentDeliveryOptionsPage.print().click();
            Assert.fail("User is able to click on print");
        } catch (PageOperationException poe) {
        }
        try {
            documentDeliveryOptionsPage.email().click();
            Assert.fail("User is able to click on email");
        } catch (PageOperationException poe) {
        }
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

    @Then("^user hovers over the country toggle dropdown$")
    public void userHoversOverTheCountryTogglePage() throws Throwable {
        comMethods.mouseOver(header.countryToggleDropdownLink());
    }

    @Then("^the user selects \"(.*?)\"$")
    public void theUserSelects(String countryName) throws Throwable {
        header.countryLink(countryName).click();
        navigationCobalt.waitForPageToLoad();
    }

    @Then("there will be text informing the user to login to view full text document")
    public void thereWillBeTextInformingToLogin() {
        String documentBody = standardDocumentPage.getFullDocumentBody().getText();
        String message = "To access this resource, log in below or register for free access";
        assertTrue("Document '" + comMethods.firstHundredChars(documentBody) + "' does not contain expected text",
                documentBody.contains(message));
    }

    @Then("\"(.*?)\" button is present in document body")
    public void buttonIsPresentInDocumentBody(String title) {
        WebElement document = standardDocumentPage.getFullDocumentBody();
        try {
            document.findElement(By.xpath(".//a[contains(text(),'" + title + "')]"));
        } catch (NoSuchElementException e) {
            Assert.fail("Button with text '" + title + "' is not present in document");
        }
    }

}

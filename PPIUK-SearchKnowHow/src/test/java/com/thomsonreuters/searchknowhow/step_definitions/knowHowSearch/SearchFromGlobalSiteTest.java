package com.thomsonreuters.searchknowhow.step_definitions.knowHowSearch;

import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawHomepage;
import com.thomsonreuters.pageobjects.pages.landingPage.UKPLCSitePage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowDocumentPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.searchknowhow.step_definitions.BaseStepDef;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class SearchFromGlobalSiteTest extends BaseStepDef {

    private PracticalLawHomepage practicalLawHomepage = new PracticalLawHomepage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private UKPLCSitePage ukplcSitePage = new UKPLCSitePage();
    private KnowHowDocumentPage knowHowDocumentPage = new KnowHowDocumentPage();

    private String westlawNextWindow;
    private String plcLegacyWindow = null;

    @And("^has selected the link to United Kingdom$")
    public void hasSelectedTheLinkToUnitedKingdom() throws Throwable {
        practicalLawHomepage.unitedKingdomContentLink().click();
    }

    @And("^the user opens the link associated with the result \"([^\"]*)\" which opens via the PLC UK site$")
    public void userOpensAssociatedPLCLink(String result) throws Throwable {
        westlawNextWindow = searchResultsPage.getWindowHandle();
        plcLegacyWindow = null;
        searchResultsPage.plcRefIdForNthSearchResult(Integer.parseInt(result)).click();
        switchToPLCLegacyWindow();
        if (null == plcLegacyWindow) {
            throw new UnknownError("new PLC Window did not open");
        }
    }

    @And("^opens the link entitled Resource details$")
    public void opensTheLinkEntitledResourceDetails() throws Throwable {
        ukplcSitePage.showResourceDetailsLink().click();
    }

    @Then("^it is clear to the user that results are restricted to Global content because the product details contain at least one of the following categories$")
    public void itIsClearToTheUserThatResultsAreRestrictedToGlobalContentBecauseTheProductDetailsContainAtLeastOneOfTheFollowingCategories() throws Throwable {
        WebElement products = knowHowDocumentPage.productCodeSection();
        assertTrue((products.getText().contains("PLC UK Magazine (UK)")) || (products.getText().contains("PLC Arbitration")) || (products.getText().contains("PLC Arbitration - International"))
                || (products.getText().contains("PLC Business Development")) || (products.getText().contains("PLC UK Commercial)")) || (products.getText().contains("PLC EU Competition Law)"))
                || (products.getText().contains("PLC UK Competition Law")) || (products.getText().contains("PLC UK Construction")) || (products.getText().contains("PLC UK Corporate"))
                || (products.getText().contains("PLC Cross-border")) || (products.getText().contains("PLC UK Dispute Resolution")) || (products.getText().contains("PLC UK Employment"))
                || (products.getText().contains("PLC UK Environment")) || (products.getText().contains("PLC EU")) || (products.getText().contains("PLC UK Finance"))
                || (products.getText().contains("PLC UK Financial Services"))
                || (products.getText().contains("PLC Glossary")) || (products.getText().contains("IP&IT")) || (products.getText().contains("PLC UK Law Department"))
                || (products.getText().contains("PLC Law Firm Publications"))
                || (products.getText().contains("PLC Lawdepartment Global")) || (products.getText().contains("PLC multi-jurisdictional guides")) || (products.getText().contains("PLC UK Pensions"))
                || (products.getText().contains("PLC UK Private Client")) || (products.getText().contains("PLC UK Property")) || (products.getText().contains("PLC UK Public Sector"))
                || (products.getText().contains("PLC UK Restructuring and Insolvency")) || (products.getText().contains("PLC UK Share Schemes & Incentives"))
                || (products.getText().contains("PLC UK Tax")) || (products.getText().contains("PLC US Antitrust")) || (products.getText().contains("PLC US Bankruptcy")) || (products.getText().contains("PLC US Capital Markets & Securities"))
                || (products.getText().contains("PLC US Commercial")) || (products.getText().contains("PLC US Corporate and M&A")) || (products.getText().contains("PLC US Corporate & Securities"))
                || (products.getText().contains("PLC US Corporate & Securities")) || (products.getText().contains("PLC US Employee Benefits & Executive Compensation"))
                || (products.getText().contains("PLC US Environmental")) || (products.getText().contains("PLC US Federal Litigation")) || (products.getText().contains("PLC US Finance"))
                || (products.getText().contains("PLC US Glossary")) || (products.getText().contains("PLC US Intellectual Property & Technology"))
                || (products.getText().contains("PLC US Labor & Employment")) || (products.getText().contains("PLC US Law Department"))
                || (products.getText().contains("PLC US Real Estate")) || (products.getText().contains("PLC US Tax"))
                || (products.getText().contains("Practical Law The Journal (US)")) || (products.getText().contains("PLC Arbitration - International"))
                || (products.getText().contains("PLC Arbitration - England and Wales")) || (products.getText().contains("PLC US Litigation - New York"))
                || (products.getText().contains("China")) || (products.getText().contains("PLC Cross-border")) || (products.getText().contains("Commercial: International")));
    }

    @When("^as a user I want to switch to the WestLawNext window$")
    public void asAUserIWantToSwitchToTheWindowWithTheTitle() throws Throwable {
        searchResultsPage.switchToWindow(westlawNextWindow);
    }

    private void switchToPLCLegacyWindow() throws InterruptedException {
        int windowCount = 0;
        int counter = 20;
        do {
            windowCount = searchResultsPage.getWindowHandles().size();
            Thread.sleep(500);
            counter--;
        }
        while (windowCount < 2 && counter > 0);
        for (String handle : searchResultsPage.getWindowHandles()) {
            if (!handle.equalsIgnoreCase(westlawNextWindow)) {
                plcLegacyWindow = handle;
                searchResultsPage.switchToWindow(handle);
            }
        }
    }

}

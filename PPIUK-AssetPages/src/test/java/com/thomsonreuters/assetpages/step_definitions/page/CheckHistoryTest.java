package com.thomsonreuters.assetpages.step_definitions.page;

import com.thomsonreuters.assetpages.step_definitions.BaseStepDef;
import com.thomsonreuters.assetpages.step_definitions.CommonLoginNaviagtionSteps;
import com.thomsonreuters.pageobjects.pages.folders.HistoryTabs;
import com.thomsonreuters.pageobjects.pages.folders.ResearchOrganizerPage;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.PrimarySourceDocumentPage;
import com.thomsonreuters.pageobjects.rest.FolderBaseUtils;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class CheckHistoryTest extends BaseStepDef {

    private FolderBaseUtils restSteps = new FolderBaseUtils();
    private CommonLoginNaviagtionSteps commonLoginNaviagtionSteps = new CommonLoginNaviagtionSteps();
    private AssetPageUtils assetPageUtils = new AssetPageUtils();
    private PrimarySourceDocumentPage primarySourceDocumentPage = new PrimarySourceDocumentPage();
    private ResearchOrganizerPage researchOrganizerPage = new ResearchOrganizerPage();
    private WLNHeader header = new WLNHeader();

    private String titleOfPrimarySourceDocument;
    private String knowHowDocumentTitle;

    @When("^API cleans all folders and history and user relogs in$")
    public void apiCleansAllFoldersAndHistoryAndUserRelogsIn() throws Throwable {
        restSteps.doSuperDelete();
        commonLoginNaviagtionSteps.userRelogsIn();
    }

    @Then("^the user store title and URL of primary source document$")
    public void theUserStoreTitleAndURLOfPrimarySourceDocument() throws Throwable {
        titleOfPrimarySourceDocument = primarySourceDocumentPage.getPageTitle();
    }

    @Then("^the user store title and URL of now how document$")
    public void theUserStoreTitleAndURLOfNowHowDocument() throws Throwable {
        knowHowDocumentTitle = primarySourceDocumentPage.getPageTitle();
    }

    @Then("^the '(\\d+)' link contains the document title and href of know how document$")
    public void theLinkContainsTheDocumentTitleAndHrefOfKnowHowDocument(int position) throws Throwable {
        primarySourceDocumentPage.waitForPageToLoad();
        assertTrue("The link doesn't contains the document title and href of ",
                assetPageUtils.isTheLinkContainsTheDocumentTitleAndHref(position, knowHowDocumentTitle));
    }

    @Then("^the '(\\d+)' link contains the document title and href of primary source document$")
    public void theLinkContainsTheDocumentTitleAndHrefOfPrimarySourceDocument(int position) throws Throwable {
        primarySourceDocumentPage.waitForPageToLoad();
        assertTrue("The link doesn't contains the document title and href of ",
                assetPageUtils.isTheLinkContainsTheDocumentTitleAndHref(position, titleOfPrimarySourceDocument));
    }

    @When("^the user clicks on '(.+)' link on the header$")
    public void theUserClicksOnLinkOnTheHeader(String linkName) throws Throwable {
        researchOrganizerPage.waitForPageToLoad();
        switch (linkName) {
            case "Folders":
                header.foldersLink().click();
                break;
            case "History":
                header.historyLink().click();
                break;
            case "Favourites":
                header.favouritesLink().click();
                break;
            default:
        }
        researchOrganizerPage.waitForPageToLoad();
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
    }

    @When("^the user clicks on '(.+)' tab on the History page$")
    public void theUserClicksOnTabOnHistoryPage(String tabName) throws Throwable {
        HistoryTabs tab = HistoryTabs.valueOf(tabName);
        openHistoryTab(tab);
    }

    protected void openHistoryTab(HistoryTabs tab) {
        researchOrganizerPage.waitForPageToLoad();
        researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
        WebElement historyTabNonClicked = researchOrganizerPage.findElement(tab.getId());
        WebElement historyTabClicked = researchOrganizerPage.findElement(tab.getIdClickable());
        if (historyTabNonClicked.isDisplayed()) {
            historyTabNonClicked.click();
            researchOrganizerPage.waitForPageToLoadAndJQueryProcessing();
        }
        if (historyTabClicked.isDisplayed()) {
            researchOrganizerPage.waitForElementPresent(tab.getPageHeader());
        } else {
            throw new RuntimeException("History tab '" + tab.getName() + "' absent!");
        }
    }

}

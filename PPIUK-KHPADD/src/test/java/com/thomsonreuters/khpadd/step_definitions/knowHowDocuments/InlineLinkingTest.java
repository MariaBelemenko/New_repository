package com.thomsonreuters.khpadd.step_definitions.knowHowDocuments;

import com.thomsonreuters.khpadd.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.DocumentRightPanelPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import com.thomsonreuters.pageobjects.pages.search.SearchHomePage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertTrue;

public class InlineLinkingTest extends BaseStepDef {

    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private DocumentRightPanelPage rightPanelPage = new DocumentRightPanelPage();
    private KHResourcePage resourcePage = new KHResourcePage();
    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();
    private CommonMethods comMethods = new CommonMethods();
    private HomePage homePage = new HomePage();
    private SearchHomePage searchHomePage = new SearchHomePage();

    private String jumpLinkSection;

    @When("^the user clicks on the first link in results$")
    public void theUserClicksOnTheFirstLinkInResults() throws Throwable {
        searchResultsPage.firstResultTitle().click();
        searchResultsPage.waitForPageToLoad();
    }

    @Then("^document title is displayed as \"(.*?)\"$")
    public void titleIsDisplayedAs(String title) throws Throwable {
        assertThat(resourcePage.title().getText().trim().replaceAll("\\n", " "), Is.is(title.replaceAll("\\\\n", " ")));
    }

    @Then("^resource type is displayed as \"(.*?)\" on right hand panel$")
    public void documentTypeIsDisplayedAsArticles(String documentType) throws Throwable {
        rightPanelPage.waitForPageToLoad();
        assertThat(rightPanelPage.resourceTypeText().getText().trim(), Is.is(documentType));
    }

    @When("^the user clicks on '(.*)' link in table of contents$")
    public void theUserClicksOnLinkSectionLinkInTableOfContents(String linkName) throws Throwable {
        jumpLinkSection = linkName;
        standardDocumentPage.getLinkInTableOfContents(linkName).click();
    }

    @Then("^it should take user to the corresponding link$")
    public void checkThatUsersSeeCorrespondedSectionFromResourceHistory() throws Throwable {
        assertTrue("User was not scrolled to corresponding section from Jump Link '" + jumpLinkSection + "'",
                standardDocumentPage.isDocumentSectionDisplayed(jumpLinkSection));
    }

    @When("^the user clicks on '(.*)' link in '(.*)' section of the document$")
    public void theUserClicksOnPracticeNoteLinLinkInSectionLinkSectionOfTheDocument(String linkName, String sectionName) {
        WebElement sectionLinkElement = standardDocumentPage.getLinkFromSection(sectionName, linkName);
        if (standardDocumentPage.getClass().equals(ChromeDriver.class)) {
            comMethods.clickElementUsingJS(sectionLinkElement);
        } else {
            sectionLinkElement.click();
        }
        standardDocumentPage.waitForPageToLoad();
    }

    @Then("^scrolled heading \"(.*?)\" is displayed on the sticky bar$")
    public void scrolledHeadingIsDisplayedOnTheStickyBar(String expectedHeading) throws Throwable {
        assertThat(resourcePage.subSectionHeadingOnStickyBar().getText().trim(), Is.is(expectedHeading));
    }

    @When("^the user clicks Back button in browser '(.*)' times$")
    public void goBackNTimesAndWaitForPageToLoad(int howMuch) throws Throwable {
        resourcePage.browserBackMulti(howMuch);
        homePage.waitForPageToLoad();
    }

    @When("^the user searches for \"(.*?)\"$")
    public void searchFor(String searchQuery) throws Throwable {
        searchHomePage.enterSearchText(searchQuery);
        searchHomePage.searchButton().click();
        searchHomePage.waitForPageToLoad();
        searchHomePage.waitForPageToLoadAndJQueryProcessing();
    }

    @When("^the user clicks on result with title \"(.*?)\"$")
    public void openDocWithResultTitle(String title) throws Throwable {
        searchResultsPage.getResultItemByTitle(title).click();
        searchResultsPage.waitForPageToLoad();
    }

    @When("^the user clicks on any link with text '(.*)'$")
    public void clickAnyLink(String linkText) throws Throwable {
        homePage.getElementByLinkText(linkText).click();
        homePage.waitForPageToLoad();
    }

    @Then("^new Tab/Windows is displayed")
    public void newWindowIsDisplayed() throws Throwable {
        int windowsCount;
        int counter = 10;
        do {
            windowsCount = getDriver().getWindowHandles().size();
            counter--;
            Thread.sleep(2000);
        }
        while (windowsCount < 2 && counter > 0);
        assertThat("The no of popupWindows opened is less than 2", getDriver().getWindowHandles().size(), greaterThanOrEqualTo(2));
    }

}

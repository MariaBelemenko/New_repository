package com.thomsonreuters.frontend.step_definitions.khPadd;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawUKCategoryPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.DraftingNotes;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import static org.junit.Assert.assertTrue;

public class DocPgStylingStoriesTest {

    private PracticalLawUKCategoryPage practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();
    private PageActions pageActions = new PageActions();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private KHResourcePage khResourcePage = new KHResourcePage();
    private CommonMethods comMethods = new CommonMethods();

    int draftingNotesCount = 0;
    public int notesIcons;

    @When("^the user runs a free text search for the query \"(.*)\"$")
    public void theUserRunsAFreeTextSearchForTheQuery(String query) throws Throwable {
        StringSelection stringSelection = new StringSelection(query);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        practicalLawUKCategoryPage.searchButton().isDisplayed();
        practicalLawUKCategoryPage.freeTextField().clear();

        if (query.contains("(") || query.contains(")") || query.contains("&")) {
            clpbrd.setContents(stringSelection, null);
            practicalLawUKCategoryPage.freeTextField().sendKeys(Keys.CONTROL + "v");
        } else {
            practicalLawUKCategoryPage.freeTextField().sendKeys(query);
        }

        if (practicalLawUKCategoryPage.getClass().equals(ChromeDriver.class)) {
            pageActions.keyPress(Keys.ENTER);
        } else {
            practicalLawUKCategoryPage.searchButton().click();
        }
        userVerifiesThatTheResultsListPageIsDisplayed();
    }

    @Then("^user should see the Standard Document with drafting icon on the Delivery toolbar$")
    public void UserShouldSeeTheStandardDocumentWithDraftingIconOnTheDeliveryToolbar() throws Throwable {
        assertTrue("Related Content section not displayed..!", khResourcePage.draftingNotesDeliveryIcon().isDisplayed());
        draftingNotesCount = khResourcePage.collapsedDraftingNotesList().size();
    }

    @And("^clicks on the Show/Hide Drafting Notes option on the delivery toolbar$")
    public void clicksOnTheShowHideDraftingNotesOptionOnTheDeliveryToolbar() throws Throwable {
        khResourcePage.selectShowAndHideDraftingNotesLink();
    }

    @When("^user clicks on the 'Show All' option$")
    public void userClicksOnTheShowAllOption() throws Throwable {
        notesIcons = khResourcePage.getNotesIconsCount();
        khResourcePage.selectOptionFromDraftingNotes(DraftingNotes.SHOW_ALL);
    }

    @Then("^user should see all the drafting notes in the document expanded$")
    public void userShouldSeeAllTheDraftingNotesInTheDocumentExpanded() throws Throwable {
        int expandedDraftingNotesCount = khResourcePage.expandedDraftingNotesList().size();
        assertTrue("All the drafting notes not expanded..!", draftingNotesCount == expandedDraftingNotesCount);
    }

    @Then("^user clicks to close the drafting note with title \"(.*)\"$")
    public void userClicksToCloseTheFirstExpandedDraftingNotes(String title) throws Throwable {
        khResourcePage.draftingNoteCloseIconByTitle(title).click();
    }

    @Then("^user should see the drafting note with title \"(.*)\" collapsed$")
    public void userShouldSeeTheDraftingNoteWithTitleCollapsed(String title) throws Throwable {
        assertTrue("Drafting Note " + title + " not collapsed..!", khResourcePage.collapsedDraftingNoteTitle(title).isDisplayed());
    }

    @When("^user clicks on the 'Hide All' option$")
    public void userClicksOnTheHideAllOption() throws Throwable {
        khResourcePage.selectOptionFromDraftingNotes(DraftingNotes.HIDE_ALL);
    }

    @Then("^user should see all the drafting notes in the document collapsed$")
    public void userShouldSeeAllTheDraftingNotesInTheDocumentCollapsed() throws Throwable {
        int collapsedDraftingNotesCount = khResourcePage.collapsedDraftingNotesList().size();
        assertTrue("All the documents not collapsed..!", collapsedDraftingNotesCount == draftingNotesCount);
    }

    @Then("^the following drafting notes options are displayed$")
    public void theFollowingDraftingNotesOptionsAreDisplayed(java.util.List<String> options) throws Throwable {
        java.util.List<String> actualOptions = khResourcePage.getNotesOptions();
        assertTrue(actualOptions.size() == 3);
        for (String expectedOption : options) {
            assertTrue(actualOptions.contains(expectedOption));
        }
    }

    @Then("^user should see the tick with \"(.*)\" option$")
    public void userShouldSeeAllTheDraftingNotesInTheDocumentCollapsed(String option) throws Throwable {
        assertTrue(option + " not selected..!", khResourcePage.showHidePopupSelectedOption().getText().trim().equalsIgnoreCase(option));
    }

    @Then("^the user closes the ToC by clicking on cross button$")
    public void theUserClosesTheToCByClickingOnCrossButton() throws Throwable {
        Is.is(khResourcePage.tocHiddenTitle().isDisplayed());
        khResourcePage.tocCrossIcon().click();
    }

    @Then("^the user should see ToC hidden with menu toggle button on left side$")
    public void theUserShouldSeeToCHiddenWithMenuToggleButtonOnLeftSide() throws Throwable {
        assertTrue("Cross Icon displayed..!", comMethods.isElementDisplayed(khResourcePage.tocMenuTogglCollapsedButton()));
    }

    private void userVerifiesThatTheResultsListPageIsDisplayed() throws Throwable {
        Robot robot = new Robot();
        robot.delay(5000);
        try {
            searchResultsPage.resultsListHeader().isDisplayed();
            searchResultsPage.filterHeader().isDisplayed();
        } catch (Exception ignored) {
        }
    }

}

package com.thomsonreuters.khpadd.step_definitions.knowHowDocuments;

import static junit.framework.Assert.assertFalse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hamcrest.core.Is;

import com.thomsonreuters.driver.framework.AbstractPage;
import com.thomsonreuters.khpadd.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.DraftingNotes;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.PrimarySourceDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DraftingNotesTest extends BaseStepDef {

    private KHResourcePage resourcePage = new KHResourcePage();
    
    private PrimarySourceDocumentPage primarySourceDocumentPage = new PrimarySourceDocumentPage();
    
	private AssetPageUtils assetPageUtils = new AssetPageUtils();

    public int notesIcons;

    @Then("^user is able to expand the first drafting notes$")
    public void expandDraftingNotes() throws Throwable {
        resourcePage.firstCollapsedDraftingNotes().click();
    }

    @Then("^see the expanded drafting notes heading is \"(.*)\"$")
    public void expandAndCloseDraftingNotes(String expectedHeading) throws Throwable {
        assertThat(resourcePage.activeDraftingNoteHeading().getText().trim().toLowerCase(), Is.is(expectedHeading.toLowerCase()));
    }

    @Then("^user is able to close the first drafting notes$")
    public void closeDraftingNotes() throws Throwable {
        resourcePage.closeDraftingNote().click();
        assertThat(resourcePage.isThereAnyExpandedDraftingNote(), Is.is(false));
    }

    @And("^clicks on the Show/Hide Drafting Notes option on the delivery toolbar$")
    public void clicksOnTheShowHideDraftingNotesOptionOnTheDeliveryToolbar() throws Throwable {
        resourcePage.selectShowAndHideDraftingNotesLink();
    }

    @Then("^the following drafting notes options are displayed$")
    public void theFollowingDraftingNotesOptionsAreDisplayed(List<String> options) throws Throwable {
        List<String> actualOptions = resourcePage.getNotesOptions();
        assertTrue(actualOptions.size() == 3);
        for (String expectedOption : options) {
            assertTrue(actualOptions.contains(expectedOption));
        }
    }

    @When("^user clicks on the 'Show All' option$")
    public void userClicksOnTheShowAllOption() throws Throwable {
        notesIcons = resourcePage.getNotesIconsCount();
        resourcePage.selectOptionFromDraftingNotes(DraftingNotes.SHOW_ALL);
    }

    @Then("^the document text along with the drafting notes expanded version is displayed$")
    public void theDocumentTextAlongWithTheDraftingNotesExpandedVersionIsDisplayed() throws Throwable {
        int notesCount = resourcePage.getDisplayedNotesCount();
        assertTrue(notesIcons == notesCount);
    }

    @When("^user clicks on the 'Hide All' option$")
    public void userClicksOnTheHideAllOption() throws Throwable {
        resourcePage.selectOptionFromDraftingNotes(DraftingNotes.HIDE_ALL);
    }

    @Then("^the document text along with drafting notes collapsed version is displayed$")
    public void theDocumentTextAlongWithDraftingNotesCollapsedVersionIsDisplayed() throws Throwable {
        assertTrue(resourcePage.getDisplayedNotesCount() == 0);
    }

    @When("^user clicks on the 'Show Notes Only' option$")
    public void userClicksOnTheShowNotesOnlyOption() throws Throwable {
        notesIcons = resourcePage.getNotesIconsCount();
        resourcePage.selectOptionFromDraftingNotes(DraftingNotes.SHOW_NOTES_ONLY);
    }

    @Then("^only the drafting notes expanded version is displayed$")
    public void onlyTheDraftingNotesExpandedVersionIsDisplayed() throws Throwable {
        int notesCount = resourcePage.getDisplayedNotesCount();
        assertTrue(notesCount > 0);
        assertTrue(notesIcons == notesCount);
        assertFalse(resourcePage.isContentParagraphsDisplayed());
    }
    
    @Then("^the source document with guid \"(.*?)\" remains open and new tab opens$")
	public void theSourceDocumentRemainsOpen(String guid) throws Throwable {	
		assertTrue("The source document doesn't remain open", assetPageUtils.isTheSourceDocumentRemainsOpen(guid));
	}
    
    @Then("^the user is taken to \"(.*?)\" resource$")
	public void theUserIsTakenToResource(String linkText) throws Throwable {
		primarySourceDocumentPage.waitForPageToLoad();
		assetPageUtils.getBaseParameters();
		assertTrue("The user doesn't taken to the selected resource",
				assetPageUtils.isTheUserTakenToTheSelectedResource(linkText));
	}
    
    @And("^user opens link \"(.*)\" in new tab$")
    public void openLinkInNewTab(String linktext) throws Throwable {
    	resourcePage.openLinkInNewTab(linktext);
        resourcePage.switchToOpenedWindow();
        resourcePage.waitForPageToLoadAndJQueryProcessing();
    }
    
    @Then("^user verifies if page is scrolled to drafting notes with title \"(.*)\"$")
    public void pageScrolledToDN(String text) throws Throwable {
    	assertTrue("The drafting note is not opened", resourcePage.isElementDisplayed(resourcePage.expandedDraftingNoteTitle(text)));
    	assertTrue("Page is not scrolled to target drafting note", resourcePage.isViewScrolledToElement(resourcePage.expandedDraftingNoteTitle(text)));
    }

    
    @Then("^user closes opened window$")
    public void userClosesOpenedWindow() throws Throwable {
    	resourcePage.close();
    	resourcePage.switchToMainWindow();
    }
    
    @Then("^user scrolls and clicks on link \"(.*)\"$")
    public void scrollAndClick(String link) throws Throwable {
    	resourcePage.scrollIntoViewAndClick(resourcePage.embeddedResourceLink(link));
    	resourcePage.waitForPageToLoad();
    }
    
    @When("^the user clicks Back button in browser$")
    public void goBackAndWaitForPageToLoad() {
    	AbstractPage.getDriver.navigate().back();
    	resourcePage.waitForPageToLoad();
    }
    
    @Then("^user verifies if page is scrolled to link \"(.*)\"$")
    public void pageScrolledToText(String link) throws Throwable {
    	assertTrue("Page is not scrolled to target text", resourcePage.isViewScrolledToElement(resourcePage.embeddedResourceLink(link)));
    }
    

}

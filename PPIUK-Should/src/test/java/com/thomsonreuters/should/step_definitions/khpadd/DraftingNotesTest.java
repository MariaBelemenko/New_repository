package com.thomsonreuters.should.step_definitions.khpadd;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;

import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.DraftingNotes;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DraftingNotesTest {
	
    private KHResourcePage resourcePage = new KHResourcePage();
    public int notesIcons;
	
    @And("^clicks on the Show/Hide Drafting Notes option on the delivery toolbar$")
    public void clicksOnTheShowHideDraftingNotesOptionOnTheDeliveryToolbar() throws Throwable {
        resourcePage.selectShowAndHideDraftingNotesLink();
    }

    @When("^user clicks on the 'Show All' option$")
    public void userClicksOnTheShowAllOption() throws Throwable {
        notesIcons = resourcePage.getNotesIconsCount();
        resourcePage.selectOptionFromDraftingNotes(DraftingNotes.SHOW_ALL);
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
    
    @Then("^user verifies if page is scrolled to link \"(.*)\"$")
    public void pageScrolledToText(String link) throws Throwable {
    	assertTrue("Page is not scrolled to target text", resourcePage.isViewScrolledToElement(resourcePage.embeddedResourceLink(link)));
    }

    @Then("^user verifies if related content bar doesn't hide the target link \"(.*)\"$")
    public void relatedContentBarDoesNotHideLink(String anchor) throws Throwable {
    	assertTrue("Related Content bar hides the target link", 
    			resourcePage.compareElementsLocationByHeight(resourcePage.jumplink(anchor),resourcePage.stickyBar())==-1);
    }
    
    @Then("^user closes opened window$")
    public void userClosesOpenedWindow() throws Throwable {
    	resourcePage.close();
    	resourcePage.switchToMainWindow();
    }
    
    @Then("^user scrolls and clicks on link \"(.*)\"$")
    public void scrollAndClick(String link) throws Throwable {
    	resourcePage.scrollIntoViewAndClick(resourcePage.embeddedResourceLink(link));
   // 	Thread.sleep(2000);
    	resourcePage.waitForPageToLoad();
    }
    
    @When("^the user clicks Back button in browser$")
    public void goBackAndWaitForPageToLoad() {
    	resourcePage.getDriver.navigate().back();
    	resourcePage.waitForPageToLoad();
    }
}

package com.thomsonreuters.ffh.step_definitions.folder;


import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.thomsonreuters.driver.framework.AbstractPage;
import com.thomsonreuters.ffh.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.folders.FolderOptionsPage;
import com.thomsonreuters.pageobjects.pages.ask.AskSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.WhatsMarketSearchResultsPage;

import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DisabilityToDrugDocumentsToFolderTest extends BaseStepDef {

    private KnowHowSearchResultsPage khSearchResultsPage = new KnowHowSearchResultsPage();
    private WhatsMarketSearchResultsPage wmSearchResultsPage = new WhatsMarketSearchResultsPage();
    private WLNHeader wlnHeader = new WLNHeader();
    private FolderOptionsPage folderOptionsPage = new FolderOptionsPage();
    private AskSearchResultsPage askPage = new AskSearchResultsPage();
    private CommonMethods commonMethods = new CommonMethods();

  
    @When("^the user tries to drug \"(.+)\" result$")
    public void drugSearchResult(String result) throws Throwable {
    	drugAndMoveElement(khSearchResultsPage.knowHowSearchResultTitle(result));
    }
    
    @When("^the user tries to drug \"(.+)\" result in What's Market$")
    public void drugSearchResultWM(String result) throws Throwable {
    	drugAndMoveElement(wmSearchResultsPage.whatsMarketSearchResultTitle(result));
    }
    
    @When("^the user tries to drug \"(.+)\" result in Ask$")
    public void drugSearchResultAsk(int result) throws Throwable {
    	drugAndMoveElement(askPage.askQuestionLink(result));
    }
    
    private void drugAndMoveElement(WebElement element){
    	Actions builder = new Actions(commonMethods.getDriver());
    	builder.clickAndHold(element)
    	   .moveToElement(wlnHeader.foldersLink())
    	   .perform();
    }
    
    @Then("^there is no ability to drag document$")
    public void noAbilityToDrug() throws Throwable {
        Assert.assertFalse("Drad and drop box is present",folderOptionsPage.isElementPresent(folderOptionsPage.dragDropBoxElementLocator()));
        Assert.assertFalse("Additional 'Recent Folders' popup is present", folderOptionsPage.isElementDisplayed(folderOptionsPage.dropdownBoxRecentFoldersElement()));
    }
    
    @After(order = 10000, value = "@releaseButton")
    public void releseButton() throws Throwable {
    	Actions builder = new Actions(commonMethods.getDriver());
    	builder.release().perform();
    }



}

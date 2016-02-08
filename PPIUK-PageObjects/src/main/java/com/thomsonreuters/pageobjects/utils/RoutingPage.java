package com.thomsonreuters.pageobjects.utils;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoutingPage extends AbstractPage {

	private CommonMethods comObj;

	public RoutingPage() {
        comObj = new CommonMethods();
	}

	public WebElement showFeatureSelectionsLink() {
		return waitForExpectedElement(By.id("co_website_resourceInfoTypeLink"));
	}

	public WebElement practicalLawDropdown() {
		return waitForExpectedElement(By
				.id("co_website_resourceInfoTypes_PracticalLaw"));
	}

	public WebElement wlnByPass100KAncillaryDropdown() {
		return waitForExpectedElement(By
				.id("co_website_resourceInfoTypes_WLNByPass100KAncillary"));
	}

    public WebElement unreleasedCatPagesDropdown() {
		return waitForExpectedElement(By
				.id("co_website_resourceInfoTypes_UnreleasedCatPages"));
	}

	public WebElement preReleaseContentDropdown() {
		return waitForExpectedElement(By
				.id("co_website_resourceInfoTypes_PreReleaseContent"));
	}

	public WebElement ignoreAuthorizationBlocksDropdown() {
		return waitForElementVisible(findElement(By.id("co_website_resourceInfoTypes_IgnoreAuthorizationBlocks")),
				120);
	}

    public WebElement whatsMarketSearchResultsDropdown() {
        return waitForExpectedElement(By
                .id("co_website_resourceInfoTypes_WhatsMarketSearchResults"));
    }

	public WebElement askEditorDropdown() {
		return waitForExpectedElement(By
				.id("co_website_resourceInfoTypes_AskEditor"));
	}

	public WebElement firmStyleDropdown() {
		return waitForExpectedElement(By
				.id("co_website_resourceInfoTypes_FirmStyle"));
	}

	public WebElement socialPlatformDropdown() {
		return waitForExpectedElement(By
				.id("co_website_resourceInfoTypes_SocialPlatform"));
	}

	public WebElement isDataRoomRegionEnabledDropdown() {
		return waitForExpectedElement(By.id("DataRoomRegionEnabled"));
	}

	public WebElement skipAnonymousAuthenticationDropdown() {
		return waitForExpectedElement(By.id("SkipAnonymousAuthenticationKey"));
	}

	public WebElement anonymousRegistrationKeyTextBox() {
		return waitForExpectedElement(By.id("AnonymousRegistrationKey"));
	}

	public WebElement infrastructureAccessControls() {
		return waitForExpectedElement(By.id("InfrastructureAccessControls"));
	}

	public WebElement saveChangesAndSignOnButton() {
		return waitForExpectedElement(By.id("coid_website_routingSaveButton"));
	}

	public WebElement infrastructureAccessTextArea() {
		return waitForElementVisible(By.id("InfrastructureAccessControls"));
	}

	public WebElement showFeatureSelectionLink() {
		return waitForElementVisible(By.id("co_website_resourceInfoTypeLink"));
	}

	public WebElement advisorTrialsDropdown() {
		return waitForElementVisible(By
				.id("co_website_resourceInfoTypes_AdvisorTrials"));
	}

	public WebElement webContentCollectionSetDropdown() {
		return waitForElementVisible(By.id("WebContentCollectionSet"));
	}

	public WebElement useContentReleaseControl() {
		return waitForElementVisible(By.id("UseContentReleaseControl"));
	}
	
	public WebElement useContentReleaseControlFalse() {
		return waitForElementVisible(By.xpath(".//*[@id='UseContentReleaseControl']/option[2]"));
	}
	
	public void setPMdDataVersion(String str) {
		waitForElementVisible(By.id("ProductMetadataDataVersion"))
				.sendKeys(str);
	}

	public void setCategoryPageCollectionSet(String collection) {
		waitForElementVisible(By.id("CategoryPageCollectionSet")).sendKeys(
				collection);
	}

	public WebElement firmStyleHost() {
		return waitForElementVisible(By.id("FirmStyle"));
	}

	public WebElement fastDraftHost() {
		return waitForElementVisible(By.id("FastDraft"));
	}

    public void selectToggleSupportedFeatures(){
        waitForExpectedElement(By.id("co_website_SupportedFeatures_button")).click();
    }

    public void selectSharedNotesCheckBox() {
        WebElement checkbox = waitForExpectedElement(By.id("co_SupportedFeature_SharedNotes"));
        if(!checkbox.isSelected()){
            checkbox.click();
        }
    }
    
    public WebElement userInternal() {
		return waitForElementVisible(By.id("co_website_resourceInfoTypes_UserInternal"));
	}

    public boolean isBlockShareNoteLinkPresent(){
        try{
            showFeatureSelectionsLink().click();
            return getBlockShareNoteLink().isDisplayed();
        }catch(TimeoutException te){} return false;
    }

    private WebElement getBlockShareNoteLink() {
       return waitForExpectedElement(By.id("co_website_resourceInfoTypes_BlockShareNoteLink"));
    }

    private List<String> getDropDownOptions(WebElement element){
        Select s = new Select(element);
        List<String> allOptions = new ArrayList<String>();
        try{
            for(WebElement webElement : s.getOptions()){
                allOptions.add(webElement.getText());
            }
        }catch(Exception e){}
        return allOptions;
    }

    public List<String> getFACDropdownOptionValues(String facName){
        if(facName.equals("BlockShareNoteLink")){
            return getDropDownOptions(getBlockShareNoteLink());
        }
        return Collections.EMPTY_LIST;
    }

}

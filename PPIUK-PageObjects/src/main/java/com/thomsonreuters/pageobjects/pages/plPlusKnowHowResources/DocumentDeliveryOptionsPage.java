package com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DocumentDeliveryOptionsPage extends AbstractPage
{

    public WebElement email() {
        return retryingFindElement(By.id("deliveryLinkRowEmail"));
    }

    public WebElement print() {
        return retryingFindElement(By.id("deliveryLinkRowPrint"));
    }

    public WebElement download() {
        return retryingFindElement(By.id("deliveryLinkRowDownload"));
    }
    
    public WebElement quickDraft() {
        return retryingFindElement(By.id("deliveryLinkRowDownloadQuickDraft"));
    }

    public WebElement rss(){
        return retryingFindElement(By.id("co_docToolbarDeliveryWidgetRss"));
    }
    
	public boolean isEmailPresent() {
		try {
			return email().isDisplayed();
		} catch (Exception poe) {
			return false;
		}

	}
	
	public boolean isDownloadPresent() {
		try {
			return download().isDisplayed();
		} catch (Exception poe) {
			return false;
		}

	}
	
	public boolean isPrintPresent() {
		try {
			return print().isDisplayed();
		} catch (Exception poe) {
			return false;
		}
	}
}

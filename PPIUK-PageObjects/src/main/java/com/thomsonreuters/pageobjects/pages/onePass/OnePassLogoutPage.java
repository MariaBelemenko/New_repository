package com.thomsonreuters.pageobjects.pages.onePass;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class OnePassLogoutPage extends AbstractPage {
	
	public WebElement logOutBrandingLogo() {
        return retryingFindElement(By.id("co_logo"));
    }
    

    public WebElement sessionSummaryBox() {
        return waitForExpectedElement(By.className("co_signOff_sessionSummary"));
    }

	public WebElement sessionDetailsTable() {
		return waitForExpectedElement(By.xpath("//div[@id='coid_SessionActivityDetails']/table"));
	}
	
    public WebElement signOffPageSignOnButton() {
        return waitForElementToBeClickable(waitForExpectedElement(By.id("coid_website_signBackOnButton")));
    }
    
    public WebElement resumeAsCurrentUserLink() {
        return retryingFindElement(By.partialLinkText("Resume as"));
    }
    
    public String sessionSummary() {
        return (String) executeScript("return $('#coid_SessionActivitySummary').prev().html()");
    }

    public WebElement signInWithDifferentAccountLink() {
        return retryingFindElement(By.partialLinkText("Sign in with a different account"));
    }
}
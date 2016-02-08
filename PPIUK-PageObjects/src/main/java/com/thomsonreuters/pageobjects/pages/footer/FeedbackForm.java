package com.thomsonreuters.pageobjects.pages.footer;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class FeedbackForm extends AbstractPage {

	public WebElement label(String field) {
		return waitForExpectedElement(By.xpath("//label[starts-with(text(),'" + field + "')]"));
	}

	
	public WebElement submitButton() {
		return waitForExpectedElement(By.id("co_submitFeedbackButton"));
	}
	
	public WebElement closeButton() {
		return waitForExpectedElement(By.id("co_search_lightbox_closeButton"));
	}

    public void closeFeedBackForm() {
        waitForExpectedElement(By.id("co_search_lightbox_closeButton")).click();
    }
	
}

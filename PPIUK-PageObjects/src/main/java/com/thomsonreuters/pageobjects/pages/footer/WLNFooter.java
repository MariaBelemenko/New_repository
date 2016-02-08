package com.thomsonreuters.pageobjects.pages.footer;

import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;


import java.util.List;


public class WLNFooter extends AbstractPage {

    public WLNFooter() {
    }
    
    public WebElement signInLink() {
        return waitAndFindElement(By.linkText("Sign in"));
      }

    public WebElement footerWidget() {
        return waitForExpectedElement(By.id("footer-container"));
    }

	public WebElement requestTraining() {
        return waitForExpectedElement(By.xpath("//div[@id='footer-container']//a[text()='Request Training']"));
	}
	public WebElement userGuides() {
        return waitForExpectedElement(By.xpath("//div[@id='footer-container']//a[text()='User Guides']"));
	}
	
	public WebElement requestTrial() {
        return waitForExpectedElement(By.xpath("//div[@id='footer-request-trial']/button[text()='Request a Trial']"));
	}

    //----------------------------------Footer first row-----------------------
    public WebElement preferenceLink() {
        return waitForExpectedElement(By.id("coid_websiteFooter_userSettings"));
    }

    public WebElement myContactsLink() {
        return waitForExpectedElement(By.id("coid_websiteFooter_contacts"));
    }

    public WebElement gettingStartedLink() {
        return waitForExpectedElement(By.id("coid_website_quickStartGuide"));
    }

    public WebElement helpLink() {
        return waitForExpectedElement(By.id("coid_websiteFooter_helplink"));
    }

    public WebElement twitterArrowLink() {
        return waitForExpectedElement(By.id("twitter-arrow"));
    }
    public WebElement twitterPopup() {
        return waitForExpectedElement(By.xpath("//div[@id='twitter-links']//ul[@class='co_dropDownMenuList']"));
    }

    //-----------------------------Footer second/last row------------------------------
    public List<WebElement> footerFirstRowLinks() {

        return waitForElementsVisible(By.xpath("//footer[@id='co_footer']//ul[@class='footer-main co_inlineList co_buttonList']//a"));
    }

    public List<WebElement> footerSecondRowLinks() {

        return waitForElementsVisible(By.xpath("//footer[@id='co_footer']//ul[@class='footer-sub co_inlineList co_buttonList']//a"));
    }

    public List<WebElement> footerSecondRowLabels() {

        return waitForElementsVisible(By.xpath("//footer[@id='co_footer']//ul[@class='footer-sub co_inlineList co_buttonList']//li"));
    }

    public WebElement offersLink() {
        return waitForExpectedElement(By.xpath("//a[text()='Offers']"));
    }
    //----------------------------Object Video Window-----------------
    public WebElement getStartVideoObject() {
        return waitForExpectedElement(By.id("co_gettingStartedGuide"));
    }

    //---------------------------For Offer Page Message----------------
    public WebElement offerPageMessage() {
        return waitForExpectedElement(By.xpath("//div[@class='co_infoBox_message']//p[contains(text(),'You are not currently eligible')]"));
    }
    
    public boolean isSignInLinkPresent() {

		try {
			return signInLink().isDisplayed();
		} catch (TimeoutException | NoSuchElementException nse) {
			return false;
		}

	}
    public List<WebElement> footerByColumnLinks(String columnHeading) {
        return waitForExpectedElements(By.xpath("//div[@id='co_footer']//div[@class='co_column']//h3[text()='" + columnHeading + "']/..//li/a"));
    }

    //**   Thomson Reuters Career Page Title **
    public WebElement careerPageTitle() {
        return waitForExpectedElement(By.xpath("//span[@class='product-name']"));
    }

    //**   All the tab elements appearing on any Category Browse Page **
    public List<WebElement> pageTabLinks() {
        return waitForExpectedElements(By.xpath("//ul[@class='co_tabs co_categoryTabs']//h2//a"));
    }

	public void goToRequestTrialForm() {
		requestTrial().click();
		switchToOpenedWindow();
		waitForPageToLoad();	
	}
	
	public WebElement betaFeedbackLink() {
		return waitForExpectedElement(By.id("co_feedbackButton"));
	}

    public void clickOnFeedBackLink() {
        try{
            waitForExpectedElement(By.id("PracticalLawFeedbackLink")).click();
            waitForElementsVisible(By.id("co_feedback"));
        }catch(TimeoutException te){
            throw new PageOperationException("Exceeded time to find the FeedBack button on footer block of the page.");
        }
    }
}

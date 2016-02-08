package com.thomsonreuters.pageobjects.pages.login;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OnepassLogin extends AbstractPage {

    public OnepassLogin() {
    }

    public boolean isUsernameValidationErrorDisplayed(String usernameValidationError) {
		return isTextPresent(By.xpath("//span[@id='Username_validationMessage']/span"), usernameValidationError);
	}
    
    public boolean isOnePassValidationErrorDisplayed(String usernameValidationError) {
		return isTextPresent(By.xpath("//div[@id='errorMessageContainer']/span"), usernameValidationError);
	}
    
    public WebElement manageOnePassLoginFormTitle() {
    	return retryingFindElement(By.xpath("//div[@class='signin']//h2"));
    }
    
    public WebElement usernameTextField() {
        return retryingFindElement(By.id("Username"));
    }

    public WebElement passwordTextField() {
        return retryingFindElement(By.id("Password"));
    }

    public WebElement signOnButton() {
        return retryingFindElement(By.id("SignIn"));
    }

    public WebElement signOffLink() {
        return waitForExpectedElement(By.linkText("Sign Off"));
    }

    public WebElement rememeberMeCheckBox() {
        return waitForExpectedElement(By.id("SuperRememberMe"));
    }

    public WebElement loginBox() {
        return retryingFindElement(By.className("signon"));
    }

    public WebElement forgotMyUsernameOrPasswordLink() {
        return retryingFindElement(By.partialLinkText("Forgot my username or password"));
    }

    public WebElement saveMyUsernameCheckBox() {
        return retryingFindElement(By.id("SaveUsername"));
    }

    public WebElement saveMyUsernameAndPasswordCheckBox() {
        return retryingFindElement(By.id("SaveUsernamePassword"));
    }

    public WebElement superRememberMeHintLink() {
        return retryingFindElement(By.id("superRememberMeHint"));
    }

    public WebElement superRememberMeHintPopUp() {
        return retryingFindElement(By.id("superRememberMeHintTooltip"));
    }
    
    public WebElement createNewOnePassProfileLink() {
        return retryingFindElement(By.partialLinkText("Create a new OnePass profile"));
    }

    public WebElement updateExistingOnePassProfileLink() {
        return retryingFindElement(By.partialLinkText("Update an existing OnePass profile"));
    }

    public WebElement learnMoreAboutOnePassLink() {
        return retryingFindElement(By.partialLinkText("Learn more about OnePass"));
    }
    
    public WebElement manageOnepassTitle() {
        return waitForElementVisible(By.xpath("//h2[text()='manage onepass']"));
    }
      
    public WebElement regKeyRadioButtonByRegKey(String regKey) {
    	 return retryingFindElement(By.xpath("//label[contains(text(),'" + regKey + "')]//preceding-sibling::input[contains(@id,'SelectedRegistrationKey')]"));
    }
    
    public List<WebElement> marketingLinks(){
    	return retryingFindElements(By.xpath("//div[@class='marketing']//a"));
    }
    

    public List<WebElement> marketingImages(){
    	return retryingFindElements(By.xpath("//div[@class='marketing']//a/img"));
    }

	public WebElement logoImage() {
		return retryingFindElement(By.xpath("//div[@class='productimage']/img"));
	}
    
}

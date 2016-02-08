package com.thomsonreuters.pageobjects.pages.wlau;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WLAUDocumentPage extends AbstractPage{
	private static final By DOCUMENT_BODY = By.id("docContent");
	private static final By SIGNOF_LINK = By.id("logoutLink");

	public WebElement documentBody() {
		return waitFluentForElement(DOCUMENT_BODY);
	}
	
	public WebElement signoutLink() {
		return waitFluentForElement(SIGNOF_LINK);
	}
	

	
}

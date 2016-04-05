package com.thomsonreuters.khpadd.step_definitions.knowHowDocuments;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;

import com.thomsonreuters.khpadd.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RequestATrialButtonTest extends BaseStepDef {
	
	private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();

    @Then("\"(.*?)\" button is present in document body")
    public void buttonIsPresentInDocumentBody(String title) {
		WebElement button = standardDocumentPage.getLinkFromSection("", title);
		assertTrue("Button with text '" + title + "' is not present in document", button.isDisplayed());
	}
    
	@When("^the user clicks on button with title \"(.*?)\"$")
	public void theUserClicksOnButtonWithTitle(String title) {
		WebElement button = standardDocumentPage.getLinkFromSection("", title);
		button.click();
    }
}

package com.thomsonreuters.khpadd.step_definitions.knowHowDocuments;

import com.thomsonreuters.khpadd.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.CommonResourcePage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.CaseDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.hamcrest.core.Is;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class StickyBarTest extends BaseStepDef {

    private KHResourcePage resourcePage = new KHResourcePage();
    private StandardDocumentPage standartDocumentPage = new StandardDocumentPage();
    private CaseDocumentPage caseDocumentPage = new CaseDocumentPage();

    @Then("^the document title \"(.*?)\" is displayed on the sticky bar$")
    public void theDocumentTitleIsDisplayedOnTheStickyBar(String expectedTitle) throws Throwable {
        resourcePage.scrollDown(11);
        resourcePage.stickyBarTitle(expectedTitle).isDisplayed();
    }

    @Given("^user scroll down the resource to heading \"(.*?)\"$")
    public void userScrollDownTheResourceToHeading(String heading) throws Throwable {
        for (WebElement headingElement : resourcePage.allHeadings()) {
            if (headingElement.getText().trim().equalsIgnoreCase(heading)) {
                scrollToElement(headingElement);
            }
        }
    }

    @Then("^'Related Content' link is displayed on the sticky bar$")
    public void relatedContentLinkIsDisplayedOnTheStickyBar() throws Throwable {
        assertThat(resourcePage.relatedContentLinkOnStickyBar().isDisplayed(), Is.is(true));
    }

    @Then("^clicking on 'Related Content' link on sticky bar jumps to Related Content section$")
    public void clickingOnRelatedContentLinkOnStickyBarJumpsToRelatedContentSection() throws Throwable {
        resourcePage.relatedContentLinkOnStickyBar().click();
        assertTrue("Related content heading is not in the visible area", resourcePage.isRelatedContentHeadingDisplayed());
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) resourcePage).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
    @When("^clicks on document link \"(.*?)\"$")
    public void clicksOnDocumentLink(String documentLink) throws Throwable {
    	resourcePage.embeddedResourceLink(documentLink).click();
    	resourcePage.waitForPageToLoad();
    }
    
    @Then("^user verifies if page is scrolled to heading \"(.*)\"$")
    public void pageScrolledToHeading(String heading) throws Throwable {
    	resourcePage.waitForPageToLoadAndJQueryProcessing();
    	//thread sleep was added to ensure that page is loaded fully
    	Thread.sleep(3000);
    	assertTrue("Page is not scrolled to target text", standartDocumentPage.isDocumentSectionDisplayed(heading));
    }
    
    @When("^user clics on link \"(.*)\" in ToC$")
    public void clicsOnLink(String link) {
    	caseDocumentPage.menuItem(link).click();
    }
    
    
    @Then("^user verifies if sticky bar doesn't hide the target link \"(.*)\"$")
    public void relatedContentBarDoesNotHideLink(String anchor) throws Throwable {
    	assertTrue("Sticky bar hides the target link", 
    			resourcePage.compareElementsLocationByHeight(resourcePage.jumplink(anchor),resourcePage.stickyBar())==-1);
    }

}

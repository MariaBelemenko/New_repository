package com.thomsonreuters.khpadd.step_definitions.knowHowDocuments;

import com.thomsonreuters.khpadd.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.GlossaryPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.DocumentRightPanelPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.hamcrest.core.Is;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class KnowHowResourceMetaDataTest extends BaseStepDef {

    private KHResourcePage resourcePage = new KHResourcePage();
    private DocumentRightPanelPage rightPanelPage = new DocumentRightPanelPage();
    private GlossaryPage glossaryPage = new GlossaryPage();

    @Then("^\"(.*?)\" is displayed underneath the title$")
    public void isDisplayedUnderneathTheTitle(String author) throws Throwable {
        if (author.equalsIgnoreCase("No Author")) {
            LOG.debug("No Author is displayed for this resource type");
            return;
        }
        String authorText = resourcePage.author().getText().trim();
        String authorTrimmed = authorText.substring(3);
        assertThat(authorTrimmed, Is.is(author));

    }

    @Given("^resource status \"(.*?)\" is displayed on the document right hand panel$")
    public void resourceStatusIsDisplayed(String expectedStatus) throws Throwable {
        try {
            assertThat(rightPanelPage.documentStatus().getText().trim().replaceAll("\\n", ""), Is.is(expectedStatus.replaceAll("\\\\n", "")));
        } catch (NoSuchElementException npe) {
            if (expectedStatus.equalsIgnoreCase("No Status")) {
                LOG.debug("No Status is displayed for this resource type");
            } else {
                throw npe;
            }
        }
    }

    @Then("^'(Related Content|View Resource History)' link is (displayed|Not displayed) on the right hand panel$")
    public void relatedContentLinkIsDisplayedOnTheRightHandPanel(String linkText, String display) throws Throwable {
        try {
            WebElement element = rightPanelPage.relatedOrHistoryLink(linkText);
            assertThat(element.isDisplayed(), Is.is(true));
        } catch (NoSuchElementException npe) {
            if (display.equalsIgnoreCase("displayed")) {
                throw npe;
            } else {
                LOG.debug(linkText + " is not displayed");
            }
        }
    }

    @Then("^plc reference is displayed as \"(.*?)\"$")
    public void plcRefIsDisplayedAs(String plcRef) throws Throwable {
        assertThat(resourcePage.plcRef().getText().trim(), Is.is(plcRef));
    }
    
    @When("^user verifies related content in popup window$")
    public void theUserVerifyRelatedContent(List<String> resources) throws Throwable {
       List<WebElement> relatedContent = glossaryPage.popupRelatedContent();
       List<String> relatedContentText = new ArrayList<>();
       for (WebElement webElement : relatedContent) {
    	   relatedContentText.add(webElement.getText());
       }
       assertTrue("related content is incorrect", resources.equals(relatedContentText));
    }

}

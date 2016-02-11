package com.thomsonreuters.khpadd.step_definitions.knowHowDocuments;

import com.thomsonreuters.khpadd.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.hamcrest.core.Is;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;

public class StickyBarTest extends BaseStepDef {

    private KHResourcePage resourcePage = new KHResourcePage();

    @Then("^the document title \"(.*?)\" is displayed on the sticky bar$")
    public void theDocumentTitleIsDisplayedOnTheStickyBar(String expectedTitle) throws Throwable {
        String actualTitle = resourcePage.titleOnStickyBar().getText().trim();
        int endIndex = actualTitle.contains("\n") ? actualTitle.indexOf("\n") : actualTitle.length();
        LOG.info("Heading = " + actualTitle.substring(0, endIndex).trim());
        assertThat(actualTitle.substring(0, endIndex).trim(), Is.is(expectedTitle));
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
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) resourcePage).executeScript("arguments[0].scrollIntoView(true);", element);
    }

}

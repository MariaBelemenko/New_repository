package com.thomsonreuters.ask.step_definitions.document;

import com.thomsonreuters.ask.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.DocumentRightPanelPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.hamcrest.core.Is;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class AskDocumentMetadataTest extends BaseStepDef {

    private KHResourcePage resourcePage = new KHResourcePage();
    private DocumentRightPanelPage rightPanelPage = new DocumentRightPanelPage();

    @Then("^author name \"(.*?)\" is displayed underneath the document title$")
    public void authorNameIsDisplayedUnderneathTheDocumentTitle(String authorName) throws Throwable {
        assertThat(resourcePage.author().getText().trim(), Is.is(authorName));
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

    @Then("^following jurisdictions are displayed on the document right hand panel$")
    public void followingJurisdictionsAreDisplayedOnTheDocumentRightHandPanel(List<String> expectedJurisdictions) throws Throwable {
        if (expectedJurisdictions.size() == 1 && expectedJurisdictions.get(0).contains(",")) {
            assertThat(rightPanelPage.getVisibleJurisdictions(), Is.is(Arrays.asList(expectedJurisdictions.get(0).split(","))));
        } else {
            if (expectedJurisdictions.get(0).equalsIgnoreCase("No Jurisdictions")) {
                LOG.debug("No Jurisdictions are displayed for this resource type");
            } else {
                assertThat(rightPanelPage.getVisibleJurisdictions(), Is.is(expectedJurisdictions));
            }
        }
    }

    @Then("^'Ask a question' link is displayed$")
    public void askAQuestionLink() throws Throwable {
        assertThat(resourcePage.askAQuestion().isDisplayed(), Is.is(true));
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

}

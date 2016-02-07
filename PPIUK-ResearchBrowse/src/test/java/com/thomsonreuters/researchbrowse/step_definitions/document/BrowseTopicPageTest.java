package com.thomsonreuters.researchbrowse.step_definitions.document;

import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawHomepage;
import com.thomsonreuters.pageobjects.pages.researchBrowse.RBContentTypePAPage;
import com.thomsonreuters.pageobjects.pages.researchBrowse.RBPLHomePage;
import com.thomsonreuters.researchbrowse.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;
import org.openqa.selenium.By;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class BrowseTopicPageTest extends BaseStepDef {

    private RBContentTypePAPage contentTypePAPage = new RBContentTypePAPage();
    private PracticalLawHomepage practicalLawHomepage = new PracticalLawHomepage();
    private RBPLHomePage rbplHomePage = new RBPLHomePage();

    public String topic;

    @When("^clicks on (.*) topic link$")
    public void clicksOnTopicLink(String topicLink) throws Throwable {
        contentTypePAPage.topicLink(topicLink).click();
        practicalLawHomepage.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^RB (Journals|Cases|Legislation) (.*) Topic Page is displayed$")
    public void rbTopicPageIsDisplayed(String contentType, String topic) throws Throwable {
        assertThat(rbplHomePage.pageHeading().getText().trim(), Is.is(topic));
    }

    @Then("^RB Know-How Topic Page for \"(.*?)\" is displayed$")
    public void rbKnowHowTopicPageForWithWorkingLinksToResearchTopicPageIsDisplayed(String topic) throws Throwable {
        this.topic = topic;
        assertTrue(rbplHomePage.pageHeading().getText().trim().contains(topic));
    }

    @Then("^browse functionality between KH Topic Page and \"(.*?)\" Topic page works correctly$")
    public void browseFunctionalityBetweenKHTopicPageAndTopicPageWorksCorrectly(String contentType) throws Throwable {
        if (contentType.equalsIgnoreCase("cases")) {
            rbplHomePage.findElement(By.linkText("View All " + topic + " " + contentType)).click();
        } else {
            rbplHomePage.findElement(By.linkText("View all " + topic + " " + contentType)).click();
        }
        practicalLawHomepage.waitForPageToLoadAndJQueryProcessing();
        rbplHomePage.findElement(By.linkText("View All " + topic + " resources")).click();
        practicalLawHomepage.waitForPageToLoadAndJQueryProcessing();
        rbKnowHowTopicPageForWithWorkingLinksToResearchTopicPageIsDisplayed(topic);
    }

}

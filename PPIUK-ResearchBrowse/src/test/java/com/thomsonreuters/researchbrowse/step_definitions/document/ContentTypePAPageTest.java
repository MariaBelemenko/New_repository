package com.thomsonreuters.researchbrowse.step_definitions.document;

import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawHomepage;
import com.thomsonreuters.pageobjects.pages.researchBrowse.RBContentTypePAPage;
import com.thomsonreuters.pageobjects.pages.researchBrowse.RBContentTypePage;
import com.thomsonreuters.pageobjects.pages.researchBrowse.RBPLHomePage;
import com.thomsonreuters.pageobjects.utils.researchBrowse.ResearchContentTypeEnum;
import com.thomsonreuters.researchbrowse.step_definitions.BaseStepDef;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;

public class ContentTypePAPageTest extends BaseStepDef {

    private RBContentTypePage contentTypePage = new RBContentTypePage();
    private RBContentTypePAPage contentTypePAPage = new RBContentTypePAPage();
    private PracticalLawHomepage practicalLawHomepage = new PracticalLawHomepage();
    private RBPLHomePage rbplHomePage = new RBPLHomePage();

    @When("^user clicks on the \"(.*?)\" Practice Area Link$")
    public void userClicksOnThePracticeAreaLink(String link) throws Throwable {
        contentTypePage.practiceAreaLink(link.trim()).click();
    }

    @Then("^RB (.*) Practice Area Page with heading \"(.*?)\" is displayed$")
    public void rbJournalsPracticeAreaIsDisplayed(ResearchContentTypeEnum contentType, String practiceAreaHeading) throws Throwable {
        contentTypePAPage.waitForPageHeadingText(practiceAreaHeading);
        assertThat("Marketing Text is Wrong", contentTypePAPage.description().getText().trim(), Is.is(contentType.getStaticText()));
        assertThat(contentTypePAPage.findOutMoreLink().isDisplayed(), Is.is(true));
    }

    @Given("^user clicks on \"(.*?)\" Link on RB PLC Home Page$")
    public void userClicksOnLinkOnRBPLCHomePage(String practiceArea) throws Throwable {
        contentTypeLink(practiceArea).click();
        practicalLawHomepage.waitForPageToLoadAndJQueryProcessing();
    }

    @When("^user clicks on the Resources Tab$")
    public void userClicksOnTheResourcesTab() throws Throwable {
        rbplHomePage.resourcesTab().click();
    }

    /**
     * This is a workaround for server side cache issue where the links are not displayed sometime
     */
    private WebElement contentTypeLink(String linkText) throws InterruptedException {
        WebElement element = null;
        int count = 0;
        do {
            try {
                Thread.sleep(1000);
                element = rbplHomePage.findElement(By.linkText(linkText));
                count++;
            } catch (NoSuchElementException nse) {
                LOG.warn("Link not found");
                rbplHomePage.refreshPage();
            }
        }
        while (null == element && count <= 10);
        return element;
    }

}

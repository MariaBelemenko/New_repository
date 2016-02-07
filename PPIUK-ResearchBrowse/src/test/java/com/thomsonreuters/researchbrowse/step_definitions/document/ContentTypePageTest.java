package com.thomsonreuters.researchbrowse.step_definitions.document;

import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawHomepage;
import com.thomsonreuters.pageobjects.pages.researchBrowse.RBContentTypePAPage;
import com.thomsonreuters.pageobjects.pages.researchBrowse.RBContentTypePage;
import com.thomsonreuters.pageobjects.pages.researchBrowse.RBPLHomePage;
import com.thomsonreuters.pageobjects.utils.researchBrowse.ResearchContentTypeEnum;
import com.thomsonreuters.researchbrowse.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;

public class ContentTypePageTest extends BaseStepDef {

    private RBPLHomePage rbplHomePage = new RBPLHomePage();
    private RBContentTypePage contentTypePage = new RBContentTypePage();
    private PracticalLawHomepage practicalLawHomepage = new PracticalLawHomepage();
    private RBContentTypePAPage contentTypePAPage = new RBContentTypePAPage();

    @When("^user clicks on (Journals|Cases|Legislation) Link on RB Resources Tab$")
    public void userClicksOnJournalsLinkOnRBResourcesTab(ResearchContentTypeEnum contentType) throws Throwable {
        contentTypeLink(contentType.getLinkText()).click();
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

    @Then("^RB (Journals|Cases|Legislation) Page is displayed with static text & link to marketing page$")
    public void rbJournalsPageIsDisplayed(ResearchContentTypeEnum contentType) throws Throwable {
        Thread.sleep(2000);
        assertThat(contentTypePage.pageHeading().getText().trim(), Is.is(contentType.getHeading()));
        assertThat(contentTypePage.description().getText().trim(), Is.is(contentType.getStaticText()));
        assertThat(contentTypePage.findOutMoreLink().isDisplayed(), Is.is(true));
    }

    @When("^user does click on Find out more link$")
    public void userClicksOnLinkOnPage() throws Throwable {
        contentTypePage.findOutMoreLink().click();
        practicalLawHomepage.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^marketing page for \"(.*?)\" research content is displayed$")
    public void marketingPageForResearchContentIsDisplayed(ResearchContentTypeEnum contentType) throws Throwable {
        assertThat(contentTypePAPage.pageHeading().getText().trim(), Is.is("Find out more"));
    }

}

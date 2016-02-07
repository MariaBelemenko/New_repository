package com.thomsonreuters.frontend.step_definitions.khPadd;

import com.thomsonreuters.frontend.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.DocumentRightPanelPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import com.thomsonreuters.pageobjects.pages.urls.plcuk.KHDocumentPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class ViewRelatedConentLinkTest extends BaseStepDef {

    private KHResourcePage khResourcePage = new KHResourcePage();
    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();
    private DocumentRightPanelPage rightPanelPage = new DocumentRightPanelPage();
    private KHDocumentPage khDocumentPage = new KHDocumentPage();

    @Then("^the user should see the related content section displayed$")
    public void theUserShouldSeeTheRelatedContentSectionDisplayed() throws Throwable {
        assertTrue("Related Content section not displayed..!", khResourcePage.relatedContentHeading().isDisplayed());
    }

    @When("the user clicks on link in related content with title \"(.*?)\"")
    public void theUserClicksOnLinkInRelatedContent(String title) {
        WebElement link = standardDocumentPage.getLinkInRelatedContent(title);
        link.click();
    }

    @Then("^document title is displayed as \"(.*?)\"$")
    public void titleIsDisplayedAs(String title) throws Throwable {
        assertThat(khResourcePage.title().getText().trim().replaceAll("\\n", " "), Is.is(title.replaceAll("\\\\n", " ")));
    }

    @Then("^resource type is displayed as \"(.*?)\" on right hand panel$")
    public void documentTypeIsDisplayedAsArticles(String documentType) throws Throwable {
        rightPanelPage.waitForPageToLoad();
        assertThat(rightPanelPage.resourceTypeText().getText().trim(), Is.is(documentType));
    }

    @Then("^the user should see the related content button on the sticky header$")
    public void theUserShouldSeeTheRelatedContentButtonOnTheStickyHeader() throws Throwable {
        assertThat(khResourcePage.relatedContentLinkOnStickyBar().isDisplayed(), Is.is(true));
    }

    @Then("^the user clicks on \"Related Content\" button$")
    public void theUserClicksOnRelatedContentButton() throws Throwable {
        khResourcePage.relatedContentLinkOnStickyBar().click();
    }

    @Then("^document contains link to '(.+)'$")
    public void documentContainsLinkTo(String name) throws Throwable {
        assertTrue("Document doesn't contain link to " + name, khDocumentPage.isContainLinkTo(name));
    }

}

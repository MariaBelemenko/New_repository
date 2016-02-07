package com.thomsonreuters.assetpages.step_definitions.page;

import com.thomsonreuters.assetpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class PracticeNotesTest extends BaseStepDef {

    private AssetPageUtils assetPageUtils = new AssetPageUtils();
    private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();

    String hrefAtribute;

    @Then("^the user sees \"(.*?)\" UK Practice Notes section$")
    public void theUserSeesUKPracticeNotesSection(String practiceNotesText) throws Throwable {
        assetDocumentPage.waitForPageToLoad();
        assertTrue("The user doesn't see UK Practice Notes section",
                assetDocumentPage.isElementDisplayed(assetDocumentPage.practiceNotes(practiceNotesText)));
    }

    @Then("^the user sees \"(.*?)\" in UK Practice Notes section$")
    public void theUserSeesInUKPracticeNotesSection(String linkText) throws Throwable {
        assertTrue("The user doesn't see links in UK Practice Notes section",
                assetDocumentPage.isElementDisplayed(assetDocumentPage.linksInPracticeNotesSection(linkText)));
    }

    @When("^the user clicks on \"(.*?)\" links in Practice Notes section$")
    public void theUserClicksOnLinksInPracticeNotesSection(String linkText) throws Throwable {
        assetPageUtils.getBaseParameters();
        hrefAtribute = assetDocumentPage.linksInPracticeNotesSection(linkText).getAttribute("href");
        assetDocumentPage.linksInPracticeNotesSection(linkText).click();
    }

    @Then("^the user is taken to the internal document$")
    public void theUserIsTakenToTheInternalDocument() throws Throwable {
        assertTrue("The user doesn't taken to the internal document",
                assetPageUtils.isTheUserTakenToTheInternalDocument(hrefAtribute));
    }

}

package com.thomsonreuters.assetpages.step_definitions.link;

import com.thomsonreuters.assetpages.step_definitions.BaseStepDef;
import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.DocumentRightPanelPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.PrimarySourceDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrimarySourcePgLegGovUKLinkTest extends BaseStepDef {

    private PrimarySourceDocumentPage primarySourceDocumentPage = new PrimarySourceDocumentPage();
    private AssetPageUtils assetPageUtils = new AssetPageUtils();
    private DocumentRightPanelPage rightPanelPage = new DocumentRightPanelPage();

    @Then("^the user see links to \"(.*?)\" Legislation$")
    public void theUserSeeLinksToLegislation(String legislationLinkText) throws Throwable {
        primarySourceDocumentPage.refreshPage();
        primarySourceDocumentPage.waitForPageToLoad();
        assertTrue("The primary source title doesn't displayed",
                primarySourceDocumentPage.isElementDisplayed(primarySourceDocumentPage
                        .legislationLink(legislationLinkText))
        );
    }

    @When("^the user click on \"(.*?)\" Legislation link$")
    public void theUserClickOnLegislationLink(String legislationLinkText) throws Throwable {
        assetPageUtils.getBaseParameters();
        primarySourceDocumentPage.legislationLink(legislationLinkText).click();
    }

    @Then("^the user does not see links to \"(.*?)\" Legislation$")
    public void theUserDoesNotSeeLinksToLegislation(String legislationLinkText) throws Throwable {
        try {
            assertFalse("The user see links to Legislation",
                    primarySourceDocumentPage.isElementDisplayed(primarySourceDocumentPage
                            .legislationLink(legislationLinkText))
            );
        } catch (PageOperationException poe) {
            LOG.info("context", poe);
        }
    }

    @Then("^the number of open tabs equals \"(.*?)\"$")
    public void theNumberOfOpenTabsEquals(String numberOfOpenedTubs) throws Throwable {
    	primarySourceDocumentPage.waitForPageToLoad();
        assertTrue("Incorrect number of opened tubs",
                assetPageUtils.isTheNumberOfOpenedTubsEqueals(Integer.parseInt(numberOfOpenedTubs)));
    }

    @Then("^resource type is displayed as \"(.*?)\" on right hand panel$")
    public void documentTypeIsDisplayedAsArticles(String documentType) throws Throwable {
        rightPanelPage.waitForPageToLoad();
        assertThat(rightPanelPage.resourceTypeText().getText().trim(), Is.is(documentType));
    }

}

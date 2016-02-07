package com.thomsonreuters.assetpages.step_definitions.page;

import com.thomsonreuters.assetpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;

public class AssetPageTemplateTest extends BaseStepDef {

    private AssetPageUtils assetPageUtils = new AssetPageUtils();
    private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();

    @Then("^the document contain class with case-asset-doc$")
    public void theDocumentContainClassWithCaseAssetDoc() throws Throwable {
        assertTrue("The document doesn't contain class with case-asset-doc",
                assetPageUtils.isDocumentContainClassWithCaseAssetDoc());
    }

    @Then("^the document contain content body$")
    public void theDocumentContainContentBody() throws Throwable {
        assertTrue("The document doesn't contain content body",
                assetDocumentPage.isElementDisplayed(assetDocumentPage.contentBody()));
    }

    @Then("^the content body contain end of document$")
    public void theContentBodyContainEndOfDocument() throws Throwable {
        assertTrue("The content body doesn't conatin ent of document",
                assetPageUtils.isTheContentBodyContainEndOfDocument());
    }

    @Then("^the end of document does not contain text$")
    public void theEndOfDocumentDoesNotContainText() throws Throwable {
        assertTrue("The End of Document contain text", assetPageUtils.isTheEndOfDocumentContainText());
    }

    @Then("^the document contain \"(.*?)\" Resource Type$")
    public void theDocumentContainResourceType(String resourceTypeText) throws Throwable {
        assertTrue("The document doesn't contain resource type",
                assetDocumentPage.isElementDisplayed(assetDocumentPage.resourceType(resourceTypeText)));
    }

    @Then("^the document contain \"(.*?)\" Court$")
    public void theDocumentContainCourt(String courtText) throws Throwable {
        assertTrue("The document doesn't contain court",
                assetDocumentPage.isElementDisplayed(assetDocumentPage.court(courtText)));
    }

}

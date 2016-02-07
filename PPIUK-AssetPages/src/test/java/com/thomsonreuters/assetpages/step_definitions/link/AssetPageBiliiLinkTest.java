package com.thomsonreuters.assetpages.step_definitions.link;

import com.thomsonreuters.assetpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.PrimarySourceDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;

public class AssetPageBiliiLinkTest extends BaseStepDef {

    private PrimarySourceDocumentPage primarySourceDocumentPage = new PrimarySourceDocumentPage();
    private AssetPageUtils assetPageUtils = new AssetPageUtils();

    @Then("^the user is taken to \"(.*?)\" resource$")
    public void theUserIsTakenToResource(String linkText) throws Throwable {
        primarySourceDocumentPage.waitForPageToLoad();
        assetPageUtils.getBaseParameters();
        assertTrue("The user doesn't taken to the selected resource",
                assetPageUtils.isTheUserTakenToTheSelectedResource(linkText));
    }

}

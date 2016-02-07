package com.thomsonreuters.assetpages.step_definitions.document;

import com.thomsonreuters.assetpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AssetPageTableOfContentTest extends BaseStepDef {

    private AssetPageUtils assetPageUtils = new AssetPageUtils();
    private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();

    @Then("^the user see Table of content$")
    public void theUserSeeTableOfContent() throws Throwable {
        assertTrue("The user doesn't see table of content",
                assetPageUtils.isTableOfContentDisplayed());
    }

    @When("^the user click on \"(.*?)\" Table of content$")
    public void theUserClickOnTableOfContent(String tableOfContentText)
            throws Throwable {
        assetDocumentPage.tableOfContentButton(tableOfContentText).click();
    }

    @Then("^the Table of content will hide$")
    public void theTableOfContentWillHide() throws Throwable {
        assertFalse("The user see table of content",
                assetPageUtils.isTableOfContentDisplayed());
    }

}

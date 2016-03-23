package com.thomsonreuters.should.step_definitions.assetPages;

import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;
import com.thomsonreuters.should.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;

public class AssetPageFontSizeTest extends BaseStepDef {

    private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();
    private AssetPageUtils assetPageUtils = new AssetPageUtils();

    @Then("^the user sees link \"(.*?)\" in the \"(.*?)\" section$")
    public void theUserSeesLinkInTheSection(String linkText, String sectionName) throws Throwable {
        assertTrue("The user doesn't see link in section", assetDocumentPage.isElementDisplayed(assetDocumentPage
                .linkInLegalUpdatesSection(linkText, sectionName)));
    }

    @Then("^font size of \"(.*?)\" equals font size of \"(.*?)\"$")
    public void fontSizeOfEqualsFontSizeOf(String linktTextFirst, String linkTextSecond) throws Throwable {
        assertTrue("The font sizes of these links are not equals", assetPageUtils.getFontSizeOfLink(linktTextFirst)
                .equals(assetPageUtils.getFontSizeOfLink(linkTextSecond)));
    }

}

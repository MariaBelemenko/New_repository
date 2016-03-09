package com.thomsonreuters.assetpages.step_definitions.page;

import static org.junit.Assert.assertTrue;

import com.thomsonreuters.assetpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;

import cucumber.api.java.en.Then;

public class PrimarySourceMetaDataTest extends BaseStepDef {

    private AssetPageUtils assetPageUtils = new AssetPageUtils();
    private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();

    @Then("^the \"(.*?)\" Jurisdictions contain more than one jurisdiction$")
    public void theJurisdictionsContainMoreThanOneJurisdiction(String jurisdictionsText) throws Throwable {
        assertTrue("The jurisdictions contain less than one jurisdiction",
                assetPageUtils.isTheJurisdictionsContainLessThanOneJurisdiction(jurisdictionsText));
    }
    
    @Then("^the metadata is displayed in the right hand side of the central column$")
    public void theMetadataIsDisplayedInTheRightHandSideOfTheCentralColumn() throws Throwable {
    	assertTrue("The metadata is not displayed in the right hand side of the central column",
				assetDocumentPage.caseMetadata().isDisplayed());
    }

    @Then("^the metadata contains \"([^\"]*)\"$")
    public void theMetadataContains(String field) throws Throwable {
    	assertTrue("The metadata doesn't contain " + field + "field",
				assetDocumentPage.metaDataField(field).isDisplayed());
    }

}

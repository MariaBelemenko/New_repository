package com.thomsonreuters.should.step_definitions.assetPages;

import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import com.thomsonreuters.pageobjects.pages.urls.plcuk.KHDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;
import com.thomsonreuters.should.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class CelexLinkTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();
    private KHDocumentPage documentPagePLCUK = new KHDocumentPage();
    private AssetPageUtils assetPageUtils = new AssetPageUtils();

    @When("^the user opens document with (.+) guid$")
    public void theUserOpensDocumentWithGuid(String guid) throws Throwable {
        navigationCobalt.navigateToPLCUKPlusSpecificURL("/Document/" + guid + "/View/FullText.html");
        navigationCobalt.waitForPageToLoad();
    }

    @Then("^the user click on View Document button$")
    public void theUserClickOnViewDocumentButton() throws Throwable {
        standardDocumentPage.clickOnViewDocumentButton();
    }

    @Then("^the document opens correctly$")
    public void theDocumentOpensCorrectly() throws Throwable {
        assertTrue("Document not present", documentPagePLCUK.isDocumentBlockPresent());
    }

    @Then("^the user see celex links \"(.*?)\"$")
    public void theUserSeeCelexLinks(String celexLinkText) throws Throwable {
        assertTrue("The user doesn't see celex links", assetPageUtils.isTheUserSeeCelexLinks(celexLinkText));
    }

    @When("^the user click on celex link \"(.*?)\"$")
    public void theUserClickOnCelexLink(String celexLinkText) throws Throwable {
        assetPageUtils.clickOnCelexLink(celexLinkText);
    }

}

package com.thomsonreuters.assetpages.step_definitions.common;

import com.thomsonreuters.assetpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.Assert.assertTrue;

public class AssetPageTopButtonTest extends BaseStepDef {

    private AssetPageUtils assetPageUtils = new AssetPageUtils();
    private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();

    @Then("^apply document settings$")
    public void applyDocumentSettings() throws Throwable {
        assetPageUtils.addTextToTheDocumentPage();
        JavascriptExecutor e = (JavascriptExecutor) assetDocumentPage;
        e.executeScript("$('#co_backToTop').css('display', 'block');");
    }

    @Then("^the user see Top button$")
    public void theUserSeeTopButton() throws Throwable {
        assertTrue("The user doesn't see jump links in the left hand navigation panel",
                assetDocumentPage.isElementDisplayed(assetDocumentPage.topButton()));
    }

    @When("^the user click on Top button$")
    public void theUserClickOnTopButton() throws Throwable {
        assetDocumentPage.topButton().click();
    }

    @Then("^the user scrolled to the top of the document$")
    public void theUserScrolledToTheTopOfTheDocument() throws Throwable {
        assertTrue("The user doesn't scrolled to the top of the document",
                assetPageUtils.isTheUserScrolledToTheTopOfTheDocument());
    }

}

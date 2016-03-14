package com.thomsonreuters.assetpages.step_definitions.link;

import static org.junit.Assert.assertTrue;

import com.thomsonreuters.assetpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.PrimarySourceDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LinkPointsTest extends BaseStepDef {

    private PrimarySourceDocumentPage primarySourceDocumentPage = new PrimarySourceDocumentPage();
    private AssetPageUtils assetPageUtils = new AssetPageUtils();
    private CommonMethods commonMethods = new CommonMethods();

    @Then("^the document contain \"(.*?)\" links$")
    public void theDocumentContainLinks(String linkText) throws Throwable {
        primarySourceDocumentPage.waitForPageToLoad();
        assertTrue("The document doesn't contain link", assetPageUtils.isTheDocumentContainLink(linkText));
    }

    @Then("^these \"(.*?)\" displayed accoding with className and hrefAtribute$")
    public void theseDisplayedAccodingWithClassNameAndHrefAtribute(String linkText) throws Throwable {
        primarySourceDocumentPage.waitForPageToLoad();
        assertTrue("The link doesn't displayed according with class name and hrefAtribute",
                assetPageUtils.isTheLinkDisplayedAccodingWithClassNameAndHrefAtribute(linkText));
    }

    @Then("^the user sees the \"(.*?)\" link$")
    public void theUserSeesTheLink(String linkText) throws Throwable {
        assertTrue("The user doesn't see Link",
                primarySourceDocumentPage.isElementDisplayed(primarySourceDocumentPage.linkInPrimarySource(linkText)));
    }
    
    @When("^the user clicks on \"([^\"]*)\" link$")
    public void theUserClicksOnLink(String link) throws Throwable {
    	primarySourceDocumentPage.waitForPageToLoad();
    	commonMethods.clickLink(link);
    }

}

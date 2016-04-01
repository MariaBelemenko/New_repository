package com.thomsonreuters.assetpages.step_definitions.common;

import com.thomsonreuters.assetpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.PrimarySourceDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import com.thomsonreuters.pageobjects.pages.urls.plcuk.KHDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertTrue;

public class AssetPageStylesTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();
    private KHDocumentPage documentPagePLCUK = new KHDocumentPage();
    private AssetPageUtils assetPageUtils = new AssetPageUtils();
    private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();
    private PrimarySourceDocumentPage primarySourceDocumentPage = new PrimarySourceDocumentPage();

    private String linkText;

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

    @Then("^the bullets have \"(.*?)\" style$")
    public void theBulletsHaveStyle(String styleName) throws Throwable {
        assertTrue("The bullets do't have " + styleName + "style", assetPageUtils.isTheBulletsHaveStyle(styleName));
    }

    @Then("^the double lines have \"(.*?)\" style$")
    public void theDoubleLinesHaveStyle(String styleName) throws Throwable {
        assertTrue("The double lines do't have " + styleName + "style",
                assetPageUtils.isTheDoubleLinesHaveStyle(styleName));
    }

    @Then("^the spacing between double lines and links have \"(.*?)\" size$")
    public void theSpacingBetweenDoubleLinesAndLinksHaveSize(String size) throws Throwable {
        assertTrue("The spacing between double lines and links doesn't have " + size + "size",
                assetPageUtils.isTheSpacingBetweenDoubleLinesAndLinksHaveSize(size));
    }

    @Then("^the \"(.*?)\" has font size \"(.*?)\"$")
    public void theHasFontSize(String linkText, String fontSize) throws Throwable {
        assertTrue("The " + linkText + "doesn't has " + fontSize + "font size",
                assetPageUtils.getFontSizeOfLink(linkText).equals(fontSize));
    }

    @Then("^the user see \"(.*?)\" jump link in the left hand side navigation panel$")
    public void theUserSeeJumpLinkInTheLeftHandSideNavigationPanel(String jumpLinkText) throws Throwable {
        assetDocumentPage.waitForPageToLoad();
        assetDocumentPage.waitForPageToLoadAndJQueryProcessing();
        assertTrue("The user doesn't see jump links in the left hand navigation panel",
                assetPageUtils.isTheUserSeeJumpLinksInTheLeftHandSideNavigationPanel(jumpLinkText));
    }

    @When("^the user clicks on \"(.*?)\" jump link$")
    public void theUserClicksOnJumpLink(String jumpLinkText) throws Throwable {
        linkText = assetPageUtils.clickOnJumpLink(jumpLinkText);
    }

    @When("^the user scrolled to the bottom of the document$")
    public void theUserScrolledToTheBottomOfTheDocument() throws Throwable {
        assetPageUtils.scrollToTheBottomOfTheDocument();
    }

    @Then("^the user sees Show more \"(.*?)\" link$")
    public void theUserSeesShowMoreLink(String showMoreLinkText) throws Throwable {
        primarySourceDocumentPage.waitForPageToLoad();
        assertTrue("The user doesn't see Show more link",
                primarySourceDocumentPage.isElementDisplayed(primarySourceDocumentPage.showMoreLink(showMoreLinkText)));
    }

    @Then("^this link located on the \"(.*?)\" side$")
    public void thisLinkLocatedOnTheSide(String sideName) throws Throwable {
        assertTrue("The link doesn't located on " + sideName + "side",
                assetPageUtils.isTheLinkLocatedOnTheSide(sideName));
    }

    @Then("^the \"(.*?)\" displayed on the document$")
    public void theDisplayedOnTheDocument(String headerHame) throws Throwable {
        assertTrue("The document doesn't contain " + headerHame + "header",
                assetDocumentPage.isElementDisplayed(assetDocumentPage.sectionHeader(headerHame)));
    }

    @Then("^the \"(.*?)\" header has \"(.*?)\" font size$")
    public void theHeaderHasFontSize(String headerHame, String fontSize) throws Throwable {
        assertTrue("The " + headerHame + "doesn't has " + fontSize + "font size",
                assetPageUtils.getFontSizeOfHeader(headerHame).equals(fontSize));
    }

    @Then("^near the \"(.*?)\" bullet have \"(.*?)\" font size$")
    public void nearTheBulletHaveFontSize(String linkText, String fontSize) throws Throwable {
        assertTrue("The bullet doesn't has " + fontSize + "font size",
                assetPageUtils.getFontSizeOfBullet(linkText).equals(fontSize));
    }
    
	@Then("^the user is taken to selected part of the document$")
	public void theUserIsTakenToSelectedPartOfTheDocument() throws Throwable {
		assertTrue("The user doesn't taken to the selected part of the document",
				assetPageUtils.isTheUserTakenToSelectedPartOfTheDocument(linkText));
	}

}

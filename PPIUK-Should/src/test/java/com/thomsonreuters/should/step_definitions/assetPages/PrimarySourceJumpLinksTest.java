package com.thomsonreuters.should.step_definitions.assetPages;

import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.AssetDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.PrimarySourceDocumentPage;
import com.thomsonreuters.pageobjects.rest.DeliveryBaseUtils;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;
import com.thomsonreuters.should.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class PrimarySourceJumpLinksTest extends BaseStepDef {

    private PrimarySourceDocumentPage primarySourceDocumentPage = new PrimarySourceDocumentPage();
    private AssetPageUtils assetPageUtils = new AssetPageUtils();
    private AssetDocumentPage assetDocumentPage = new AssetDocumentPage();
    private DeliveryBaseUtils deliveryBaseUtils = new DeliveryBaseUtils();

    private String linkText;

    @Then("^text added to the document$")
    public void textAddedToTheDocument() throws Throwable {
        primarySourceDocumentPage.waitForPageToLoadAndJQueryProcessing();
        assetPageUtils.addTextToTheDocumentPage();
    }

    @Then("^the user see links to \"(.*?)\" Bailii$")
    public void theUserSeeLinksToBailii(String bailiiLink) throws Throwable {
        assertTrue("The user doesn't see links to Bailii", assetPageUtils.isTheUserSeeLinksToBailii(bailiiLink));
    }

    @Then("^the user see link to \"(.*?)\" Westlaw UK$")
    public void theUserSeeLinkToWestlawUK(String westlawUkLinkText) throws Throwable {
        assertTrue("The user doesn't see link to westlawUk",
                assetPageUtils.isTheUserSeeLinkToWestlawUK(westlawUkLinkText));
    }

    @Then("^the downloaded PDF document contain hyperlink to \"(.*?)\" Bailii$")
    public void theDownloadedPDFDocumentContainHyperlinkToBailii(String bailiiLinkText) throws Throwable {
        assertTrue("The downloaded PDF document doesn't contain hyperlink to Bailii",
                assetPageUtils.isTheDownloadedPDFDocumentContainHyperlinkToExternalWebSite(assetDocumentPage
                                .bailiiLink(bailiiLinkText).getAttribute("href"), bailiiLinkText,
                        deliveryBaseUtils.getDownloadedDoc()
                )
        );
    }

    @Then("^the downloaded PDF document contain hyperlink to \"(.*?)\" Westlaw UK$")
    public void theDownloadedPDFDocumentContainHyperlinkToWestlawUK(String wetslawUKLinkText) throws Throwable {
        assertTrue("The downloaded PDF document doesn't contain hyperlink to WestlawUK",
                assetPageUtils.isTheDownloadedPDFDocumentContainHyperlinkToExternalWebSite(assetDocumentPage
                                .westlawUkLink(wetslawUKLinkText).getAttribute("href"), wetslawUKLinkText,
                        deliveryBaseUtils.getDownloadedDoc()
                )
        );
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

    @Then("^the user is taken to selected part of the document$")
    public void theUserIsTakenToSelectedPartOfTheDocument() throws Throwable {
        assertTrue("The user doesn't taken to the selected part of the document",
                assetPageUtils.isTheUserTakenToSelectedPartOfTheDocument(linkText));
    }

}

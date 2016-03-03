package com.thomsonreuters.researchdocdisplay.step_definitions.common;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.ProvisionPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.ProvisionPageUtils;
import com.thomsonreuters.researchdocdisplay.step_definitions.BaseStepDef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertTrue;

public class JurisdictionAndNotesTest extends BaseStepDef {

    private ProvisionPage provisionPage = new ProvisionPage();
    private ProvisionPageUtils provisionPageUtils = new ProvisionPageUtils();
    protected PageActions pageActions = new PageActions();
    private CommonMethods commonMethods = new CommonMethods();

    private String url;

    @Then("^the user the user will see the jurisdictions listed in the left hand navigation column$")
    public void theUserTheUserWillSeeTheJurisdictionsListedInTheLeftHandNavigationColumn() throws Throwable {
        assertTrue("The jurisdictions is not displayed",
                provisionPage.isElementDisplayed(provisionPage.jurisdictionLink()));
    }

    @When("^the user selects a jurisdiction$")
    public void theUserSelectsAJurisdiction() throws Throwable {
        provisionPageUtils.clickOnLink(provisionPage.jurisdictionLink());
    }

    @Then("^the user is taken to that part of the document$")
    public void theUserIsTakenToThatPartOfTheDocument() throws Throwable {
        assertTrue("The user is not taken to the part of the document",
                provisionPageUtils.isUserTakenToThatPartOfTheDocument());
    }

    @Then("^the document contain internal links to other documents$")
    public void theDocumentContainInternalLinksToOtherDocuments() throws Throwable {
        assertTrue("The document do't contain internal links to other documents",
                provisionPage.isElementDisplayed(provisionPage.linkInNoteDescription()));
    }

    @When("^the user clicks on one of interlan links$")
    public void theUserClicksOnOneOfInterlanLinks() throws Throwable {
        url = provisionPageUtils.clicksOnOneOfInternalLinks();
    }

    @Then("^the user will be taken to the internal document$")
    public void theUserWillBeTakenToTheInternalDocument() throws Throwable {
        assertTrue("The user did'n take the internal document",
                provisionPageUtils.isTheUserTakenToTheSelectedDocument(url));
    }

    @Then("^the user see the \"(.*?)\" amendments on document$")
    public void theUserSeeTheAmendmentsOnDocument(String amendmentsText) throws Throwable {
        assertTrue("The user doesn't see the amendments on document",
                provisionPage.isElementDisplayed(provisionPage.amendmentsLink(amendmentsText)));
    }

    @When("^the user views the \"(.*?)\" amendments$")
    public void theUserViewsTheAmendments(String amendmentsText) throws Throwable {
        assertTrue("The user doesn't views the amendments on document",
                provisionPage.isElementDisplayed(provisionPage.amendmentText(amendmentsText)));
    }

    @Then("^the user see notes in the amendments section$")
    public void theUserSeeNotesInTheAmendmentsSection() throws Throwable {
        assertTrue("The user do't see notes on document",
                provisionPage.isElementDisplayed(provisionPage.notePoint()));
    }

    @Then("^each note have a number and description$")
    public void eachNoteHaveANumberAndDescription() throws Throwable {
        assertTrue("The note doesn't have a number",
                provisionPageUtils.isTheNoteHaveANumberAndDescription());
    }

    @Then("^the note description contains links to internal documents$")
    public void theNoteDescriptionContainsLinksToInternalDocuments() throws Throwable {
        assertTrue("The note description don't contains links to internal documents",
                provisionPage.isElementDisplayed(provisionPage.linkInNoteDescription()));
    }

    @When("^the mouse move on footnote reference$")
    public void theMouseMoveOnFootnoteReference() throws Throwable {
        pageActions.mouseOver(provisionPage.footnoteReference());
    }

    @Then("^a lightbox will appear$")
    public void aLightboxWillAppear() throws Throwable {
        assertTrue("The lightbox didn't appear on document",
                provisionPage.isElementDisplayed(provisionPage.lightbox()));
    }

    @Then("^the text \"(.*?)\" will be displayed to the users$")
    public void theTextWillBeDisplayedToTheUsers(String lightboxText) throws Throwable {
        assertTrue("The text didnt' display to the user",
                provisionPage.isElementDisplayed(provisionPage.lightboxText(lightboxText)));
    }

    @Then("^the light box contains links to internal documents$")
    public void theLightBoxContainsLinksToInternalDocuments() throws Throwable {
        assertTrue("The text didnt' display to the user",
                provisionPage.isElementDisplayed(provisionPage.lightboxInternalLink()));
    }

    @When("^the user click on the link$")
    public void theUserClickOnTheLink() throws Throwable {
        url = provisionPageUtils.clickOnInternalLinkInLightbox();
    }
    
    @When("^the user clicks on \"(.*?)\" link$")
    public void theUserClicksOnLink(String linkText) {
        commonMethods.clickLink(linkText);
    }

}

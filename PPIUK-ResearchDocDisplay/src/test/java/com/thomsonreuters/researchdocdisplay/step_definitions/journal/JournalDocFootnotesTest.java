package com.thomsonreuters.researchdocdisplay.step_definitions.journal;

import static org.junit.Assert.assertTrue;

import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.JournalDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;
import com.thomsonreuters.researchdocdisplay.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

public class JournalDocFootnotesTest extends BaseStepDef {

	private JournalDocumentPage journalDocumentPage = new JournalDocumentPage();
	private AssetPageUtils assetPageUtils = new AssetPageUtils();
	private PageActions pageActions = new PageActions();
	private CommonMethods commonMethods = new CommonMethods();

	@When("^the user clicks on footnote link \"([^\"]*)\" in document$")
	public void theUserClicksOnFootnoteLinkInDocument(String number) {
		journalDocumentPage.footnoteNumberInDocument(number).click();
	}

	@Then("^the user is scrolled to footnote \"([^\"]*)\"$")
	public void theUserIsScrolledToFootnote(String number) {
		WebElement fn = journalDocumentPage.fullFootnoteInFootnotesSection(number);
		WebElement docHeader = journalDocumentPage.documentTitlePanel();

		boolean footnoteBelowHeader = journalDocumentPage.compareElementsLocationByHeight(docHeader, fn) < 0;
		boolean footnoteInViewport = journalDocumentPage.isViewScrolledToElement(fn);
		assertTrue("The footnote " + number + " is not in the visible area", footnoteBelowHeader && footnoteInViewport);
	}

	@When("^the user clicks on footnote link \"([^\"]*)\" in the footnotes section$")
	public void theUserClicksOnFootnoteLinkInFootnotes(String number) {
		journalDocumentPage.footnoteNumberInFootnotesSection(number).click();
	}

	@Then("^the user is scrolled to footnote link \"([^\"]*)\" in document$")
	public void theUserIsScrolledToFootnoteLinkInDoc(String number) {
		WebElement fn = journalDocumentPage.footnoteNumberInDocument(number);
		WebElement docHeader = journalDocumentPage.documentTitlePanel();

		boolean footnoteBelowHeader = journalDocumentPage.compareElementsLocationByHeight(docHeader, fn) < 0;
		boolean footnoteInViewport = journalDocumentPage.isViewScrolledToElement(fn);
		assertTrue("The footnote " + number + " is not in the visible area", footnoteBelowHeader && footnoteInViewport);
	}

	@When("^the user clicks on link in footnote \"([^\"]*)\" body in footnotes section$")
	public void theUserClicksOnLinkInFootnoteBodyInFootnotesSection(String number) {
		journalDocumentPage.linkInFootnoteBodyInFootnotesSection(number).click();
	}

	@Then("^document title is displayed as \"(.*?)\"$")
	public void titleIsDisplayedAs(String title) throws Throwable {
		assertTrue("Document title is not '" + title + "' but '" + journalDocumentPage.getPageTitle() + "'", journalDocumentPage
				.getPageTitle().contains(title));
	}

	@Then("^the source document with guid \"(.*?)\" remains open and new tab opens$")
	public void theSourceDocumentRemainsOpen(String guid) throws Throwable {
		assertTrue("The source document doesn't remain open", assetPageUtils.isTheSourceDocumentRemainsOpen(guid));
	}

	@Then("^the user is taken to \"(.*?)\" resource$")
	public void theUserIsTakenToResource(String linkText) throws Throwable {
		journalDocumentPage.waitForPageToLoad();
		assetPageUtils.getBaseParameters();
		assertTrue("The user doesn't taken to the selected resource", assetPageUtils.isTheUserTakenToTheSelectedResource(linkText));
	}

	@When("^the mouse moves over \"([^\"]*)\" Journal footnote reference$")
	public void theMouseMovesOnFootnoteReference(String number) throws Throwable {
		//scroll so that the necessary item is in view (should work for most numbers)
		if (Integer.valueOf(number) > 3) {
			commonMethods.moveToElementUsingJS(journalDocumentPage.footnoteNumberInDocument(String.valueOf(Integer.valueOf(number) - 3)));
		}
		pageActions.mouseOver(journalDocumentPage.footnoteNumberInDocument(number));
	}

	@When("^the user selects a link in light box$")
	public void theUserSelectsALinkInLightBox() throws Throwable {
		journalDocumentPage.clickOnLinkInLightBox();
	}
}

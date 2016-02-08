package com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document;

import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.common.WindowHandler;
import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.enums.DocumentSecondaryLink;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.enums.Jurisdiction;
import com.thomsonreuters.pageobjects.utils.document.DateFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;


import org.springframework.util.StringUtils;

/**
 * This Page object is to identify the Provision document elements and depicts
 * the page functionality.
 * <p/>
 */

public class ProvisionPage extends DocumentDisplayAbstractPage {

	public static final By DOC_TITLE = By.cssSelector("div.co_title");

	/**
	 * TODO: Need to add proper CSS for the selectors below.
	 */
	private static final By MODIFICATIONS_HEADER_LOCATOR = By
			.xpath(".//h2[contains(@class,'co_printHeading') and contains(text(),'Modifications')]");
	private static final By MODIFICATIONS_SECTION_LOCATOR = By
			.cssSelector(".//h2[contains(@class,'co_printHeading') and contains(text(),'Modifications')]/../..");
	private static final By TITLE_OF_THE_ACT_LOCATOR = By.cssSelector("");
	private static final By STATUS_LOCATOR = By.cssSelector("");
	private static final By PART_OF_THE_ACT_LOCATOR = By.cssSelector("");
	private static final By YEAR_OF_THE_ACT_LOCATOR = By.cssSelector("");
	private static final By INDIVIDUAL_SECTION_OF_THE_ACT_LOCATOR = By
			.cssSelector("");
	private static final By PROVISION_VERSION_LOCATOR = By.cssSelector("");
	private static final By PROVISION_EFFECTIVE_DATE_LOCATOR = By
			.cssSelector("");
	private static final By BACK_TO_DOCUMENT_LINK_LOCATOR = By.cssSelector("");
	private static final By SHOW_HIDE_BUTTON = By.cssSelector("");
	public static final String LEGISLATION_DOC_TYPE_LOCATOR = "div.co_title+div";

	private static final By MODIFICATION_LINK = By.linkText("Modifications");
	private static final By JURISDICTION_LINK = By
			.xpath(".//div[@id='kh_tocContainer']//a[@class='is-active']");

	private static final By LINK_UNDER_MODIFICATIONS = By
			.xpath(".//div[@id='co_docContentBody']/div/a[@class='co_link co_drag ui-draggable']");
	private static final By JURISDICTION_TEXT = By
			.xpath(".//*[@id='co_docContentBody']/div[@class='co_paragraph co_underline']/h2/strong");

	private static final By INTERNAL_LINK = By
			.xpath("//a[@class='co_link co_drag ui-draggable']");

	private static final By DOC_CONTENT = By.className("co_footnoteSection");
	private static final By NOTE_POINT = By
			.xpath(".//div[@class = 'co_paragraph']");
	private static final By DATE_TEXT_LOCATOR = By
			.xpath(".//*[@id='co_docContentMetaInfo']");

	private static final By TITLE_TEXT = By
			.xpath(".//h1[@class='co_title noTOC']");

	private static final By DOCUMENT_META_INFO = By.id("co_docContentMetaInfo");
	private static final By DOCUMENT_STATUS = By.xpath("//div");
	private static final By EFFECTIVE_DATE_ON_DOCUMENT = By.xpath("//div[@class='co_paragraph']");
	private static final By DOCUMENT_VERSION = By.xpath("//strong");
	private static final By SECTION_TEXT = By
			.xpath(".//div[@id='co_AnnotationDocumentSource']//h4");
	private static final By PARAGRAPHS_TEXT = By.className("co_paragraph");

	private static final By FOOTNOTE_REFERENCE = By.id("co_footnoteReference_1");
	private static final By LIGHTBOX = By.className("co_footnoteHoverTitle");

	private static final By LIGHTBOX_INTERNAL_LINK = By.id("co_link_N101EB");

	protected WindowHandler windowHandler;

	protected DateFormat dateFormat;

	protected PageActions pageActions;

	/**
	 * This method verifies given title is present in document header and
	 * returns the boolean value.
	 *
	 * @param title
	 * @return boolean
	 */

	@Override
	public boolean isDocumentHeaderPresent(String title) {
		if (StringUtils.isEmpty(title)) {
			throw new IllegalArgumentException(" Document Title is required.");
		}
		try {
			return waitForExpectedElement(DOC_TITLE).getText().contains(title);
		} catch (TimeoutException te) {
			LOG.info("context", te);
		}
		return false;
	}

	/**
	 * This method to identify whether modifications present for the particular
	 * provision or not.
	 *
	 * @return boolean
	 */
	public boolean isModificationsAvailable() {
		return (isModificationsHeaderPresent() && isModificationsSectionPresent());
	}

	/**
	 * This method does the verification of Modifications Section presence and
	 * returns the boolean value accordingly.
	 *
	 * @return boolean
	 */
	public boolean isModificationsSectionPresent() {
		try {
			return waitFluentForElement(MODIFICATIONS_SECTION_LOCATOR)
					.isDisplayed();
		} catch (TimeoutException te) {
			LOG.info("context", te);
		}
		return false;
	}

	/**
	 * This method does the verification of Modifications Header presence and
	 * returns the boolean value accordingly.
	 *
	 * @return boolean
	 */
	public boolean isModificationsHeaderPresent() {
		try {
			return waitFluentForElement(MODIFICATIONS_HEADER_LOCATOR)
					.isDisplayed();
		} catch (TimeoutException te) {
			LOG.info("context", te);
		}
		return false;
	}

	/**
	 * This method verifies the provision's title is displayed and returns the
	 * boolean value accordingly.
	 *
	 * @return boolean
	 */
	public boolean isTitleOfTheActDisplayed() {
		try {
			return waitForExpectedElement(TITLE_OF_THE_ACT_LOCATOR)
					.isDisplayed();
		} catch (TimeoutException te) {
			LOG.info("context", te);
		}
		return false;
	}

	/**
	 * This method verifies the provision's Year of the act is displayed and
	 * returns the boolean value accordingly.
	 *
	 * @return boolean
	 */
	public boolean isYearOfTheActDisplayed() {
		try {
			return waitForExpectedElement(YEAR_OF_THE_ACT_LOCATOR)
					.isDisplayed();
		} catch (TimeoutException te) {
			LOG.info("context", te);
		}
		return false;
	}

	/**
	 * This method verifies the provision's Part of the Act is displayed and
	 * returns the boolean value accordingly.
	 *
	 * @return boolean
	 */
	public boolean isPartOfTheActDisplayed() {
		try {
			return waitForExpectedElement(PART_OF_THE_ACT_LOCATOR)
					.isDisplayed();
		} catch (TimeoutException te) {
			LOG.info("context", te);
		}
		return false;
	}

	/**
	 * This method verifies the provision's Individual Section of the Act is
	 * displayed and returns the boolean value accordingly.
	 *
	 * @return boolean
	 */
	public boolean isIndividualSectionOfTheActDisplayed() {
		try {
			return waitForExpectedElement(INDIVIDUAL_SECTION_OF_THE_ACT_LOCATOR)
					.isDisplayed();
		} catch (TimeoutException te) {
			LOG.info("context", te);
		}
		return false;
	}

	/**
	 * This method verifies the provision's Status is displayed and returns the
	 * boolean value accordingly.
	 *
	 * @return boolean
	 */
	public boolean isStatusDisplayed() {
		try {
			return waitForExpectedElement(STATUS_LOCATOR).isDisplayed();
		} catch (TimeoutException te) {
			LOG.info("context", te);
		}
		return false;
	}

	/**
	 * This method verifies the provision's Version is displayed and returns the
	 * boolean value accordingly.
	 *
	 * @return boolean
	 */
	public boolean isVersionDisplayed() {
		try {
			return waitForExpectedElement(PROVISION_VERSION_LOCATOR)
					.isDisplayed();
		} catch (TimeoutException te) {
			LOG.info("context", te);
		}
		return false;
	}

	/**
	 * This method verifies the provision's Effective Date is displayed and
	 * returns the boolean value accordingly.
	 *
	 * @return boolean
	 */
	public boolean isProvisionEffectiveDateDisplayed() {
		try {
			return waitForExpectedElement(PROVISION_EFFECTIVE_DATE_LOCATOR)
					.isDisplayed();
		} catch (TimeoutException te) {
			LOG.info("context", te);
		}
		return false;
	}

	/**
	 * This method is to verify the given Jurisdiction links and blocks are
	 * present in the navigation and document as well.
	 *
	 * @param jurisdiction
	 * @return boolean
	 */
	public boolean isJuridictionsDisplayed(Jurisdiction jurisdiction) {
		if (jurisdiction == null) {
			throw new IllegalArgumentException("Jurisdiction name is required.");
		}

		if (isJurisdictionNavigationLinkDisplayed(jurisdiction)) {
			return (isJurisdictionBlockPresent(jurisdiction) && isJurisdictionDocumentLinksPresent(jurisdiction));
		} else {
			return isDocumentHeaderPresent(jurisdiction
					.getJurisdictionLinkName());
		}
	}

	/**
	 * This method does the verification of given jurisdiction navigation link
	 * is displayed or not.
	 *
	 * @param jurisdiction
	 * @return boolean
	 */
	public boolean isJurisdictionNavigationLinkDisplayed(
			Jurisdiction jurisdiction) {
		if (jurisdiction == null) {
			throw new IllegalArgumentException("Jurisdiction name is required.");
		}
		try {
			return waitForExpectedElement(
					jurisdiction.getJurisdictionNavigationLinkLocator())
					.isDisplayed();
		} catch (TimeoutException te) {
			LOG.info("context", te);
		}
		return false;
	}

	/**
	 * This method does the verification of given jurisdiction block is present
	 * or not in the document.
	 *
	 * @param jurisdiction
	 * @return boolean
	 */
	public boolean isJurisdictionBlockPresent(Jurisdiction jurisdiction) {
		if (jurisdiction == null) {
			throw new IllegalArgumentException("Jurisdiction name is required.");
		}
		try {
			return waitForExpectedElement(
					jurisdiction.getJurisdictionBlockLocator()).isDisplayed();
		} catch (TimeoutException te) {
			LOG.info("context", te);
		}
		return false;
	}

	/**
	 * This method does the verification of given jurisdiction document link is
	 * present or not in the document.
	 *
	 * @param jurisdiction
	 * @return boolean
	 */
	public boolean isJurisdictionDocumentLinksPresent(Jurisdiction jurisdiction) {
		if (jurisdiction == null) {
			throw new IllegalArgumentException("Jurisdiction name is required.");
		}
		try {
			return waitForExpectedElement(
					jurisdiction.getJurisdictionDocumentLinkLocator())
					.isDisplayed();
		} catch (TimeoutException te) {
			LOG.info("context", te);
		}
		return false;
	}

	/**
	 * This method verifies the given internal/external link is present or not
	 * inside the Annotations block and returns the boolean value accordingly.
	 *
	 * @param link
	 * @return boolean
	 */
	public boolean isLinkPresentInAnnotations(String link) {
		if (StringUtils.isEmpty(link)) {
			throw new IllegalArgumentException(
					" Internal/External link name is required.");
		}
		try {
			return getDisplayedBlockElement(DocumentSecondaryLink.ANNOTATIONS)
					.findElement(By.linkText("link")).isDisplayed();
		} catch (PageOperationException pe) {
			LOG.info("context", pe);
		}
		return false;
	}

	/**
	 * This method does the selection of the given internal/external present in
	 * the Annotations block.
	 *
	 * @param link
	 */
	public void selectLinkInAnnotations(String link) {
		if (StringUtils.isEmpty(link)) {
			throw new IllegalArgumentException(
					" Internal/External link name is required.");
		}
		getDisplayedBlockElement(DocumentSecondaryLink.ANNOTATIONS)
				.findElement(By.linkText(link)).click();
	}

	/**
	 * This method verifies the New Browser is opened with the given link name
	 * and returns the boolean value accordingly. As an extra step, this method
	 * is closing the new window to make sure the functionality continues with
	 * the actual window session.
	 *
	 * @param link
	 * @return
	 */
	public boolean isNewBrowserOpenedWithExternalLink(String link) {
		if (StringUtils.isEmpty(link)) {
			throw new IllegalArgumentException(
					" External link name is required.");
		}

		try {
			windowHandler.switchWindow(link);
			windowHandler.closeWindow(link);
			return true;
		} catch (Exception t) {
			LOG.info("context", t);
		}
		return false;
	}

	/**
	 * This method is to verify the given child link's section is expanded or
	 * not on the right hand side of the document area.
	 *
	 * @param childLink
	 * @return boolean
	 */
	public boolean iSectionExpanded(String childLink) {
		if (StringUtils.isEmpty(childLink)) {
			throw new IllegalArgumentException(" ChildLink name is required.");
		}
		DocumentSecondaryLink.getLink(childLink);
		/**
		 * TODO: This is the pageobjects method for every section expanded or not
		 * verification, so based on given link name find out the corresponding
		 * section has expanded or not.
		 */
		return false;
	}

	/**
	 * This methos is to verify the show/hide button present or not on the child
	 * link section on the document.
	 *
	 * @param childLink
	 * @return boolean
	 */
	public boolean iShowHideButtonPresent(String childLink) {
		if (StringUtils.isEmpty(childLink)) {
			throw new IllegalArgumentException(" ChildLink name is required.");
		}

		try {
			return getDisplayedBlockElement(
					DocumentSecondaryLink.valueOf(childLink)).findElement(
					SHOW_HIDE_BUTTON).isDisplayed();
		} catch (TimeoutException pe) {
			LOG.info("context", pe);
		}
		return false;
	}

	/**
	 * This method does the selection of the show/hide button present on child
	 * link section.
	 *
	 * @param childLink
	 */
	public void clickOnShowHideButton(String childLink) {
		if (StringUtils.isEmpty(childLink)) {
			throw new IllegalArgumentException(" ChildLink name is required.");
		}

		try {
			getDisplayedBlockElement(DocumentSecondaryLink.valueOf(childLink))
					.findElement(SHOW_HIDE_BUTTON).click();
		} catch (TimeoutException pe) {
			throw new PageOperationException(
					"Exceeded time to find the ShowHideButton link on :"
							+ childLink);
		}
	}

	/**
	 * This method is to verify the Back to document link is present on the
	 * General notes section.
	 *
	 * @return boolean
	 */
	public boolean isBackToPrimaryLegislationDocumentFromNotesLink() {
		try {
			return waitForElementPresent(BACK_TO_DOCUMENT_LINK_LOCATOR)
					.isDisplayed();
		} catch (TimeoutException pe) {
			LOG.info("context", pe);
		}
		return false;
	}

	/**
	 * This method is to select the Back to document link present on the General
	 * notes section.
	 */
	public void clickOnBackToMainDocument() {
		try {
			waitForElementPresent(BACK_TO_DOCUMENT_LINK_LOCATOR).click();
		} catch (TimeoutException pe) {
			throw new PageOperationException(
					"Exceeded time to find the BackToDocument link :"
							+ BACK_TO_DOCUMENT_LINK_LOCATOR);
		}
	}

	/**
	 * This method is to verify the given internal link is present on provision
	 * modifications section.
	 *
	 * @param link
	 * @return boolean
	 */
	public boolean isLinkPresentInModifications(String link) {
		if (StringUtils.isEmpty(link)) {
			throw new IllegalArgumentException(
					" Internal/External name is required.");
		}

		try {
			return getDisplayedBlockElement(DocumentSecondaryLink.MODIFICATIONS)
					.findElement(By.linkText(link)).isDisplayed();
		} catch (PageOperationException pe) {
			LOG.info("context", pe);
		}
		return false;
	}

	/**
	 * This method is to click on given link present on the provision
	 * modifications section.
	 *
	 * @param link
	 */
	public void selectLinkInModifications(String link) {
		if (StringUtils.isEmpty(link)) {
			throw new IllegalArgumentException(
					" Internal/External name is required.");
		}

		getDisplayedBlockElement(DocumentSecondaryLink.MODIFICATIONS)
				.findElement(By.linkText(link)).click();
	}

	/**
	 * This method does the verification of Modifications Header presence and
	 * returns the boolean value accordingly.
	 *
	 * @return boolean
	 */
	public boolean isBlockPresentInDocument(String sectionName) {
		try {
			waitFluentForElement(By
					.xpath(".//h2[contains(@class,'co_printHeading') and contains(text(),'"
							+ sectionName + "')]"));
			return true;
		} catch (TimeoutException te) {
			LOG.info("context", te);
		}
		return false;
	}

	public void clickOnBlockHeader(String sectionName) {
		if (StringUtils.isEmpty(sectionName)) {
			throw new IllegalArgumentException(" Section Name is required.");
		}
		try {
			waitFluentForElement(
					By.xpath(".//h2[contains(@class,'co_printHeading') and contains(text(),'"
							+ sectionName + "')]")).click();
		} catch (TimeoutException pe) {
			LOG.info("context", pe);
			throw new PageOperationException("Exceeded time to find the "
					+ sectionName + " Block in the document");
		}
	}

	public boolean isExpandAndCollapsePresentOnNavigationPrimaryLink(
			String primaryMenu) {
		if (StringUtils.isEmpty(primaryMenu)) {
			throw new IllegalArgumentException(" PrimaryMenu name is required.");
		}
		try {
			return waitFluentForElement(By.xpath("")).isDisplayed(); // Todo
																		// find
																		// an
																		// pageobjects
																		// way
																		// to
																		// find
																		// out
																		// the
																		// primary
																		// navigation
																		// link
																		// and
																		// find
																		// the
																		// expand
																		// and
																		// collapse
																		// link
																		// element.
		} catch (TimeoutException te) {
			LOG.info("context", te);
		}
		return false;
	}

	/**
	 * This method verifies the given document is legislation type or not and
	 * returns the boolean value accordingly.
	 *
	 * @param docType
	 * @return boolean
	 */
	public boolean isProvisionDocument(String docType) {
		if (StringUtils.isEmpty(docType)) {
			throw new IllegalArgumentException(" PrimaryMenu name is required.");
		}
		try {
			return waitForExpectedElement(
					By.cssSelector(LEGISLATION_DOC_TYPE_LOCATOR)).getText()
					.contains(docType);
		} catch (TimeoutException te) {
			LOG.info("context", te);
		}
		return false;
	}

	/**
	 * This method verifies whether the image is displayed on provision or not.
	 *
	 * @return boolean
	 */
	public boolean isImageDisplayedOnProvision() {
		try {
			return waitForExpectedElement(
					By.cssSelector("img[alt='inline image']")).isDisplayed();
		} catch (TimeoutException te) {
			LOG.info("context", te);
		}
		return false;
	}

	public WebElement linkUnderModofocation() {
		return waitForExpectedElement(LINK_UNDER_MODIFICATIONS);
	}

	public WebElement modificationLink() {
		return waitForExpectedElement(MODIFICATION_LINK);
	}

	public WebElement jurisdictionLink() {
		return retryingFindElement(JURISDICTION_LINK);
	}

	public WebElement jurisdictionText() {
		return retryingFindElement(JURISDICTION_TEXT);
	}

	public WebElement amendmentText(String amendmentsText) {
		return findChildElement(docContent(), By.xpath("//h2[contains(text(),'" + amendmentsText+ "')]"));	
	}

	public WebElement docContent() {
		return retryingFindElement(DOC_CONTENT);
	}

	public WebElement notePoint() {
		return findChildElement(docContent(), NOTE_POINT);
	}

	public WebElement noteNumber() {
		return findChildElement(notePoint(), By.className("co_footnoteNumber"));
	}

	public WebElement amendmentsLink(String amendmentsLink) {
		return retryingFindElement(By.linkText(amendmentsLink));
	}

	public WebElement dateText() {
		return waitForExpectedElement(DATE_TEXT_LOCATOR);
	}

	public WebElement titleText() {
		return retryingFindElement(TITLE_TEXT);
	}

	public WebElement annotatedStatutesLink(String linkName) {
		return retryingFindElement(By.linkText(linkName));
	}

	public WebElement annotatedStatuesText(String annotatedStatusText) {
		return retryingFindElement(By.xpath("//h2[contains(text()," + "'" + annotatedStatusText + "'" + ")]"));
	}

	public WebElement sectionText() {
		return retryingFindElement(SECTION_TEXT);
	}

	public WebElement paragraphsText() {
		return retryingFindElement(PARAGRAPHS_TEXT);
	}

	public WebElement footnoteReference() {
		return retryingFindElement(FOOTNOTE_REFERENCE);
	}

	public WebElement lightbox() {
		return retryingFindElement(LIGHTBOX);
	}
	
	public WebElement lightboxText(String lightboxText) {
		return findChildElement(lightbox(), By.xpath("//span[contains(text()," + "'" + lightboxText + "'" + ")]"));
	}
	

	public WebElement lightboxInternalLink() {
		return retryingFindElement(LIGHTBOX_INTERNAL_LINK);
	}

	public WebElement jumpLink(String jumpLinkText) {
		return retryingFindElement(By.xpath(".//a[contains(text()," + "'" + jumpLinkText + "'" + ")]"));
	}

	public WebElement jumpLinkText(String jumpLinkText) {
		return retryingFindElement(By.xpath(".//h2[contains(text()," + "'" + jumpLinkText + "'" + ")]"));
	}
	
	public WebElement documentMetaInfo() {
		return retryingFindElement(DOCUMENT_META_INFO);
	}
	
	public WebElement documentStatus() {
		return findChildElement(documentMetaInfo(), DOCUMENT_STATUS);
	}
	
	public WebElement effectiveDate() {
		return findChildElement(documentMetaInfo(), EFFECTIVE_DATE_ON_DOCUMENT);
	}
	
	public WebElement documentVersion() {
		return findChildElement(documentMetaInfo(), DOCUMENT_VERSION);
	}
	
	public WebElement noteDescription() {
		return findChildElement(notePoint(), By.className("co_footnoteBody"));
	}
	
	public WebElement linkInNoteDescription() {
		return findChildElement(docContent(), INTERNAL_LINK);
	}
	
	public void clickOnAnnotatedStatutesMenuLink(String linkName) {
		annotatedStatutesLink(linkName).click();
	}
	
	public boolean isModificationsOnDocumentDispleyed() {
		waitForPageToLoad();
		return isElementDisplayed(modificationLink());
	}

	public boolean isMdificationsContainLinksToOtherDocuments() {
		modificationLink().click();
		return isElementDisplayed(linkUnderModofocation());
	}

	public String clickOnLink() {
		String firstTitle = getPageTitle();
		linkUnderModofocation().click();
		return firstTitle;
	}
	
}
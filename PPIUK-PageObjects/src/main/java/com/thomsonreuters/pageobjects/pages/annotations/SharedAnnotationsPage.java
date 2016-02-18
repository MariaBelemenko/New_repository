package com.thomsonreuters.pageobjects.pages.annotations;

import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.*;


import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * This page object is to depict the annotations blocks present on document page and this class holds the elements and functions to handle the annotations operations.
 *
 * Created by UC186961 on 17/08/2015.
 */

public class SharedAnnotationsPage extends AbstractPage {

    public static final int TIMEOUT_2_SECONDS = 2;
    public static final int TIMEOUT_5_SECONDS = 5;
    private By IFRAME_LOCATOR = By.cssSelector("div.co_dropdownBoxExpanded .co_richEditor.co_noteArea.mce-content-body");
    private int urlFindingCount = 0;

    private TinyMceEditor tinyMceEditor;

    public SharedAnnotationsPage(){
        tinyMceEditor = new TinyMceEditor();
    }

    /*
     *  This enum is used for elements visiblity.
     */
    public enum ExpectedResult {
        VISIBLE,
        NOT_VISIBLE;
    }

    /**
     * This method is to verify the annotations textbox is displayed or not.
     *
     * @return boolean
     */
    public boolean isTextBoxDisplayed() {
        try {
            return waitForExpectedElement(IFRAME_LOCATOR, TIMEOUT_5_SECONDS).isDisplayed();

        } catch (TimeoutException te) {
            return false;
        }
    }

    /**
     * This method is to clear the existing text on it and inserts the given input value into the annotations textbox present on tinymce editor
     *
     * @param input
     */
    public void insertInput(String input) {
        tinyMceEditor.clearAll();
        tinyMceEditor.addContent(input);
    }

    /**
     * This private method is used to find the warning message presence on document and returns the boolean value accordingly.
     *
     * @return boolean
     */
    private boolean isWarningMessagePresent() {
        try {
            return getWarningMessageOKButton().isDisplayed();
        } catch (TimeoutException te) {
            return false;
        }
    }

    /**
     * This private method is to get the displayed warning message webelement on document.
     *
     * @return WebElement
     */
    private WebElement getWarningMessageOKButton() {
        try {
            return waitForExpectedElement(By.cssSelector(".co_overlayBox_optionsBottom .co_NotesLightBox_okbutton"), TIMEOUT_2_SECONDS);
        } catch (TimeoutException te) {
            throw new PageOperationException("Exceeded time to find the Annotations Warning message ok button" + te.getMessage());
        }
    }

    /**
     * This method does the inserting the given input value into WLN annotations textbox.
     *
     * @param input
     */
    public void insertInputInWLNAnnotationTextBox(String input) {
        try {
            retryingFindElement(By.cssSelector(".co_noteArea")).sendKeys(input);
        } catch (PageOperationException te) {
            throw new PageOperationException("Exceeded time to find the Annotations text box in WLN" + te.getMessage());
        }
    }

    /**
     * This method is to adds the given input value to existing text presents in the annotations textbox.
     *
     * @param input
     */
    public void amendInput(String input) {
        tinyMceEditor.addContent(input);
    }

    /**
     * Saves the annotation and waits until the document is loaded with all elements.
     */
    public void saveAnnotation() {
        try {
            WebElement saveButton = retryingFindElement(By.cssSelector("input[value='Save']"));
            saveButton.click();
            waitForElementInvisible(By.id(saveButton.getAttribute("id")));
            waitForPageToLoad();
            waitForPageToLoadAndJQueryProcessing();
        } catch (PageOperationException | TimeoutException te) {
            throw new PageOperationException("Exceeded time to find the save button" + te.getMessage());
        }
    }

    /**
     * Finding the save button enabled or note - returns true if save button is enabled otherwise false.
     *
     * @return boolean
     */
    public boolean isSaveAnnotationEnabled() {
        try {
            return waitForExpectedElement(By.cssSelector("input[value='Save']"), TIMEOUT_5_SECONDS).isEnabled();
        } catch (TimeoutException te) {
            return false;
        }
    }

    /**
     * This method is to select the cancel button present on new/edit annotations.
     */
    public void cancelSavingAnnotation() {
        try {
            waitForExpectedElement(By.linkText("Cancel")).click();
        } catch (TimeoutException te) {
            throw new PageOperationException("Exceeded time to find the cancel button" + te.getMessage());
        }
    }

    /**
     * Verifies the sharing social icon visibility based on the given annotations text.
     * Returns true if icon is visible beside of the annotation created by value otherwise false
     *
     * @param input
     * @return boolean
     */
    public boolean isSharingIconVisible(String input) {
        try {
            return waitForElementPresent(By.xpath("//div[@class='co_viewNoteText mce-content-body']/p[text()='" + input + "']/../../div[@class='co_noteHeader']/div/div[contains(@class,'icon_people')]")).isDisplayed();
        } catch (TimeoutException te) {
            return false;
        }
    }

    /**
     * Verifies the saved annotation is displayed back on document annotations list or not.
     * Returns true if annotations is displayed otherwise false
     *
     * @return boolean
     */
    public boolean isAnnotationsDisplayed() {
        try {
            return waitForExpectedElement(By.cssSelector(".co_viewNoteText.mce-content-body"), TIMEOUT_5_SECONDS).isDisplayed();
        } catch (TimeoutException te) {
            return false;
        }
    }

    /**
     * Verifies the annotations count is displayed on show/hide icon.
     * Returns true if annotations count is displayed otherwise false
     *
     * @return boolean
     */
    public boolean isAnnotationsCountDisplayed() {
        try {
            return retryingFindElement(By.id("co_ToggleAnnotationCount")).isDisplayed();
        } catch (PageOperationException poe) {
            return false;
        }
    }

    /**
     * Gets the displayed Notes count value on show/hide notes icon.
     *
     * @return int
     */
    public int getNotesCountFromShowAndHideIcon() {
        try {
            return Integer.parseInt(retryingFindElement(By.id("co_ToggleAnnotationCount")).getText());
        } catch (PageOperationException | NumberFormatException poe) {
        }
        return 0;
    }

    /**
     * Gets the displayed total doc level notes elements count.
     *
     * @return int
     */
    public int getTotalNotesOnDocument() {
        return getInlineNotesCount() + getAnnotationsElements().size();
    }

    /**
     * Gets the displayed total inline notes elements count.
     *
     * @return int
     */
    private int getInlineNotesCount() {
        try {
            return retryingFindElements(By.cssSelector("span.co_noteHolderActive>div.co_hideState+a[title='Minimize']")).size();
        } catch (PageOperationException poe) {
        }
        return 0;
    }

    /**
     * This does the deletion of the all inline notes present on document.
     */
    public void deleteInlineAnnotations() {
        try {
            for (WebElement inlineNote : retryingFindElements(By.cssSelector("span.co_noteHolderActive>div.co_hideState+a[title='Minimize']"))) {
                inlineNote.click();
                WebElement ele = inlineNote.findElement(By.xpath("./.."));
                ele.findElement(By.className("co_viewNote")).click();
                getDeleteElement().click();
                if (isUndoButtonDisplayed() && isCloseButtonDisplayed()) {
                    try {
                        waitForElementInvisible(By.id(inlineNote.getAttribute("id")));
                    } catch (StaleElementReferenceException sle) {
                        LOG.warn("Inline note is not visible");
                    }
                }
            }
        } catch (PageOperationException | NoSuchElementException te) {
            throw new PageOperationException("Unable to select delete icon on inline note : ");
        }
    }

    /**
     * Verifies the paragraph style is added to entered text in notes textbox.
     * Returns true if paragraph is default style otherwise false
     *
     * @return boolean
     */
    public boolean isParagraphStyleAddedAsDefault(String input) {
        try {
            return waitForExpectedElement(By.xpath("//p[text()='" + input + "']")).isDisplayed();
        } catch (TimeoutException | NoSuchElementException te) {
            return false;
        }
    }


    /**
     * Verifies the given input annotation is displayed or not after saving it and
     * depends on the given ExpectedResult enum value the way of finding will be vary to save the waiting time.
     * Returns true if annotation is as expected result value otherwise false
     *
     * @return boolean
     */
    public boolean isSavedAnnotationDisplayed(String input, ExpectedResult result) {
        try {
            if (result.equals(ExpectedResult.VISIBLE)) {
                return waitForElementPresent(By.xpath("//div[@class='co_viewNoteText mce-content-body']/p[text()='" + input + "']")).isDisplayed();
            } else if (result.equals(ExpectedResult.NOT_VISIBLE)) {
                return findElement(By.xpath("//div[@class='co_viewNoteText mce-content-body']/p[text()='" + input + "']")).isDisplayed();
            }
        } catch (TimeoutException | NoSuchElementException te) {
        } catch (StaleElementReferenceException sle) {
            isSavedAnnotationDisplayed(input, result);
        }
        return false;
    }

    /**
     * Verifies the given input annotation is displayed or not in wln application
     * Returns true if annotation is displayed otherwise false
     *
     * @return boolean
     */
    public boolean isSavedAnnotationDisplayedInWLN(String input) {
        try {
            for (WebElement element : retryingFindElements(By.cssSelector(".co_viewNoteText"))) {
                if (element.getText().contains(input)) {
                    return true;
                }
            }
        } catch (PageOperationException te) {
        }
        return false;
    }

    /**
     * Verifies the given input annotation is displayed as link.
     * Returns true if annotation text link is displayed otherwise false
     *
     * @param input
     * @return boolean
     */
    public boolean isSavedAnnotationTextDisplayedAsLink(String input) {
        try {
            return waitForElementPresent(By.xpath("//div[@class='co_viewNoteText mce-content-body']/p/a[text()='" + input + "']")).isDisplayed();
        } catch (TimeoutException te) {
            return false;
        }
    }

    /**
     * Verifies the given input annotation is displayed with link as part of its text.
     * Returns true if annotation text link is displayed otherwise false
     *
     * @param textOrUrl
     * @return boolean
     */
    public boolean isSavedAnnotationTextDisplayedWithLink(String textOrUrl) {
        try {
            return waitForElementPresent(By.xpath("//div[@class='co_viewNoteText mce-content-body']/p[contains(text(),'" + textOrUrl + "')]")).isDisplayed();
        } catch (TimeoutException te) {
            return false;
        }
    }

    /**
     * Verifies the given input annotation is saved and displayed with selected style formattype.
     * depends on the given ExpectedResult enum value the way of finding will be vary to save the waiting time.
     * Returns true if selected style formatted annotation is displayed otherwise false
     *
     * @param formatType
     * @param result
     * @param input
     * @return boolean
     */
    public boolean isSavedAnnotationDisplayedWithSelectedStyle(FormatType formatType, ExpectedResult result, String... input) {
        try {
            for (String text : input) {
                if (ExpectedResult.VISIBLE.equals(result)) {
                    if (!waitForElementPresent(By.xpath(String.format("//div[@class='co_viewNoteText mce-content-body']" + formatType.getSavedTextCSS(), input))).isDisplayed()) {
                        return false;
                    }
                } else if (ExpectedResult.NOT_VISIBLE.equals(result)) {
                    if (!findElement(By.xpath(String.format("//div[@class='co_viewNoteText mce-content-body']" + formatType.getSavedTextCSS(), input))).isDisplayed()) {
                        return false;
                    }
                }
            }
            return true;
        } catch (TimeoutException | NoSuchElementException te) {
            return false;
        }
    }

    /**
     * This method is to verify the complete metadata of the given annotation text.
     * And returns the boolean value is true if metadata is displayed otherwise false.
     *
     * @param input
     * @return boolean
     */
    public boolean isMetaDataDispalyed(String input) {

        List<WebElement> list = getAnnotationsElements();
        AnnotationMetaData metaData = null;
        Iterator<WebElement> iterator = list.iterator();

        while (iterator.hasNext()) {
            WebElement element = (WebElement) iterator.next();
            if (element.getText().contains(input)) {
                metaData = new AnnotationMetaData(element.findElement(By.xpath("./..")));
                break;
            }
        }

        try {
            if (metaData != null) {
                if (!StringUtils.isEmpty(metaData.getDate()) && !StringUtils.isEmpty(metaData.getTime()) && !StringUtils.isEmpty(metaData.getCreatedBy())) {
                    return true;
                } else {
                    LOG.warn("Meta data is missing for annotations.");
                }
            }
        } catch (PageOperationException te) {
        }
        return false;
    }

    /**
     * This method is to select the existing annotation and makes it editable.
     *
     * @param input
     */
    public void selectEditMode(String input) {
        try {
            for (WebElement element : getAnnotationsElements()) {
                if (element.getText().contains(input)) {
                    element.click();
                    break;
                }
            }
        } catch (StaleElementReferenceException se) {
            selectEditMode(input);
        }
    }

    /**
     * Returns the boolean value if given input annotation is editable otherwise false.
     *
     * @param input
     * @return boolean
     */
    public boolean isEditModeDisplayedWithText(String input) {
        try {
            WebElement element = retryingFindElement(IFRAME_LOCATOR);
            if (element.isDisplayed()) {
                return tinyMceEditor.getText().equals(input);
            }
        } catch (TimeoutException te) {
        }
        return false;
    }


    /**
     * Verifies the given input annotation delete icon is displayed.
     * Returns true if annotation delete link is displayed otherwise false
     *
     * @param input
     * @return boolean
     */
    public boolean isDeleteIconDisplayedOnAnnotation(String input) {
        try {
            getDeleteElement();
            return true;
        } catch (PageOperationException te) {
        }
        return false;
    }

    /**
     * Gets the delete icon element on editable annotation textbox
     *
     * @return webelement
     */
    private WebElement getDeleteElement() {
        return retryingFindElement(By.xpath("//div[@class='co_dropdownBoxExpanded'][contains(@style,'visible')]//a[@class='co_noteDelete']"));
    }

    /**
     * Deletes the given annotation
     *
     * @param input
     */
    public void deleteAnnotation(String input) {
        try {
            getDeleteElement().click();
        } catch (PageOperationException te) {
            throw new PageOperationException("Unable to select delete icon on annotation : " + input + " - " + te.getMessage());
        } catch (WebDriverException we) {
            deleteAnnotation(input);
        }
    }

    /**
     * Deletes all annotations for the given user
     *
     * @param user
     */
    public void deleteAllAnnotations(String user) {
        AnnotationMetaData metaData = null;
        try {
            for (WebElement element : getAnnotationsElements()) {
                metaData = new AnnotationMetaData(element.findElement(By.xpath("./..")));
                if (metaData.getCreatedBy().equals(user)) {
                    element.click();
                    getDeleteElement().click();
                    if (isUndoButtonDisplayed() && isCloseButtonDisplayed()) {
                        try {
                            waitForElementInvisible(By.id(element.getAttribute("id")));
                        } catch (StaleElementReferenceException sle) {
                        }
                    }
                }
            }
        }catch(StaleElementReferenceException sle){
            deleteAnnotation(user);
        }catch (PageOperationException te) {
            throw new PageOperationException("Unable to select delete icon on annotations : ");
        }
    }

    /**
     * Gets all annotations present in doc level.
     *
     * @return List<WebElement>
     */
    private List<WebElement> getAnnotationsElements() {
        int count = 0;
        try {
            WebElement element = null;
            try {
                element = waitForExpectedElement(By.cssSelector(".co_viewNoteText.mce-content-body"), TIMEOUT_5_SECONDS);
            } catch (TimeoutException te) {
            }
            if (element != null && element.isDisplayed()) {
                return waitForExpectedElements(By.cssSelector(".co_viewNoteText.mce-content-body"), TIMEOUT_5_SECONDS);
            }
        } catch (TimeoutException te) {
            if (count < 3) {
                getAnnotationsElements();
            }
            count++;
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * Verifies the given deleted annotation is displayed again.
     * Returns true if delted annotation is displayed otherwise false
     *
     * @param message
     * @return boolean
     */
    public boolean isDeleteNotesDisplayed(String message) {
        try {
            return retryingFindElement(By.cssSelector(".co_notes .co_infoBox_message")).getText().contains(message);
        } catch (PageOperationException te) {
        }
        return false;
    }

    /**
     * Verifies the Undo button is displaed after delete operation successful.
     * Returns true if undo button is displayed otherwise false
     *
     * @return boolean
     */
    public boolean isUndoButtonDisplayed() {
        try {
            return retryingFindElement(By.className("co_notes_undoLink")).isDisplayed();
        } catch (PageOperationException te) {
        }
        return false;
    }

    /**
     * Verifies the Close button is displaed after delete operation successful.
     * Returns true if close button is displayed otherwise false
     *
     * @return boolean
     */
    public boolean isCloseButtonDisplayed() {
        try {
            return retryingFindElement(By.className("co_notes_closeLink")).isDisplayed();
        } catch (PageOperationException te) {
        }
        return false;
    }

    /**
     * Clicking on undo delete button to undo the deleted annotation.
     */
    public void undoDelete() {
        try {
            retryingFindElement(By.className("co_notes_undoLink")).click();
        } catch (PageOperationException te) {
            throw new PageOperationException("Unable to select undo icon on: " + te.getMessage());
        }
    }

    /**
     * Closes down the delete successful message.
     */
    public void closeDeleteMessage() {
        try {
            retryingFindElement(By.className("co_notes_closeLink")).click();
        } catch (PageOperationException te) {
            throw new PageOperationException("Unable to select close icon on: " + te.getMessage());
        }
    }

    /**
     * Verifies the Contacts Link is displayed under the annotations textbox.
     * Returns true if link is displayed otherwise false
     *
     * @return boolean
     */
    public boolean isContactsLinkDisplayed() {
        try {
            return retryingFindElement(By.cssSelector("#sharedNotesHyperlink #contactsId")).isDisplayed();
        } catch (PageOperationException te) {
        }
        return false;
    }

    /**
     * Verifies the Previous Contacts Link is displayed under the annotations textbox.
     * Returns true if link is displayed otherwise false
     *
     * @return boolean
     */
    public boolean isPreviousContactsLinkDisplayed() {
        try {
            return retryingFindElement(By.cssSelector("#sharedNotesHyperlink #previousId")).isDisplayed();
        } catch (PageOperationException te) {
        }
        return false;
    }

    /**
     * Clicks on contacts link present under the annotation.
     */
    public void clickOnContactsLink() {
        try {
            retryingFindElement(By.cssSelector("#sharedNotesHyperlink #contactsId")).click();
        } catch (PageOperationException te) {
            throw new PageOperationException("Unable to clickon Contacts link. " + te.getMessage());
        }
    }

    /**
     * Verifies the Contacts And Groups popup page is displayed when clicking on contacts link.
     * Returns true if popup page is displayed otherwise false
     *
     * @return boolean
     */
    public boolean isContactsGroupsPageDisplayed() {
        try {
            return retryingFindElement(By.cssSelector("#sharedNotesHyperlink #previousId")).isDisplayed();
        } catch (PageOperationException te) {
        }
        return false;
    }

    /**
     * Search for the given contact name in the contacts and groups popup page.
     *
     * @param contact
     */
    public void searchContact(String contact) {
        try {
            WebElement element = waitFluentForElement(By.id("coid_contacts_people_searchBoxInput_contacts"));
            element.clear();
            element.sendKeys(contact);
        } catch (TimeoutException te) {
            throw new PageOperationException("Exceeded time to find the search box. " + te.getMessage());
        }
    }

    /**
     * Returns the entered text in annotations tinymce text editor.
     *
     * @return String
     */
    public String getText() {
        return tinyMceEditor.getText();
    }

    /**
     * Verifies that given contact has found or not in  Contacts And Groups popup page.
     * Returns true if given contact found otherwise false
     *
     * @param contact
     * @return boolean
     */
    public boolean isContactFoundInSearch(String contact) {
        try {
            for (WebElement result : retryingFindElements(By.cssSelector("#coid_contacts_peopleListItems_contacts a[role='checkbox']"))) {
                if (contact.equals(result.getText())) {
                    return true;
                }
            }
        } catch (PageOperationException te) {
        } catch(StaleElementReferenceException sle){
            isContactFoundInSearch(contact);
        }
        return false;
    }

    /**
     * Searches the given group name in Groups list.
     *
     * @param group
     */
    public void searchGroup(String group) {
        try {
            WebElement element = waitFluentForElement(By.id("coid_contacts_groups_searchBoxInput"));
            element.clear();
            element.sendKeys(group);
        } catch (TimeoutException te) {
            throw new PageOperationException("Exceeded time to find the search box. " + te.getMessage());
        }
    }

    /**
     * Verifies that given group name has found or not in Groups popup page.
     * Returns true if given group found otherwise false
     *
     * @param group
     * @return boolean
     */
    public boolean isGroupFoundInSearch(String group) {
        try {
            for (WebElement result : retryingFindElements(By.cssSelector("#coid_contacts_groupsListItems a[role='checkbox']"))) {
                if (group.equals(result.getText())) {
                    return true;
                }
            }
        } catch (PageOperationException te) {
        } catch (StaleElementReferenceException ste) {
            isGroupFoundInSearch(group);
        }
        return false;
    }

    /**
     * Verifies that client id value is not displayed on saved annotation
     * Returns true if client id found otherwise false
     *
     * @param input
     * @return boolean
     */
    public boolean verifyClientIDNotDisplayed(String input) {
        try {
            return waitForExpectedElement(By.xpath(".//div[@class='co_viewNoteText mce-content-body']/p[text()='" + input + "']/.."), TIMEOUT_5_SECONDS).findElement(By.className("co_noteHeader_clientID")).isDisplayed();
        } catch (TimeoutException | NoSuchElementException te) {
            return true;
        }
    }

    /**
     * Selects given format type in tinymce editro.
     *
     * @param formatType
     */
    public void selectStyle(FormatType formatType) {
        tinyMceEditor.selectStyle(formatType);
    }

    /**
     * Selects the given format group name from Formats Menu.
     *
     * @param styleGroupName
     */
    public void selectStyleGroupFromFormatsMenu(String styleGroupName) {
        tinyMceEditor.openFormatsMenu();
        tinyMceEditor.selectStylesMenuItem(styleGroupName);
    }

    /**
     * Verifies that Saved annotation is displayed with applied format style.
     * Returns true if expected formatted text found otherwise false
     *
     * @param formatType
     * @param text
     * @return boolean
     */
    public boolean isAnnoatationsTextDisplayedWithCharacterStyle(FormatType formatType, String... text) {
        return tinyMceEditor.isAnnoatationsTextDisplayedWithCharacterStyle(formatType, text);
    }

    /**
     * Select the text entered in tinymce text editor.
     */
    public void selectText() {
        tinyMceEditor.selectTextFromEditor();
    }

    /**
     * Verifies that Formats menu style is selected in tinymce editor.
     * Returns true if format type is selected otherwise false
     *
     * @param formatType
     * @return boolean
     */
    public boolean isLinkOptionSelected(FormatType formatType) {
        try {
            return waitForExpectedElement(formatType.getStyleLocator()).findElement(By.xpath(".//../..")).getAttribute("class").contains("mce-active");
        } catch (TimeoutException te) {
        }
        return false;
    }

    /**
     * Removes the entered text and styles from tinymce editor.
     */
    public void clearAll() {
        tinyMceEditor.clearAll();
    }

    /**
     * Verifies that Formats menu is selected in tinymce editor.
     * Returns true if format menu is selected otherwise false
     *
     * @param style
     * @return boolean
     */
    public boolean isMenuOptionSelected(String style) {
        try {
            for (WebElement element : waitForExpectedElements(By.cssSelector(".mce-menu-item.mce-active"))) {
                if (element.getText().contains(style)) {
                    return true;
                }
            }
        } catch (TimeoutException te) {
        }
        return false;
    }

    /**
     * Common method to find out the given formattype link is enabled or not on tinymce editor.
     * Returns true if given link is enabled otherwise false
     *
     * @param formatType
     * @return boolean
     */
    public boolean isLinkOptionEnabled(FormatType formatType) {
        try {
            for (WebElement element : waitForExpectedElements(formatType.getStyleLocator())) {
                if (element.isDisplayed()) {
                    if (element.findElement(By.xpath(".//../..")).getAttribute("aria-disabled").equals("true")) {
                        return false;
                    }
                    return true;
                }
            }
        } catch (TimeoutException | NoSuchElementException te) {
            LOG.info(te.getMessage());
        }
        return false;
    }

    /**
     * Clicks on annotations link text present in tinymce editor.
     *
     * @param input
     */
    public void clickOnAnnotationLinkText(String input) {
        waitForElementPresent(By.xpath("//div[@class='co_viewNoteText mce-content-body']/p/a[text()='" + input + "']")).click();
    }

    /**
     * Clicks on given input url link present on the tinymce text editor.
     *
     * @param input
     */
    public void clickOnURLLink(String input) {
        WebElement textElement = null;
        try {
            textElement = waitForElementPresent(By.xpath("//div[@class='co_viewNoteText mce-content-body']/p[contains(text(),'" + input + "')]"));
            textElement.findElement(By.xpath(".//..//a")).click();
        } catch (Exception nse) {
            if (urlFindingCount < 3) {
                urlFindingCount++;
                clickOnURLLink(input);
            } else {
                throw new PageOperationException("Facing difficulty in selecting the textlink.");
            }
        }
    }

    static int textMenuCounter = 0;

    /**
     * Selects the given text and write inline notes.
     *
     * @param text
     */
    public void selectTextPresentInParaUsingDoubleClick(String text) {
        WebElement element = waitForExpectedElement(By.xpath(".//*[text()='" + text + "']"));
        highlightElement(element);
        try {
            waitForExpectedElement(By.xpath("//div[@id='co_selectedTextMenu'][contains(@style,'visible')]"), TIMEOUT_5_SECONDS);
            textMenuCounter = 0;
        } catch (TimeoutException te) {
            if (textMenuCounter <= 3) {
                textMenuCounter++;
                selectTextPresentInParaUsingDoubleClick(text);
            } else {
                textMenuCounter = 0;
                throw new PageOperationException("Facing page difficulty in having the inline text menu.");
            }
        }
    }

    /**
     * Hightlights the given webelement.
     *
     * @param element
     */
    public void highlightElement(WebElement element) {
        for (int i = 0; i < 2; i++) {
            JavascriptExecutor js = (JavascriptExecutor) getDriver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "background: yellow; border: 2px solid yellow;");
        }
    }

    /**
     * Selects color note from inline note popup
     */
    public void selectInlineNotesYellowColor() {
        waitForExpectedElement(By.cssSelector(".highlightBox.yellowBox.activeBox.highlightBoxHover")).click();
    }

    /**
     * Selects given Contact in contacts popup.
     *
     * @param contact
     */
    public void selectContact(String contact) {
        try {
            for (WebElement result : retryingFindElements(By.cssSelector("#coid_contacts_peopleListItems_contacts a[role='checkbox']"))) {
                if (contact.equals(result.getText())) {
                    result.click();
                    break;
                }
            }
        } catch (PageOperationException te) {
            throw new PageOperationException("Unable to find the contact in contacts list: " + contact);
        } catch (StaleElementReferenceException se) {
            selectContact(contact);
        }
    }

    /**
     * Selects the given group from the list of group names present on contacts and groups popup page.
     *
     * @param group
     */
    public void selectGroup(String group) {
        try {
            for (WebElement result : retryingFindElements(By.cssSelector("#coid_contacts_groupsListItems a[role='checkbox']"))) {
                if (group.equals(result.getText())) {
                    result.click();
                }
            }
        } catch (PageOperationException te) {
            throw new PageOperationException("Unable to find the group in contacts list: " + group);
        } catch (StaleElementReferenceException sle) {
            selectGroup(group);
        }
    }

    /**
     * Adds the given new group name with given contacts as members of the new group.
     *
     * @param groupName
     * @param contacts
     */
    public void addGroup(String groupName, String... contacts) {
        try {
            retryingFindElement(By.id("groupListBoxWidgetAddGroup")).click();
            retryingFindElement(By.id("coid_contacts_newGroupName")).sendKeys(groupName);
            for (String contact : contacts) {
                retryingFindElement(By.id("coid_contacts_people_searchBoxInput_contacts_edit")).clear();
                retryingFindElement(By.id("coid_contacts_people_searchBoxInput_contacts_edit")).sendKeys(contact);
                retryingFindElement(By.xpath("//ul[@id='coid_contacts_peopleListItems_contacts_edit']//a[@role='checkbox'][text()='" + contact + "']")).click();
            }
            retryingFindElement(By.id("coid_contacts_newGroup_saveButton")).click();
        } catch (PageOperationException poe) {
            throw new PageOperationException("Having issues in creating group" + poe.getMessage());
        }
    }

    /**
     * Clicks on Insert button present on contacts popup page
     */
    public void selectInsertButtonOnContactsPage() {
        waitForExpectedElement(By.id("coid_contacts_closeButton")).click();
    }

    /**
     * Scrolls up the document to tinymce editor.
     */
    public void scrollToTinyMceEditor() {
        tinyMceEditor.scrollToTinyMceEditor();
    }

    /**
     * Custom enum for the text types
     * TEXT and RICH_TEXT
     */
    public enum MessageType {
        TEXT,
        RICH_TEXT;
    }

    /**
     * Gets the warning message displayed on document because of the given message type text is exceeded the lenghth.
     *
     * @param messageType
     * @return String
     */
    public String getWarningMessage(MessageType messageType) {
        StringBuffer sb = new StringBuffer();
        String cssLocator = "";

        if (messageType.equals(MessageType.TEXT)) {
            cssLocator = "#co_NotesMessage";
        } else if (messageType.equals(MessageType.RICH_TEXT)) {
            cssLocator = "#co_NotesMessage>div";
        }

        try {
            for (WebElement element : retryingFindElements(By.cssSelector(cssLocator))) {
                sb.append(element.getText());
            }
        } catch (PageOperationException pe) {
        }
        return sb.toString();
    }

    /**
     * clicks on OK button present on exceeded length warning message.
     */
    public void selectOKButtonOnWarningMessage() {
        try {
            retryingFindElement(By.className("co_NotesLightBox_okbutton")).click();
        } catch (PageOperationException pe) {
            throw new PageOperationException("Having issues in selection ok button on warning message" + pe.getMessage());
        }
    }

    /**
     * Inserts the given xml/html contact as in the given format.
     *
     * @param content
     */
    public void insertContent(String content) {
        tinyMceEditor.setTinyMCeContent(content);
    }

    /**
     * Annotations metadata
     */
    class AnnotationMetaData {
        private WebElement element;

        public AnnotationMetaData(WebElement element) {
            this.element = element;
        }

        public String getCreatedBy() {
            return element.findElement(By.className("co_noteHeader_createdBy")).getText();
        }

        public String getDate() {
            return element.findElement(By.className("co_noteBody_date")).getText();
        }

        public String getTime() {
            return element.findElement(By.className("co_noteBody_time")).getText();
        }
    }
}
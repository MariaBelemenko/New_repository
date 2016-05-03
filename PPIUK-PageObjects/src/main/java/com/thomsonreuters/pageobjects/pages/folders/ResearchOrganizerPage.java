package com.thomsonreuters.pageobjects.pages.folders;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import com.thomsonreuters.driver.exception.PageOperationException;
import com.thomsonreuters.driver.framework.AbstractPage;
import com.thomsonreuters.pageobjects.common.DocumentColumn;

public class ResearchOrganizerPage extends AbstractPage {

    private static final String EXPECTED_CLASS_ATTRIBUTE_VALUE_FOR_TABS = "co_tabLeft co_tabActive";

    public WebElement foldersTab() {
        return waitForExpectedElement(By.id("co_researchOrganizer_myFolders"));
    }

    public WebElement historyTab() {
        return waitForExpectedElement(By.id("co_researchOrganizer_history"));
    }

    public WebElement createNewFolderButton() {
        return waitForExpectedElement(By.xpath("//*[@class='co_createNewFolder']/a"));
    }

    public WebElement optionsButton() {
        return waitForExpectedElement(By.xpath("(//*[@id='co_ro_folder_options']//a)[1]"),15);
    }
    
    public WebElement optionsCopy() {
        return waitForExpectedElement(By.id("co_ro_fo_copy"));
    }
    
    public WebElement optionsExport() {
        return waitForExpectedElement(By.id("co_ro_fo_export"));
    }
    
    public WebElement optionsMove() {
        return waitForExpectedElement(By.id("co_ro_fo_move"));
    }

    public WebElement deleteOptionButton() {
        return waitForExpectedElement(By.id("co_ro_fo_delete"),15);
    }

    public WebElement renameOptionButton() {
        return waitForExpectedElement(By.id("co_ro_fo_rename"));
    }

    public String getExpectedClassAttributeValueForTabs() {
        return EXPECTED_CLASS_ATTRIBUTE_VALUE_FOR_TABS;
    }

    public WebElement getLinkToDocumentAtRowPosition(String position) {
        return waitForExpectedElement(By.xpath("//*[@id='cobalt_foldering_ro_item_name_" + String.valueOf(Integer.parseInt(position) - 1) + "']"),15);
    }
    
    public WebElement getEventTypeAtRowPosition(String position) {
        return waitForExpectedElement(By.xpath("//*[@id='cobalt_foldering_ro_item_event_" + String.valueOf(Integer.parseInt(position) - 1) + "']"),15);
    }

    public WebElement getContentTypeAtRowPosition(String position) {
        return waitForExpectedElement(By.xpath("//*[@id='cobalt_foldering_ro_item_contentType_" + String.valueOf(Integer.parseInt(position) - 1) + "']"),15);
    }

    public WebElement getResourceTypeAtRowPosition(String position) {
        return waitForExpectedElement(By.xpath("//*[@id='cobalt_foldering_ro_item_name_" + String.valueOf(Integer.parseInt(position) - 1)
                + "']/ancestor::td//div[@class='cobalt_ro_documentDescription']/span[2]"),10);
    }

    public WebElement getDateAtRowPosition(String position) {
        return waitForExpectedElement(By.xpath("//*[@id='cobalt_foldering_ro_item_eventDate_" + String.valueOf(Integer.parseInt(position) - 1) + "']"));
    }

    public WebElement getClientIdAtRowPosition(String position) {
        return waitForExpectedElement(By.xpath("//*[@id='cobalt_foldering_ro_item_clientId_" + String.valueOf(Integer.parseInt(position) - 1) + "']"));
    }

    public WebElement rootFolderLinkLeftFrame() {
        return waitForExpectedElement(By.xpath("//a[contains(text(),'s Research') and @class='co_tree_selectable co_tree_name co_tree_position--0--']"),10);
    }

    public WebElement folderLinkLeftFrame(String folderName) {
        return waitForExpectedElement(By.xpath("//*[@id='co_researchFolderTree']//a[text()='" + folderName + "']"),10);
    }

    public WebElement linkToDocumentInTrash(String title) {
        return findElement(By.xpath("//*[contains(text(),\"" + title + "\")]"));
    }

    public WebElement linkToDocument(String documentGuid, String title) {
        return findElement(By.xpath("//*[contains(@href, '" + documentGuid + "') and contains(text(),\"" + title + "\")]"));
    }

    public WebElement linkToDocumentContentType(String documentGuid, String contentType) {
        String text = "'" + contentType + "'";
        if (contentType.contains("'")) {
            contentType = "\"" + contentType + "\"";
            text = contentType;
        }
        return findElement(By.xpath("//*[contains(@href,'" + documentGuid + "')]/ancestor::td/following-sibling::td[1]/span[text()=" + text + "]"));
    }

    public WebElement linkToDocumentInRecentDropdown(String documentGuid, String title) {
        String text = "'" + title + "'";
        if (title.contains("'")) {
            title = "\"" + title + "\"";
            text = title;
        }
        return findElement(By.xpath("//*[@id='co_recentHistoryContainer']//*[contains(@href, '" + documentGuid + "') and text()=" + text + "]"));
    }

    public WebElement linkToFolderInRecentDropdown(String folderName) {
        return findElement(By.xpath("//*[@id='co_recentFoldersContainer']//*[text()='" + folderName + "']"));
    }

    public WebElement recentHistoryDropdown() {
        return waitForExpectedElement(By.xpath("//*[@class='co_dropdownBoxanchorLabel' and text()='History']"));
    }

    public WebElement recentFoldersDropdown() {
        return waitForExpectedElement(By.xpath("//*[@class='co_dropdownBoxanchorLabel' and text()='Folders']"));
    }

    public int getRootFolderCountInRecentFoldersDropdown() {
        return waitForExpectedElements(By.xpath("//*[@id='co_recentFoldersContainer']//a[contains(text(),'s Research')]")).size();
    }

    public WebElement linkToSearchInRecentDropdown(String search) {
        return findElement(By.xpath("//*[@id='co_recentHistoryContainer']//*[contains(@href, '" + search + "')]"));
    }

    public int getDocumentCountInFolders() {
        return waitForExpectedElements(By.xpath("//table[@class='co_detailsTable']/tbody//tr")).size();
    }

    public String getContentType(String documentGuid) {
        return waitForExpectedElement(By.xpath("//*[contains(@href,'" + documentGuid + "')]/ancestor::td/following-sibling::td[1]/span")).getText();
    }

    public String getContentTypeInTrash(String documentName) {
        return waitForExpectedElement(By.xpath("//*[contains(text(),\"" + documentName + "\")]/ancestor::tr/*[@class='co_detailsTable_type']")).getText();
    }

    public String getDateInTrash(String documentName) {
        return waitForExpectedElement(By.xpath("//*[contains(text(),\"" + documentName + "\")]/ancestor::tr/*[@class='co_detailsTable_date']")).getText();
    }

    public String getResourceType(String documentGuid) {
        return waitForExpectedElement(By.xpath("//*[contains(@href,'" + documentGuid + "')]/ancestor::td//div[@class='cobalt_ro_documentDescription']/span[2]")).getText();
    }

    public String getDate(String documentGuid) {
        return waitForExpectedElement(By.xpath("//*[contains(@href,'" + documentGuid + "')]/ancestor::td/following-sibling::td[2]/span")).getText();
    }

    public WebElement linkToDocument() {
        return findElement(By.xpath("//*[contains(@href, '/Document/') and @name]"));
    }

    public WebElement documentCheckbox(String documentGuid) {
        return waitForExpectedElement(By.xpath("//input[contains(@value, '" + documentGuid + "')]"));
    }

    public WebElement selectAllDocumentsCheckbox() {
        return waitForExpectedElement(By.id("cobalt_foldering_ro_details_select_all"));
    }

    public WebElement deleteButton() {
        return waitForExpectedElement(By.id("cobalt_ro_detail_trash"));
    }

    public WebElement folderingSearch() {
        return waitForExpectedElement(By.id("co_searchWithinWidget_textArea"));
    }

    public void selectMultipleFilters1() {
        WebElement select = null;
        try {
            select = waitForElementVisible(By.xpath("//*[@id='co_multifacet_selector_1']/*[@class='co_multifacet_select_multiple ']"));
            select.isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            LOG.info("context", e);
            return;
        }
        select.click();
    }

	public WebElement applyFilters1() {
		return waitForExpectedElement(By.xpath("//*[@id='co_multifacet_selector_1']/*[@class='co_multifacet_apply']"));
	}

	public WebElement cancelFilters1() {
		return waitForExpectedElement(By.xpath("//*[@id='co_multifacet_selector_1']/*[@class='co_multifacet_cancel ']"));
	}

	public WebElement facetedViewSelectType(String type) {
		return waitForExpectedElement(By.xpath("//*[@id='facet_div_Type']//label[text()='" + type
				+ "']/../descendant-or-self::input[@type='checkbox']"));
	}

	public WebElement facetedViewSelectClientID(String clientID) {
		return waitForExpectedElement(By.xpath("//*[@id='facet_div_Client_IDs']//label[text()='" + clientID + "']/../descendant-or-self::input[@type='checkbox']"));
	}
	
    public WebElement facetedViewSelectContentType(String contentType) {
        return waitForExpectedElement(By.xpath("//h4[contains(., 'Content')]/following-sibling::ul/li[contains(., \"" + contentType + "\")]/input"));
    }

    public WebElement folderInLeftFrame(String folderName) {
        return waitForExpectedElement(By.xpath("//*[@id='co_researchOrganizerNavigationContainer']//a[text()='" + folderName + "']"));
    }

    public boolean isFolderPresentInLeftFrame(String folderName, String parentFolder) {
        WebElement folder = null;
        try {
            if (parentFolder.equals("root")) {
                folder = findElement(By.xpath("(//*[@id='co_researchOrganizerNavigationContainer']//a[text()='" + folderName + "']//ancestor::li[2]//a)[1]"));
            } else {
                folder = findElement(By.xpath("//*[@id='co_researchOrganizerNavigationContainer']//a[text()='" + folderName + "']//ancestor::li[2]//a[text()='"
                        + parentFolder + "']"));
            }
            folder.isDisplayed();
        } catch (NoSuchElementException e) {
            LOG.info("context", e);
            return false;
        }
        return true;
    }
    
    public boolean isFolderAbsentOnSameLevelAsSpecifiedFolder(String folderName, String specifiedFolder) {
        WebElement folder = null;
        String treeDeepthOfSpecifiedFolder;
        try {
            if (specifiedFolder.equals("root")) {
            	treeDeepthOfSpecifiedFolder = rootFolderLinkLeftFrame().findElement(By.xpath("/ancestor::li")).getAttribute("class");
            } else {
            	treeDeepthOfSpecifiedFolder = findElement(By.xpath("//a[(contains(@class,'co_tree_name')) and contains(text(),'" + specifiedFolder + "')]/ancestor::li[@class!='co_tree_depth_0']")).getAttribute("class");
            }
            folder = findElement(By.xpath("//li[@class='" + treeDeepthOfSpecifiedFolder + "']/div//a[text()='" + folderName + "']"));
            folder.isDisplayed();
        } catch (NoSuchElementException e) {
            LOG.info("context", e);
            return false;
        }
        return true;
    }

    public WebElement getHistoryEmpty() {
        return waitForExpectedElement(By.xpath("//*[@id='co_researchOrg_detailsContainer']//td[@class='empty' and text()='No records found.']"));
    }

    public void checkFacetingIsAbsent() {
        try {
        	WebElement faceting = findElement(By.xpath("//*[@id='facet_div_Content Types' or @id='facet_div_Client_IDs']"));
            faceting.isDisplayed();
        } catch (NoSuchElementException e) {
            LOG.info("Faceting is absent", e);
            return;
        }
        throw new RuntimeException("Faceting presents");
    }

    public boolean hasDocumentFolderedSign(String documentId) {
		try {
			WebElement folderedSign = findElement(By.xpath("//*[contains(@href,'/Document/" + documentId + "')]/preceding::li[@class='co_document_icon_foldered']"));
			folderedSign.isDisplayed();
		} catch (NoSuchElementException e) {
			LOG.info("Foldered sign for '" + documentId + "' absents", e);
			return false;
		}
		LOG.info("Foldered sign for '" + documentId + "' presents");
		return true;
	}

	public boolean hasDocumentPreviouslyViewedSign(String documentId) {
		WebElement previouslyViewedSign = null;
		try {
			previouslyViewedSign = findElement(By.xpath("//*[contains(@href,'/Document/" + documentId + "')]/preceding::li[@class='co_document_icon_previouslyviewed']"));
			previouslyViewedSign.isDisplayed();
		} catch (NoSuchElementException e) {
			LOG.info("Previously viewed sign for '" + documentId + "' absents", e);
			return false;
		}
		LOG.info("Previously viewed sign for '" + documentId + "' presents");
		return true;
	}

	public WebElement shareFolder(String folderName) {
		return waitForExpectedElement(By.xpath("//*[@class='co_shared_icon']"));
	}
	
	public WebElement expandSharedFolder(String folderName) {
		return findElement(By.xpath("//*[@id='cobalt_ro_sharedFolders_folderTree']//a[contains(@class,'co_tree_expand') and text()='Expand " + folderName + "']"));
	}

	public void checkFolderIsNowSharedMessage(String folderName) {
		try {
			WebElement message = findElement(By.xpath("//*[@id='co_researchOrganizerNotification' and text()=\"'" + folderName + "' is now shared.\"]"));
			message.isDisplayed();
		} catch (NoSuchElementException e) {
			throw new RuntimeException("Folder is now shared message absents", e.getCause());
		}
	}

	public boolean isFolderPresentInSharedFolders(String folderName) {
		WebElement folder = null;
		try {
			folder = findElement(By.xpath("//*[@id='cobalt_ro_sharedFolders_folderTree']//a[text()='" + folderName + "']"));
			folder.isDisplayed();
		} catch (NoSuchElementException e) {
			LOG.info("context", e);
			return false;
		}
		return true;
	}
	
	public boolean isUserAbleToExpandSharedFolder(String folderName) {
		try {
			return expandSharedFolder(folderName).isDisplayed();
		} catch (NoSuchElementException e) {
			LOG.info("context", e);
			return false;
		}
	}

	public void checkFolderIsNoLongerSharedMessage(String folderName) {
		try {
			WebElement message = findElement(By.xpath("//*[@class='co_infoBox_message' and text()=\"'"
					+ folderName + "' is no longer shared.\"]"));
			message.isDisplayed();
		} catch (NoSuchElementException e) {
			throw new RuntimeException("Folder is no longer shared message absents", e.getCause());
		}
	}

	public WebElement sharePopup(String folderName) {
		return waitForExpectedElement(By.id("co_folderingShareFolderCommit"));
	}

    /**
     * This method is used to find the notes added icon presence based on the given document index position in the history list.
     * @param position
     * @return boolean
     */
    public boolean isNotesIconPresentForDocument(String position){
        try{
            return retryingFindElement(By.cssSelector("#cobalt_foldering_ro_item_icon_container_" + (Integer.parseInt(position)-1) + " .co_document_icon_notes")).isDisplayed();
        }catch(PageOperationException te){ }
        return false;
    }

    public By cancelByFilters() {
        return By.xpath("//*[@id='co_multifacet_selector_1']/*[@class='co_multifacet_cancel ']");
    }

    public By selectMultipleByFilters() {
        return By.xpath("//*[@id='co_multifacet_selector_1']/*[@class='co_multifacet_select_multiple ']");
    }

    /**
     * element that provides the search area within History page
     */
    public WebElement searchAreaWithinHistory() {

        return waitForElementVisible(By.id("co_searchWithinWidget_textArea"));
    }

    /**
     * element that provides the total search term selected regardless of row number
     */
    public List<WebElement> totalSelectedSearchTerm() {

        return waitForElementsVisible(By.xpath("//div[@id='co_researchOrg_detailsTable']//tr//span[@class='co_searchTerm co_keyword']"));
    }


    /**
     * element that provides the search term selected
     */
    public List<WebElement> selectedRowWiseSearchTerm(int rowNumber) {

        return waitForElementsVisible(By.xpath("//div[@id='co_researchOrg_detailsTable']//tr["+rowNumber+"]//span[@class='co_searchTerm co_keyword']"));
    }

    /**
     * element that provides the list of all history page result title links
     */
    public List<WebElement> historyPageResultTitleLinks() {

        return waitForElementsVisible(By.xpath("//div[@id='co_researchOrg_detailsTable']//tr//a[contains(@id,'cobalt_foldering_ro_item_name')]"));
    }

    /**
     * element that provides the list of all history page result title links
     */
    public By historyPageResultByTitleLink() {

        return By.xpath("//div[@id='co_researchOrg_detailsTable']//tr//a[contains(@id,'cobalt_foldering_ro_item_name')]");
    }

    /**
     * element that provides date picker dropdown
     */
    public WebElement historyPageDatePickerDropdownLink() {

        return waitForElementVisible(By.id("co_dateWidget_1_dropdown"));
    }
    /**
     * element that provides date picker dropdown
     */
    public List<WebElement> datePickerDropdownOptionsList() {

        return waitForElementsVisible(By.xpath("//div[@id='co_dateWidget_footer_1']//li//a"));
    }

    /**
     * element that provides date picker dropdown selection
     */
    public WebElement datePickerDropdownSelectedOption() {

        return waitForElementVisible(By.id("co_dateWidget_1_dropdown_span"));
    }

    /**
     * element that provides date picker dropdown option count
     */
    public WebElement datePickerOptionCount(String option) {

        return waitForElementVisible(By.xpath("//ul[@id='co_dateWidgetFixedList_1']//span[.='" + option + "']/..//span"));
    }

    /**
     * Check if folder present in main content frame
     * @param folderName Folder name
     * @return True - if folder present, otherwise - false.
     */
    public boolean isFolderPresent(String folderName) {
        return waitForElementPresent(By.xpath("//tr[contains(@id, 'datatable')]//a[contains(@id, 'item') and .='" + folderName + "']")).isDisplayed();
    }

    /**
     * Get title of opened folder
     * @return Selected folder title
     */
    public String getOpenedFolderTitle() {
        return waitForElementPresent(By.cssSelector(".co_folderTitle")).getText();
    }

    /**
     * Click on column of table at folder view page
     * @param documentColumn Column to get data from.
     *                       @see DocumentColumn
     */
    public WebElement getColumn(DocumentColumn documentColumn) {
        return waitForElementPresent(By.xpath("//th[.='" + documentColumn.getName() + "']"));
    }

    /**
     * Get content of selected folder.
     * IMPORTANT! Only documents data will be retrieved. Rows, which contains nested folders, will be ignored.
     * @param column Column to get data from.
     *               @see DocumentColumn
     * @return List with data from all presented document rows in selected folder for given column
     */
    public List<String> getDocumentsDataInColumn(DocumentColumn column) {
        String rowXpath = "//tr[contains(@id, 'datatable') and .//input[@type='checkbox']]";
        String tableCellsXpath;
        List<String> result = new ArrayList<>();
        switch (column) {
            case TITLE:
                tableCellsXpath = rowXpath + "//a[contains(@id, 'item')]";
                break;
            case CONTENT:
                tableCellsXpath = rowXpath + "//td[contains(@class, 'type')]//span";
                break;
            case DATE_ADDED:
                tableCellsXpath = rowXpath + "//td[contains(@class, 'date')]//span";
                break;
            default:
                throw new UnsupportedOperationException("There is no locator pattern for column " + column.getName());
        }
        List<WebElement> cells = waitAndFindElements(By.xpath(tableCellsXpath));
        for (WebElement cell : cells) {
            result.add(cell.getText());
        }
        return result;
    }

    /**
     * Get document checkbox
     * @param documentName Document name which checkbox should be clicked to
     * @return Element with document checkbox
     */
    public WebElement getDocumentCheckbox(String documentName) {
    	return waitForExpectedElement(By.xpath("//tr[contains(@id, 'datatable') and contains(., '" + documentName + "')]//input[@type='checkbox']"));
    }

    /**
     * Get "Save to folder" button
     * @return Element with "Save to folder" button
     */
    public WebElement getSaveToFolderButton() {
        return waitForExpectedElement(By.xpath("//li[contains(@id, 'saveTo')]//a"));
    }

    /**
     * Check if document with name is exists on the page
     * @param documentName Document name which checkbox should be clicked to
     * @return True = if doc exists, otherwise - false.
     */
    public boolean isDocumentExists(String documentName) {
    	return waitForElementExists(By.xpath("//tr[contains(@id, 'datatable') and contains(., '" + documentName + "')]//input[@type='checkbox']")).isDisplayed();
    }

    /**
     * Check if document with name is not exists on the page
     * @param documentName Document name which checkbox should be clicked to
     * @return True = if doc is not exists, otherwise - false.
     */
    public boolean isDocumentAbsent(String documentName) {
    	return waitForElementAbsent(By.xpath("//tr[contains(@id, 'datatable') and contains(., '" + documentName + "')]//input[@type='checkbox']"));
    }
    /**
     * element that provides date picker for Before, After, On and From Date Text-boxes
     */

    public WebElement datePickerBeforeAfterOnFromTextbox(String option) {

        return waitForElementVisible(By.xpath("//a[.='"+option+"']/..//label/following-sibling::input"));
    }

    public WebElement datePickerUntilDateTextbox() {

        return waitForElementVisible(By.id("co_dateWidgetCustomRangeUntilText_1_fromUntil"));
    }

    public WebElement datePikcerOKButton(String option) {

        return waitForElementVisible(By.xpath("//a[.='" + option + "']/..//input[@class='co_button_submit_small co_primaryBtn']"));
    }
    
    public WebElement documentCheckboxByNumber(String number) {
    	int numberOfDocument = Integer.parseInt(number)-1;
        return waitForExpectedElement(By.xpath("//input[@id='cobalt_foldering_ro_select_checkbox_" + numberOfDocument + "']"));
    }

}
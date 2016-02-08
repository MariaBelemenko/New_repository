package com.thomsonreuters.pageobjects.pages.folders;

import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;




public class SaveToPopup extends AbstractPage {

	private PageActions pageActions;

    public SaveToPopup(){
        pageActions = new PageActions();
    }

	public WebElement save() {
		return waitForExpectedElement(By.xpath("(//*[@class='co_dropdownBox_ok co_saveToDoSave'])[last()]"));
	}

	public WebElement selectRootFolder() {
		return waitForExpectedElement(By
				.xpath("(//*[@class='co_tree_selectable co_tree_name co_tree_position--0--'])[last()]"));
	}

	public WebElement expandRootFolder() {
		return findElement(By.xpath("//*[@class='co_tree_toggle co_tree_position--0-- co_tree_expand']"));
	}
	
	public WebElement expandRootFolderWait() {
		return waitForExpectedElement(By.xpath("//*[@class='co_tree_toggle co_tree_expand co_tree_position--0--']"));
	}

	public WebElement newFolder() {
		return waitForExpectedElement(By.xpath("//div[contains(@class, 'Overlay') and not(contains(@class, 'hide'))]//a[contains(@class, 'saveToNewFolder')]"));
	}
	
	public WebElement selectFolder(String folder) {
		return findElement(By.xpath("(//a[text()='" + folder + "'])[last()]"));
	}
	
	public WebElement selectFolderWait(String folder) {
		return waitForExpectedElement(By.xpath("(//a[text()='" + folder + "'])[last()]"));
	}

	public WebElement getPopUp() {
		return waitForExpectedElement(By
				.xpath("//div[@class='co_overlayBox_container co_folderAction co_saveTo_folderAction']"));
	}

	public boolean isPopUpDispayed() {
		return isElementDisplayed(getPopUp());
	}

	public void waitFolderSelected(String folderName) {
		try {
			waitForElementVisible(By
					.xpath("//div[@class='co_myFolders']//div[contains(@class,'co_treeFocus')]//a[text()='" + folderName + "']"));
		} catch (TimeoutException e) {
			throw new RuntimeException("New folder is not selected on Save to Folder popup");
		}
	}

	public WebElement saveButton() {
		return waitForExpectedElement(By.xpath("//li/input[contains(@class,'saveToDoSave')][@type='button']"),10);
	}

}

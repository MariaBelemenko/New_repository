package com.thomsonreuters.pageobjects.pages.folders;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewFolderPopup extends AbstractPage {

	public WebElement newFolderInput() {
		return waitForExpectedElement(By.id("cobalt_ro_folder_action_textbox"));
	}

	public WebElement selectFolder(String parentFolder) {
		return waitForExpectedElement(By.xpath("//*[contains(@class,'co_new_folderAction')]//a[text()='" + parentFolder + "']"));
	}

	public WebElement selectRootFolder() {
		return waitForExpectedElement(By
				.xpath("(//*[@class='co_tree_selectable co_tree_name co_tree_position--0--'])[last()]"));
	}

	public WebElement clickCancel() {
		return waitForExpectedElement(By.xpath("(//*[@class='co_dropdownBox_cancel'])[last()]"));
	}

	public WebElement save() {
		return waitForElementVisible(By.xpath("//*[@type='button' and @value='OK']"));
	}

	public WebElement getErrorMessage() {
		return waitForExpectedElement(By.id("cobalt_ro_folder_action_error"));
	}
	
	public WebElement folderRoleInformation() {
		return waitForExpectedElement(By.xpath("//div[@class='co_roleMessageContainer cobalt_folderAction_roleMessage']"));
	}

}

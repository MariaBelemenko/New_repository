package com.thomsonreuters.pageobjects.pages.folders;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewFolderPopup extends AbstractPage {

	public WebElement newFolderInput() {
		return waitForExpectedElement(By.id("cobalt_ro_folder_action_textbox"),15);
	}

	public WebElement selectFolder(String parentFolder) {
		return waitForExpectedElement(By.xpath("//*[contains(@class,'co_new_folderAction')]//a[text()='" + parentFolder + "']"),15);
	}

	public WebElement selectRootFolder() {
		return waitForExpectedElement(By
				.xpath("(//*[@class='co_tree_selectable co_tree_name co_tree_position--0--'])[last()]"),15);
	}

	public WebElement clickCancel() {
		return waitForExpectedElement(By.xpath("(//*[@class='co_dropdownBox_cancel'])[last()]"));
	}

	public WebElement save() {
		return waitForExpectedElement(By.xpath("//*[@type='button' and @value='OK']"),15);
	}

	public WebElement getErrorMessage() {
		return waitForExpectedElement(By.id("cobalt_ro_folder_action_error"));
	}
	
	public WebElement folderRoleInformation() {
		return waitForExpectedElement(By.xpath("//div[@class='co_roleMessageContainer cobalt_folderAction_roleMessage']"));
	}

}

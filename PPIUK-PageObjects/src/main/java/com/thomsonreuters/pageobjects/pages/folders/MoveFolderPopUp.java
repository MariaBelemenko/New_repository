package com.thomsonreuters.pageobjects.pages.folders;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class MoveFolderPopUp extends AbstractPage {

	public WebElement selectFolder(String parentFolder) {
		return waitForExpectedElement(By.xpath("//*[contains(@class,'co_move_folderAction')]//a[text()='"
				+ parentFolder + "']"));
	}

	public WebElement clickCancel() {
		return waitForExpectedElement(By.xpath("(//*[@class='co_dropdownBox_cancel'])[last()]"));
	}

	public WebElement save() {
		return waitForElementVisible(By.xpath("//*[@type='button' and @value='Move']"));
	}

}

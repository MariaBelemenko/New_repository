package com.thomsonreuters.pageobjects.pages.folders;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShareFolderPopup extends AbstractPage {

    public WebElement deleteContact(String contactName) {
        return waitForExpectedElement(By.xpath("//td[text()='" + contactName + "']//following-sibling::td[@class='co_detailsTable_remove']/a"));
    }

    public WebElement contactRoleSelect(String contactName) {
        return waitForExpectedElement(By.xpath("//td[text()='" + contactName + "']//following-sibling::td[@class='co_detailsTable_roles']/select"));
    }

    public WebElement continueButton() {
        return waitForExpectedElement(By.id("co_folderingShareFolderContinue"));
    }

    public WebElement shareSubFoldersCheckBox() {
        return waitForExpectedElement(By.id("co_shareFolder_inclSubfolders"));
    }

    public WebElement cancel() {
        return waitForExpectedElement(By.id("co_folderingShareFolderCancel"));
    }

    public WebElement add() {
        return waitForExpectedElement(By.className("co_shareFolder_addCollaborators"));
    }

    public WebElement closeFolderPopUp() {
        return waitForExpectedElement(By.id("co_folderingShareFolderClose"));
    }

    public WebElement contacts() {
        return waitForExpectedElement(By.className("co_folderingShareFolder_contacts"));
    }

    public WebElement contactsInputDisabled() {
        return waitForExpectedElement(By.id("coid_contacts_addedContactsInput"));
    }

    public WebElement contactsInputEnabled() {
        return waitForExpectedElement(By.xpath("//*[@class='co_contacts_collector_addNew']/input"));
    }

    public WebElement endShareFolder() {
        return waitForExpectedElement(By.className("co_shareFolder_unshare"));
    }

    public WebElement endSharingConfirmation() {
        return waitForExpectedElement(By.className("co_dropdownBox_ok"));
    }

    public WebElement newGroup() {
        return waitForExpectedElement(By.id("groupListBoxWidgetAddGroup"));
    }

    public WebElement emailToNotify() {
        return waitForExpectedElement(By.id("coid_inviteexternal_email"));
    }

}

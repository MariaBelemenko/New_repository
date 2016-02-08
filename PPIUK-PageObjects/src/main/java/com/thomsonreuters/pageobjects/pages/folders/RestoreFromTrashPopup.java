package com.thomsonreuters.pageobjects.pages.folders;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;


/**
 * Created by Pavel_Ardenka on 29.10.2015.
 * Ideas: all popups has the pageobjects logic which can be placed in one base class
 */

public class RestoreFromTrashPopup extends AbstractPage {

    private String dialogXpath = "//div[contains(@class, 'Overlay') and not(contains(@class, 'hide'))]";
    private String rootFolderXpath = dialogXpath + "//a[contains(@class, '0') and contains(@class, 'name')]";
    private String plusSignForRootFolderXpath = dialogXpath + "//div[.//a[contains(@class, '0') and contains(@class, 'name')]]/a[contains(@class, 'toggle')]";

    /**
     * Expand root folder (e.g., with name "User's Research")
     */
    public void expandRootFolder() {
        waitForExpectedElement(By.xpath(plusSignForRootFolderXpath)).click();
    }

    /**
     * Select folder
     * @param targetFolderName Folder name which should be selected
     * @param expandRoot Is root folder should be expanded?
     * @param parentFolderNames Parent folders names which should be expanded for selecting target folder (root folder excluded)
     *                          E.g., there is necessary to select folder:
     *                          User's Research -> FolderOne -> SubFolderOne -> TargetFolder
     *                          parameters value should be "FolderOne", "SubFolderOne"
     */
    public void selectFolder(String targetFolderName, boolean expandRoot, String... parentFolderNames) {
        boolean isRootExpanded = false;
        if (expandRoot) {
            expandRootFolder();
            isRootExpanded = true;
        }
        for (String parentFolderName : parentFolderNames) {
            if (isRootExpanded) { // skip first folder, which name may be passed as "root" to first argument in parentFolderNames
                isRootExpanded = false; // for prevent entering to this "if" in next iterations
                continue;
            }
            String plusSignXpath = dialogXpath + "//div[.//a[.='" + parentFolderName + "']]/a[contains(@class, 'toggle')]";
            if (isExists(By.xpath(plusSignXpath))) {
                findElement(By.xpath(plusSignXpath)).click();
            }
        }
        waitForExpectedElement(By.xpath(dialogXpath + "//a[.='" + targetFolderName + "']")).click();
    }

    /**
     * Click Move Button
     */
    // Common XPath for every active button except "Cancel": dialogXpath +  //input[contains(@class, 'saveTo') and not(contains(@class, 'hide'))]
    public void clickMoveButton() {
        waitForExpectedElement(By.xpath(dialogXpath + "//input[@value='Move']")).click();
    }

    /**
     * Click on "Cancel" button
     */
    public void clickcancelButton() {
        waitForExpectedElement(By.xpath(dialogXpath + "//a[contains(@class, 'cancel')]")).click();
    }

    /**
     * Get root folder name
     * @return Root folder name
     */
    public String getRootFolderName() {
        return waitForExpectedElement(By.xpath(rootFolderXpath)).getText();
    }

}

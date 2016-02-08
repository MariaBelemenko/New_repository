package com.thomsonreuters.pageobjects.pages.delivery;

import com.thomsonreuters.driver.framework.AbstractPage;
import com.thomsonreuters.pageobjects.utils.delivery.DeliveryFormField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

/**
 * Common Page Objects for Email, Print and Download forms
 */

public class CommonDeliveryOptionsPage extends AbstractPage {

    public WebElement basicTab() {
        return waitForExpectedElement(By.cssSelector("#co_deliveryOptionsTab1 .co_tabLink"));
    }

    public WebElement advancedTab() {
        return findElement(By.cssSelector("#co_deliveryOptionsTab2 .co_tabLink"));
    }

    /**
     * Very bad hack but could not figure out a better way
     */
    public void waitTillAdvancedTabIsClickable() throws InterruptedException {
        List<WebElement> elementList;
        int counter = 10;
        do {
            elementList = findElements(By.cssSelector(".co_tabLeft.co_tabInactive.ddcdisplaymodefulltext.ddcdisplaymodelist"));
            counter--;
            Thread.sleep(2000);
        }
        while (elementList.size() > 0 && counter >= 0);
    }

    public WebElement cancelButton() {
        return findElement(By.id("co_deliveryCancelButton"));
    }

    public WebElement tableOfContents() {
        return findElement(DeliveryFormField.TABLE_OF_CONTENTS.getBy());
    }

    public WebElement annotations() {
        return findElement(By.id("coid_chkDdcContentAnnotations"));
    }

    public WebElement deliverDocument() {
        return findElement(DeliveryFormField.DOCUMENT.getBy());
    }

    public WebElement deliverOnlyDraftingNotes() {
        return findElement(DeliveryFormField.ONLY_DRAFTING_NOTES.getBy());
    }

    public WebElement deliverDocumentAndDraftingNotes() {
        return findElement(DeliveryFormField.DOCUMENT_AND_DRAFTING_NOTES.getBy());
    }

    public WebElement expandedMarginForNotes() {
        return waitAndFindElement(DeliveryFormField.EXPAND_MARGIN_FOR_NOTES.getBy());
    }

    public WebElement coverPage() {
        return findElement(DeliveryFormField.COVER_PAGE.getBy());
    }

    public WebElement coverPageComment() {
        return findElement(DeliveryFormField.COVER_PAGE_COMMENT.getBy());
    }

    public WebElement links() {
        return findElement(DeliveryFormField.LINKS.getBy());
    }

    public WebElement underline() {
        return findElement(DeliveryFormField.UNDERLINE.getBy());
    }

    public WebElement fontSize() {
        return findElement(DeliveryFormField.FONTSIZE.getBy());
    }

}

package com.thomsonreuters.pageobjects.pages.delivery;

import com.thomsonreuters.pageobjects.utils.delivery.DeliveryFormField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * This is the pop up which appears when the user selects the email option within delivery.
 */

public class EmailOptionsPage extends CommonDeliveryOptionsPage {

    /**
     * This is the email address field
     */
    public WebElement emailAddressField() {
        return waitForExpectedElement(DeliveryFormField.TO.getBy());
    }

    /**
     * This is the subject field
     */
    public WebElement subjectField() {
        return waitForExpectedElement(DeliveryFormField.SUBJECT.getBy());
    }

    public WebElement emailNote() {
        return findElement(DeliveryFormField.EMAIL_NOTE.getBy());
    }

    /**
     * This is the format dropdown
     */
    public WebElement formatDropdown() {
        return findElement(DeliveryFormField.FORMAT.getBy());
    }

    /**
     * This is the email button for submission of the request
     */
    public WebElement emailButton() {
        return waitAndFindElement(By.id("co_deliveryEmailButton"));
    }

    public WebElement cancelButton() {
        return waitAndFindElement(By.id("co_deliveryCancelButton"));
    }

    public WebElement deliveryMessage() {
        return waitAndFindElement(By.id("co_deliveryWaitMessageTitle"));
    }

    public WebElement waitForSuccessDeliveryMessage(String text) {
        return waitAndFindElement(By.xpath("//div[@id='co_deliveryWaitMessageTitle'][text()=\"" + text + "\"]"));
    }

    public WebElement expandedMarginForNotes() {
        return findElement(By.id("coid_chkDdcLayoutRightNoteMarging"));
    }

}
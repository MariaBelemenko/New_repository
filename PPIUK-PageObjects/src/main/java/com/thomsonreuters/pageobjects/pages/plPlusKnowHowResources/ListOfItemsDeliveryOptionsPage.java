package com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * Created by u0171568 (Asha Shetty) on 15/07/2015. This class is created to hold delivery page objects on the
 * list of items pages (For eg: Topic Pages and Search results page)
 */

public class ListOfItemsDeliveryOptionsPage extends AbstractPage {

    public WebElement emailLink() {
        return findElement(By.cssSelector("#deliveryLinkRow1Email span[class='delivery_icon th_flat_icon icon_email']"));
    }
    public WebElement printLink() {
        return findElement(By.cssSelector("#deliveryLinkRow1Print span[class='delivery_icon th_flat_icon icon_print']"));
    }
    public WebElement downloadLink() {
        return findElement(By.cssSelector("#deliveryLinkRow1Download span[class='delivery_icon th_flat_icon icon_download']"));
    }
    public WebElement saveToFolderLink() {
        return findElement(By.cssSelector("#saveToFolder span[class='th_flat_icon icon_folder']"));
    }

    public boolean EnabledDeliveryOption(String option) {

        if (option.equals("Email")) {
            return emailLink().isDisplayed();
            //return findElement(By.cssSelector("#deliveryLinkRow1Email span[class='delivery_icon th_flat_icon icon_email']")).isDisplayed();
        } else if (option.equals("Print")) {
            return printLink().isDisplayed();
            //return retryingFindElement(By.cssSelector("#deliveryLinkRow1Print span[class='delivery_icon th_flat_icon icon_print']")).isDisplayed();
        } else if (option.equals("Download")) {
            return downloadLink().isDisplayed();
            //return retryingFindElement(By.cssSelector("#deliveryLinkRow1Download span[class='delivery_icon th_flat_icon icon_download']")).isDisplayed();
        } else if (option.equals("Save to Folder")) {
            return saveToFolderLink().isDisplayed();
            //return retryingFindElement(By.cssSelector("#saveToFolder span[class='th_flat_icon icon_folder']")).isDisplayed();
        }
        return false;
    }
    public boolean DisabledDeliveryOption(String option) {

        if (option.equals("Email")) {
            return findElement(By.cssSelector("#deliveryLinkRow1Email span[class='delivery_icon th_flat_icon icon_email outline']")).isDisplayed();
        } else if (option.equals("Print")) {
            return retryingFindElement(By.cssSelector("#deliveryLinkRow1Print span[class='delivery_icon th_flat_icon icon_print outline']")).isDisplayed();
        } else if (option.equals("Download")) {
            return retryingFindElement(By.cssSelector("#deliveryLinkRow1Download span[class='delivery_icon th_flat_icon icon_download outline']")).isDisplayed();
        } else if (option.equals("Save to Folder")) {
            return retryingFindElement(By.cssSelector("#saveToFolder span[class='outline th_flat_icon icon_folder']")).isDisplayed();
        }
        return false;
    }
}

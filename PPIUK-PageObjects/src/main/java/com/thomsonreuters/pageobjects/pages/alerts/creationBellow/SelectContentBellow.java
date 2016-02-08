package com.thomsonreuters.pageobjects.pages.alerts.creationBellow;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;


public class SelectContentBellow extends AbstractPage {
    public WebElement browseHeader() {
        return waitAndFindElement(By.className("co_browseHeading"));
    }

    public List<WebElement> topicsUnorderedLinkList() {
        return waitAndFindElements(By.xpath("//div[@class='co_3Column']//li/a"));
    }

    public WebElement topicsUnorderedListItemLink(String topicName) {
        return waitAndFindElement(By.xpath("//div[@class='co_3Column']//li/a[text()='" + topicName + "']"));
    }

    public List<WebElement> contentUnorderdIconList() {
        return waitAndFindElements(By.xpath("//div[@class='co_3Column']//i"));
    }

    public WebElement contentUnorderdListIcon(String content) {
        return waitAndFindElement(By.xpath("//div[@class='co_3Column']//span[text()='" + content + "']/preceding-sibling::i"));
    }

    public WebElement leftBreadcrumbFirstLink() {
        return waitAndFindElement(By.xpath("//div[@class='co_wizardStep_left_breadcrumb']/a"));
    }

    public WebElement leftBreadcrumbLastLeaf() {
        return waitAndFindElement(By.xpath("//div[@class='co_wizardStep_left_breadcrumb']/span"));
    }

    public List<WebElement> selectedContentDivList() {
        return waitAndFindElements(By.xpath("//ul[@id='selectedItemsControlId']/li/div"));
    }

    public WebElement continueContentButton() {
        return waitAndFindElement(By.id("co_button_continue_Content"));
    }
}

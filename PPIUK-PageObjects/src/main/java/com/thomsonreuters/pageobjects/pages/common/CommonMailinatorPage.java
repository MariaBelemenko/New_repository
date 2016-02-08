package com.thomsonreuters.pageobjects.pages.common;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

/**
 * Created by uc087619 Ian Hudson on 20/04/2015.
 */


public class CommonMailinatorPage extends AbstractPage {

    public WebElement emailFromByOnclick(
            String Onclick) {
        return waitForExpectedElement(By.xpath("//a[@onclick=\"" + Onclick + "\"]/div[contains(@class,'from')]"));
    }

    public WebElement emailSubjectOnclick(
            String Onclick) {
        return waitForExpectedElement(By.xpath("//a[@onclick=\"" + Onclick + "\"]/div[contains(@class,'subject')]"));
    }

    public WebElement emailTimeOnclick(
            String Onclick) {
        return waitForExpectedElement(By.xpath("//a[@onclick=\"" + Onclick + "\"]/div[contains(@class,'time')]"));
    }

    public WebElement emailTimeRecentByOnclick(
            String Onclick) {
        return waitForExpectedElement(By.xpath("//a[@onclick=\"" + Onclick + "\"]/div[contains(@class,'time')]/self::*[contains(text(),'minute')]"));
    }

    public List displayedEmailList() {

        List<WebElement> eList = findElements(By.xpath("//a[contains(@onclick,'showmail')]"));

        return eList;
    }

    public Integer displayedEmailCount() {
        List<WebElement> eList = findElements(By.xpath("//a[contains(@onclick,'showmail')]"));
        return eList.size();
    }

    public WebElement emailEmptyInbox() {
        return waitForExpectedElement(By.xpath("//div[@id='noemailmsg']"));
    }

    public WebElement emailSubject(
            String subjectText) {
        return waitForExpectedElement(By.xpath("//div[contains(@class,'subject')]/self::*[contains(text(),'" + subjectText + "')]"));
    }

    public String firstEmailOnclickId(){
        WebElement firstEmailLink = waitForExpectedElement(By.xpath("//a[1]/self::a[contains(@onclick,'showmail')]"));
        String onclickId = firstEmailLink.getAttribute("onclick");
        return onclickId;
    }

    public WebElement emailByOnclick(
            String Onclick) {
        return waitForExpectedElement(By.xpath("//a[@onclick='" + Onclick + "']"));
    }

    public WebElement emailDisplayTo() {
        return waitForExpectedElement(By.xpath("//div[contains(text(),'To:')]/following-sibling::div"));
    }

    public WebElement emailDisplayFrom() {
        return waitForExpectedElement(By.xpath("//div[contains(text(),'From:')]/following-sibling::div"));
    }

    public WebElement emailDisplaySubject() {
        return waitForExpectedElement(By.xpath("//div[contains(text(),'Subject:')]/following-sibling::div"));
    }

    public WebElement emailMainText() {

        return waitForExpectedElement(By.xpath("//div[@class='mailview']"));
    }

    public WebElement buttonOriginal() {
        return waitForExpectedElement(By.xpath("//button[contains(@onclick,'load')]"));
    }

    public WebElement emailMainTextLink(
            String containsHref) {
        return waitForExpectedElement(By.xpath("//div[@class='mailview']/a[contains(@href,'" + containsHref + "')]"));
    }

    public WebElement emailMainTextFrame() {
        return waitForExpectedElement(By.name("rendermail"));
    }

}

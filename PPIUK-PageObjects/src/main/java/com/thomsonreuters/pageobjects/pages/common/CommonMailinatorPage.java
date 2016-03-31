package com.thomsonreuters.pageobjects.pages.common;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

/**
 * Created by uc087619 Ian Hudson on 20/04/2015.
 */


public class CommonMailinatorPage extends AbstractPage {

    public WebElement emailListSubjectOnclick(
            String Onclick) {
        return waitForExpectedElement(By.xpath("//div[@id=\"" + Onclick + "\"]//div[contains(@style,'blue')]/div[contains(@class,'innermail')]"));
    }

    public List displayedEmailList() {
        List<WebElement> eList = waitForExpectedElements(By.cssSelector(".someviewport div[id*='row_public']"),15);
        return eList;
    }

    public Integer displayedEmailCount() {
        List<WebElement> eList = waitForExpectedElements(By.cssSelector(".someviewport div[id*='row_public']"),15);
        return eList.size();
    }

    public void selectFirstEmail(){
        WebElement element = (WebElement) displayedEmailList().get(0);
        element.findElement(By.cssSelector("div[onclick*='showTheMessage']")).click();
    }

    public String firstEmailOnclickId(){
        WebElement firstEmailLink = (WebElement) displayedEmailList().get(0);
        return firstEmailLink.getAttribute("id");
    }

    public WebElement emailDisplayTo() {
        return waitForExpectedElement(By.xpath("//td[contains(text(),'To:')]/following-sibling::td"));
    }

    public WebElement emailDisplayFrom() {
        return waitForExpectedElement(By.xpath("//td[contains(text(),'From:')]/following-sibling::td"));
    }

    public WebElement emailDisplaySubject() {
        return waitForExpectedElement(By.xpath("//td[contains(text(),'Subject:')]/following-sibling::td"));
    }

    public WebElement emailMainTextLink(
            String containsHref) {
        return waitForExpectedElement(By.xpath("//body/a[contains(@href,'" + containsHref + "')]"));
    }

    public WebElement emailMainTextFrame() {
        return waitForExpectedElement(By.id("publicshowmaildivcontent"),10);
    }

    public String getEmailText() {
        WebElement iframe = emailMainTextFrame();
        switchToIframe(iframe);
        String text = waitForExpectedElement(By.cssSelector("html body")).getText();
        switchToMainWindow();
        return text;
    }
}

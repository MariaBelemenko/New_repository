package com.thomsonreuters.pageobjects.pages.pageCreation;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * Created by Phil Harper on 06/05/2016. The Topics and Resources Tabs are Tabs that the user MAY see on
 * SOME Practice Area pages after selecting a particular Practice Area.
 */

public class PracticeAreaTopicsResourcesTabs extends AbstractPage {

    public WebElement TopicsTab() {
        return waitForExpectedElement(By.xpath("//a[@class='co_tabLink'][@href='#'][contains(.,'Topics')]"));
    }

    public WebElement TopicDefault(String TopicName) {
        return waitForExpectedElement(By.xpath("//div[@id='coid_categoryBoxTabPanel1']//ul/li/a[normalize-space(.)" +
                "=\"" + TopicName + "\"]"));
    }
    //div[@id='coid_categoryBoxTabPanel1']//ul/li/a[normalize-space(.)="Insurance"]

    public WebElement TopicCompetition(String TopicName) {
        return waitForExpectedElement(By.xpath("//div[@id='coid_categoryBoxTabPanel2']//ul/li/a[normalize-space(.)" +
                "=\"" + TopicName + "\"]"));
    }

    public WebElement TopicEULaw(String TopicName) {
        return waitForExpectedElement(By.xpath("//div[@id='coid_categoryBoxTabPanel3']//ul/li/a[normalize-space(.)" +
                "='" + TopicName + "']"));
    }

    public WebElement ResourcesTab() {
        return waitForExpectedElement(By.xpath("//a[@class='co_tabLink'][@href='#'][contains(.,'Resources')]"));
    }

    public WebElement ResourcesDefault(String ResourcesName) {
        return waitForExpectedElement(By.xpath("//div[@id='coid_categoryBoxTabPanel2']//ul/li/a[normalize-space(.)" +
                "='" + ResourcesName + "']"));
    }

    public WebElement ResourcesDefaultLabel() {
        return waitForExpectedElement(By.xpath("//div[@id='coid_categoryBoxTabPanel2']//ul/li/a"));
    }
    public WebElement ResourcesCompetitionEU(String ResourcesName) {
        return waitForExpectedElement(By.xpath("//div[@id='coid_categoryBoxTab1SubPanel1-0-main']//ul/li/a[normalize-space(.)" +
                "='" + ResourcesName + "']"));
    }

    public WebElement ResourcesCompetitionUK(String ResourcesName) {
        return waitForExpectedElement(By.xpath("//div[@id='coid_categoryBoxTab1SubPanel2-0-main']//ul/li/a[normalize" +
                "-space(.)" + "='" + ResourcesName + "']"));
    }

    public WebElement ResourcesEULaw(String ResourcesName) {
        return waitForExpectedElement(By.xpath("//div[@id='coid_categoryBoxTabPanel1']//ul/li/a[normalize-space(.)" +
                "='" + ResourcesName + "']"));
    }

 /*   return waitForExpectedElement(By.xpath("//div[@class='co_genericBoxFooter']/a[contains(.,'Go to Ask:')" +
            "][contains(.,'" + PracticeArea + "')]"));
*/
}

package com.thomsonreuters.askRewrite.pages;


import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

public class AskPage extends AbstractPage {

    public AskPage() {

    }

    public WebElement askHeading() {
        return waitForExpectedElement(By.xpath("//h1[text()='Ask']"));
    }

    public WebElement askByPracticeAreaHeading() {
        return waitForExpectedElement(By.xpath("//h2[text()='Ask by practice area']"));
    }

    public WebElement latestQuestionsHeading() {
        return waitForExpectedElement(By.xpath("//h2[text()='Latest questions']"));
    }

    public WebElement specificAskAreaHeading() {
        return waitForExpectedElement(By.cssSelector("div[id='askplc_newpromo'] h1"));
    }

    public WebElement browseQueriesByTopicHeading() {
        return waitForExpectedElement(By.xpath("//h2[text()='Browse queries by topic']"));
    }

    public WebElement recentQueriesHeading() {
        return waitForExpectedElement(By.xpath("//h2[text()='Recent queries']"));
    }

    public WebElement featuredQueriesHeading() {
        return waitForExpectedElement(By.xpath("//h2[text()='Featured queries']"));
    }

}
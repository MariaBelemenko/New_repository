package com.thomsonreuters.askRewrite.pages;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;


public class AskUpdates extends AbstractPage {

    public WebElement textAreaComment() {
        return waitForExpectedElement(textAreaCommentSelector());
    }

    public By textAreaCommentSelector() {
        return By.id("mce_editor_0");
    }

    public WebElement repliedCommentDate() {
        return waitForExpectedElement(By.className("commentDate"));
    }

    public WebElement repliedComment() {
        return waitForExpectedElement(By.cssSelector("div[id*='comment_']"));
    }

    public WebElement addReplyLinkInComments() {
        return waitForExpectedElement(By.cssSelector("div[id='askPlcCommentsContainer'] > div.comment > div.commentActionPanel a:nth-of-type(1)"));
    }

    public List<WebElement> getAllComments() {
        return waitForExpectedElements(By.cssSelector("div[id='askPlcCommentsContainer'] div.comment"));
    }

    public boolean isSpecificCommentExists(String comment) {
        List<WebElement> commentsList= null;
        try {
            commentsList = waitForExpectedElements(By.cssSelector("div[id='askPlcCommentsContainer'] div.comment"));
        } catch (Exception e) {
            return false;
        }

        for (WebElement webelement : commentsList) {
            try {
                if(webelement.getText().contains(comment)){
                    return true;
                }
            } catch (StaleElementReferenceException e) {
                if(webelement.getText().contains(comment)){
                    return true;
                }
            }
        }
        return false;
    }

    public WebElement reportThisPostLinkInComments() {
        return waitForExpectedElement(By.cssSelector("div[id='askPlcCommentsContainer'] > div.comment > div.commentActionPanel a:nth-of-type(2)"));
    }

    public WebElement editThisPostLinkInComments() {
        return waitForExpectedElement(By.cssSelector("div[id='askPlcCommentsContainer'] > div.comment > div.commentActionPanel a:nth-of-type(4)"));
    }

    public WebElement removeThisPostLinkInComments() {
        return waitForExpectedElement(By.cssSelector("div[id='askPlcCommentsContainer'] > div.comment > div.commentActionPanel a:nth-of-type(3)"));
    }

    public WebElement commentAuthor() {
        return waitForExpectedElement(By.cssSelector("div[id='askPlcCommentsContainer'] > div.comment > div.commentAuthor"));
    }

    public WebElement joinTheDiscussion() {
        return waitForExpectedElement(By.className("askplc-join-discussion"));
    }


    public WebElement termsAndCondtnsCheckBox() {
        return waitForExpectedElement(By.id("commentTermsAccepted"));
    }

    public WebElement displayNameAndOrg() {
        return waitForExpectedElement(By.id("showAuthor"));
    }

    public WebElement displayName() {
        return waitForExpectedElement(By.id("displayName"));
    }
    public WebElement displayService() {
        return waitForExpectedElement(By.id("displayService"));
    }

    public WebElement submitReplyButton() {
        return waitForExpectedElement(By.id("commentSubmit"));
    }
}

package com.thomsonreuters.pageobjects.utils.email;

import com.thomsonreuters.driver.framework.AbstractPage;
import com.thomsonreuters.pageobjects.pages.mailinator.MailinatorPage;
import org.openqa.selenium.TimeoutException;

public class MailinatorMethods extends AbstractPage {

    private MailinatorPage mailinatorPage = new MailinatorPage();

    private final String MAILINATOR_URL =  "https://www.mailinator.com/";

    public MailinatorMethods() {
    }

    public void navigateToMailinatorSite() {
        navigate(MAILINATOR_URL);
        waitForPageToLoadAndJQueryProcessing();
    }

    public boolean openEmailBoxAndcheckUserMail(String userEmail, String sender, String subject) throws InterruptedException {
        openInboxFolder(userEmail);
        mailinatorPage.userMailBoxHeading();
        Thread.sleep(60000);
        for (int row = 0; row < mailinatorPage.emailFrom().size(); row++) {
            LOG.info("Email sender: " + mailinatorPage.emailFrom().get(row).getText());
            LOG.info("Email subject: " + mailinatorPage.emailSubject().get(row).getText());
            if (mailinatorPage.emailFrom().get(row).getText().equalsIgnoreCase(sender)
                    && mailinatorPage.emailSubject().get(row).getText().trim().contains(subject.trim())) {
                return true;
            }
        }
        return false;
    }

    public void openEmailBoxAndDeleteAllEmails(String userEmail) {
        openInboxFolder(userEmail);
        mailinatorPage.userMailBoxHeading();
        int emailsCount = 0;
        try{
            emailsCount = mailinatorPage.emailFrom().size();
        } catch(TimeoutException e){
            LOG.info("Email folder is empty");
        }
        while (emailsCount > 0) {
            mailinatorPage.emailFrom().get(0).click();
            mailinatorPage.deleteEmailButton().click();
            emailsCount--;
        }
    }

    private void openInboxFolder(String userEmail) {
        LOG.info("Checking inbox for email user: " + userEmail);
        mailinatorPage.checkMailTextBox().sendKeys(userEmail);
        mailinatorPage.checkItButton().click();
    }

}

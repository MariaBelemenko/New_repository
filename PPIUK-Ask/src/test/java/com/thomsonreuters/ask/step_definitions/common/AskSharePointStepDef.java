package com.thomsonreuters.ask.step_definitions.common;

import com.thomsonreuters.ask.step_definitions.BaseStepDef;
import com.thomsonreuters.driver.framework.WebDriverDiscovery;
import com.thomsonreuters.pageobjects.pages.ask.AskSharePointPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import org.assertj.core.api.SoftAssertions;
import org.hamcrest.core.Is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Pavel_Ardenka on 16/02/2016.
 */
public class AskSharePointStepDef extends BaseStepDef {

    private static final String ASK_EMAIL = "AskTestuser@mailinator.com";
    // If ask form invoked not from doc view page than URL won't be populated. It is ok, see details in TFS 858408
    private static final String ASK_DOCUMENT_URL = "";
    private static final String ASK_PLC_DOCUMENT_ID_EMPTY = "";
    private static final String ASK_DOCUMENT_URL_EMPTY = "";
    private static final String SUBSCRIBER = "No";
    private static final String ANSWERING_STATUS = "Not started";

    private String firstName;
    private String lastName;
    private String answeringService;
    private String postion;
    private String organisationType;
    private String fullName;
    private String askReference;
    private String documentId;
    private String documentURL;

    private AskSharePointPage askSharePointPage = new AskSharePointPage();
    private WebDriverDiscovery webDriverDiscovery = new WebDriverDiscovery();

    /**
     * Read data from test data table
     * To check Document ID or Document URL
     * @param dataTable
     */
    private void readDataFromFeatureFile(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        answeringService = map.get("Answering Service");
        postion = map.get("Position");
        firstName = map.get("First Name");
        lastName = map.get("Last Name");
        organisationType = map.get("Organisation Type");
        fullName = firstName + " " + lastName;
        if (map.get("PLC Document ID") == null) {
            documentId = ASK_PLC_DOCUMENT_ID_EMPTY;
            documentURL = ASK_DOCUMENT_URL;
        } else {
            String tmpPlcDocId = map.get("PLC Document ID");
            // If relative url was specified in feature
            documentId = (tmpPlcDocId.startsWith("http")) ? tmpPlcDocId :
                    webDriverDiscovery.getCurrentRootAddress(true) + tmpPlcDocId;
            documentURL = ASK_DOCUMENT_URL_EMPTY;
        }
    }

    @And("^the question is correctly displayed on the ASK SharePoint site$")
    public void the_question_is_correctly_displayed_on_the_ASK_SharePoint_site(DataTable dataTable) throws Throwable {
        String nowDate = getCurrentLondonTime();
        readDataFromFeatureFile(dataTable);
        goSharePointFeedbackTeamPage(answeringService);
        checkAskPresentInUnassignedItems(nowDate);
        openSubscriberTabAskReference(askReference);
        checkSubscriberDetails(firstName, lastName, ASK_EMAIL, organisationType, postion, documentId,
                documentURL, askReference, SUBSCRIBER, answeringService, ANSWERING_STATUS);
    }

    //TODO to refactor
    private void checkAskPresentInUnassignedItems(String nowDate) {
        boolean found = false;
        String sharePointDate = null;
        for (int i = askSharePointPage.unAssignedItems().size() - 1; i >= 0; i--) {
            WebElement rowElement = askSharePointPage.unAssignedItems().get(i);
            askReference = rowElement.findElement(askSharePointPage.getSelectorWithinRowForRefid()).getText();
            sharePointDate = rowElement.findElement(askSharePointPage.getSelectorWithinRowForDate()).getText();
            String sharePointName = rowElement.findElement(askSharePointPage.getSelectorWithinRowForName()).getText();
            String sharePointPosition = rowElement.findElement(askSharePointPage.getSelectorWithinRowForPosition())
                    .getText();
            if (isDateCorrect(nowDate, sharePointDate) && sharePointName.equalsIgnoreCase(fullName)
                    && sharePointPosition.equalsIgnoreCase(postion)) {
                found = true;
                break;
            }
        }
        assertThat("Submitted Question is NOT found in SharePoint for Position " + postion + " name " + fullName
                + " date " + sharePointDate, found, Is.is(true));
    }

    private String getCurrentLondonTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM YY HH:mm");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(new Date());
    }

    private void openSubscriberTabAskReference(String askReference) {
        askSharePointPage.waitForElementPresent(By.linkText(askReference)).click();
        askSharePointPage.subscriberLink().click();
    }

    /**
     * Check date is correct with +2 minutes interval
     *
     * @param nowDate
     * @param sharePointDate
     * @return
     */
    private boolean isDateCorrect(String nowDate, String sharePointDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM YY HH:mm");
        Date now = null;
        Date sharePoint = null;
        try {
            now = formatter.parse(nowDate);
            sharePoint = formatter.parse(sharePointDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return now.getTime() - sharePoint.getTime() <= 2 * 60 * 1000;
    }

    private void goSharePointFeedbackTeamPage(String feedbackTeamPage) {
        askSharePointPage.waitForPageToLoad();
        askSharePointPage.navigateToSharePointSite();
        // Sometimes Share Point is very slow
        try {
            Thread.sleep(10000);
            LOG.info("Open page '" + feedbackTeamPage + "'");
            askSharePointPage.feedbackTeamLink(feedbackTeamPage).click();
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        askSharePointPage.waitForPageToLoad();
    }

    /**
     * Check data on Subscriber screen
     *
     * @param expectedFirstName
     * @param expectedLastName
     * @param expectedEmail
     * @param expectedOrgType
     * @param expectedPostion
     * @param expectedPlcDocumentId
     * @param expectedAskDocumentUrl
     * @param expectedAskReference
     * @param expectedSubscriber
     * @param expectedAnsweringService
     * @param expectedAnsweringStatus
     */
    private void checkSubscriberDetails(String expectedFirstName, String expectedLastName, String expectedEmail,
                                        String expectedOrgType, String expectedPostion, String expectedPlcDocumentId,
                                        String expectedAskDocumentUrl, String expectedAskReference, String expectedSubscriber,
                                        String expectedAnsweringService, String expectedAnsweringStatus) {
        SoftAssertions softly = new SoftAssertions();
        String actualFirstName = askSharePointPage.webFormDetailsFirstNameText().getText();
        softly.assertThat(actualFirstName.equals(expectedFirstName))
                .overridingErrorMessage("First Name expected: %s, actual is : %s", expectedFirstName, actualFirstName)
                .isTrue();

        String actualLastName = askSharePointPage.webFormDetailsLastNameText().getText();
        softly.assertThat(actualLastName.equals(expectedLastName))
                .overridingErrorMessage("Last Name expected: %s, actual is : %s", expectedLastName, actualLastName)
                .isTrue();

        String actualEmail = askSharePointPage.webFormDetailsEmailText().getText();
        softly.assertThat(actualEmail.equals(expectedEmail))
                .overridingErrorMessage("Email expected: %s, actual is : %s", expectedEmail, actualEmail).isTrue();

        String actualOrgtype = askSharePointPage.webFormDetailsOrgTypeText().getText();
        softly.assertThat(actualOrgtype.equals(expectedOrgType))
                .overridingErrorMessage("Organisation Type expected: %s, actual is : %s", expectedOrgType,
                        actualOrgtype).isTrue();

        String actualPostion = askSharePointPage.webFormDetailsPositionText().getText();
        softly.assertThat(actualPostion.equalsIgnoreCase(expectedPostion))
                .overridingErrorMessage("Position expected: %s, actual is : %s", expectedPostion, actualPostion)
                .isTrue();

        String actualPlcDocumentId = askSharePointPage.webFormDetailsPlcDocumentIdText().getText();
        softly.assertThat(actualPlcDocumentId.equals(expectedPlcDocumentId))
                .overridingErrorMessage("Plc Document Id expected: %s, actual is : %s", expectedPlcDocumentId,
                        actualPlcDocumentId).isTrue();

        String actualAskDocumentUrl = askSharePointPage.webFormDetailsDocumentUrlText().getText();
        softly.assertThat(actualAskDocumentUrl.contains(expectedAskDocumentUrl))
                .overridingErrorMessage("Reference expected: %s, actual is : %s", expectedAskDocumentUrl,
                        actualAskDocumentUrl).isTrue();

        String actualAskReference = askSharePointPage.statusAndActionsReferenceText().getText();
        softly.assertThat(actualAskReference.equals(expectedAskReference))
                .overridingErrorMessage("Reference expected: %s, actual is : %s", expectedAskReference,
                        actualAskReference).isTrue();

        String actualSubscriber = askSharePointPage.statusAndActionsSubscriberText().getText();
        softly.assertThat(actualSubscriber.equals(expectedSubscriber))
                .overridingErrorMessage("Subscriber expected: %s, actual is : %s", expectedSubscriber, actualSubscriber)
                .isTrue();

        String actualAnsweringService = askSharePointPage.statusAndActionsAssignedServiceText().getText();
        softly.assertThat(actualAnsweringService.equals(expectedAnsweringService))
                .overridingErrorMessage("Assigned Service expected: %s, actual is : %s", expectedAnsweringService,
                        actualAnsweringService).isTrue();

        String actualAnsweringStatus = new Select(askSharePointPage.statusAndActionsAnsweringStatusDropDown())
                .getFirstSelectedOption().getText();
        softly.assertThat(actualAnsweringStatus.equals(expectedAnsweringStatus))
                .overridingErrorMessage("Answering Status expected: %s, actual is : %s", expectedAnsweringStatus,
                        actualAnsweringStatus).isTrue();
        softly.assertAll();
    }

}

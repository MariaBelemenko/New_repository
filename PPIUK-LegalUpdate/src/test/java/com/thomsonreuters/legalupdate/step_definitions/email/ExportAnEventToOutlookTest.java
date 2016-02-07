package com.thomsonreuters.legalupdate.step_definitions.email;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.FileActions;
import com.thomsonreuters.pageobjects.common.WindowHandler;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.legalUpdates.CalendarWidget;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesPracticeAreaPage;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class ExportAnEventToOutlookTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private LegalUpdatesPracticeAreaPage legalUpdatesPracticeAreaPage = new LegalUpdatesPracticeAreaPage();
    private CalendarWidget calendarWidget = new CalendarWidget();
    private WindowHandler windowHandler = new WindowHandler();
    private FileActions fileActions = new FileActions();

    private File downloadedFile = null;

    private final static String FILE_NAME = "calendar.ics";
    private final static String DOWNLOADED_FILE_PATH = System.getProperty("user.home") + "/Downloads";

    private final String MEDIA_AND_TELECOMS_PAGE = "/Browse/Home/Practice/MediaTelecoms";

    @Given("^a user is viewing the calendar widget on the 'Media & telecoms' practice area page$")
    public void aUserIsViewingTheCalendarWidgetOnTheMediaTelecomsPracticeAreaPage() throws Throwable {
        navigationCobalt.navigateToPLCUKPlusSpecificURL(MEDIA_AND_TELECOMS_PAGE);
        legalUpdatesPracticeAreaPage.waitForPageToLoadAndJQueryProcessing();
    }

    @Given("^the user has clicks on an event indicator on the calendar widget$")
    public void theUserHasClicksOnAnEventIndicatorOnTheCalendarWidget() throws Throwable {
        calendarWidget.eventMarker().click();
        calendarWidget.waitForPageToLoadAndJQueryProcessing();
    }

    @Given("^the user has been presented with the event pop-up$")
    public void theUserHasBeenPresentedWithTheEventPopUp() throws Throwable {
        assertTrue("Event LightBox is not displayed", calendarWidget.eventLightBox().isDisplayed());
    }

    @When("^the user clicks 'Add to outlook' link on the pop-up for an event$")
    public void theUserClicksAddToOutlookLinkOnThePopUpForAnEvent() throws Throwable {
        windowHandler.fileDownload(calendarWidget.addToOutlookLink());
    }

    @Then("^the event \\.ics file for the selected event should download to the users machine$")
    public void theEventIcsFileForTheSelectedEventShouldDownloadToTheUsersMachine() throws Throwable {
        downloadedFile = fileActions.findFile(FILE_NAME, DOWNLOADED_FILE_PATH);
        assertTrue("File was not downloaded", downloadedFile != null && downloadedFile.exists());
    }

    @After(order = 40000, value = "@DeleteDownloadedCalendarFile")
    public void deleteDownloadedCalendarFile() {
        fileActions.deleteFile(downloadedFile);
    }


}

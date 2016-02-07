package com.thomsonreuters.legalupdate.step_definitions.common;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.legalUpdates.CalendarWidget;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesPracticeAreaPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import static org.junit.Assert.assertTrue;

public class PopUpShouldSpanWidthOfPageTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private LegalUpdatesPracticeAreaPage legalUpdatesPracticeAreaPage = new LegalUpdatesPracticeAreaPage();
    private CalendarWidget calendarWidget = new CalendarWidget();

    private final String MEDIA_AND_TELECOMS_PAGE = "/Browse/Home/Practice/MediaTelecoms";

    @Given("^a user is viewing a the calendar widget on a practice area page$")
    public void aUserIsViewingATheCalendarWidgetOnAPracticeAreaPage() throws Throwable {
        navigationCobalt.navigateToPLCUKPlusSpecificURL(MEDIA_AND_TELECOMS_PAGE);
        legalUpdatesPracticeAreaPage.waitForPageToLoadAndJQueryProcessing();
        assertTrue("Calendar widget is not displayed", legalUpdatesPracticeAreaPage.calendarWidget().isDisplayed());
    }

    @When("^the user clicks on an event indicator on the widget$")
    public void theUserClicksOnAnEventIndicatorOnTheWidget() throws Throwable {
        calendarWidget.eventMarker().click();
        calendarWidget.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^the user should be presented with the event pop-up$")
    public void theUserShouldBePresentedWithTheEventPopUp() throws Throwable {
        assertTrue("Event LightBox is not displayed", calendarWidget.eventLightBox().isDisplayed());
    }

    @Then("^the event pop-up should expand to the left edge of the page$")
    public void theEventPopUpShouldExpandToTheLeftEdgeOfThePage() throws Throwable {
        Point calendarPoint = legalUpdatesPracticeAreaPage.calendarWidget().getLocation();
        Point eventLightBoxPoint = calendarWidget.eventLightBox().getLocation();
        int deltaP = Math.abs(calendarPoint.getX() - eventLightBoxPoint.getX());
        Dimension eventLightBoxDimension = calendarWidget.eventLightBox().getSize();
        Dimension calendarWidgetDimension = legalUpdatesPracticeAreaPage.calendarWidget().getSize();
        assertTrue("Event LightBox is not exoanded to tehe left edge of page",
                deltaP == eventLightBoxDimension.getWidth() && calendarWidgetDimension.getHeight() == eventLightBoxDimension.getHeight());
    }

}

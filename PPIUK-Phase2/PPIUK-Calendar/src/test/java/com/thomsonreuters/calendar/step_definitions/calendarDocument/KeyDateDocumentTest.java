package com.thomsonreuters.calendar.step_definitions.calendarDocument;

import com.thomsonreuters.calendar.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.ListFunctions;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.calendar.CalendarWidgetPage;
import com.thomsonreuters.pageobjects.pages.calendar.KeyDateDocumentPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.utils.legalUpdates.CalendarAndDate;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.security.Key;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class KeyDateDocumentTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private KeyDateDocumentPage keyDateDocumentPage = new KeyDateDocumentPage();

    //private CalendarAndDate calendarAndDate =new CalendarAndDate();

    @Then("^the user is on key date document view$")
    public void theUserIsOnKeyDateDocumentView() throws Throwable {
         assertTrue(" Key date document is not visible...!", keyDateDocumentPage.docEventDate().isDisplayed());
    }

    @Then("^the user should be presented with the document body,$")
    public void theUserShouldBePresentedWithTheDocumentBody() throws Throwable {
        assertTrue(" Key date Doc Body is not visible...!", keyDateDocumentPage.keyDateDocumentBody().isDisplayed());

    }

    @Then("^the user should be presented with the resource links,$")
    public void theUserShouldBePresentedWithTheResourceLinks() throws Throwable {
        assertTrue(" Key date Resource Link is not visible...!", keyDateDocumentPage.resourceLinkList().get(0).isDisplayed());
    }

    @Then("^the user should be presented with the metadata,$")
    public void theUserShouldBePresentedWithTheMetadata() throws Throwable {
        assertTrue(" Meta Data Event Type is not visible...!", keyDateDocumentPage.metaDataEventTypeHeading().isDisplayed());
    }

    @Then("^the user should be presented with a maximum of (\\d+) jurisdictions$")
    public void theUserShouldBePresentedWithAMaximumOfJurisdictions(int maxCount) throws Throwable {
        assertTrue(" Key dat document is not visible...!", (keyDateDocumentPage.metaDataJurisdictionValueList().size()<maxCount));
    }

    @Then("^the user should be presented with the display date at the top of the page\\.$")
    public void theUserShouldBePresentedWithTheDisplayDateAtTheTopOfThePage() throws Throwable {
        assertTrue(" Key date is not visible...!", keyDateDocumentPage.docEventDate().isDisplayed());
    }
}

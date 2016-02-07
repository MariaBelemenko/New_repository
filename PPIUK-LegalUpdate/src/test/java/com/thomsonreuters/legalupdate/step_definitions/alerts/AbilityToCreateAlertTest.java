package com.thomsonreuters.legalupdate.step_definitions.alerts;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.RandomGenerator;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.alerts.AlertsCenterPage;
import com.thomsonreuters.pageobjects.pages.alerts.AlertsHeader;
import com.thomsonreuters.pageobjects.pages.alerts.creationBellow.BasicsBellow;
import com.thomsonreuters.pageobjects.pages.alerts.creationBellow.CustomizeDeliveryBellow;
import com.thomsonreuters.pageobjects.pages.alerts.creationBellow.SelectContentBellow;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class AbilityToCreateAlertTest extends BaseStepDef {

    private NavigationCobalt navigation = new NavigationCobalt();
    private AlertsCenterPage alertsCenterPage = new AlertsCenterPage();
    private BasicsBellow basicsBellow = new BasicsBellow();
    private SelectContentBellow selectContentBellow = new SelectContentBellow();
    private CustomizeDeliveryBellow customizeDeliveryBellow = new CustomizeDeliveryBellow();
    private AlertsHeader alertsHeader = new AlertsHeader();

    @When("^user go to alerts center page$")
    public void aUserGoToAlertsCenterPage() throws Throwable {
        navigation.navigateToPLCUKPlusSpecificURL("/Alerts/Center");
    }

    @When("^user selects the alert type of '(.+)' to create$")
    public void userSelectsScecificAlertTypeToCreate(String alertType) throws Throwable {
        alertsCenterPage.waitForPageToLoadAndJQueryProcessing();
        alertsCenterPage.createAlertDropdownLink().click();
        alertsCenterPage.createSpecificAlertLink(alertType).click();
    }

    @Given("^that a user is on the Legal Update creation page '(.+)' bellow,$")
    public void thatAUserIsOnTheLegalUpdateCreationPageScheduleAlertBellow(String bellowName) throws Throwable {
        switch (bellowName) {
            case "basics":
                break;
            case "content":
                basicsBellow.continueBasicsButton().click();
                break;
            case "customise delivery":
                selectContentBellow.continueContentButton().click();
                break;
            case "schedule alert":
                customizeDeliveryBellow.continueDeliveryButton().click();
                break;
            default:
                throw new IllegalArgumentException("Invalid page bellow: " + bellowName);
        }
    }

    @Then("^the user should be presented with the ability to enter '(.+)' name for their alert,$")
    public void theUserShouldBePresentedWithTheAbilityToEnterANameForTheirAlert(String namePrefix) throws Throwable {
        String alertName = RandomGenerator.stringPlusCurrentDate(namePrefix);
        WebElement alertNameInput = basicsBellow.alertNameInput();
        alertNameInput.sendKeys(alertName);
        String storedAlertName = basicsBellow.getTextFromInputOrTextarea(alertNameInput);
        assertEquals("Inputed string alert name not equals to stored", alertName, storedAlertName);
    }

    @Then("^the user should be presented with their client ID,$")
    public void theUserShouldBePresentedWithTheirClientID() throws Throwable {
        assertEquals("Client Id is not right", basicsBellow.clientIDSpan().getText(), alertsHeader.sessionAnchor().getText());
    }

    @Then("^the user should have the ability to enter '(.+)' Description for their alert$")
    public void theUserShouldHaveTheAbilityToEnterADescriptionForTheirAlert(String alertDesc) throws Throwable {
        WebElement alertDescriptionInput = basicsBellow.alertDescriptionTextarea();
        alertDescriptionInput.sendKeys(alertDesc);
        String storedAlertDesc = basicsBellow.getTextFromInputOrTextarea(alertDescriptionInput);
        assertEquals("Inputed string description not equals to stored", alertDesc, storedAlertDesc);
    }

}

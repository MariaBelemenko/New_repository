package com.thomsonreuters.khpadd.step_definitions.knowHowDocuments;

import com.thomsonreuters.khpadd.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.DocumentRightPanelPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class JurisdictionInformationTest extends BaseStepDef {

    private DocumentRightPanelPage rightPanelPage = new DocumentRightPanelPage();

    @Then("^following jurisdictions are displayed on the document right hand panel$")
    public void followingJurisdictionsAreDisplayedOnTheDocumentRightHandPanel(List<String> expectedJurisdictions) throws Throwable {
        if (expectedJurisdictions.size() == 1 && expectedJurisdictions.get(0).contains(",")) {
            assertThat(rightPanelPage.getVisibleJurisdictions(), Is.is(Arrays.asList(expectedJurisdictions.get(0).split(","))));
        } else {
            if (expectedJurisdictions.get(0).equalsIgnoreCase("No Jurisdictions")) {
                LOG.debug("No Jurisdictions are displayed for this resource type");
            } else {
                assertThat(rightPanelPage.getVisibleJurisdictions(), Is.is(expectedJurisdictions));
            }
        }
    }

    @Then("^link 'View all' to display more jurisdictions is not displayed$")
    public void linkToDisplayMoreJurisdictionsIsNotDisplayed() throws Throwable {
        assertThat(rightPanelPage.isViewAllLinkDisplayed(), Is.is(false));
    }

    @When("^user agrees to view the document if out of plan$")
    public void viewOutOfPlanDocument() throws Throwable {
        if (rightPanelPage.findElements(By.id("co_WarnViewOkButton")).size() > 0) {
            rightPanelPage.findElement(By.id("co_WarnViewOkButton")).click();
        }
    }

    @When("^user clicks on 'View all' link to view all jurisdictions$")
    public void userClicksOnLinkToViewAllJurisdictions() throws Throwable {
        rightPanelPage.jurisdictionViewAllLink().click();
    }

    @Then("^the user can read the label listing the countries as \"(.*?)\"$")
    public void theUserCanReadTheLabelListingTheCountriesAs(String label) throws Throwable {
        assertThat(rightPanelPage.jurisdictionLabel().getText(), Is.is(label));
    }

}

package com.thomsonreuters.khpadd.step_definitions.topicPage;

import com.thomsonreuters.khpadd.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.delivery.EmailOptionsPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.ListOfItemsDeliveryOptionsPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.TopicPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;
import org.openqa.selenium.TimeoutException;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class TopicPageDeliveryTest extends BaseStepDef {

    private TopicPage topicPage = new TopicPage();
    private ListOfItemsDeliveryOptionsPage listOfItemsDeliveryOptionsPage = new ListOfItemsDeliveryOptionsPage();
    private EmailOptionsPage email = new EmailOptionsPage();

    @When("^the user (selects|unselects) the following Editor's Picks resources$")
    public void theUserSelectsTheFollowingEditorSPicksResources(String selection, List<String> resources) throws Throwable {
        if ((selection.equals("selects")) || (selection.equals("unselects"))) {
            for (String resource : resources) {
                topicPage.selectEditorsPickResourceByTitle(resource);
            }
        }
    }

    @Then("^the following icons are enabled$")
    public void theFollowingIconsAreEnabled(List<String> deliveryOptions) throws Throwable {
        for (String option : deliveryOptions) {
            assertThat(option + " is disabled", listOfItemsDeliveryOptionsPage.EnabledDeliveryOption(option), Is.is(true));
        }
    }

    @Then("^the following icons are disabled")
    public void theFollowingIconsAreDisabled(List<String> deliveryOptions) throws Throwable {
        for (String option : deliveryOptions) {
            assertThat(option + " is enabled", listOfItemsDeliveryOptionsPage.DisabledDeliveryOption(option), Is.is(true));
        }
    }

    @When("^the user (selects|unselects) the following Topic page resources$")
    public void theUserSelectsTheFollowingTopicPageResources(String selection, List<String> resources) throws Throwable {
        if ((selection.equals("selects")) || (selection.equals("unselects"))) {
            for (String resource : resources) {
                topicPage.selectTopicPageResourceByTitle(resource);
            }
        }
    }

    @When("^the user selects \"(Email|Print|Download|Save to Folder)\" delivery option on Topics Page$")
    public void theUserSelectsDeliveryOptionOnTopicsPage(String deliveryOption) throws Throwable {
        switch (deliveryOption) {
            case "Email":
                listOfItemsDeliveryOptionsPage.emailLink().click();
                email.emailButton().isDisplayed();
                break;
            case "Print":
                listOfItemsDeliveryOptionsPage.printLink().click();
                break;
            case "Download":
                listOfItemsDeliveryOptionsPage.downloadLink().click();
                break;
            case "Save to Folder":
                listOfItemsDeliveryOptionsPage.saveToFolderLink().click();
                break;
            default:
                break;
        }
    }

    @Then("^the 'Expanded Margin for Notes' is not displayed on the advanced tab$")
    public void theExpandedMarginForNotesIsNotDisplayedOnTheAdvancedTab() throws Throwable {
        try {
            assertThat(" Expanded Margin for Notes is displayed", email.expandedMarginForNotes().isDisplayed(), Is.is(false));
        } catch (TimeoutException te) {
            LOG.info("Expanded Margin for Notes is not displayed when delivering list of items");
        }
    }

    @When("^an email with the list of resources is sent successfully by clicking on the Email button$")
    public void anEmailWithTheListOfResourcesIsSentSuccessfullyByClickingOnTheEmailButton() throws Throwable {
        email.emailButton().click();
        email.waitForSuccessDeliveryMessage("The items will be emailed.");
    }

}

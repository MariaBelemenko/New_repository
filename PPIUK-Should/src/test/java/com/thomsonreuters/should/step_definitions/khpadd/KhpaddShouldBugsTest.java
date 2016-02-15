package com.thomsonreuters.should.step_definitions.khpadd;

import com.thomsonreuters.pageobjects.pages.delivery.EmailOptionsPage;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.DocumentRightPanelPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.ListOfItemsDeliveryOptionsPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.TopicPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.documentNavigation.DocumentNavigationPage;
import com.thomsonreuters.pageobjects.utils.delivery.DeliveryFormField;
import com.thomsonreuters.pageobjects.utils.form.FormUtils;
import com.thomsonreuters.should.step_definitions.BaseStepDef;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KhpaddShouldBugsTest extends BaseStepDef {

    private HomePage homePage = new HomePage();
    private KHResourcePage resourcePage = new KHResourcePage();
    private TopicPage topicPage = new TopicPage();
    private ListOfItemsDeliveryOptionsPage listOfItemsDeliveryOptionsPage = new ListOfItemsDeliveryOptionsPage();
    private EmailOptionsPage email = new EmailOptionsPage();
    private FormUtils formUtils = new FormUtils();
    private DocumentRightPanelPage rightPanelPage = new DocumentRightPanelPage();
    private DocumentNavigationPage documentNavigationPage = new DocumentNavigationPage();

    @When("^the user navigates to practice area \"(.*?)\" filtered by \"(.*?)\" topic page$")
    public void theUserNavigatesToPracticeAreaFilteredByTopicPage(String practiceArea, String topicName) throws Throwable {
        homePage.selectLinkPresentOnTab(practiceArea);
        topicPage.clickTopicLinkOnPAPage(topicName).click();
        Thread.sleep(2000);
        resourcePage.waitForPageToLoad();
    }

    @When("^the user (selects|unselects) the following Topic page resources$")
    public void theUserSelectsTheFollowingTopicPageResources(String selection, List<String> resources) throws Throwable {
        if ((selection.equals("selects")) || (selection.equals("unselects"))) {
            for (String resource : resources) {
                topicPage.selectTopicPageResourceByTitle(resource);
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

    @When("^clicks on the facet group \"(.*?)\"$")
    public void clicksOnTheFacetGroup(String facetName) throws Throwable {
        topicPage.facetNameLink(facetName).click();
        topicPage.waitForPageToLoad();
        Thread.sleep(1000);
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

    @Then("^the user should be able to see (Email|Print|Download) (basic|advanced) tab options as follows$")
    public void theUserShouldBeAbleToSeeEmailBasicTabOptionsAsFollows(String deliveryType, String tabType, DataTable dataTable) throws Throwable {
        for (Map.Entry<String, String> entry : dataTable.asMap(String.class, String.class).entrySet()) {
            String value;
            try {
                value = formUtils.getValue(DeliveryFormField.getByFieldDisplayName(entry.getKey())).trim();
            } catch (Exception e) {
                throw new Exception("Could not find or modify field '" + entry.getKey() + "'", e);
            }
            assertThat(value, Is.is(entry.getValue().trim()));
        }
    }

    @Then("^user closes the delivery box by clicking on the cancel button$")
    public void userClosesTheDeliveryBoxByClickingOnTheButton() throws Throwable {
        email.cancelButton().click();
    }

    @Then("^document title is displayed as \"(.*?)\"$")
    public void titleIsDisplayedAs(String title) throws Throwable {
        assertThat(resourcePage.title().getText().trim().replaceAll("\\n", " "), Is.is(title.replaceAll("\\\\n", " ")));
    }

    @Then("^\"(.*?)\" is displayed underneath the title$")
    public void isDisplayedUnderneathTheTitle(String author) throws Throwable {
        try {
            String authorText = resourcePage.author().getText().trim();
            String authorTrimmed = authorText.substring(3);
            assertThat(authorTrimmed, Is.is(author));
        } catch (NoSuchElementException npe) {
            if (author.equalsIgnoreCase("No Author")) {
                LOG.debug("No Author is displayed for this resource type");
            } else {
                throw npe;
            }
        }
    }

    @Given("^resource status \"(.*?)\" is displayed on the document right hand panel$")
    public void resourceStatusIsDisplayed(String expectedStatus) throws Throwable {
        try {
            assertThat(rightPanelPage.documentStatus().getText().trim().replaceAll("\\n", ""), Is.is(expectedStatus.replaceAll("\\\\n", "")));
        } catch (NoSuchElementException npe) {
            if (expectedStatus.equalsIgnoreCase("No Status")) {
                LOG.debug("No Status is displayed for this resource type");
            } else {
                throw npe;
            }
        }
    }

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

    @Then("^'(Related Content|View Resource History)' link is (displayed|Not displayed) on the right hand panel$")
    public void relatedContentLinkIsDisplayedOnTheRightHandPanel(String linkText, String display) throws Throwable {
        try {
            WebElement element = rightPanelPage.relatedOrHistoryLink(linkText);
            assertThat(element.isDisplayed(), Is.is(true));
        } catch (NoSuchElementException npe) {
            if (display.equalsIgnoreCase("displayed")) {
                throw npe;
            } else {
                LOG.debug(linkText + " is not displayed");
            }
        }
    }

    @Then("^resource type is displayed as \"(.*?)\" on right hand panel$")
    public void documentTypeIsDisplayedAsArticles(String documentType) throws Throwable {
        rightPanelPage.waitForPageToLoad();
        assertThat(rightPanelPage.resourceTypeText().getText().trim(), Is.is(documentType));
    }

    @Then("^plc reference is displayed as \"(.*?)\"$")
    public void plcRefIsDisplayedAs(String plcRef) throws Throwable {
        assertThat(resourcePage.plcRef().getText().trim(), Is.is(plcRef));
    }

    @Then("^the user sees Also found in section$")
    public void theUserSeesAlsoFoundInSection() throws Throwable {
        assertTrue("'Also found in' section is not present", documentNavigationPage.linkInAlsoFoundInSection().isDisplayed());
    }

    @Then("^Also Found In section includes link to the relevant Topic page$")
    public void alsoFoundInSectionIncludeLinkToTheRelevantTopicPage() {
        String linkToRelevantTopicPage = documentNavigationPage.linkInAlsoFoundInSection().getAttribute("href").split
                ("\\?")[0];
        documentNavigationPage.linkInAlsoFoundInSection().click();
        topicPage.waitForPageToLoad();
        String actualUrl = topicPage.getCurrentUrl().split("\\?")[0];
        assertEquals("'Also Found In' section has link to irrelevant Topic page", linkToRelevantTopicPage, actualUrl);
    }

}

package com.thomsonreuters.khpadd.step_definitions.knowHowDelivery;

import com.thomsonreuters.khpadd.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.annotations.SharedAnnotationsPage;
import com.thomsonreuters.pageobjects.pages.delivery.EmailOptionsPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.documentNavigation.DocumentDeliveryPage;
import com.thomsonreuters.pageobjects.utils.delivery.DeliveryFormField;
import com.thomsonreuters.pageobjects.utils.form.FormUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class AnyResourceDeliveryTest extends BaseStepDef {

    private DocumentDeliveryPage deliveryPage = new DocumentDeliveryPage();
    private SharedAnnotationsPage sharedAnnotationsPage = new SharedAnnotationsPage();
    private EmailOptionsPage email = new EmailOptionsPage();
    private FormUtils formUtils = new FormUtils();

    public static String input;

    @When("user added new annotation")
    public void userAddedNewAnnotation() throws Throwable {
        deliveryPage.clickOnLink(DocumentDeliveryPage.Links.NEW_ANNOTATION);
        input = "input" + System.currentTimeMillis();
        sharedAnnotationsPage.amendInput(input);
        sharedAnnotationsPage.saveAnnotation();
    }

    @Then("^the user clicks on (Email|Print|Download) advanced tab$")
    public void clicksOnEmailAdvancedTab(String deliveryOption) throws Throwable {
        email.waitTillAdvancedTabIsClickable();
        email.advancedTab().click();
    }

    @Then("^the cover page comment textbox is displayed$")
    public void coverPageCommentIsDisplayed() throws Throwable {
        assertThat(email.coverPageComment().isDisplayed(), Is.is(true));
    }

    @Then("^an email is sent successfully by clicking on the Email button$")
    public void anEmailIsSentSuccessfullyByClickingOnTheEmailButton() throws Throwable {
        email.emailButton().click();
        email.waitForSuccessDeliveryMessage("The item will be emailed.");
    }

    @Then("^the following options will not be displayed$")
    public void theFollowingOptionsWillNotBeDisplayed(List<String> options) throws Throwable {
        for (String option : options) {
            assertThat(option + " is displayed", formUtils.isNotDisplayed(DeliveryFormField.getByFieldDisplayName(option)), Is.is(true));
        }
    }

    @When("^the user selects \"(.*?)\" as email format$")
    public void theUserSelectsAsEmailFormat(String emailFormat) throws Throwable {
        new Select(email.formatDropdown()).selectByVisibleText(emailFormat);
    }

    @Then("^the \"(.*?)\" tab is not displayed$")
    public void advancedTabIsNotDisplayed(String label) throws Throwable {
        try {
            assertThat(label + " is displayed", formUtils.findElement(DeliveryFormField.getByFieldDisplayName(label)).isDisplayed(),
                    Is.is(false));
        } catch (NoSuchElementException ne) {
            LOG.info("Basic tab is not visible when there is nothing to display in it");
        }
    }

    @Then("^the following options get disabled$")
    public void theFollowingOptionsGetDisabled(List<String> fields) throws Throwable {
        for (String field : fields) {
            assertThat(field + " is enabled", email.findElement(DeliveryFormField.getByFieldDisplayName(field).getBy()).isEnabled(),
                    Is.is(false));
        }
    }

}

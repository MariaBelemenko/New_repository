package com.thomsonreuters.legalupdate.step_definitions.email;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.legalUpdates.EmailDeliverWidget;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesResultsPage;
import cucumber.api.java.en.Then;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class SelectEmailDeliveryOptionsTest extends BaseStepDef {

    private LegalUpdatesResultsPage legalUpdatesResultsPage = new LegalUpdatesResultsPage();
    private EmailDeliverWidget emailDeliverWidget = new EmailDeliverWidget();

    private final String[] selectFromatOptions = {"Word Processor (RTF)", "Microsoft Word", "PDF"};

    @Then("^the user is presented with the email delivery lightbox$")
    public void theUserIsPresentedWithTheEmailDeliveryLightbox() throws Throwable {
        assertTrue("Email delivery widget is not visible", legalUpdatesResultsPage.emailIcon().isDisplayed());
    }

    @Then("^the lightbox should contain the features described in the description$")
    public void theLightboxShouldContainTheFeaturesDescribedInTheDescription() throws Throwable {
        int result = 0;
        if (!emailDeliverWidget.isElementDisplayed(emailDeliverWidget.toInput())) {
            result++;
        }
        if (!emailDeliverWidget.isElementDisplayed(emailDeliverWidget.subjectInput())) {
            result++;
        }
        if (!emailDeliverWidget.isElementDisplayed(emailDeliverWidget.emailNoteInput())) {
            result++;
        }
        if (!emailDeliverWidget.isElementDisplayed(emailDeliverWidget.formatSelect())) {
            result++;
        }
        if (!emailDeliverWidget.getAllFormatOptionsFromSelect().containsAll(Arrays.asList(selectFromatOptions))) {
            result++;
        }
        assertTrue("Lightbox contains not all features frpm description list", result == 0);
    }

}

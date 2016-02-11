package com.thomsonreuters.khpadd.step_definitions.knowHowDocuments;

import com.thomsonreuters.khpadd.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class CaseTrackerTest extends BaseStepDef {

    private KHResourcePage resourcePage = new KHResourcePage();

    @Then("^user \"(.*?)\" see the embedded resources within this document$")
    public void userSeeTheEmbeddedResourcesWithinThisDocument(String canOrCannot) throws Throwable {
        if (canOrCannot.equalsIgnoreCase("cannot")) {
            assertThat(resourcePage.visibleEmbeddedResources().size(), Is.is(0));
        } else {
            assertTrue(resourcePage.visibleEmbeddedResources().size() > 0);
        }
    }

    @Then("^user is able to see the \"(.*?)\" link on the document$")
    public void userIsAbleToSeeTheLinkOnTheDocument(String showHideLink) throws Throwable {
        assertThat(resourcePage.showHideIndividualCasesLink(showHideLink).getText().trim(), Is.is(showHideLink));
    }

    @When("^the user clicks on the embedded resources link \"(.*?)\"$")
    public void theUserClicksOnTheEmbeddedResourcesLink(String embeddedLink) throws Throwable {
        try {
            resourcePage.embeddedResourceLink(embeddedLink).click();
        } catch (Exception e) {
            resourcePage.embeddedResourceLink(embeddedLink).click();
        }
    }

    @When("^user clicks on \"(.*?)\" link on this case tracker page$")
    public void userClicksOnLinkOnThisPage(String link) throws Throwable {
        resourcePage.showHideIndividualCasesLink(link).click();
    }

    @Then("^the user is navigated to the child case tracker page with title \"(.*?)\"$")
    public void theUserIsNavigatedToTheChildCaseTrackerPageWithTitle(String title) throws Throwable {
        resourcePage.waitForPageToLoadAndJQueryProcessing();
        assertThat(resourcePage.title().getText().trim(), Is.is(title));
    }

}

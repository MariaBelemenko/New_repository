package com.thomsonreuters.khpadd.step_definitions.knowHowDocuments;

import com.thomsonreuters.khpadd.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEmptyString.isEmptyString;

public class KhpaddWhatsMarketTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private KHResourcePage resourcePage = new KHResourcePage();

    @When("^the user navigates to the main PLCUK page$")
    public void theUserNavigatesToTheMainPLCUKPage() throws Throwable {
        navigationCobalt.navigateToPLUKPlus();
        navigationCobalt.waitForPageToLoad();
    }

    @Then("^the user should not see the \"(.*?)\" tag on the What's Market document$")
    public void theUserShouldNotSeeTheTagOnTheWhatSMarketDocument(String lastViewed) throws Throwable {
        try {
            assertThat(resourcePage.whatsMarketLastViewedTag().getText().trim(), isEmptyString());
        } catch (NoSuchElementException ne) {
            LOG.info("Last Viewed Tag is no more visible on UK What's Market resources");
        }
    }

}

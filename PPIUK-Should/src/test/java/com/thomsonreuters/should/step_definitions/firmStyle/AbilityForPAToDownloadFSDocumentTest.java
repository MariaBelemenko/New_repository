package com.thomsonreuters.should.step_definitions.firmStyle;

import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.PracticalLawToolsPage;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.StandardDocumentPage;
import com.thomsonreuters.pageobjects.pages.widgets.CategoryPage;
import com.thomsonreuters.should.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;

public class AbilityForPAToDownloadFSDocumentTest extends BaseStepDef {

    private CategoryPage categoryPage = new CategoryPage();
    private StandardDocumentPage standardDocumentPage = new StandardDocumentPage();
    private PracticalLawToolsPage practicalLawToolsPage = new PracticalLawToolsPage();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();

    @When("^the user opens \"([^\"]*)\" link$")
    public void openLinkFromList(String linkName) throws Throwable {
        categoryPage.openPageByText(linkName);
    }

    @When("^the user clicks Firm Style link$")
    public void clickFirmStyleLink() throws Throwable {
        standardDocumentPage.firmStyle().click();
        standardDocumentPage.waitForPageToLoad();
    }

    @Then("^Firm Style Tools page is displayed$")
    public void checkToolsPageDisplayed() throws Throwable {
        practicalLawToolsPage.waitForPageToLoad();
        String learnMoreLink = "/About/PracticalLawTools";
        String currentUrl = getDriver().getCurrentUrl();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(currentUrl.contains(learnMoreLink))
                .overridingErrorMessage(
                        "Expected current URL contains link '" + learnMoreLink + "', current is '" + currentUrl + "'")
                .isTrue();
        softly.assertThat(practicalLawToolsPage.isFirmStyleTabActive())
                .overridingErrorMessage("Firmstyle tab is not active").isTrue();
        softly.assertAll();
    }

    @When("^the user opens (.+) url on plcuk website$")
    public void theUserOpensUrlOnPLCUKSite(String url) throws Throwable {
        navigationCobalt.navigateToPLCUKPlusSpecificURL(url);
        navigationCobalt.waitForPageToLoadAndJQueryProcessingWithCustomTimeOut(90);
    }

}

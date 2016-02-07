package com.thomsonreuters.assetpages.step_definitions.page;

import com.thomsonreuters.assetpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusResearchDocDisplay.document.PrimarySourceDocumentPage;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class PrimarySourcePaginationTest extends BaseStepDef {

    private PrimarySourceDocumentPage primarySourceDocumentPage = new PrimarySourceDocumentPage();
    private AssetPageUtils assetPageUtils = new AssetPageUtils();

    @When("^the user sees the number of links found$")
    public void theUserSeesTheNumberOfLinksFound() throws Throwable {
        assertTrue("The user doesn't see the number of links found",
                primarySourceDocumentPage.isElementDisplayed(primarySourceDocumentPage.numberOfLinksFoundResult()));
    }

    @When("^this number more than \"(.*?)\"$")
    public void thisNumberMoreThan(String numberOfLinks) throws Throwable {
        assertTrue("The number of links less than 300", assetPageUtils.isTheNumberOfLinksMoreThan(numberOfLinks));
    }

    @When("^the user clicks on Show more \"(.*?)\" link$")
    public void theUserClicksOnShowMoreLink(String showMoreLinkText) throws Throwable {
        primarySourceDocumentPage.showMoreLink(showMoreLinkText).click();
    }

    @Then("^the number of displayed links equals to the number of results found$")
    public void theNumberOfDisplayedLinksEqualsToTheNumberOfResultsFound() throws Throwable {
        assertTrue("The number of displayed links is not equals to the number of results found",
                assetPageUtils.isTheNumberOfLinksEqualsToTheNumberOfResultsFound());
    }

}

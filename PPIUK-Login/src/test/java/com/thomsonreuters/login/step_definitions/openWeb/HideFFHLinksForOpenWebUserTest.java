package com.thomsonreuters.login.step_definitions.openWeb;

import com.thomsonreuters.login.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class HideFFHLinksForOpenWebUserTest extends BaseStepDef {

    private CommonMethods commMethods = new CommonMethods();
    private WLNHeader wlnHeader = new WLNHeader();

    @Then("^he does not see any link related to FFH$")
    public void heDoesNotSeeAnyLinkRelatedToFFH(List<String> ffhLinks) throws Throwable {
        checkIfLinksVisible(ffhLinks);
    }

    @When("^he looks at the header , no matter which page he is at$")
    public void heLooksAtTheHeaderNoMatterWhichPageHeIsAt() throws Throwable {
        assertTrue("Header is not visible", wlnHeader.header().isDisplayed());
    }

    @Then("^he does not see in the header any link related to FFH$")
    public void heDoesNotSeeInTheHeaderAnyLinkRelatedToFFH() throws Throwable {
        int result = 0;
        if (wlnHeader.isFavoritesLinkPresent()) {
            result++;
        }
        if (wlnHeader.isFoldersLinkPresent()) {
            result++;
        }
        if (wlnHeader.isHistoryLinkPresent()) {
            result++;
        }
        assertTrue("FFH is visible for user", result == 0);
    }

    private void checkIfLinksVisible(List<String> ffhLinks) {
        int result = 0;
        for (String ffhLink : ffhLinks) {
            if (commMethods.getElementByLinkText(ffhLink) != null) {
                LOG.info(ffhLink + " link is visvible for user");
                result++;
            }
        }
        assertTrue("FFH is visvible for user", result == 0);
    }

}

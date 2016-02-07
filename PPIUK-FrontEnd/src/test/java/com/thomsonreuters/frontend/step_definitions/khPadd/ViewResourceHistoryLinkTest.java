package com.thomsonreuters.frontend.step_definitions.khPadd;

import com.thomsonreuters.frontend.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import cucumber.api.java.en.Then;
import org.hamcrest.core.Is;

import static org.hamcrest.MatcherAssert.assertThat;

public class ViewResourceHistoryLinkTest extends BaseStepDef {

    private KHResourcePage resourcePage = new KHResourcePage();

    @Then("^the user can see 3 latest resource histories displayed$")
    public void theFollowingResourceHistoryEntriesAreVisible() throws Throwable {
        int listSize = resourcePage.visibleResourceHistoryList().size();
        assertThat(listSize, Is.is(3));
    }

}

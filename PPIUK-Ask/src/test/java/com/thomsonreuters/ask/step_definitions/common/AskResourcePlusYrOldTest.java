package com.thomsonreuters.ask.step_definitions.common;

import com.thomsonreuters.ask.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.ask.AskResourcePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class AskResourcePlusYrOldTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private AskResourcePage askResourcePage = new AskResourcePage();

    @When("^the user is in Page '(.*)'$")
    public void theUserIsInPage(String pages) throws Throwable {
        List<String> links = Arrays.asList(pages.split(">"));
        for (String link : links) {
            if (link.contains("/")) {
                navigationCobalt.navigateToRelativeURL(link);
                navigationCobalt.waitForPageToLoad();
            }
        }
    }

    @Then("^the user verifies that ask error message displayed (.*)contains '(.*)'$")
    public void theUserVerifiesThatAskErrorMessageDisplayedContains(String should, String text) throws Throwable {
        if (!should.contains("NOT")) {
            assertThat(askResourcePage.askErrorText().getText().replaceAll("\\n", ""), containsString(text.replaceAll("\\\\n", "")));
        } else {
            assertThat(askResourcePage.askErrorText().getText().replaceAll("\\n", ""), Matchers.not(containsString(text.replaceAll("\\\\n", ""))));
        }
    }

}

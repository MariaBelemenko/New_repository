package com.thomsonreuters.pagecreation.step_definitions.categoryPage;

/**Phil Harper, SD file for tests for CPET Commercial Practice Area Ask Tab.
 * Not all Practice Areas have one of these - please review the Feature File
        * Created by U0162413 on 06/05/2016.
 */

import com.thomsonreuters.pagecreation.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.pageCreation.PracticeAreaAskTab;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class cpetPracticeAreaAskTab extends BaseStepDef {
    PracticeAreaAskTab PLPAAsk = new PracticeAreaAskTab();

    @When("^navigates to the Ask Tab$")
    public void navigatesToTheAskTab() throws Throwable {
        PLPAAsk.AskTab().click();
    }

    @Then("^the user verifies the Ask disclaimer is present$")
    public void theUserVerifiesTheAskDisclaimerIsPresent() throws Throwable {
        PLPAAsk.AskTabDisclaimer().isDisplayed();
    }

    @Then("^the user clicks the Scope and Rules link$")
    public void theuserclickstheScopeandRuleslink() throws Throwable {
        PLPAAsk.AskTabScopeandRules().click();
    }

    @Then("^the user verifies the resulting 'Scope and Rules' page$")
    public void theuserverifiestheresultingScopeandRulespage() throws Throwable {
    PLPAAsk.AskTabScopeandRulesPage().isDisplayed();
    }

    @Then("^All Recent Queries are displayed$")
    public void allRecentQueriesAreDisplayed() throws Throwable {
        PLPAAsk.AskTabRecentQuery("0").isDisplayed();
        PLPAAsk.AskTabRecentQuery("1").isDisplayed();
        PLPAAsk.AskTabRecentQuery("2").isDisplayed();
        PLPAAsk.AskTabRecentQuery("3").isDisplayed();
        PLPAAsk.AskTabRecentQuery("4").isDisplayed();
    }

    @And("^verifies each Recent Query has associated reply information$")
    public void verifiesEachRecentQueryHasAssociatedReplyInformation() throws Throwable {
        PLPAAsk.AskTabRecentQueryReply("0").isDisplayed();
        PLPAAsk.AskTabRecentQueryReply("1").isDisplayed();
        PLPAAsk.AskTabRecentQueryReply("2").isDisplayed();
        PLPAAsk.AskTabRecentQueryReply("3").isDisplayed();
        PLPAAsk.AskTabRecentQueryReply("4").isDisplayed();
        assertTrue(PLPAAsk.AskTabRecentQueryReply("0").getText().length() > 0);
        assertTrue(PLPAAsk.AskTabRecentQueryReply("1").getText().length() > 0);
        assertTrue(PLPAAsk.AskTabRecentQueryReply("3").getText().length() > 0);
        assertTrue(PLPAAsk.AskTabRecentQueryReply("2").getText().length() > 0);
        assertTrue(PLPAAsk.AskTabRecentQueryReply("4").getText().length() > 0);
    }

    @And("^verifies each Recent Query has a Date$")
    public void verifiesEachRecentQueryHasADate() throws Throwable {
        PLPAAsk.AskTabRecentQueryDate("0").isDisplayed();
        PLPAAsk.AskTabRecentQueryDate("1").isDisplayed();
        PLPAAsk.AskTabRecentQueryDate("2").isDisplayed();
        PLPAAsk.AskTabRecentQueryDate("3").isDisplayed();
        PLPAAsk.AskTabRecentQueryDate("4").isDisplayed();
        assertTrue(PLPAAsk.AskTabRecentQueryDate("0").getText().length() > 4);
        assertTrue(PLPAAsk.AskTabRecentQueryDate("1").getText().length() > 4);
        assertTrue(PLPAAsk.AskTabRecentQueryDate("3").getText().length() > 4);
        assertTrue(PLPAAsk.AskTabRecentQueryDate("2").getText().length() > 4);
        assertTrue(PLPAAsk.AskTabRecentQueryDate("4").getText().length() > 4);
    }

    @Then("^confirms the Go to Ask \"(.*?)\" Button is present$")
    public void confirmsTheGoToAskIsPresent(String PracticeArea) throws Throwable {
        PLPAAsk.AskTabGoToPracticeAreaButton(PracticeArea).isDisplayed();
    }

    @And("^clicks the Go to Ask \"([^\"]*)\"$")
    public void clicksTheGoToAsk(String PracticeArea) throws Throwable {
        PLPAAsk.AskTabGoToPracticeAreaButton(PracticeArea).click();
    }

    @And("^the resulting Go to Ask \"([^\"]*)\" contains the associated Page Label$")
    public void theResultingGoToAskContainsTheAssociatedPageLabel(String PracticeArea) throws Throwable {
            PLPAAsk.AskTabAskPracticeAreaPageLabel(PracticeArea).isDisplayed();
    }

}

package com.thomsonreuters.khpadd.step_definitions.knowHowDocuments;

import com.thomsonreuters.khpadd.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.DocumentRightPanelPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class ResourceHistoryTest extends BaseStepDef {

    private DocumentRightPanelPage rightPanelPage = new DocumentRightPanelPage();
    private KHResourcePage resourcePage = new KHResourcePage();

    @When("^the user clicks on the 'View Resource History' link on the resource page$")
    public void theUserClicksOnTheViewResourceHistoryLinkOnTheResourcePage() throws Throwable {
        rightPanelPage.viewResourceHistoryLink().click();
    }

    @Then("^the user can see 3 latest resource histories displayed$")
    public void theFollowingResourceHistoryEntriesAreVisible() throws Throwable {
        int listSize = resourcePage.visibleResourceHistoryList().size();
        assertThat(listSize, Is.is(3));
    }

    @Then("^user clicks on '(View All|View Latest)' to view (all|latest) resource histories$")
    public void theUserClicksOnLink(String linkText, String allOrLatest) throws Throwable {
        WebElement element = resourcePage.viewAllAndLatestResourceHistoryLink();
        assertThat(element.getText().trim(), Is.is(linkText));
        element.click();
    }

    @Then("^the user can now see more than (\\d+) resource history entries$")
    public void theUserCanNowSeeMoreThanResourceHistoryEntries(int size) throws Throwable {
        int listSize = resourcePage.visibleResourceHistoryList().size();
        assertTrue("less than 3 entries are displayed", listSize >= size);
    }

    @Then("^the following message is displayed in the resource history section$")
    public void theFollowingMessageIsDisplayedInTheResourceHistorySection(List<String> expectedMessage) throws Throwable {
        String actualText = resourcePage.visibleResourceHistoryList().get(0).getText();
        String expectedText = expectedMessage.get(0);
        assertThat(actualText.replace("\n", " ").trim(), Is.is(expectedText));
    }

    @Then("^the link 'View All' to display more resource entries is not visible$")
    public void theLinkToDisplayMoreResourceEntriesIsNotVisible() throws Throwable {
        assertThat(resourcePage.viewAllResourceHistoryLink(), Is.is(false));
    }

}

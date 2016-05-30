package com.thomsonreuters.legalupdate.step_definitions.widget;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesResultsPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesWidget;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class LegalUpdatesWidgetsTest extends BaseStepDef {

    private LegalUpdatesWidget luWidget = new LegalUpdatesWidget();
    private LegalUpdatesResultsPage legalUpdatesResultsPage = new LegalUpdatesResultsPage();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();

    private List<String> updatesTitles;
    private List<String> updatesDates;

    @Given("^the user should see (\\d+) updates on a \"(.*?)\" widget$")
    public void theUserShouldSeeUpdatesOnAWidget(int titlesCount, String widgetName) throws Throwable {
        updatesTitles = luWidget.getAll5UpdatesTitles(widgetName);
        assertTrue("Titles count is more or less than 5. Actual titles count: " + updatesTitles.size(), updatesTitles.size() == titlesCount);
    }

    @Given("^\"(.*?)\" widget should display publication dates of documents$")
    public void widgetShouldDisplayPublicationDatesOfDocuments(String widgetName) throws Throwable {
        int result = 0;
        updatesDates = luWidget.getAllDatesFromWidget(widgetName);
        for (String date : updatesDates) {
            if (date.isEmpty()) {
                result++;
            }
        }
        assertTrue("Some dates from widget are not visible", updatesTitles.size() == updatesDates.size() && result == 0);
    }

    @When("^the user clicks on the 'View all' link of the \"(.*?)\" widget$")
    public void theUserClicksOnTheViewAllLinkOfTheWidget(String widgetName) throws Throwable {
        luWidget.veiwAllUpdatesLink(widgetName).click();
        legalUpdatesResultsPage.waitForPageToLoad();
    }

    @Then("^the user should see first five updates same as on widget$")
    public void theUserShouldSeeFirstFiveUpdatesSameAsOnWidget() throws Throwable {
        knowHowSearchResultsPage.waitForSearchResults();
        List<String> luTitlesFromResultsPage = legalUpdatesResultsPage.getFirstLU5Titles();
        assertTrue("First 5 updates on results page are inconsistent with updates from widget.Updates from widget: " + updatesTitles.toString() + " updates from LU page: " + luTitlesFromResultsPage.toString(), luTitlesFromResultsPage.containsAll(updatesTitles));
    }
}

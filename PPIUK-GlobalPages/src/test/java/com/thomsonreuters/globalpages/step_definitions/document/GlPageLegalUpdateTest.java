package com.thomsonreuters.globalpages.step_definitions.document;

import com.thomsonreuters.globalpages.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.globalPage.GlobalCategoryPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesWidget;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.utils.globalPage.GlobalPageUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class GlPageLegalUpdateTest extends BaseStepDef {

    private LegalUpdatesWidget luWidget = new LegalUpdatesWidget();
    private GlobalPageUtils globalPageUtils = new GlobalPageUtils();
    private GlobalCategoryPage globalCategoryPage = new GlobalCategoryPage();
    private HomePage homePage = new HomePage();

    private final String dateFormat = "MMMM dd, yyyy";
    private final String dateFormatResultListOfLegalUpdates = "dd MMM yyyy";

    @Then("^the \"(.*?)\" dates are sorted in reverse chronological order$")
    public void theDatesAreSortedInReverseChronologicalOrder(String widget) throws Throwable {
        globalCategoryPage.waitForPageToLoad();
        assertTrue(
                "The dates are not sorted in reerse chronological order",
                globalPageUtils.isTheDatesSortedInReverseChronologicalOrder(
                        luWidget.getAllDatesFromWidget(widget), dateFormat)
        );
    }

    @Then("^the dates in results list are sorted in reverse chronological order$")
    public void theDatesInResultsListAreSortedInReverseChronologicalOrder() throws Throwable {
        globalCategoryPage.waitForPageToLoad();
        assertTrue(
                "The dates in results list are not sorted in reverse chronological order",
                globalPageUtils.isTheDatesSortedInReverseChronologicalOrder(
                        globalPageUtils.getAllDatesFromResultListOfLegalUpdates(), dateFormatResultListOfLegalUpdates)
        );
    }

    @When("^the user clicks on the \"(.*?)\" link on \"(.*?)\" widget$")
    public void theUserClicksOnTheLinkOnWidget(String linkNumber, String widget) throws Throwable {
        globalCategoryPage.waitForPageToLoad();
        globalCategoryPage.linkOnLegalUpdateWidget(Integer.parseInt(linkNumber), widget).click();
    }

    @When("^the user clicks link '(.*)' on '(.*)' page$")
    public void theUserClicksLinkOnPage(String link, String page) throws Throwable {
        if (!link.equals("")) {
            if (page.contains("Browse")) {
                homePage.findChildElement(homePage.getPracticeAreasBrowseMenuContainer(), By.linkText((link))).click();
            } else {
                try {
                    homePage.waitForExpectedElement(By.linkText(link), 2).click();
                } catch (Exception e) {
                    homePage.waitForExpectedElement(By.partialLinkText(link), 5).click();
                }
            }
            Thread.sleep(2000);
            homePage.waitForPageToLoad();
        }
    }

}

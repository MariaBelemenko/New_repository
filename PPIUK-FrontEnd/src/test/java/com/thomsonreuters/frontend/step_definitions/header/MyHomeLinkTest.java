package com.thomsonreuters.frontend.step_definitions.header;

import com.thomsonreuters.frontend.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.onePass.OnePassLogoutPage;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class MyHomeLinkTest extends BaseStepDef {

    private CommonMethods comMethods = new CommonMethods();
    private HomePage homePage = new HomePage();
    private WLNHeader wlnHeader = new WLNHeader();
    private OnePassLogoutPage onePassLogoutPage = new OnePassLogoutPage();

    @Then("^user should see the \"(.*?)\" link$")
    public void userShouldSeeLink(String linkText) throws Throwable {
        assertTrue(linkText + " link not present..!", comMethods.waitElementByLinkText(linkText) != null);
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
            homePage.waitForPageToLoad();
        }
    }

    @Then("^the user verifies that the current PageTitle contains '(.*)'$")
    public void theUserVerifiesThatTheCurrentPageTitleContainsPageTitle(String pageTitle) throws Throwable {
        assertTrue("The Expected Page Title " + pageTitle + " is  NOT displayed", wlnHeader.pageHeaderLabel().getText().contains(pageTitle));
    }

    @Then("^user logs out$")
    public void userLogsOut() throws Throwable {
        wlnHeader.signOff();
        wlnHeader.waitForPageToLoad();
    }

    @Then("^user tries to log in again$")
    public void userTriesToLogInAgain() throws Throwable {
        onePassLogoutPage.signOffPageSignOnButton().click();
        onePassLogoutPage.waitForPageToLoad();
    }

}

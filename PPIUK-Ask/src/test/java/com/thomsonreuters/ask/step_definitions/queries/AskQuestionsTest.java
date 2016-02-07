package com.thomsonreuters.ask.step_definitions.queries;

import com.thomsonreuters.ask.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class AskQuestionsTest extends BaseStepDef {

    private HomePage homePage = new HomePage();
    private WLNHeader wlnHeader = new WLNHeader();

    @When("^the user clicks category link '(.*)'and topic link '(.*)' on '(.*)' page$")
    public void theUserClicksCategoryAndTopicLinkOnPage(String link, String topicLink, String page) throws Throwable {
        homePage.waitForExpectedElement(By.linkText(link)).click();
        homePage.waitForPageToLoad();
        assertTrue("The Expected Category Page Title " + link + " is  NOT displayed", wlnHeader.pageHeaderLabel().getText().toLowerCase().contains(link.toLowerCase()));
        homePage.waitForExpectedElement(By.linkText(topicLink)).click();
        homePage.waitForPageToLoad();
        assertTrue("The Expected Topic Page Title " + topicLink + " is  NOT displayed", wlnHeader.pageHeaderLabel().getText().toLowerCase().contains(topicLink.toLowerCase()));
    }

}

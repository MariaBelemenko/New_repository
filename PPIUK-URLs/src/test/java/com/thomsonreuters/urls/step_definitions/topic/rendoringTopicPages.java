package com.thomsonreuters.urls.step_definitions.topic;

import com.thomsonreuters.pageobjects.pages.urls.plcuk.PracticeAreaPage;
import com.thomsonreuters.urls.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class rendoringTopicPages extends BaseStepDef {

    private PracticeAreaPage practiceAreaPage = new PracticeAreaPage();

    public static final String REGEX_TOPIC_URL = ".+(com/topic/)(\\w{1})-(\\d{3})-(\\d{4}).+";

    @When("^the user opens (.+) topic$")
    public void theUserOpensTopic(String topicName) throws Throwable {
        practiceAreaPage.getTopicLink(topicName).click();
        practiceAreaPage.waitForPageToLoadAndJQueryProcessing();
    }

    @Then("^the Topic page URL is in this format: hostname/topic/x-xxx-xxxx$")
    public void theTopicPageURLIsInCorectFormat() throws Throwable {
        assertTrue("Topic URL isn't in correct format - hostname/Topic/x-xxx-xxxx : " + practiceAreaPage.getCurrentUrl(), practiceAreaPage.isURLmatches(REGEX_TOPIC_URL));
    }

}
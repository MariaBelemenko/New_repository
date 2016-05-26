package com.thomsonreuters.pagecreation.step_definitions.categoryPage;

/**Phil Harper, SD file for tests for CPET Practice Area Topics Tab.
 * All Practice Areas have one of these - please review the Feature File
        * Created by U0162413 on 11/05/2016.
 */

import com.thomsonreuters.pagecreation.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.pageCreation.AskPracticeAreaPage;
import com.thomsonreuters.pageobjects.pages.pageCreation.PracticeAreaTopicsResourcesTabs;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;


public class cpetPracticeAreaTopicsTab extends BaseStepDef {
    PracticeAreaTopicsResourcesTabs PLPATopRes = new PracticeAreaTopicsResourcesTabs();
    AskPracticeAreaPage AskPracticeArea = new AskPracticeAreaPage();
    private CommonMethods commonMethods = new CommonMethods();


    @Then("^user clicks on Topic Link where Topic Tab is default, verify the url and verify the Page Label$")
    public void userclicksonTopicLinkverifytheurlandverifythePageLabel(DataTable PracticeAreaTopics) throws Throwable {
        List<String> PracticeAreaTopiclink = new ArrayList<String>();
        List<String> PracticeAreaTopicURL = new ArrayList<String>();
        List<String> PracticeAreaTopicPageLabel = new ArrayList<String>();
        for (Map<String, String> map : PracticeAreaTopics.asMaps(String.class, String.class)) {
            PracticeAreaTopiclink.add(map.get("practiceAreaTopiclink"));
            PracticeAreaTopicURL.add(map.get("practiceAreaTopicURL"));
            PracticeAreaTopicPageLabel.add(map.get("practiceAreaTopicPageLabel"));
        }
        for (int i=0;i<PracticeAreaTopiclink.size();i++){
            PLPATopRes.TopicsTab().click();
            PLPATopRes.TopicDefault(PracticeAreaTopiclink.get(i)).click();
            String topicHeader=AskPracticeArea.askTopicLinkHeading().getText();
            assertThat("Actual topicpage heading is : " +topicHeader+ " Expected heading is : " +
                    PracticeAreaTopicPageLabel.get(i), topicHeader.equals(PracticeAreaTopicPageLabel.get(i)));
            assertThat("The PA Topic URL does not contain PLC ref for topic "+PracticeAreaTopicPageLabel.get(i) +" as expected. " +
                    "Expected : "+PracticeAreaTopicURL.get(i) + " . Actual:" + commonMethods.getCurrentURL(),commonMethods
                    .getCurrentURL().contains(PracticeAreaTopicURL.get(i)));
            commonMethods.browserGoBack();
        }
    }

    @Then("^user clicks on Topic Link for Competition, verify the url and verify the Page Label$")
    public void userclicksonTopicLinkforCompetitionverifytheurlandverifythePageLabel(DataTable PracticeAreaTopics) throws Throwable {
        List<String> PracticeAreaTopiclink = new ArrayList<String>();
        List<String> PracticeAreaTopicURL = new ArrayList<String>();
        List<String> PracticeAreaTopicPageLabel = new ArrayList<String>();
        for (Map<String, String> map : PracticeAreaTopics.asMaps(String.class, String.class)) {
            PracticeAreaTopiclink.add(map.get("practiceAreaTopiclink"));
            PracticeAreaTopicURL.add(map.get("practiceAreaTopicURL"));
            PracticeAreaTopicPageLabel.add(map.get("practiceAreaTopicPageLabel"));
        }
        for (int i=0;i<PracticeAreaTopiclink.size();i++){
            PLPATopRes.TopicsTab().click();
            PLPATopRes.TopicCompetition(PracticeAreaTopiclink.get(i)).click();
            String topicHeader=AskPracticeArea.askTopicLinkHeading().getText();
            assertThat("Actual topicpage heading is : " +topicHeader+ " Expected heading is : " +
                    PracticeAreaTopicPageLabel.get(i), topicHeader.equals(PracticeAreaTopicPageLabel.get(i)));
            assertThat("The PA Topic URL does not contain PLC ref for topic "+PracticeAreaTopicPageLabel.get(i) +" as expected. " +
                    "Expected : "+PracticeAreaTopicURL.get(i) + " . Actual:" + commonMethods.getCurrentURL(),commonMethods
                    .getCurrentURL().contains(PracticeAreaTopicURL.get(i)));
            commonMethods.browserGoBack();
        }
    }

    @Then("^user clicks on Topic Link for EU Law, verify the url and verify the Page Label$")
    public void userclicksonTopicLinkforEULawverifytheurlandverifythePageLabel(DataTable PracticeAreaTopics) throws
            Throwable {
        List<String> PracticeAreaTopiclink = new ArrayList<String>();
        List<String> PracticeAreaTopicURL = new ArrayList<String>();
        List<String> PracticeAreaTopicPageLabel = new ArrayList<String>();
        for (Map<String, String> map : PracticeAreaTopics.asMaps(String.class, String.class)) {
            PracticeAreaTopiclink.add(map.get("practiceAreaTopiclink"));
            PracticeAreaTopicURL.add(map.get("practiceAreaTopicURL"));
            PracticeAreaTopicPageLabel.add(map.get("practiceAreaTopicPageLabel"));
        }
        for (int i=0;i<PracticeAreaTopiclink.size();i++){
            PLPATopRes.TopicsTab().click();
            PLPATopRes.TopicEULaw(PracticeAreaTopiclink.get(i)).click();
            String topicHeader=AskPracticeArea.askTopicLinkHeading().getText();
            assertThat("Actual topicpage heading is : " +topicHeader+ " Expected heading is : " +
                    PracticeAreaTopicPageLabel.get(i), topicHeader.equals(PracticeAreaTopicPageLabel.get(i)));
            assertThat("The PA Topic URL does not contain PLC ref for topic "+PracticeAreaTopicPageLabel.get(i) +" as expected. " +
                    "Expected : "+PracticeAreaTopicURL.get(i) + " . Actual:" + commonMethods.getCurrentURL(),commonMethods
                    .getCurrentURL().contains(PracticeAreaTopicURL.get(i)));
            commonMethods.browserGoBack();
        }
    }



}
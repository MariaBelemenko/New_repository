package com.thomsonreuters.pagecreation.step_definitions.homePage;

import com.thomsonreuters.pagecreation.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.ask.AskCategoryPage;
import com.thomsonreuters.pageobjects.pages.ask.AskFormPage;
import com.thomsonreuters.pageobjects.pages.pageCreation.AskPracticeAreaPage;
import com.thomsonreuters.pageobjects.pages.pageCreation.PLRssWidget;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.openqa.selenium.NoSuchWindowException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.junit.Assert.assertTrue;


public class PracticeAreaAskPagesTopicLinks extends BaseStepDef {

    AskPracticeAreaPage AskPracticeArea = new AskPracticeAreaPage();
    private CommonMethods commonMethods = new CommonMethods();

    @Given("^clicks on the topic Topiclink and verifies the correct page is opened$")
    public void clicksonthetopicandverifiesthecorrectpageisopened(DataTable topic) throws Throwable {

        List<String> topicLink= new ArrayList<String>();
        List<String> topicRef= new ArrayList<String>();
        for (Map<String, String> map : topic.asMaps(String.class, String.class)) {
            topicLink.add(map.get("TopicLink"));
            topicRef.add(map.get("TopicPLCRef"));
        }

        for(int i=0;i<topicLink.size();i++) {
            commonMethods.waitForPageToLoad();
            AskPracticeArea.askTopicLink(topicLink.get(i)).click();
            String topicHeader=AskPracticeArea.askTopicLinkHeading().getText();

            if(topicLink.get(i).equals("Cross-border acquisitions")) {
                topicLink.set(i, "Cross-border: Acquisitions");
            }else if(topicLink.get(i).equals("Public mergers & acquisitions")) {
                topicLink.set(i, "Public mergers and acquisitions");
            }else if(topicLink.get(i).equals("US securities law: for non - US companies")) {
                topicLink.set(i, "US Securities Law: Issues for Non-US Companies");
            }else if(topicLink.get(i).equals("Financial Promotion")) {
                topicLink.set(i, "Financial Promotion and Marketing");
            }else if(topicLink.get(i).equals("Miscellaneous: company law")) {
                topicLink.set(i, "Cross-border: Company Law and Corporate Governance");
            }else if(topicLink.get(i).equals("Partnership and LLP's")) {
                topicLink.set(i, "Partnerships and LLPs");
            }else if(topicLink.get(i).equals("Funding")) {
                    topicLink.set(i,"Funding Litigation");
            }else if(topicLink.get(i).equals("Evidence")) {
                topicLink.set(i,"Evidence: Litigation");
            }else if(topicLink.get(i).equals("Disclosure")) {
                topicLink.set(i,"Disclosure: Litigation");
            }else if(topicLink.get(i).equals("Early Determination")) {
                topicLink.set(i,"Early Determination: Litigation");
            }else if(topicLink.get(i).equals("Costs")) {
                topicLink.set(i,"Costs: Litigation");
            }else if(topicLink.get(i).equals("Enforcement")) {
                topicLink.set(i,"Enforcement: Litigation");
            }else if(topicLink.get(i).equals("Insolvency litigation")){
                topicLink.set(i,"Court Proceedings: Restructuring and Insolvency");
            }else if(topicLink.get(i).equals("Employee data, monitoring and privacy")){
                topicLink.set(i,"Employee Data and Monitoring");
            }else if(topicLink.get(i).equals("Financial remedies: on divorce or dissolution")){
                topicLink.set(i,"Financial remedies: divorce and dissolution of civil partnership");
            }else if(topicLink.get(i).equals("Information technology")){
                topicLink.set(i,"General Contract and Boilerplate");
            }else if(topicLink.get(i).equals("Trade marks")){
                topicLink.set(i,"Trademarks");
            }else if(topicLink.get(i).equals("Direct payment schemes: agriculture and rural land")) {
                topicLink.set(i, "Direct payment schemes: agriculture & rural land");
            }else if(topicLink.get(i).equals("Financial and corporate crime")) {
                topicLink.set(i, "Financial Crime ");
            }else if(topicLink.get(i).equals("Employment status and self-employment")) {
                topicLink.set(i, "Employment Status and Independent Contractors");
            }else if(topicLink.get(i).equals("Development and construction")) {
                topicLink.set(i, "Development");
            }else if(topicLink.get(i).equals("Buybacks and other returns of value")) {
                topicLink.set(i, "Returns of value");
            }


            assertThat("Actual topicpage heading is : " + AskPracticeArea.askTopicLinkHeading().getText() + " Expected heading is : " + topicLink.get(i).toLowerCase(), topicHeader.toLowerCase().contains(topicLink.get(i).toLowerCase()));
            assertThat("The ASK Topic URL does not contain PLC ref for topic "+topicLink.get(i) +" as expected. Expected : "+topicRef.get(i) + " . Actual:" + commonMethods.getCurrentURL(),commonMethods.getCurrentURL().contains(topicRef.get(i)));
            commonMethods.browserGoBack();
        }

    }
}


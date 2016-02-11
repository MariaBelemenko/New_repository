package com.thomsonreuters.khpadd.step_definitions.topicPage;

import com.thomsonreuters.khpadd.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.pageCreation.HomePage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.TopicPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;

public class EditorsPickMetaDataTest extends BaseStepDef {
    private HomePage homePage = new HomePage();
    private TopicPage topicPage = new TopicPage();
    private KHResourcePage resourcePage = new KHResourcePage();


    @When("^the user navigates to practice area \"(.*?)\" filtered by \"(.*?)\" topic page$")
    public void theUserNavigatesToPracticeAreaFilteredByTopicPage(String practiceArea, String topicName) throws Throwable {
        homePage.selectLinkPresentOnTab(practiceArea);
        topicPage.clickTopicLinkOnPAPage(topicName).click();
        Thread.sleep(2000);
        resourcePage.waitForPageToLoad();
    }

    @Then("^the following resources are present under the Editors Picks$")
    public void theFollowingResourcesArePresentUnderTheEditorsPicks(List<KHEditorsPicks> expectedResources) throws Throwable {
        Map<String, String> actualEditorPicks = topicPage.getEditorPicksAsMap();
        for (KHEditorsPicks resource : expectedResources) {
            String actualMetaData = actualEditorPicks.get(resource.getResourceLink());
            assertFalse(resource.getResourceLink() + " is not present in Editors Picks", null == actualMetaData);
            assertThat(actualMetaData, Is.is(resource.getMetadata().replace(";", "|")));
        }
    }

    @When("^the user clicks on the resource link \"(.*?)\" in Editor's pick widget$")
    public void theUserClicksOnTheResourceLinkInEditorSPickWidget(String resourceLink) throws Throwable {
        topicPage.clickResourceLinkOnEditorsPick(resourceLink).click();
    }

    @When("^user clicks on Page \"(.*?)\" of the Topic page results list$")
    public void userClicksOnPageOfTheTopicPageResultsList(int pageNum) throws Throwable {
        topicPage.waitForPageToLoadAndJQueryProcessing();
        topicPage.pageNumber(pageNum).click();
        resourcePage.waitForPageToLoad();
        assertThat(Integer.parseInt(topicPage.currentPageSelected()), Is.is(pageNum));
    }

    @Then("^user cannot see the Editor's pick widget on this page$")
    public void userCannotSeeTheEditorSPickWidgetOnThisPage() throws Throwable {
        assertThat("Editor's pick widget is displayed", topicPage.NoEditorsPickWidget(), Is.is(true));
    }

    public class KHEditorsPicks {
        private String resourceLink;
        private String metadata;

        public String getResourceLink() {
            return resourceLink;
        }

        public String getMetadata() {
            return metadata;
        }
    }

}

package com.thomsonreuters.smoke.step_definitions;

import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.TopicPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class ProdTopicPagesTest extends BaseStepDef {

    private TopicPage topicPage = new TopicPage();
    private KHResourcePage resourcePage = new KHResourcePage();

    @Then("^user can see the Editor's pick widget on this page$")
    public void userCanSeeTheEditorSPickWidgetOnThisPage() throws Throwable {
        assertThat("Editor's pick widget is not displayed", topicPage.NoEditorsPickWidget(), Is.is(false));
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

    @When("^clicks on the facet group \"(.*?)\"$")
    public void clicksOnTheFacetGroup(String facetName) throws Throwable {
        topicPage.facetNameLink(facetName).click();
        topicPage.waitForPageToLoad();

    }

    @Then("^only '(.+)' are displayed on topic page$")
    public void onlyChecklistsAreDisplayedOnTopicPage(String resourceType) throws Throwable {
        topicPage.waitForPageToLoadAndJQueryProcessing();
        assertTrue(topicPage.resultsByResourceType(resourceType).isDisplayed());
        List<WebElement> otherResourceTypes = topicPage.findElements(By.xpath("//div[contains(@id, 'cobalt_search_knowHowTopicPlc_')]"));
        assertTrue(otherResourceTypes.size() == 2);     	
    }

}

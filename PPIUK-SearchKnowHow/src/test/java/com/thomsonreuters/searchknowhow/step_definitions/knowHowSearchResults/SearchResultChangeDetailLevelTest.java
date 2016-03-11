package com.thomsonreuters.searchknowhow.step_definitions.knowHowSearchResults;

import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawUKCategoryPage;
import com.thomsonreuters.pageobjects.pages.legalUpdates.LegalUpdatesWidget;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.searchknowhow.step_definitions.BaseStepDef;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class SearchResultChangeDetailLevelTest extends BaseStepDef {

    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private LegalUpdatesWidget legalUpdatesWidget = new LegalUpdatesWidget();
    private PracticalLawUKCategoryPage practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();

    @Then("^the user can verify that the more detail icon is displayed$")
    public void theUserCanVerifyThatTheMoreDetailIconForTermsInContextIsDisplayed() throws Throwable {
        assertTrue(searchResultsPage.isSliderSelectorDisplayed(SearchResultsPage.SliderSelector.MORE));
    }

    @Then("^the user can verify that search results are displayed according to detail selection$")
    public void verifyDetailsSelection(List<String> detailLevels){
        StringBuffer sb = new StringBuffer();
        for(String detailLevel : detailLevels){
            try{
                //Selecting the detail level from dropdown
                searchResultsPage.moreOrLessDetailAnchor().click();
                if(detailLevel.equals("MOST"))
                {
                    searchResultsPage.mostDetailOption().click();
                    assertTrue(searchResultsPage.isSliderSelectorDisplayed(SearchResultsPage.SliderSelector.MOST));
                }else if(detailLevel.equals("MORE")){
                    searchResultsPage.moreDetailOption().click();
                    assertTrue(searchResultsPage.isSliderSelectorDisplayed(SearchResultsPage.SliderSelector.MORE));
                }else if(detailLevel.equals("LESS")){
                    searchResultsPage.lessDetailOption().click();
                    assertTrue(searchResultsPage.isSliderSelectorDisplayed(SearchResultsPage.SliderSelector.LESS));
                }


                //the user is able to verify the presence of the title of the first result
                assertTrue(searchResultsPage.firstResultTitle().isDisplayed());

                //the user is able to verify the presence of a resource type description
                searchResultsPage.resourceTypeDescription().isDisplayed();

                //the user is able to verify a brief description of the content
                assertTrue(searchResultsPage.firstResultAbstractText().isDisplayed());

                //the user is able to verify that jurisdiction information is displayed
                assertTrue(searchResultsPage.jurisdictionsForFirstResult().isDisplayed());

                //the user is able to verify that the content is either maintained or non maintained
                String statusText = searchResultsPage.statusForFirstResult().getText();
                assertTrue(statusText.contains("Maintained") || statusText.contains("Published") || statusText.contains("Law"));

                //the user is able to verify that terms in context are displayed appropriate to the more setting
                if(detailLevel.equals("MOST"))
                {
                    assertTrue(searchResultsPage.firstSnippetPara().isDisplayed());
                    assertTrue(searchResultsPage.secondSnippetPara().isDisplayed());
                }else if(detailLevel.equals("MORE")){
                    assertTrue(searchResultsPage.firstSnippetPara().isDisplayed());
                    assertFalse(searchResultsPage.secondSnippetPara().isDisplayed());
                }else if(detailLevel.equals("LESS")){
                    assertFalse(searchResultsPage.firstResultAbstractText().isDisplayed());
                    assertFalse(searchResultsPage.firstSnippetPara().isDisplayed());
                }

            }catch(Exception | AssertionError e){
                String errMsg = "Test failed for validating of detail level :"+detailLevel+ "::error message::"+e.getMessage()+"\n";
                LOG.warn(errMsg);
                sb.append(errMsg);
            }
        }
        if(sb.length()>0){
            fail(sb.toString());
        }
    }

    @Then("^the user is able to verify that terms in context are displayed appropriate to the more setting$")
    public void theUserIsAbleToVerifyThatTermsInContextAreDisplayedAppropriateToTheMoreSetting() throws Throwable {
        searchResultsPage.firstSnippetPara().isDisplayed();
        assertFalse(searchResultsPage.secondSnippetPara().isDisplayed());
    }

    @Then("^the user can verify that the most detail icon is displayed$")
    public void theUserCanVerifyThatTheMostDetailIconForTermsInContextIsDisplayed() throws Throwable {
        assertTrue(searchResultsPage.isSliderSelectorDisplayed(SearchResultsPage.SliderSelector.MOST));
    }

    @Then("^the user is able to verify that terms in context are displayed appropriate to the most setting$")
    public void theUserIsAbleToVerifyThatTermsInContextAreDisplayedAppropriateToTheMostSetting() throws Throwable {
        assertTrue(searchResultsPage.firstSnippetPara().isDisplayed());
        assertTrue(searchResultsPage.secondSnippetPara().isDisplayed());
    }

    @Then("^the user can select the option to show less detail$")
    public void theUserCanSelectTheOptionToShowLessDetail() throws Throwable {
        searchResultsPage.moreOrLessDetailAnchor().click();
        searchResultsPage.lessDetailOption().click();
    }

    @Then("^the user can verify that the less detail icon is displayed$")
    public void theUserCanVerifyThatTheLessDetailIconForTermsInContextIsDisplayed() throws Throwable {
        assertTrue(searchResultsPage.isSliderSelectorDisplayed(SearchResultsPage.SliderSelector.LESS));
    }

    @Then("^the user is able to verify a brief description of the content is not displayed$")
    public void theUserIsAbleToVerifyABriefDescriptionOfTheContentIsNotDisplayed() throws Throwable {
        assertFalse(searchResultsPage.firstResultAbstractText().isDisplayed());
    }

    @Then("^the user is able to verify that terms in context are displayed appropriate to the less setting$")
    public void theUserIsAbleToVerifyThatTermsInContextAreDisplayedAppropriateToTheLessSetting() throws Throwable {
        assertFalse(searchResultsPage.firstResultAbstractText().isDisplayed());
        assertFalse(searchResultsPage.firstSnippetPara().isDisplayed());
    }

    @When("^has selected the link to View All on the Legal Updates Widget$")
    public void hasSelectedTheLinkToViewAllOnTheLegalUpdatesWidget() throws Throwable {
        legalUpdatesWidget.veiwAllUpdatesLink().click();
    }

    @When("^has selected the topic link to \"([^\"]*)\"")
    public void hasSelectedTheTopicLinkTo(String arg1) throws Throwable {
        practicalLawUKCategoryPage.topicAreaLink(arg1).click();
    }

}

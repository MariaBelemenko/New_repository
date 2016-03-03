package com.thomsonreuters.khpadd.step_definitions.knowHowDocuments;

import com.thomsonreuters.khpadd.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.KHResourcePage;
import cucumber.api.java.en.Then;
import org.hamcrest.core.Is;

import static org.hamcrest.MatcherAssert.assertThat;

public class BackToTopTest extends BaseStepDef {

    private KHResourcePage resourcePage = new KHResourcePage();

    @Then("^user scroll down the resource by offset (\\d+)$")
    public void scrollDownTheResource(int offset) throws Throwable {
        resourcePage.executeScript("window.scrollTo(0," + offset + ");");
    }

    @Then("^back to top sticky link is displayed$")
    public void backToTopIsDisplayed() throws Throwable {
        Thread.sleep(2000);
        assertThat(resourcePage.backToTop().isDisplayed(), Is.is(true));
    }

    @Then("^user can navigate to top from anywhere in the document by clicking on the back to top link$")
    public void navigateToTop() throws Throwable {
        resourcePage.backToTop().click();
        Thread.sleep(2000);
    }


}

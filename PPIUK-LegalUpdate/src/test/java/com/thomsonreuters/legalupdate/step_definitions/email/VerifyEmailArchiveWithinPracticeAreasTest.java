package com.thomsonreuters.legalupdate.step_definitions.email;

import com.thomsonreuters.legalupdate.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawHomepage;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawUKCategoryPage;
import com.thomsonreuters.pageobjects.pages.landingPage.ResourcesPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class VerifyEmailArchiveWithinPracticeAreasTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private PracticalLawUKCategoryPage practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();
    private PracticalLawHomepage practicalLawHomepage = new PracticalLawHomepage();
    private ResourcesPage resourcesPage = new ResourcesPage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();

    @Given("^the user is on the home page$")
    public void aUserIsOnTheHomePage() throws Throwable {
        navigationCobalt.navigateToHomePage();
    }

    @When("^has selected the homepage practice area link to \"(.*?)\"$")
    public void hasSelectedTheHomepagePracticeAreaLinkTo(String arg1) throws Throwable {
        practicalLawUKCategoryPage.practiceAreaLink(arg1).click();
    }

    @Given("^has selected the link to Resources$")
    public void hasSelectedTheLinkToResources() throws Throwable {
        practicalLawHomepage.resourcesLink().click();
    }


    @Given("^the user has selected the resource link entitled Email archive$")
    public void theUserHasSelectedTheResourceLinkEntitledEmailArchive() throws Throwable {
        resourcesPage.emailArchiveLink().click();
    }



    @Given("^the user is presented with a page entitled Email archive \"(.*?)\"$")
    public void theUserIsPresentedWithAPageEntitledEmailArchive(String arg1) throws Throwable {
        searchResultsPage.emailArchiveHeader(arg1).isDisplayed();

    }


    @Given("^the user can verify the presence of a list of archive search results$")
    public void theUserCanVerifyThePresenceOfAListOfArchiveSearchResults() throws Throwable {
    }

}

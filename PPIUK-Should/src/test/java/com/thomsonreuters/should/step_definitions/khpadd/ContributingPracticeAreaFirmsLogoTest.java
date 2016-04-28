package com.thomsonreuters.should.step_definitions.khpadd;

import static org.junit.Assert.assertTrue;

import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.ContributorsPracticeAreaPage;
import com.thomsonreuters.should.step_definitions.BaseStepDef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContributingPracticeAreaFirmsLogoTest extends BaseStepDef {

	private NavigationCobalt navigationCobalt = new NavigationCobalt();
	private ContributorsPracticeAreaPage contributorsPracticeAreaPage = new ContributorsPracticeAreaPage();
	
	private int logoCountOnNewSite = 0;
	private int logoCountOnOldSite = 0;

	private static final String oldDomain = "http://uk.practicallaw.com";
	
	@When("^the user opens (.+) on the old practical law website$")
    public void theUserOpensURLOnTheOldPracticalLawWebsite(String url) throws Throwable {
        if (url.startsWith("/")) {
            url = oldDomain + url;
        }
        navigationCobalt.navigate(url);
        navigationCobalt.waitForPageToLoad();
    }
	
	@Then("^the user should see logos for contributing firms on new site$")
    public void theUserShouldSeeLogosOnNewSite() throws Throwable {
		logoCountOnNewSite = contributorsPracticeAreaPage.contibutorFirmsLogosOnNewSite().size();
		assertTrue("Document does not contain logos on new site ", !contributorsPracticeAreaPage.contibutorFirmsLogosOnNewSite().isEmpty());
    }
	
	@Then("^the user should see logos for contributing firms on old site$")
    public void theUserShouldSeeLogosOnOldSite() throws Throwable {
		logoCountOnOldSite = contributorsPracticeAreaPage.contibutorFirmsLogosOnOldSite().size();
		assertTrue("Document does not contain logos on legacy site ", !contributorsPracticeAreaPage.contibutorFirmsLogosOnOldSite().isEmpty());
    }
	
	@Then("^the count of links should be identical on new and legacy site$")
    public void theCountOfLinksShouldBeIdentical() throws Throwable {
		assertTrue("Count of logos is not equal. new site logos count is: " + logoCountOnNewSite + " old site logos count is: " + logoCountOnOldSite, logoCountOnNewSite == logoCountOnOldSite);
    }

}

package com.thomsonreuters.pageobjects.pages.landingPage;

import com.thomsonreuters.driver.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * Created by Steph Armytage on 26/01/2015. This is the category page that the user arrives at after selecting
 * the link to "Practice" on the Practical Law landing page.
 */

public class PracticeAreaLandingPage extends AbstractPage {

    public PracticeAreaLandingPage() {
    }

    public WebElement mediaAndTelecomsLink() {

        return waitForExpectedElement(By.xpath("//a[@id='coid_media___telecoms']"));
    }

    public WebElement genericLink(String linkText) {

        return waitForExpectedElement(By.xpath("//div[@id='coid_website_browseMainColumn']//a[text()='" + linkText + "']"));
    }

    public WebElement socialMediaLink() {

        return waitForExpectedElement(By.linkText("Social media"));
    }

    // Elements below intended for use for CPET testing by Phil Harper

    public WebElement PAAgriculRuralLandlink () { return waitForExpectedElement(By.id
            ("coid_agriculture___rural_land"));}
    public WebElement PAArbitrationlink () { return waitForExpectedElement(By.id("coid_arbitration"));}
    public WebElement PABusCrimeInvestlink () { return waitForExpectedElement(By.id
            ("coid_business_crime___investigations"));}
    public WebElement PACommerciallink () { return waitForExpectedElement(By.id("coid_commercial"));}
    public WebElement PACompetitionlink () { return waitForExpectedElement(By.id("coid_competition"));}
    public WebElement PAConstructionlink () { return waitForExpectedElement(By.id("coid_construction"));}
    public WebElement PACorporatelink (){ return waitForExpectedElement(By.id("coid_corporate"));}
    public WebElement PADataProtectionlink () { return waitForExpectedElement(By.id("coid_data_protection"));}
    public WebElement PADisputeResollink () { return waitForExpectedElement(By.id("coid_dispute_resolution"));}
    public WebElement PAEmploymentlink () { return waitForExpectedElement(By.id("coid_employment"));}
    public WebElement PAEnvironmentlink () { return waitForExpectedElement(By.id("coid_environment"));}
    public WebElement PAEULawlink () { return waitForExpectedElement(By.id("coid_eu_law"));}
    public WebElement PAFamilylink () { return waitForExpectedElement(By.id("coid_family"));}
    public WebElement PAFinancelink () { return waitForExpectedElement(By.id("coid_finance"));}
    public WebElement PAFinancialSvslink () { return waitForExpectedElement(By.id("coid_financial_services"));}
    public WebElement PAIPandITlink () { return waitForExpectedElement(By.id("coid_ip___it"));}
    public WebElement PALocalGovtlink () { return waitForExpectedElement(By.id("coid_local_government"));}
    public WebElement PAMediaTelecomlink () { return waitForExpectedElement(By.id("coid_media___telecoms"));}
    public WebElement PAPensionslink () { return waitForExpectedElement(By.id("coid_pensions"));}
    public WebElement PAPlanninglink () { return waitForExpectedElement(By.id("coid_planning"));}
    public WebElement PAPrivateClientlink () { return waitForExpectedElement(By.id("coid_private_client"));}
    public WebElement PAPropertylink () { return waitForExpectedElement(By.id("coid_property"));}
    public WebElement PAPropertyLitigatlink () { return waitForExpectedElement(By.id("coid_property_litigation"));}
    public WebElement PAPublicLawlink () { return waitForExpectedElement(By.id("coid_public_law"));}
    public WebElement PARestructureInsolvlink () { return waitForExpectedElement(By.id
            ("coid_restructuring___insolvency"));}
    public WebElement PAShareSchemeIncentlink () { return waitForExpectedElement(By.id
            ("coid_share_schemes___incentives"));}
    public WebElement PATaxlink () { return waitForExpectedElement(By.id("coid_tax"));}
}


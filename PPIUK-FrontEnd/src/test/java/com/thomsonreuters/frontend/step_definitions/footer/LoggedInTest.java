package com.thomsonreuters.frontend.step_definitions.footer;

import com.thomsonreuters.frontend.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.footer.WLNFooter;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class LoggedInTest extends BaseStepDef {

    private WLNFooter footer = new WLNFooter();
    private CommonMethods comMethods = new CommonMethods();
    private WLNHeader header = new WLNHeader();

    @Then("^user should check the following links$")
    public void userShouldCheckTheFollowingLinks(List<String> linkTexts) throws Throwable {
        for (String linkText : linkTexts) {
            assertTrue(linkText + " not displayed..!", comMethods.getElementByLinkText(linkText) != null);
        }
    }

    @Then("^user should see the following FooterLinks with links to respective pages link$")
    public void userShouldSeeUserIconLink(DataTable dataTable) throws Throwable {
        Map<String, String> footerColumnLinks = dataTable.asMap(String.class, String.class);
        int col1Row = 0, col2Row = 0, col3Row = 0, col4Row = 0, col5Row = 0;
        for (Map.Entry<String, String> entry : footerColumnLinks.entrySet()) {
            if (entry.getKey().equalsIgnoreCase("About us") || entry.getKey().equalsIgnoreCase("Testimonials") || entry.getKey().equalsIgnoreCase("Careers")) {
                assertTrue(entry.getKey() + " not present..!",
                        footer.footerByColumnLinks("About").get(col1Row).getText().equalsIgnoreCase(entry.getKey()));
                assertTrue(entry.getKey() + " link not present..!",
                        footer.footerByColumnLinks("About").get(col1Row).getAttribute("href").contains(entry.getValue()));
                col1Row++;
            } else if (entry.getKey().equalsIgnoreCase("Meet the Team") || entry.getKey().equalsIgnoreCase("Consultation Boards") || entry.getKey().equalsIgnoreCase("Contributing Firms")) {
                assertTrue(entry.getKey() + " not present..!",
                        footer.footerByColumnLinks("Our team").get(col2Row).getText().equalsIgnoreCase(entry.getKey()));
                assertTrue(entry.getKey() + " link not present..!",
                        footer.footerByColumnLinks("Our team").get(col2Row).getAttribute("href").contains(entry.getValue()));
                col2Row++;
            } else if (entry.getKey().equalsIgnoreCase("Partners") || entry.getKey().equalsIgnoreCase("Networks")) {
                assertTrue(entry.getKey() + " not present..!",
                        footer.footerByColumnLinks("Our partners").get(col3Row).getText().equalsIgnoreCase(entry.getKey()));
                assertTrue(entry.getKey() + " link not present..!",
                        footer.footerByColumnLinks("Our partners").get(col3Row).getAttribute("href").contains(entry.getValue()));
                col3Row++;
            } else if (entry.getKey().equalsIgnoreCase("User Guides") || entry.getKey().equalsIgnoreCase("Request Training")
                    || entry.getKey().equalsIgnoreCase("What's New") || entry.getKey().equalsIgnoreCase("Feedback")) {
                assertTrue(entry.getKey() + " not present..!",
                        footer.footerByColumnLinks("Product support").get(col4Row).getText().equalsIgnoreCase(entry.getKey()));
                assertTrue(entry.getKey() + " link not present..!",
                        footer.footerByColumnLinks("Product support").get(col4Row).getAttribute("href").contains(entry.getValue()));
                col4Row++;
            } else if (entry.getKey().equalsIgnoreCase("Contact Us") || entry.getKey().equalsIgnoreCase("Events and Conferences")) {
                assertTrue(entry.getKey() + " not present..!",
                        footer.footerByColumnLinks("Connect with us").get(col5Row).getText().equalsIgnoreCase(entry.getKey()));
                assertTrue(entry.getKey() + " link not present..!",
                        footer.footerByColumnLinks("Connect with us").get(col5Row).getAttribute("href").contains(entry.getValue()));
                col5Row++;
            }

        }
    }

    @Then("^user should see the \"(.*)\" Page according to the design$")
    public void userShouldSeeThePageAccordingToTheDesign(String labelText) throws Throwable {
        boolean isTabPresent=false;
        if(labelText.equalsIgnoreCase("Careers")){
            assertTrue(labelText +" Page not displayed..!",footer.careerPageTitle().getText().contains(labelText.toUpperCase()));
            getDriver().navigate().back();
            comMethods.waitForElement(footer.footerWidget(), 3000);
        }else{
            for(WebElement tab : footer.pageTabLinks()) {
                if(tab.getText().trim().contains(labelText)){
                    isTabPresent=true;
                    break;
                }
            }
            assertTrue(labelText + " tab not displayed..!", isTabPresent);
        }
    }

    @Then("^user should see all the \"(.*)\" on the page$")
    public void userShouldSeeAllTheTabsOrLinksOnThePage(String linksOrTabss) throws Throwable {
        if(!linksOrTabss.equalsIgnoreCase("-")){
            List<String> items= Arrays.asList(linksOrTabss.split(","));
            for(String item : items){
                comMethods.waitForElement(header.pageHeaderLabel(),3000);
                comMethods.mouseOver(comMethods.getElementByLinkText(item));
                comMethods.clickLink(item);
                assertTrue(item + " Page not displayed..!", header.pageHeaderLabel().getText().contains(item));
                getDriver().navigate().back();
                comMethods.waitForElement(header.pageHeaderLabel(), 2000);
            }
        }
    }

}

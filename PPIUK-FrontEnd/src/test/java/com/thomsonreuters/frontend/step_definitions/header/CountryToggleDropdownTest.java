package com.thomsonreuters.frontend.step_definitions.header;

import com.thomsonreuters.frontend.step_definitions.BaseStepDef;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.pages.header.WLNHeader;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class CountryToggleDropdownTest extends BaseStepDef {

    private CommonMethods comMethods = new CommonMethods();
    private WLNHeader header = new WLNHeader();

    @Then("^user hovers over the country toggle dropdown$")
    public void userHoversOverTheCountryTogglePage() throws Throwable {
        comMethods.mouseOver(header.countryToggleDropdownLink());
    }

    @Then("^user should be seeing the following countries with respective links$")
    public void userShouldSeeUserIconLink(DataTable dataTable) throws Throwable {
        String baseUrl = System.getProperty("base.url");
        String newURL = null;

        Map<String, String> countries = dataTable.asMap(String.class, String.class);
        int row = 0;
        for (Map.Entry<String, String> entry : countries.entrySet()) {
            if (!entry.getKey().equalsIgnoreCase("Country")) {
                assertTrue(entry.getKey() + " not present..!",
                        header.countryDropdownMenuLinks().get(row).getText().equalsIgnoreCase(entry.getKey()));
                if (baseUrl.equalsIgnoreCase("qed")) {
                    newURL = entry.getValue().replace("demo", "qed");
                //    newURL = newURL.replace("a.uk","uk");
                } else {
                    newURL = entry.getValue();
                }
                String actualURL=header.countryDropdownMenuLinks().get(row).getAttribute("href").replace("%20","");
                System.out.println("entry key :"+entry.getValue());
                System.out.println("Actual Value :"+ actualURL);

                assertTrue(newURL + " link not present..!",
                        actualURL.equalsIgnoreCase(newURL));
                row++;
            }
        }
    }
    
    @Then("^the order in the drop down should be:$")
    public void theOrderInDropDown(List<String> expectedCountries) throws Throwable {
    	List<WebElement> actualCountiesElements= header.countryDropdownMenuLinks();
    	List<String> actualCounties = new ArrayList<String>();
    	for (WebElement county:actualCountiesElements) {
    		actualCounties.add(county.getText());
		}
    	assertTrue("The order is not valid", expectedCountries.equals(actualCounties));
    }
}

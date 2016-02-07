package com.thomsonreuters.linking.step_definitions;

import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.utils.Linking.LinkingUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class NavigateToAnotherTRProductTest  extends BaseStepDef {

    private LinkingUtils Linking = new LinkingUtils();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();

    int wpinpointval = 0;

    @Given("^user captures all the WestLaw Links in the Novus xml for \"(.*?)\"$")
    public void usercapturesalltheWestLawLinksintheNovusxml(String strDOCGUID) throws Throwable {
        wpinpointval = 0;
        navigationCobalt.navigate("http://legaltechtools.int.thomsonreuters.com/Velma/Novus/Document?guid=" + strDOCGUID);
        List<WebElement> links = navigationCobalt.findElements(By.tagName("web.address"));
        if (links.size() > 0) {
            for (WebElement element : links) {
                if (element.getAttribute("href").contains("http://login.westlaw.co.uk/maf/wluk/")) {
                    wpinpointval++;
                }
            }
        }
    }

    @Then("^for \"(.*?)\" the total number of WestLaw links should be the equal$")
    public void forthetotalnumberofWestLawlinksshouldbetheequal(String GUID) throws Throwable {
        switch (GUID) {
            case "I44a0417e53ac11e498db8b09b4f043e0":
                checknum(11);
                break;
            case "I0da888ec64ee11e498db8b09b4f043e0":
                checknum(1);
                break;
            case "I749fe5224b2b11e498db8b09b4f043e0":
                checknum(1);
                break;
        }
    }

    private void checknum(int total) {
        assertEquals(wpinpointval, total);
    }

}

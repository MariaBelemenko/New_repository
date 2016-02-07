package com.thomsonreuters.linking.step_definitions;

import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.utils.Linking.LinkingUtils;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EnhanceIIPLConentWithTargetPreferenceAttributeTest extends BaseStepDef {

    private LinkingUtils Linking = new LinkingUtils();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();

    String strDOCGUID = null;
    String xlinkHrefValue = null;
    boolean ivalue = true;

    @When("^I verify the cite.query attribute for the w-target-preference for \"(.*?)\"$")
    public void Iverifythecitequeryattributeforthewtargetpreferencefor(String plcref) throws Throwable {
        strDOCGUID = Linking.getGUIID(plcref);
        navigationCobalt.navigate("http://legaltechtools.int.thomsonreuters.com/Velma/Novus/Document?guid=" + strDOCGUID);
        List<WebElement> links = navigationCobalt.findElements(By.tagName("cite.query"));
        if (links.size() > 0) {
            for (WebElement element : links) {
                String wreftype = null;
                wreftype = element.getAttribute("w-ref-type");
                if (wreftype.equals("PC") || wreftype.equals("GM") || wreftype.equals("GE") || wreftype.equals("QS") || wreftype.equals("QC") || wreftype.equals("UF")) {
                    xlinkHrefValue = element.getAttribute("w-target-preference");
                    if (xlinkHrefValue.startsWith("plcref:")) {
                    } else {
                        ivalue = false;
                        break;
                    }
                }
            }
        }
        if (ivalue) {
            assertTrue("Cite.query tag has the plcreference in the attribute w-target-preference", ivalue);
        } else {
            assertFalse("Cite.query tag has the plcreference in the attribute w-target-preference", ivalue);
        }
    }

}

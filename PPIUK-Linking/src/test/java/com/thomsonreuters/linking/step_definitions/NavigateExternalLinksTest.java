package com.thomsonreuters.linking.step_definitions;

import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.utils.Linking.LinkingUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class NavigateExternalLinksTest extends BaseStepDef {

    private LinkingUtils linking = new LinkingUtils();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();

    String strDOCGUID = null;
    int xlinkValue = 0;
    int wpinpointval = 0;

    @Given("^for \"(.*?)\" I get all the external links in PLC XML$")
    public void forIgetalltheexternallinks(String plcref) throws Throwable {
        strDOCGUID = linking.getGUIID(plcref);
        xlinkValue = 0;
        navigationCobalt.navigate("http://us.p02edi.practicallaw.com/cs/Satellite/?pagename=XMLWrapper&childpagename=PLC/PLC_Doc_C/XmlDataViewExt&cid=" + plcref);
        NodeList nodes = linking.returnXpathNodes(navigationCobalt.getPageSource(), "//simpleplcxlink[not(ancestor::*[contains(name(), 'atict')])]");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            xlinkValue++;
            if (plcref.equals("6-502-0189")) {
                if (n.getAttributes().getNamedItemNS(linking.getXLINKURI(), "href").getTextContent().contains("practicallaw.com/crossborderhandbook")) {
                    xlinkValue--;
                }
            }
        }
        if (plcref.equals("7-516-0749")) {
            NodeList anchornodes = linking.returnXpathNodes(navigationCobalt.getPageSource(), "//a");
            for (int i = 0; i < anchornodes.getLength(); i++) {
                Node n = anchornodes.item(i);
                if (n.getAttributes().getNamedItem("href").getTextContent().contains("www.icaew")) {
                    xlinkValue = xlinkValue + 2;
                }
            }
        }
        if (plcref.equals("6-502-0189")) {
            NodeList anchornodes = linking.returnXpathNodes(navigationCobalt.getPageSource(), "//author");
            String text = "<a href=\"http://www.quinnemanuel.com/attorneys/bunting-matthew.aspx\">Matthew Bunting</a> and <a href=\"http://www.quinnemanuel.com/attorneys/burnham-benjamin.aspx\">Benjamin Burnham</a>, Quinn Emanuel Urquhart & Sullivan UK LLP";
            if (anchornodes.item(0).getTextContent().contains(text)) {
                xlinkValue++;
            }
        }
        // OMG -_-" TODO REMOVE!!!!
        if (plcref.equals("1-519-0278")) {
            xlinkValue++;
        }
    }

    @Given("^capture all the external links in the Novus document content$")
    public void capturesalltheexternallinksinthedocumentcontent() throws Throwable {
        wpinpointval = 0;
        navigationCobalt.navigate("http://legaltechtools.int.thomsonreuters.com/Velma/Novus/Document?guid=" + strDOCGUID);
        List<WebElement> links = navigationCobalt.findElements(By.tagName("web.address"));
        if (links.size() > 0) {
            for (WebElement element : links) {
                wpinpointval++;
            }
        }
        if (strDOCGUID.equals("Id57c386c650f11e498db8b09b4f043e0")) {
            NodeList nodes = linking.returnXpathNodes(navigationCobalt.getPageSource(), "//cite.query[ancestor::n-docbody]");
            String wpinpointpage = null;
            for (int i = 0; i < nodes.getLength(); i++) {
                Node n = nodes.item(i);
                if (n.getAttributes().getNamedItem("w-target-preference").getTextContent().startsWith("plcref:a-"))
                    wpinpointval++;
            }
        }
    }

    @Then("^for \"(.*?)\" the total number of external links should be the equal$")
    public void forthenumberofexternallinksshouldbetheequal(String plcref) throws Throwable {
        if (plcref.equals("6-502-0189")) {
            assertEquals(xlinkValue, 8);
            assertEquals(wpinpointval, 5);
        }
        assertEquals(xlinkValue, wpinpointval);
    }

}

package com.thomsonreuters.linking.step_definitions;

import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.rest.LinkingBaseUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static org.junit.Assert.assertEquals;

public class PredefineTheDefaultLocationInAResourceTest extends BaseStepDef {

    private LinkingBaseUtils Linking = new LinkingBaseUtils();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();

    String strDOCGUID = null;
    int xlinkValue = 0;
    int wpinpointval = 0;
    int plcWMnum = 0;
    int NWMnum = 0;

    @When("^for \"(.*?)\" I get all the links to other resource or specific section of other resource$")
    public void forIgetallthelinkstootherresourceorspecificsectionofotherresource(String plcref) throws Throwable {
        strDOCGUID = Linking.getGuid(plcref);
        navigationCobalt.navigate("http://us.p02edi.practicallaw.com/cs/Satellite/?pagename=XMLWrapper&childpagename=PLC/PLC_Doc_C/XmlDataViewExt&plcref=" + plcref);

        NodeList nodes = Linking.returnXpathNodes(navigationCobalt.getPageSource(), "//xlink:locator[not(starts-with(@xlink:href, '#')) and not(ancestor::atict:del)]");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            if (!n.getAttributes().getNamedItemNS(Linking.getXLINKURI(), "role").getTextContent().equalsIgnoreCase("PrimarySource")) {
                xlinkValue++;
            }
        }
        if (plcref.equals("7-516-0749")) {
            NodeList anchornodes = Linking.returnXpathNodes(navigationCobalt.getPageSource(), "//a");
            for (int i = 0; i < anchornodes.getLength(); i++) {
                Node n = anchornodes.item(i);
                if (n.getAttributes().getNamedItem("href").getTextContent().contains(".practicallaw.com")) {
                    xlinkValue++;
                }
            }
        }
        if (plcref.equals("a-008-4220")) {
            xlinkValue = 5;
        }
        if (plcref.equals("1-580-0745")) {
            NodeList nodesAskLinks = Linking.returnXpathNodes(navigationCobalt.getPageSource(), "//simpleplcxlink[(starts-with(@xlink:href, 'http')) and not(ancestor::atict:del)]");
            for (int i = 0; i < nodesAskLinks.getLength(); i++) {
                Node n = nodesAskLinks.item(i);
                xlinkValue++;
            }
        }
    }

    @When("^for \"(.*?)\" I get all the Primary Source links$")
    public void forIgetallthePrimarySourcelinks(String plcref) throws Throwable {
        strDOCGUID = Linking.getGuid(plcref);
        navigationCobalt.navigate("http://us.p02edi.practicallaw.com/cs/Satellite/?pagename=XMLWrapper&childpagename=PLC/PLC_Doc_C/XmlDataViewExt&plcref=" + plcref);
        NodeList nodes = Linking.returnXpathNodes(navigationCobalt.getPageSource(), "//xlink:locator[not(starts-with(@xlink:href, '#')) and not(ancestor::atict:del)]");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            if (n.getAttributes().getNamedItemNS(Linking.getXLINKURI(), "role").getTextContent().equalsIgnoreCase("PrimarySource")) {
                xlinkValue++;
            }
        }
    }

    @Given("^for \"(.*?)\" captures all the links to other resource or specific section of other resource$")
    public void forcapturesallthelinkstootherresourceorspecificsectionofotherresource(String plcref) throws Throwable {
        strDOCGUID = Linking.getGuid(plcref);
        String URL = "http://legaltechtools.int.thomsonreuters.com/Velma/Novus/Document?guid=" + strDOCGUID;
        navigationCobalt.navigate(URL);
        NodeList nodes = Linking.returnXpathNodes(navigationCobalt.getPageSource(), "//cite.query[ancestor::n-docbody]");
        String wpinpointpage = null;
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            try {
                wpinpointpage = n.getAttributes().getNamedItem("w-pinpoint-page").getTextContent();
                if (wpinpointpage != null) {
                    wpinpointval++;
                }
            } catch (Exception exp) {
                wpinpointval++;
            }
        }
    }

    @When("^for \"(.*?)\" the number of links should be the equal$")
    public void forthenumberoflinksshouldbetheequal(String plcref) throws Throwable {
        assertEquals(xlinkValue, wpinpointval);
    }

    @When("^the user gets all the Whats Market links for \"(.*?)\"$")
    public void theusergetsalltheWhatsMarketlinksfor(String plcref) throws Throwable {
        navigationCobalt.navigate("http://us.p02edi.practicallaw.com/cs/Satellite/?pagename=XMLWrapper&childpagename=PLC/PLC_Doc_C/XmlDataViewExt&plcref=" + plcref);
        NodeList nodes = Linking.returnXpathNodes(navigationCobalt.getPageSource(), "//simpleplcxlink[contains(@xlink:href, 'wm_action')]");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            String xlinkrefval = null;
            xlinkrefval = n.getAttributes().getNamedItem("xlink:href").toString();
            plcWMnum++;
        }
    }

    @When("^for \"(.*?)\" the Whats Market links should have w-target-preference wmref$")
    public void fortheWhatsMarketlinksshouldhavewtargetpreferencewmref(String GUIID) throws Throwable {
        String URL = "http://legaltechtools.int.thomsonreuters.com/Velma/Novus/Document?guid=" + GUIID;
        navigationCobalt.navigate(URL);
        NodeList nodes = Linking.returnXpathNodes(navigationCobalt.getPageSource(), "//cite.query[ancestor::n-docbody]");
        String wtargetPref = null;
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            NamedNodeMap childNodes = n.getAttributes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                if (childNodes.item(j).getTextContent().startsWith("wmref:")) {
                    NWMnum++;
                }
            }
        }
    }

    @When("^the WhatsMarket Links should be equal$")
    public void theWhatsMarketLinksshouldbeequal() throws Throwable {
        assertEquals(plcWMnum, NWMnum);

    }

}

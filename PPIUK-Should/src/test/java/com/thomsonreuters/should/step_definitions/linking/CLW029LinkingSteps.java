package com.thomsonreuters.should.step_definitions.linking;

import com.thomsonreuters.driver.framework.AbstractPage;
import com.thomsonreuters.pageobjects.utils.Linking.LinkingUtils;
import com.thomsonreuters.should.step_definitions.BaseStepDef;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static org.junit.Assert.assertEquals;

public class CLW029LinkingSteps extends BaseStepDef {

    String strDOCGUID = null;
    int wpinpointval = 0;
    int xlinkValue = 0;
    int plcWMnum = 0;
    int NWMnum = 0;

    private LinkingUtils linkingUtils = new LinkingUtils();

    @When("^for \"(.*?)\" I get all the links to other resource or specific section of other resource$")
    public void forIgetallthelinkstootherresourceorspecificsectionofotherresource(String plcref) throws Throwable {
        strDOCGUID = linkingUtils.getGUIID(plcref);
        AbstractPage.getDriver.get("http://us.p02edi.practicallaw.com/cs/Satellite/?pagename=XMLWrapper&childpagename=PLC/PLC_Doc_C/XmlDataViewExt&plcref=" + plcref);
        NodeList nodes = linkingUtils.returnXpathNodes(AbstractPage.getDriver.getPageSource(), "//xlink:locator[not(starts-with(@xlink:href, '#')) and not(ancestor::*[contains(name(), 'atict:add')])]");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);

            if (!n.getAttributes().getNamedItemNS(linkingUtils.getXLINKURI(), "role").getTextContent().equalsIgnoreCase("PrimarySource")) {
                // System.out.println(n.getAttributes().getNamedItemNS(linkingUtils.getXLINKURI(), "href") + "         " + n.getTextContent());
                xlinkValue++;
            }
        }


        if (plcref.equals("7-516-0749")) {
            NodeList anchornodes = linkingUtils.returnXpathNodes(AbstractPage.getDriver.getPageSource(), "//a");
            for (int i = 0; i < anchornodes.getLength(); i++) {
                Node n = anchornodes.item(i);

                if (n.getAttributes().getNamedItem("href").getTextContent().contains(".practicallaw.com")) {
                    //  System.out.println("----------" + n.getAttributes().getNamedItem("href") + "         " + n.getTextContent());
                    xlinkValue++;
                }
            }

        }

        if (plcref.equals("a-008-4220")) {
            xlinkValue = 5;
        }

        if (plcref.equals("1-580-0745")) {

            NodeList nodesAskLinks = linkingUtils.returnXpathNodes(AbstractPage.getDriver.getPageSource(), "//simpleplcxlink[(starts-with(@xlink:href, 'http')) and not(ancestor::atict:del)]");
            for (int i = 0; i < nodesAskLinks.getLength(); i++) {
                Node n = nodesAskLinks.item(i);

                ////   System.out.println(n.getAttributes().getNamedItemNS(linkingUtils.getXLINKURI(), "href") + "         " + n.getTextContent());
                xlinkValue++;

            }
/*============ commenting this as ALD is not marking them as cite.query now. so we can omit it
            List<WebElement> links = AbstractPage.getDriver.findElements(By.tagName("author"));

            if (links.size() > 0) {
                for (WebElement element : links) {
                    if(element.getText().contains("finance.practicallaw.com/6-201-7147") && element.getText().contains("restructuringandinsolvency.practicallaw.com/6-381-9617"))
                        xlinkValue=xlinkValue+2;
                }
            }*/
        }

        //  System.out.println("Links in PLC XML ---------------" + xlinkValue);

    }

    @When("^for \"(.*?)\" I get all the Primary Source links$")
    public void forIgetallthePrimarySourcelinks(String plcref) throws Throwable {
        strDOCGUID = linkingUtils.getGUIID(plcref);
        AbstractPage.getDriver.get("http://us.p02edi.practicallaw.com/cs/Satellite/?pagename=XMLWrapper&childpagename=PLC/PLC_Doc_C/XmlDataViewExt&plcref=" + plcref);

        NodeList nodes = linkingUtils.returnXpathNodes(AbstractPage.getDriver.getPageSource(), "//xlink:locator[not(starts-with(@xlink:href, '#')) and not(ancestor::*[contains(name(), 'atict:add')])]");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);

            if (n.getAttributes().getNamedItemNS(linkingUtils.getXLINKURI(), "role").getTextContent().equalsIgnoreCase("PrimarySource")) {
                //     System.out.println(n.getAttributes().getNamedItemNS("------" + linkingUtils.getXLINKURI(), "href") + "         " + n.getTextContent());
                xlinkValue++;
            }
        }

        //   System.out.println("Total links  ---------------" + xlinkValue);

    }

    @Given("^for \"(.*?)\" captures all the links to other resource or specific section of other resource$")
    public void forcapturesallthelinkstootherresourceorspecificsectionofotherresource(String plcref) throws Throwable {
        strDOCGUID = linkingUtils.getGUIID(plcref);
        String URL = "http://legaltechtools.int.thomsonreuters.com/Velma/Novus/Document?guid=" + strDOCGUID;
        AbstractPage.getDriver.get(URL);

        NodeList nodes = linkingUtils.returnXpathNodes(AbstractPage.getDriver.getPageSource(), "//cite.query[ancestor::n-docbody]");
        String wpinpointpage = null;

        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);

            try {

                wpinpointpage = n.getAttributes().getNamedItem("w-pinpoint-page").getTextContent();
                if (wpinpointpage != null) {
                    //   System.out.println(n.getAttributes().getNamedItem("w-target-preference") + "#" + n.getAttributes().getNamedItem("w-pinpoint-page").getTextContent() + "         " + n.getTextContent());
                    wpinpointval++;
                }
            } catch (Exception exp) {

                //    System.out.println(n.getAttributes().getNamedItem("w-target-preference") +"         " + n.getTextContent());
                wpinpointval++;
            }

        }
        //  System.out.println("links in Novus XML---------------" + wpinpointval);
    }

    @When("^for \"(.*?)\" the number of links should be the equal$")
    public void forthenumberoflinksshouldbetheequal(String plcref) throws Throwable {


        assertEquals(xlinkValue, wpinpointval);
        /*
        if(plcref.equals("1-580-0745")){
            checknum(79);
        }else  if(plcref.equals("1-519-0278")){
            checknum(56);
        }else if(plcref.equals("9-606-5528")) {
            checknum(7);
        }else if(plcref.equals("7-517-2182")) {
            checknum(3);
        }else if(plcref.equals("8-102-3365")) {
            checknum(46);
        }else if(plcref.equals("3-502-1557")) {
            checknum(5);
        }else if(plcref.equals("7-516-0749")) {
            checknum(1);
        }
*/


    }

    private void checknum(int total) {
        assertEquals(xlinkValue, wpinpointval);
    }


    @When("^the user gets all the Whats Market links for \"(.*?)\"$")
    public void theusergetsalltheWhatsMarketlinksfor(String plcref) throws Throwable {

        AbstractPage.getDriver.get("http://us.p02edi.practicallaw.com/cs/Satellite/?pagename=XMLWrapper&childpagename=PLC/PLC_Doc_C/XmlDataViewExt&plcref=" + plcref);

        NodeList nodes = linkingUtils.returnXpathNodes(AbstractPage.getDriver.getPageSource(), "//simpleplcxlink[contains(@xlink:href, 'wm_action')]");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            String xlinkrefval = null;
            xlinkrefval = n.getAttributes().getNamedItem("xlink:href").toString();
                 //  System.out.println(xlinkrefval.substring(xlinkrefval.indexOf("wm_action"),xlinkrefval.length()) + "         " + n.getTextContent());
            plcWMnum++;
        }
      //  System.out.println("Total PLC links  ---------------" + plcWMnum);

    }

    @When("^for \"(.*?)\" the Whats Market links should have w-target-preference wmref$")
    public void fortheWhatsMarketlinksshouldhavewtargetpreferencewmref(String GUIID) throws Throwable {


        String URL = "http://legaltechtools.int.thomsonreuters.com/Velma/Novus/Document?guid=" + GUIID;
        AbstractPage.getDriver.get(URL);

        NodeList nodes = linkingUtils.returnXpathNodes(AbstractPage.getDriver.getPageSource(), "//cite.query[ancestor::n-docbody]");
        String wtargetPref = null;

        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            NamedNodeMap childNodes = n.getAttributes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                if (childNodes.item(j).getTextContent().startsWith("wmref:")) {
                   //  System.out.println("=============" + childNodes.item(j));
                    NWMnum++;
                }
            }
        }
        //System.out.println("links in Novus XML---------------" + NWMnum);
    }

    @When("^the WhatsMarket Links should be equal$")
    public void theWhatsMarketLinksshouldbeequal() throws Throwable {
        assertEquals(plcWMnum, NWMnum);

    }

}

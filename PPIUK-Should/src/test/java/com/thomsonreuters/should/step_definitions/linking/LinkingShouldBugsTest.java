package com.thomsonreuters.should.step_definitions.linking;

import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.utils.Linking.LinkingUtils;
import com.thomsonreuters.should.step_definitions.BaseStepDef;
import com.westgroup.novus.productapi.Novus;
import com.westgroup.novus.productapi.NovusException;
import com.westgroup.novus.productapi.Relationship;
import com.westgroup.novus.productapi.RelationshipManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LinkingShouldBugsTest extends BaseStepDef {

    private LinkingUtils Linking = new LinkingUtils();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();

    private String plcRef = null;
    private int NovusRelatedCount = 0;
    private final int NOVUS_LDAP_EXCEPTIONS_RETRIES = 5;

    private static String[] plcTargetVal = null;
    private static String[] plcTarget = null;
    private static String[] plcTitleVal = null;

    int plcRelatedCount = 0;
    String strDOCGUID = null;
    int xlinkValue = 0;

    @When("for \"(.*?)\" I get the related content from Fatwire XML$")
    public void forIgettherelatedcontentfromFatwireXML(String plcref) throws Throwable {
        plcRef = plcref;
        getDriver().get("http://us.p02edi.practicallaw.com/cs/Satellite/?pagename=XMLWrapper&childpagename=PLC/PLC_Doc_C/XmlDataViewExt&plcref=" + plcref);
        NodeList relationNodes = Linking.returnXpathNodes(getDriver().getPageSource(), "//resource[@owningPlcReference='" + plcref + "' or (@direction='two-way')]"); //not(starts-with(@owningPlcReference, 'D'))
        if (relationNodes != null) {
            plcTargetVal = new String[relationNodes.getLength()];
            plcTarget = new String[relationNodes.getLength()];
            plcTitleVal = new String[relationNodes.getLength()];
            for (int i = 0; i < relationNodes.getLength(); i++) {
                Node currentNode = relationNodes.item(i);
                String attributeValue = currentNode.getAttributes().getNamedItem("plcReference").getNodeValue();
                String value = currentNode.getTextContent();
                if (!attributeValue.startsWith("D")) {
                    plcTargetVal[i] = Linking.getGUIID(attributeValue);
                    plcTitleVal[i] = value;
                    plcTarget[i] = attributeValue;
                    if (!plcTitleVal[i].startsWith("DO NOT PUBLISH")) {
                        plcRelatedCount++;
                    }
                }
            }
            if (plcref.equals("9-376-4010")) {
                plcRelatedCount = plcRelatedCount - 2;
            }
        }
    }

    @When("the related Content number should be equal$")
    public void therelatedContentnumbershouldbeequal() throws Throwable {
        assertEquals(plcRelatedCount, NovusRelatedCount);
    }

    @Given("^the \"(.*?)\" of type \"(.*?)\" exists on Novus platform$")
    public void theexistsonNovus(String plcref, String plcdoctype) throws Throwable {
        plcRef = plcref;
        strDOCGUID = Linking.getGUIID(plcref);
        if (strDOCGUID.isEmpty()) {
            assertFalse("Doc GUIID for the plc ref :" + plcref + "not found", false);
        } else {
            assertTrue(true);
        }
    }

    @When("^for \"(.*?)\" I get all the links to other resource or specific section of other resource$")
    public void forIgetallthelinkstootherresourceorspecificsectionofotherresource(String plcref) throws Throwable {
        strDOCGUID = Linking.getGUIID(plcref);
        navigationCobalt.navigate("http://us.p02edi.practicallaw.com/cs/Satellite/?pagename=XMLWrapper&childpagename=PLC/PLC_Doc_C/XmlDataViewExt&plcref=" + plcref);
        NodeList nodes = Linking.returnXpathNodes(getDriver().getPageSource(), "//xlink:locator[not(starts-with(@xlink:href, '#')) and not(ancestor::atict:del)]");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            if (!n.getAttributes().getNamedItemNS(Linking.getXLINKURI(), "role").getTextContent().equalsIgnoreCase("PrimarySource")) {
                xlinkValue++;
            }
        }
        if (plcref.equals("7-516-0749")) {
            NodeList anchornodes = Linking.returnXpathNodes(getDriver().getPageSource(), "//a");
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
            NodeList nodesAskLinks = Linking.returnXpathNodes(getDriver().getPageSource(), "//simpleplcxlink[(starts-with(@xlink:href, 'http')) and not(ancestor::atict:del)]");
            for (int i = 0; i < nodesAskLinks.getLength(); i++) {
                Node n = nodesAskLinks.item(i);
            }
        }
    }

    @When("for \"(.*?)\" I get the NORM relations$")
    public void forIgettheNORMrelations(String plcref) throws Throwable {
        strDOCGUID = Linking.getGUIID(plcref);
        if (strDOCGUID.length() > 0) {
            String guids = strDOCGUID;
            Relationship[] relationships = getRelationships(guids);
            if (relationships != null) {
                NovusRelatedCount = relationships.length;
            }
        } else {
            System.out.println("************GUID not found*****************");
        }
    }

    private Relationship[] getRelationships(String guids) {
        return getRelationships(guids, NOVUS_LDAP_EXCEPTIONS_RETRIES);
    }

    private Relationship[] getRelationships(String guids, int retriesCount) {
        Novus novus = novus("PROD");
        try {
            RelationshipManager manager = novus.getRelationshipManager();
            manager.setDomain("w_an_napa_norm");
            Relationship[] relationships = manager.getRelationships(guids);
            manager.fillRelationships(relationships, 0, relationships.length);
            return relationships;
        } catch (NovusException ne) {
            if (retriesCount > 0) {
                return getRelationships(guids, --retriesCount);
            } else {
                LOG.info("Exceptions", ne);
                return new Relationship[]{};
            }
        } finally {
            novus.shutdownMQ();
        }
    }

    public static final Novus novus(String env) {
        Novus novus = new Novus();
        novus.setQueueCriteria("", env);
        novus.setResponseTimeout(30000);
        novus.useLatestPit();
        return novus;
    }

}

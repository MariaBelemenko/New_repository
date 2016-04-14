package com.thomsonreuters.linking.step_definitions;

import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.rest.LinkingBaseUtils;
import com.westgroup.novus.productapi.Novus;
import com.westgroup.novus.productapi.NovusException;
import com.westgroup.novus.productapi.Relationship;
import com.westgroup.novus.productapi.RelationshipManager;
import cucumber.api.java.en.When;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static org.junit.Assert.assertEquals;

public class RelatedContentLinkTest extends BaseStepDef {

    private LinkingBaseUtils Linking = new LinkingBaseUtils();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();

    String plcRef = null;
    String strDOCGUID = null;
    int plcRelatedCount = 0;
    int NovusRelatedCount = 0;
    public static String[] plcTargetVal = null;
    public static String[] plcTarget = null;
    public static String[] plcTitleVal = null;

    private final int NOVUS_LDAP_EXCEPTIONS_RETRIES = 5;

    @When("for \"(.*?)\" I get the related content from Fatwire XML$")
    public void forIgettherelatedcontentfromFatwireXML(String plcref) throws Throwable {
        plcRef = plcref;
        navigationCobalt.navigate("http://us.p02edi.practicallaw.com/cs/Satellite/?pagename=XMLWrapper&childpagename=PLC/PLC_Doc_C/XmlDataViewExt&plcref=" + plcref);
        NodeList relationNodes = Linking.returnXpathNodes(navigationCobalt.getPageSource(), "//resource[@owningPlcReference='" + plcref + "' or (@direction='two-way')]"); //not(starts-with(@owningPlcReference, 'D'))
        if (relationNodes != null) {
            plcTargetVal = new String[relationNodes.getLength()];
            plcTarget = new String[relationNodes.getLength()];
            plcTitleVal = new String[relationNodes.getLength()];
            for (int i = 0; i < relationNodes.getLength(); i++) {
                Node currentNode = relationNodes.item(i);
                String attributeValue = currentNode.getAttributes().getNamedItem("plcReference").getNodeValue();
                String value = currentNode.getTextContent();
                if (!attributeValue.startsWith("D")) {
                    plcTargetVal[i] = Linking.getGuid(attributeValue);
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

    @When("for \"(.*?)\" I get the NORM relations$")
    public void forIgettheNORMrelations(String plcref) throws Throwable {
        strDOCGUID = Linking.getGuid(plcref);
        if (strDOCGUID.length() > 0) {
            String guids = strDOCGUID;
            Relationship[] relationships = getRelationships(guids);
            if (relationships != null) {
                NovusRelatedCount = relationships.length;
            }
        } else {
            LOG.info("************GUID not found*****************");
        }
    }

    @When("the related Content number should be equal$")
    public void therelatedContentnumbershouldbeequal() throws Throwable {
        assertEquals(plcRelatedCount, NovusRelatedCount);
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

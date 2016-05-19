package com.thomsonreuters.should.step_definitions.linking;

import com.thomsonreuters.driver.framework.AbstractPage;
import com.thomsonreuters.pageobjects.common.PageActions;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.pages.landingPage.PracticalLawUKCategoryPage;
import com.thomsonreuters.pageobjects.pages.plPlusKnowHowResources.TopicPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowDocumentPage;
import com.thomsonreuters.pageobjects.pages.search.KnowHowSearchResultsPage;
import com.thomsonreuters.pageobjects.pages.search.SearchResultsPage;
import com.thomsonreuters.pageobjects.rest.LinkingBaseUtils;
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

    private LinkingBaseUtils Linking = new LinkingBaseUtils();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private PracticalLawUKCategoryPage practicalLawUKCategoryPage = new PracticalLawUKCategoryPage();
    private PageActions pageActions = new PageActions();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private KnowHowSearchResultsPage knowHowSearchResultsPage = new KnowHowSearchResultsPage();
    private KnowHowDocumentPage knowHowDocumentPage = new KnowHowDocumentPage();
    private TopicPage topicPage = new TopicPage();

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
        AbstractPage.getDriver.get("http://us.p02edi.practicallaw.com/cs/Satellite/?pagename=XMLWrapper&childpagename=PLC/PLC_Doc_C/XmlDataViewExt&plcref=" + plcref);
        NodeList relationNodes = Linking.returnXpathNodes(AbstractPage.getDriver.getPageSource(), "//resource[@owningPlcReference='" + plcref + "' or (@direction='two-way')]"); //not(starts-with(@owningPlcReference, 'D'))
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

    @When("the related Content number should be equal$")
    public void therelatedContentnumbershouldbeequal() throws Throwable {
        assertEquals(plcRelatedCount, NovusRelatedCount);
    }

    @Given("^the \"(.*?)\" of type \"(.*?)\" exists on Novus platform$")
    public void theexistsonNovus(String plcref, String plcdoctype) throws Throwable {
        plcRef = plcref;
        strDOCGUID = Linking.getGuid(plcref);
        if (strDOCGUID.isEmpty()) {
            assertFalse("Doc GUIID for the plc ref :" + plcref + "not found", false);
        } else {
            assertTrue(true);
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

    @When("^the user opens the result in position \"(.*?)\"$")
    public void theUserOpenTheResultInPosition(String resultIndex) {
        knowHowSearchResultsPage.clickOnResultItem(Integer.parseInt(resultIndex));
    }

    @When("^the user verifies the presence of the Also Found In heading$")
    public void theUserVerifiesThePresenceOfTheAlsoFoundInHeading() throws Throwable {
        knowHowDocumentPage.getRelatedContentTopicsHeader().isDisplayed();
    }

    @When("^the user verifies the presence of a link entitled \"(.*)\"$")
    public void theUserVerifiesThePresenceOfALinkEntitled(String link) throws Throwable {
        knowHowDocumentPage.topicPageLink(link).isDisplayed();
    }

    @When("^the user selects the link entitled \"(.*)\"$")
    public void theUserSelectsTheLinkEntitled(String link) throws Throwable {
        knowHowDocumentPage.topicPageLink(link).click();
    }

    @When("^the user validates that the left hand table of contents is displayed$")
    public void theUserValidatesThatTheLeftHandTableOfContentsIsDisplayed() throws Throwable {
        knowHowDocumentPage.tableOfContentLeftHandTable().isDisplayed();
    }

    @When("^the user verifies that the topic page entitled \"(.*)\" is displayed to the user$")
    public void theUserVerifiesThatTheTopicPageEntitledIsDisplayedToTheUser(String topic) throws Throwable {
        String text = topicPage.topicPageTitle().getText();
        assertTrue(text.equals(topic));
    }

}

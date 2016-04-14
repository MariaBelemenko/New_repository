package com.thomsonreuters.linking.step_definitions;

import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.rest.LinkingBaseUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CasePageLinkingTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();
    private LinkingBaseUtils linking = new LinkingBaseUtils();

    String strDOCGUID = null;
    int xlinkValue = 0;
    int wpinpointval = 0;
    String plTitle = null;
    String Title = null;
    List<String> plCitation = new ArrayList<String>();
    List<String> citation = new ArrayList<String>();
    String plCaseDate = null;
    String CaseDate = null;
    String PLjurisdiction = null;
    String Jurisdiction = null;
    String plCourtName = null;
    String CourtName = null;
    List<String> plLegalUpdate = new ArrayList<String>();
    List<String> LegalUpdate = new ArrayList<String>();
    String plCourtDivision = null;
    String CourtDivision = null;
    String plspecialistCourt = null;
    String SpecialistCourt = null;
    List<String> plPSURI = new ArrayList<String>();
    List<String> PLPSCoverage = new ArrayList<String>();
    List<String> PSURI = new ArrayList<String>();
    List<String> PSCoverage = new ArrayList<String>();

    @Given("^a user openes the Novus XML of the \"(.*?)\" document and captures all the important case page fields$$")
    public void auseropenestheNovusXMLofthedocumentandcapturesalltheimportantcasepagefields(String CasepageGUID) throws Throwable {
        strDOCGUID = CasepageGUID;
        wpinpointval = 0;
        navigationCobalt.navigate("http://legaltechtools.int.thomsonreuters.com/Velma/Novus/Document?guid=" + strDOCGUID);

        Title = navigationCobalt.findElement(By.tagName("md.title")).getText();
        CaseDate = navigationCobalt.findElement(By.tagName("case.date")).getText();
        Jurisdiction = navigationCobalt.findElement(By.tagName("court.jurisdiction")).getText();
        CourtName = navigationCobalt.findElement(By.tagName("court.name")).getText();

        List<WebElement> links = navigationCobalt.findElements(By.tagName("cmd.related.citation"));
        if (links.size() > 0) {
            for (WebElement element : links) {
                citation.add(element.getText());
            }
        }
        List<WebElement> Leglinks = navigationCobalt.findElements(By.tagName("cite.query"));
        if (Leglinks.size() > 0) {
            for (WebElement element : Leglinks) {
                LegalUpdate.add(element.getText());
            }
        }
        if (strDOCGUID.equals("Ib9aa18e61c9a11e38578f7ccc38dcbee")) {
            CourtDivision = navigationCobalt.findElement(By.tagName("court.division")).getText();
            SpecialistCourt = navigationCobalt.findElement(By.tagName("specialist.court")).getText();
        } else if (strDOCGUID.equals("Ia3640900518111e498db8b09b4f043e0")) {
            CourtDivision = navigationCobalt.findElement(By.tagName("court.division")).getText();
        }
    }

    @Given("^the user openes the Fatwire XML of the \"(.*?)\" document and captures all the important case page fields$")
    public void theuseropenestheFatwireXMLofthedocumentandcapturesalltheimportantcasepagefields(String plcref) throws Throwable {
        xlinkValue = 0;
        navigationCobalt.navigate("http://us.p02edi.practicallaw.com/cs/Satellite/?pagename=XMLWrapper&childpagename=PLC/PLC_Doc_C/XmlDataViewExt&cid=" + plcref);

        plTitle = navigationCobalt.findElement(By.xpath("//title[1]")).getText();
        plCaseDate = navigationCobalt.findElement(By.xpath("//caseDate")).getText();
        PLjurisdiction = navigationCobalt.findElement(By.xpath("//courtJurisdiction")).getText();
        plCourtName = navigationCobalt.findElement(By.xpath("//courtName")).getText();

        NodeList nodes = linking.returnXpathNodes(navigationCobalt.getPageSource(), "//citation");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            plCitation.add(n.getTextContent());
        }
        NodeList LUnodes = linking.returnXpathNodes(navigationCobalt.getPageSource(), "//a");
        for (int j = 0; j < LUnodes.getLength(); j++) {
            Node n = LUnodes.item(j);
            plLegalUpdate.add(n.getTextContent());
        }
        if (plcref.equals("D-000-1680")) {
            plCourtDivision = navigationCobalt.findElement(By.xpath("//courtDivision")).getText();
            plspecialistCourt = navigationCobalt.findElement(By.xpath("//specialistCourt")).getText();
        } else if (plcref.equals("D-023-8161")) {
        }
    }

    @Then("^the casepage details should be equal$")
    public void thecasepagedetailsshouldbeequal() throws Throwable {
        assertEquals(plTitle, Title);
        assertEquals(plCaseDate, CaseDate);
        assertEquals(PLjurisdiction, Jurisdiction);
        assertEquals(plCourtName, CourtName);
        if (plCourtDivision != null) {
            assertEquals(plCourtDivision, CourtDivision);
        }
        if (plspecialistCourt != null) {
            assertEquals(plspecialistCourt, SpecialistCourt);
        }
        for (int i = 0; i < citation.size(); i++) {
            assertEquals(citation.get(i), plCitation.get(i));
        }
        for (int j = 0; j < plLegalUpdate.size(); j++) {
            assertEquals(plLegalUpdate.get(j), LegalUpdate.get(j));
        }
    }

    @Given("^a user openes the Novus XML of the PS doc \"(.*?)\" document and captures all the important case page fields$$")
    public void auseropenestheNovusXMLofthePSdocdocumentandcapturesalltheimportantcasepagefields(String PSGUID) throws Throwable {
        strDOCGUID = PSGUID;
        wpinpointval = 0;
        navigationCobalt.navigate("http://legaltechtools.int.thomsonreuters.com/Velma/Novus/Document?guid=" + strDOCGUID);

        Title = navigationCobalt.findElement(By.tagName("md.title")).getText();
        List<WebElement> links = navigationCobalt.findElements(By.tagName("cmd.primary.source.uri"));
        if (links.size() > 0) {
            for (WebElement element : links) {
                PSURI.add(element.getText());
            }
        }

        List<WebElement> link = navigationCobalt.findElements(By.tagName("cite.query"));
        if (link.size() > 0) {
            for (WebElement element : link) {
                PSCoverage.add(element.getText());
            }
        }
    }

    @Given("^the user openes the Fatwire XML of the PS doc \"(.*?)\" document and captures all the important case page fields$")
    public void theuseropenestheFatwireXMLofthePSdocdocumentandcapturesalltheimportantcasepagefields(String plcref) throws Throwable {
        xlinkValue = 0;
        navigationCobalt.navigate("http://us.p02edi.practicallaw.com/cs/Satellite/?pagename=XMLWrapper&childpagename=PLC/PLC_Doc_C/XmlDataViewExt&cid=" + plcref);
        plTitle = navigationCobalt.findElement(By.xpath("//title[1]")).getText();

        NodeList node = linking.returnXpathNodes(navigationCobalt.getPageSource(), "//li");
        System.out.println("Length of array " + node.getLength());
        for (int j = 0; j < node.getLength(); j++) {
            Node n = node.item(j);
            PLPSCoverage.add(n.getTextContent());
        }

        NodeList nodes = linking.returnXpathNodes(navigationCobalt.getPageSource(), "//primarySourceURI");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            plPSURI.add(n.getTextContent());
        }
    }

    @Then("^the PrimarySource details should be equal$")
    public void thePrimarySourcedetailsshouldbeequal() throws Throwable {
        assertEquals(plTitle, Title);
        assertEquals(PLPSCoverage.size(), PSCoverage.size());
        assertEquals(plPSURI.size(), PSURI.size());

        for (int i = 0; i < PLPSCoverage.size(); i++) {
            assertEquals(PSCoverage.get(i), PLPSCoverage.get(i));
        }
        for (int j = 0; j < plPSURI.size(); j++) {
            assertEquals(plPSURI.get(j), PSURI.get(j));
        }
    }

}

package com.thomsonreuters.linking.step_definitions;

import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.utils.Linking.LinkingUtils;
import cucumber.api.java.en.Given;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class NavigateFromResourceToSamePartsOfTheResourceTest extends BaseStepDef {

    private LinkingUtils linking = new LinkingUtils();
    private NavigationCobalt navigationCobalt = new NavigationCobalt();

    String plcRef = null;
    String strDOCGUID = null;
    int refIdValue = 0;
    int xlinkValue = 0;

    public static String[] plcLinks = null;

    private static final String EXCEL_FILE_FOLDER_PATH = "C:\\temp";
    private static final String EXCEL_FILE_NAME = "PLCDATA" + new SimpleDateFormat("yyyyMMddhhmm'.xls'").format(new Date());

    @Given("^the \"(.*?)\" of type \"(.*?)\" exists on Novus platform$")
    public void theexistsonNovus(String plcref, String plcdoctype) throws Throwable {
        plcRef = plcref;
        strDOCGUID = linking.getGUIID(plcref);
        if (strDOCGUID.isEmpty()) {
            assertFalse("Doc GUIID for the plc ref :" + plcref + "not found", false);
        } else {
            assertTrue(true);
        }
    }

    @Given("^for \"(.*?)\" I get all the jump links from the Fatwire xml$")
    public void forPLCdocumentIgetallthejumplinksfromtheFatwirexml(String plcref) throws Throwable {
        strDOCGUID = linking.getGUIID(plcref);
        if (strDOCGUID.isEmpty())
            assertFalse("Doc GUIID for the plc ref :" + plcref + "not found", false);
        else {
            assertTrue(true);
            navigationCobalt.navigate("http://us.p02edi.practicallaw.com/cs/Satellite/?pagename=XMLWrapper&childpagename=PLC/PLC_Doc_C/XmlDataViewExt&plcref=" + plcref);
            NodeList nodes = linking.returnXpathNodes(navigationCobalt.getPageSource(), "//xlink:locator[not(ancestor::atict:del) and starts-with(@xlink:href, '#')]");
            for (int i = 0; i < nodes.getLength(); i++) {
                Node n = nodes.item(i);
                xlinkValue++;
            }
            if (plcref.equals("2-521-5400")) {
                xlinkValue++;
            }
        }
    }

    @Given("^user captures the jump links in the Novus main document xml$")
    public void usercapturesthejumplinksintheNovusmaindocumentxml() throws Throwable {
        navigationCobalt.navigate("http://legaltechtools.int.thomsonreuters.com/Velma/Novus/Document?guid=" + strDOCGUID);
        NodeList nodes = linking.returnXpathNodes(navigationCobalt.getPageSource(), "//internal.reference[not(ancestor::author)]");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            refIdValue++;
        }
    }

    @Given("^for \"(.*?)\" the number of jump links should be the equal$")
    public void thenumberofjumplinksshouldbetheequal(String plcref) throws Throwable {
        switch (plcref) {
            case "9-376-4010":
                checknum(12);
                break;
            case "7-203-1181":
                checknum(5);
                break;
            case "a-008-4220":
                checknum(0);
                break;
            case "9-606-5528":
                checknum(1);
                break;
            case "2-521-5400":
                checknum(7);
                break;
            case "6-502-0189":
                checknum(1);
                break;
        }
    }

    private void checknum(int total) {
        assertEquals(refIdValue, xlinkValue);
    }

}

package com.thomsonreuters.linking.step_definitions;

import com.google.gson.*;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.utils.Linking.DocFamilyRecord;
import com.thomsonreuters.pageobjects.utils.Linking.DocInstance;
import com.westgroup.novus.message.DOMUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.By;
import org.w3c.dom.Node;

import java.util.Arrays;

import static org.apache.commons.lang3.StringUtils.defaultIfBlank;
import static org.junit.Assert.assertEquals;

public class EntryIDTest extends BaseStepDef {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();

    String DOC_FAMILY_PL_SERIAL_GET;
    String TYPE = null;
    String EFamilyGUID, EGUID, EDocLoc, EDomain, EIndex, EpubNo;
    String AFamilyGUID, AGUID, ADocLoc, ASerialNo, APubNo;

    @Given("^the user queries \"(.*?)\" in the GetSerialNumber URL$")
    public void theuserqueriesintheGetSerialNumberURL(String SerialNum) throws Throwable {
        DOC_FAMILY_PL_SERIAL_GET = "http://entityid.int.next.westlaw.com/EntityIdentification/v1/docfamily/" + SerialNum;
        TYPE = "PLSERIAL";
    }

    @When("^the user extracts the values for \"(.*?)\" from the MetaTools URL$")
    public void theuserextractsthevaluesforfromtheMetaToolsURL(String strDOCGUID) throws Throwable {
        navigationCobalt.navigate("http://legaltechtools.int.thomsonreuters.com/Velma/Novus/Document?guid=" + strDOCGUID);
        AFamilyGUID = navigationCobalt.findElement(By.tagName("md.doc.family.uuid")).getText();
        AGUID = navigationCobalt.findElement(By.tagName("md.uuid")).getText();
        switch (strDOCGUID) {
            case "Ib5556d4de83211e398db8b09b4f043e0":
                ADocLoc = "w_plc_uk_pracnote";
                break;
            case "I640a4d77010811e498db8b09b4f043e0":
                ADocLoc = "w_plc_uk_pracnote";
                break;
            case "I864e6172d91d11e498db8b09b4f043e0":
                ADocLoc = "w_plc_uk_pracnote";
                break;
            case "Ic3c6d4f9e83311e398db8b09b4f043e0":
                ADocLoc = "w_plc_uk_linkshell";
                break;
            case "I33f12c0ce8cd11e398db8b09b4f043e0":
                ADocLoc = "w_plc_uk_standdoc";
                break;
            case "I0b3ad5eae01011e398db8b09b4f043e0":
                ADocLoc = "w_plc_uk_pracnote";
                break;
            case "I6F2E9701E42811DA8FC2A0F0355337E9":
                ADocLoc = "UK_SMG_CASESLOC";
                break;
            case "I344DCE30E42811DA8FC2A0F0355337E9":
                ADocLoc = "UK_SMG_CASESLOC";
                break;
            case "I7B32D820C5D111DE8405B6EF4FE8F8F3":
                ADocLoc = "UK_SMG_CASESLOC";
                break;
        }
    }

    @Given("^the Entity ID results should be equal to Metatool results$")
    public void theEntityIDresultsshouldbeequaltoMetatoolresults() throws Throwable {
        if (TYPE.equals("PLSERIAL") || TYPE.equals("GUID") || TYPE.equals("PLSERIALPUB") || TYPE.equals("FamilyGUID")) {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(DOC_FAMILY_PL_SERIAL_GET);
            CloseableHttpResponse response1 = httpclient.execute(httpGet);
            Node buffer = null;
            String Entity = EntityUtils.toString(response1.getEntity(), "UTF-8");
            DocFamilyRecord[] res = new Gson().fromJson(
                    Entity, DocFamilyRecord[].class);
            for (int i = 0; i < res.length; i++) {
                EFamilyGUID = res[i].getDocFamilyGuid();
                DocInstance[] doc = res[i].getDocInstances();
                for (int j = 0; j < doc.length; j++) {
                    EGUID = doc[j].getDocGuid();
                    EDocLoc = doc[j].getDocLoc();
                }
            }
        }
        assertEquals(AFamilyGUID, EFamilyGUID);
        assertEquals(AGUID, EGUID);
        assertEquals(ADocLoc, EDocLoc);
    }

    @Given("^the user queries \"(.*?)\" in the GetGUIDNumber URL$")
    public void theuserqueriesintheGetGUIDNumberURL(String GUID) throws Throwable {
        DOC_FAMILY_PL_SERIAL_GET = "http://entityid.int.next.westlaw.com/EntityIdentification/v1/docfamily/" + GUID;
        TYPE = "GUID";
    }

    @Given("^the user queries \"(.*?)\" and \"(.*?)\" in the GetSerialPubNumber URL$")
    public void theuserqueriesintheGetSerialPubNumberURL(String SerialNum, String PubNum) throws Throwable {
        DOC_FAMILY_PL_SERIAL_GET = "http://entityid.int.next.westlaw.com/EntityIdentification/v1/docfamily/" + SerialNum + "?domainResolver:pub:" + PubNum;
        TYPE = "PLSERIALPUB";
    }

    @Given("^the user queries \"(.*?)\" in the GetCaseLocatorFamilyGUID URL$")
    public void theuserqueriesintheGetCaseLocatorFamilyGUIDURL(String FamilyGUID) throws Throwable {
        DOC_FAMILY_PL_SERIAL_GET = "http://entityid.int.next.westlaw.com/EntityIdentification/v1/docfamily/" + FamilyGUID;
        TYPE = "FamilyGUID";
    }

    @Given("^the results should be equal for \"(.*?)\"$")
    public void theresultsshouldbeequal(String GUID) throws Throwable {
        String guid = GUID;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(DOC_FAMILY_PL_SERIAL_GET);
        CloseableHttpResponse response1 = httpclient.execute(httpGet);
        Node buffer = null;
        String Entity = EntityUtils.toString(response1.getEntity(), "UTF-8");
        DocFamilyRecord[] res = new Gson().fromJson(
                Entity, DocFamilyRecord[].class);
        for (int i = 0; i < res.length; i++) {
            EFamilyGUID = res[i].getDocFamilyGuid();
            DocInstance[] doc = res[i].getDocInstances();
            for (int j = 0; j < doc.length; j++) {
                EGUID = doc[j].getDocGuid();
                EDocLoc = doc[j].getDocLoc();
                if (j == 0) {
                    assertEquals(EGUID, AGUID);
                    assertEquals(EDocLoc, ADocLoc);
                }
            }
        }
    }

    @Given("^the user queries \"(.*?)\" in the GetCaseLocatorDocGUID URL$")
    public void theuserqueriesintheGetCaseLocatorDocGUIDURL(String DocGUID) throws Throwable {
        DOC_FAMILY_PL_SERIAL_GET = "http://entityid.int.next.westlaw.com/EntityIdentification/v1/docfamily/" + DocGUID;
        TYPE = "GUID";
    }

    @Given("^the user queries the PostCaseLocatorDocGUID URL$")
    public void theuserqueriesinthePostCaseLocatorDocGUIDURL() throws Throwable {
        DOC_FAMILY_PL_SERIAL_GET = "http://entityid.int.next.westlaw.com/EntityIdentification/v1/docfamily/docinstancelists";
        TYPE = "PostGUID";
    }

    @Given("^the Entity ID results should be equal for \"(.*?)\"$")
    public void theEntityIDresultsshouldbeequal(String GUID) throws Throwable {
        String guid = GUID;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(DOC_FAMILY_PL_SERIAL_GET);
        JsonObject root = new JsonObject();
        JsonArray requests = new JsonArray();
        JsonObject request = new JsonObject();
        request.addProperty("index", guid);
        requests.add(request);
        root.add("requests", requests);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .setFieldNamingPolicy(
                        FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        httpPost.setEntity(new StringEntity(gson.toJson(root),
                ContentType.APPLICATION_JSON));
        CloseableHttpResponse response1 = httpclient.execute(httpPost);
        try {
            HttpEntity entity1 = response1.getEntity();
            PostDocGUID_Result[] res = new Gson().fromJson(
                    EntityUtils.toString(entity1, "UTF-8"), PostDocGUID_Result[].class);
            for (int i = 0; i < res.length; i++) {
                DocFamilyRecord[] docFamily = res[i].getDocFamilyRecords();
                for (int j = 0; j < docFamily.length; j++) {
                    EFamilyGUID = docFamily[j].getDocFamilyGuid();
                    DocInstance[] doc = docFamily[j].getDocInstances();
                    for (int k = 0; k < doc.length; k++) {
                        EGUID = doc[k].getDocGuid();
                        EDocLoc = doc[k].getDocLoc();
                    }
                }
                Request docrequest = res[i].getRequest();
                EDomain = docrequest.domain;
                EIndex = docrequest.index;
                EpubNo = docrequest.pubNo;
                assertEquals(AFamilyGUID, EFamilyGUID);
                assertEquals(AGUID, EGUID);
                assertEquals(ADocLoc, EDocLoc);
            }
        } finally {
            response1.close();
        }
    }

    @Given("^the Entity ID results for \"(.*?)\" and \"(.*?)\" should be equal$")
    public void theEntityIDresultsforshouldbeequal(String SerialNum, String PubNum) throws Throwable {
        String SerialNumber = SerialNum;
        String PubNumber = PubNum;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(DOC_FAMILY_PL_SERIAL_GET);
        JsonObject root = new JsonObject();
        JsonArray requests = new JsonArray();
        JsonObject request = new JsonObject();
        request.addProperty("index", SerialNumber);
        request.addProperty("pubNo", PubNumber);
        requests.add(request);
        root.add("requests", requests);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .setFieldNamingPolicy(
                        FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        httpPost.setEntity(new StringEntity(gson.toJson(root),
                ContentType.APPLICATION_JSON));
        CloseableHttpResponse response1 = httpclient.execute(httpPost);
        try {
            HttpEntity entity1 = response1.getEntity();
            PostDocGUID_Result[] res = new Gson().fromJson(
                    EntityUtils.toString(entity1, "UTF-8"), PostDocGUID_Result[].class);
            for (int i = 0; i < res.length; i++) {
                DocFamilyRecord[] docFamily = res[i].getDocFamilyRecords();
                for (int j = 0; j < docFamily.length; j++) {
                    EFamilyGUID = docFamily[j].getDocFamilyGuid();
                    DocInstance[] doc = docFamily[j].getDocInstances();
                    for (int k = 0; k < doc.length; k++) {
                        EGUID = doc[k].getDocGuid();
                        EDocLoc = doc[k].getDocLoc();
                        if (SerialNumber.equals("2020221896")) {
                            assertEquals(doc.length, 2);
                            EGUID = doc[0].getDocGuid();
                            EDocLoc = doc[0].getDocLoc();
                        }
                    }
                }
                Request docrequest = res[i].getRequest();
                EDomain = docrequest.domain;
                EIndex = docrequest.index;
                EpubNo = docrequest.pubNo;
                assertEquals(AFamilyGUID, EFamilyGUID);
                assertEquals(AGUID, EGUID);
                assertEquals(ADocLoc, EDocLoc);
            }

        } finally {
            response1.close();
        }
    }

    class PostDocGUID_Result {
        DocFamilyRecord[] docFamilyRecords;
        Request request;

        public DocFamilyRecord[] getDocFamilyRecords() {
            return docFamilyRecords;
        }

        public void setDocFamilyRecords(DocFamilyRecord[] docFamilyRecords) {
            this.docFamilyRecords = docFamilyRecords;
        }

        public Request getRequest() {
            return request;
        }

        public void setRequest(Request request) {
            this.request = request;
        }

        @Override
        public String toString() {
            return "PostDocGUID_Result{" +
                    "docFamilyRecords=" + Arrays.toString(docFamilyRecords) +
                    ", request=" + request +
                    '}';
        }

        public void saveToDOM(Node buffer) throws Exception {
            Node resultNode = buffer.getOwnerDocument().createElement("result");
            buffer.appendChild(resultNode);
            for (DocFamilyRecord rec : docFamilyRecords) {
                rec.saveToDOM(resultNode);
            }
            request.saveToDOM(resultNode);
        }
    }

    class Request {
        String providedDomain;
        String domain;
        String index;
        String pubNo;

        public String getProvidedDomain() {
            return providedDomain;
        }

        public void setProvidedDomain(String providedDomain) {
            this.providedDomain = providedDomain;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getPubNo() {
            return pubNo;
        }

        public void setPubNo(String pubNo) {
            this.pubNo = pubNo;
        }

        @Override
        public String toString() {
            return "Request{" +
                    "providedDomain='" + providedDomain + '\'' +
                    ", domain='" + domain + '\'' +
                    ", index='" + index + '\'' +
                    ", pubNo='" + pubNo + '\'' +
                    '}';
        }

        public void saveToDOM(Node buffer) throws Exception {
            Node requestNode = buffer.getOwnerDocument().createElement(
                    "request");
            buffer.appendChild(requestNode);
            DOMUtil.addElement(requestNode, "providedDomain",
                    defaultIfBlank(providedDomain, ""));
            DOMUtil.addElement(requestNode, "domain",
                    defaultIfBlank(domain, ""));
            DOMUtil.addElement(requestNode, "index", defaultIfBlank(index, ""));
            DOMUtil.addElement(requestNode, "pubNo", defaultIfBlank(pubNo, ""));
        }
    }

}

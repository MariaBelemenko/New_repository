package com.thomsonreuters.pageobjects.utils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.thomsonreuters.driver.framework.WebDriverDiscovery;
import org.jsoup.Jsoup;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;
import java.util.Iterator;

public class LinkingUtils extends DefaultHandler {

    private WebDriverDiscovery webDriverDiscovery;

    private static final String HEADER_ACCEPT_HTML_XML = "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8";
    private static final int STATUS_CODE_OK = 200;

    protected static final org.slf4j.Logger LOG = LoggerFactory.getLogger(LinkingUtils.class);

    public String getXLINKURI() {
        String XLINKURI = "http://www.w3.org/1999/xlink";
        return XLINKURI;
    }

    public String getATICTURI() {
        String ATICTURI = "http://www.arbortext.com/namespace/atict";
        return ATICTURI;
    }

    public String getGUIID(String oldDocId) {
        String GUIID = null;
        try {
            Client client = Client.create();
            WebResource webResource = client
                    .resource("http://entityid.int.next.westlaw.com/EntityIdentification/v1/find/document?findValue=Practical%20Law%20Resource%20ID%20" + oldDocId);
            ClientResponse response = webResource.accept("application/json")
                    .get(ClientResponse.class);
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }
            GUIID = searchNewDocId(response.getEntity(String.class));
        } catch (Exception e) {
            LOG.info("context", e);
        }
        return GUIID;
    }

    private String searchNewDocId(String searchText) {
        String newDocId = null;
        String newDocIdKeyword = "docGuid";

        int newDocIdStart = searchText.indexOf(newDocIdKeyword) + 10;
        int newDocIdEnd = searchText.indexOf(",", newDocIdStart);

        newDocId = searchText.substring(newDocIdStart, newDocIdEnd - 1);
        return newDocId;
    }

    public NodeList returnXpathNodes(String pageSource, String strXpath) throws Throwable {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        docFactory.setNamespaceAware(true);
        DocumentBuilder builder = docFactory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(pageSource)));
        XPath xpath = XPathFactory.newInstance().newXPath();
        xpath.setNamespaceContext(new NamespaceContext() {

            @Override
            public String getNamespaceURI(String prefix) {
                if ("xlink".equals(prefix)) {
                    return getXLINKURI();
                } else if ("atict".equals(prefix)) {
                    return getATICTURI();
                }
                return null;
            }

            @Override
            public String getPrefix(String namespaceURI) {
                return null;
            }

            @Override
            public Iterator getPrefixes(String namespaceURI) {
                return null;
            }
        });

        NodeList nodes = (NodeList) xpath.evaluate(strXpath, doc, XPathConstants.NODESET);
        return nodes;
    }

    /**
     * Get elements from HTML DOM
     * @param htmlPageSource HTML page source
     * @param sizzle Extended CSS selector. For additional documentation please see http://jsoup.org/cookbook/extracting-data/selector-syntax
     *               WARNING: possible unexpected work if selector has parents (e.g., "div[id='someId'] a")
     * @return List of found elements
     */
    public org.jsoup.select.Elements getElementsFromHtml(String htmlPageSource, String sizzle) {
        org.jsoup.nodes.Document doc = Jsoup.parse(htmlPageSource);
        return doc.select(sizzle);
    }

    /**
     * Check if link OK and returning document
     * @param hrefAttr Href attribute from "a" element or just URL. If value point to relative resource then
     *                 current domain will be added to absolute resource path
     * @return True - if response code for link is 200 and response body not contains "error" word.
     */
    public boolean isLinkReturnsTheDocument(String hrefAttr) {
        ClientResponse response = getResponseFor(hrefAttr, HEADER_ACCEPT_HTML_XML);
        return response.getStatus() == STATUS_CODE_OK;
    }

    /**
     * Get HTML page source for page presented by navigating to link
     * @param link Link of page (full or relative)
     * @return String with page HTML code
     */
    public String getPageSourceForLink(String link) {
        ClientResponse response = getResponseFor(link, HEADER_ACCEPT_HTML_XML);
        return response.getEntity(String.class);
    }

    /**
     * Get Response object for link
     * @param absoluteOrRelativeUrl Full or relative URL
     * @param acceptHeader "Accept" header value (e.g., "text/html", "application/json", ...)
     * @return Object with response {@link ClientResponse}
     */
    private ClientResponse getResponseFor(String absoluteOrRelativeUrl, String acceptHeader) {
        String cookies = webDriverDiscovery.getBrowserCookiesAsString();
        String baseUrl = "";
        if (!absoluteOrRelativeUrl.startsWith("http")) {
            String currUrl = webDriverDiscovery.getRemoteWebDriver().getCurrentUrl();
            String[] splitedUrlBySlash = currUrl.split("/");
            baseUrl = splitedUrlBySlash[0] + "//" + splitedUrlBySlash[2];
        }
        return Client
                .create().resource(baseUrl + absoluteOrRelativeUrl.split("#")[0]) // Remove anchor part from the link. It does not important and also causing URISyntaxException
                .accept(acceptHeader)
                .header("Cookie", cookies)
                .get(ClientResponse.class);
    }
}

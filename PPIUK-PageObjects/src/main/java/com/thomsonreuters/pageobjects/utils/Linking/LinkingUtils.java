package com.thomsonreuters.pageobjects.utils.Linking;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.thomsonreuters.pageobjects.otherPages.NavigationCobalt;
import com.thomsonreuters.pageobjects.utils.document.content.Section;
import com.thomsonreuters.pageobjects.utils.document.metadata.Jurisdiction;
import com.thomsonreuters.pageobjects.utils.document.metadata.Product;
import org.jsoup.Jsoup;
import org.openqa.selenium.Cookie;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
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
import java.util.*;


public class LinkingUtils extends DefaultHandler {

    private NavigationCobalt navigationCobalt = new NavigationCobalt();

    private static final String HEADER_ACCEPT_HTML_XML = "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8";
    private static final int STATUS_CODE_OK = 200;
    private static final String FATWIRE_TOOL = "http://us.p02edi.practicallaw.com/cs/Satellite/?pagename=XMLWrapper&childpagename=PLC/PLC_Doc_C/XmlDataViewExt&plcref=";

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

    /**
     * Get document object with it metadata and document sections only.
     *
     * @param plcRef Document PLC Reference
     * @return {@link com.thomsonreuters.pageobjects.utils.document.Document} object with resourceType, products,
     * jurisdictions and document scetions
     * Other object fields will be null.
     */
    public com.thomsonreuters.pageobjects.utils.document.Document getDocumentMetaDataAndSectionsFromFatWire(String plcRef) {
        ClientResponse response = getResponseFor(FATWIRE_TOOL + plcRef, HEADER_ACCEPT_HTML_XML);
        String responseXmlBody = response.getEntity(String.class);
        com.thomsonreuters.pageobjects.utils.document.Document docMetadata = new com.thomsonreuters.pageobjects.utils.document.Document();
        List<Product> products = new ArrayList<>();
        List<Jurisdiction> jurisdictions = new ArrayList<>();
        List<Section> sections = new ArrayList<>();
        try {
            NodeList productsNodeList = returnXpathNodes(responseXmlBody, "//resource/products/product");
            NodeList jurisdictionsNodeList = returnXpathNodes(responseXmlBody, "//jurisdiction");
            NodeList resourceTypeNodeList = returnXpathNodes(responseXmlBody, "//resourceType/name");
            NodeList sectionsNodeList = returnXpathNodes(responseXmlBody,
                    "//fulltext//*[contains(local-name(), 'section') and ./title and not(ancestor::*[contains(local-name(),'del')])]");
            products.addAll(getMetaDataProductFromNodeList(productsNodeList));
            jurisdictions.addAll(getMetaDataJurisdictionsFromNodeList(jurisdictionsNodeList));
            sections.addAll(getDocumentSectionsFromNodeList(sectionsNodeList));
            docMetadata.setProducts(products);
            docMetadata.setJurisdictions(jurisdictions);
            docMetadata.setResourceType(resourceTypeNodeList.item(0).getTextContent());
            docMetadata.setSections(sections);
        } catch (Exception e) {
            LOG.info("XML processing error", e);
        }
        return docMetadata;
    }

    public NodeList returnXpathNodes(String pageSource, String strXpath) throws Exception {
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
     *
     * @param htmlPageSource HTML page source
     * @param sizzle         Extended CSS selector. For additional documentation please see http://jsoup.org/cookbook/extracting-data/selector-syntax
     *                       WARNING: possible unexpected work if selector has parents (e.g., "div[id='someId'] a")
     * @return List of found elements
     */
    public org.jsoup.select.Elements getElementsFromHtml(String htmlPageSource, String sizzle) {
        org.jsoup.nodes.Document doc = Jsoup.parse(htmlPageSource);
        return doc.select(sizzle);
    }

    /**
     * Check if link OK and returning document
     *
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
     *
     * @param link Link of page (full or relative)
     * @return String with page HTML code
     */
    public String getPageSourceForLink(String link) {
        ClientResponse response = getResponseFor(link, HEADER_ACCEPT_HTML_XML);
        return response.getEntity(String.class);
    }

    /**
     * Get Response object for link
     *
     * @param absoluteOrRelativeUrl Full or relative URL
     * @param acceptHeader          "Accept" header value (e.g., "text/html", "application/json", ...)
     * @return Object with response {@link com.sun.jersey.api.client.ClientResponse}
     */
    private ClientResponse getResponseFor(String absoluteOrRelativeUrl, String acceptHeader) {
        String cookies = getBrowserCookiesAsString();
        String baseUrl = "";
        if (!absoluteOrRelativeUrl.startsWith("http")) {
            String currUrl = navigationCobalt.getCurrentUrl();
            String[] splitedUrlBySlash = currUrl.split("/");
            baseUrl = splitedUrlBySlash[0] + "//" + splitedUrlBySlash[2];
        }
        return Client
                .create().resource(baseUrl + absoluteOrRelativeUrl.split("#")[0]) // Remove anchor part from the link. It does not important and also causing URISyntaxException
                .accept(acceptHeader)
                .header("Cookie", cookies)
                .get(ClientResponse.class);
    }

    public String getBrowserCookiesAsString() {
        return getBrowserCookiesAsString(null);
    }

    public String getBrowserCookiesAsString(Set<Cookie> ignoredCookies) {
        Set<Cookie> cookies = removeCookiesFrom(navigationCobalt.getCookies(), ignoredCookies);
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int cookiesCount = cookies.size();
        for (Cookie cookie : cookies) {
            sb.append(cookie.getName()).append("=").append(cookie.getValue());
            if (i < cookiesCount) {
                sb.append("; ");
            }
            i++;
        }
        return sb.toString();
    }

    private Set<Cookie> removeCookiesFrom(Set<Cookie> sourceCookies, Set<Cookie> cookiesToRemove) {
        if (cookiesToRemove == null) {
            return sourceCookies;
        }
        Set<Cookie> resultCookiesList = new HashSet();
        boolean isFound = false;
        for (Cookie sourceCookie : sourceCookies) {
            for (Cookie cookieToRemove : cookiesToRemove) {
                if ((sourceCookie.getName().endsWith(cookieToRemove.getName())) || (sourceCookie.getName().startsWith(cookieToRemove.getName()))) {
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                resultCookiesList.add(sourceCookie);
            }
        }
        return resultCookiesList;
    }

    /**
     * Get products list from Fatwire XML document for meta data
     *
     * @param productsNodeList Nodes with products
     * @return List with products {@link Product}
     */
    private List<Product> getMetaDataProductFromNodeList(NodeList productsNodeList) {
        List<Product> products = new ArrayList<>();
        int itemsCount = productsNodeList.getLength();
        for (int i = 0; i < itemsCount; i++) {
            Node productNode = productsNodeList.item(i);
            NodeList namePlcRefNodes = productNode.getChildNodes();
            Product product = new Product();
            // First child is "name"
            product.setName(namePlcRefNodes.item(0).getTextContent().trim());
            // Second child is "plc reference"
            product.setPlcReference(namePlcRefNodes.item(1).getTextContent());
            products.add(product);
        }
        return products;
    }

    /**
     * Get jurisdictions list from Fatwire XML document for meta data
     *
     * @param jurisdictionsNodeList Nodes with jurisdictions
     * @return List with jurisdictions {@link Jurisdiction}
     */
    private List<Jurisdiction> getMetaDataJurisdictionsFromNodeList(NodeList jurisdictionsNodeList) {
        List<Jurisdiction> jurisdictions = new ArrayList<>();
        int itemsCount = jurisdictionsNodeList.getLength();
        for (int i = 0; i < itemsCount; i++) {
            Node jurisdictionNode = jurisdictionsNodeList.item(i);
            NodeList namePlcRefNodes = jurisdictionNode.getChildNodes();
            String name = namePlcRefNodes.item(0).getTextContent();
            // Any UK jurisdiction is ignored in the metadata block
            if (name.equals("Any UK jurisdiction")) {
                continue;
            }
            Jurisdiction jurisdiction = new Jurisdiction();
            // First child is "name"
            jurisdiction.setName(namePlcRefNodes.item(0).getTextContent().trim());
            // Second child is "plc reference"
            jurisdiction.setPlcReference(namePlcRefNodes.item(1).getTextContent());
            jurisdictions.add(jurisdiction);
        }
        return jurisdictions;
    }

    /**
     * Get list of sections from Fatwire XML document
     *
     * @param sectionsNodeList Nodes with sections
     * @return List with jurisdictions {@link Section}
     */
    private List<Section> getDocumentSectionsFromNodeList(NodeList sectionsNodeList) {
        List<Section> sections = new ArrayList<>();
        int itemsCount = sectionsNodeList.getLength();
        for (int i = 0; i < itemsCount; i++) {
            Node sectionNode = sectionsNodeList.item(i);
            NodeList sectionChildNodes = sectionNode.getChildNodes();
            Section section = new Section();
            // First child is "title"
            section.setTitle(sectionChildNodes.item(0).getTextContent().trim());
            sections.add(section);
        }
        return sections;
    }

}

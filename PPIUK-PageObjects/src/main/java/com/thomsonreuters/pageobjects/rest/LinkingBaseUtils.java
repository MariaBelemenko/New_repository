package com.thomsonreuters.pageobjects.rest;

import com.thomsonreuters.pageobjects.rest.service.impl.RestServiceLinkingImpl;
import com.thomsonreuters.pageobjects.utils.document.content.Section;
import com.thomsonreuters.pageobjects.utils.document.metadata.Jurisdiction;
import com.thomsonreuters.pageobjects.utils.document.metadata.Product;
import org.jsoup.Jsoup;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Pavel_Ardenka on 13/04/2016.
 */
public class LinkingBaseUtils {

    private RestServiceLinkingImpl restServiceLinking = new RestServiceLinkingImpl();
    protected static final org.slf4j.Logger LOG = LoggerFactory.getLogger(LinkingBaseUtils.class);

    public String getXLINKURI() {
        return "http://www.w3.org/1999/xlink";
    }

    public String getATICTURI() {
        return "http://www.arbortext.com/namespace/atict";
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

    public String getGuid(String plcRef) {
        return restServiceLinking.getGuid(plcRef);
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
        String responseXmlBody = restServiceLinking.getXmlDocumentFromFatwire(plcRef);
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

    public boolean isLinkReturnsTheDocument(String hrefAttr) {
        return restServiceLinking.isLinkReturnsTheDocument(hrefAttr);
    }

    public String getPageSourceForLink(String link) {
        return restServiceLinking.getPageSourceForLink(link);
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

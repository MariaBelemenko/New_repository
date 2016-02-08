package com.thomsonreuters.pageobjects.utils.adestra;

import org.slf4j.Logger;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.annotation.PostConstruct;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;


public class AdestraSubscriptionXMLParser extends DefaultHandler {

	private SubscriptionParameters subscriptionParameters;

	private LinkedList<SubscriptionParameters> subscriptionParametersList;
	
	protected static final Logger LOG = org.slf4j.LoggerFactory.getLogger(AdestraSubscriptionXMLParser.class);
	
	private StringBuilder thisElement;
	private String name = "";
	private String commonName = "";
	private String frequency = "";
	private String description = "";
	private String category = "";
	private static final File baseUserDir = new File(System.getProperty("user.dir"));
	private static final File subscriptionXMLFile = new File(baseUserDir + "/src/test/resources/email-subscription.xml");

	@PostConstruct
	public void parse() {
		subscriptionParametersList = new LinkedList<SubscriptionParameters>();
		SAXParserFactory spfac = SAXParserFactory.newInstance();
		SAXParser sp;
		try {
			sp = spfac.newSAXParser();
			sp.parse(subscriptionXMLFile, this);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void startDocument() throws SAXException {
		LOG.info("Start parse XML document ...");
	}

	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
		thisElement = new StringBuilder();

		if (qName.equals("category")) {

			category = atts.getValue("name");

		}
		if (qName.equals("product")) {
			subscriptionParameters = new SubscriptionParameters();
			frequency = atts.getValue("freq");
		}
	}

	@Override
	public void endDocument() throws SAXException {
		LOG.info("Stop parse XML document...");

	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("product")) {
			subscriptionParameters.setCategoryName(category);
			subscriptionParameters.setCommonName(commonName);
			subscriptionParameters.setProductFrequency(frequency);
			subscriptionParameters.setName(name);
			subscriptionParameters.setDescription(description);
			subscriptionParametersList.add(subscriptionParameters);
		} else {
			String elementVal = thisElement.toString();
			if (qName.equals("pageobjects-name")) {
				commonName = elementVal;
			}

			if (qName.equals("name")) {
				name = elementVal;

			}

			if (qName.equals("description")) {
				description = elementVal;

			}

		}

		thisElement = new StringBuilder();

	}

	public LinkedList<SubscriptionParameters> getResult() {
		return subscriptionParametersList;
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		thisElement.append(ch, start, length);
	}
}

package com.thomsonreuters.pageobjects.utils.pdf;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdfparser.PDFStreamParser;
import org.apache.pdfbox.pdfwriter.ContentStreamWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.interactive.action.type.PDAction;
import org.apache.pdfbox.pdmodel.interactive.action.type.PDActionURI;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDChoiceField;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.pdfbox.util.PDFTextStripperByArea;



import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PDFBoxUtil {


	private Parser stripper;

	public PDDocument readDocument(String urlToPdf) {
		PDDocument document;
		try {
			document = PDDocument.loadNonSeq(new File(urlToPdf), null);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		return document;
	}

	@SuppressWarnings("unchecked")
	private PDPage getFirstPage(PDDocument document) {
		List<Object> pages = document.getDocumentCatalog().getAllPages();
		return (PDPage) pages.get(0);
	}

	private PDFStreamParser parsePage(PDPage page) {
		PDFStreamParser parser;
		try {
			parser = new PDFStreamParser(page.getContents().getStream());
			parser.parse();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		return parser;
	}

	public void editName(PDDocument document, String newName) {
		PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();
		try {
			PDField nameField = (PDField) acroForm.getFields().get(0);
			nameField.setValue(newName);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public void editOccupation(PDDocument document, String newOccupation) {
		PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();
		try {
			PDField occupationField = (PDField) acroForm.getFields().get(7);
			occupationField.setValue(newOccupation);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public void editBirthDate(PDDocument document, String newBirthDate, String newBirthMonth, String newBirthYear) {
		PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();
		try {
			PDChoiceField dateOfBirthDate = (PDChoiceField) acroForm.getFields().get(1);
			dateOfBirthDate.setValue(newBirthDate);

			PDChoiceField dateOfBirthMonth = (PDChoiceField) acroForm.getFields().get(2);
			dateOfBirthMonth.setValue(newBirthMonth);

			PDChoiceField dateOfBirthYear = (PDChoiceField) acroForm.getFields().get(3);
			dateOfBirthYear.setValue(newBirthYear);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public void save(PDDocument document, String urlToPdf) {
		PDStream updatedStream = new PDStream(document);
		PDPage page = getFirstPage(document);
		PDFStreamParser parser = parsePage(page);
		try {
			OutputStream out = updatedStream.createOutputStream();
			ContentStreamWriter tokenWriter = new ContentStreamWriter(out);
			tokenWriter.writeTokens(parser.getTokens());
		} catch (IOException e1) {
			throw new RuntimeException(e1.getMessage());
		}
		page.setContents(updatedStream);
		document.setAllSecurityToBeRemoved(true);
		try {
			document.save(urlToPdf);
			if (document != null) {
				document.close();
			}
		} catch (COSVisitorException | IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	private Map<String, PDAction> extractLinks(PDDocument document) throws Exception {
		Map<String, PDAction> links = new HashMap<String, PDAction>();
		for (PDPage page : (List<PDPage>) document.getDocumentCatalog().getAllPages()) {
			links.putAll(extractLinks(page));
		}
		return links;
	}

	private Map<String, PDAction> extractLinks(PDPage page) throws Exception {
		Map<String, PDAction> links = new HashMap<String, PDAction>();
		PDFTextStripperByArea stripper = new PDFTextStripperByArea();
		List<PDAnnotation> annotations = page.getAnnotations();
		// First setup the text extraction regions.
		for (int j = 0; j < annotations.size(); j++) {
			PDAnnotation annotation = annotations.get(j);
			if (annotation instanceof PDAnnotationLink) { // public class
															// PDAnnotationLink
															// extends
															// PDAnnotation
				PDAnnotationLink link = (PDAnnotationLink) annotation;
				PDRectangle rect = link.getRectangle();
				// Need to reposition link rectangle to match text space.
				float x = rect.getLowerLeftX();
				float y = rect.getUpperRightY();
				float width = rect.getWidth();
				float height = rect.getHeight();
				int rotation = page.findRotation();
				if (rotation == 0) {
					PDRectangle pageSize = page.findMediaBox();
					y = pageSize.getHeight() - y;
				} else if (rotation == 90) {
					// Do nothing.
				}
				Rectangle2D.Float awtRect = new Rectangle2D.Float(x, y, width, height);
				stripper.addRegion(String.valueOf(j), awtRect);
			}
		}
		stripper.extractRegions(page);
		for (int j = 0; j < annotations.size(); j++) {
			PDAnnotation annotation = annotations.get(j);
			if (annotation instanceof PDAnnotationLink) {
				PDAnnotationLink link = (PDAnnotationLink) annotation;
				String label = stripper.getTextForRegion(String.valueOf(j)).trim();
				stripper.getFonts();
				System.out.println("label: " + label);
				links.put(label, link.getAction());
			}
		}
		return links;
	}

	public Map<String, String> extractURLs(String path) throws Exception {
		Map<String, String> urls = new HashMap<String, String>();
		PDDocument document = null;
		try {
			document = PDDocument.load(path);
			for (Map.Entry<String, PDAction> entry : extractLinks(document).entrySet()) {
				if (entry.getValue() instanceof PDActionURI) { // public class
																// PDActionURI
																// extends
																// PDAction
					PDActionURI uri = (PDActionURI) entry.getValue();
					urls.put(entry.getKey(), uri.getURI());
				}
			}
		} finally {
			if (document != null) {
				document.close();
			}
		}
		return urls;
	}

	public String extractText(String path) throws IOException {
		PDDocument document = readDocument(path);
		PDFTextStripper pdfStripper = new PDFTextStripper();
		String parsedText = pdfStripper.getText(document);
		return parsedText;
	}

	public String extractFirstPageText(String path) throws IOException {
		PDDocument document = readDocument(path);
		PDFTextStripper pdfStripper = new PDFTextStripper();
		pdfStripper.setStartPage(1);
		pdfStripper.setEndPage(1);
		String parsedText = pdfStripper.getText(document);
		return parsedText;
	}

	public float getFontSizeFromPdf(String path, String text, int index) throws IOException {
		stripper.parse(path, text);
		return stripper.getFontSize(index);
	}

	public Color getFontColorFromPdf(String path, String text, int index) throws IOException {
		stripper.parse(path, text);
		return stripper.getFontColor(index);
	}

	public String[] getFontLineByLineFromPdf(String path) throws IOException {
		PDDocument doc = PDDocument.load(path);
		Parser stripper = new Parser();
		String content = stripper.getText(doc);
		doc.close();
		String pdfLinesWithFont[] = content.split("\\r?\\n");
		return pdfLinesWithFont;
	}
}

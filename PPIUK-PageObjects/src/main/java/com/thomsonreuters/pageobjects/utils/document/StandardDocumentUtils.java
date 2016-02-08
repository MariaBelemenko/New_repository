package com.thomsonreuters.pageobjects.utils.document;

import com.thomsonreuters.pageobjects.utils.LinkingUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StandardDocumentUtils {

    private LinkingUtils linkingUtils;

    private static final Logger LOG = LoggerFactory.getLogger(StandardDocumentUtils.class);

    // Error message for Cucumber report
    private String paLinksCheckErrMsg = "";

    /**
     * Check if all links for document in section are valid
     * @param sectionElement WebElement link with section name
     * @param checkThreshold Links to validity check of.
     * @return True - if check passed. Otherwise - false.
     */
    public boolean isLinksAreValidInSection(WebElement sectionElement, int checkThreshold) {
        String hrefAttr = sectionElement.getAttribute("href");
        // Check if doc for section contains links. If not - we can't work with it anymore
        if (!linkingUtils.isLinkReturnsTheDocument(hrefAttr)) {
            paLinksCheckErrMsg = "No documents for section '" + sectionElement.getText().trim() + "', link '" + hrefAttr + "'";
            LOG.warn(paLinksCheckErrMsg);
            return false;
        }
        // Get document page source to check it links
        String documentPageSource = linkingUtils.getPageSourceForLink(hrefAttr);
        try {
            // Get all links from the document
            Elements links = linkingUtils.getElementsFromHtml(documentPageSource, ".co_link");
            int linksCount = links.size();
            // just counter for loops count
            int i = 0;
            // Check every link from document
            for (Element link : links) {
                if (!isDocumentLinksAreValid(sectionElement.getText().trim(), link)) {
                    return false;
                }
                // If threshold reached - break loop
                if (i >= checkThreshold) {
                    break;
                }
                i++;
            }
            paLinksCheckErrMsg = "Document for section '" + sectionElement.getText().trim() + "', link '" + hrefAttr + "' " +
                    "does not contains any links";
            // if there is no related links, for loop will be skipped and we can't return just true
            return linksCount > 0;
        } catch (Exception e) {
            paLinksCheckErrMsg = "Something went wrong: " + e.getMessage();
            LOG.warn(paLinksCheckErrMsg, e);
            return false;
        }
    }

    /**
     * Get error message for cucumber report if any link in document is invalid (use this in step definition class)
     * @return Error message, if any method of this utils gets error. Otherwise - empty string.
     */
    public String getPracticeAreaLinksErrMsg() {
        return paLinksCheckErrMsg;
    }

    public void setPracticeAreaLinksErrMsg(String paLinksCheckErrMsg) {
        this.paLinksCheckErrMsg = paLinksCheckErrMsg;
    }

    /**
     * Check that link from document points to other correct document
     * @param sectionName Practice Area Section name which related with verifiable document (just for log / report message)
     * @param linkToCheck Element with one link of current document
     * @return True - if check passed. Otherwise - false.
     */
    private boolean isDocumentLinksAreValid(String sectionName, Element linkToCheck) {
        String hrefValue = linkToCheck.attr("href");
        LOG.debug("Checking link '" + linkToCheck.text() + "' and href '" + hrefValue + "', section '"
                + sectionName + "'");

        Elements header = linkingUtils.getElementsFromHtml(linkingUtils.getPageSourceForLink(hrefValue), ".co_title");

        // If document not returned (response status code != 200) or header is absent then wrong page is opened
        if (!linkingUtils.isLinkReturnsTheDocument(hrefValue) || header.isEmpty()) {
            paLinksCheckErrMsg = "Link '" + linkToCheck.text() + "' and href '" + hrefValue + "' is invalid, section '"
                    + sectionName + "'";
            LOG.warn(paLinksCheckErrMsg);
            return false;
        }
        return true;
    }
}

package com.thomsonreuters.pageobjects.rest;

import com.google.common.base.Function;
import com.thomsonreuters.driver.framework.AbstractPage;
import com.thomsonreuters.driver.framework.WebDriverDiscovery;
import com.thomsonreuters.pageobjects.common.CommonMethods;
import com.thomsonreuters.pageobjects.rest.model.request.delivery.initiateDelivery.InitiateDelivery;
import com.thomsonreuters.pageobjects.rest.model.response.delivery.initiateDelivery.InitiateDeliveryResponse;
import com.thomsonreuters.pageobjects.rest.model.response.delivery.status.StatusResponse;
import com.thomsonreuters.pageobjects.rest.service.impl.RestServiceDeliveryImpl;
import com.thomsonreuters.pageobjects.utils.pdf.PDFBoxUtil;
import com.thomsonreuters.pageobjects.utils.plPlusResearchDocDisplay.AssetPageUtils;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.BadLocationException;
import java.io.File;
import java.io.IOException;

public class DeliveryBaseUtils {

    private RestServiceDeliveryImpl deliveryService = new RestServiceDeliveryImpl();
    private WebDriverDiscovery webDriverDiscovery = new WebDriverDiscovery();
    private CommonMethods commonMethods = new CommonMethods();

    private static final Logger LOG = LoggerFactory.getLogger(DeliveryBaseUtils.class);
    private File downloadedDoc;

    /**
     * Download document via HTTP and check it not empty
     * WARNING: method should be called when document ready for download.
     *
     * @param docFormat   Document format {@link InitiateDelivery.DocFormat}
     * @param isPrintable Is delivery called for printable document?
     * @throws BadLocationException
     */
    public boolean isDocDownloadedAndChecked(InitiateDelivery.DocFormat docFormat, boolean isPrintable) throws BadLocationException {
        File downloadedDocument = downloadAndGetDocument(isPrintable);
        return isDocumentNotEmpty(downloadedDocument, docFormat);
    }

    /**
     * Check that downloaded document is not empty
     *
     * @param documentFile Downloaded document file
     * @param docFormat    Document format
     * @return True - if check passed. Otherwise - false.
     * @throws BadLocationException
     */
    public boolean isDocumentNotEmpty(File documentFile, InitiateDelivery.DocFormat docFormat) throws BadLocationException {
        try {
            switch (docFormat) {
                case Pdf:
                    return !new PDFBoxUtil().extractText(documentFile.getAbsolutePath()).trim().isEmpty();
                case Rtf:
                case Doc:
                    return !new AssetPageUtils().getTextFromFileWithRTForDOCextension(documentFile.getAbsolutePath()).isEmpty();
                default:
                    return false;
            }
        } catch (IOException e) {
            LOG.warn("Document downloading / parsing failed", e);
            return false;
        }
    }

    /**
     * Get transaction ID for delivery using Cobalt JS library
     * Call method when file ready to download ("Ready For Download" pop-up is showing)
     *
     * @return Transaction id which can be given to Status Response to check deliver status
     */
    public String getTransactionId() {
        Function<RemoteWebDriver, String> waitCondition = new Function<RemoteWebDriver, String>() {
            @Override
            public String apply(RemoteWebDriver driver) {
                String transactionId = (String) driver.executeScript("return Cobalt.Delivery.DeliveryOptionsDialog.Instance()._currentTransactionId;");
                return (transactionId != null && !transactionId.isEmpty()) ? transactionId : null;
            }
        };
        return AbstractPage.waitFor(waitCondition, webDriverDiscovery.getRemoteWebDriver());
    }

    /**
     * Download document and get downloaded doc as file.
     * WARNING: method should be called when document prepared in UI ("Ready For Download" dialog is displayed)
     *
     * @return File with downloaded document
     */
    public File downloadAndGetDocument(boolean isPrintable) {
        InitiateDeliveryResponse initiateDeliveryResponse = new InitiateDeliveryResponse();
        initiateDeliveryResponse.setTransactionId(getTransactionId());
        StatusResponse statusResponse = getStatusResponseForInitiateDeliveryResponse(initiateDeliveryResponse);
        File result = deliveryService.downloadDocumentAndGetFile(statusResponse, isPrintable);
        setDownloadedDoc(result);
        return result;
    }

    /**
     * Download document via "Open In Word" action
     *
     * @return File with downloaded document
     */
    public File downloadViaOpenInWordAndGetDocument() {
        String fileNameScript = "($('.co_title') !== null ? $('.co_title').text() : 'Quick Draft').replace(/\\W/g, '')";
        String fileUrl = (String) webDriverDiscovery.getRemoteWebDriver().executeScript(
                "return $('.kh_standardDocumentAttachment a').attr('href') + '&imageFileName=' + " + fileNameScript + ";");
        String fileName = (String) webDriverDiscovery.getRemoteWebDriver().executeScript(
                "return " + fileNameScript + ";");
        return deliveryService.getFileViaHttp(fileUrl, fileName);
    }

    /**
     * Check that give document contains and / or not contains expected phrases
     *
     * @param document           File with document (can be obtained by {@link RestServiceDeliveryImpl#downloadDocumentAndGetFile(StatusResponse, boolean)})
     * @param docFormat          Document format {@link InitiateDelivery.DocFormat}
     * @param phraseShouldExists Text, which should be exists in the document. There is can be few phrases joined with comma ",".
     * @param phraseShouldAbsent Text, which should not be exists in the document.
     *                           There is can be few phrases joined with comma ",".
     *                           OPTIONAL: if phrase absence check is not needed, than this argument should be passed
     *                           as empty string.
     * @return True - if document successfully downloaded and it contains some text, otherwise - false.
     * <p/>
     * WARNING: Exception can be thrown by {@link org.springframework.web.client.RestTemplate} if response will
     * not be successfull (when response code 4**, 5**)
     * @throws BadLocationException if document was not parsed successfully
     */
    public boolean isDocContainsOrNotContains(File document, InitiateDelivery.DocFormat docFormat,
                                              String phraseShouldExists, String phraseShouldAbsent) throws BadLocationException {
        String docFileName = document.getAbsolutePath();
        try {
            String docText;
            switch (docFormat) {
                case Pdf:
                    docText = new PDFBoxUtil().extractText(docFileName);
                    break;
                case Rtf:
                case Doc:
                    docText = new AssetPageUtils().getTextFromFileWithRTForDOCextension(docFileName);
                    break;
                default:
                    return false;
            }

            return commonMethods.isStringContains(docText, phraseShouldExists, ",") &&
                    (phraseShouldAbsent.isEmpty() || !commonMethods.isStringContains(docText, phraseShouldAbsent, ","));
        } catch (IOException e) {
            LOG.warn("Parsing failed", e);
            return false;
        }
    }

    public File getDownloadedDoc() {
        return downloadedDoc;
    }

    public void setDownloadedDoc(File downloadedDoc) {
        this.downloadedDoc = downloadedDoc;
    }

    private StatusResponse getStatusResponseForInitiateDeliveryResponse(final InitiateDeliveryResponse initiateDeliveryResponse) {
        if (initiateDeliveryResponse.getTransactionId() == null) {
            throw new IllegalArgumentException("Initiate Delivery Response does not contains transaction Id");
        }
        Function<RestServiceDeliveryImpl, StatusResponse> waitCondition = new Function<RestServiceDeliveryImpl, StatusResponse>() {
            @Override
            public StatusResponse apply(RestServiceDeliveryImpl service) {
                return (service.isDocumentReady(initiateDeliveryResponse)) ?
                        service.getDocumentStatus(initiateDeliveryResponse) : null;
            }
        };
        // Wait until document status will be "completed" and return StatusResponse result
        return AbstractPage.waitFor(waitCondition, deliveryService);
    }

}

package com.thomsonreuters.pageobjects.rest.service.impl;

import com.thomsonreuters.pageobjects.common.FileActions;
import com.thomsonreuters.pageobjects.rest.model.response.delivery.initiateDelivery.InitiateDeliveryResponse;
import com.thomsonreuters.pageobjects.rest.model.response.delivery.status.StatusResponse;
import com.thomsonreuters.pageobjects.rest.service.RestService;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class RestServiceDeliveryImpl extends RestServiceImpl implements RestService {

    private FileActions fileActions = new FileActions();

    /**
     * GET request to get document status response.
     * IMPORTANT: Call method when file ready to download ("Ready For Download" pop-up is showing)
     *
     * @param InitiateDeliveryResponse Response from initiate delivery request.
     *                                 Can be a new object, but transactionId should be set
     *                                 {@link InitiateDeliveryResponse#setTransactionId(String)}
     * @return StatusResponse ({@link StatusResponse}) with appropriate data.
     * WARNING: Exception can be thrown by {@link org.springframework.web.client.RestTemplate} if response will
     * not be successfull (when response code 4**, 5**)
     */
    public StatusResponse getDocumentStatus(InitiateDeliveryResponse InitiateDeliveryResponse) {
        LOG.info("-------------------BEGIN--------------------");
        HttpHeaders httpHeaders = configureHeaders();
        String requestTo = getProtocol() + getCurrentBaseUrl() + "/V1/Delivery/Status/" + InitiateDeliveryResponse.getTransactionId();
        LOG.info("TO: " + requestTo);
        LOG.info("HEADERS: " + httpHeaders);
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        LOG.info("REQ: " + requestEntity.toString());
        HttpEntity<StatusResponse> response = getRestTemplate().exchange(requestTo, HttpMethod.GET, requestEntity, StatusResponse.class);
        LOG.info("RESP: " + response.toString());
        LOG.info("-------------------END--------------------");
        return response.getBody();
    }

    /**
     * GET request to get document status response and check if document is ready to download
     * IMPORTANT: Call method when file ready to download ("Ready For Download" pop-up is showing)
     *
     * @param InitiateDeliveryResponse Response from initiate delivery request.
     *                                 Can be a new object, but transactionId should be set
     *                                 {@link InitiateDeliveryResponse#setTransactionId(String)}
     * @return True - if document ready to download, otherwise - false.
     * <p/>
     * WARNING: Exception can be thrown by {@link org.springframework.web.client.RestTemplate} if response will
     * not be successfull (when response code 4**, 5**)
     */
    public boolean isDocumentReady(InitiateDeliveryResponse InitiateDeliveryResponse) {
        return "completed".equalsIgnoreCase(getDocumentStatus(InitiateDeliveryResponse).getProgressStatus());
    }

    @Override
    public HttpHeaders configureHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Accept", "application/json");
        httpHeaders.set("Accept-Language", "en-GB");
        httpHeaders.set("Accept-Encoding", "gzip, deflate");
        httpHeaders.set("Cache-Control", "no-cache");
        httpHeaders.set("Connection", "keep-alive");
        httpHeaders.set("Cookie", getWebDriverDiscovery().getBrowserCookiesAsString());
        httpHeaders.set("Host", getWebDriverDiscovery().getCurrentRootAddress(false));
        httpHeaders.set("Pragma", "no-cache");
        httpHeaders.set("Referer", getWebDriverDiscovery().getRemoteWebDriver().getCurrentUrl());
        return httpHeaders;
    }

    /**
     * Download file with document name from status response and get file with it
     *
     * @param statusResponse {@link StatusResponse} which contains document name
     * @param isPrintable    Should be true if method calls for "Print" action of delivery
     * @return File with downloaded document
     */
    public File downloadDocumentAndGetFile(StatusResponse statusResponse, boolean isPrintable) {
        String fileUrl;
        if (isPrintable) {
            fileUrl = getProtocol() + getCurrentBaseUrl() + "/V1/Delivery/Print.pdf?deliveryId=" + statusResponse.getDeliveryId() +
                    "&printViaDownload=1";
        } else {
            fileUrl = getProtocol() + getCurrentBaseUrl() + "/V1/Delivery/Download/" + statusResponse.getDeliveryId() + "/" +
                    statusResponse.getFileName();
        }
        return getFileViaHttp(fileUrl, statusResponse.getFileName());
    }

    /**
     * Download file via HTTP through GET request
     *
     * @param fileUrl URL to file
     * @param targetFileName Relative file name which should be using for downloaded document. File will be stored in
     *                       "./target" folder.
     *                       WARNING: If file already exists then file will be downloaded with incremented file name.
     *                       E.g., "DocName_1.doc". Please, see {@link FileActions#incrementFileNameIfExists(File)}
     * @return File with downloaded document
     */
    public File getFileViaHttp(String fileUrl, String targetFileName) {
        HttpHeaders httpHeaders = configureHeaders();
        HttpEntity<byte[]> downloadFileResponse = getRestTemplate().exchange(fileUrl, HttpMethod.GET, new HttpEntity<>(httpHeaders), byte[].class);
        // Property points to root project dir ONLY if project running with Maven. In other cases you may receive wrong location or NullPointerException
        String targetDir = System.getProperty("basedir");
        String docFileName = targetDir + "/target/" + targetFileName;
        File downloadedFile = fileActions.incrementFileNameIfExists(new File(docFileName));
        try {
            FileUtils.writeByteArrayToFile(downloadedFile, downloadFileResponse.getBody());
        } catch (IOException e) {
            LOG.info("Error occurred during file downloading", e.getMessage());
        }
        return downloadedFile;
    }

}

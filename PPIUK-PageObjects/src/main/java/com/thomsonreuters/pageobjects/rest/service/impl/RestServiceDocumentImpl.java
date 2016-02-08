package com.thomsonreuters.pageobjects.rest.service.impl;

import com.thomsonreuters.pageobjects.rest.auth.UDSCredentials;
import com.thomsonreuters.pageobjects.rest.model.request.DocumentMetaInfoRequeset;
import com.thomsonreuters.pageobjects.rest.model.response.DocumentMetaInfoResponse;
import com.thomsonreuters.pageobjects.rest.service.RestService;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;

@Service
public class RestServiceDocumentImpl extends RestServiceImpl implements RestService {

    protected static final org.slf4j.Logger LOG = LoggerFactory.getLogger(RestServiceDocumentImpl.class);

    /**
     * POST request to
     * document/v1/MetaInfoList
     * with body
     * "DocumentGUIDS": [{
     * "docGuid": "",
     * "novusSearchHandle": ""
     * }]
     *
     * @return json[] object
     */
    public DocumentMetaInfoResponse[] postGetMetaInfo(String documentGuid) {
        ResponseEntity<DocumentMetaInfoResponse[]> result = null;
        try {
            String environment = System.getProperty("base.url");
            DocumentMetaInfoRequeset docRequest = new DocumentMetaInfoRequeset();
            String request = docRequest.createMetaInfoRequest(documentGuid, "");
            HttpEntity<String> requestEntity = new HttpEntity<String>(request, configureHeaders());
            String requestTo = "http://document.int.next." + environment + ".westlaw.com/Document/v1/MetaInfoList";
            result = getRestTemplate().postForEntity(requestTo, requestEntity, DocumentMetaInfoResponse[].class);
        } catch (RestClientException re) {
            if (re instanceof HttpClientErrorException) {
                HttpClientErrorException he = (HttpClientErrorException) re;
                System.out.println(he.getResponseBodyAsString());
            } else if (re instanceof HttpServerErrorException) {
                HttpServerErrorException he = (HttpServerErrorException) re;
                System.out.println(he.getResponseBodyAsString());
            } else {
                System.out.println("Sevice invoke Exception '" + re + "'");
                LOG.info("context", re);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return result.getBody();
    }

    /**
     * GET request to
     * document/v1/MetaInfo/{documentGuid}
     *
     * @return json[] object
     */
    public DocumentMetaInfoResponse getMetaInfo(String documentGuid) {
        ResponseEntity<DocumentMetaInfoResponse> result = null;
        try {
            String environment = System.getProperty("base.url");
            HttpHeaders httpHeaders = configureHeaders();
            HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
            String url = "http://document.int.next." + environment + ".westlaw.com/Document/v1/MetaInfo/" + documentGuid;
            result = getRestTemplate().exchange(url, HttpMethod.GET, requestEntity,
                    DocumentMetaInfoResponse.class);
        } catch (RestClientException re) {
            if (re instanceof HttpClientErrorException) {
                HttpClientErrorException he = (HttpClientErrorException) re;
                System.out.println(he.getResponseBodyAsString());
            } else if (re instanceof HttpServerErrorException) {
                HttpServerErrorException he = (HttpServerErrorException) re;
                System.out.println(he.getResponseBodyAsString());
            } else {
                System.out.println("Sevice invoke Exception '" + re + "'");
                LOG.info("context", re);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return result.getBody();
    }

    public HttpHeaders configureHeaders() {
        UDSCredentials credentials = getUDSCredentials();
        HttpHeaders httpHeaders = new HttpHeaders();
        String environment = System.getProperty("base.url");
        httpHeaders.set("x-cobalt-host", "document.int.next." + environment + ".westlaw.com");
        httpHeaders.set("Host", "document.int.next." + environment + ".westlaw.com");
        httpHeaders.set("Content-Type", "application/jsonrequest; charset=utf-8");
        httpHeaders.set("x-cobalt-product-container", "WestlawNext");
        httpHeaders.set("X-Cobalt-Security-Container", "Cobalt");
        httpHeaders.set("X-Cobalt-Security-UDS", "http://uds.int.next." + environment + ".westlaw.com/");
        httpHeaders.set("X-Cobalt-Security-ProductView", "PLCUK");
        httpHeaders.set("x-cobalt-security-userguid", credentials.getUserGuid());
        httpHeaders.set("x-cobalt-security-sessionid", credentials.getSessionID());
		httpHeaders.set("Cookie", "Co_SessionToken=" + credentials.getCoSessionToken() + "; site=" + getSite());
        httpHeaders.set("x-trmr-product", "WestlawNext");
        httpHeaders.set("Accept-Language", "en-us");
        httpHeaders.set("Accept", "application/json");
        httpHeaders.set("X-TRMR-BusinessUnit", "LEGAL-US-CORE");
        return httpHeaders;
    }

}

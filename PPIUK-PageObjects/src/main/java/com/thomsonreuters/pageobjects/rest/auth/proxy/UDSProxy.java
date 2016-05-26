package com.thomsonreuters.pageobjects.rest.auth.proxy;

import com.thomsonreuters.pageobjects.rest.auth.model.GetForSessionInfoResponse;
import com.thomsonreuters.pageobjects.rest.auth.model.GetForWorkProductTokenResponse;
import com.thomsonreuters.pageobjects.rest.auth.model.PostForUserGuidResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UDSProxy {
    private RestTemplate restTemplate = new RestTemplate();
    private String udsHost;

    public UDSProxy() {
        String environment = System.getProperty("base.url");
        udsHost = "http://uds.int.next." + environment + ".westlaw.com";
    }

    /**
     * POST request to UDS module with endpoint '/UDS/v1/authentication'
     * <p/>
     * Given a Prism Security user id and password (reg key),
     * attempt to log in to the Prism Security domain configured
     * for the calling product and environment. If the login is successful,
     * a short-lived prism authentication token will be returned,
     * along with the prism user guid and other user information associated
     * with that user in Prism Security.
     *
     * @param userID   name of new folder
     * @param password id of parent folder
     * @return json object
     */
    public PostForUserGuidResponse postForUserGuid(String userID, String password) {
        HttpHeaders httpHeaders = configureHeaders();
        String requestStr = "{\"UserId\":\"" + userID + "\",\"Password\":\"" + password + "\"}";
        HttpEntity<String> requestEntity = new HttpEntity<>(requestStr, httpHeaders);
        String requestTo = udsHost + "/UDS/v1/authentication";
        return restTemplate.postForObject(requestTo, requestEntity, PostForUserGuidResponse.class);
    }

    /**
     * GET request to UDS module with endpoint '/UDS/v8/authsession/query'
     * Query for sessions that match the given criteria
     *
     * @param userGuid      prism user guid
     * @param statusSession status may be 'online', 'authenticated' or other
     * @param productView   product View of session
     * @param site          site instance 'B' or "PC1" or other
     * @return array of all coSessionTokens that match the query
     */
    public String[] getAllActiveCoSessionTokens(String userGuid, String statusSession, String productView, String site) {
        HttpHeaders httpHeaders = configureHeaders();
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        String requestTo = udsHost + "/UDS/v8/authsession/query?" + "userId=" + userGuid + "&status=" + statusSession;
        if (productView != null) {
            requestTo += "&productView=" + productView;
        }
        if (site != null) {
        	requestTo += "&site=" + site.toUpperCase();
        }        
        HttpEntity<String[]> response = restTemplate.exchange(requestTo, HttpMethod.GET, requestEntity, String[].class);
        return response.getBody();
    }
    

    /**
     * GET request to UDS module with endpoint '/UDS/v8/authsession/{encodedLongToken}'
     * Retrieve a previously created session.
     *
     * @param encodedLongToken coSessionToken of session
     * @param siteCookie       cookie of site instance e.g "site=B"
     * @return json object
     */
    public GetForSessionInfoResponse getForSessionInfo(String encodedLongToken, String siteCookie) {
        HttpHeaders httpHeaders = configureHeaders();
        httpHeaders.add("Cookie", siteCookie);
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        String requestTo = udsHost + "/UDS/v8/authsession/" + encodedLongToken;
        HttpEntity<GetForSessionInfoResponse> response = restTemplate.exchange(requestTo, HttpMethod.GET, requestEntity, GetForSessionInfoResponse.class);
        return response.getBody();
    }

    /**
     * GET request to UDS module with endpoint '/UDS/v4/authentication/workproducttoken/{sessionID}'
     * Obtain a DataRoom WorkProductToken
     *
     * @param sessionID
     * @return json object
     */
    public GetForWorkProductTokenResponse getForWorkProductToken(String sessionID) {
        HttpHeaders httpHeaders = configureHeaders();
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        String requestTo = udsHost + "/UDS/v4/authentication/workproducttoken/" + sessionID;
        HttpEntity<GetForWorkProductTokenResponse> response = restTemplate.exchange(requestTo, HttpMethod.GET, requestEntity, GetForWorkProductTokenResponse.class);
        return response.getBody();
    }

    private HttpHeaders configureHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json; charset=utf-8");
        return httpHeaders;
    }
}

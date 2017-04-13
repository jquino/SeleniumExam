package com.jalasoft.pivotaltracker.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import com.jalasoft.pivotaltracker.framework.util.PropertiesInfo;

/**
 * This class initialize the REST API.
 */
public final class Authentication {

    private static Authentication instance;
    private RequestSpecification requestSpecification;
    private static final String TOKEN_HEADER = "X-TrackerToken";

    /**
     * This method initialize the REST API.
     */
    private Authentication() {
        initializeApi();
    }

    /**
     * Get an instance of the Authentication class.
     * @return authentication.
     */
    public static Authentication getInstance() {
        if (instance == null) {
            instance = new Authentication();
        }
        return instance;
    }

    /**
     * This method initialize the REST API.
     */
    private void initializeApi() {
        requestSpecification = new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .addHeader(TOKEN_HEADER, PropertiesInfo.getInstance().getApiToken())
                .build();
        requestSpecification.baseUri(PropertiesInfo.getInstance().getUrlApi());
        if (PropertiesInfo.getInstance().getProxy() != null) {
            requestSpecification.proxy(PropertiesInfo.getInstance().getProxy());
        }
    }

    /**
     * This method gets the RequestSpecification.
     * @return RequestSpecification.
     */
    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}

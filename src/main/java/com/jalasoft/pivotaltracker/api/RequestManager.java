package com.jalasoft.pivotaltracker.api;

import java.util.Map;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

/**
 * The purpose of this class is to provide methods that manage the REST API.
 * requests like GET, POST, PUT, and DELETE.
 * @author Jose Rioja.
 */
public final class RequestManager {

    private static final RequestSpecification REQUEST = Authentication.getInstance().getRequestSpecification();

    /**
     * RequestManager constructor.
     */
    private RequestManager() {
    }

    /**
     * This method is for GET request.
     * @param endpoint endpoint.
     * @return response.
     */
    public static Response getRequest(final String endpoint) {
        return given().spec(REQUEST)
                .when().get(endpoint);
    }

    /**
     * This method is for POST request.
     * @param endpoint endpoint.
     * @param parameters parameters.
     * @return response.
     */
    public static Response postRequest(final String endpoint, final Map<String, Object> parameters) {
        return given().spec(REQUEST).params(parameters)
                .when().post(endpoint);
    }

    /**
     * This method is for PUT request.
     * @param endpoint endpoint.
     * @param parameters parameters.
     * @return response.
     */
    public static Response putRequest(final String endpoint, final Map<String, Object> parameters) {
        return given().spec(REQUEST).params(parameters)
                .when().put(endpoint);
    }

    /**
     * This method is for DELETE request.
     * @param endpoint endpoint.
     * @return response.
     */
    public static Response deleteRequest(final String endpoint) {
        return given().spec(REQUEST).when().delete(endpoint);
    }
}

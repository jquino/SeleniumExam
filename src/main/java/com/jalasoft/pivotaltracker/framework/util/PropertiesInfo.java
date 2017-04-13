package com.jalasoft.pivotaltracker.framework.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * This class is for getting the properties defined into the properties file.
 * @author Jose Rioja.
 */
public final class PropertiesInfo {

    private static final Logger LOGGER = Logger.getLogger(PropertiesInfo.class.getSimpleName());
    private static final String CONFIG_PROPERTIES = "gradle.properties";
    private static final String PROXY_PORT = "proxyPort";
    private static final String PROXY_HOST = "proxyHost";
    private static final String EMAIL = "email";
    private static final String ACCESS_SECURITY = "password";
    private static final String URL = "url";
    private static final String URL_API = "urlApi";
    private static final String API_TOKEN = "apiToken";
    private static final String BROWSER = "browser";

    private static PropertiesInfo instance;

    private Properties properties;

    /**
     * Method to initialize properties info.
     */
    private PropertiesInfo() {
        loadProperties();
    }

    /**
     * Method to get an instance of the PropertiesInfo class.
     * @return a PropertiesInfo instance.
     */
    public static PropertiesInfo getInstance() {
        if (instance == null) {
            instance = new PropertiesInfo();
        }
        return instance;
    }

    /**
     * This method is used to load the .properties file.
     * which contains the configurations of the project.
     */
    private void loadProperties() {
        try {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(CONFIG_PROPERTIES);
                properties = new Properties();
                properties.load(fileInputStream);
//                fileInputStream.close();
            } finally {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.warn("The properties file couldn't be found", e);
        } catch (IOException e) {
            LOGGER.warn("A problem of type", e);
        }
    }

    /**
     * Method to get the value of a property.
     * @param propertyKey Property key.
     * @return Property value.
     */
    public String getProperty(final String propertyKey) {
        String propertyValue = System.getProperty(propertyKey);
        if (propertyValue == null) {
            propertyValue = properties.getProperty(propertyKey);
        }
        return propertyValue;
    }

    /**
     * Method to get the Email property value.
     * @return Email.
     */
    public String getEmail() {
        return getProperty(EMAIL);
    }

    /**
     * Method to get the Password property value.
     * @return password.
     */
    public String getPassword() {
        return getProperty(ACCESS_SECURITY);
    }

    /**
     * Method to get the Url property value.
     * @return Url.
     */
    public String getUrl() {
        return getProperty(URL);
    }

    /**
     * Method to get the Url API property value.
     * @return UrlApi.
     */
    public String getUrlApi() {
        return getProperty(URL_API);
    }

    /**
     * Method to get the Api Token property value.
     * @return ApiToken.
     */
    public String getApiToken() {
        return getProperty(API_TOKEN);
    }

    /**
     * Method to get the Browser property value.
     * @return Browser.
     */
    public String getBrowser() {
        return getProperty(BROWSER);
    }

    /**
     * Method to get the Proxy property value.
     * @return Proxy.
     */
    public String getProxy() {
        return !getProxyHost().isEmpty() ? String.format("http://%s:%s", getProxyHost(), getProxyPort()) : null;
    }

    /**
     * Method to get the Proxy Host property value.
     * @return Proxy Host.
     */
    private String getProxyHost() {
        return getProperty(PROXY_HOST);
    }

    /**
     * Method to get the Proxy Port property value.
     * @return Proxy Port.
     */
    private String getProxyPort() {
        return getProperty(PROXY_PORT);
    }
}

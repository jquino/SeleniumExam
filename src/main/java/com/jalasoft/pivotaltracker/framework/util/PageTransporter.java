package com.jalasoft.pivotaltracker.framework.util;

import static com.jalasoft.pivotaltracker.framework.selenium.DriverManager.getInstance;

/**
 * This class allows to navigate among the different pages of the site.
 * @author Jose Rioja.
 */
public final class PageTransporter {

    private static String baseUrl = PropertiesInfo.getInstance().getUrl();

    /**
     * PageTransporter constructor.
     */
    private PageTransporter() {
    }

    /**
     * This method navigates to specific page.
     * @param endPoint endpoint.
     */
    public static void goToURL(final String endPoint) {
        getInstance().getWebDriver().navigate().to(String.format("%s%s", baseUrl, endPoint));
    }
}

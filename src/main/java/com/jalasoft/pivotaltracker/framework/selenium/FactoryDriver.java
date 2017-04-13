package com.jalasoft.pivotaltracker.framework.selenium;

import org.openqa.selenium.WebDriverException;

/**
 * This class handle the logic related to what kind of browser will be used in the test.
 * @author Jose Rioja.
 */
public final class FactoryDriver {

    /**
     * Constructor of the FactoryDriver class.
     */
    private FactoryDriver() {
    }

    /**
     * Method to get the browser webDriver.
     * @param browser Browser name.
     * @return a browser webDriver.
     */
    public static IDriver getDriver(final String browser) {
        switch (Browser.valueOf(browser.toUpperCase())) {
            case CHROME:
                return new Chrome();
            case FIREFOX:
                return new Firefox();
            default:
                throw new WebDriverException("Browser not found: " + browser);
        }
    }
}

package com.jalasoft.pivotaltracker.framework.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class initialize the Firefox Selenium Web Driver.
 * @author Jose Rioja.
 */
public class Firefox implements IDriver {

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver initializeDriver() {
        return new FirefoxDriver();
    }
}

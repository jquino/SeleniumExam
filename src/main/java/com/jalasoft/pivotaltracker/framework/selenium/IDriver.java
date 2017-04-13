package com.jalasoft.pivotaltracker.framework.selenium;

import org.openqa.selenium.WebDriver;

/**
 * This interface define the methods related to initialize the Selenium webDriver.
 * @author Jose Rioja.
 */
public interface IDriver {

    /**
     * This method initialize the Selenium web webDriver through the classes that implements this method.
     * @return Selenium Web Driver.
     */
    WebDriver initializeDriver();
}

package com.jalasoft.pivotaltracker.framework.selenium;

import com.jalasoft.pivotaltracker.framework.util.PropertiesInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * The purpose of this class is to provide basic methods for managing the Selenium drivers.
 * @author Jose Rioja.
 */
public final class DriverManager {
    private static final int IMPLICIT_WAIT_TIME = 15;
    private static final int WAIT_TIME = 30;
    private static final int LOAD_PAGE_TIME = 40;
    private static DriverManager instance;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    /**
     * Method to initialize the Selenium drivers.
     */
    private DriverManager() {
        initializeWebDriver();
    }

    /**
     * Method to get an instance of the Driver Manager class.
     * @return an instance.
     */
    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    /**
     * Method to initialize the Selenium Web Driver.
     */
    private void initializeWebDriver() {
        webDriver = FactoryDriver.getDriver(PropertiesInfo.getInstance().getBrowser()).initializeDriver();
        webDriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(LOAD_PAGE_TIME, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriverWait = new WebDriverWait(webDriver, WAIT_TIME);
    }

    /**
     * Method to get the selenium webDriver.
     * @return a web webDriver.
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Method to get the Selenium webDriverWait.
     * @return a web webDriver webDriverWait.
     */
    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }
}

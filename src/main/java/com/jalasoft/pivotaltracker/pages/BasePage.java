package com.jalasoft.pivotaltracker.pages;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;

import static com.jalasoft.pivotaltracker.framework.selenium.DriverManager.getInstance;

/**
 * This class groups the generic methods to execute actions.
 * @author Jose Rioja.
 */
public abstract class BasePage {

    protected WebDriver webDriver;

    /**
     * This method initializes the page factory.
     */
    public BasePage() {
        webDriver = getInstance().getWebDriver();
        PageFactory.initElements(webDriver, this);
    }

    /**
     * This method refresh the current page.
     */
    public void refreshPage() {
        webDriver.navigate().refresh();
    }
}

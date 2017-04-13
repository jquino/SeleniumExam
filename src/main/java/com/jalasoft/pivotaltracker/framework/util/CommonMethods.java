package com.jalasoft.pivotaltracker.framework.util;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.jalasoft.pivotaltracker.framework.selenium.DriverManager.getInstance;

/**
 * This class groups the generic methods to execute actions.
 * @author Jose Rioja.
 */
public final class CommonMethods {

    private static final WebDriverWait WEB_DRIVER_WAIT = getInstance().getWebDriverWait();
    private static final WebDriver WEB_DRIVER = getInstance().getWebDriver();
    private static final Logger LOGGER = Logger.getLogger(CommonMethods.class.getSimpleName());

    /**
     * Constructor of CommonMethods class.
     */
    private CommonMethods() {
    }

    /**
     * This method set a Web Element.
     * @param webElement element.
     * @param text Text to set.
     */
    public static void setWebElement(final WebElement webElement, final String text) {
        WEB_DRIVER_WAIT.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    /**
     * This Method does click in a Web element.
     * @param webElement element.
     */
    public static void clickWebElement(final WebElement webElement) {
        WEB_DRIVER_WAIT.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * This Method does click in a By element.
     * @param byElement by element.
     */
    public static void clickByElement(final By byElement) {
        WEB_DRIVER_WAIT.until(ExpectedConditions.elementToBeClickable(byElement));
        WEB_DRIVER.findElement(byElement).click();
    }

    /**
     * Get the text from a WebElement.
     * @param webElement element.
     * @return Text.
     */
    public static String getTextFieldValue(final WebElement webElement) {
        getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }
}

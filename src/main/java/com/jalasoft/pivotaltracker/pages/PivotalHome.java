package com.jalasoft.pivotaltracker.pages;

import com.jalasoft.pivotaltracker.framework.util.PropertiesInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.pivotaltracker.framework.util.CommonMethods.clickWebElement;
import static com.jalasoft.pivotaltracker.framework.selenium.DriverManager.getInstance;

/**
 * This class loads the Pivotal Home page.
 * @author Jose Rioja.
 */
public class PivotalHome extends BasePage {

    @FindBy(css = ".header__lg a[href*='signin']")
    private WebElement signInLink;

    /**
     * This method loads the Pivotal Home page.
     */
    public PivotalHome() {
        getInstance().getWebDriver().get(PropertiesInfo.getInstance().getUrl());
    }

    /**
     * This method clicks on Signin link.
     * @return login page.
     */
    public Login clickSingInLink() {
        clickWebElement(signInLink);
        return new Login();
    }
}

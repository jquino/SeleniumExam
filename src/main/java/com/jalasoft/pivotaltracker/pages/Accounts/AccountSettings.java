package com.jalasoft.pivotaltracker.pages.Accounts;

import com.jalasoft.pivotaltracker.framework.selenium.DriverManager;
import com.jalasoft.pivotaltracker.framework.util.CommonMethods;
import com.jalasoft.pivotaltracker.pages.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class represents tha account settings page.
 * @author Jose Rioja.
 */
public class AccountSettings extends BasePage {

    @FindBy(xpath = "//a[text() = 'delete this account']")
    private WebElement deleteAccountLink;

    /**
     * This method clicks the delete account link.
     */
    public void clickDeleteAccountLink() {
        CommonMethods.clickWebElement(deleteAccountLink);
        Alert alert = DriverManager.getInstance().getWebDriver().switchTo().alert();
        alert.accept();
    }
}

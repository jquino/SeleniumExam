package com.jalasoft.pivotaltracker.pages.Accounts;

import com.jalasoft.pivotaltracker.framework.util.CommonMethods;
import com.jalasoft.pivotaltracker.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class represent the Accounts page.
 * @author Jose Rioja.
 */
public class Accounts extends BasePage {

    @FindBy(id = "new_account_link")
    private WebElement createAccountBtn;

    @FindBy(css = "h2.account_name span")
    private WebElement accountNameLabel;

    @FindBy(xpath = "//a[text() = 'Settings']")
    private WebElement settingsTab;

    @FindBy(xpath = "//a[. = 'accounts']")
    private WebElement accountsTab;

    private static final String ACCOUNT_NAME = "//*[text() = '%s']";
    private static final String MANAGE_ACCOUNT = "//*[.='%s']/ancestor::div[@class='header']/a[contains(@id,'manage')]";

    /**
     * This method clicks on create account button.
     * @return CreateAccountForm.
     */
    public CreateAccountForm clickCreateAccountBtn() {
        CommonMethods.clickWebElement(createAccountBtn);
        return new CreateAccountForm();
    }

    /**
     * This method gets the label of the user.
     * @return username.
     */
    public String getUserAccountLabel() {
        return CommonMethods.getTextFieldValue(accountNameLabel);
    }

    /**
     * This method clicks on Settings tab.
     * @return AccountSettings.
     */
    public AccountSettings clickSettingsTab() {
        CommonMethods.clickWebElement(settingsTab);
        return new AccountSettings();
    }

    /**
     * This method clicks on Accounts tab.
     */
    public void clickAccountsTab() {
        CommonMethods.clickWebElement(accountsTab);
    }

    /**
     * This method does click on the Manager Account button of an specific account.
     * @param accountName account name.
     */
    public void clickManageAccountBtn(final String accountName) {
        By manageAccountBtn = By.xpath(String.format(MANAGE_ACCOUNT, accountName));
        CommonMethods.clickByElement(manageAccountBtn);
    }

    /**
     * This method returns True or False when the element is displayed.
     * @param account account name.
     * @return True or false.
     */
    public boolean isAccountNameDisplayed(final String account) {
        By accountName = By.xpath(String.format(ACCOUNT_NAME, account));
        return webDriver.findElement(accountName).isDisplayed();
    }
}

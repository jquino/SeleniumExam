package com.jalasoft.pivotaltracker.pages.Accounts;

import com.jalasoft.pivotaltracker.framework.util.CommonMethods;
import com.jalasoft.pivotaltracker.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.pivotaltracker.framework.util.CommonMethods.setWebElement;

/**
 * This class represent the Create Account Form.
 * @author Jose Rioja
 */
public class CreateAccountForm extends BasePage {

    @FindBy(id = "account_name")
    private WebElement accountNameTextField;

    @FindBy(id = "add_account_button")
    private WebElement createNewAccountBtn;

    /**
     * This method sets a value for the account name.
     * @param accountName account name.
     */
    private void setAccountNameTextField(final String accountName) {
        setWebElement(accountNameTextField, accountName);
    }

    /**
     * This method clicks on the Create Account button.
     * @return accounts page.
     */
    private Accounts clickCreateAccountBtn() {
        CommonMethods.clickWebElement(createNewAccountBtn);
        return new Accounts();
    }

    /**
     * This method creates an account.
     * @param accountName account name.
     * @return Accounts.
     */
    public Accounts createAccount(final String accountName) {
        setAccountNameTextField(accountName);
        return clickCreateAccountBtn();
    }
}

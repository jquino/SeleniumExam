package com.jalasoft.pivotaltracker;

import com.jalasoft.pivotaltracker.pages.Accounts.AccountSettings;
import com.jalasoft.pivotaltracker.pages.Accounts.Accounts;
import com.jalasoft.pivotaltracker.pages.Accounts.CreateAccountForm;
import com.jalasoft.pivotaltracker.pages.Login;
import com.jalasoft.pivotaltracker.pages.dashboard.Dashboard;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Jose Rioja on 4/12/2017.
 */
public class AccountTest {

    private static final String ACCOUNT_NAME = "User 2";
    private Dashboard dashboard;
    private Accounts accounts;

    /**
     * BeforeClass method.
     */
    @BeforeClass
    public void beforeClass() {
        dashboard = Login.loginAsPrimaryUser();
    }

    /**
     * Test: Create an account.
     */
    @Test
    public void testLoginPage() {
        // When
        accounts = dashboard.clickAccounts();
        CreateAccountForm createAccountForm = accounts.clickCreateAccountBtn();
        accounts = createAccountForm.createAccount(ACCOUNT_NAME);

        //Then
        assertEquals(accounts.getUserAccountLabel(), ACCOUNT_NAME);
        accounts.clickAccountsTab();
        assertTrue(accounts.isAccountNameDisplayed(ACCOUNT_NAME));
    }

    /**
     * AfterClass method.
     */
    @AfterClass
    public void afterClass() {
        accounts.clickManageAccountBtn(ACCOUNT_NAME);
        AccountSettings accountSettings = accounts.clickSettingsTab();
        accountSettings.clickDeleteAccountLink();
    }
}

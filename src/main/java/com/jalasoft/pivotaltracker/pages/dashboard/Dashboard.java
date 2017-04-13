package com.jalasoft.pivotaltracker.pages.dashboard;

import com.jalasoft.pivotaltracker.api.RequestManager;
import com.jalasoft.pivotaltracker.framework.util.CommonMethods;
import com.jalasoft.pivotaltracker.pages.Accounts.Accounts;
import com.jalasoft.pivotaltracker.pages.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.pivotaltracker.framework.util.Constants.IMPLICIT_FAIL_WAIT_TIME;
import static com.jalasoft.pivotaltracker.framework.util.Constants.IMPLICIT_WAIT_TIME;
import static java.util.concurrent.TimeUnit.SECONDS;
import static com.jalasoft.pivotaltracker.framework.selenium.DriverManager.getInstance;

/**
 * This class is the Dashboard page.
 * @author Jose Rioja.
 */
public class Dashboard extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(Dashboard.class.getName());

    @FindBy(css = ".tc_profile_dropdown .tc_dropdown_name")
    private WebElement userNameText;

    @FindBy(css = "a[href='/accounts']")
    private WebElement accountsOption;

    @FindBy(id = "create_new_project_button")
    private WebElement createProjectLink;

    @FindBy(css = "[data-aid = 'create-workspace-button']")
    private WebElement createWorkspaceLink;

    @FindBy(id = "notice")
    private WebElement deleteMessageText;

    @FindBy(id = "notice")
    private WebElement messageDeleteWorkspace;

    @FindBy(id = "my_workspaces")
    private WebElement workspaceContainer;

    @FindBy(xpath = "//span[text() = 'Projects']")
    private WebElement projectsTab;

    @FindBy(xpath = "//span[text() = 'Workspaces']")
    private WebElement workspacesTab;

    /**
     * This method gets the user name from the profile dropdown field.
     * @return username.
     */
    public String getUserNameText() {
        String userName = "";
        try {
            getInstance().getWebDriver().manage().timeouts().implicitlyWait(IMPLICIT_FAIL_WAIT_TIME, SECONDS);
            userName = userNameText.getText();
        } catch (NoSuchElementException e) {
            LOGGER.warn("User name element not found", e);

        } finally {
            getInstance().getWebDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, SECONDS);
        }
        return userName;
    }

    /**
     * This method gets the username using the REST API.
     * @param value username.
     * @return username.
     */
    public String getUserName(final String value) {
        final String endPointProfile = "/me";
        final String fieldEmail = "email";
        final String fieldUserName = "username";
        final String email = RequestManager.getRequest(endPointProfile).body().jsonPath().get(fieldEmail);
        if (value.equalsIgnoreCase(email)) {
            return RequestManager.getRequest(endPointProfile).body().jsonPath().get(fieldUserName);
        }
        System.out.println("VALUE => " + value);
        return value;
    }

    /**
     * This method clicks on user name drop down to display the menu options.
     */
    private void clickUserNameDropDown() {
        CommonMethods.clickWebElement(userNameText);
    }

    /**
     * This method clicks on Accounts option.
     */
    private void clickAccountsOption() {
        CommonMethods.clickWebElement(accountsOption);
    }

    /**
     * This method expands the user dropdown menu and select accounts option.
     * @return accounts page.
     */
    public Accounts clickAccounts() {
        clickUserNameDropDown();
        clickAccountsOption();
        return new Accounts();
    }
}

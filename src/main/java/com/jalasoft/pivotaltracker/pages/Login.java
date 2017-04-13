package com.jalasoft.pivotaltracker.pages;

import com.jalasoft.pivotaltracker.framework.util.CommonMethods;
import com.jalasoft.pivotaltracker.framework.util.PageTransporter;
import com.jalasoft.pivotaltracker.framework.util.PropertiesInfo;
import com.jalasoft.pivotaltracker.pages.dashboard.Dashboard;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.pivotaltracker.framework.util.Constants.DASHBOARD_PAGE;

/**
 * This class is to login page the pivotal.
 * @author  Jose Rioja.
 */

public class Login extends BasePage {

    private static final PropertiesInfo PROPERTIES_INFO = PropertiesInfo.getInstance();

    @FindBy(id = "credentials_username")
    private WebElement userNameTextField;

    @FindBy(id = "credentials_password")
    private WebElement passwordTextField;

    @FindBy(css = ".app_signin_action_button")
    private WebElement signInBtn;

    /**
     * This method sets the user name text field.
     * @param username username.
     */
    public void setUserNameTextField(final String username) {
        CommonMethods.setWebElement(userNameTextField, username);
    }

    /**
     * This method sets the password text field.
     * @param password password.
     */
    public void setPasswordTextField(final String password) {
        CommonMethods.setWebElement(passwordTextField, password);
    }

    /**
     * This method allows to login to the site providing a username and password.
     * @param userName username.
     * @param password password.
     * @return dashboard.
     */
    public static Dashboard loginAs(final String userName, final String password) {
        Dashboard dashboard = new Dashboard();
        if (!dashboard.getUserNameText().equalsIgnoreCase(dashboard.getUserName(userName))) {
            PivotalHome pivotalHome = new PivotalHome();
            Login login = pivotalHome.clickSingInLink();
            login.setUserNameTextField(userName);
            login.clickSignInButton();
            login.setPasswordTextField(password);
            return login.clickSignInButton();
        } else {
            PageTransporter.goToURL(DASHBOARD_PAGE);
        }
        return dashboard;
    }

    /**
     * This method allows to click in the signin button.
     * @return dashboard.
     */
    public Dashboard clickSignInButton() {
        CommonMethods.clickWebElement(signInBtn);
        return new Dashboard();
    }


    /**
     * This method allows to login to the site using the username and password from the properties file.
     * @return dashboard.
     */
    public static Dashboard loginAsPrimaryUser() {
        return loginAs(PROPERTIES_INFO.getEmail(),
                PROPERTIES_INFO.getPassword());
    }
}

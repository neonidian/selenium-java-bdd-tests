package com.mitigram.web.pages;

import com.mitigram.web.framework.LocatorObject;
import com.mitigram.web.framework.browser.BrowserActions;

public class LoginPage {
    private final BrowserActions browserActions;
    private static final String LOGIN_PAGE_URL = "https://marketplace.mitigram.com/Account/Login";
    private static final String LOGIN_PAGE = "Login page > ";
    private static final LocatorObject LOGIN_DIV = new LocatorObject("div#login", LocatorObject.CSS, LOGIN_PAGE + "> Login div");
    private static final LocatorObject EMAIL_TEXT_BOX = new LocatorObject("Email", LocatorObject.ID, LOGIN_PAGE + "> Email ID text box");
    private static final LocatorObject PASSWORD_TEXT_BOX = new LocatorObject("Password", LocatorObject.ID, LOGIN_PAGE + "> Password text box");
    private static final LocatorObject LOGIN_BUTTON = new LocatorObject("loginBtn", LocatorObject.ID, LOGIN_PAGE + "> Login button");
    private static final LocatorObject FIELD_VALIDATION_NOTIFICATION_LABEL = new LocatorObject("div.error", LocatorObject.CSS, LOGIN_PAGE + "> Field validation notification label");
    private static final LocatorObject FORGOT_PASSWORD_LINK = new LocatorObject("//a[text()='Forgot your password?']", LocatorObject.XPATH, LOGIN_PAGE + "> Forgot password link");

    public LoginPage(BrowserActions browserActions) {
        this.browserActions = browserActions;
    }

    public boolean isLoginPageDisplayed() {
        return browserActions.isElementVisibleOnPage(LOGIN_DIV);
    }

    public void goToLoginPageByURL() {
        browserActions.openURL(LOGIN_PAGE_URL);
    }

    public LoginPage enterEmailIdToLogin(String username) {
        browserActions.enterTextInTextBox(EMAIL_TEXT_BOX, username);
        return this;
    }

    public void enterPasswordToLogin(String password) {
        browserActions.enterTextInTextBox(PASSWORD_TEXT_BOX, password);
    }

    public void clickOnLoginButton() {
        browserActions.click(LOGIN_BUTTON);
    }

    public String getFieldValidationNotificationMessageFromWebPage() {
        return browserActions.getLocatorInnerText(FIELD_VALIDATION_NOTIFICATION_LABEL);
    }

    public void clickOnForgotPasswordLink() {
        browserActions.click(FORGOT_PASSWORD_LINK);
    }
}

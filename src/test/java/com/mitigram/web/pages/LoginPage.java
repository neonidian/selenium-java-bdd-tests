package com.mitigram.web.pages;

import com.mitigram.web.framework.LocatorObject;
import com.mitigram.web.framework.browser.BrowserActions;

public class LoginPage {
    private final BrowserActions browserActions;
    private static final String LOGIN_PAGE_URL = "https://marketplace.mitigram.com/Account/Login";
    private static final String LOGIN_PAGE_NAME = "Login page > ";
    private static final LocatorObject LOGIN_DIV = new LocatorObject("div#login", LocatorObject.CSS, LOGIN_PAGE_NAME + "> Login div");

    public LoginPage(BrowserActions browserActions) {
        this.browserActions = browserActions;
    }

    public boolean isLoginPageDisplayed() {
        return browserActions.isElementVisibleOnPage(LOGIN_DIV);
    }

    public LoginPage goToLoginPageByURL() {
        browserActions.openURL(LOGIN_PAGE_URL);
        return this;
    }
}

package com.mitigram.web.pages;

import com.mitigram.web.framework.browser.BrowserActions;

public class LoginPage {
    BrowserActions browserActions;
    private static final String LOGIN_PAGE_NAME = "Login page > ";
    private static final com.mitigram.web.framework.LocatorObject LOGIN_DIV = new com.mitigram.web.framework.LocatorObject("div#login", com.mitigram.web.framework.LocatorObject.CSS, LOGIN_PAGE_NAME + "> Header section > Login link");

    public LoginPage(BrowserActions browserActions) {
        this.browserActions = browserActions;
    }

    public boolean isLoginPageDisplayed() {
        return browserActions.isElementVisibleOnPage(LOGIN_DIV);
    }
}

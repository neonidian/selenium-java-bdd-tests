package com.mitigram.web.pages;

import com.mitigram.web.framework.LocatorObject;
import com.mitigram.web.framework.browser.BrowserActions;

// Assuming on successful login, user is re-directed to 'user account' page
public class UserAccountPage {
    private final BrowserActions browserActions;
    private static final String USER_ACCOUNT_PAGE = "User account page ";
    private static final LocatorObject USER_ACCOUNT_DIV = new LocatorObject("div#useraccount", LocatorObject.CSS, USER_ACCOUNT_PAGE + "> User account div");

    public UserAccountPage(com.mitigram.web.framework.browser.BrowserActions browserActions) {
        this.browserActions = browserActions;
    }

    public boolean isUserAccountPageDisplayed() {
        return browserActions.isElementVisibleOnPage(USER_ACCOUNT_DIV);
    }
}

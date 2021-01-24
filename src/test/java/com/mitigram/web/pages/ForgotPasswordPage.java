package com.mitigram.web.pages;

import com.mitigram.web.framework.LocatorObject;
import com.mitigram.web.framework.browser.BrowserActions;

public class ForgotPasswordPage {
    private final BrowserActions browserActions;
    private static final String FORGOT_PASSWORD_PAGE = "Forgot password page ";
    private static final LocatorObject FORGOT_PASSWORD_HEADING = new LocatorObject("//div[@class='account-wall']//h4", LocatorObject.XPATH, FORGOT_PASSWORD_PAGE + "> Forgot password heading 4 level");

    public ForgotPasswordPage(BrowserActions browserActions) {
        this.browserActions = browserActions;
    }

    public boolean isForgotPasswordPageDisplayed() {
        return browserActions.isElementVisibleOnPage(FORGOT_PASSWORD_HEADING);
    }
}

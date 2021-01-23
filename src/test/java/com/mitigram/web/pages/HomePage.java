package com.mitigram.web.pages;

import com.mitigram.web.framework.LocatorObject;
import com.mitigram.web.framework.browser.BrowserActions;

public class HomePage {
    BrowserActions browserActions;
    private static final String HOME_PAGE_NAME = "Home page ";
    private static final String HOME_PAGE_URL = "https://mitigram.com/";
    private static final LocatorObject LOGIN_LINK_HEADER = new LocatorObject("//header/nav[@class='right']//a[text()='Login']", LocatorObject.XPATH, HOME_PAGE_NAME + "> Header section > Login link");
    private static final LocatorObject LOGIN_LINK_FOOTER = new LocatorObject("//footer/nav[@class=\"menu\"]//a[text()=\"Login\"]", LocatorObject.XPATH, HOME_PAGE_NAME + "> Footer section > Login link");

    public HomePage(BrowserActions browserActions) {
        this.browserActions = browserActions;
    }

    public com.mitigram.web.pages.HomePage goToMitigramHomePageByURL() {
        browserActions.openURL(HOME_PAGE_URL);
        return this;
    }

    public LoginPage navigateToLoginPageUsingHeader() {
        browserActions.click(LOGIN_LINK_HEADER);
        return new LoginPage(browserActions);
    }

    public LoginPage navigateToLoginPageUsingFooter() {
        browserActions.click(LOGIN_LINK_FOOTER);
        return new LoginPage(browserActions);
    }
}

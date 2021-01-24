package com.mitigram.web.pages;

import com.mitigram.web.framework.LocatorObject;
import com.mitigram.web.framework.browser.BrowserActions;

public class HomePage {
    private final BrowserActions browserActions;
    private static final String HOME_PAGE = "Home page ";
    private static final String HOME_PAGE_URL = "https://mitigram.com/";
    private static final LocatorObject LOGIN_LINK_HEADER = new LocatorObject("//header/nav[@class='right']//a[text()='Login']", LocatorObject.XPATH, HOME_PAGE + "> Header section > Login link");
    private static final LocatorObject LOGIN_LINK_FOOTER = new LocatorObject("//footer/nav[@class='menu']//a[text()='Login']", LocatorObject.XPATH, HOME_PAGE + "> Footer section > Login link");
    private static final LocatorObject CAREERS_LINK_HEADER = new LocatorObject("//header/nav//a[text()='Careers']", LocatorObject.XPATH, HOME_PAGE + "> Header section > Careers link");

    public HomePage(BrowserActions browserActions) {
        this.browserActions = browserActions;
    }

    public void goToMitigramHomePageByURL() {
        browserActions.openURL(HOME_PAGE_URL);
    }

    public void navigateToLoginPageUsingHeader() {
        browserActions.click(LOGIN_LINK_HEADER);
    }

    public void navigateToLoginPageUsingFooter() {
        browserActions.click(LOGIN_LINK_FOOTER);
    }

    public void navigateToCareersPageUsingHeader() {
        browserActions.click(CAREERS_LINK_HEADER);
    }
}

package com.mitigram.web.pages;

import com.mitigram.web.framework.LocatorObject;
import com.mitigram.web.framework.browser.BrowserActions;

public class CareersPage {
    private final BrowserActions browserActions;
    private static final String CAREERS_PAGE = "Careers page ";
    private static final String CAREERS_PAGE_URL = "https://mitigram.com/careers";
    private static final LocatorObject CAREERS_PAGE_HEADING = new LocatorObject("h2.headline", LocatorObject.CSS, CAREERS_PAGE + "> Careers page heading level 2");
    private static final LocatorObject OPEN_POSITIONS_DIV = new LocatorObject("div.positions", LocatorObject.CSS, CAREERS_PAGE + "> Open positions div");
    private static final LocatorObject PRIVACY_INFORMATION_IN_INTRODUCE_YOURSELF_SECTION = new LocatorObject("p.recaptcha", LocatorObject.CSS, CAREERS_PAGE + "> Introduce yourself section > privacy information");

    public CareersPage(BrowserActions browserActions) {
        this.browserActions = browserActions;
    }

    public void goToMitigramCareersPageByURL() {
        browserActions.openURL(CAREERS_PAGE_URL);
    }

    public boolean isCareersPageDisplayed() {
        return browserActions.isElementVisibleOnPage(CAREERS_PAGE_HEADING);
    }

    public boolean isOpenPositionsDivDisplayed() {
        return browserActions.isElementVisibleOnPage(OPEN_POSITIONS_DIV);
    }

    public boolean isPrivacyPolicyInformationInIntroduceYourselfSectionDisplayed() {
        return browserActions.isElementVisibleOnPage(PRIVACY_INFORMATION_IN_INTRODUCE_YOURSELF_SECTION);
    }
}

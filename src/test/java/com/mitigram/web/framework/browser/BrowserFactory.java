package com.mitigram.web.framework.browser;

@FunctionalInterface
public interface BrowserFactory {
    BrowserActions initializeBrowser();
}

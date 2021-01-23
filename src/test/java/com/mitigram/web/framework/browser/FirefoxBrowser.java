package com.mitigram.web.framework.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser implements BrowserFactory {
    @Override
    public BrowserActions initializeBrowser() {
        WebDriverManager.firefoxdriver().setup();
        return new BrowserActions(new FirefoxDriver());
    }
}

package com.mitigram.web.framework.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser implements BrowserFactory {
    @Override
    public BrowserActions initializeBrowser() {
        WebDriverManager.chromedriver().setup();
        return new BrowserActions(new ChromeDriver());
    }
}

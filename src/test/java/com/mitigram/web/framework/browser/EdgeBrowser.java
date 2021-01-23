package com.mitigram.web.framework.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeBrowser implements BrowserFactory {
    @Override
    public BrowserActions initializeBrowser() {
        WebDriverManager.edgedriver().setup();
        return new BrowserActions(new EdgeDriver());
    }
}

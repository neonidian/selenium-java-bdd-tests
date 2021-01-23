package com.mitigram.web;

import com.mitigram.web.framework.browser.BrowserActions;
import com.mitigram.web.framework.browser.ChromeBrowser;
import com.mitigram.web.framework.browser.EdgeBrowser;
import com.mitigram.web.framework.browser.FirefoxBrowser;
import com.mitigram.web.pages.HomePage;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.util.Arrays;
import java.util.List;

abstract class TestBase {

    private static final String CHROME = "CHROME";
    private static final String FIREFOX = "FIREFOX";
    private static final String EDGE = "EDGE";
    private static final List<String> supportedBrowsers = Arrays.asList(CHROME, FIREFOX, EDGE);
    protected BrowserActions browserActions;

    protected HomePage homePage;
    protected com.mitigram.web.pages.LoginPage loginPage;

    @BeforeEach
    void setupBrowser() {
        String browser = readBrowserFromConfiguration();
        startBrowser(browser);
        initializePages();
    }

     @AfterEach
     void exitBrowser() {
         browserActions.exitBrowser();
     }

    private void startBrowser(String browser) {
        switch (browser) {
            case CHROME: {
                browserActions = new ChromeBrowser().initializeBrowser();
                break;
            }
            case FIREFOX: {
                browserActions = new FirefoxBrowser().initializeBrowser();
                break;
            }
            case EDGE: {
                browserActions = new EdgeBrowser().initializeBrowser();
                break;
            }
            default: {
                throw new RuntimeException(
                        String.format("***** Browser %s not implemented in repository. Supported browsers - %s",
                                browser, supportedBrowsers));
            }
        }
    }

    private String readBrowserFromConfiguration() {
        Configurations browserConfiguration = new Configurations();
        String browserToUse = null;
        try {
            Configuration configuration = browserConfiguration.properties(new File("browser.properties"));
            browserToUse = configuration.getString("browserToUse").trim().toUpperCase();
        } catch (ConfigurationException configurationException) {
            configurationException.printStackTrace();
        }
        return browserToUse;
    }

    private void initializePages() {
        homePage = new HomePage(browserActions);
        loginPage = new com.mitigram.web.pages.LoginPage(browserActions);
    }
}
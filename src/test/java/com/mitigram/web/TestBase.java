package com.mitigram.web;

import com.mitigram.web.framework.browser.BrowserActions;
import com.mitigram.web.framework.browser.ChromeBrowser;
import com.mitigram.web.framework.browser.EdgeBrowser;
import com.mitigram.web.framework.browser.FirefoxBrowser;
import com.mitigram.web.pages.HomePage;
import com.mitigram.web.pages.LoginPage;
import com.mitigram.web.pages.UserAccountPage;
import io.cucumber.testng.TestNGCucumberRunner;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.Arrays;
import java.util.List;

abstract public class TestBase {

    private static final String CHROME = "CHROME";
    private static final String FIREFOX = "FIREFOX";
    private static final String EDGE = "EDGE";
    private static final List<String> supportedBrowsers = Arrays.asList(CHROME, FIREFOX, EDGE);

    protected BrowserActions browserActions;
    protected TestNGCucumberRunner testNGCucumberRunner;
    protected static HomePage homePage;
    protected static LoginPage loginPage;
    protected static UserAccountPage userAccountPage;


    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }

    @BeforeTest(alwaysRun = true)
    public void setupBrowser() {
        String browser = readBrowserFromConfiguration();
        startBrowser(browser);
        initializePages();
    }

    @AfterTest(alwaysRun = true)
    public void exitBrowser() {
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
                        String.format("***** Browser %s not implemented in this repository. Supported browsers - %s",
                                browser, supportedBrowsers));
            }
        }
    }

    private String readBrowserFromConfiguration() {
        Configurations browserConfiguration = new Configurations();
        String browserToUse = null;
        try {
            Configuration configuration = browserConfiguration.properties(new File("src/test/resources/com/mitigram/web/browser.properties"));
            browserToUse = configuration.getString("browserToUse").trim().toUpperCase();
        } catch (ConfigurationException configurationException) {
            configurationException.printStackTrace();
        }
        return browserToUse;
    }

    private void initializePages() {
        homePage = new HomePage(browserActions);
        loginPage = new LoginPage(browserActions);
        userAccountPage = new UserAccountPage(browserActions);
    }
}

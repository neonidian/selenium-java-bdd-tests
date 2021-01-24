package com.mitigram.web.framework.browser;

import com.mitigram.web.framework.LocatorObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserActions {

    private WebDriver webDriver;
    private final WebDriverWait webDriverWait;
    private static final int TIME_OUT_IN_SECONDS = 5;

    public BrowserActions(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(this.webDriver, Duration.ofSeconds(TIME_OUT_IN_SECONDS));
    }

    public void click(LocatorObject locatorObjectToClick) {
        try {
            webDriverWait.withMessage(
                    String.format("Unable to click web element '%s'. Locator description: %s", locatorObjectToClick.elementValue, locatorObjectToClick.locatorDescription))
                    .until(ExpectedConditions.visibilityOfElementLocated(locatorObjectToClick.elementValue)).click();
        } catch (WebDriverException webDriverException) {
            throw new WebDriverException(webDriverException);
        }
    }

    public void openURL(String applicationURL) {
        try {
            webDriver.get(applicationURL);
        } catch (WebDriverException webDriverException) {
            throw new WebDriverException(webDriverException);
        }
    }

    public void enterTextInTextBox(LocatorObject locatorTextBox, String textToEnter) {
        try {
            webDriverWait.withMessage(
                    String.format("Unable to enter text in web element '%s'. Locator description: %s", locatorTextBox.elementValue, locatorTextBox.locatorDescription))
                    .until(ExpectedConditions.visibilityOfElementLocated(locatorTextBox.elementValue)).sendKeys(textToEnter);
        } catch (WebDriverException webDriverException) {
            throw new WebDriverException(webDriverException);
        }
    }

    public String getLocatorInnerText(LocatorObject locatorObject) {
        try {
            return webDriverWait.withMessage(
                    String.format("Unable to get inner text for web element '%s'. Locator description: %s", locatorObject.elementValue, locatorObject.locatorDescription))
                    .until(ExpectedConditions.visibilityOfElementLocated(locatorObject.elementValue)).getText();
        } catch (WebDriverException webDriverException) {
            throw new WebDriverException(webDriverException);
        }
    }

    public boolean isElementVisibleOnPage(LocatorObject locatorObject) {
        try {
            return webDriverWait.withMessage(
                    String.format("Locator: %s is not visible in the web page. Locator: %s. ",
                            locatorObject.locatorDescription, locatorObject.elementValue))
                    .until(ExpectedConditions.visibilityOfElementLocated(locatorObject.elementValue)).isDisplayed();
        } catch (WebDriverException webDriverException) {
            throw new WebDriverException(webDriverException);
        }
    }

    public void exitBrowser() {
        webDriver.quit();
    }
}

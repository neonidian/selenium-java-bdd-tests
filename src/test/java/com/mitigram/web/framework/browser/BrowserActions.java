package com.mitigram.web.framework.browser;

import org.openqa.selenium.Keys;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserActions {

    private WebDriver webDriver;
    private final WebDriverWait webDriverWait;
    private static final int TIME_OUT_IN_SECONDS = 10;

    public BrowserActions(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(this.webDriver, Duration.ofSeconds(TIME_OUT_IN_SECONDS));
    }

    public void click(com.mitigram.web.framework.LocatorObject locatorObjectToClick) {
        try {
            webDriverWait.withMessage(
                    String.format("Unable to click web element '%s'. Locator description: %s", locatorObjectToClick.elementValue, locatorObjectToClick.locatorDescription))
                    .until(ExpectedConditions.visibilityOfElementLocated(locatorObjectToClick.elementValue)).click();
        } catch (WebDriverException webDriverException) {
            throw new WebDriverException(webDriverException);
        }
    }

    public String getCurrentPageURL() {
        try {
            return webDriver.getCurrentUrl();
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

    public void enterTextInTextBox(com.mitigram.web.framework.LocatorObject locatorTextBox, String textToEnter) {
        try {
            webDriverWait.withMessage(
                    String.format("Unable to enter text in web element '%s'. Locator description: %s", locatorTextBox.elementValue, locatorTextBox.locatorDescription))
                    .until(ExpectedConditions.visibilityOfElementLocated(locatorTextBox.elementValue)).sendKeys(textToEnter);
        } catch (WebDriverException webDriverException) {
            throw new WebDriverException(webDriverException);
        }
    }

    public void pressKeyOnAElement(com.mitigram.web.framework.LocatorObject locatorObject, String keyToPress) {
        try {
            WebElement webElement = webDriverWait.withMessage(
                    String.format("Unable to press the key: '%s' text in web element '%s'. Locator description: %s", keyToPress, locatorObject.elementValue, locatorObject.locatorDescription))
                    .until(ExpectedConditions.visibilityOfElementLocated(locatorObject.elementValue));
            if ("ENTER".equals(keyToPress.trim().toUpperCase())) {
                webElement.sendKeys(Keys.ENTER);
            } else {
                throw new UnsupportedCommandException(String.format("Key to press: '%s' not supported yet", keyToPress));
            }
        } catch (WebDriverException webDriverException) {
            throw new WebDriverException(webDriverException);
        }
    }

    public String getLocatorInnerText(com.mitigram.web.framework.LocatorObject locatorObject) {
        try {
            return webDriverWait.withMessage(
                    String.format("Unable to get inner text for web element '%s'. Locator description: %s", locatorObject.elementValue, locatorObject.locatorDescription))
                    .until(ExpectedConditions.visibilityOfElementLocated(locatorObject.elementValue)).getText();
        } catch (WebDriverException webDriverException) {
            throw new WebDriverException(webDriverException);
        }
    }

    public boolean waitForTextVisibleInElement(com.mitigram.web.framework.LocatorObject locatorObject, String textToBePresent) {
        try {
            return webDriverWait.withMessage(
                    String.format("Text: '%s' is not visible in the locator: %s. Locator description: %s",
                            textToBePresent, locatorObject.elementValue, locatorObject.locatorDescription))
                    .until(ExpectedConditions.and(
                            ExpectedConditions.visibilityOfElementLocated(locatorObject.elementValue),
                            ExpectedConditions.textToBePresentInElementLocated(locatorObject.elementValue, textToBePresent)
                    ));
        } catch (WebDriverException webDriverException) {
            throw new WebDriverException(webDriverException);
        }
    }

    public boolean isElementVisibleOnPage(com.mitigram.web.framework.LocatorObject locatorObject) {
        try {
            return webDriverWait.withMessage(
                    String.format("Locator: %s is not visible in the web page. Locator: %s. ",
                            locatorObject.locatorDescription, locatorObject.elementValue))
                    .until(ExpectedConditions.visibilityOfElementLocated(locatorObject.elementValue)).isDisplayed();
        } catch (WebDriverException webDriverException) {
            throw new WebDriverException(webDriverException);
        }
    }

    public void switchToCaptchaFrameAndClick(com.mitigram.web.framework.LocatorObject locatorObjectOfFrame, com.mitigram.web.framework.LocatorObject locatorObjectToClick) {
        try {
            WebDriver webDriverFrame = waitForFrameToBeAvailableAndSwitchTo(locatorObjectOfFrame);
            new WebDriverWait(webDriverFrame, Duration.ofSeconds(TIME_OUT_IN_SECONDS))
                    .withMessage(String.format("Unable to click locator element: %s", locatorObjectToClick))
                    .until(ExpectedConditions.visibilityOfElementLocated(locatorObjectToClick.elementValue)).click();
            this.webDriver = switchToDefaultContentFromAnotherFrame(webDriverFrame);
        } catch (WebDriverException webDriverException) {
            throw new WebDriverException(webDriverException);
        }
    }

    private WebDriver waitForFrameToBeAvailableAndSwitchTo(com.mitigram.web.framework.LocatorObject locatorObjectOfFrame) {
        try {
            return webDriverWait.withMessage(String.format("Unable to switch to frame with Locator Object: %s", locatorObjectOfFrame.elementValue))
                    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locatorObjectOfFrame.elementValue));
        } catch (WebDriverException webDriverException) {
            throw new WebDriverException(webDriverException);
        }
    }

    public boolean switchToFrameAndCheckIfALocatorIsDisplayed(com.mitigram.web.framework.LocatorObject locatorObjectFrame, com.mitigram.web.framework.LocatorObject locatorToVerifyIfDisplayed) {
        try {
            WebDriver webDriverFrame = waitForFrameToBeAvailableAndSwitchTo(locatorObjectFrame);
            return new WebDriverWait(webDriverFrame, Duration.ofSeconds(TIME_OUT_IN_SECONDS))
                    .withMessage(String.format("Locator: %s is not visible", locatorToVerifyIfDisplayed.elementValue))
                    .until(ExpectedConditions.visibilityOfElementLocated(locatorToVerifyIfDisplayed.elementValue)).isDisplayed();
        } catch (WebDriverException webDriverException) {
            throw new WebDriverException(webDriverException);
        }
    }

    private WebDriver switchToDefaultContentFromAnotherFrame(WebDriver webDriver) {
        try {
            return webDriver.switchTo().defaultContent();
        } catch (WebDriverException webDriverException) {
            throw new WebDriverException(webDriverException);
        }
    }

    public void exitBrowser() {
        webDriver.quit();
    }
}

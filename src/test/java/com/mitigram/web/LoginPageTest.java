package com.mitigram.web;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoginPageTest extends TestBase {

    @Test(description = "Verify navigation to Login page from Home page 'Login' link in header", priority = 1)
    public void verifyNavigationToLoginPageFromHomePageHeader() {
        homePage.goToMitigramHomePageByURL()
                .navigateToLoginPageUsingHeader();

        assertThat(loginPage.isLoginPageDisplayed(), is(true));
    }

    @Test(description = "Verify navigation to Login page from Home page 'Login' link in footer", priority = 2)
    public void verifyNavigationToLoginPageFromHomePageFooter() {
        homePage.goToMitigramHomePageByURL()
                .navigateToLoginPageUsingFooter();

        assertThat(loginPage.isLoginPageDisplayed(), is(true));
    }
}

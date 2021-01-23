package com.mitigram.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoginPageTest extends TestBase {

    @Test
    @DisplayName("Verify navigation to Login page from Home page 'Login' link in header")
    public void verifyNavigationToLoginPageFromHomePageHeader() {
        homePage.goToMitigramHomePageByURL()
                .navigateToLoginPageUsingHeader();

        assertThat(loginPage.isLoginPageDisplayed(), is(true));
    }

    @Test
    @DisplayName("Verify navigation to Login page from Home page 'Login' link in footer")
    public void verifyNavigationToLoginPageFromHomePageFooter() {
        homePage.goToMitigramHomePageByURL()
                .navigateToLoginPageUsingFooter();

        assertThat(loginPage.isLoginPageDisplayed(), is(true));
    }
}

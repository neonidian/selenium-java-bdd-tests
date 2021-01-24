package com.mitigram.web.stepdefinitions;

import com.mitigram.web.TestBase;
import io.cucumber.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoginPageStepDefinitions extends TestBase {

    @Then("the login page is displayed")
    public void verifyIfLoginPageIsDisplayed() {
        assertThat(loginPage.isLoginPageDisplayed(), is(true));
    }
}

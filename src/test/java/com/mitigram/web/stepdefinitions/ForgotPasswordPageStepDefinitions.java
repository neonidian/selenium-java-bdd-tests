package com.mitigram.web.stepdefinitions;

import com.mitigram.web.TestBase;
import io.cucumber.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ForgotPasswordPageStepDefinitions extends TestBase {

    @Then("the forgot password page must be displayed")
    public void verifyIfForgotPasswordPageIsDisplayed() {
        assertThat(forgotPasswordPage.isForgotPasswordPageDisplayed(), is(true));
    }
}

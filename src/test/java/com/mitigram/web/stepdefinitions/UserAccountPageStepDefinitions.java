package com.mitigram.web.stepdefinitions;

import com.mitigram.web.TestBase;
import io.cucumber.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UserAccountPageStepDefinitions extends TestBase {

    @Then("the user account page must be displayed")
    public void theUserAccountPageMustBeDisplayed() {
        assertThat(userAccountPage.isUserAccountPageDisplayed(), is(true));
    }
}

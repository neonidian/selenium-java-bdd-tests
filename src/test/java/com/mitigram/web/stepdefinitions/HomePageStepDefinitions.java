package com.mitigram.web.stepdefinitions;

import com.mitigram.web.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomePageStepDefinitions extends TestBase {

    @Given("a user is in home page")
    public void userIsInMitigramHomePage() {
        homePage.goToMitigramHomePageByURL();
    }

    @When("user clicks on the login link in the {string} section")
    public void userClicksOnTheLoginLinkInTheHeaderSection(String headerOrFooter) {

    }
}

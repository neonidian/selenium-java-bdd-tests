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
    public void userClicksOnTheLoginLink(String headerOrFooter) {
        if(headerOrFooter.equalsIgnoreCase("header")) {
            homePage.navigateToLoginPageUsingHeader();
        } else if(headerOrFooter.equalsIgnoreCase("footer")){
            homePage.navigateToLoginPageUsingFooter();
        } else {
            throw new RuntimeException("Invalid parameter passed - " + headerOrFooter);
        }
    }

    @When("user clicks on the careers link in the {string} section")
    public void userClicksOnTheCareersLinkInTheHeaderSection(String headerOrFooter) {
        homePage.navigateToCareersPageUsingHeader();
    }
}

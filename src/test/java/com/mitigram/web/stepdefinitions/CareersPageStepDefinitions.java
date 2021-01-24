package com.mitigram.web.stepdefinitions;

import com.mitigram.web.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CareersPageStepDefinitions extends TestBase {

    @Given("a user is in careers page")
    public void userIsInCareersPage() {
        careersPage.goToMitigramCareersPageByURL();
    }

    @Then("the careers page is displayed")
    public void verifyIfCareersPageIsDisplayed() {
        assertThat(careersPage.isCareersPageDisplayed(), is(true));
    }

    @Then("the open position section must be displayed")
    public void verifyIfOpenPositionsDivIsDisplayed() {
        assertThat(careersPage.isOpenPositionsDivDisplayed(), is(true));
    }

    @Then("the privacy policy must be displayed to the user")
    public void privacyPolicyMustBeDisplayedToTheUser() {
        assertThat(careersPage.isPrivacyPolicyInformationInIntroduceYourselfSectionDisplayed(), is(true));
    }
}

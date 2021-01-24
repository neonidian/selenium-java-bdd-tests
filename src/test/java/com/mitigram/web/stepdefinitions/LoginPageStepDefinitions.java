package com.mitigram.web.stepdefinitions;

import com.mitigram.web.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class LoginPageStepDefinitions extends TestBase {

    @Given("a user is in login page")
    @When("user uses the login URL in the browser")
    public void userUsesTheLoginURLInTheBrowser() {
        loginPage.goToLoginPageByURL();
    }

    @When("user enters empty email ID and password")
    public void userEntersEmptyEmailIDAndPassword() {
        loginPage.enterEmailIdToLogin("");
        loginPage.enterPasswordToLogin("");
    }

    @When("user enters an invalid email ID like {string}")
    public void userEntersInvalidEmailID(String emailID) {
        loginPage.enterEmailIdToLogin(emailID);
    }

    @When("user enters an valid email ID but invalid password")
    public void userEntersAnValidEmailIDButInvalidPassword() {
        loginPage.enterEmailIdToLogin("validemail@google.com")
                .enterPasswordToLogin("");
    }

    @And("user clicks on the login button")
    public void userClicksOnTheLoginButton() {
        loginPage.clickOnLoginButton();
    }

    @And("stays on the login page")
    @Then("the login page is displayed")
    public void verifyIfLoginPageIsDisplayed() {
        assertThat(loginPage.isLoginPageDisplayed(), is(true));
    }

    @Then("the user must get a notification message {string}")
    public void theUserMustGetANotificationMessage(String messageToShow) {
        assertThat(loginPage.getFieldValidationNotificationMessageFromWebPage(),
                containsString(messageToShow));
    }

    @When("user enters email ID as {string} and password as {string}")
    public void userEntersEmailIDAndPassword(String emailId, String password) {
        loginPage.enterEmailIdToLogin(emailId)
                .enterPasswordToLogin(password);
    }

    @When("user clicks on {string} link")
    public void userClicksOnForgotYourPasswordLink(String linkToClick) {
        loginPage.clickOnForgotPasswordLink();
    }
}

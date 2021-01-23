package com.mitigram.web;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/loginpage"},
        glue = {"com.mitigram.web.stepdefinitions"},
        plugin = { "pretty", "html:build/cucumber-reports.html" }
)

public class LoginFeatureTestRunner extends TestBase {

    @Override
    @org.testng.annotations.DataProvider(parallel = true)
    @org.testng.annotations.Test
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

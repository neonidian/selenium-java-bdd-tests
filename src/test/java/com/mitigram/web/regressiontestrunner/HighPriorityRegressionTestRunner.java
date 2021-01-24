package com.mitigram.web.regressiontestrunner;

import com.mitigram.web.TestBase;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(priority = 1)
@CucumberOptions(
        features = {"src/test/resources/features/loginpage"},
        glue = {"com.mitigram.web.stepdefinitions"},
        tags = "@high",
        plugin = { "pretty", "html:build/cucumber-reports/regression-high-risk-tests.html" }

)

public class HighPriorityRegressionTestRunner extends TestBase {

    @Override
    @DataProvider(parallel = true)
    //@Test(priority = 1, dataProvider = "scenarios")
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

package com.mitigram.web.regressiontestrunner;

import com.mitigram.web.TestBase;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(priority = 2)
@CucumberOptions(
        features = {"src/test/resources/features/loginpage"},
        glue = {"com.mitigram.web.stepdefinitions"},
        tags = "@low",
        plugin = { "pretty", "html:build/cucumber-reports/regression-low-risk-tests.html" }
)

public class LowPriorityRegressionTestRunner extends TestBase {

    @Override
    @DataProvider(parallel = true)
    //@Test(priority = 2, dataProvider = "scenarios")
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

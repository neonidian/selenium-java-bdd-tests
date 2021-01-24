package com.mitigram.web.regressiontests;

import com.mitigram.web.TestBase;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/com/mitigram/web/features/loginpage"},
        glue = {"com.mitigram.web.stepdefinitions"},
        tags = "@low",
        plugin = { "pretty", "html:build/cucumber-reports/regression-low-priority-tests.html" }
)

public class LowPriorityRegressionTest extends TestBase {

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @Test(dataProvider = "scenarios", description = "Low priority regression tests")
    public void lowPriorityScenario(PickleWrapper pickle, FeatureWrapper cucumberFeatureWrapper) {
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }
}

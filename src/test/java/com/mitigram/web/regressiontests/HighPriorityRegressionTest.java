package com.mitigram.web.regressiontests;

import com.mitigram.web.TestBase;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/com/mitigram/web/features"},
        glue = {"com.mitigram.web.stepdefinitions"},
        tags = "@high",
        plugin = { "pretty", "html:build/cucumber-reports/regression-high-priority-tests.html" }
)
public class HighPriorityRegressionTest extends TestBase {

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @Test(priority = 1, dataProvider = "scenarios", description = "High Runs Cucumber Feature")
    public void highPriorityScenario(PickleWrapper pickle, FeatureWrapper cucumberFeatureWrapper) {
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }
}

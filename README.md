# Mitigram Website - Regression Tests

## Overview
* The repository contains regression tests written in Ghekrin style(Given-When-Then) using Cucumber Java libraries
* The Gherkin style tests are located [here](src/test/resources/com/mitigram/web/features)
* To execute all the tests, open commandline -> go to this directory -> run `./gradlew`(Linux or Mac OS) or `gradlew`(Windows OS)
* After running the tests, the Gradle generated test reports can be viewed [here](build/reports/tests/test/index.html) 
  and Cucumber generated test reports can be viewed [here](build/cucumber-reports)
  
## Priority of regression tests
* The priority of the regression tests in this repository are based on the critical function of the application or not
* Based on the criticality, they have been classified as 'high' or 'low' priority using Cucumber tags
* 'high' priority tests defined in this repository means that these tests test the critical flow of the application 
and must pass as part of quality check
* 'low' priority tests defined in this repository means that these tests test functionality that are 'good to have' but 
may not block a release
  
### Running high priority tests
To run only _high_ priority tests use the command use the Gradle task `highPriorityRegressionTests`
E.g., In Linux or Mac, open command-line and use this command `./gradlew highPriorityRegressionTests`

### Running low priority tests
To run only _low_ priority tests use the command use the Gradle task `lowPriorityRegressionTests`
E.g., In Linux or Mac, open command-line and use this command `./gradlew lowPriorityRegressionTests`

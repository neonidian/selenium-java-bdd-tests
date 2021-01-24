# Mitigram Website - Regression Tests

## Overview
* The repository contains browser based regression tests written in Ghekrin style(Given-When-Then) using Cucumber Java libraries
* The Gherkin style tests are located [here](src/test/resources/com/mitigram/web/features)
* Pre-requisites to run the test: Chrome browser, JDK 8 or higher. 
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

## Build system, libraries used
* Gradle is used as the build system. Build file [here](build.gradle)
* TestNG library is used as the test library because it provides better way of handling parallel execution, order of execution
* [TestNG suite XML configuration](src/test/resources/com/mitigram/web/testngrunners) files have been used in the [build.gradle](build.gradle)
file to organize tests based on priority
* Cucumber library is used for writing BDD style speciifaction tests
* Selenium library is used for browser based automation
* Webdrivermanager library is used for managing driver executables for various browsers
* Hamcrest is used as the assertion library
* Apache Commons configuration is used to retrieve configuration. Currently only browser configuration can be configured 
  through [browser.properties](src/test/resources/com/mitigram/web/browser.properties) file. This library can be further used
  to use system properties, XML configuration and more when needed
  
## Test framework
* A test framework based on page object model is used here. This enable re-use and easy maintenance.
* The [pages package](src/test/java/com/mitigram/web/pages) defines the functionality of the respective web page
* The [framework package](src/test/java/com/mitigram/web/framework) defines the Selenium based framework to perform actions in the browser
* The [regressiontests package](src/test/java/com/mitigram/web/regressiontests) provides the glue code for Cucumber tests based on priority

## Browsers supported
* Chrome, Firefox, Edge browsers are supported
* The browser can be configured through [browser.properties](src/test/resources/com/mitigram/web/browser.properties) file

## Running tests in IDE
To run tests in any Java based IDE,
1. Make sure TestNG IDE plugin is installed(mostly IDEs have this plugin by default)
2. Go to the glue code [directory](src/test/java/com/mitigram/web/regressiontests)
3. Right-click the file you would like to run based on priority and select a context action 
   which says like Run tests.
 
## Using this in a CI/CD system
If these regression tests, were to be used in a CI/CD system like Jenkins, since the Gradle tasks are defined,
the tests can be run in a pipline starting with high priority tests so as to get quicker feedback when tests fail
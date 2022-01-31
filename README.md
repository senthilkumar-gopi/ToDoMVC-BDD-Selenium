# TodoMVC – BDD Test Automation

TodoMVC Web Automation testing using Selenium and Cucumber.

## Tools Used

```bash
Automation tool : Selenium
Programming language : Java
Build Tool : Maven
Testing Framework : Cucumber BDD
Reports : Extent
Logger : Slf4J
```

## Project Folder structure

```python
==============
src/main/java:
==============
Helper Package:
ScenarioSetup - contains driver manager, utility methods and required common methods for this framework
UIHelper – Contains different reusable actions methods such as click, settext, gettext, takescreenshot, etc
WebDriverListener – listener class to log some thing during exception and other purposes
WebDriverManager -  Contains the methods for creating drivers for different browsers such as Chrome & Firefox

Pages Package:
HomePageAction - contains the page objects and action methods used for the home page

Stepdefinition Package:
HomePageSteps - contains the glue code corresponding to the Home Page

===================
src/main/resources:
===================
Config – Contains url for different environments like Dev, INT, Staging
Driver – Contains the drivers for chrome and firefox for Windows/Mac OS
Log4j – Used for logging and logs will be created in target folder


==============
src/test/java:
==============
Feature: Contains cucumber feature file written in Gherkin language/keywords
Test Runner: contains runner classes helps in kick start the execution through Junit/TestNG

==================
src/test/resources:
==================
SuiteFiles - Contains testng xml file which helps in Parallel execution.

=====================
Test Execution Steps:
=====================
1.	src/test/java -> testrunner -> CucumberRunner.java
Right click on the file and run as Junit Test

(OR)

2.	src/test/resources -> suitexmlfile -> Regression.xml
Right click on the file and run as TestNG Suite

(OR)

3.	Right click on the pom.xml and run as Maven test

=========
Reports :
=========
1) HTML Reports - target\HtmlReports
     SparkHtmlReport.html - Extent Report
     cucumber-html-report.html - Default Cucumber Report
2) Json Reports - target\JsonReports
	 cucumber-json-report.json - Cucumber Json Report
3) Junit Reports - target\JunitReports
	 cucumber-junit-report.xml - Junit xml Report
```

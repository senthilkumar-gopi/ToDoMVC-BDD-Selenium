package testrunner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		monochrome = true,
		plugin = { 
				   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				   "html:target/HtmlReports/cucumber-html-report.html",
		           "json:target/JsonReports/cucumber-json-report.json", 
		           "junit:target/JunitReports/cucumber-junit-report.xml" 
		         },
		features = {"src/test/java/feature/todomvc.feature"},
		glue={"stepdefinition"},
		tags = "@regression"
		)

public class TestNgRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
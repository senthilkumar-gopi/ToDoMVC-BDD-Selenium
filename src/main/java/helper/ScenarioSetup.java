package helper;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.Scenario;

public class ScenarioSetup {
	
	public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static final ThreadLocal<UIHelper> helper = new ThreadLocal<>();
	public static final ThreadLocal<Scenario> scenario = new ThreadLocal<>();
	
	public static UIHelper getUIHelper() {
		return helper.get();
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static Scenario getScenario( ) {
		return scenario.get();
	}
}

package stepdefinition;

import org.apache.log4j.Logger;
import helper.ScenarioSetup;
import helper.UIHelper;
import helper.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePageAction;

public class HomePageSteps {

	private static Logger log = Logger.getLogger(HomePageSteps.class);
	private HomePageAction homePage;
	
	@Before
	public void beforeScenario(Scenario scenario) throws Exception {
		try {
			String browser = "Chrome";
			log.info("********Started executing scenario : " + scenario.getName() + "********");
			ScenarioSetup.driver.set(WebDriverManager.INSTANCE.getWebDriver(browser));
			ScenarioSetup.helper.set(new UIHelper(ScenarioSetup.driver.get()));
			ScenarioSetup.scenario.set(scenario);
		} catch(Exception e) {
			throw new RuntimeException("Unable to load web driver" + e.getMessage());
		}
	}

	@After
	public void afterScenario(Scenario scenario) {
		String status="PASSED";
		try {
			if (scenario.getStatus()==Status.FAILED) {
				status="FAILED";
				ScenarioSetup.getUIHelper().screenShot();
			}
			ScenarioSetup.getDriver().quit();
			ScenarioSetup.driver.remove();
			ScenarioSetup.helper.remove();
			ScenarioSetup.scenario.remove();
		} catch(Exception e) {
			throw new RuntimeException("Unable to quit the web dribver!" + e.getMessage());
		}
		log.info("********Completed executing scenario : " + scenario.getName() + "  --->  " + status + "********\n");
	}
	
	@Given("Senthil opens the todoMVC application")
	public void openToDoMvcApplication() {
		homePage = new HomePageAction();
		homePage.openApplication();
	}
	
	/**
	 * 
	 * @param task - String
	 */
	@When("Senthil add task {string} to the TODO list")
	public void addTask(String task) {
		homePage.addTask(task);
	}
	
	/**
	 * 
	 * @param task - String
	 * @param section - All, Active, Completed
	 */
	@Then("Senthil ensure task {string} is listed in {string} section")
	public void ensureTasksPresent(String task, String section) {
		homePage.ensureTask(task, section, true);
	}
	
	/**
	 * 
	 * @param task - String
	 * @param section - All, Active, Completed
	 */
	@Then("Senthil ensure task {string} is not listed in {string} section")
	public void ensureTasksNotPresent(String task, String section) {
		homePage.ensureTask(task, section, false);
	}
	
	@When("Senthil clicks toggle all Tasks")
	public void toggleAllTasks() {
		homePage.toggleAll();
	}
	
	@When("Senthil marks the task {string} as Completed")
	public void taskComplete(String task) {
		homePage.completeTheTask(task);
	}
	
	/**
	 * 
	 * @param task - String
	 * @param newTask - String
	 */
	@When("Senthil edit task {string} from the list with new Task {string}")
	public void editTask(String task, String newTask) {
		homePage.editExistingTask(task, newTask);
	}
	
	/**
	 * 
	 * @param task - String
	 */
	@When("Senthil marks the task {string} as not Completed")
	public void markNotComplete(String task) {
		homePage.completeTheTask(task);
	}
	
	/**
	 * 
	 * @param task - String
	 */
	@Then("Senthil ensure task {string} is striked off")
	public void tasksStrikeOff(String task) {
		homePage.ensureTaskStrikeOff(task);
	}
	
	@When("Senthil clicks Clear completed link")
	public void clearComplete() {
		homePage.clickClearComplete();
	}
	
	/**
	 * 
	 * @param count - Integer
	 */
	@Then("Senthil ensure {int} items left")
	public void ensureCount(int count) {
		homePage.verifyCount(count);
	}
	
	/**
	 * 
	 * @param task - String
	 */
	@When("Senthil remove task {string} from the list")
	public void taskRemove(String task) {
		homePage.removeTheTask(task);
	}
}
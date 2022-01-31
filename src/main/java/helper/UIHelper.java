package helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIHelper {

	private static Logger log = Logger.getLogger(UIHelper.class);
	private WebDriverWait wait;	
	private WebDriver driver;
	
	public UIHelper(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 60);
	}

	public void clickElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public void clickElementByLocator(WebDriver driver, By bylocator) {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(bylocator));
		wait.until(ExpectedConditions.elementToBeClickable(bylocator));
	    driver.findElement(bylocator).click();
	}
	
	public void setText(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.clear();
		element.sendKeys(text);
	}
	
	public String getText(WebElement element) {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("Element text : "+ element.getText());
		return element.getText();
	}
	
	public boolean isElementPresent(WebElement element) {
		boolean value=false;
		try {
			element.isDisplayed();
			value=true;
		}
		catch(Exception e) {
			log.info("Element is not present " + element);			
		}
		return value;
	}
	
	public void screenShot()
    {
		try {
			String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
			byte[] screenshot = ((TakesScreenshot) ScenarioSetup.getDriver()).getScreenshotAs(OutputType.BYTES);
			ScenarioSetup.getScenario().attach(screenshot, "image/png", ScenarioSetup.getScenario().getName()+timestamp);
	    }
	    catch(Exception e) {
	    	log.info("Problem in adding screenshot to the Reports- " + e.getMessage());
	    }
    }
	
	public String getProperty(String key) {
		Properties prop = new Properties();
		String value = "";
		try(InputStream input = new FileInputStream("src/main/resources/config/config.properties")) {
			prop.load(input);
			value = prop.getProperty(key);
		} catch(IOException e) {
			log.info("Problem in getting the value for the key - " + e.getMessage());
			throw new RuntimeException("Problem in getting the value for the key - " + key);
		}
		return value;
	}
}

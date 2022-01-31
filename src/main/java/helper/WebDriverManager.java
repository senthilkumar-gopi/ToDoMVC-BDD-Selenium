package helper;

import java.util.Collections;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public enum WebDriverManager {
	
	INSTANCE;
	private static Logger log = Logger.getLogger(WebDriverManager.class);
	
	private WebDriver getDriver(String browser) {
		WebDriver basedriver = null;
		log.info("Current Browser is : "+ browser);
		String os = System.getProperty("os.name");
		log.info("Current OS is : "+ os);
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			options.setExperimentalOption("useAutomationExtension", false);
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			if(os.toLowerCase().trim().contains("mac"))
				  System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/mac/chromedriver");
			  else
				  System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/windows/chromedriver.exe");
			basedriver = new ChromeDriver(options);
			getSessionId(basedriver);
		} 
		else if(browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.setAcceptInsecureCerts(true);
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(CapabilityType.HAS_NATIVE_EVENTS, false);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			if(os.toLowerCase().trim().contains("mac"))
				  System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/mac/geckodriver");
			  else
				  System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/windows/geckodriver.exe");			basedriver = new FirefoxDriver(options);
			getSessionId(basedriver);
		}
		
		WebDriver driver;
		EventFiringWebDriver efwd = new EventFiringWebDriver(basedriver);
		WebDriverListener eventListener = new WebDriverListener(basedriver);
		efwd.register(eventListener);
		driver = efwd;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		return driver;
	}
	
	public WebDriver getWebDriver(String browser) {
		return getDriver(browser);
	}
	
	private void getSessionId(WebDriver driver) {
		log.info("Created Session Id - "+ ((RemoteWebDriver) driver).getSessionId().toString());
	}
	
}
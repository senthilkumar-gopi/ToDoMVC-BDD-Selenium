package helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebDriverListener implements WebDriverEventListener {

	private static Logger log = Logger.getLogger(WebDriverListener.class);
	private WebDriver driver;

	public WebDriverListener(WebDriver driver) {
		this.driver = driver;
	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		// To do
	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		log.info("After clicking. Url is " + driver.getCurrentUrl());
	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// To do
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		// To do
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		// To do
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		// To do
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		log.info("Current Title is " + driver.getTitle());
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// To do
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		// To do
	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// To do
	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// To do
	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		// To do
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		// To do
	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		// To do
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		log.info("Before moving to the url" + url);
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// To do
	}

	@Override
	public void onException(Throwable t, WebDriver driver) {
		log.debug("Problem in the Script. Excpetion is ", t);
	}

	@Override
	public void afterAlertAccept(WebDriver arg0) {
		// To do
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		// To do
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// To do
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		// To do
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		// To do
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// To do
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// To do
	}

	@Override
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// To do
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// To do
	}

	@Override
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// To do
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		// To do
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// To do
		
	}
}
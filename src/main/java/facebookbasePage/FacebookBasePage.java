package facebookbasePage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.aventstack.extentreports.ExtentTest;

import facebookconfig.Settings;


public class FacebookBasePage {
	
	
	protected String baseUrl = Settings.websiteUrl;
	protected WebDriver driver;
	//protected Logger log;
	protected Actions action;
	protected ExtentTest test;
	//protected WaitUtils waitUtils;


	public FacebookBasePage(WebDriver driver) {
		this.driver = driver;
		//this.log = log;
		//this.waitUtils = new WaitUtils(driver, null);
	}
	
	public void openUrl(String url) {
		driver.get(url);
	}
//	
//	protected WebElement find(By locator) {
//		waitForVisibilityOf(locator);
//		return driver.findElement(locator);
//	}
	
//	protected void waitForVisibilityOf(By locator, Duration... timeout) {
//		waitUtils.waitForVisibilityOf(locator, timeout);
//	}
	
//	protected void click(By locator) {
//		find(locator).click();
//	}
	
	
	
}

package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.SearchResultsPage;

public class BaseTest {

	protected LoginPage loginPage;
	WebDriver driver;
	DriverFactory df;
	protected Properties prop;
	protected AccountPage accPage;
	protected SearchResultsPage searchResultsPage;
	Actions action;

	
	@BeforeTest
	public void Setup() {
	
	df = new DriverFactory();
	prop = df.initProp();
	driver = df.initDriver(prop);
	
	loginPage = new LoginPage(driver);
	action = new Actions(driver);
	}

	@AfterTest
	public void tearDown() {
	driver.quit();
	}
}

package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.exceptions.BrowserExceptions;

public class DriverFactory {
//initDriver
//initProperties

	WebDriver driver;
	Properties prop;
	WebDriverWait wait;
	
	public Boolean isPageLoaded(int timeout)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.pollingEvery(Duration.ofMillis(500))
		.ignoring(TimeoutException.class);
	
		String flag = wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==='complete'")).toString();
		return Boolean.valueOf(flag);	
	}
	
	//JavascriptExecutor jsUtil;
	public WebDriver initDriver(Properties prop) {

		String browserName = prop.getProperty("browser");
		
		switch(browserName.trim().toLowerCase())
		{
		case "chrome": driver = new ChromeDriver();
		break;
		
		case "firefox": driver= new FirefoxDriver();
		break;
		
		case "edge":driver = new EdgeDriver();
		break;
		
		default: throw new BrowserExceptions("BROWSER NOT FOUND");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("url"));
		
		if(!isPageLoaded(10))
		{
			isPageLoaded(5);
			
		}
		
		return driver;
	}

	public Properties initProp() {
	
		prop = new Properties();
		try {
			FileInputStream fs = new FileInputStream(".//src//test//resources//config//config.properties");
			prop.load(fs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
}

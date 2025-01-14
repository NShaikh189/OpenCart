package com.qa.opencart.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends PagesAbstract{

	private WebDriver driver;
	WebDriverWait wait;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}

	private By accPageListGroup = By.cssSelector(".list-group a");
	private By logoutLink = By.linkText("Logout");
//	private By accPageHeaders = By.cssSelector(".col-sm-9");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");

	@Override
	public String pageTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}

	@Override
	public String pageUrl() {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl();
	}
	
	
	public int accPageListGroupCount() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(accPageListGroup))).size();
	}

	public boolean islogoutLinkExist() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink)).isDisplayed();
	}

	public SearchResultsPage doSearch(String product) {

		driver.findElement(search).clear();

		Actions act = new Actions(driver);
		act.sendKeys(driver.findElement(search), product).perform();;
		act.moveToElement(driver.findElement(searchIcon)).click().perform();;
		return new SearchResultsPage(driver);

	}


}

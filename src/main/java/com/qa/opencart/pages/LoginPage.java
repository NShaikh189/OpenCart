
package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By email = By.id("input-email");
	private By password = By.id("input-password");
	private By forgotPasswordLink = By.xpath("(//a[contains(text(),'Password')])[1]");
	private By submitButtom=By.xpath("//input[@type='submit']");
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public String getLoginPageUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public boolean forgotPasswordLinkExist()
	{
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}
	
	public AccountPage doLogin(String uname, String pwd)
	{
		driver.findElement(email).sendKeys(uname);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(submitButtom).click();
		
		return new AccountPage(driver);
	}
}

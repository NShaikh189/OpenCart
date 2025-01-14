package com.qa.opencart.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BWF {

	static WebDriver driver;
	static WebDriverWait wait;
	public static void initDriver()
	{
		driver = new ChromeDriver();
		driver.get("https://bwfworldtour.bwfbadminton.com/tournament/5222/petronas-malaysia-open-2025/results/2025-01-10");
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		
	//	wait.until(ExpectedConditions.jsReturnsValue("return document.readyState()==='complete'"));
	}
	
	
	public static void getMatchDetails(int matchId)
	{
		
		By playerCountry = By.xpath("//span[text()='Match 9']/parent::div//following-sibling::div//div[@class='participant-wrapper']/img");
		By playerName = By.xpath("//span[text()='Match 9']/parent::div//following-sibling::div//div[@class='participant-wrapper']/div/a");
		By AllowAllCookies = By.xpath("//button[text()='Allow all']");
		Actions act = new Actions(driver);
		act.scrollToElement(wait.until(ExpectedConditions.presenceOfElementLocated(playerCountry))).build().perform();
		System.out.println(driver.getTitle());
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(AllowAllCookies));
		
		if(!(element==null))
			{
						element.click();
			System.out.println("Cookies Accepted");
			}
		System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(playerCountry)).getAttribute("alt").toString());
		System.out.println(driver.findElement(playerName).getText());
	}
	public static void main(String args[])
	{
		initDriver();
		getMatchDetails(8);
	}
}

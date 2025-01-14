package com.qa.opencart.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.exceptions.BrowserExceptions;

public class SearchResultsPage extends PagesAbstract {

	WebDriver driver;
	
	String allProducts = "//div[@class='product-thumb']";
	String addToCartButton = "//ancestor::div[@class='caption']/following-sibling::div//span";

	By productList = By.xpath(allProducts);

	By productHeaderList = By.cssSelector(".product-thumb .caption a");
//	By productLocator = By.xpath("//div[@class='product-thumb']//a[text()='MacBook Air']");

	By shoppingCart = By.linkText("shopping cart");
	By addtoCartMessage = By.cssSelector(".alert-success");
	Actions act;
	List<String> searchProductList;
	WebDriverWait wait;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		act = new Actions(driver);
	}

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

	public int searchResultCount() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productList));
		return driver.findElements(productList).size();
	}

	public List<WebElement> productHeaderList() {
		return driver.findElements(productHeaderList);
	}

	public Boolean doAddToCart(String product) {

		Boolean flag=false;
		
		String prodName = allProducts + "//a[text()='" + product + "']" + addToCartButton;
		
		By addtoCart = By.xpath(prodName);
		
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(addtoCart));
		act.moveToElement(driver.findElement(addtoCart)).click().perform();
		flag = true;
		}catch(Exception e) {
			flag = false;
	}
		
		return flag;
	}

}

package com.qa.opencart.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.Assert;

import com.qa.opencart.base.BaseTest;

public class SearchResultsPageTest extends BaseTest {

	@BeforeClass
	public void searchResultPageSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 2)
	public void searchResultPageTitleTest() {
		// searchResultsPage = accPage.doSearch(product);
		Assert.assertTrue(searchResultsPage.pageTitle().contains("Search"));
	}

	@Test(priority = 2)
	public void searchResultUrlTest() {
		Assert.assertTrue(searchResultsPage.pageUrl().contains("search"));
	}

	@DataProvider
	public Object[][] product() {
		return new Object[][] { { "macbook", 3 }, { "samsung", 2 } };
	}

	@Test(dataProvider = "product", priority = 1)
	public void searchProductCount(String productName, int productCount) {
		searchResultsPage = accPage.doSearch(productName);
		Assert.assertEquals(searchResultsPage.searchResultCount(), productCount);

	}

//	@DataProvider
//	public Object[][] productsToAdd() {
//		return new Object[][] { 
//			{
//				"macbook", new String[] { "MacBook Air", "MacBook2","MacBook Pro" } 
//				} 
//			};
//	}
//			

	@DataProvider
	public Object[][] productsToAdd() {
		return new Object[][] { { "macbook", "MacBook Air" }, { "macbook", "MacBook" },
				{ "samsung", "Samsung Galaxy Tab 10.1" }, { "macbook", "MacBook2" }, };
	}

	@Test(dataProvider = "productsToAdd", priority = 1)
	public void addProductToCartTest(String productBrand, String productName) {
		SoftAssert assertion = new SoftAssert();

		searchResultsPage = accPage.doSearch(productBrand);

		assertion.assertTrue(searchResultsPage.doAddToCart(productName), productName + ": NOT FOUND");
		assertion.assertAll();

	}

}

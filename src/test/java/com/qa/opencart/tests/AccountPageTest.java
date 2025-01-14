package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class AccountPageTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetup()
	{
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	@Test(priority=1)
	public void pageTitleTest()
	{
		Assert.assertEquals(accPage.pageTitle(),"My Account");
	}
	
	@Test(priority=2)
	public void pageUrlTest()
	{
		Assert.assertTrue(accPage.pageUrl().contains("route=account/account"));
	}
	
	@Test(priority=5)
	public void doSearchTest()
	{
		searchResultsPage = accPage.doSearch("Macbook");
		Assert.assertEquals(searchResultsPage.pageTitle(), "Search");
	}
	
	@Test(priority=3)
	public void isLogoutLinkExist()
	{
		Assert.assertTrue(accPage.islogoutLinkExist());
	}
	
	@Test(priority=4)
	public void accPageHeadersTest()
	{
		int count = accPage.accPageListGroupCount();
		Assert.assertTrue(count>0);
	}
	
}

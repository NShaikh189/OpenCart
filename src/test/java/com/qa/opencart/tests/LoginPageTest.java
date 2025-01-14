package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title, "Account Login");
	}

	@Test(priority = 2)
	public void loginPageURLTest() {
		String pageUrl = loginPage.getLoginPageUrl();
		Assert.assertTrue(pageUrl.contains("route=account/login"));

	}

	@Test(priority = 3)
	public void forgotPasswordLinkExistTest() {
		Assert.assertTrue(loginPage.forgotPasswordLinkExist());
	}

	@Test(priority = 4)
	public void loginTest() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	    Assert.assertTrue(accPage.pageTitle().contains("My Account"));
	}
}

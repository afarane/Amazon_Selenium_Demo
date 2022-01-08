package com.amazon.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.SignInPage;
import com.amazon.qa.pages.SignInUser;
import com.amazon.qa.util.TestUtil;

public class LoginTest extends TestBase {
	HomePage homePage;
	SignInPage signinPage;
	TestUtil testUtil;
	SignInUser signInUser;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		signinPage = new SignInPage();
	}

	@Test(priority = 1)
	public void homePageTitle() {
		String homePagetitle = homePage.validateHomePageTitle();
		System.out.println("Home Page Title is : " + homePagetitle);
		Assert.assertEquals(homePagetitle,
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in",
				"[error] Home Page Title is not correct");
	}

	@Test(priority = 2)
	public void loginTest() {
		signinPage = homePage.login();
		String signinPageTitle = signinPage.validateSigninPageTitle();
		Assert.assertEquals(signinPageTitle, "Amazon Sign In", "[error] Sign In Page Title is not correct");
		signInUser = signinPage.signin(prop.getProperty("email"), prop.getProperty("password"));
		signInUser.validateSignInUser(prop.getProperty("username"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
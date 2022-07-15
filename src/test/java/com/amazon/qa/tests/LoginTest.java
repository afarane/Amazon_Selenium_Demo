package com.amazon.qa.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.SignInPage;
import com.amazon.qa.pages.SignInUser;
import com.amazon.qa.util.TestUtil;

import TestSetup.TestBase;

public class LoginTest extends TestBase {
	HomePage homePage;
	SignInPage signinPage;
	TestUtil testUtil;
	SignInUser signInUser;
	
	Logger log = Logger.getLogger(LoginTest.class);

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info(" ************ Starting tets ************ ");
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		signinPage = new SignInPage();
	}

	@Test(priority = 1)
	public void homePageTitle() {
		log.info("[afarane] Checking Home Page Title");
		String homePagetitle = homePage.validateHomePageTitle();
		System.out.println("Home Page Title is : " + homePagetitle);
		Assert.assertEquals(homePagetitle,
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in",
				"[error] Home Page Title is not correct");
	}

	@Test(priority = 2)
	public void loginTest() {
		signinPage = homePage.login();
		String signinPageTitle = signinPage.getSigninPageTitle();
		Assert.assertEquals(signinPageTitle, "Amazon Sign In", "[error] Sign In Page Title is not correct");
		signInUser = signinPage.signin(prop.getProperty("email"), prop.getProperty("password"));
		signInUser.validateSignInUser(prop.getProperty("username"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info(" ************ Test END ************ ");
		
		
	}

}

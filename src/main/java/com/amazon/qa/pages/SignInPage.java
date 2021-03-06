package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestSetup.PageBase;

public class SignInPage extends PageBase {

	@FindBy(xpath = "//form[@name='signIn']")
	WebElement signInForm;
	
	// PageFatory - Object Repository.
	@FindBy(id = "ap_email")
	WebElement emailTextBox;

	@FindBy(id = "continue")
	WebElement continueBtn;

	@FindBy(id = "ap_password")
	WebElement passwordTextBox;

	@FindBy(id = "signInSubmit")
	WebElement signInBtn;
	
	

	// Initializing Page Objects
	public SignInPage() {
		PageFactory.initElements(driver, this);	
	}

	// Actions:
	public String getSigninPageTitle() {
		return getPageTitle();
	}

	public SignInUser signin(String email, String password) {
		signInForm.isDisplayed();
		emailTextBox.sendKeys(email);
		continueBtn.click();
		passwordTextBox.sendKeys(password);
		signInBtn.click();

		return new SignInUser();
	}



}

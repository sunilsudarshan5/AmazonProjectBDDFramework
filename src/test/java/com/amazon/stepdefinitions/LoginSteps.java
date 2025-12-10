package com.amazon.stepdefinitions;

import org.testng.Assert;

import com.amazon.base.Base;
import com.amazon.pages.LoginPage;
import com.amazon.utilites.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends Base{
	
	public LoginPage loginPage;
	public LoginSteps() {		
		loginPage = new LoginPage(driver);
	}

	@Given("I navigate to Amazon login page")
	public void i_navigate_to_amazon_login_page() {
		loginPage.clickOnContinueShoppingButton();
		loginPage.clickOnSigninBtn();	
		Assert.assertTrue(loginPage.getSignInPageURL().contains("signin"));
	}

	@When("I enter valid username")
	public void i_enter_valid_username() {
		String username = System.getProperty("username", ConfigReader.get("config", "username"));
		loginPage.enterEmailIdOrMobileNo(username);
	}

	@When("I click on continue button")
	public void i_click_on_continue_button() {
		loginPage.clickOnContinueButton();
	}

	@When("I enter valid password")
	public void i_enter_valid_password() {
		String pass = System.getProperty("password", ConfigReader.get("config", "password"));
		loginPage.enterPassword(pass);
	}

	@When("click on login button")
	public void click_on_login_button() {
		loginPage.clickSignInButton();
	}

	@Then("I should be logged in successfully")
	public void i_should_be_logged_in_successfully() {
		Assert.assertEquals(loginPage.getAllText(), "All");
	}

	@When("I enter invalid username")
	public void i_enter_invalid_username() {

		String invalidUser = System.getProperty("inValidUsername", ConfigReader.get("config", "inValidUsername"));
		loginPage.enterEmailIdOrMobileNo(invalidUser);
	}

	@Then("Looks like you are new to Amazon text should be visible")
	public void looks_like_you_are_new_to_amazon_text_should_be_visible() {

		String invalidUser = System.getProperty("verificationCodeText",
				ConfigReader.get("config", "verificationCodeText"));
		Assert.assertEquals(loginPage.getVerificationCodeText(), invalidUser);
	}

}

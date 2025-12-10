package com.amazon.stepdefinitions;

import org.testng.Assert;

import com.amazon.base.Base;
import com.amazon.pages.CartPage;
import com.amazon.pages.LoginPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps extends Base {

	public static CartPage cartPage;
	public static LoginPage loginPage;

	public CartSteps() {
		cartPage = new CartPage(driver);
		loginPage = new LoginPage(driver);
	}

	@When("I click on add to cart")
	public void i_click_on_add_to_cart() {
		loginPage.clickOnContinueShoppingButton();
		cartPage.clickOnAddToCartBtn();
	}

	@Then("trash icon should be displayed")
	public void trash_icon_should_be_displayed() {
		Assert.assertTrue(cartPage.isTrashIconDisplayed(), "Product is not added in Cart");
	}

}

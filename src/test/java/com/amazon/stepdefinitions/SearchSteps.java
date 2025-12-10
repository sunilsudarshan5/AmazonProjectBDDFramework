package com.amazon.stepdefinitions;

import org.testng.Assert;

import com.amazon.base.Base;
import com.amazon.pages.LoginPage;
import com.amazon.pages.SearchPage;
import com.amazon.utilites.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps extends Base {

	public static SearchPage searchPage;
	public static LoginPage loginPage;

	public SearchSteps() {
		searchPage = new SearchPage(driver);
		loginPage = new LoginPage(driver);
	}

	@Given("I am on Amazon homepage")
	public void i_am_on_amazon_homepage() {
		loginPage.clickOnContinueShoppingButton();
		Assert.assertEquals(loginPage.getAllText(), "All");
	}

	@When("I search for iphone15")
	public void i_search_for_iphone15() {
		searchPage.enterSearchProductName();
	}

	@When("I click on search button")
	public void i_click_on_search_button() {
		searchPage.clickOnSearchBtn();
	}

	@Then("search result should be displayed")
	public void search_result_should_be_displayed() {
		String searchProductNm = System.getProperty("searchItem", ConfigReader.get("config", "searchItem"));
		Assert.assertEquals(searchPage.getProductName(), searchProductNm);
	}

}

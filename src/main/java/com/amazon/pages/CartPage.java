package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.amazon.base.Base;
import com.amazon.utilites.ConfigReader;
import com.amazon.utilites.WaitUtilitie;

public class CartPage extends Base{
	
	int explicitWait = Integer.parseInt(System.getProperty("explicitWait", ConfigReader.get("config", "explicitWait")));
	private By btnAddCard = By.xpath("//h2[contains(text(),'Results')]/ancestor::div[contains(@class,'s-result-item')]/following::div[1]//button[text()='Add to cart']");
	private By trashIcon = By.xpath("//h2[contains(text(),'Results')]/ancestor::div[contains(@class,'s-result-item')]/following::div[1]//span[contains(@class,'trash')]");
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickOnAddToCartBtn() {
		WaitUtilitie.explicitWaitForelementToBeClickable(driver, explicitWait, btnAddCard).click();;
	}
	
	public boolean isTrashIconDisplayed() {
		return WaitUtilitie.explicitWaitForvisibilityOfElementLocated(driver, explicitWait, trashIcon).isDisplayed();
	}

}

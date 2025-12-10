package com.amazon.pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.Base;
import com.amazon.utilites.ConfigReader;
import com.amazon.utilites.WaitUtilitie;

public class SearchPage extends Base{
	
	private By fieldSearchBar = By.id("twotabsearchtextbox");
	private By btnSearch = By.id("nav-search-submit-button");
	private By txtProductName = By.xpath("//h2[contains(text(),'Results')]/ancestor::div[contains(@class,'s-result-item')]/following::div[1]//h2/span");
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterSearchProductName() {
		String searchProductNm = System.getProperty("searchItem", ConfigReader.get("config", "searchItem"));	
		WebElement product = driver.findElement(fieldSearchBar);
		product.clear();
		product.sendKeys(searchProductNm);
	}
	
	public void clickOnSearchBtn() {
		WebElement searchBtn = driver.findElement(btnSearch);
		searchBtn.click();
	}
	
	public String getProductName() {
		int explicitWait = Integer.parseInt(System.getProperty("explicitWait", ConfigReader.get("config", "explicitWait")));
		
		String product = WaitUtilitie.explicitWaitForvisibilityOfElementLocated(driver, explicitWait, txtProductName).getText();
		Pattern pattern = Pattern.compile("iPhone \\d+");
		Matcher matcher = pattern.matcher(product);
		String productName = null;
		if(matcher.find()) {
			productName = matcher.group();
		}
		return productName;
	}
	
}

package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.Base;
import com.amazon.utilites.ConfigReader;
import com.amazon.utilites.WaitUtilitie;

public class LoginPage extends Base {


	int explicitWait = Integer.parseInt(System.getProperty("explicitWait", ConfigReader.get("config", "explicitWait")));

	private By continueShopping = By.xpath("//button[text()='Continue shopping']");
	private By accountList = By.xpath("//a[contains(@href,'/ap/signin')]/span[contains(text(),'Account & Lists')]");
	private By signInButton = By.xpath("//a[contains(@href,'/ap/signin')]");
	private By enterMobNo = By.name("email");
	private By continueButton = By.xpath("//input[contains(@class,'a-button-input')]");
	private By enterPassword = By.name("password");
	private By btnSignIn = By.xpath("//span[@id='auth-signin-button']");
	private By txtNewToAmazon = By.xpath("//div[@id='intent-confirmation-container']/h1");
	private By allText = By.xpath("//a/span[text()='All']");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnContinueShoppingButton() {
		try {
			WaitUtilitie.explicitWaitForelementToBeClickable(driver, explicitWait, continueShopping).click();
		} catch (Exception e) {
			System.out.println("Failed to click Continue Shopping button: " + e.getMessage());
		}
	}

	public void clickOnSigninBtn() {
		WebElement account = WaitUtilitie.explicitWaitForvisibilityOfElementLocated(driver, explicitWait, accountList);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(account).perform();
		
		WebElement signInBtn = WaitUtilitie.explicitWaitForelementToBeClickable(driver, explicitWait, signInButton);
		signInBtn.click();
	}

	public String getSignInPageURL() {
		WaitUtilitie.explicitWaitForUrlContains(driver, explicitWait, "signin");
		return driver.getCurrentUrl();
	}

	public void enterEmailIdOrMobileNo(String mobNo) {
		WaitUtilitie.explicitWaitForvisibilityOfElementLocated(driver, explicitWait, enterMobNo).sendKeys(mobNo);
	}

	public void clickOnContinueButton() {
		WaitUtilitie.explicitWaitForelementToBeClickable(driver, explicitWait, continueButton).click();
	}

	public void enterPassword(String pass) {
		WaitUtilitie.explicitWaitForvisibilityOfElementLocated(driver, explicitWait, enterPassword).sendKeys(pass);
	}

	public void clickSignInButton() {
		WaitUtilitie.explicitWaitForelementToBeClickable(driver, explicitWait, btnSignIn).click();
	}

	public String getVerificationCodeText() {
		return WaitUtilitie.explicitWaitForvisibilityOfElementLocated(driver, explicitWait, txtNewToAmazon).getText();
	}

	public String getAllText() {
		return WaitUtilitie.explicitWaitForvisibilityOfElementLocated(driver, explicitWait, allText).getText();
	}

}

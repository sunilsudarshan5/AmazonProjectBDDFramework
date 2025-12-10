package com.amazon.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.amazon.utilites.ConfigReader;

public class Base {
	public static WebDriver driver;
		
	public Base(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Base() {
		
	}
	
	public WebDriver initiateBrowser() {
		String browser = System.getProperty("browser", ConfigReader.get("config", "browser")).toLowerCase().trim();
		switch (browser) {
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "chrome":
			driver = new ChromeDriver();
			break;
		default:
			throw new IllegalArgumentException("unsupported browser " + browser);
		}
		return driver;
	}

	public void quiteBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
}

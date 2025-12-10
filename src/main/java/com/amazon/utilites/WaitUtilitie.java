package com.amazon.utilites;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilitie {
	
	public static void implicitWaitforPage(WebDriver driver, int times) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(times));
	}

	public static WebElement explicitWaitForelementToBeClickable(WebDriver driver, int times, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(times));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static WebElement explicitWaitForvisibilityOfElementLocated(WebDriver driver, int times, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(times));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static Boolean explicitWaitForUrlContains(WebDriver driver, int times, String str) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(times));
		return wait.until(ExpectedConditions.urlContains(str));
	}
	
}

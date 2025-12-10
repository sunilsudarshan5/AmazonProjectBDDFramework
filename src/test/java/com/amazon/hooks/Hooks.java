package com.amazon.hooks;

import com.amazon.base.Base;
import com.amazon.utilites.ConfigReader;
import com.amazon.utilites.WaitUtilitie;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Base{
	
	@Before
	public void setUp() {
		initiateBrowser();
		driver.manage().window().maximize();
		int implicitWait = Integer
				.parseInt(System.getProperty("implicitWait", ConfigReader.get("config", "implicitWait")));
		WaitUtilitie.implicitWaitforPage(driver, implicitWait);
		driver.get(System.getProperty("amazonUrl", ConfigReader.get("config", "amazonUrl")));

	}
	
	@After
	public void teardown() {
		quiteBrowser();
	}

}

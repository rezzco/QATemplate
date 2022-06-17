package com.github.rezzco.QATemplate;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPageObjects;

public class HomePage extends Base{

		@BeforeTest
		public void InitialSteps() {
////		driver initialized before all the test so every test can be run on one driver
////		or Test cases can initialize the drive again
//		driver = initializeWebDriver(DriverType.CHROME);
//		
	}
	
	@Test
	public void basePageNavigation() {
		driver = initializeWebDriver();
		driver.get("https://rezztours.herokuapp.com/");
		
		LandingPageObjects lp = new LandingPageObjects(driver);
		lp.loginBtn().click();
	}
}

package com.github.rezzco.QATemplate;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ErrorHandling.InitializationFailedException;
import ErrorHandling.InternalExceptions;
import PageObjects.NavbarPageObjects;

public class Navbar extends Base {
	public WebDriver driver;

	@BeforeTest
	public void InitialSteps() throws InitializationFailedException {
		
		driver = initializeWebDriver();
	}
	
	@Test
	public void navbarLoadingTest() throws InternalExceptions {
		logger.info("Before Test Thread Number Is " + Thread.currentThread().getId());

		driver.get(getProperty("url"));
		
		NavbarPageObjects navObjects = new NavbarPageObjects(driver);
		
		Assert.assertTrue(navObjects.getNavbar().isDisplayed());
		
		
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}

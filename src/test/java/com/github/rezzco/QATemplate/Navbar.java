package com.github.rezzco.QATemplate;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ErrorHandling.InitializationFailedException;
import ErrorHandling.InternalExceptions;
import PageObjects.NavbarPageObjects;

public class Navbar extends Base {
	@BeforeTest
	public void InitialSteps() throws InitializationFailedException {
		driver = initializeWebDriver();
	}
	
	@Test
	public void navbarLoadingTest() throws InternalExceptions {
		System.out.println("The thread ID for Firefox is "+ Thread.currentThread().getId());
		driver.get(getProperty("url"));
		
		NavbarPageObjects navObjects = new NavbarPageObjects(driver);
		
		Assert.assertTrue(navObjects.getNavbar().isDisplayed());
		
		
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}

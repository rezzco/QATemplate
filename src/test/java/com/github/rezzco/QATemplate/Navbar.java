package com.github.rezzco.QATemplate;

import org.testng.Assert;
import org.testng.annotations.Test;

import ErrorHandling.InternalExceptions;
import PageObjects.NavbarPageObjects;

public class Navbar extends Base {
	
	@Test
	public void navbarLoadingTest() throws InternalExceptions {
		driver = initializeWebDriver();
		driver.get(getProperty("url"));
		
		NavbarPageObjects navObjects = new NavbarPageObjects(driver);
		
		Assert.assertTrue(navObjects.getNavbar().isDisplayed());
		
		driver.close();
		
		
	}

}

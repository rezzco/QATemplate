package com.github.rezzco.QATemplate;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ErrorHandling.InitializationFailedException;
import ErrorHandling.InternalExceptions;
import PageObjects.LandingPageObjects;
import PageObjects.LoginPageObjects;

public class HomePage extends Base {

	public WebDriver driver;
	@BeforeTest
	public void InitialSteps() throws InitializationFailedException {
		logger.info("Before Test Thread Number Is " + Thread.currentThread().getId());

		
	}

	@BeforeMethod
	public void methodInitialization() throws InitializationFailedException {
		driver = initializeWebDriver();
	}

	@Test(dataProvider = "userdp")
	public void basePageNavigation(String username, String password, String testType) throws InternalExceptions {
		logger.info("Before Test Thread Number Is " + Thread.currentThread().getId());

		driver.get(getProps().getProperty("url"));
		LandingPageObjects lp = new LandingPageObjects(driver);
		lp.loginBtn().click();
		String AlertText = loginTest(username, password);
		logger.error(String.format("test for %s and pass %s starting...", username, password));
		if (testType.equalsIgnoreCase("fake"))
			Assert.assertTrue(AlertText.contains("incorrect"));
		else
			Assert.assertTrue(AlertText.contains("success"));

	}

	public String loginTest(String usr, String pass) {
		// Login action
		LoginPageObjects login = new LoginPageObjects(driver);
		login.getEmailBox().sendKeys(usr);
		login.getPassBox().sendKeys(pass);
		login.getLoginBtn().click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		return login.getAlert().getText();

	}

	@DataProvider(name = "userdp")
	public Object[][] dataProvider() {

		List<List<String>> ls = ExcelData.getDate();
		Object[][] data = new Object[ls.size()][ls.get(0).size()];

		for (int i = 0; i < ls.size(); i++) {
			for (int j = 0; j < ls.get(0).size(); j++) {
				data[i][j] = ls.get(i).get(j);
			}
		}
		return data;
	}

	@AfterMethod
	public void methodSettlement() {
		driver.quit();
	}
	@AfterTest
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}

}

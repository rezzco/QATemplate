package com.github.rezzco.QATemplate;

import java.time.Duration;
import java.util.List;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ErrorHandling.InternalExceptions;
import PageObjects.LandingPageObjects;
import PageObjects.LoginPageObjects;

public class HomePage extends Base {

	@BeforeTest
	public void InitialSteps() {
		
	}

	@Test(dataProvider = "userdp")
	public void basePageNavigation(String username, String password, String testType) throws InternalExceptions {
		driver = initializeWebDriver();
		driver.get(getProps().getProperty("url"));
		LandingPageObjects lp = new LandingPageObjects(driver);
		lp.loginBtn().click();
		String AlertText = loginTest(username, password);
		if(testType.equalsIgnoreCase("fake"))
			Assert.assertTrue(AlertText.contains("incorrect"));
		else
			Assert.assertTrue(AlertText.contains("success"));
		
		driver.quit();
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

}
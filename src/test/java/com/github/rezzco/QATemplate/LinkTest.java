package com.github.rezzco.QATemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ErrorHandling.InitializationFailedException;
import PageObjects.GeneralPageObjects;

public class LinkTest extends Base{
	public WebDriver driver;

	String [] pageUrls; 
	public LinkTest() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeTest
	public void initializationStage() throws InitializationFailedException {
		

		
		driver = initializeWebDriver();
		GlobalProperties.readPropsFile();
		pageUrls= GlobalProperties.getProperty("linkTestUrls").split(",");
		
	}
	@Test
	public void pageLinkTest() throws Exception {
		logger.info("Before Test Thread Number Is " + Thread.currentThread().getId());
		for(String url : pageUrls) {
			driver.get(url);
			GeneralPageObjects gpo = new GeneralPageObjects(driver);
			for (WebElement el :gpo.getlinks()) {
				Assert.assertTrue(validLink(el));
				if(!validLink (el))
					logger.error("Link connectivity error");
			}
			
		}
	}

	private boolean validLink(WebElement el) throws Exception, Exception {
		// TODO Auto-generated method stub		
		int response = getStatusCode(el.getAttribute("href"));
		if (response>400)
			return false;
		return true;
	}
	private int getStatusCode(String url) throws Exception, IOException {
		
		HttpURLConnection connection= (HttpURLConnection)new URL(url).openConnection();
		connection.setRequestMethod("HEAD");
		connection.connect();
				return connection.getResponseCode();
	}
	
	@Test
	public void checkTitle() throws InitializationFailedException {
		driver.get(getProperty("url"));
		Assert.assertTrue( driver.getTitle().equals("some tour name"));
		
	}
	
	@AfterTest
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}

}

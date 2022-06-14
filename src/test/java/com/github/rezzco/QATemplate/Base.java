package com.github.rezzco.QATemplate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Base class that all Test cases would refer to in order to perform their shared tasks 
 * */
public class Base {
	private static WebDriver _driver;

	public WebDriver initializeWebDriver(DriverType browserType) {
		Properties props = new Properties();
		try {
			String propsFilePath = System.getProperty("user.dir") + "\\data.properties";
			FileInputStream fis = new FileInputStream(propsFilePath);
			try {
				props.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch (browserType) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", props.getProperty("chrome"));
			_driver = new ChromeDriver();
			break;
		case FIREFOX:
			System.setProperty("webdriver.firefox.driver", props.getProperty("firefox"));
			_driver = new ChromeDriver();
			break;
		case EDGE:
			System.setProperty("webdriver.edge.driver", props.getProperty("edge"));
			_driver = new ChromeDriver();
			break;

		default:
			System.setProperty("webdriver.chrome.driver", props.getProperty("chrome"));
			_driver = new ChromeDriver();
			break;	
			}
		return _driver;
	}
}

package com.github.rezzco.QATemplate;


import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ErrorHandling.InitializationFailedException;

/*
 * Base class that all Test cases would refer to in order to perform their shared tasks 
 * */
public abstract class Base {
	private WebDriver driver;
	private Properties props;
	public static Logger logger =  LogManager.getLogger(Base.class);
	public WebDriver getDriver() {
		return driver;
	}

	public Properties getProps() {
		return props;
	}
	public String getProperty(String p) throws InitializationFailedException {
		return GlobalProperties.getProperty(p);
	}

	public WebDriver initializeWebDriver() throws InitializationFailedException {

		String propsFilePath = System.getProperty("user.dir") + "\\resources\\data.properties";
		props = GlobalProperties.readPropsFile(propsFilePath);
		String browserType = GlobalProperties.getProperty("browser");
		switch (browserType) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", props.getProperty("chrome"));
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver", props.getProperty("firefox"));
			driver = new FirefoxDriver();
			break;
		case "EDGE":
			System.setProperty("webdriver.edge.driver", props.getProperty("edge"));
			driver = new ChromeDriver();
			break;
		case "ANDROID":
			System.setProperty("webdriver.android.driver", props.getProperty("android"));
			driver = new ChromeDriver();
			break;
		case "SAFARI":
			System.setProperty("webdriver.safari.driver", props.getProperty("safari"));
			driver = new ChromeDriver();
			break;
		case "IOS":
			System.setProperty("webdriver.ios.driver", props.getProperty("IOS"));
			driver = new ChromeDriver();
			break;
		case "OPERA":
			System.setProperty("webdriver.opera.driver", props.getProperty("opera"));
			driver = new ChromeDriver();
			break;
		case "CHROMIUM":
			System.setProperty("webdriver.chromium.driver", props.getProperty("chromium"));
			driver = new ChromeDriver();
			break;

		case "EVENTFIREWEBDRIVER":
			System.setProperty("webdriver.evenfire.driver", props.getProperty("evenfire"));
			driver = new ChromeDriver();
			break;

		case "HTMLUNITDRIVER":
			System.setProperty("webdriver.htmlunit.driver", props.getProperty("htmlunit"));
			driver = new ChromeDriver();
			break;

		default:
			System.setProperty("webdriver.chrome.driver", props.getProperty("chrome"));
			driver = new ChromeDriver();
			break;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
}

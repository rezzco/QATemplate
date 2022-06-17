package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPageObjects {

	private WebDriver _driver;
	
	public LandingPageObjects(WebDriver driver) {
		this._driver = driver;
		
	}
	
	By allTours = By .partialLinkText("tours");
	By login = By .xpath("//a[contains(@href,'login')]");
	By signup = By .xpath("//a[contains(@href,'signup')]");

	public WebElement loginBtn() {
		// TODO Auto-generated method stub
		return _driver.findElement(login);
	}

	

}

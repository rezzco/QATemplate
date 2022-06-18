package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavbarPageObjects {

	
private WebDriver _driver;
	
	public NavbarPageObjects(WebDriver driver) {
		this._driver = driver;
		
	}
	
	By allTours = By .partialLinkText("tours");
	By login = By .xpath("//a[contains(@href,'login')]");
	By signup = By .xpath("//a[contains(@href,'signup')]");
	By logout = By .cssSelector("a.nav__el--logout");

	public WebElement loginBtn() {
		// TODO Auto-generated method stub
		return _driver.findElement(login);
	}
	public WebElement logoutBtn() {
		// TODO Auto-generated method stub
		return _driver.findElement(logout);
	}
	public WebElement allToursLink() {
		// TODO Auto-generated method stub
		return _driver.findElement(allTours);
	}
	public WebElement signupBtn() {
		// TODO Auto-generated method stub
		return _driver.findElement(signup);
	}


}

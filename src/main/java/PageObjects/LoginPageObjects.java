package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects extends NavbarPageObjects {

	private WebDriver _driver;

	public LoginPageObjects(WebDriver driver) {
		super(driver);
		this._driver = driver;
		PageFactory.initElements(_driver, this);
	}

	@FindBy(partialLinkText = "All tours")
	WebElement allTours;

	@FindBy(css = "div.alert")
	WebElement alert;
	
	By emailBox = By.id("email");
	By passBox = By.id("password");
	By loginBtn = By.xpath("//button[contains(text(), 'Login')]");

	public WebElement getAllTours() {
		return allTours;
	}
	public WebElement getAlert() {
		return alert;
	}


	public WebElement getEmailBox() {
		return _driver.findElement(emailBox);
	}

	public WebElement getPassBox() {
		return _driver.findElement(passBox);
	}

	public WebElement getLoginBtn() {
		return _driver.findElement(loginBtn);
	}

}

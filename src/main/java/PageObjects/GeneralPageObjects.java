package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneralPageObjects extends NavbarPageObjects{

	private WebDriver driver;
	public GeneralPageObjects(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//main //a")
	private List<WebElement> links;
	
	public List<WebElement> getlinks() {
		return links;
	}
	
}

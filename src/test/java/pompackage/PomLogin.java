package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseHRMClass;

public class PomLogin extends BaseHRMClass {
	//object repository
	@FindBy(name="username")    //driver.findElement(by.
	WebElement Username;
	@FindBy(name="password")
	WebElement Password;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	WebElement Loginbutton;
	
	// initiate page elements
	public PomLogin() {
		PageFactory.initElements(driver,this);
	}
		
	public void typeusername(String name) {
		
		Username.sendKeys(name);
	}
		
	public void typepassword(String pass) {
		Password.sendKeys(pass);
	}
	
	public void clickbtn() {
		Loginbutton.click();
	}
	public String verify() {
		return driver.getTitle();
		
		
	}
	
}



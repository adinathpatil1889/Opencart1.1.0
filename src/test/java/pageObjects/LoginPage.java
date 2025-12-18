package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
//	locator

@FindBy(xpath="//input[@id='input-email']") WebElement txt_email;
@FindBy(xpath="//input[@id='input-password']") WebElement txt_password;
@FindBy(xpath="//input[@value='Login']") WebElement btn_login;

//action

	public void Add_email(String email) {
		txt_email.sendKeys(email);		
	}
	
	public void add_password(String password) {
		txt_password.sendKeys(password);		
	}
	
	public void click_login() {
		btn_login.click();		
	}

	

}

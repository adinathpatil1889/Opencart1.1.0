package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
//1.constructor---so we define constructor in basepage.java class and call from here with super keyword
//	2.locator
//	3.action methods

	public HomePage(WebDriver driver) {
		super(driver);
	}



//locator

@FindBy(xpath="//span[normalize-space()='My Account']") 
WebElement link_My_Account;
@FindBy(xpath="//a[normalize-space()='Register']") 
WebElement link_Register;

@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']") 
WebElement link_login;

//Action
public void clickMYAccount() {
	link_My_Account.click();	
}

public void clickRegister() {
	link_Register.click();	
}

public void clickLogin() {
	link_login.click();	
}



}
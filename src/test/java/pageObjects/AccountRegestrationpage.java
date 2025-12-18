package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//every time new page create extends from the basepage
public class AccountRegestrationpage extends BasePage{
	
	public AccountRegestrationpage(WebDriver driver) {
		super(driver);		
	}
	
	//locator

@FindBy(xpath="//input[@id='input-firstname']") WebElement txt_Firstname;
@FindBy(xpath="//input[@id='input-lastname']") WebElement txt_lastname;
@FindBy(xpath="//input[@id='input-email']") WebElement txt_email;
@FindBy(xpath="//input[@id='input-telephone']") WebElement txt_telephone;
@FindBy(xpath="//input[@id='input-password']") WebElement txt_pwd;
@FindBy(xpath="//input[@id='input-confirm']") WebElement txt_pwdconf;
@FindBy(xpath="//input[@value='Continue']") WebElement btn_continue;
@FindBy(xpath="//input[@name='agree']") WebElement checkbox_Privicy;
@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement confirm_msg;


//Action methods

public void setFirstName(String fname) {
	txt_Firstname.sendKeys(fname);
}

public void setLastName(String lname) {
	txt_lastname.sendKeys(lname);
}

public void setEmail(String email) {
	txt_email.sendKeys(email);
}

public void setTelephone(String telnum) {
	txt_telephone.sendKeys(telnum);
}

public void setPwd(String pwd1) {
	txt_pwd.sendKeys(pwd1);	
}

public void setPwdConf(String pwd2 ) {
	txt_pwdconf.sendKeys(pwd2);	
}

public void check_privicy() {
	checkbox_Privicy.click();	
}

public void click_Continue() {
	btn_continue.click();	
}

public String getConfirmationMsg() {//you cann add the try catch to handle if msg not shows--
	return confirm_msg.getText();
}

}

package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		logger.info("***statting login*****");
	//1st go on the home page	
		try {
		HomePage hp= new HomePage(driver);
		hp.clickMYAccount();
		hp.clickLogin();
		
//		go to login page
		LoginPage lp=new LoginPage(driver);
		lp.Add_email(p.getProperty("email"));//passing keys so it in string format
		lp.add_password(p.getProperty("password"));
		lp.click_login();
		
		//go to my accpunt page to validate
		MyAccountPage map=new MyAccountPage(driver);
		Boolean status=map.isMyAccountPageExist();
		Assert.assertEquals(status,true);
		
		 
		
	}
		catch(Exception e) {
		Assert.fail();
	}
		
		
		}
	
	
	

}

package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
//	we cover =ve and -ve in one round of testting
	
	//data is valid - login success - test pass - logout
	//data is valid -- login failed - test fail
	
//	data is invalid - login success - test fail - logout
//	data is invalid - login failed - test pass
	
//	dat provider methods are the special methods we not extends that class
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DDT")//this for getting data provider class when the class present in other package
	public void verify_DDT(String email, String pwd, String exp) throws InterruptedException 
	{
		logger.info("***TC003statting login*****");
	//1st go on the home page	
		
		HomePage hp= new HomePage(driver);
		hp.clickMYAccount();
		Thread.sleep(3000);
		hp.clickLogin();
		
//		go to login page
		LoginPage lp=new LoginPage(driver);
		lp.Add_email(email);//passing keys so it in string format
		lp.add_password(pwd);
		lp.click_login();
		
		//go to my accpunt page to validate
		MyAccountPage map=new MyAccountPage(driver);
		boolean status=map.isMyAccountPageExist();
		 
//		when data is valid
		if (exp.equalsIgnoreCase("Valid")) {
			if (status==true) {
				Assert.assertTrue(true);
				map.click_logout();
			}else{ 
				Assert.assertTrue(false);
		}

}
		if(exp.equalsIgnoreCase("InValid")) 
		{
			if (status==true)
			{				 
				map.click_logout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
				}
		}
		logger.info("***TC003statting login*****");
		}
	
}

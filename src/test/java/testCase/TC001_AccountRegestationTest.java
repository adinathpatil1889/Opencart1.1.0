package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegestrationpage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegestationTest extends BaseClass   {	
//	every class is single testacse
//	WebDriver driver;--if we use this driver then this is new driver in that no pagefactory classes methods that presentin basevlass.java
//	
//	@BeforeClass
//	void setup() {
//		WebDriverManager.chromedriver().setup();
//	//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\adinath.p\\Downloads\\chromedriver-win64 (3)\\chromedriver-win64\\chromedriver.exe");
//		driver=new ChromeDriver();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://tutorialsninja.com/demo/");
//		driver.manage().window().maximize();
//	}
////	
//	@AfterClass
//	void teardown() {
//		driver.quit();}
	
//	above methods are commonly we use so put in BaseClass.java
		
		
 
	
	@Test(groups={"Regression","Master"})
	void verify_account_regestion() {
		
		logger.info("*** Stating TC001_AccountRegestationTest ***");
		try {
		//to access action methods from the homePgae.java class we need to create object
		HomePage hp=new HomePage(driver);//we need to pass driver becoz we write constructopr
		hp.clickMYAccount();
		logger.info("clicked on the my account");
		
		hp.clickRegister();
		logger.info("clicked on the Register");
		
		AccountRegestrationpage agp=new AccountRegestrationpage(driver);
		
		logger.debug("providing custmers details");
//		agp.setFirstName("adinath");
		agp.setFirstName(random_String().toUpperCase());
//		agp.setLastName("patil");
		agp.setLastName(random_String().toUpperCase());
//		agp.setEmail("adinathpatil1999@gmail.com");//randemonly generate data
		agp.setEmail(random_String()+"@gmail.com");
//		agp.setTelephone("123456");
		agp.setTelephone(random_number());
		agp.setPwd("test@123");
		agp.setPwdConf("test@123");
		agp.check_privicy();
		agp.click_Continue();
		
		logger.info("validating expected msg");
		String conf_msg=agp.getConfirmationMsg();
		if(conf_msg.equals("Your Account Has Been Created!"))
		{
			logger.info("***Your Account Has Been Created***");
		}
		else {
		 
		logger.error("Test failed..");
		logger.debug("Debug logs...");
		Assert.fail();
		}
		}
		catch(Exception e){
		 System.out.println("print exeception"+e);
		}
		logger.info("*** Finish TC001_AccountRegestationTest ***");
	
	}
	
		
	
	//below methods also put in the BaseClass beoz its common
//	String random_String() {
//		//use the built in methods
//		@SuppressWarnings("deprecation")
//		String generatedString=RandomStringUtils.randomAlphabetic(5);
//		return generatedString;
//	}
//
//	String random_number() {
//		//use the built in methods
//		@SuppressWarnings("deprecation")
//		String generatedNumber=RandomStringUtils.randomNumeric(10);
//		return generatedNumber;
//	}
}

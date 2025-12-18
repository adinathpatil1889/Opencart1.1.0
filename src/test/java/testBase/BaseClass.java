package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;   // Log4j
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//exact this package
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;


import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {
	public Logger logger;	
	public WebDriver driver;
	public Properties p;

	@BeforeClass(groups={"Sanity","Regression","Master"})//@BeforeClass is also a method of the testacse--so we add the groups
	//@Parameters({"browser"})
	public void setup() throws IOException {
		//loading config file
		FileInputStream  file=new FileInputStream("src/test/resources/config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());//this autimatically load the log4j2.log 
		
		
//		switch (br.toLowerCase())
//		{
//		    case "chrome":
//		        driver = new ChromeDriver();
//		        break;
//
//		    case "edge":
//		        driver = new EdgeDriver();
//		        break;
//
//		    case "firefox":
//		        driver = new FirefoxDriver();
//		        break;
//
//		    default:
//		        System.out.println("Invalid browser name...");
//		        return;
//		}

		
		WebDriverManager.chromedriver().setup();
	//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\adinath.p\\Downloads\\chromedriver-win64 (3)\\chromedriver-win64\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://tutorialsninja.com/demo/");
		driver.get(p.getProperty("appUrl1"));//reading url from the propertis file
		driver.manage().window().maximize();
	}
	
	
	
	
	
	@AfterClass(groups={"Sanity","Regression","Master"})
	public void teardown() {
		driver.quit();
		}

	public String random_String() {
		//use the built in methods
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String random_number() {
		//use the built in methods
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	
	public String captureScreen(String tname) throws IOException {

	    String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

	    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

	    String targetFilePath = System.getProperty("user.dir") +
	            "\\screenshots\\" + tname + "_" + timeStamp + ".png";

	    File targetFile = new File(targetFilePath);

	    sourceFile.renameTo(targetFile);

	    return targetFilePath;
	}

	
}



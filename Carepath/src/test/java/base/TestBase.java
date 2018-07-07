package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.functions.ExpectedCondition;
import utilities.ExcelReader;
import utilities.ExtentManager;
import utilities.TestUtil_old;


public class TestBase {

	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	//public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	public static SoftAssert myassertion=new SoftAssert();

	@BeforeSuite
	public void setUp() throws Exception  {

		//*****Initializing******* 
		if (driver == null) {
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
					e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			   } catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			   // ******For Jenkins to select browser type************
			       if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty()){
				   browser = System.getenv("browser");
			       }else{
				        browser = config.getProperty("browser");
			            }

			//***** Browser selection**********
			       
			config.setProperty("browser", browser);
			if (config.getProperty("browser").equals("firefox")) {
				  System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
				  driver = new FirefoxDriver();
			}else if (config.getProperty("browser").equals("chrome")) {
			 	 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			  	 driver = new ChromeDriver();
		 	} else if (config.getProperty("browser").equals("ie")) {
				 System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
				 driver = new InternetExplorerDriver();
			}

			//driver.get(config.getProperty("testsiteurl"));
			//log.debug("Navigated to : " + config.getProperty("testsiteurl"));
			//test.log(LogStatus.INFO, "URL opened");
			
			//Thread.sleep(5000);
			//driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
				//	TimeUnit.SECONDS);
			//wait = new WebDriverWait(driver, 5);
		}

	}
	
//************** Reusable Funcations************************	
	public void OpenBrowser(String environment)
	{
		if(config.getProperty("environment").equals("SIT2")){
			driver.get(config.getProperty("SIT2_TestURL"));
		}	
        if(config.getProperty("Portal").equals("DevDox")){  			
			driver.get(config.getProperty("DevDox_TestURL"));
	    }	
    }
	
	
	//****** Click *************
	
	public static void click(String locator) {
	  getElement(locator).click();
	  if (locator.endsWith("_CSS"))
			 test.log(LogStatus.INFO, "Clicked on : " + locator.substring(0, locator.length() -4));
	 else if (locator.endsWith("_XPATH"))
			 test.log(LogStatus.INFO, "Clicked on : " + locator.substring(0, locator.length() -6));
	 else if (locator.endsWith("_ID"))
			 test.log(LogStatus.INFO, "Clicked on : " + locator.substring(0, locator.length() -3));
	}	
	/* try{
		 if (locator.endsWith("_CSS"))
	     		driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		 else if (locator.endsWith("_XPATH")) 
		    	driver.findElement(By.xpath(OR.getProperty(locator))).click();
		 else if (locator.endsWith("_ID")) 
	    	    driver.findElement(By.id(OR.getProperty(locator))).click();
 		  } 
		catch(ElementNotFoundException e) {
			Assert.fail("Locator is not correct" + locator);	
		  }
		test.log(LogStatus.INFO, "Clicking on : " + locator.substring(0, locator.length() -2));
	 } */


	public static WebElement getElement(String locator) {

		WebElement element =null;
		try{
			 if (locator.endsWith("_CSS"))
		     		element=driver.findElement(By.cssSelector(OR.getProperty(locator)));
			 else if (locator.endsWith("_XPATH")) 
			    	element=driver.findElement(By.xpath(OR.getProperty(locator)));
			 else if (locator.endsWith("_ID")) 
				 element=driver.findElement(By.id(OR.getProperty(locator)));
			 else
				 Assert.fail("Locator is not correct" +locator);
	              		 
		  }catch(Exception e) {
				e.printStackTrace();
				Assert.fail("Locator is not correct");
			    //throw new AssertionError("Locator not found",e);
			}
		   return element;
		 }

	
	// ******** type ***************
	
	public static void type(String locator, String value) {
		 
		getElement(locator).sendKeys(value);
		 
		 if (locator.endsWith("_CSS"))
			 
				 test.log(LogStatus.INFO, " At " + locator.substring(0, locator.length() -4) + " field, entered value as " + value);
		 else if (locator.endsWith("_XPATH"))
				 test.log(LogStatus.INFO, " At " + locator.substring(0, locator.length() -6)+ " field, entered value as " + value);

		 else if (locator.endsWith("_ID"))
				 test.log(LogStatus.INFO, " At " + locator.substring(0, locator.length() -3)+ " field, entered value as " + value);
		}
		
	/*try{
		if (locator.endsWith("_CSS")) 
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		else if (locator.endsWith("_XPATH")) 
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		 else if (locator.endsWith("_ID")) 
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		 else
			 Assert.fail("Locator is not correct" +locator);
		
		}catch(Exception e) {
		  	e.printStackTrace();
			Assert.fail("Locator is not correct");
		    //throw new AssertionError("Locator not found",e);
		 } 
			test.log(LogStatus.INFO, "Typing in : " + locator + " entered value as " + value);
		}*/

	
	//***
	public void type_int(String locator, CharSequence[] phone) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(phone);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(phone);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(phone);
		}

		test.log(LogStatus.INFO, "Typing in : " + locator + " entered value as " + phone);

	}
	
	static WebElement dropdown;
	public static void select(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			dropdown = driver.findElement(By.id(OR.getProperty(locator)));
		}
		
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);

		test.log(LogStatus.INFO, "Selecting from dropdown : " + " value as " + value);

	}

	
		
	public boolean isElementPresent(By by) {

		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	
	public static void clickStaleElement(WebDriver driver,String xpath) throws Exception
	{
		for(int i=0;i<=20;i++)
		{
		try
			{		
				driver.findElement(By.xpath(xpath)).click();		
				break;
			}
		catch(Exception e)
			{
				System.out.println(e.getMessage());			
			}
		}
	} 
	
	
   public static void check_checkbox(WebElement locator) {
       boolean checkstatus;
       checkstatus = locator.isSelected();
       if (checkstatus == true) {
          System.out.println("Checkbox is already checked");
       } else {
    	   
       locator.click();
       System.out.println("Checked the checkbox");
       }
      test.log(LogStatus.INFO, "Checking: " + locator);
    }
   
  
		public static void select_radiobutton(WebElement Radio) {
			   boolean checkstatus;
			   checkstatus = Radio.isSelected();
			   if (checkstatus == true) {
				   System.out.println("RadioButton is already checked");
			   } else {
				   Radio.click();
				   System.out.println("Selected the Radiobutton");
			   }
			   test.log(LogStatus.INFO, "Selected: " + Radio);
		   	}

// Unchecking
   	public static void unckeck_checkbox(WebElement checkbox) {
   		boolean checkstatus;
   		checkstatus = checkbox.isSelected();
		if (checkstatus == true) {
		checkbox.click();
		System.out.println("Checkbox is unchecked");
		} else {
			System.out.println("Checkbox is already unchecked");
		}
}

		public static void deselect_radioButton(WebElement Radio) {
				boolean checkstatus;
				checkstatus = Radio.isSelected();
				if (checkstatus == true) {
				Radio.click();
				System.out.println("Radio Button is deselected");
				} else {
				System.out.println("Radio Button was already Deselected");
				}
				}


   public void waitandtype(String locator,String value) {

		  WebDriverWait wait = new WebDriverWait(driver,80);
		 //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(OR.getProperty(locator)))));
		
		 if (locator.endsWith("_CSS")) {
			 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(OR.getProperty(locator))))).sendKeys(value);
			
		    } else if (locator.endsWith("_XPATH")) {
			 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(OR.getProperty(locator))))).sendKeys(value);
			
		    } else if (locator.endsWith("_ID")) {
		    	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(OR.getProperty(locator))))).sendKeys(value);
			}
			test.log(LogStatus.INFO, "Typing in : " + locator + " entered value as " + value);
		}



	public void waittoClick(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		//wait.until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(OR.getProperty(locator)))));
		//element.click();
		}
		
	public void waittotype(String locator) {
		    WebDriverWait wait = new WebDriverWait(driver, 120);
		    wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(OR.getProperty(locator)))));
		    }
		


	
	public static void verifyEquals(String expected, String actual) throws IOException {
		try {
			Assert.assertEquals(actual, expected);
		} catch (Throwable t) {
			TestUtil_old.captureScreenshot();
			test.log(LogStatus.FAIL, " Verification failed with exception : " + t.getMessage());
			test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil_old.screenshotName));
  		  }
    	}

	@AfterSuite
	public void tearDown() {
		//if (driver != null) {
	    //driver.quit();
	}
		//log.debug("test execution completed !!!");
	}
	


	//}

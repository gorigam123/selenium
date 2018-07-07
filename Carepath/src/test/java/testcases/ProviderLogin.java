package testcases;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Iterator;
import com.gargoylesoftware.htmlunit.javascript.host.Set;
import com.google.common.base.Function;
import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;

import utilities.TestUtil;
import utilities.TestUtil_old;
public class ProviderLogin extends TestBase {


	@Test(dataProvider="getData")
	//@Test(dataProvider="getData",dependsOnMethods={"testcases.ProviderRegistration_IndependentSite.provider_reg_IndependentSite"})
	
	public void provider_Login(Hashtable<String,String> data) throws InterruptedException, IOException, AWTException{
		
		if(!(TestUtil.isRunnable("ProviderLogin", excel))){
			throw new SkipException("Skipping the test "+"ProviderLogin" + "as the Run mode is set as NO");
		}
		
       	driver.get(config.getProperty("ProviderURL"));
       	
     	driver.manage().window().maximize();
     	Thread.sleep(30000);
     
     	type("ProviderLogin_Username_XPATH",data.get("Prusername"));
     	Thread.sleep(4000);
    	type("ProviderLogin_Password_XPATH",data.get("Prpassword"));
    	
    	click("ProviderLogin_LoginButton_XPATH");
	   Thread.sleep(20000); 
	    
	    //if(config.getProperty("environment").equals("SIT2")){
	 
	   // Runtime.getRuntime().exec("C:\\Users\\AnandB\\Desktop\\MyProject\\myJohnson\\JanssenCarePath_Framework\\HandleAutheticationWindow.exe");
    	
	     //Runtime.getRuntime().exec(("user.dir")+ "\\src\\test\\resources\\autoit\\HandleAutheticationWindow.exe");
	   
	 	 //}
     
	    	
	Thread.sleep(12000);	 
	//click("ProviderLogoutDropDown_XPATH");
	click("ProviderLogoutDropDown_CSS");
	//Thread.sleep(4000);
	click("ProviderLogout_XPATH");
 } 

	@AfterMethod
	public void cleanup() {
		try{
		myassertion.assertAll();
		
			}
		catch(Error e)
		{
			test.log(LogStatus.FAIL,"Test Case Failed");
			//driver.close();
			
		}
		driver.manage().deleteAllCookies();
	}


@DataProvider
public Object[][] getData() {

	return TestUtil.getProviderData("ProviderLogin");
//return TestUtil.getTestData(xl,"ProviderLogin");

}
}
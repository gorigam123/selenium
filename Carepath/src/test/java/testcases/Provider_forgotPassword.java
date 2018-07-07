package testcases;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil_old;
import utilities.TestUtil;

public class Provider_forgotPassword extends TestBase{

	//@Test(dataProvider="getData")
	@Test(dataProvider="getData",dependsOnMethods={"testcases.ProviderRegistration_IndependentSite.provider_reg_IndependentSite"})
	public void providerforgotpassword(Hashtable<String,String> data) throws InterruptedException, IOException{
		
		driver.get(config.getProperty("ProviderURL"));
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser opened");
		
		Thread.sleep(10000);
		
		
		click("providerforgtpwdLink_XPATH");
		Thread.sleep(10000);
		
		//click("providerforgotpwd_closeButton_XPATH");
			
		  boolean element= driver.findElement(By.xpath(OR.getProperty("providerforgotpwd_closeButton_XPATH"))).isDisplayed();
		    
		  System.out.println(element);

		  if(element==true)
			
			{
			  click("providerforgotpwd_closeButton_XPATH");
              // driver.close();
             
 			}
		
		    // WebElement actual=driver.findElement(By.xpath(OR.getProperty("providerforgotpwd_closeButton_XPATH")));
			
			//WebElement expected=driver.findElement(By.xpath(OR.getProperty("provider_unamefor_forgotpwd_XPATH")));
			
			//myassertion.assertEquals(actual, expected);	  
			/*Boolean actual=isElementPresent(By.xpath(OR.getProperty("provider_unamefor_forgotpwd_XPATH")));
						
			//if(actual==true)
			//{
				//System.out.println("Element present");
				type("provider_unamefor_forgotpwd_XPATH",username);
			}
		
			else
 			
			  {String oldtab=driver.getWindowHandle();
			  ArrayList<String> newtab=new ArrayList<String>(driver.getWindowHandles());
			  driver.switchTo().window(newtab.get(1));
			  Thread.sleep(3000);
			  click("providerforgotpwd_closeButton_XPATH");
			 */
			 // myassertion.fail("Element not found..TC failed");
			  
			//WebElement expected=driver.findElement(By.xpath(OR.getProperty("providerforgotpwd_closeButton_XPATH")));
			//myassertion.assertEquals(actual,expected);
			
		Thread.sleep(4000);
		type("provider_unamefor_forgotpwd_XPATH",data.get("Prusername"));
		Thread.sleep(4000);
		click("providerforgotButton_XPATH");
		Thread.sleep(6000);
		click("provideremailconfirmationButton_XPATH");
		
		  //myassertion.assertAll();
		
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

		return TestUtil.getProviderData("Provider_ForgotPassword");
	}
}

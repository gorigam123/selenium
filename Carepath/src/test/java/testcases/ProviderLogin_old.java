package testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;


import utilities.TestUtil_old;
public class ProviderLogin_old extends TestBase {

     @Test(dataProvider="getData")
	//@Test(dataProvider="getData",dependsOnMethods={"testcases.ProviderRegistration_IndependentSite.provider_reg_IndependentSite"})
	public void provider_Login(Hashtable<String,String> data) throws InterruptedException, IOException{
		
       	driver.get(config.getProperty("ProviderURL"));
     	    	
     	driver.manage().window().maximize();
     	
     	//waitForPageLoad();
     	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     	    	
     	// waitthentype("txtPrUsername_XPATH");
       	   
     	//Thread.sleep(10000);
     	waitandtype("txtPrUsername_XPATH",data.get("Prusername"));
     	    	
     	type("txtPrPassword_XPATH",data.get("Prpassword"));
     
     	waittoClick("ProviderLoginbutton_XPATH");
       	
     	//clickWhenReady(By.xpath(OR.getProperty("ProviderLoginbutton_XPATH")));
     	
     	//click("ProviderLoginbutton_XPATH");
	    //test.log(LogStatus.INFO, "Clicked on Login button");
    	
	   // waitForElement(By.xpath(OR.getProperty("ProviderLogoutDropDown_XPATH")));
	   	
			 
	waittoClick("ProviderLogoutDropDown_XPATH");
	//driver.wait(6);
	//click("ProviderLogout_XPATH");
 } 


	@AfterTest
	public void tearDown() {

		   
		
	}	



@DataProvider
public Object[][] getData() {

return TestUtil_old.getData("ProviderLogin");
//return TestUtil.getTestData(xl,"ProviderLogin");

}
}
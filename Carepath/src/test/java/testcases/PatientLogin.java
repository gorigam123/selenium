package testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import testcases.PatientRegistration;
import utilities.TestUtil_old;
import utilities.TestUtil;

public class PatientLogin extends TestBase {
	
	JavascriptExecutor executor;

	@Test(dataProvider="getData")
	
	//@Test(dataProvider="getData",dependsOnMethods={"testcases.PatientRegistration.patient_registration"})
	public void patient_Login(Hashtable<String,String> data) throws InterruptedException, IOException{
		
        if(!(TestUtil.isRunnable("PatientLogin", excel))){
			
			throw new SkipException("Skipping the test "+ "PatientLogin" + "as the Run mode is NO");
		 }
		
		driver.get(config.getProperty("PatientURL"));		
		driver.manage().window().maximize();
     	
		Thread.sleep(20000);
     	
           /* if(config.getProperty("environment").equals("DevDox"))
            {
        	type("PatientLoginDevDox_username_XPATH",data.get("username"));
        	type("PatientLoginDevDox_password_XPATH",data.get("password"));
        	click("PatientLoginButton_DevDox_XPATH");
        	
        	Thread.sleep(25000);
    		click("PatientMyProfileDevDox_XPATH");
    		Thread.sleep(2000);
    		click("PatientLogout_XPATH");
        }*/
        
       /* else if(config.getProperty("environment").equals("UAT")){
        	Thread.sleep(6000);
        	type("txtPatientUsername_XPATH",data.get("username"));
        	type("txtPatientPassword_XPATH",data.get("password"));
        	Thread.sleep(6000);
        	click("Patientlogin_XPATH");
        	
        	Thread.sleep(30000);
        	click("PatientLogin_MyProfile_XPATH");
    		Thread.sleep(12000);
    		click("PatientLogin_PatientLogoutUAT_XPATH");
        } 
      else 
    	 {      
     */	Thread.sleep(20000);
     	
    	
        type("txtPatientUsername_XPATH",data.get("username"));
     	Thread.sleep(4000);
    	type("txtPatientPassword_XPATH",data.get("password"));
        //Thread.sleep(8000);
    	
        WebElement ele = driver.findElement(By.xpath(OR.getProperty("PatientLogin_LoginButton_XPATH")));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", ele);
        
        //click("PatientLogin_LoginButton_XPATH");
	    
    	 Thread.sleep(32000); 
	    
	    executor = (JavascriptExecutor)driver;
	    String jsScript= "var textarea =document.getElementsByClassName('cJanssenUI_AgreementText2')[0];"
				+ "	textarea.scrollTop=textarea.scrollHeight;"	;		
		
	    executor.executeScript(jsScript);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(100,250)", "");
		
		Thread.sleep(35000);
		//click("PatientLogin_consentCheckbox_XPATH");
		click("PatientLogin_consentCheckbox_CSS");
		Thread.sleep(10000);
		click("PatientcontinueButton_XPATH");
	  
		Thread.sleep(25000);
		click("PatientLogin_MyProfile_XPATH");
		Thread.sleep(8000);
		
		if(config.getProperty("environment").equals("UAT"))
		  {
		  click("PatientLogin_PatientLogoutUAT_XPATH");
		  }
		else
		click("PatientLogin_PatientLogout_XPATH");	
			
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
	//return TestUtil.getData("PatientLogin");
	   return TestUtil.getPatientData("PatientLogin");
  }
}
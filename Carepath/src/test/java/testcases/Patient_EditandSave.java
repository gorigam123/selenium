package testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
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

public class Patient_EditandSave extends TestBase {
	
	JavascriptExecutor executor;

	@Test(dataProvider="getData")
	//@Test(dataProvider="getData",dependsOnMethods={"testcases.PatientLogin.patient_Login"})
	public void patientdetails_editandsave(Hashtable<String,String> data) throws InterruptedException, IOException{
				
		if(!(TestUtil.isRunnable("Patient_EditandSave", excel))){
			throw new SkipException("Skipping the test "+"Patient_EditandSave" + "as the Run mode is set as NO");
		 }
		
         driver.get(config.getProperty("PatientURL"));
         driver.manage().window().maximize();
         Thread.sleep(10000);     
        
       /* if(config.getProperty("environment").equals("DevDox")){
        	type("PatientLoginDevDox_username_XPATH",data.get("username"));
        	type("PatientLoginDevDox_password_XPATH",data.get("password"));
        	click("PatientLoginButton_DevDox_XPATH");
        	Thread.sleep(40000);
        }
        else
        {*/   
          Thread.sleep(15000);
     	  type("txtPatientUsername_XPATH",data.get("username"));
     	  Thread.sleep(4000);
    	  type("txtPatientPassword_XPATH",data.get("password"));
    	
          click("Patientlogin_XPATH");
	      Thread.sleep(40000); 
	    
	    
        click("PatientEditSave_MyProfile_XPATH");
    	Thread.sleep(3000);
		click("PatientEditSave_GotoMyProfile_XPATH");
		Thread.sleep(10000);
		click("PatientEditSave_ContinueButton_XPATH");
		//click("PatientEditSave_Continue_XPATH");
		Thread.sleep(25000);
      		
		
		//Patient_Login_Generic.patient_login_generic(data);
		
		//Patient_Login_Generic login=new Patient_Login_Generic();
	    //login.patient_login_generic(data);
		
	    //Thread.sleep(5000);
		click("PatientEditSave_Edit_XPATH");
		Thread.sleep(3000);
		type("PatientEditSave_PatientAddress_XPATH","36 Cross Road");
		click("PatientEditSave_SaveButton_XPATH");	
		Thread.sleep(15000);
		//click("PatientEditSave_MyProfile1_XPATH");
		click("PatientEditSave_AfterSaveMyProfile_XPATH");
		click("PatientEditSave_Logout_XPATH");
		
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

	return TestUtil.getPatientData("PatientLogin");
}
}
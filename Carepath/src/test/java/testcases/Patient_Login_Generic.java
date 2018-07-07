package testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil_old;
import utilities.TestUtil;



public class Patient_Login_Generic extends TestBase{

	//@Test(dataProvider="getData")
	//@Test(dataProvider="getData",dependsOnMethods={"testcases.PatientRegistration.patient_registration"}
	
	public void patient_login_generic(String username,String password) throws InterruptedException{
					
		
          type("PatientLogin_UserName_XPATH","username");
     	  Thread.sleep(4000);
    	  type("PatientLogin_Password_XPATH","password");
          click("PatientLogin_LoginButton_XPATH");
	      Thread.sleep(8000); 
          click("PatientLogin_MyProfile_XPATH");
    	  Thread.sleep(2000);
		  click("PatientLogin_GotoMyProfile_XPATH");
		  click("PatientLogin_ContinueButton_XPATH");
		
}
}


	

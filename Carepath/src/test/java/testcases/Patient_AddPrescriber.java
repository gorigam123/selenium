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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import testcases.Patient_Login_Generic;
import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil_old;
import utilities.TestUtil;



public class Patient_AddPrescriber extends TestBase {

	JavascriptExecutor executor;

	@Test(dataProvider="getData")
	//@Test(dataProvider="getData",dependsOnMethods={"testcases.PatientLogin.patient_Login"})
	
	public static void patient_addprescriber(Hashtable<String,String> data) throws InterruptedException, IOException{
			
        if(!(TestUtil.isRunnable("Patient_AddPrescriber", excel))){
			
			throw new SkipException("Skipping the test "+"Patient_AddPrescriber" + "as the Run mode is set as NO");
		 }	
       
        driver.get(config.getProperty("PatientURL"));
      //  driver.manage().window().maximize();
        Thread.sleep(30000);
        
        type("AddPrescriber_Username_XPATH",data.get("username"));
        type("AddPrescriber_Password_XPATH",data.get("password"));
        Thread.sleep(10000);
        click("AddPrescriber_login_XPATH");
        Thread.sleep(35000);
        
        click("AddPrescriber_MyProfile_XPATH");
    	Thread.sleep(2000);
		click("AddPrescriber_GotoMyProfile_XPATH");
		click("AddPrescriber_ContinueButton_XPATH");
		Thread.sleep(30000);
		
		
		//Patient_Login_Generic login=new Patient_Login_Generic();
	    //login.patient_login_generic(data);
		
		//Patient_Login_Generic.patient_login_generic(data);
		
		//Thread.sleep(10000);
		click("Patient_Accmgnt_TreatmentInfo_XPATH");
		Thread.sleep(8000);
		click("Patient_Accmgnt_Addprescriber_XPATH");
		Thread.sleep(4000);
		click("Patient_Accmgnt_Prescinfo_XPATH");
				Thread.sleep(2000);				
				type("Patient_Accmgnt_PrescFname_XPATH",data.get("PrescriberFirstName"));
				type("Patient_Accmgnt_PrescMi_XPATH",data.get("MI"));
				type("Patient_Accmgnt_PrescLname_XPATH",data.get("PrescriberLastName"));
				select("Patient_Accmgnt_PrescSuffix_XPATH",data.get("Suffix"));
				
				/*JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(100,250)", "");*/				
				
				Thread.sleep(10000);	
				select("Patient_Accmgnt_PrescSpeciality_XPATH",data.get("Specialty"));
				type("Patient_Accmgnt_Pracname_XPATH",data.get("PracticeName"));
				type("Patient_Accmgnt_PrescAddress_XPATH",data.get("Address1"));
				type("Patient_Accmgnt_PrescCity_XPATH",data.get("City"));
				type("Patient_Accmgnt_PrescState_XPATH",data.get("State"));
				
				type("Patient_Accmgnt_PrescZipcode_XPATH",data.get("Zip"));
				type("Patient_Accmgnt_PrescPhone_XPATH",data.get("Phone"));		
				
				Thread.sleep(4000);
				select("Patient_Accmgnt_PhoneType_XPATH",data.get("phonetype"));
				//type("Patient_Accmgnt_PrescPhone_XPATH",data.get("Phone"));		
				Thread.sleep(6000);
				
				type("Patient_Accmgnt_PrescFax_XPATH",data.get("Fax"));
				
				// jse.executeScript("window.scrollBy(100,250)", "");
				
				Thread.sleep(14000);
				click("Patient_Accmgnt_PresSave_XPATH");
				Thread.sleep(15000);
				click("Patient_Accmgnt_myProfile_XPATH");
				Thread.sleep(5000);
				click("Patient_Accmgnt_logut_XPATH");
				
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

	//return TestUtil.getData("AddPrescriber");
		return TestUtil.getPatientData("AddPrescriber");
	}
}


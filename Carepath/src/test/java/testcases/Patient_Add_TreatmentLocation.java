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

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil_old;
import utilities.TestUtil;



public class Patient_Add_TreatmentLocation extends TestBase {

	JavascriptExecutor executor;

	//@Test(dataProvider="getData")
	@Test(dataProvider="getData",dependsOnMethods={"testcases.Patient_AddPrescriber.patient_addprescriber"})
	
	public void patient_add_treatmentlocation(Hashtable<String,String> data) throws InterruptedException, IOException{
		
		if(!(TestUtil.isRunnable("Patient_Add_TreatmentLocation", excel))){
			
			throw new SkipException("Skipping the test "+"Patient_Add_TreatmentLocation" + "as the Run mode is set as NO");
		}
		
		
      	driver.get(config.getProperty("PatientURL"));
        driver.manage().window().maximize();
        Thread.sleep(25000);
        type("Patient_AddTreatmentLocation_Username_XPATH",data.get("TLusername"));
        type("Patient_AddTreatmentLocation_Password_XPATH",data.get("TLpassword"));
        Thread.sleep(10000);
        click("Patient_AddTreatmentLocation_login_XPATH");
        Thread.sleep(30000);
        
        
        click("Patient_AddTreatmentLocation_MyProfile_XPATH");
    	Thread.sleep(2000);
		click("Patient_AddTreatmentLocation_GotoMyProfile_XPATH");
		Thread.sleep(5000);
		click("Patient_AddTreatmentLocation_ContinueButton_XPATH");
		Thread.sleep(25000);
		
		
		// Patient_Login_Generic.patient_login_generic(data);
		// Thread.sleep(5000);
		 
		 click("Patient_Accmgnt_TreatmentInfo_XPATH");
			Thread.sleep(10000);
			   click("Patient_AddTreatmentLocation_Button_XPATH");
		       Thread.sleep(16000);
		        select("Patient_AddTreatmentLocationTyype_XPATH",data.get("locationtype"));
		 		
		        click("Patient_EnterTreatmentLocationRadio_XPATH");
		        type("Patient_AddTreatmentLocation_PracticeName_XPATH",data.get("practicename"));
		        type("Patient_AddTreatmentLocation_ProviderFName_XPATH",data.get("providerfirstname"));
		        type("Patient_AddTreatmentLocation_ProviderLName_XPATH",data.get("providerlastname"));
		        select("Patient_AddTreatmentLocation_ProviderSuffix_XPATH",data.get("suffix"));
		        type("Patient_AddTreatmentLocation_ProviderAddress_XPATH",data.get("address"));
		        type("Patient_AddTreatmentLocation_ProviderCity_XPATH",data.get("city"));
		        
		        type("Patient_AddTreatmentLocation_ProviderState_XPATH",data.get("state"));
		        type("Patient_AddTreatmentLocation_ProviderZipCode_XPATH",data.get("zip"));
		        type("Patient_AddTreatmentLocation_ProviderSitePhone_XPATH",data.get("sitephone"));
		        type("Patient_AddTreatmentLocation_ProviderPhoneType_XPATH",data.get("sitephonetype"));
		       
		        type("Patient_AddTreatmentLocation_ProviderSiteFax_XPATH",data.get("sitefax"));
			       
		        Thread.sleep(15000);
		        		        
				click("Patient_AddTreatmentLocationSaveButton_XPATH");
		       
		        Thread.sleep(10000);
		        click("Patient_AddTreatmentLocation_MyProfileAfterSave_XPATH");
		        Thread.sleep(5000);
		        click("Patient_AddTreatmentLocation_logut_XPATH");
		        
		       
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

	return TestUtil.getPatientData("PatientAddTreatmentLocation");

}
}

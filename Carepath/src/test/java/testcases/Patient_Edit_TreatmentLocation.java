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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil_old;
import utilities.TestUtil;



public class Patient_Edit_TreatmentLocation extends TestBase {

	JavascriptExecutor executor;

	//@Test(dataProvider="getData")
	@Test(dataProvider="getData",dependsOnMethods={"testcases.Patient_Add_TreatmentLocation.patient_add_treatmentlocation"})
	
	public void patient_edit_treatmentlocation(Hashtable<String,String> data) throws InterruptedException, IOException{
					
		if(!(TestUtil.isRunnable("Patient_Edit_TreatmentLocation", excel))){
			throw new SkipException("Skipping the test "+"Patient_Edit_TreatmentLocation" + "as the Run mode is set as NO");
		 }
		
      	driver.get(config.getProperty("PatientURL"));
        driver.manage().window().maximize();
        Thread.sleep(25000);
        type("Patient_EditTreatmentLocation_Username_XPATH",data.get("TLusername"));
        type("Patient_EditTreatmentLocation_Password_XPATH",data.get("TLpassword"));
        Thread.sleep(10000);
        click("Patient_EditTreatmentLocation_login_XPATH");
        Thread.sleep(30000);
        
        
        click("Patient_EditTreatmentLocation_MyProfile_XPATH");
    	Thread.sleep(2000);
		click("Patient_EditTreatmentLocation_GotoMyProfile_XPATH");
		Thread.sleep(5000);
		click("Patient_EditTreatmentLocation_ContinueButton_XPATH");
		Thread.sleep(25000);
		
		
		// Patient_Login_Generic.patient_login_generic(data);
		// Thread.sleep(5000);
		 
		 click("Patient_EditTreatmentLocation_TreatmentInfo_XPATH");
			Thread.sleep(10000);
			  
		      
			click("Patient_EditTreatmentLocation_EditButton_XPATH");
			Thread.sleep(4000);
			type("Patient_EditTreatmentLocation_EditField_XPATH",data.get("editpracticename"));
			
			click("Patient_EditTreatmentLocation_EditSaveButton_XPATH");
		    Thread.sleep(10000);
		    
		    click("Patient_EditTreatmentLocation_MyProfileAfterSave_XPATH");
		    Thread.sleep(5000);
		    click("Patient_EditTreatmentLocation_logut_XPATH");
		 
		   // myassertion.assertAll();	        
		       
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

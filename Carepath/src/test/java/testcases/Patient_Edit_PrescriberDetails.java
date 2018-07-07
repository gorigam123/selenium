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



public class Patient_Edit_PrescriberDetails extends TestBase {

	JavascriptExecutor executor;

	//@Test(dataProvider="getData")
	@Test(dataProvider="getData",dependsOnMethods={"testcases.Patient_AddPrescriber.patient_addprescriber"})
	
	public void patient_editprescriber(Hashtable<String,String> data) throws InterruptedException, IOException{
			
		 if(!(TestUtil.isRunnable("Patient_Edit_PrescriberDetails", excel))){
				
				throw new SkipException("Skipping the test "+"Patient_Edit_PrescriberDetails" + "as the Run mode is set as NO");
			 }	
	       
       	driver.get(config.getProperty("PatientURL"));
        driver.manage().window().maximize();
        Thread.sleep(25000);
        type("txtPatientUsername_XPATH",data.get("username"));
        type("txtPatientPassword_XPATH",data.get("password"));
        Thread.sleep(10000);
        click("Patientlogin_XPATH");
        Thread.sleep(35000);
        
        click("PatientEditPrescriberDetails_MyProfile_XPATH");
    	Thread.sleep(2000);
		click("PatientEditPrescriberDetails_GotoMyProfile_XPATH");
		click("PatientEditPrescriberDetails_ContinueButton_XPATH");
		Thread.sleep(20000);
		
		
		// Patient_Login_Generic.patient_login_generic(data);
		 Thread.sleep(5000);
		click("Patient_Accmgnt_TreatmentInfo_XPATH");
	    Thread.sleep(10000);
			
			click("Patient_EditPrescriberDetails_XPATH");
			
			Thread.sleep(15000);
			
		//	click("Patient_EditPrescriberDetails_MN_XPATH");
			driver.findElement(By.xpath(OR.getProperty("Patient_EditPrescriberDetails_MN_XPATH"))).clear();
			type("Patient_EditPrescriberDetails_MN_XPATH",data.get("middlename"));
			
			//type("Patient_EditPrescriberDetails_SitePhoneType_XPATH",data.get("phonetype"));
								
			click("Patient_SavePrescriberDetails_XPATH");
			
			Thread.sleep(8000);
			click("Patient_EditPrescriberDetails_myProfile_XPATH");
			Thread.sleep(3000);
			click("Patient_EditPrescriberDetails_logut_XPATH");
				
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
		public Object[][] getData(){
			return TestUtil.getPatientData("EditPrescriberDetails");
		}}
		

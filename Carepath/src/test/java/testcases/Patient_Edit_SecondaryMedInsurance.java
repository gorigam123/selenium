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



public class Patient_Edit_SecondaryMedInsurance extends TestBase {

	JavascriptExecutor executor;

	@Test(dataProvider="getData")
	//@Test(dataProvider="getData",dependsOnMethods={"testcases.PatientLogin.patient_Login"})
	
	public void patient_edit_secMedInsurance(Hashtable<String,String> data) throws InterruptedException, IOException{
					
		if(!(TestUtil.isRunnable("Patient_Edit_SecondaryMedInsurance", excel))){
			throw new SkipException("Skipping the test "+"Patient_Edit_SecondaryMedInsurance" + "as the Run mode is set as NO");
		 }
		
		
        driver.get(config.getProperty("PatientURL"));
      //  driver.manage().window().maximize();
        Thread.sleep(30000);
        type("Patient_AddSecMedInsurance_Username_XPATH",data.get("username"));
        Thread.sleep(10000);
        type("Patient_AddSecMedInsurance_Password_XPATH",data.get("password"));
        Thread.sleep(10000);
        click("Patient_AddSecMedInsurance_login_XPATH");
        Thread.sleep(30000);
        
        click("Patient_AddSecMedInsurance_MyProfile_XPATH");
    	Thread.sleep(2000);
		click("Patient_AddSecMedInsurance_GotoMyProfile_XPATH");
		Thread.sleep(5000);
		click("Patient_AddSecMedInsurance_ContinueButton_XPATH");
		Thread.sleep(20000);
		
		
		// Patient_Login_Generic.patient_login_generic(data);
		 Thread.sleep(5000);
		 
		click("Patient_AddSecMedInsuranceTab_XPATH");
		Thread.sleep(10000);
		click("Patient_AddSecMedInsuranceButton_XPATH");
		Thread.sleep(16000);
		       		
				type("Patient_AddSecMedInsurance_Insurer_XPATH",data.get("Insurer"));
				type("Patient_AddSecMedInsurance_PhoneNo_XPATH",data.get("phone"));
				select("Patient_AddSecMedInsurance_PhoneType_XPATH",data.get("phonetype"));
				type("Patient_AddSecMedInsurance_CardHolderFName_XPATH",data.get("Cardholderfname"));
				type("Patient_AddSecMedInsurance_CardHolderLName_XPATH",data.get("Cardholderlname"));
				type("Patient_AddSecMedInsurance_CardHolderDOM_XPATH",data.get("CardholderDOM"));
				type("Patient_AddSecMedInsurance_CardHolderDOD_XPATH",data.get("Cardholderbirthday"));
				type("Patient_AddSecMedInsurance_CardHolderDOY_XPATH",data.get("CardholderbirthYear"));
				Thread.sleep(5000);
				select("Patient_AddSecMedInsurance_Relationship_XPATH",data.get("RelationshiptoCardholder"));
				type("Patient_AddSecMedInsurance_Policyno_XPATH",data.get("PolicyNo"));
				type("Patient_AddSecMedInsurance_GroupNo_XPATH",data.get("GroupNo"));
				
				Thread.sleep(7000);
				click("Patient_AddSecMedInsurance_SaveButton_XPATH");
				Thread.sleep(15000);
				click("Patient_AddSecMedInsurance_AfterSave_MyProfile_XPATH");
				
				click("Patient_AddSecMedInsurance_Logut_XPATH");
				
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

	return TestUtil.getPatientData("EditSecondaryInsurance");

}
}

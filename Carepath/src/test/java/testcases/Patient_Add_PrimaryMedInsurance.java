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



public class Patient_Add_PrimaryMedInsurance extends TestBase {

	JavascriptExecutor executor;

	@Test(dataProvider="getData")
	//@Test(dataProvider="getData",dependsOnMethods={"testcases.PatientLogin.patient_Login"})
	
	public void patient_add_primaryInsurance(Hashtable<String,String> data) throws InterruptedException, IOException{
	
     if(!(TestUtil.isRunnable("Patient_Add_PrimaryMedInsurance", excel))){
			
			throw new SkipException("Skipping the test "+"Add Primary Insurance" + "as the Run mode is set as NO");
		}
		
        driver.get(config.getProperty("PatientURL"));
        driver.manage().window().maximize();
        Thread.sleep(30000);
        type("Patient_AddPrimaryMedInsurance_Username_XPATH",data.get("username"));
        Thread.sleep(10000);
        type("Patient_AddPrimaryMedInsurance_Password_XPATH",data.get("password"));
        Thread.sleep(10000);
        click("Patient_AddPrimaryMedInsurance_login_XPATH");
        Thread.sleep(30000);
        
        click("Patient_AddPrimaryMedInsurance_MyProfile_XPATH");
    	Thread.sleep(2000);
		click("Patient_AddPrimaryMedInsurance_GotoMyProfile_XPATH");
		Thread.sleep(5000);
		click("Patient_AddPrimaryMedInsurance_ContinueButton_XPATH");
		Thread.sleep(20000);
		
		
		// Patient_Login_Generic.patient_login_generic(data);
		 Thread.sleep(5000);
		 
		click("Patient_AddPrimaryMedInsurance_XPATH");
		Thread.sleep(10000);
		click("Patient_AddPrimaryMedInsuranceButton_XPATH");
		Thread.sleep(16000);
		       		
				type("Patient_AddPrimaryMedInsuranceInsurer_XPATH",data.get("Insurer"));
				type("Patient_AddPrimaryMedInsurancePhoneNo_XPATH",data.get("phone"));
				select("Patient_AddPrimaryMedInsurancePhoneType_XPATH",data.get("phonetype"));
				type("Patient_AddPrimaryMedInsuranceCardHolderFName_XPATH",data.get("Cardholderfname"));
				type("Patient_AddPrimaryMedInsuranceCardHolderLName_XPATH",data.get("Cardholderlname"));
				type("Patient_AddPrimaryMedInsuranceCardHolderDOM_XPATH",data.get("CardholderDOM"));
				type("Patient_AddPrimaryMedInsuranceCardHolderDOD_XPATH",data.get("Cardholderbirthday"));
				type("Patient_AddPrimaryMedInsuranceCardHolderDOY_XPATH",data.get("CardholderbirthYear"));
				Thread.sleep(5000);
				select("Patient_AddPrimaryMedInsuranceRelationship_XPATH",data.get("RelationshiptoCardholder"));
				type("Patient_AddPrimaryMedInsurancePolicyno_XPATH",data.get("PolicyNo"));
				type("Patient_AddPrimaryMedInsuranceGroupNo_XPATH",data.get("GroupNo"));
				
				Thread.sleep(7000);
				click("Patient_AddPrimaryMedInsuranceSaveButton_XPATH");
				Thread.sleep(15000);
				click("Patient_AddPrimaryMedInsurance_AfterSave_MyProfile_XPATH");
				
				click("Patient_AddPrimayMedInsurance_Logut_XPATH");
				
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

return TestUtil.getPatientData("AddPrimaryInsurance");	

}
}

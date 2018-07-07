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



public class Patient_Edit_PrimaryMedInsurance extends TestBase {

	JavascriptExecutor executor;

	//@Test(dataProvider="getData")
	@Test(dataProvider="getData",dependsOnMethods={"testcases.Patient_Add_PrimaryMedInsurance.patient_add_primaryInsurance"})
	
	public void patient_edit_primaryMedInsurance(Hashtable<String,String> data) throws InterruptedException, IOException{
					
		 if(!(TestUtil.isRunnable("Patient_Edit_PrimaryMedInsurance", excel))){
				
				throw new SkipException("Skipping the test "+"Patient_Edit_PrimaryMedInsurance" + "as the Run mode is set as NO");
			 }
		
        driver.get(config.getProperty("PatientURL"));
        driver.manage().window().maximize();
        Thread.sleep(30000);
        type("Patient_EditPrimaryMedInsurance_Username_XPATH",data.get("username"));
        Thread.sleep(10000);
        type("Patient_EditPrimaryMedInsurance_Password_XPATH",data.get("password"));
        Thread.sleep(10000);
        click("Patient_EditPrimaryMedInsurance_login_XPATH");
        Thread.sleep(30000);
        
        click("Patient_EditPrimaryMedInsurance_MyProfile_XPATH");
    	Thread.sleep(2000);
		click("Patient_EditPrimaryMedInsurance_GotoMyProfile_XPATH");
		Thread.sleep(5000);
		click("Patient_EditPrimaryMedInsurance_ContinueButton_XPATH");
		Thread.sleep(20000);
		
		
		// Patient_Login_Generic.patient_login_generic(data);
		 Thread.sleep(5000);
		 
		click("Patient_EditPrimaryMedInsuranceTab_XPATH");
		Thread.sleep(10000);
		click("Patient_EditPrimaryMedInsurance_EditButton_XPATH");
		Thread.sleep(16000);
		       		
		        driver.findElement(By.xpath(OR.getProperty("Patient_EditPrimaryMedInsurance_EditInsurer_XPATH"))).clear();
				type("Patient_EditPrimaryMedInsurance_EditInsurer_XPATH",data.get("Insurer"));
				driver.findElement(By.xpath(OR.getProperty("Patient_EditPrimaryMedInsurance_EditPhone_XPATH"))).clear();
				type("Patient_EditPrimaryMedInsurance_EditPhone_XPATH",data.get("phone"));
				
				Thread.sleep(7000);
				click("Patient_EditPrimaryMedInsuranceSaveButton_XPATH");
				Thread.sleep(15000);
				click("Patient_EditPrimaryMedInsurance_AfterSave_MyProfile_XPATH");
				
				click("Patient_EditPrimayMedInsurance_Logut_XPATH");
				
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

	return TestUtil.getPatientData("EditPrimaryInsurance");

}
}

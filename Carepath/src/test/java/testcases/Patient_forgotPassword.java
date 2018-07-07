package testcases;

import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil_old;
import utilities.TestUtil;

public class Patient_forgotPassword extends TestBase{

	//@Test(dataProvider="getData")
	@Test(dataProvider="getData",dependsOnMethods={"testcases.PatientLogin.patient_Login"})
	public void patientforgotpassword(Hashtable<String,String> data) throws InterruptedException, IOException{
		
		if(!(TestUtil.isRunnable("Patient_forgotPassword", excel))){
			throw new SkipException("Skipping the test "+"Patient_forgotPassword" + "as the Run mode is set as NO");
		 }
		
		driver.get(config.getProperty("PatientURL"));
		Thread.sleep(20000);
		click("patientforgotpassword_XPATH");
	    Thread.sleep(4000);
		type("patientforgotuser_XPATH",data.get("username"));
	 // driver.findElement(By.xpath(OR.getProperty(""))).sendKeys(username);
		
	    //type("patientforgotuser_XPATH",username);
		click("forgotbutton_XPATH");
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    
		Thread.sleep(6000);
		click("forgotclosebutton_XPATH");
		
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

	//return TestUtil.getData("forgotPassword");
		return TestUtil.getPatientData("Patient_ForgotPassword");
		
	}
}

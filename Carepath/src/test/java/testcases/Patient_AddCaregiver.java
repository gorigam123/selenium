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
import org.openqa.selenium.interactions.Actions;
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

public class Patient_AddCaregiver extends TestBase {
	
	JavascriptExecutor executor;

	@Test(dataProvider="getData")
   //@Test(dataProvider="getData",dependsOnMethods={"testcases.PatientLogin.patient_Login"})
	
	 public void patient_addCaregiver(Hashtable<String,String> data) throws InterruptedException, IOException{
		

		if(!(TestUtil.isRunnable("Patient_AddCaregiver", excel))){
			
			throw new SkipException("Skipping the test "+"Patient_AddCaregiver" + "as the Run mode is set as NO");
		}	
		
      	 driver.get(config.getProperty("PatientURL"));
       //  driver.manage().window().maximize();
         Thread.sleep(12000);
        
       /* if(config.getProperty("environment").equals("DevDox")){
        	type("PatientLoginDevDox_username_XPATH",data.get("CGusername"));
        	type("PatientLoginDevDox_password_XPATH",data.get("CGpassword"));
        	click("PatientLoginButton_DevDox_XPATH");
        	Thread.sleep(40000);
        }
        else
        {*/ 
        	//Thread.sleep(15000);
     	   type("AddCaregiver_Username_XPATH",data.get("CGusername"));
     	   Thread.sleep(4000);
    	   type("AddCaregiver_Password_XPATH",data.get("CGpassword"));
           click("AddCaregiver_login_XPATH");
	       Thread.sleep(32000); 
         
        
    	click("PatientEditSave_MyProfile_XPATH");
    	Thread.sleep(2000);
		click("AddCaregiver_GotoMyProfile_XPATH");
		Thread.sleep(10000);
		click("AddCaregiver_ContinueButton_XPATH");
		Thread.sleep(10000);
		
		//Patient_Login_Generic.patient_login_generic(data);
    	//Thread.sleep(5000);
	    
		//Patient_Login_Generic login=new Patient_Login_Generic();
	    //login.patient_login_generic();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(120,250)", "");
		Thread.sleep(7000);
		
		click("AddCaregiverButton_XPATH");
		Thread.sleep(3000);
		type("AddCaregiver_firstname_XPATH",data.get("CGfirstname"));
		type("AddCaregiver_Middlename_XPATH",data.get("CGmiddlename"));
		type("AddCaregiver_LastName_XPATH",data.get("CGlastname"));
		Thread.sleep(5000);
		select("AddCaregiver_Suffix_XPATH",data.get("CGsuffix"));
		type("AddCaregiver_Email_XPATH",data.get("CGemail"));
		type("AddCaregiver_Phone_XPATH",data.get("Cgphone"));
		Thread.sleep(9000);
		select("AddCaregiver_Relationship_XPATH",data.get("CGrelationship"));
		Thread.sleep(20000);
		
		
	
		click("AddCaregiver_SaveButton_XPATH");
		
     /*WebElement savebutton = driver.findElement(By.xpath(OR.getProperty("AddCaregiver_SaveButton_XPATH")));
		Actions action = new Actions(driver);
		action.moveToElement(savebutton).click().perform();	
	 */
		Thread.sleep(12000);
		 click("AddCaregiver_MyProfile_XPATH");
		 Thread.sleep(4000);
		 click("AddCaregiver_Logout_XPATH");
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

	return TestUtil.getPatientData("PatientCGiver");
 }
}

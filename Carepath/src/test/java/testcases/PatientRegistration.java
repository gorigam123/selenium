package testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil_old;
import utilities.TestUtil;

public class PatientRegistration extends TestBase{

	static Random rad = new Random();
	//String mailid="PatrickJohn"+rad.nextInt(1000)+"@mailinator.com";
	//String Patientmailid="darensam456+"+rad.nextInt(2000)+"@gmail.com";
	JavascriptExecutor executor;
		

	@Test(dataProvider="getData")
	public void patient_registration(Hashtable<String,String> data)throws Exception{
	
	
      if(!(TestUtil.isRunnable("PatientRegistration", excel))){
			
			throw new SkipException("Skipping the test "+"PatientRegistration" + "as the Run mode is set as NO");
		}
		
		driver.get(config.getProperty("PatientURL"));		
		driver.manage().window().maximize();
		Thread.sleep(10000);
		if(config.getProperty("environment").equals("DevDox")){
			
			click("PatientRegistration_signup_XPATH");
			Thread.sleep(15000);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(150,250)", "");
			click("PatientReg_IamAPatient_XPATH");
			}
		else 
		  {
				
			Thread.sleep(22000);
			click("PatientReg_Signup_XPATH");
			Thread.sleep(14000);
			click("PatientReg_IamAPatient_XPATH");
			  
			
	       }
	    //click("IamAPatient_XPATH");
		        Thread.sleep(8000);
				JavascriptExecutor jse = (JavascriptExecutor)driver;		
				executor = (JavascriptExecutor)driver;	
				jse.executeScript("window.scrollBy(100,250)", "");
				
				//inner window-scrolling down
				String jsScript= "var textarea =document.getElementsByClassName('cJanssenUI_AgreementText2')[0];"
						+ "	textarea.scrollTop=textarea.scrollHeight;"	;		
				executor.executeScript(jsScript);
				Thread.sleep(10000);
				//click("Ackldge1_XPATH");
				click("PatientReg_ConsentCheckbox_CSS");
				
				Thread.sleep(5000);
				//click("Ackldge2_XPATH");
				click("PatientReg_ConsentCheckbox_NotMinor_XPATH");
				click("PateintReg_AckldgeNxtBtn_XPATH");
				
				Thread.sleep(5000);
				
				click("ProductSelection_Remicade_XPATH");
				click("ProductSelection_Simponi_XPATH");
				
															
				Thread.sleep(4000);
				
				JavascriptExecutor jsec = (JavascriptExecutor)driver;		
				jsec.executeScript("window.scrollBy(190,250)", "");
				Thread.sleep(14000);

				click("productNextButton_XPATH");
		     	Thread.sleep(25000);
	
		     type("PatientReg_firstname_XPATH",data.get("FirstName"));
		     type("PatientReg_middlename_XPATH",data.get("MiddleName"));
		     type("PatientReg_lastname_XPATH",data.get("LastName"));
		     
	         select("PatientReg_suffix_XPATH",data.get("suffix"));
	         select("PatientReg_DOM_XPATH",data.get("Month"));
	
	         type("PatientReg_DOD_XPATH",data.get("Date"));
	         type("PatientReg_DOY_XPATH",data.get("Year"));
	         type("PatientReg_sex_XPATH",data.get("sex"));
	
	//System.out.print(Patientmailid);	
	type("PatientReg_email_XPATH",data.get("username"));
	type("PatientReg_patientphone_XPATH",data.get("phone"));
	select("PatientReg_patientphonetype_XPATH",data.get("phonetype"));
	type("PatientReg_patientaddress_XPATH",data.get("address"));
	type("PatientReg_patientaddress2_XPATH",data.get("address2"));
	type("PatientReg_patientcity_XPATH",data.get("City"));
	select("PatientReg_patientstate_XPATH",data.get("state"));
	type("PatientReg_patientzipcode_XPATH",data.get("zip"));
    
	Thread.sleep(8000);
    //click("communicationCheckbox1_XPATH");
	
    click("communicationCheckbox2_XPATH");
    click("communicationYesRadio_XPATH");
    click("communicationNxtButton_XPATH");
    
    Thread.sleep(18000);
	
//	click("additioninfocheckbox1_XPATH");
//	Thread.sleep(4000);
//	click("additionalRadio_XPATH");
	
    click("additioninfocheckbox2_XPATH");
	Thread.sleep(4000);
	click("additioninfoButton_XPATH");
	Thread.sleep(12000);
   
	     //User name field is filled by default
	    
	      Boolean element=isElementPresent(By.xpath(OR.getProperty("PatientReg_reenterUsername_XPATH")));
	      if(element==true)
	      { System.out.println(element);
	    	 //driver.findElement(By.xpath(OR.getProperty("PatientReg_reenterUsername_XPATH"))).sendKeys(Patientmailid);
	        type("PatientReg_reenterUsername_XPATH",data.get("username"));
	      } 
	    
	          type("PatientReg_password_XPATH",data.get("password"));
	          Thread.sleep(4000);    
	          type("PatientReg_reenterpassword_XPATH",data.get("password"));
	          Thread.sleep(15000);
	      
	           click("button_XPATH");
	           Thread.sleep(60000);
	           click("PatientReg_emailconfimationClose_XPATH");
	
	/*           
    excel.setCellData("PatientLogin","username",2,Patientmailid);	
    excel.setCellData("forgotPassword","username",2, Patientmailid);	
    excel.setCellData("PatientCGiver","CGusername",2, Patientmailid);	
    excel.setCellData("AddPrescriber","username",2,Patientmailid);
    excel.setCellData("EditPrescriberDetails","username",2,Patientmailid);
    excel.setCellData("AddPrimaryInsurance","username",2, Patientmailid);
    excel.setCellData("PatientAddTreatmentLocation","TLusername",2, Patientmailid);
    */
    
    

//-------------------Activation through Gmail or Mailinator----------------------

    /*if(config.getProperty("mailtype").equals("gmail")){
        Activation_Gmail myGmail=new Activation_Gmail();
        myGmail.activation_gmail();
       }
          else if(config.getProperty("mailtype").equals("mailinator")){
      	 Activation_Mailinator myMail=new Activation_Mailinator();
      	 myMail.activation_mailinator();
          } */
	} 
	
	@AfterMethod
	public void cleanup() {
		try{
		myassertion.assertAll();
			}
		catch(Error e)
		{
			test.log(LogStatus.FAIL,"Test Case Failed");
		}
		driver.manage().deleteAllCookies();
	}

	
	@DataProvider
	
	   public Object[][] getData() {
	   
	   //return TestUtil.getData("PatientRegistration");
		return TestUtil.getPatientData("PatientRegistration");
	  }	
}
	
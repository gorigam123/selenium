package testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil_old;
import utilities.TestUtil;


public class ProviderRegistration_IndependentSite extends TestBase{

	static Random rad = new Random();
	
	//static String mailinatorid="TestDavidMiller"+rad.nextInt(1000)+"@mailinator.com";
	//static String providermailid="darensam456+"+rad.nextInt(1000)+"@gmail.com";
	//String Phonenumber =RandomStringUtils.randomNumeric(10);
	//String PresNPI=RandomStringUtils.randomNumeric(10);
	
	JavascriptExecutor executor;
	
	@Test(dataProvider="getData")
	
	public void provider_reg_IndependentSite(Hashtable<String,String>data) throws Exception{
	
        if(!(TestUtil.isRunnable("ProviderRegistration_IndependentSite", excel))){
			throw new SkipException("Skipping the test "+"ProviderRegistration_IndependentSite" + "as the Run mode is set as NO");
		}
		
	driver.get(config.getProperty("ProviderURL"));
	driver.manage().window().maximize();
	Thread.sleep(15000);
	test.log(LogStatus.INFO, "Provider login/Registration url opened");
	
	//Scroll down window
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(100,250)", "");
	Thread.sleep(25000);
	
	//click("LnkProviderRegistation_XPATH");
	click("ProviderRegistationIndSite_Signup_XPATH");
	Thread.sleep(20000);
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(220,250)", "");
	Thread.sleep(10000);	
   
 	//enter provider details
	type("ProviderRegIndSite_fname_XPATH",data.get("FName"));
	type("ProviderRegIndSite_mname_XPATH",data.get("MName"));
	type("ProviderRegIndSite_lname_XPATH",data.get("LName"));
	select("ProviderRegIndSite_suffix_XPATH",data.get("suffix"));
	
	type("ProviderRegIndSite_phone_XPATH",data.get("phone"));
	select("ProviderRegIndSite_phoneType_XPATH",data.get("ptype"));
	select("ProviderRegIndSite_role_XPATH",data.get("Role"));
	
	Thread.sleep(4000);
	click("ProivderRegIndSite_ConsentRadioButton_CSS");
	
	type("ProviderRegIndSite_prenpi_XPATH",data.get("prenpi"));
	select("ProviderRegIndSite_speciality_XPATH",data.get("speciality"));
	select("ProviderRegIndSite_stateoflicense_XPATH",data.get("StateofLicence"));
	type("ProviderRegIndSite_prescribersln_XPATH",data.get("PreSLN"));
	
	//executor = (JavascriptExecutor)driver;
	//JavascriptExecutor jse = (JavascriptExecutor)driver;
	//jse.executeScript("window.scrollBy(100,250)", "");
	Thread.sleep(5000);
	
	executor = (JavascriptExecutor)driver;
	String jsScript= "var textarea =document.getElementsByClassName('cJanssenUI_AgreementText2')[0];"
			+ "	textarea.scrollTop=textarea.scrollHeight;"	;		
	executor.executeScript(jsScript);
	Thread.sleep(3000);
 
	click("ProviderRegIndSite_LegalTermsofUse_CSS");
	click("ProviderRegIndSite_LegalTermsofUseButton_XPATH");
	
	Thread.sleep(8000);
	
	  if(config.getProperty("environment").equals("SIT2"))
	  {
		  if(config.getProperty("mailtype").equals("gmail"))
		  {		  
			  type("ProviderRegIndSite_Username_XPATH",data.get("username"));
			  Thread.sleep(4000);
			  type("ProviderRegIndSite_confirmUsername_XPATH",data.get("username"));
			  Thread.sleep(3000);
			  type("ProviderRegIndSite_Pasword_XPATH",data.get("password"));  
			  Thread.sleep(4000);
			  type("ProviderRegIndSite_confirmPasword_XPATH",data.get("password"));
		   }
			else if(config.getProperty("mailtype").equals("mailinator")){
				  type("ProviderRegIndSite_Username_XPATH",data.get("username"));
				  Thread.sleep(4000);
				  type("ProviderRegIndSite_confirmUsername_XPATH",data.get("username"));
				  Thread.sleep(3000);
				  type("ProviderRegIndSite_Pasword_XPATH",data.get("password"));  
				  Thread.sleep(4000);
				  type("ProviderRegIndSite_confirmPasword_XPATH",data.get("password"));
			 } 
	 }
	  if(config.getProperty("environment").equals("DevDox"))
	  {
		  if(config.getProperty("mailtype").equals("gmail"))
		  {		  
			type("confirmUsername_XPATH",data.get("username"));
			type("confirmPasword_XPATH",data.get("password"));  
			type("confirmReenterpwd_XPATH",data.get("password"));
			//driver.findElement(By.xpath(OR.getProperty("confirmReenterpwd_XPATH"))).clear();
			//type("confirmReenterpwd_XPATH",data.get("password"));
		  }
			else if(config.getProperty("mailtype").equals("mailinator")){
				type("confirmUsername_XPATH",data.get("username"));
				type("confirmPasword_XPATH",data.get("password"));
				type("confirmReenterpwd_XPATH",data.get("password"));
				//driver.findElement(By.xpath(OR.getProperty("confirmReenterpwd_XPATH"))).clear();
				//type("confirmReenterpwd_XPATH",data.get("password"));
			 }
	    }
		  if(config.getProperty("environment").equals("UAT"))
		  {
			  if(config.getProperty("mailtype").equals("gmail"))
			  {		  
				  type("ProviderRegIndSite_Username_XPATH",data.get("username"));
				  Thread.sleep(4000);
				  type("ProviderRegIndSite_confirmUsername_XPATH",data.get("username"));
				  Thread.sleep(3000);
				  type("ProviderRegIndSite_Pasword_XPATH",data.get("password"));  
				  Thread.sleep(4000);
				  type("ProviderRegIndSite_confirmPasword_XPATH",data.get("password"));
			   }
				else if(config.getProperty("mailtype").equals("mailinator")){
					  type("ProviderRegIndSite_Username_XPATH",data.get("username"));
					  Thread.sleep(4000);
					  type("ProviderRegIndSite_confirmUsername_XPATH",data.get("username"));
					  Thread.sleep(3000);
					  type("ProviderRegIndSite_Pasword_XPATH",data.get("password"));  
					  Thread.sleep(4000);
					  type("ProviderRegIndSite_confirmPasword_XPATH",data.get("password"));
				 } 
			  
		  } 	   

	  
	Thread.sleep(14000);
	
		
		click("ProviderRegIndSite_NextButton_XPATH");
		Thread.sleep(8000);
		
		executor = (JavascriptExecutor)driver;
		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse1.executeScript("window.scrollBy(150,250)", "");
		
		Thread.sleep(20000);
		
		click("ProviderRegIndSite_textnotificationChecBox_XPATH");
		click("ProviderRegIndSite_programinfoFax_XPATH");
		click("ProviderRegIndSite_CommPref_NextButton_XPATH");
		
		click("ProviderRegIndSite_CreateNewSite_XPATH");
		
		select("ProviderRegIndSite_OrganisationType_XPATH",data.get("organisationType"));
		select("ProviderRegIndSite_sitelocationtype_XPATH",data.get("sitelocationtype"));
		type("ProviderRegIndSite_SiteName_XPATH",data.get("sitename"));
		type("ProviderRegIndSite_Sitelocationtaxid_XPATH",data.get("taxid"));
		type("ProviderRegIndSite_SitlocationMedicalGroup_XPATH",data.get("medicalgroup"));
		Thread.sleep(3000);
		type("ProviderRegIndSite_SitelocationAddress_XPATH",data.get("address"));
		
		type("ProviderRegIndSite_SitelocationCity_XPATH",data.get("city"));
		select("ProviderRegIndSite_SitelocationState_XPATH",data.get("state"));
		type("ProviderRegIndSite_SitelocationZip_XPATH",data.get("SitelocationZip"));
		type("ProviderRegIndSite_SitelocationPhone_XPATH",data.get("SitelocationPhone"));
		type("ProviderRegIndSite_SitelocationFax_XPATH",data.get("SitelocationFax"));
		click("ProviderRegIndSite_SitelocationNextButton_XPATH");
		Thread.sleep(5000);
		click("ProviderRegIndSite_SitelocationReviewSubmitButton_XPATH");
		Thread.sleep(65000);
		
		click("ProviderRegIndSite_CompleteRegistrationButton_XPATH");
		
		//driver.findElement(By.xpath(OR.getProperty("completeRegistration_XPATH"))).click();
		//driver.findElement(By.xpath(".//span[contains(text(),'Continue')]")).click();
	
	
		//System.out.print(providermailid);
		
		// write email id on excel sheet
		
		/*if(config.getProperty("mailtype").equals("gmail")){
			excel.setCellData("ProviderLogin", "Prusername", 2, providermailid);	
			excel.setCellData("PrForgotPassword", "Prusername", 2, providermailid);		
			
		}
		else if(config.getProperty("mailtype").equals("mailinator")){
			excel.setCellData("ProviderLogin", "Prusername", 2, mailinatorid);	
			excel.setCellData("PrForgotPassword", "Prusername", 2, mailinatorid);	
		
		} */
		
		
		
		
   // ----------------Activation via Gmail or Mailinator ------------------------------

	/*if(config.getProperty("mailtype").equals("gmail")){
      Activation_Gmail myGmail=new Activation_Gmail();
      myGmail.activation_gmail();
     }
        else if(config.getProperty("mailtype").equals("mailinator")){
    	 Activation_Mailinator myMail=new Activation_Mailinator();
    	 myMail.activation_mailinator();
    }*/
	  
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
		return TestUtil.getProviderData("ProviderRegistration");
	  }	
}
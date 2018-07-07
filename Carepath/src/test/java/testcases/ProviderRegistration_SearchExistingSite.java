package testcases;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil_old;
import utilities.TestUtil;

public class ProviderRegistration_SearchExistingSite extends TestBase{

	/*static Random rad = new Random();
	static String SearchNetworksite_gmailid="darensam456+"+rad.nextInt(1000)+"@gmail.com";
	static String SearchNetworksite_mailinatorid="TestDavidMiller"+rad.nextInt(1000)+"@mailinator.com";
	*/
	JavascriptExecutor executor;
	
	@Test(dataProvider="getData")
	
	public void provider_reg_searchExistingSite(Hashtable<String,String> data)throws Exception{
	
		if(!(TestUtil.isRunnable("ProviderRegistration_SearchExistingSite", excel))){
			throw new SkipException("Skipping the test "+"ProviderRegistration_SearchExistingSite" + "as the Run mode is set as NO");
		}
		driver.get(config.getProperty("ProviderURL"));
		driver.manage().window().maximize();
		Thread.sleep(25000);
		test.log(LogStatus.INFO, "Provider login/Registration url opened");
		
		//Scroll down window
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(100,250)", "");
		Thread.sleep(25000);
		
		click("ProviderRegSearchExistingSite_Signup_XPATH");
		Thread.sleep(20000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(220,250)", "");
		Thread.sleep(20000);	
	   
	 	//enter patient details
		type("ProviderRegSearchExistingSite_fname_XPATH",data.get("FName"));
		type("ProviderRegSearchExistingSite_mname_XPATH",data.get("MName"));
		type("ProviderRegSearchExistingSite_lname_XPATH",data.get("LName"));
		select("ProviderRegSearchExistingSite_suffix_XPATH",data.get("suffix"));
		type("ProviderRegSearchExistingSite_phone_XPATH",data.get("phone"));
		select("ProviderRegSearchExistingSite_phoneType_XPATH",data.get("ptype"));
		select("ProviderRegSearchExistingSite_role_XPATH",data.get("Role"));
		
		Thread.sleep(4000);
		click("ProviderRegSearchExistingSite_ConsentRadioButton_CSS");
		
		type("ProviderRegSearchExistingSite_prenpi_XPATH",data.get("prenpi"));
		select("ProviderRegSearchExistingSite_speciality_XPATH",data.get("speciality"));
		select("ProviderRegSearchExistingSite_stateoflicense_XPATH",data.get("StateofLicence"));
		type("ProviderRegSearchExistingSite_prescribersln_XPATH",data.get("PreSLN"));
		
		executor = (JavascriptExecutor)driver;
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("window.scrollBy(100,250)", "");
		Thread.sleep(5000);
		
		executor = (JavascriptExecutor)driver;
		String jsScript= "var textarea =document.getElementsByClassName('cJanssenUI_AgreementText2')[0];"
				+ "	textarea.scrollTop=textarea.scrollHeight;"	;		
		executor.executeScript(jsScript);
		Thread.sleep(3000);
	 
		click("ProviderRegSearchExistingSite_LegalTermsofUse_CSS");
		click("ProviderRegSearchExistingSite_LegalTermsofUseButton_XPATH");
		
		Thread.sleep(3000);
		
		//type("confirmUsername_XPATH",providermailid);
		
		if(config.getProperty("mailtype").equals("gmail")){
		   type("ProviderRegSearchExistingSite_Username_XPATH",data.get("username"));
		  }
		else if(config.getProperty("mailtype").equals("mailinator")){
			type("ProviderRegSearchExistingSite_Username_XPATH",data.get("username"));
		}
		Thread.sleep(4000);
		
		if(driver.findElement(By.xpath(OR.getProperty("ProviderRegSearchExistingSite_confirmUsername_XPATH"))).isDisplayed())
		
		{
			if(config.getProperty("mailtype").equals("gmail")){
			    type("ProviderRegSearchExistingSite_confirmUsername_XPATH",data.get("username"));
			    	    
			}
			else if(config.getProperty("mailtype").equals("mailinator")){
				type("ProviderRegSearchExistingSite_confirmUsername_XPATH",data.get("username"));
				
			}	
		
			Thread.sleep(6000);
			type("ProviderRegSearchExistingSite_Password_XPATH","Carepath@1");
		
			Thread.sleep(8000);
			type("ProviderRegSearchExistingSite_confirmPassword_XPATH","Carepath@1");
			Thread.sleep(3000);
			click("ProviderRegSearchExistingSite_NextButton_XPATH");
			Thread.sleep(8000);
			
			executor = (JavascriptExecutor)driver;
			JavascriptExecutor jse1 = (JavascriptExecutor)driver;
			jse1.executeScript("window.scrollBy(100,250)", "");
			
			Thread.sleep(25000);
			
			click("ProviderRegSearchExistingSite_textnotificationChecBox_XPATH");
			click("ProviderRegSearchExistingSite_programinfoFax_XPATH");
			click("ProviderRegSearchExistingSite_CommPref_NextButton_XPATH");
			Thread.sleep(15000);
			click("ProviderRegSearchExistingSite_SearchSiteButton_XPATH");
			type("ProviderRegSearchExistingSite_SiteName_XPATH",data.get("SearchSiteName"));
			//type("ProviderRegSearchExistingSite_SiteCity_XPATH",data.get("SearchCity"));
			//type("ProviderRegSearchExistingSite_SiteState_XPATH",data.get("SearchState"));
			click("ProviderRegSearchExistingSite_SearchButton_XPATH");		
			Thread.sleep(10000);
			
			//executor = (JavascriptExecutor)driver;
			JavascriptExecutor jse2 = (JavascriptExecutor)driver;
			jse2.executeScript("window.scrollBy(100,250)", "");
			
			//Click on Radio button. Use Radio button selection method
			Thread.sleep(6000);
			click("ProviderRegSearchExistingSite_SiteNameRadioButton_XPATH");
			Thread.sleep(10000);
			
			JavascriptExecutor jse3 = (JavascriptExecutor)driver;
			jse3.executeScript("window.scrollBy(150,250)", "");
			
			click("ProviderRegSearchExistingSite_NextButton_XPATH");
			Thread.sleep(10000);
			click("ProviderRegSearchExistingSite_afiliatedsitesButton_XPATH");
			Thread.sleep(9000);
				
		   	try{
		   	click("ProviderRegSearchExistingSite_reviewandsubmit_XPATH");
		   	}catch(Exception e){
		   		
			throw new AssertionError("Test case failed-Exception occured",e);
		   	}
		}
		   	// ----------------Activation via Gmail or Mailinator ------------------------------

	/*	if(config.getProperty("mailtype").equals("gmail")){
	      Activation_Gmail myGmail=new Activation_Gmail();
	      myGmail.activation_gmail();
	     }
	        else if(config.getProperty("mailtype").equals("mailinator")){
	    	 Activation_Mailinator myMail=new Activation_Mailinator();
	    	 myMail.activation_mailinator();
	    }
	    	
		
		
	  */}
		
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
			return TestUtil.getProviderData("Provider_SearchExistingSite");
		  }	
	}
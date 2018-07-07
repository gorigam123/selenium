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

public class ProviderRegistration_NewNetworkSite extends TestBase{

	/*static Random rad = new Random();
	static String newNetworksite_gmailid="darensam456+"+rad.nextInt(1000)+"@gmail.com";
	static String newNetworksite_mailinatorid="TestDavidMiller"+rad.nextInt(1000)+"@mailinator.com";
	*/
	JavascriptExecutor executor;
	
	@Test(dataProvider="getData")
	public void provider_reg_newNetworksite(Hashtable<String,String> data)throws Exception{
	
		if(!(TestUtil.isRunnable("ProviderRegistration_NewNetworkSite", excel))){
			throw new SkipException("Skipping the test "+"ProviderRegistration_NewNetworkSite" + "as the Run mode is set as NO");
		}
		 
		
		driver.get(config.getProperty("ProviderURL"));
		driver.manage().window().maximize();
		Thread.sleep(30000);
		test.log(LogStatus.INFO, "Provider login/Registration url opened");
		
		//Scroll down window
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(100,250)", "");
		Thread.sleep(35000);
		
		click("ProviderRegNewNetworkSite_Signup_XPATH");
		
		Thread.sleep(15000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(220,250)", "");
		Thread.sleep(18000);	
	   
	 	//enter patient details
		type("ProviderRegNewNetworkSite_fname_XPATH",data.get("FName"));
		type("ProviderRegNewNetworkSite_mname_XPATH",data.get("MName"));
		type("ProviderRegNewNetworkSite_lname_XPATH",data.get("LName"));
		select("ProviderRegNewNetworkSite_suffix_XPATH",data.get("suffix"));
		
		type("ProviderRegNewNetworkSite_phone_XPATH",data.get("phone"));
		select("ProviderRegNewNetworkSite_phoneType_XPATH",data.get("ptype"));
		select("ProviderRegNewNetworkSite_role_XPATH",data.get("Role"));
		
		Thread.sleep(4000);
		click("ProviderRegNewNetworkSite_ConsentRadioButton_CSS");
		
		type("ProviderRegNewNetworkSite_prenpi_XPATH",data.get("prenpi"));
		select("ProviderRegNewNetworkSite_speciality_XPATH",data.get("speciality"));
		select("ProviderRegNewNetworkSite_stateoflicense_XPATH",data.get("StateofLicence"));
		type("ProviderRegNewNetworkSite_prescribersln_XPATH",data.get("PreSLN"));
		
		executor = (JavascriptExecutor)driver;
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("window.scrollBy(100,250)", "");
		Thread.sleep(5000);
		
		executor = (JavascriptExecutor)driver;
		String jsScript= "var textarea =document.getElementsByClassName('cJanssenUI_AgreementText2')[0];"
				+ "	textarea.scrollTop=textarea.scrollHeight;"	;		
		executor.executeScript(jsScript);
		Thread.sleep(3000);
	 
		click("ProviderRegNewNetworkSite_LegalTermsofUse_CSS");
		click("ProviderRegNewNetworkSite_LegalTermsofUseButton_XPATH");
		
		Thread.sleep(3000);
		
		//type("confirmUsername_XPATH",providermailid);
		
		if(config.getProperty("mailtype").equals("gmail")){
		   type("ProviderRegNewNetworkSite_Username_XPATH",data.get("username"));
		  }
		else if(config.getProperty("mailtype").equals("mailinator")){
			type("ProviderRegNewNetworkSite_Username_XPATH",data.get("username"));
		}
		Thread.sleep(4000);
		
		if(driver.findElement(By.xpath(OR.getProperty("ProviderRegNewNetworkSite_confirmUsername_XPATH"))).isDisplayed())
			{
			if(config.getProperty("mailtype").equals("gmail")){
			    type("ProviderRegNewNetworkSite_confirmUsername_XPATH",data.get("username"));
			    	    
			}
			else if(config.getProperty("mailtype").equals("mailinator")){
				type("ProviderRegNewNetworkSite_confirmUsername_XPATH",data.get("username"));
				
			}	
			
		}
			Thread.sleep(6000);
			type("ProviderRegNewNetworkSite_Password_XPATH",data.get("password"));
			Thread.sleep(8000);
			type("ProviderRegNewNetworkSite_confirmPassword_XPATH",data.get("password"));
			Thread.sleep(3000);
			click("ProviderRegNewNetworkSite_NextButton_XPATH");
			Thread.sleep(8000);
			
			executor = (JavascriptExecutor)driver;
			JavascriptExecutor jse1 = (JavascriptExecutor)driver;
			jse1.executeScript("window.scrollBy(100,250)", "");
			
			Thread.sleep(25000);
			
			click("ProviderRegNewNetworkSite_textnotificationChecBox_XPATH");
			click("ProviderRegNewNetworkSite_programinfoFax_XPATH");
			click("ProviderRegNewNetworkSite_CommPref_NextButton_XPATH");
			
			click("ProviderRegNewNetworkSite_CreateNewSite_XPATH");
			
			select("ProviderRegNewNetworkSite_OrganisationType_XPATH",data.get("organisationType"));
			click("createnewNetworksite_XPATH");
			
			// By default create new network radio button will be selected
			
			type("ProviderRegNewNetworkSite_NetworkName_XPATH",data.get("NetworkName"));
			type("ProviderRegNewNetworkSite_NetworkTaxid_XPATH",data.get("taxid"));
			Thread.sleep(3000);
			type("ProviderRegNewNetworkSite_NetworkAddress_XPATH",data.get("address"));
			type("ProviderRegNewNetworkSite_NetworkAddress2_XPATH",data.get("address2"));
			type("ProviderRegNewNetworkSite_NetworkCity_XPATH",data.get("city"));
			Thread.sleep(6000);
			select("ProviderRegNewNetworkSite_NetworkState_XPATH",data.get("state"));
			type("ProviderRegNewNetworkSite_NetworkZip_XPATH",data.get("zip"));
			type("ProviderRegNewNetworkSite_NetworkPhone_XPATH",data.get("NetworksitePhone"));
			type("ProviderRegNewNetworkSite_NetworkFax_XPATH",data.get("NetworksiteFax"));
			click("ProviderRegNewNetworkSite_NetworkNextButton_XPATH");
			Thread.sleep(5000);
			
			select("ProviderRegNewNetworkSite_NetworkSiteLocType_XPATH",data.get("Site1LocationType"));

			type("ProviderRegNewNetworkSite_NetworkSiteName_XPATH",data.get("Site1SiteName"));
			//type("NewNetworksiteTaxid2_XPATH","3434565678");
			type("ProviderRegNewNetworkSite_NetworkSiteMedGroup_XPATH",data.get("Site1MedGrp"));
  
			type("ProviderRegNewNetworkSite_NetworkSiteAddress_XPATH",data.get("Site1Address"));
			type("ProviderRegNewNetworkSite_NetworkSiteAddress2_XPATH",data.get("Site1Add2"));
			type("ProviderRegNewNetworkSite_NetworkSiteCity_XPATH",data.get("Site1City"));
			Thread.sleep(6000);
			select("ProviderRegNewNetworkSite_NetworkSiteState_XPATH",data.get("Site1State"));
			type("ProviderRegNewNetworkSite_NetworkSiteZip_XPATH",data.get("NewNetworksiteZip2"));
			type("ProviderRegNewNetworkSite_NetworkSitePhone_XPATH",data.get("NewNetworkSitePhone2"));
			type("ProviderRegNewNetworkSite_NetworkSiteFax_XPATH",data.get("NewNetworkSiteFax2"));
			click("ProviderRegNewNetworkSite_NetworkSiteNextButton_XPATH");
			
			Thread.sleep(8000);
			click("ProviderRegNewNetworkSite_NetworkSiteReview&Submit_XPATH");
			
			Thread.sleep(55000);
			
			driver.findElement(By.xpath(".//span[contains(text(),'Continue')]")).click();;
    		
			/*System.out.print(data.get("username"));
			
			// write email id on excel sheet
			
			if(config.getProperty("mailtype").equals("gmail")){
				excel.setCellData("PrNewNetworkLogin", "PrNewNtwork_Username",2,newNetworksite_gmailid);	
				//excel.setCellData("PrForgotPassword", "Prusername", 2, newNetworksite_gmailid);		
				
			}
			else if(config.getProperty("mailtype").equals("mailinator")){
				excel.setCellData("PrNewNetworkLogin", "Prusername", 2, newNetworksite_mailinatorid);	
				//excel.setCellData("PrForgotPassword", "Prusername", 2, newNetworksite_gmailid);	
			}
		*/		
			
			
	   // ----------------Activation via Gmail or Mailinator ------------------------------

		/*if(config.getProperty("mailtype").equals("gmail")){
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
			return TestUtil.getProviderData("Provider_NewNetworkSite");
		  }	
	}
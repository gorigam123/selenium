package testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil_old;
import utilities.TestUtil;

public class Activation_Mailinator extends TestBase {

		
	@Test
	public void activation_mailinator() throws Exception{
	
		 driver.get(config.getProperty("mailinatorurl"));
		    
		 
		 
			//driver.findElement(By.xpath(OR.getProperty("mailinatorUsername_XPATH"))).sendKeys(ProviderRegistration_Physician_gmail.mailinatorid);
			driver.findElement(By.xpath(OR.getProperty("mailinatorUsername_XPATH"))).sendKeys("TestDavidMiller158@mailinator.com");

			Thread.sleep(5000);
			driver.findElement(By.xpath(OR.getProperty("mailinatorGo_XPATH"))).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(OR.getProperty("mailinatorEmailSubject_XPATH"))).click();
			Thread.sleep(7000);
			Select picker = new Select(driver.findElement(By.xpath(OR.getProperty("mailinatorDropdown_XPATH"))));
			picker.selectByVisibleText("text/plain");
			Thread.sleep(3000);
			
			WebElement dropdown7=driver.findElement(By.xpath(OR.getProperty("mailinatorDropdown_XPATH")));
			Select texttype = new Select(dropdown7);
			texttype.selectByVisibleText("text/plain");
			Thread.sleep(3000);
			driver.switchTo().frame(1);	
			String St = driver.findElement(By.xpath(OR.getProperty("mailinatorVerifyLink_XPATH"))).getText();		
			driver.get(St);
			Thread.sleep(20000);		
			clickStaleElement(driver, OR.getProperty("mailinatorVerifybutton_XPATH"));
			Thread.sleep(15000);
			String Heading = driver.findElement(By.xpath(".//h1[@class='headline center-text']")).getText();
			Assert.assertEquals("Thank you for verifying your email address.", Heading);
		    //driver.quit();	
		  
		 
			
	}
	@AfterTest
	
	public void teardown(){
		
		
		
	}
	
/*	@DataProvider
	   public Object[][] getData() {
	   return TestUtil.getData("ProviderLogin");
	  }*/		
	
}
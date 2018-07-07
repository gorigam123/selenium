package testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import base.TestBase;

public class Activation_Gmail extends TestBase {

		
	@Test
	public void activation_gmail() throws Exception{
	
		 	       
		    driver.get(config.getProperty("gmailurl"));
		    
		    //Thread.sleep(4000);
		    
		    type("gmailuser_XPATH",OR.getProperty("gmailuser"));
		 		    
		    Thread.sleep(4000);
		 
		    click("gmailUsername_nextbutton_CSS");
		    Thread.sleep(8000);
		    type("gmailpassword_CSS",OR.getProperty("gmailpassword"));
		    Thread.sleep(10000);
		    click("gmailpassoword_nextbutton_CSS");
		    Thread.sleep(10000);
		   
		   Boolean present=isElementPresent(By.cssSelector("a.WaidBe"));
		   if(present==true)
		                {
						driver.findElement(By.cssSelector("a.WaidBe")).click();
			              }
		   Thread.sleep(12000);
		   driver.manage().window().maximize();
		   Thread.sleep(6000);
		   
	//clicking on required mail from gmail inbox
		   
		        List<WebElement> a = driver.findElements(By.xpath("//*[@class='yW']/span"));
		        System.out.println(a.size());
		        for (int i = 0; i < a.size(); i++) {
		           System.out.println(a.get(i).getText());
		           if (a.get(i).getText().equals("noreply@janssencarepath..")) //to click on a specific mail.
		           {                                           
		           a.get(i).click();
		           }
		         }
		     
		     Thread.sleep(12000);
	//  to scroll down
		      JavascriptExecutor executor;
		      JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		      jse2.executeScript("window.scrollBy(100,250)", "");
		      Thread.sleep(10000);
		   
		   driver.findElement(By.xpath("//a[contains(text(),'Activate Account')]")).click();
		   Thread.sleep(20000);
		   
	  //---- switching windows from gmail to Janssen------------
	  
	  String oldtab=driver.getWindowHandle();
	  ArrayList<String> newtab=new ArrayList<String>(driver.getWindowHandles());
	  driver.switchTo().window(newtab.get(1));
	  
	  //----to check if current url is of Janssen or not-----------
	   
	   String myurl=driver.getCurrentUrl();
	   System.out.print(myurl);
	   Thread.sleep(25000);
		   
	   driver.findElement(By.xpath("html/body/div[4]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/section/div[2]/div/div/div/div[2]/div/form/div[2]/div/button")).click();
	   //driver.findElement(By.xpath(".//span[contains(text(),'Click here to verify Email Address')]")).click();
	   Thread.sleep(6000);
	   
	   //---switch back to gmail---------
	   
	   driver.switchTo().window(newtab.get(0));
	   Thread.sleep(10000);
	  
	   click("gmailInbox_CSS"); //click on gmail Inbox
	   Thread.sleep(3000);
       click("gmailselectAllcheckbox_XPATH");//click on select all checkbox
       Thread.sleep(3000);
       click("gmaildelete_XPATH");//click on Delete button
          
	   Thread.sleep(3000);	   
	   
	}
	@AfterTest
	
	public void teardown(){
		
		
		
	}
}
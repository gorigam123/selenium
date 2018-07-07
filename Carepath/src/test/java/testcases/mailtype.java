package testcases;

import org.testng.annotations.Test;

import base.TestBase;

public class mailtype extends TestBase{

@Test

public void mailtypevalidation() throws Throwable{

	if(config.getProperty("mailtype").equals("gmail")){
	      Activation_Gmail myGmail=new Activation_Gmail();
	      myGmail.activation_gmail();
	     }
	        else if(config.getProperty("mailtype").equals("mailinator")){
	    	 Activation_Mailinator myMail=new Activation_Mailinator();
	    	 myMail.activation_mailinator();
	        }
     
     
	}    		
 }

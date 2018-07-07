package utilities;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	
	public static ExtentReports getInstance(){
		
		if(extent==null){
			Date date=new Date();
			
			String reportname=date.toString().replace(":","_").replace(" ","_")+".html";
			
			//extent = new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extent.html",true,DisplayOrder.OLDEST_FIRST);
			extent = new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+reportname,true,DisplayOrder.OLDEST_FIRST);
			
			
			
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\extentconfig\\ReportsConfig.xml"));
			
			
		}
		
		return extent;
		
	}

}

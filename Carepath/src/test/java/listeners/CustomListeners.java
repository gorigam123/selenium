package listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil_old;
import utilities.TestUtil;


public class CustomListeners extends TestBase implements ITestListener,ISuiteListener {

	public 	String messageBody;
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {

		//System.setProperty("org.uncommons.reportng.escape-output","false");
		try {
			TestUtil_old.captureScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(LogStatus.FAIL, arg0.getName()+" Failed with exception : "+arg0.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil_old.screenshotName));
			
		rep.endTest(test);
		rep.flush();
		
	}

	public void onTestSkipped(ITestResult arg0) {

		test.log(LogStatus.SKIP, arg0.getName().toUpperCase()+" Test Case is skipped as the Run mode is set as NO");
		rep.endTest(test);
		rep.flush();
		
	
		
	}


	public void onTestStart(ITestResult arg0) {

		test = rep.startTest(arg0.getName().toUpperCase());

		
	}

	public void onTestSuccess(ITestResult arg0) {


		//test.log(LogStatus.PASS, arg0.getName() +"PASS");
		rep.endTest(test);
		rep.flush();
		
	}

	public void onFinish(ISuite arg0) {
		
	
		}

		
	

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

}

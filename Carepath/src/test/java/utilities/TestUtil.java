package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import base.TestBase;


public class TestUtil extends TestBase {

	public static Object[][] getPatientData(String testCaseName)
	{
		//ExcelReader excelxl=new ExcelReader("C:\\Users\\AnandB\\Desktop\\MyProject\\JanssenCarePath_Framework\\CarepathSanity\\Carepath\\src\\test\\resources\\excel\\testdata2.xlsx");
		
	 String sheetName="PatientData";
	 //String testCaseName="PatientLogin";

	 int testStartRowNum=1;
	 while(!excel.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName))
	 {
		 testStartRowNum++;
	 }
       //System.out.print(testStartRowNum);
       int colStartRownum=testStartRowNum+1;
       int dataStartRownum=testStartRowNum+2;
       
       int rows=0;
       
       while(!excel.getCellData(sheetName, 0, dataStartRownum+rows).equals("")){
    	   rows++;
    	//System.out.println(rows);   
       }
       
       int cols=0;
       while(!excel.getCellData(sheetName, cols, colStartRownum).equals("")){
    	   
    	   cols++;
       }  
       
       Object[][] data=new Object[rows][1];
        int dataRow=0;
         Hashtable<String,String> table=null;
       
    	for(int rNum=dataStartRownum;rNum<dataStartRownum+rows;rNum++){
    	
    		table=new Hashtable<String,String>();
    		for(int cNum=0;cNum<cols;cNum++){
    			String key=excel.getCellData(sheetName, cNum, colStartRownum);
    			String value=excel.getCellData(sheetName, cNum, rNum);
    			table.put(key, value);
    		    //data[dataRow][cNum]=xl.getCellData(sheetName, cNum, rNum);	
    			
    		}
    		data[dataRow][0]=table;
    		dataRow++; 
    	}
    	return data;
    	
	} 	   
    	   
    	@DataProvider
    	public static Object[][] getMyData(String sheetName) {

    		//String sheetName = m.getName();
    		int rows = excel.getRowCount(sheetName);
    		int cols = excel.getColumnCount(sheetName);

    		Object[][] data = new Object[rows-1][cols];
    		
    		for (int rowNum = 2; rowNum <= rows; rowNum++) { 

    		  for (int colNum = 0; colNum < cols; colNum++) {

    			   data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
    			 }

    		}

    		return data;

    	} 
    	
    	public static boolean isRunnable(String testName, ExcelReader excel){
    		
    		String sheetName="TestCases";
    		int rows = excel.getRowCount(sheetName);
    		
    		
    		for(int rNum=2; rNum<=rows; rNum++){
    			
    			String testCase = excel.getCellData(sheetName, "TestCaseName", rNum);
    			
    			if(testCase.equalsIgnoreCase(testName)){
    				
    				String runmode = excel.getCellData(sheetName, "Runmode", rNum);
    				
    				if(runmode.equalsIgnoreCase("Y"))
    					return true;
    				else
    					return false;
    			}
    			
    			
    		}
    		return false;
    	}

    	
	   
     
    	
	

	
public static Object[][] getProviderData(String testCaseName)
{
	//ExcelReader excelxl=new ExcelReader("C:\\Users\\AnandB\\Desktop\\MyProject\\JanssenCarePath_Framework\\CarepathSanity\\Carepath\\src\\test\\resources\\excel\\testdata2.xlsx");
	
 String sheetName="ProviderData";
 //String testCaseName="PatientLogin";

 int testStartRowNum=1;
 while(!excel.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName))
 {
	 testStartRowNum++;
 }
   //System.out.print(testStartRowNum);
   int colStartRownum=testStartRowNum+1;
   int dataStartRownum=testStartRowNum+2;
   
   int rows=0;
   
   while(!excel.getCellData(sheetName, 0, dataStartRownum+rows).equals("")){
	   rows++;
	//System.out.println(rows);   
   }
   
   int cols=0;
   while(!excel.getCellData(sheetName, cols, colStartRownum).equals("")){
	   
	   cols++;
   }  
   
   Object[][] data=new Object[rows][1];
    int dataRow=0;
     Hashtable<String,String> table=null;
   
	for(int rNum=dataStartRownum;rNum<dataStartRownum+rows;rNum++){
	
		table=new Hashtable<String,String>();
		for(int cNum=0;cNum<cols;cNum++){
			String key=excel.getCellData(sheetName, cNum, colStartRownum);
			String value=excel.getCellData(sheetName, cNum, rNum);
			table.put(key, value);
		    //data[dataRow][cNum]=xl.getCellData(sheetName, cNum, rNum);	
			
		}
		data[dataRow][0]=table;
		dataRow++; 
	}
	return data;
	
} 	   
}







package testcases;

import java.util.Hashtable;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ExcelReader;

public class testhash {

	
	@Test(dataProvider="getData")
	
	public void testA(Hashtable<String,String>data){
		
		
	}
	
	@DataProvider
	public Object[][]getData()
	{
		ExcelReader xl=new ExcelReader("C:\\Users\\AnandB\\Desktop\\MyProject\\JanssenCarePath_Framework\\CarepathSanity\\Carepath\\src\\test\\resources\\excel\\testdata2.xlsx");
	
		 String sheetName="Data";
		 String testCaseName="PatientLogin";
	
		 int testStartRowNum=1;
		 while(!xl.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName))
		 {
			 testStartRowNum++;
		 }
	       //System.out.print(testStartRowNum);
	       int colStartRownum=testStartRowNum+1;
	       int dataStartRownum=testStartRowNum+2;
	       
	       int rows=0;
	       
	       while(!xl.getCellData(sheetName, 0, dataStartRownum+rows).equals("")){
	    	   rows++;
	    	//System.out.println(rows);   
	       }
	       
	       int cols=0;
	       while(!xl.getCellData(sheetName, cols, colStartRownum).equals("")){
	    	   
	    	   cols++;
	       }  
	       
	       Object[][] data=new Object[rows][1];
	       int dataRow=0;
	      
	       Hashtable<String,String> table=null;
	       
	    	for(int rNum=dataStartRownum;rNum<dataStartRownum+rows;rNum++){
	    	table=new Hashtable<String,String>();
	    		for(int cNum=0;cNum<cols;cNum++){
	    			String key=xl.getCellData(sheetName, cNum, colStartRownum);
	    			String value=xl.getCellData(sheetName, cNum, rNum);
	    			table.put(key, value);
	    		    //data[dataRow][cNum]=xl.getCellData(sheetName, cNum, rNum);	
	    			
	    		}
	    		data[dataRow][0]=table;
	    		dataRow++; 
	    	}
	    	return data;
	    	
	    	   
	    	   
	    	   
	       }
	}
	



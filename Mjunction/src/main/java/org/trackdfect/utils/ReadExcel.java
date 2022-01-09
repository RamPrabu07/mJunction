package org.trackdfect.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws Throwable {
		File file = new File("‪C:\\Users\\RBT\\Downloads\\invoice1.xlsx");
		FileInputStream fs = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(0);
		System.out.println("rows:" + sheet.getPhysicalNumberOfRows());
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		for(int i=1;i<=rowCount;i++){
		     
		     int cellcount=sheet.getRow(i).getLastCellNum();	   	   
		     System.out.println("Row"+ i+" data is :");   
		     String ckdata = sheet.getRow(i).getCell(0).toString();
		    if (ckdata == null)
			{
			
				break;
			}
		
		
		
		for(int j=0;j<cellcount;j++){
	        //System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() +",");
	    	
	    	
	    	System.out.print(sheet.getRow(i).getCell(j).toString() + " , ");
		}
		
		

		}
	
	}

}

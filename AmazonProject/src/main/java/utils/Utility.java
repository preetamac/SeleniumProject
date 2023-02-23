package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility
{
	
	
		
	public static void CaptureScreenShot(WebDriver driver ,String testMethodName) throws InterruptedException,IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH MM SS");
		String dateformat = df.format(new Date());
		String imageName=testMethodName+dateformat;
		
		File dest = new File("C:\\Users\\arun\\OneDrive\\Desktop\\Testing_class\\ScreenShots\\Test-"+imageName+".jpg");
		FileHandler.copy(src, dest);
	}
	
	
	public static String fetchDataFromExcelSheet(String sheetName,int row,int cell) throws IOException,IllegalStateException
	{
		String path="C:\\Users\\arun\\OneDrive\\Desktop\\Testing_class\\TestExcelSheet.xlsx";
		InputStream file=new FileInputStream(path);
		
		Workbook book =WorkbookFactory.create(file);//open file
		
		Sheet sheet=book.getSheet("AmazonLogin"); //select sheet
		
		int lastrowno=sheet.getLastRowNum();//get last row number in the sheet
		
		Row rowval=sheet.getRow(row);//select row
			
		int lastcellno=rowval.getLastCellNum();//Last cell number in the row
					
		Cell cellval=rowval.getCell(cell);//select first cell
		
		//for()
							
		String data="";
		try
		 {
			  data=cellval.getStringCellValue();
		 }
		 catch(IllegalStateException e)
		 {
			 double value=cellval.getNumericCellValue();
			 
			// data=String.valueOf(value);
			 
			 data=Double.toString(value);
			 
		 }
		return data;
		
	}
}








/*Workbook book =WorkbookFactory.create(file);//open file

Sheet sheet=book.getSheet("AmazonLogin"); //select sheet

int lastrowno=sheet.getLastRowNum();

Row rowNo=sheet.getRow(lastrowno);

int lastcellno=rowNo.getLastCellNum();



for(int i=0;i<=lastrowno;i++)
{
	for(int j=0;j<lastcellno;j++)
	{
		System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+",");
	}
	System.out.println();
}
*/
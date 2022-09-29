package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
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

public class Utility {

	static Cell cell ;
	static String value ;
	public static WebDriver captureScreenShot(WebDriver driver,int testId) throws IOException
	{
		   DateFormat formatDate=  new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		   Date systemDate = new Date();
		   String dateOfSystem = formatDate.format(systemDate) ;
		   System.out.println(dateOfSystem);
	       
		   TakesScreenshot take = (TakesScreenshot) driver ;
		   File src = take.getScreenshotAs(OutputType.FILE);
	       File dest = new File("C:\\TakeSrc\\fb\\fb "+testId+" "+dateOfSystem+".jpeg");
	       FileHandler.copy(src,dest);	
	       
	       return driver ;
	}
	
	public static String  dataFromExelSheet (String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	{
		String path = "C:\\Users\\shri\\Desktop\\EXEL FILE1234.xlsx" ;
		FileInputStream file = new FileInputStream(path);
		Cell cell = WorkbookFactory.create(file).getSheet(sheetName).getRow(rowNum).getCell(cellNum);	
	
	
	try {
		value = cell.getStringCellValue();
	}
	catch(IllegalStateException e){
		double numValue = cell.getNumericCellValue();
		value = Double.toString(numValue);
	}
	return value ;

  }
	
}
	
	
	
	
	
	
	
	
	


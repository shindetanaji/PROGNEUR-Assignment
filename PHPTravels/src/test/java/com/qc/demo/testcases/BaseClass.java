package com.qc.demo.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.qc.demo.utils.ReadFile;

public class BaseClass {

	WebDriver driver;
	ReadFile read = new ReadFile();
	
	@BeforeSuite
	public void doSetUp(){
		Properties prop = read.readPropData();
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		driver.get(prop.getProperty("siteUrl"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@DataProvider
	public Object[][] getData() throws BiffException, IOException {
		FileInputStream fis = new FileInputStream("src/test/resources/ReadData.xls");
		Workbook book = Workbook.getWorkbook(fis);
		Sheet sheet = book.getSheet(0);
		int rows = sheet.getRows();
		int columns = sheet.getColumns();
		String testData[][] = new String[rows - 1][columns];
		int count = 0;
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				Cell cell = sheet.getCell(j, i);
				testData[count][j] = cell.getContents();
			}
			count++;
		}
		fis.close();
		return testData;
	}
	
	
	
}

package com.qc.demo.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadFile {

	public Properties readPropData(){
		Properties prop = null;
		try {
			FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public static Object[][] readData(String number) throws IOException, BiffException{
		FileInputStream fis = new FileInputStream("src/test/resources/ReadData.xls");
		Workbook book = Workbook.getWorkbook(fis);
		Sheet sheet = book.getSheet(number);
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

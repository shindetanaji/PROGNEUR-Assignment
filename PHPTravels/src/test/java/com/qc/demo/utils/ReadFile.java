package com.qc.demo.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ReadFile {

	public Properties readPropData() {
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

	public static Object[][] readData(String number) throws IOException {
		FileInputStream fis = new FileInputStream("src/test/resources/ReadData.xls");
		DataFormatter formatter = new DataFormatter();
		HSSFWorkbook book = new HSSFWorkbook(fis);
		HSSFSheet sheet = book.getSheet(number);
		HSSFRow row = sheet.getRow(0);
		int rows = sheet.getPhysicalNumberOfRows();
		int columns = row.getLastCellNum();

		Object testData[][] = new Object[rows][columns];

		for (int i = 0; i < rows; i++) {
			HSSFRow row1 = sheet.getRow(i + 1);
			for (int j = 0; j < columns; j++) {
				if (row1 == null)
					testData[i][j] = "";
				else {
					HSSFCell cell = row1.getCell(j);
					if (cell == null)
						testData[i][j] = ""; 
					else {
						String value = formatter.formatCellValue(cell);
						testData[i][j] = value; 
					}
				}
			}
		}

		return testData;
	}

}

package com.qc.demo.utils;

import java.io.FileInputStream;
import java.util.Properties;

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
	
}

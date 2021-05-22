package com.qc.demo.testcases;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
		}else{
			driver = new FirefoxDriver();
		}
		
		driver.get(prop.getProperty("siteUrl"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@DataProvider(name="login")
	public Object[][] loginData() throws IOException {
		return ReadFile.readData("Sheet1");
	}
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][]{
			   new Object[] {"admin@phptravels.com", "demoadmin"}
		};
	}
	
	@DataProvider(name="register")
	public Object[][] registerData() throws IOException {
		return ReadFile.readData("Sheet2");
	}
	
}

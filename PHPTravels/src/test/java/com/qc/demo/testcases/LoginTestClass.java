package com.qc.demo.testcases;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qc.demo.pages.DashboardPage;
import com.qc.demo.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTestClass extends BaseClass{

	WebDriver driver;
	static DashboardPage dashboard;
	static LoginPage login;
	String userName;
	String password;
	
	//For Extent report
	static ExtentReports extent;
	static ExtentTest logger;
	static ITestResult result;
	
	//@Parameters({ "OS", "browser" })
	@BeforeTest
	public void setUpReport(){
		extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/testReport.html");
		extent.addSystemInfo("Host Name","PROGNEUR TECHNOLOGIES")
			  .addSystemInfo("Environment", "Automation Testing")
		      .addSystemInfo("User Name", "Tanaji Shinde");
		extent.loadConfig(new File(System.getProperty("user.dir")
				+ "src/test/resources/extent-config.xml"));
	}
	
	@Test(dataProvider="loginData")
	public void doLogin(String uName, String uPass){
		logger = extent.startTest("passTest");
		this.userName = uName;
		this.password = uPass;
		driver= super.driver;
		login = new LoginPage(driver);
		dashboard = login.login(uName, uPass);
	}
	
	@AfterMethod
	public void verifyResult(){
		if(userName.equalsIgnoreCase("") && password.equalsIgnoreCase("")){
			verifyInValidResult();
		}else{
			verifyValidResult();
		}
	}
	
	public static void verifyValidResult(){
		logger.log(LogStatus.PASS, "Login test with valid data");
		Assert.assertTrue(dashboard.verifyDashboardPage());
	}
	
	public static void verifyInValidResult(){
		logger.log(LogStatus.PASS, "Login test with Invalid data");
		Assert.assertTrue(login.verifyLoginPage());
	}
	
	@AfterMethod
	public void getResult(ITestResult result){
	extent.endTest(logger);
	}
	
	@AfterSuite
	public void tearDown(){
		extent.flush();
		extent.close();
		dashboard.doLogout();
		driver.close();
	}
	
}

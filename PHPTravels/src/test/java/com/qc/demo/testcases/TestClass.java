package com.qc.demo.testcases;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.qc.demo.pages.DashboardPage;
import com.qc.demo.pages.LoginPage;

public class TestClass extends BaseClass{

	WebDriver driver;
	static DashboardPage dashboard;
	static LoginPage login;
	String userName;
	String password;
	
	@Test(dataProvider="getData")
	public void doLogin(String uName, String uPass){
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
		Assert.assertTrue(dashboard.verifyDashboardPage());
	}
	
	public static void verifyInValidResult(){
		Assert.assertTrue(login.verifyLoginPage());
	}
	
	
	@AfterSuite
	public void tearDown(){
		dashboard.doLogout();
		driver.close();
	}
	
}

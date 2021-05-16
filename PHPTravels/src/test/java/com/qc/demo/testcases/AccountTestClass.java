package com.qc.demo.testcases;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.qc.demo.pages.AddCustomerPage;
import com.qc.demo.pages.DashboardPage;
import com.qc.demo.pages.LoginPage;

public class AccountTestClass extends BaseClass{

	WebDriver driver;

	LoginPage login;
	DashboardPage dashboard;
	AddCustomerPage customer;
	@Test(dataProvider="getData", priority=0)
	public void doLogin(String uName, String uPass){
		driver= super.driver;
		login = new LoginPage(driver);
		dashboard = login.login(uName, uPass);
	}
	
	@Test(dataProvider="registerData", priority=1)
	public void addCustomer(String fname, String lname, String email, String password, String mobile, String add, String add1){
		dashboard.clickOnAccounts();
		dashboard.clickOnCustomer();
		customer = new AddCustomerPage(driver);
		customer.addCustomerData(fname, lname, email, password, mobile, add, add1);
	}
	
	@AfterSuite
	public void tearDown(){
		//dashboard.doLogout();
		//driver.close();
	}
	
}

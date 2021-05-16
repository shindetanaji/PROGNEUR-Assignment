package com.qc.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//li[@id='logout']")
	WebElement logout;
	
	@FindBy(xpath="//a[@href='#ACCOUNTS']")
	WebElement account;
	
	@FindBy(partialLinkText="Customers")
	WebElement customers;
	
	public String getHomePageTitle() {
		String titleDashBoard = driver.getTitle();
		return titleDashBoard;
	}

	public boolean verifyDashboardPage() {
		return getHomePageTitle().equals("Dashboard");
	}

	public void doLogout(){
		logout.click();
	}
	
	public void clickOnAccounts(){
		account.click();
		
	}
	
	public void clickOnCustomer(){
		customers.click();
	}
}

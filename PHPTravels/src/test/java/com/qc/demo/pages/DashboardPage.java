package com.qc.demo.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@FindBy(xpath="//li[@id='logout']")
	WebElement logout;
	
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
	
}

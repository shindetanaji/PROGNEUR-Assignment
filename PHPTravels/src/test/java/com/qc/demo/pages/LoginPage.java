package com.qc.demo.pages;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qc.demo.utils.ReadFile;

public class LoginPage {
	WebDriver driver;
	ReadFile read = new ReadFile();
	Properties prop;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement signIn;
	
	//WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
	//WebElement password = driver.findElement(By.xpath(prop.getProperty("passwordXPath")));
	//WebElement signIn = driver.findElement(By.xpath(prop.getProperty("submitButtonXpath")));
	

	public void enterEmailValue(String uName) {
		email.sendKeys(uName);
	}

	public void enterPasswordValue(String uPass) {
		password.sendKeys(uPass);
	}

	public DashboardPage clickOnSubmit() {
		signIn.click();
		return new DashboardPage(driver);
	}

	public String getTitleLoginPage() {
		String titleDashBoard = driver.getTitle();
		return titleDashBoard;
	}

	public boolean verifyLoginPage() {
		return getTitleLoginPage().equals("Administator Login");
	}
	
	public DashboardPage login(String userName, String userPassword) {
		enterEmailValue(userName);
		enterPasswordValue(userPassword);
		if(userName.isEmpty()){
			signIn.click();
		}
		return clickOnSubmit();
	}

}

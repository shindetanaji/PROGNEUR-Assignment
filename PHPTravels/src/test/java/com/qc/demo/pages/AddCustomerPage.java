package com.qc.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement clickToAdd;

	@FindBy(name="fname")
	WebElement fname;
	
	@FindBy(name="lname")
	WebElement lname;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="mobile")
	WebElement mobile;
	
	@FindBy(className="select2-focusser")
	WebElement country;
	Select select = new Select(country);
	
	@FindBy(name="address1")
	WebElement address1;
	
	@FindBy(name="address2")
	WebElement address2;
	
	@FindBy(name="newssub")
	WebElement checkBox;
	
	@FindBy(className="btn")
	WebElement submit;
	
	public void addCustomerData(String fname, String lname, String email, String password, String mobile, String add, String add1){
		this.fname.sendKeys(fname);
		this.lname.sendKeys(lname);
		this.email.sendKeys(email);
		this.password.sendKeys(password);
		this.mobile.sendKeys(mobile);
		select.selectByVisibleText("India");
		this.address1.sendKeys(add);
		this.address2.sendKeys(add1);
		this.checkBox.click();
		submit.click();
	}
}

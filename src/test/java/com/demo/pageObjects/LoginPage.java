package com.demo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath = "//a[contains(text(),'Log out')]")
	@CacheLookup
	WebElement btnLogOut;
	
	
	
	
	public void setUserName(String name) {
		txtUserName.sendKeys(name);
	}
	
	public void setPassword(String password) {
		txtpassword.sendKeys(password);
	}
	
	public void cliclSubmit() {
		btnLogin.click();
	
	}
	
	public void clicKLogout() {
		btnLogOut.click();
	
	}
	
	

}

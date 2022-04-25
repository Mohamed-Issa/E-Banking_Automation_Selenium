package com.ebanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {

	WebDriver driver;

	public AddNewCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using  = "//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement lnknewCustomer;

	@FindBy(how = How.CSS,  using = "input[name='name']")
	@CacheLookup
	WebElement customerName;

	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement rdGender;

	@CacheLookup
	@FindBy(how = How.ID_OR_NAME,  using = "dob")
	WebElement dateOfBirth;

	@FindBy(how = How.CSS,  using = "input[name='city']")
	@CacheLookup
	WebElement city;

	@FindBy(how = How.CSS,  using = "input[name='state']")
	@CacheLookup
	WebElement state;

	@FindBy(how = How.CSS,  using = "input[name='pinno']")
	@CacheLookup
	WebElement pin;

	@FindBy(how = How.NAME,  using = "telephoneno")
	@CacheLookup
	WebElement mobileNumber;
	
	
	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement address;
	

	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement email;

	@FindBy(how = How.NAME,  using = "password")
	@CacheLookup
	WebElement password;
	
	
	@FindBy(how = How.XPATH,  using = "//input[@type='submit']")
	@CacheLookup
	WebElement btnSubmit;

	
	public void clickNewCutomer() {
		lnknewCustomer.click();
	}
	
	public void setCutomerName(String name) {
		customerName.sendKeys(name);
	}
	
	public void setGender(String gender) {
		rdGender.click();
	}
	
	public void setDateOfBirth(String mm,String dd,String yy) {
		dateOfBirth.sendKeys(mm);
		dateOfBirth.sendKeys(dd);
		dateOfBirth.sendKeys(yy);
		
	}
	
	public void setCity(String ccity) {
		city.sendKeys(ccity);
		
	}
	
	public void setState(String sstate) {
		state.sendKeys(sstate);
		
	}
	
	
	public void setPin(String ppin) {
		pin.sendKeys(String.valueOf(ppin));
		
	}
	
	public void setAddress(String addr) {
		address.sendKeys(addr);
		
	}
	
	public void setMobileNum(String mobileNo) {
		mobileNumber.sendKeys(mobileNo);
		
	}
	
	public void setEmail(String eemail) {
		email.sendKeys(eemail);
		
	}
	
	public void setPassword(String pass) {
		password.sendKeys(pass);
		
	}
	
	public void clickSubmit() {
		btnSubmit.click();
	}
}

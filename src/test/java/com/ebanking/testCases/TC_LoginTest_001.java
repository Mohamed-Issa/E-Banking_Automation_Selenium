package com.ebanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	
	
	@Test
	public void LoginTest() throws IOException {
		
		driver.get(baseURL);
		logger.info("URL is open");
		
	/*	if (driver.findElement(By.id("details-button")).isDisplayed()) {
			driver.findElement(By.id("details-button")).click();
			driver.findElement(By.id("proceed-link")).click();
		}*/
		
		logger.info("proceed-link is pressed");

		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(userName);
		logger.info("Entered userName");
		loginPage.setPassword(password);
		logger.info("Entered password");
		loginPage.cliclSubmit();
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")){
			Assert.assertTrue(true);
			logger.info("login test is passed");
		}	
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("login test is failed");
			
		}
		
	}
	
	

}

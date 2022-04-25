package com.ebanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebanking.pageObjects.AddNewCustomerPage;
import com.ebanking.pageObjects.LoginPage;

public class TC_AddCutomerTest_003 extends BaseClass {

	@Test
	public void addNewCutomer() throws IOException, InterruptedException {

		LoginPage lPage = new LoginPage(driver);
		lPage.setUserName(userName);
		lPage.setPassword(password);
		lPage.cliclSubmit();

		AddNewCustomerPage addNewCust = new AddNewCustomerPage(driver);

		logger.info("providing cutomer details....");

		addNewCust.clickNewCutomer();
		addNewCust.setCutomerName("mohamed");
		addNewCust.setGender("male");
		addNewCust.setDateOfBirth("11", "11", "1999");
		Thread.sleep(3000);
		addNewCust.setAddress("Egypt");
		addNewCust.setCity("Cairo");
		addNewCust.setState("AP");
		addNewCust.setPin("5000074");
		addNewCust.setMobileNum("987890091");

		String email = rondomString() + "@email.com";
		addNewCust.setEmail(email);
		addNewCust.setPassword("abcde");
		addNewCust.clickSubmit();
		
		Thread.sleep(3000);

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			logger.info("test case passed....");

		} else {
			logger.info("test case failed....");
			captureScreen(driver, "addNewCustomerTest");
			Assert.assertTrue(false);
		}

	}

}

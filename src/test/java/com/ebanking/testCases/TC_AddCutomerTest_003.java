package com.ebanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebanking.pageObjects.AddNewCustomerPage;
import com.ebanking.pageObjects.LoginPage;

public class TC_AddCutomerTest_003 extends BaseClass {

	public static String cutomerID;

	@Test(priority = 1)
	public void addNewCutomer() throws IOException, InterruptedException {

		LoginPage lPage = new LoginPage(driver);
		lPage.setUserName(userName);
		lPage.setPassword(password);
		lPage.cliclSubmit();

		AddNewCustomerPage addNewCust = new AddNewCustomerPage(driver);

		logger.info("providing cutomer details....");

		addNewCust.clickNewCutomer();
		addNewCust.setCutomerName(rondomString());
		addNewCust.setGender("female");
		addNewCust.setDateOfBirth("8", "8", "1998");
		// Thread.sleep(3000);
		addNewCust.setAddress("Egypt");
		addNewCust.setCity("Cairo");
		addNewCust.setState("AP");
		addNewCust.setPin("5000074");
		addNewCust.setMobileNum("987890091");

		String email = rondomString() + "@email.com";
		addNewCust.setEmail(email);
		addNewCust.setPassword("abcde");
		addNewCust.clickSubmit();

		Thread.sleep(5000);

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			logger.info("test case passed....");

		} else {
			logger.info("test case failed....");
			captureScreen(driver, "addNewCustomerTest");
			Assert.assertTrue(false);
		}

		cutomerID = driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]")).getText();

		System.out.println(cutomerID);

	}

	@Test(priority = 2)
	public void editCustomer() throws InterruptedException {
		driver.findElement(By.linkText("Edit Customer")).click();
		driver.findElement(By.cssSelector("input[name='cusid']")).sendKeys(cutomerID);
		driver.findElement(By.cssSelector("input[name='AccSubmit']")).click();
		driver.findElement(By.linkText("Home")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void addNewAccount() throws IOException, InterruptedException {
		driver.findElement(By.linkText("New Account")).click();
		driver.findElement(By.cssSelector("input[name='cusid']")).sendKeys(cutomerID);
		Select accType = new Select(driver.findElement(By.cssSelector("select[name='selaccount']")));
		accType.selectByIndex(1);
		driver.findElement(By.cssSelector("input[name='inideposit']")).sendKeys("5000");
		driver.findElement(By.cssSelector("input[name='button2']")).click();

		boolean res = driver.getPageSource().contains("Account Generated Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			logger.info("test case passed....");

		} else {
			logger.info("test case failed....");
			captureScreen(driver, "addNewAccountTest");
			Assert.assertTrue(false);
		}
		
		Thread.sleep(3000);

		LoginPage lPage = new LoginPage(driver);
		lPage.clicKLogout();
		driver.switchTo().alert().accept(); // logout alert
		driver.switchTo().defaultContent();

	}

}

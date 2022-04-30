package com.ebanking.testCases;

import java.io.IOException;


import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ebanking.pageObjects.LoginPage;
import com.ebanking.utilities.XLUtils;

public class TC_LoginTestDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void LoginDDT(String name, String pass) throws IOException, InterruptedException {

		driver.get(baseURL);
		logger.info("get url");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(name);
		logger.info("Entered userName");
		loginPage.setPassword(pass);
		logger.info("Entered password");
		loginPage.cliclSubmit();

		//Thread.sleep(3000);

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login test is failed");
			captureScreen(driver,"test failed");
		} else {
			Assert.assertTrue(true);
			loginPage.clicKLogout();
			//Thread.sleep(3000);
			driver.switchTo().alert().accept(); // logout alert
			driver.switchTo().defaultContent();
			logger.info("login test is passed");
		}

	}

	public boolean isAlertPresent() {

		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}


	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir")+"/src/test/java/com/ebanking/testData/LoginData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);// 1 0 }

			}
		}
		return logindata;

	}

	/*
	 * @DataProvider(name = "loginData") Object[][] getLoginData() throws
	 * IOException {
	 * 
	 * Object[][] loginData = { { "mngr401331", "UvAtebu" }, { "mngr83460",
	 * "qAbUzyj" }, { "mngr137319", "bAdYvyb" }, { "mngr401331", "UvAtebu" }, {
	 * "mngr112909", "tytUreg" } };
	 * 
	 * return loginData; }
	 */

}

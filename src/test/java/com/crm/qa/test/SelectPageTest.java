package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SelectPage;

public class SelectPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	SelectPage selectPage;
	
	
	public SelectPageTest(){
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		selectPage=homePage.FindFlight();
	}
	
	@Test(priority=1)
	public void verifySelectPageTest() {
		String SelectPagetitle = selectPage.validateSelectPageTitle();
		Assert.assertEquals(SelectPagetitle, "Select a Flight: Mercury Tours");
	}

	@Test(priority=2)
	public void verifyFlightLabelTest() {
		Assert.assertTrue(selectPage.validateSelectFlightLogo());

	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CreateProfilePage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SelectPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	SelectPage selectPage;
	CreateProfilePage createProfilePage;

	public HomePageTest(){
		super();
	}

	//Test cases should be independent  -- independent to each other
	//Before each test case -- launch the browser and login
	//@Test - execute test case
	//After each test case - close the browser

	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void verifyHomePageTest() {
		String homePagetitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePagetitle, "Find a Flight: Mercury Tours:");
	}

	@Test(priority=2)
	public void verifyFlightLabelTest() {
		Assert.assertTrue(homePage.validateFlightImage());

	}

	@Test(priority=3)
	public void verifySelectedPortTest() {
		

	}

	@Test(priority=4)
	public void verifyFindFlightTest() {
		selectPage= homePage.FindFlight();

	} 
	
	@Test(priority=5)
	public void verifyProfileTest() {
		createProfilePage= homePage.CreateProfileLink();

	} 

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

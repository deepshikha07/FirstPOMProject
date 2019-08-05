package com.crm.qa.test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CreateProfilePage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CreateProfileTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	CreateProfilePage createProfilePage;
	TestUtil testUtil;
	String sheetName="profile";

	public CreateProfileTest() {
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		createProfilePage = homePage.CreateProfileLink();
		//testUtil = TestUtil.getTestData(sheetname);
	}

//	@Test(priority=1)
//	public void verifyProfilePageTest() {
//		String ProfilePagetitle = createProfilePage.validateProfilePageTitle();
//		Assert.assertEquals(ProfilePagetitle, "Register: Mercury Tours");
//	}
	
	@DataProvider
	public Object[][] getProfileTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;	
	}

	//	@Test(priority=2)
	//	public void validateProfileTest() {
	//		homePage.CreateProfileLink();
	//		createProfilePage.CreatenewProfile("Deep", "Gautm", "8087", "deep@gmail.com", "Bhumkar", "Pune", "MH", "101", "THAILAND","dgautam");
	//	}

	@Test(priority=2, dataProvider="getProfileTestData")
	public void validateProfileTest(String Fnm, String Lastnm, String num, String mail, String addr, String cty, String MH, String pin, String to, String userid )
	{
		homePage.CreateProfileLink();
		//createProfilePage.CreatenewProfile("Deep", "Gautm", "8087", "deep@gmail.com", "Bhumkar", "Pune", "MH", "101", "THAILAND","dgautam");
		createProfilePage.CreatenewProfile(Fnm, Lastnm, num, mail, addr, cty, MH, pin, to, userid);
	}



	@AfterMethod
	public void tearDown() {
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.quit();
	}

}



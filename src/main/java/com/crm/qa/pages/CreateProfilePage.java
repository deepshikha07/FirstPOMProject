package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class CreateProfilePage extends TestBase {

	
	//Page Factory or OR

	@FindBy(name="firstName")
	WebElement Firstnm;

	@FindBy(name="lastName")
	WebElement Lastnm;

	@FindBy(name="phone")
	WebElement phonenum;

	@FindBy(name="userName")
	WebElement emailid;

	@FindBy(name="address1")
	WebElement Address;

	@FindBy(name="city")
	WebElement cityname;

	@FindBy(name="state")
	WebElement Statenm;

	@FindBy(name="postalCode")
	WebElement pincode;

	@FindBy(name="country")
	WebElement Countryname;	
	
	@FindBy(name="email")
	WebElement usernm;

	
	@FindBy(xpath="//input[@src='/images/forms/submit.gif']")
	WebElement submitBtn;	
	
	
	
	//Initializing the Page Objects:
		public CreateProfilePage() {
			PageFactory.initElements(driver, this);
		}
		
	//Actions:
		public String validateProfilePageTitle(){
			return driver.getTitle();
		}
		
	public void CreatenewProfile(String fname,String lname,String phnum,String emid,String add, String city, String state, String Pinc,String cntry,String usrnm)
	{
		PageFactory.initElements(driver, this);
		Firstnm.sendKeys(fname);
		Lastnm.sendKeys(lname);
		phonenum.sendKeys(phnum);
		emailid.sendKeys(emid);
		Address.sendKeys(add);
		cityname.sendKeys(city);
		Statenm.sendKeys(state);
		pincode.sendKeys(Pinc);
		Select select = new Select(Countryname);
		select.selectByVisibleText(cntry);
		usernm.sendKeys(usrnm);
		submitBtn.click();
		
	}

}

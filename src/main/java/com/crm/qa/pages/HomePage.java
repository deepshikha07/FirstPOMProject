package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase {
	
	TestUtil testUtil;

	@FindBy(xpath = "//img[@src='/images/masts/mast_flightfinder.gif']")
	@CacheLookup
	WebElement flightLabel;

	@FindBy(name="passCount")
	WebElement passengers;

	@FindBy(name="fromPort")
	WebElement departingFrom;

	@FindBy(name="airline")
	WebElement airLine;

	@FindBy(name="findFlights")
	WebElement continueBtn;
	
	@FindBy(linkText="PROFILE")
	WebElement fillprofile;

	//Initializing the Page Objects:
	public HomePage(){
		PageFactory.initElements(driver, this);
	}

	//Actions:
	public String validateHomePageTitle(){
		return driver.getTitle();
	}

	public boolean validateFlightImage(){
		return flightLabel.isDisplayed();
	}
	
	public List<WebElement> validateSelectPort() {
		 testUtil.automateDropdown(driver, "fromPort","London");
		 return testUtil.dropdown.getAllSelectedOptions();
	   
	   
	}
	
	public void SelectAirline() {
		Select dropdown = new Select(airLine);
		List<WebElement> options = dropdown.getOptions();
		
		System.out.println("Size :" +options.size());
		
		for(int i=0;i<options.size();i++)
		{
			System.out.println(options.get(i).getText());
		}
		
		dropdown.selectByValue("Blue Skies Airlines");
		//return dropdown.equals("Blue Skies Airlines");
		
	}
	
	public CreateProfilePage CreateProfileLink() {
		fillprofile.click();
		return new CreateProfilePage();
	}
	

	public SelectPage FindFlight() {
		continueBtn.click();
		return new SelectPage();
	}




}



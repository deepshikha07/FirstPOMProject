package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class SelectPage extends TestBase {

	@FindBy(xpath="//img[@src='/images/masts/mast_selectflight.gif']")
	WebElement SelectLabel;

	//Initializing the Page Objects:
	public SelectPage(){
		PageFactory.initElements(driver, this);
	}

	//Actions:
	public String validateSelectPageTitle(){
		return driver.getTitle();
	}

	public boolean validateSelectFlightLogo(){
		return SelectLabel.isDisplayed();
	}

}

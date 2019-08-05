package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static int PAGE_LOAD_TIMEOUT = 20;
	public static int IMPLICIT_WAIT = 10;
	public Select dropdown;
	static Workbook book;
	static Sheet sheet;

	public static String Testdata_Sheet_Path = "C:\\Users\\Dell\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\ProfileCreation_TestData.xlsx";

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(Testdata_Sheet_Path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(sheet.getLastRowNum() + "--------" + sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k =0 ; k < sheet.getRow(0).getLastCellNum(); k++) {
				
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
				System.out.println(data[i][k]);
				}
			}
		return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}


	public void automateDropdown(WebDriver driver,String locProp,String dValue) {

		WebElement departingPoint = driver.findElement(By.name(locProp));
		Select dropdown = new Select(departingPoint);
		List<WebElement> options = dropdown.getOptions();

		System.out.println("Size :" +options.size());

		for(int i=0;i<options.size();i++)
		{
			System.out.println(options.get(i).getText());
		}

		dropdown.selectByValue(dValue);
		//dropdown.selectByValue("11");
		//dropdown.selectByVisibleText("May");





	}
}

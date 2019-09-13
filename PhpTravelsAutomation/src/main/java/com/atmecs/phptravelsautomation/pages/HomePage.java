package com.atmecs.phptravelsautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.atmecs.phptravelsautomation.constants.FindLocators;
import com.atmecs.phptravelsautomation.constants.FindValidateData;
import com.atmecs.phptravelsautomation.helpers.CommonUtility;
import com.atmecs.phptravelsautomation.logreports.LogReport;

/**
 * This class operate the Home page
 * 
 * @author arjun.santra
 *
 */
public class HomePage {
	static LogReport log = new LogReport();

	public static void changeCurrency(WebDriver driver, FindLocators loc) {
		Actions action = new Actions(driver);
		WebElement wb = driver.findElement(By.xpath(loc.getlocator("loc.currencyexchange.txt")));
		Action mouseover = action.moveToElement(wb).build();
		mouseover.perform();
		CommonUtility.clickElement(loc.getlocator("loc.inrcurrency.btn"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonUtility.clickElement(loc.getlocator("loc.acceptcookie.btn"));

	}
	/**
	 * 
	 * @param driver
	 * @param loc
	 * @param validatedata
	 */
	public static void invalidCheckinDateValidation(WebDriver driver, FindLocators loc, FindValidateData validatedata) {

		CommonUtility.clickElement(loc.getlocator("loc.tours.btn"));
		CommonUtility.clickElement(loc.getlocator("loc.checkindate.btn"));
		CommonUtility.clearTextData(loc.getlocator("loc.checkindate.btn"));
		CommonUtility.clickAndSendText(loc.getlocator("loc.checkindate.btn"), 30,
				validatedata.getData("homepage.checkin_date_input_data"));
		CommonUtility.clickElement(loc.getlocator("loc.homepage.search.btn"));
		System.out.println("pass");
		Assert.assertEquals(driver.getTitle(), validatedata.getData("homepage.checkin_date_validate_data"),
				"Checkin date working properly");
		log.info("Next page title: " + driver.getTitle());
		log.info("Checkin date not working properly");

	}

	/**
	 * 
	 * @param loc
	 * @param validatedata
	 */
	public static void cityInputValidation(FindLocators loc, FindValidateData validatedata) {
		CommonUtility.clickElement(loc.getlocator("loc.backtohomapage.btn"));
		CommonUtility.clickElement(loc.getlocator("loc.tours.btn"));
		CommonUtility.clickElement(loc.getlocator("loc.city.btn"));
		CommonUtility.clickAndSendText(loc.getlocator("loc.cityinput.btn"), 30,
				validatedata.getData("homepage.city_validate_input_data"));
		String actual = CommonUtility.getText(loc.getlocator("loc.invalidcityinput.txt"));
		Assert.assertEquals(actual, validatedata.getData("homepage.city_validate_data"), "City Validation Failed");
		log.info("city validate data=" + actual);
		log.info("city input validation passed");
	}


	/**
	 * 
	 * @param loc
	 * @param city
	 * @param date
	 */
	public static void homePageTest(FindLocators loc, String city, String date) {

		CommonUtility.clearTextData(loc.getlocator("loc.cityinput.btn"));
		CommonUtility.clickAndSendText(loc.getlocator("loc.cityinput.btn"), 30, city);
		CommonUtility.clickElement(loc.getlocator("loc.citysearchoption.btn"));
		CommonUtility.clearTextData(loc.getlocator("loc.checkindate.btn"));
		CommonUtility.clickAndSendText(loc.getlocator("loc.checkindate.btn"), 30, date);
		CommonUtility.clickElement(loc.getlocator("loc.guests.dpdn"));
		CommonUtility.clickElement(loc.getlocator("loc.guestsnumber.btn"));
		CommonUtility.clickElement(loc.getlocator("loc.homepage.search.btn"));
	}

	public static void homePageVerification(WebDriver driver, FindValidateData validateData) {
		Assert.assertEquals(driver.getTitle(), validateData.getData("homepage.title_validate_data"),
				"Home page is not landing");
		log.info("Home page title: " + driver.getTitle());
		log.info("Home page URL verified successfully");
	}
}

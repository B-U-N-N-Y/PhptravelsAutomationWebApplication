package com.atmecs.phptravels.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.atmecs.phptravelsautomation.constants.FindLocators;
import com.atmecs.phptravelsautomation.helpers.CommonUtility;
import com.atmecs.phptravelsautomation.testbase.TestBase;

public class Testing extends TestBase{
	FindLocators loc=new FindLocators();

	@Test
	public void test() {
		
		Actions action=new Actions(driver);
		WebElement wb=driver.findElement(By.xpath(loc.getlocator("loc.currencyexchange.txt")));
		Action mouseOverHome=action.moveToElement(wb).build();
		mouseOverHome.perform();
		CommonUtility.clickElement(driver,loc.getlocator("loc.inrcurrency.btn"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonUtility.clickElement(driver, loc.getlocator("loc.tours.btn"));
		CommonUtility.clickElement(driver, "//span[text()='Search by Listing or City Name']");
		CommonUtility.clickAndSendText(driver,"//input[@class='select2-input select2-focused']" , 30, "india");
		CommonUtility.clickElement(driver, loc.getlocator("loc.citysearchoption.btn"));
		driver.findElement(By.xpath(loc.getlocator("loc.checkindate.btn"))).clear();
		CommonUtility.clickAndSendText(driver, loc.getlocator("loc.checkindate.btn"), 30, "27/11/2019");
		CommonUtility.clickElement(driver, loc.getlocator("loc.guests.dpdn"));
		CommonUtility.clickElement(driver, loc.getlocator("loc.guestsnumber.btn"));
		CommonUtility.clickElement(driver, loc.getlocator("loc.homepage.search.btn"));
		CommonUtility.clickElement(driver, loc.getlocator("loc.tourdetails.btn"));
		CommonUtility.scrollDownPage(driver, 3000);
		CommonUtility.clickElement(driver, loc.getlocator("loc.adults.dpdn"));
		CommonUtility.clickElement(driver, loc.getlocator("loc.adultsnumber.btn"));
		CommonUtility.clickElement(driver, loc.getlocator("loc.children.dpdn"));
		CommonUtility.clickElement(driver, loc.getlocator("loc.chilnumber.btn"));
		CommonUtility.clickElement(driver, loc.getlocator("loc.bookingoption.booknow.btn"));

		
	}
	
	
	
//	@AfterSuite
//	public void close() {
//		driver.close();
//		driver.quit();
//	}
}

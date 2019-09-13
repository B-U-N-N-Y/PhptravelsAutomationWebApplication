package com.atmecs.phptravels.testscripts;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.atmecs.phptravelsautomation.constants.FindLocators;
import com.atmecs.phptravelsautomation.constants.FindValidateData;
import com.atmecs.phptravelsautomation.dataprovider.HomePageData;
import com.atmecs.phptravelsautomation.helpers.CommonUtility;
import com.atmecs.phptravelsautomation.pages.HomePage;
import com.atmecs.phptravelsautomation.testbase.TestBase;

public class HomePageTestScript extends TestBase {
	FindLocators loc = new FindLocators();
	FindValidateData validatedata = new FindValidateData();
	@Test(priority=0)
	public void landingPageValidation() {
		HomePage.homePageVerification(driver, validatedata);
	}

	@Test(priority=1)
	public void invalidCheckinDate() {
		HomePage.changeCurrency(driver, loc);
		HomePage.invalidCheckinDateValidation(driver, loc, validatedata);
	}

	@Test(priority = 2)
	public void cityInputValidation() {
		HomePage.cityInputValidation(loc, validatedata);
	}

	@Test(priority = 2, dataProvider = "home_page_data", dataProviderClass = HomePageData.class)
	public void tourSearch(String city, String date) {
		HomePage.homePageTest(loc, city, date);
	}
	@AfterSuite
	public void processEnd() {
		driver.quit();
	}
	
}

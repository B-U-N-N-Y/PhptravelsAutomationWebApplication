package com.atmecs.phptravels.testscripts;

import org.testng.annotations.Test;

import com.atmecs.phptravelsautomation.constants.FindLocators;
import com.atmecs.phptravelsautomation.constants.FindValidateData;
import com.atmecs.phptravelsautomation.helpers.CommonUtility;
import com.atmecs.phptravelsautomation.pages.BookingOptionPage;

public class BookingOptionTestScript {
	FindLocators loc = new FindLocators();
	FindValidateData validatedata = new FindValidateData();

	@Test(priority = 3)
	public void BookingOption() {
		BookingOptionPage.bookingPageTest(loc);
		BookingOptionPage.bookingPageValidate(loc, validatedata);
		CommonUtility.clickElement(loc.getlocator("loc.bookingoption.booknow.btn"));
	}
}

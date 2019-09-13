package com.atmecs.phptravels.testscripts;

import org.testng.annotations.Test;

import com.atmecs.phptravelsautomation.constants.FindLocators;
import com.atmecs.phptravelsautomation.constants.FindValidateData;
import com.atmecs.phptravelsautomation.dataprovider.GuestDetails;
import com.atmecs.phptravelsautomation.dataprovider.PersonalDetails;
import com.atmecs.phptravelsautomation.helpers.CommonUtility;
import com.atmecs.phptravelsautomation.pages.BookingSummaryPage;

public class BookingSummaryPageTest {

	FindLocators loc = new FindLocators();
	FindValidateData validatedata = new FindValidateData();
	static int counter = 0;

	@Test(priority = 4, dataProvider = "personal_details", dataProviderClass = PersonalDetails.class)
	public void personalDetailsInput(String[] data) {
		BookingSummaryPage.personalDetails(loc, data[0], data[1], data[2], data[3], data[4], data[5]);

	}

	@Test(priority = 5, dataProvider = "guest_details", dataProviderClass = GuestDetails.class)
	public void guestInfoInput(String[] data) {
		System.out.println(counter);
		BookingSummaryPage.guestInfo(loc, data[0], data[1], data[2], counter);
		counter++;
	}

	@Test(priority = 6)
	public void amountValidateAfterAddingExtra() {
		BookingSummaryPage.bookingSummaryTotalAmountAfterExtra(loc, validatedata);
	}

	@Test(priority = 7)
	public void tourNameValidate() {
		BookingSummaryPage.bookingSummaryTourNameValidate(loc, validatedata);
	}
	
	@Test(priority = 8)
	public void amountValidateBeforeAddingExtra() {
		BookingSummaryPage.bookingSummaryTotalAmountBeforeExtra(loc, validatedata);
		CommonUtility.clickElement(loc.getlocator("loc.confirmbooking.btn"));
	}

}

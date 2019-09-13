package com.atmecs.phptravelsautomation.pages;

import org.testng.Assert;

import com.atmecs.phptravelsautomation.constants.FindLocators;
import com.atmecs.phptravelsautomation.constants.FindValidateData;
import com.atmecs.phptravelsautomation.helpers.CommonUtility;
import com.atmecs.phptravelsautomation.logreports.LogReport;

/**
 * 
 * @author arjun.santra This class operate the Booking option page
 */
public class BookingOptionPage {

	static LogReport log = new LogReport();

	/**
	 * 
	 * @param loc
	 */
	public static void bookingPageTest(FindLocators loc) {
		CommonUtility.clickElement(loc.getlocator("loc.tourdetails.btn"));
		CommonUtility.scrollDownPage(5000);
		CommonUtility.clickElement(loc.getlocator("loc.adults.dpdn"));
		CommonUtility.clickElement(loc.getlocator("loc.adultsnumber.btn"));
		CommonUtility.clickElement(loc.getlocator("loc.children.dpdn"));
		CommonUtility.clickElement(loc.getlocator("loc.chilnumber.btn"));
	}

	/**
	 * 
	 * @param loc
	 * @param validatedata
	 */
	public static void bookingPageValidate(FindLocators loc, FindValidateData validatedata) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual = CommonUtility.getText(loc.getlocator("loc.bookingoption.totalcost.txt"));
		Assert.assertEquals(actual, validatedata.getData("bookingpage.totalamount_data"), "Failed");
		log.info("The total amount in booking option page: " + actual);
		log.info("The total amount is validate succesfully");

	}
}

package com.atmecs.phptravelsautomation.pages;

import org.testng.Assert;

import com.atmecs.phptravelsautomation.constants.FindLocators;
import com.atmecs.phptravelsautomation.constants.FindValidateData;
import com.atmecs.phptravelsautomation.helpers.CommonUtility;
import com.atmecs.phptravelsautomation.logreports.LogReport;

/**
 * This class operate the Booking Summary page
 * 
 * @author arjun.santra
 *
 */
public class BookingSummaryPage {
	static String totalamount;
	static LogReport log = new LogReport();

	/**
	 * 
	 * @param loc
	 */
	public static void extraCheckBoxes(FindLocators loc) {

		CommonUtility.clickElement(loc.getlocator("loc.returnairticket.checkbox"));
		CommonUtility.clickElement(loc.getlocator("loc.3nightccomodation.checkbox"));
		CommonUtility.clickElement(loc.getlocator("loc.travelinsurance.checkbox"));
		CommonUtility.clickElement(loc.getlocator("loc.airportpickup.checkbox"));
	}

	/**
	 * 
	 * @param loc
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param mobile_no
	 * @param address
	 * @param country
	 */
	public static void personalDetails(FindLocators loc, String firstname, String lastname, String email,
			String mobile_no, String address, String country) {
		CommonUtility.clickAndSendText(loc.getlocator("loc.personaldetails.firstname.input"), 3, firstname);
		CommonUtility.clickAndSendText(loc.getlocator("loc.personaldetails.lastname.input"), 3, lastname);
		CommonUtility.clickAndSendText(loc.getlocator("loc.personaldetails.email.input"), 3, email);
		CommonUtility.clickAndSendText(loc.getlocator("loc.personaldetails.confirmemail.input"), 3, email);
		CommonUtility.clickAndSendText(loc.getlocator("loc.personaldetails.contactnumber.input"), 3, mobile_no);
		CommonUtility.clickAndSendText(loc.getlocator("loc.personaldetails.address.input"), 3, address);
		CommonUtility.clickElement(loc.getlocator("loc.personaldetails.countrybox.btn"));
		CommonUtility.clickAndSendText(loc.getlocator("loc.personaldetails.country.input"), 3, country);
		CommonUtility.clickElement(loc.getlocator("loc.personaldetails.country.search.btn"));
		CommonUtility.scrollDownPage(600);
		extraCheckBoxes(loc);

	}

	/**
	 * 
	 * @param loc
	 * @param name
	 * @param passno
	 * @param age
	 * @param counter
	 */

	public static void guestInfo(FindLocators loc, String name, String passno, String age, int counter) {
		switch (counter) {
		case 0:
			CommonUtility.clickAndSendText(loc.getlocator("loc.guestinfo.name1.input"), 3, name);
			CommonUtility.clickAndSendText(loc.getlocator("loc.guestinfo.passportno1.inout"), 3, passno);
			CommonUtility.clickAndSendText(loc.getlocator("loc.guestinfo.age1.input"), 3, age);
			break;
		case 1:
			CommonUtility.clickAndSendText(loc.getlocator("loc.guestinfo.name2.input"), 3, name);
			CommonUtility.clickAndSendText(loc.getlocator("loc.guestinfo.passportno2.inout"), 3, passno);
			CommonUtility.clickAndSendText(loc.getlocator("loc.guestinfo.age2.input"), 3, age);
			break;
		case 2:
			CommonUtility.clickAndSendText(loc.getlocator("loc.guestinfo.name3.input"), 3, name);
			CommonUtility.clickAndSendText(loc.getlocator("loc.guestinfo.passportno3.inout"), 3, passno);
			CommonUtility.clickAndSendText(loc.getlocator("loc.guestinfo.age3.input"), 3, age);
			break;
		case 3:
			CommonUtility.clickAndSendText(loc.getlocator("loc.guestinfo.name4.input"), 3, name);
			CommonUtility.clickAndSendText(loc.getlocator("loc.guestinfo.passportno4.inout"), 3, passno);
			CommonUtility.clickAndSendText(loc.getlocator("loc.guestinfo.age4.input"), 3, age);
			break;
		default:
			System.out.println("no data");
		}
	}

	/**
	 * 
	 * @param loc
	 * @param validatedata
	 */
	public static void bookingSummaryTotalAmountAfterExtra(FindLocators loc, FindValidateData validatedata) {
		totalamount = CommonUtility.getText(loc.getlocator("loc.totalbillamount.txt"));
		Assert.assertEquals(totalamount, validatedata.getData("bookingsummarypage.total_amount_afterextra_data"),
				"After Adding Extra total amount is not match");
		log.info("Total amount after adding extra: " + totalamount);
		log.info("After adding extras total amount is validate Successfully");

	}

	/**
	 * 
	 * @param loc
	 * @param validatedata
	 */

	public static void bookingSummaryTourNameValidate(FindLocators loc, FindValidateData validatedata) {
		extraCheckBoxes(loc);
		String tourname = CommonUtility.getText(loc.getlocator("loc.tourtitle.validate.txt"));
		Assert.assertEquals(tourname, validatedata.getData("bookingsummarypage.tourname_data"), "Tour name is invalid");
		log.info("Tour name is: " + tourname);
		log.info("Tour name is validate Successfully");
	}

	/**
	 * 
	 * @param loc
	 * @param validatedata
	 */
	public static void bookingSummaryTotalAmountBeforeExtra(FindLocators loc, FindValidateData validatedata) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		totalamount = CommonUtility.getText(loc.getlocator("loc.totalbillamount.txt"));
		Assert.assertEquals(totalamount, validatedata.getData("bookingsummarypage.total_amount_beforeextra_data"),
				"Before Adding Extra total amount is not match");
		log.info("Total amount before adding extra: " + totalamount);
		log.info("Before adding extras total amount is validate Successfully");
	}

}

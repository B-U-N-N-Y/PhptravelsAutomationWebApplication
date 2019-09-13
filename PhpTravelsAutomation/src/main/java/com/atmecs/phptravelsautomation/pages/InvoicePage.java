package com.atmecs.phptravelsautomation.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.atmecs.phptravelsautomation.constants.FindLocators;
import com.atmecs.phptravelsautomation.constants.FindValidateData;
import com.atmecs.phptravelsautomation.helpers.CommonUtility;
import com.atmecs.phptravelsautomation.logreports.LogReport;

/**
 * This class operate the Invoice page
 * 
 * @author arjun.santra
 *
 */
public class InvoicePage {
	static LogReport log = new LogReport();

	public static void invoicevalidation(FindLocators loc, FindValidateData validate, WebDriver driver) {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert alert = driver.switchTo().alert();
		alert.accept();
		CommonUtility.scrollDownPage(600);

		Assert.assertEquals(CommonUtility.getText(loc.getlocator("loc.customerdetails.name.txt")),
				validate.getData("invoice.customerdetails_name_data"), "customer name is mismatch");

		Assert.assertEquals(CommonUtility.getText(loc.getlocator("loc.customerdetails.address.txt")),
				validate.getData("invoice.customerdetails_address_data"), "customer address is mismatch");

		Assert.assertEquals(CommonUtility.getText(loc.getlocator("loc.customerdetails.mobile.txt")),
				validate.getData("invoice.customerdetails_mobile_data"), "customer mobile number is mismatch");

		CommonUtility.scrollDownPage(600);

		Assert.assertEquals(CommonUtility.getText(loc.getlocator("loc.checkindate.txt")),
				validate.getData("invoice.checkindate_data"), "invoice check in date failed");

		Assert.assertEquals(CommonUtility.getText(loc.getlocator("loc.totalamount.txt")),
				validate.getData("invoice.totalamount_data"), "invoice total amount failed");

		Assert.assertEquals(CommonUtility.getText(loc.getlocator("loc.guest1.name.txt")),
				validate.getData("invoice.guest1_name_data"), "guest name mismatch");

		Assert.assertEquals(CommonUtility.getText(loc.getlocator("loc.guest1.passno.txt")),
				validate.getData("invoice.guest1_passno_data"), "guest passport number mismatch");

		Assert.assertEquals(CommonUtility.getText(loc.getlocator("loc.guest1.age.txt")),
				validate.getData("invoice.guest1_age_data"), "guest age is mismatch");

		Assert.assertEquals(CommonUtility.getText(loc.getlocator("loc.guest2.name.txt")),
				validate.getData("invoice.guest2_name_data"), "guest name mismatch");

		Assert.assertEquals(CommonUtility.getText(loc.getlocator("loc.guest2.passno.txt")),
				validate.getData("invoice.guest2_passno_data"), "guest passport number mismatch");

		Assert.assertEquals(CommonUtility.getText(loc.getlocator("loc.guest2.age.txt")),
				validate.getData("invoice.guest2_age_data"), "guest age is mismatch");

		Assert.assertEquals(CommonUtility.getText(loc.getlocator("loc.guest3.name.txt")),
				validate.getData("invoice.guest3_name_data"), "guest name mismatch");

		Assert.assertEquals(CommonUtility.getText(loc.getlocator("loc.guest3.passno.txt")),
				validate.getData("invoice.guest3_passno_data"), "guest passport number mismatch");

		Assert.assertEquals(CommonUtility.getText(loc.getlocator("loc.guest3.age.txt")),
				validate.getData("invoice.guest3_age_data"), "guest age is mismatch");

		Assert.assertEquals(CommonUtility.getText(loc.getlocator("loc.guest4.name.txt")),
				validate.getData("invoice.guest4_name_data"), "guest name mismatch");

		Assert.assertEquals(CommonUtility.getText(loc.getlocator("loc.guest4.passno.txt")),
				validate.getData("invoice.guest4_passno_data"), "guest passport number mismatch");

		Assert.assertEquals(CommonUtility.getText(loc.getlocator("loc.guest4.age.txt")),
				validate.getData("invoice.guest4_age_data"), "guest age is mismatch");

		log.info("Invoice validate Successfully");
	}

}

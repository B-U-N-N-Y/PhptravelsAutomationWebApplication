package com.atmecs.phptravelsautomation.dataprovider;

import org.testng.annotations.DataProvider;

import com.atmecs.phptravelsautomation.constants.FilePath;
import com.atmecs.phptravelsautomation.utils.ProvideData;
/**
 * 
 * @author arjun.santra
 * This class to load and get guest information from excel file by using data provider
 *
 */
public class GuestDetails {
	@DataProvider(name = "guest_details")
	public Object[][] getData() {
		ProvideData provideData = new ProvideData(FilePath.TESTDATA_FILE, 2);
		Object[][] getData = provideData.provideData();
		return getData;
	}

//	public static void main(String[] args) {
//
//		Object[][] data = new GuestDetails().getData();
//		for (Object[] objects : data) {
//			String userName = (String) objects[0];
//			String password = (String) objects[1];
//			System.out.println(" " + userName + "   " + password);
//		}
//	}

}

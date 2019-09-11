package com.atmecs.phptravelsautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.atmecs.phptravelsautomation.constants.FindLocators;
import com.atmecs.phptravelsautomation.helpers.CommonUtility;

import junit.framework.Assert;

public class HomePageValidation{
	
public void changeCurrency(WebDriver driver,FindLocators loc) {
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
}
	public void cityInputValidation(WebDriver driver,FindLocators loc) {
		CommonUtility.clickElement(driver, "//span[text()='Search by Listing or City Name']");
		CommonUtility.clickAndSendText(driver,"//input[@class='select2-input select2-focused']" , 30, "hyderabad");
		WebElement actual=CommonUtility.getElement(driver, loc.getlocator("loc.invalidcityinput.txt"));
		Assert.assertEquals("failed", "No matches found", actual.getText());
		System.out.println("city input validation passed");
	}
}

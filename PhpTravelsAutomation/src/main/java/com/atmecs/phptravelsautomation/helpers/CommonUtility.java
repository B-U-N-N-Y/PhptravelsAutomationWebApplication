package com.atmecs.phptravelsautomation.helpers;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.phptravelsautomation.constants.TimeOut;
import com.atmecs.phptravelsautomation.testbase.TestBase;

public class CommonUtility extends TestBase {

	/**
	 * method click the Element using the fluent wait concepts ignoring the
	 * ElementClickInterceptedException.
	 * 
	 * @param driver
	 * @param xpath
	 */

	public static void clickElement(final String xpath) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(1, TimeUnit.SECONDS)
				.withTimeout(30, TimeUnit.SECONDS);
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				element.click();
				return true;
			}

		});
	}

	/**
	 * method takes parameter as
	 * 
	 * @param driver
	 * @param xpath
	 * @param timeOut
	 * @param text    and select the items from the drop down.
	 */

	public static void selectDropdown(final String xpath, int timeOut, final String text) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).pollingEvery(1, TimeUnit.SECONDS)
				.withTimeout(30, TimeUnit.SECONDS);
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				Select select = new Select(element);

				select.selectByVisibleText(text);
				return true;
			}

		});
	}

	/**
	 * method click the blank fields and send the text to be entered
	 * 
	 * @param driver
	 * @param xpath
	 * @param timeOutInSeconds
	 * @param text
	 */
	public static void clickAndSendText(final String xpath, int timeOutInSeconds, final String text) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(1, TimeUnit.SECONDS)
				.withTimeout(timeOutInSeconds, TimeUnit.SECONDS);

		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				element.sendKeys(text);
				;
				return true;
			}
		});
	}

	/**
	 * method takes parameter as
	 * 
	 * @param driver
	 * @param xpath  using explicit wait it will click the element
	 */

	public static void clickOnElement(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, TimeOut.TIMEOUT_INSECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath)).click();

	}

	/**
	 * method takes parameters as
	 * 
	 * @param driver
	 * @param xpath
	 * @param timeOutInSeconds
	 * @param text             and get the text of the web element
	 */
	public static String getText(final String xpath) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS).ignoring(ElementClickInterceptedException.class);

		return fluentWait.until(new Function<WebDriver, String>() {
			public String apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				String text = element.getText();
				return text;
			}

		});
	}

	/**
	 * method takes parameter as
	 * 
	 * @param driver
	 * @param xpath
	 * @param text
	 * @return WebElement
	 */
	public static WebElement getElementAndSendText(String xpath, String text) {

		WebElement element = driver.findElement(By.xpath(xpath));
		element.sendKeys(text);
		return element;
	}

	/**
	 * method check that element is displayed in the page or not
	 * 
	 * @param driver
	 * @param XPathIsDisplayed
	 * @return a boolean value for the displayed element on the web page
	 */
	public static boolean isDisplayed(String XPathIsDisplayed) {
		boolean isDisplayed = false;
		try {
			isDisplayed = driver.findElement(By.xpath(XPathIsDisplayed)).isDisplayed();
		} catch (Exception e) {
			isDisplayed = false;
		}
		return isDisplayed;
	}

	/**
	 * method check that element is visible in the webpage
	 * 
	 * @param driver
	 * @param xpath  and uses the explicit wait concept
	 * @return a boolean value after checking the visibility of the.
	 */
	public static boolean isElementVisible(String xpath) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		} catch (Exception exception) {

			return false;
		}
		return true;
	}

	/**
	 * method takes parameters as
	 * 
	 * @param driver
	 * @param xpath
	 * @return the list of elements
	 */

	public static List<WebElement> getElementsList(final String xpath) {

		List<WebElement> element = driver.findElements(By.xpath(xpath));
		return element;
	}

	/**
	 * method scroll down the window on the web page the method takes parameter as
	 * 
	 * @param driver
	 * @param byResolution and scroll down the window.
	 */
	public static void scrollDownPage(int byResolution) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String scroll = "window.scrollBy(0," + byResolution + ")";
		js.executeScript(scroll);

	}

	/**
	 * the method takes parameter as
	 * 
	 * @param xpath
	 * @return WebElement
	 */

	public static WebElement getTheElement(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, TimeOut.TIMEOUT_INSECONDS);
		wait.until(ExpectedConditions.elementToBeSelected(By.xpath(xpath)));
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	/**
	 * method return the webelement
	 * 
	 * @param xpath
	 * @return WebElement
	 */

	public static WebElement getElement(String xpath) {

		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	/**
	 * method clear the data from input box
	 * 
	 * @param xpath
	 */

	public static void clearTextData(final String xpath) {

		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(1, TimeUnit.SECONDS)
				.withTimeout(30, TimeUnit.SECONDS);
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				element.clear();
				return true;
			}
		});
	}

	/**
	 * method return the list of webelements for a given xpath
	 * 
	 * @param driver
	 * @param xpath
	 * @return list of WebElement
	 */

	public static List<WebElement> getElementsList(WebDriver driver, final String xpath) {

		List<WebElement> element = driver.findElements(By.xpath(xpath));
		return element;
	}

}

package com.atmecs.phptravelsautomation.testbase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
/**
 * This class operate Grid Connection
 * @author arjun.santra
 *
 */
public class GitConnection {
	public URL url1;
	
	public static WebDriver driver;
	public void gitConnection() {

		String nodeurl = "http://55.55.52.236:4444/wd/hub";

		DesiredCapabilities capability = new DesiredCapabilities();
		
		try {
			url1 = new URL(nodeurl);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		capability.setBrowserName("chrome");
		capability.setPlatform(Platform.WIN10);
		driver = new RemoteWebDriver(url1, capability);
	}
}

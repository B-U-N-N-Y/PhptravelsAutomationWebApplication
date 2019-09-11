package com.atmecs.phptravelsautomation.testbase;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.atmecs.phptravelsautomation.constants.FilePath;
import com.atmecs.phptravelsautomation.extentreports.Extent;
import com.atmecs.phptravelsautomation.utils.ReadPropertiesFile;


public class TestBase {
	public static WebDriver driver;
	Properties baseClass;
	String url;
	String browser;
	int downloadFile;

	@BeforeSuite
	public void intitailizeBrowser() throws IOException {

//		String nodeurl="http://55.55.52.236:4444/wd/hub";
//		
//		
//		DesiredCapabilities capability=new DesiredCapabilities();
//		URL url1=new URL(nodeurl);
//		capability.setBrowserName("chrome");
//		capability.setPlatform(Platform.WIN10);
//	 driver=new RemoteWebDriver(url1,capability);

		baseClass = ReadPropertiesFile.loadProperty(FilePath.CONFIG_FILE);
		url = baseClass.getProperty("url");
		browser = baseClass.getProperty("browser");

		System.out.println("browser is " + browser);

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", FilePath.CHROME_PATH);

			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", FilePath.FIREFOX_PATH);
			driver = new FirefoxDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

}

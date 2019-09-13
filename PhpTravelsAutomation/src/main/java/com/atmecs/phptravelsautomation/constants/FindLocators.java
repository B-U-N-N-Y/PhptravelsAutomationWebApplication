package com.atmecs.phptravelsautomation.constants;

import java.io.IOException;
import java.util.Properties;

import com.atmecs.phptravelsautomation.utils.ReadPropertiesFile;
/**
 * 
 * @author arjun.santra
 * 
 * This class to load locator file
 *
 */
public class FindLocators {
	static Properties phptravelsloc;

	public FindLocators() {
		try {
			phptravelsloc = ReadPropertiesFile.loadProperty(FilePath.LOCATOR_FILE);
		} catch (IOException e) {
			e.getMessage();
		}
	}
/**
 * 
 * @param key
 * @return locators from the property file
 * This method to get the locators
 */
	public String getlocator(String key) {
		String value = phptravelsloc.getProperty(key);
		return value;

	}

}

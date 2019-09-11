package com.atmecs.phptravelsautomation.constants;

import java.io.IOException;
import java.util.Properties;

import com.atmecs.phptravelsautomation.utils.ReadPropertiesFile;

public class FindLocators {
	static Properties phptravelsprop;
	
	public FindLocators() {
		try {
			phptravelsprop = ReadPropertiesFile.loadProperty(FilePath.LOCATOR_FILE);
		} catch (IOException e) {
			e.getMessage();
		}
	}
	
	public  String getlocator(String key)
	{
		String value=phptravelsprop.getProperty(key);
		return value;
		
	}
	
}

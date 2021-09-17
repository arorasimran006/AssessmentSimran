package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties properties;
	private final String propertyFilePath = "./src/test/resources/config.properties";

	public Properties initProp() {

		try {
			FileInputStream fis = new FileInputStream(propertyFilePath);
			properties = new Properties();
			try {
				properties.load(fis);
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Unable to load the Properties file or Unable to close FileInputStream");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Configuration.properties not found at " + propertyFilePath);
		}
		return properties;
	}
}

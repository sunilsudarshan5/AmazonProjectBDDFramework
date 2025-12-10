package com.amazon.utilites;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties props;
	
	public static void loadProperties(String fileName) {		
		try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/"+fileName+".properties")) {
			props = new Properties();
			props.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String get(String fileName, String key) {
		loadProperties(fileName);
		return props.getProperty(key);
	}
	
}

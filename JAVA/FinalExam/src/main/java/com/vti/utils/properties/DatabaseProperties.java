package com.vti.utils.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseProperties {

	public static final String RESOURCE_FOLDER_URL = "src/main/resources/";

	private Properties properties;

	public DatabaseProperties() throws IOException {
		properties = new Properties();
		properties.load(new FileInputStream(RESOURCE_FOLDER_URL + "database.properties"));
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}

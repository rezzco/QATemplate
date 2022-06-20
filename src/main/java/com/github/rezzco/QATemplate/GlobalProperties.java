package com.github.rezzco.QATemplate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import ErrorHandling.InitializationFailedException;

public class GlobalProperties {
	private static Properties _props=null;
	public GlobalProperties(Properties props) {
		_props=props;
	}
	public static Properties readPropsFile() {
		String path = System.getProperty("user.dir") + "\\resources\\data.properties";
		return readPropsFile(path);
		
	}
	public static Properties readPropsFile(String propsFilePath) {
		Properties props = new Properties();
		try {
			FileInputStream fis = new FileInputStream(propsFilePath);
			try {
				props.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		_props=props;
		return props;
	}
	
	public static String getProperty (String property) throws InitializationFailedException {
		try{
			return _props.getProperty(property);

		}catch (Exception e) {
			throw new InitializationFailedException("property variable is not initialized");
		}
		
	}

}

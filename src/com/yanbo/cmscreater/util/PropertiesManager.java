package com.yanbo.cmscreater.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesManager {

	public static String getValue(String name) {
		Properties prop = new Properties();
		InputStream is = null;
		try {
			is = PropertiesManager.class.getResourceAsStream("/db.properties");
			prop.load(is);
		} catch (Exception e) {
			System.out.print("read excelPath.properties error!!!");
		} finally {
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		String propValue = (String) prop.get(name);
		if (propValue == null || propValue.trim().length() == 0) {
			System.out.print("getFilePath url not empty!");
		}
		return propValue;
	}
}

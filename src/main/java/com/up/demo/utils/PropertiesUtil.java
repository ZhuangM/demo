package com.up.demo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	public static Properties getProperties(String resource, Class<?> clazz) {
		Properties props = new Properties();
		ClassLoader loader = null == clazz ? null : clazz.getClassLoader();
		InputStream in = null;
		try {
			if (null == loader) {
				in = ClassLoader.getSystemResourceAsStream(resource);
			} else {
				in = loader.getResourceAsStream(resource);
			}
			props.load(in);
			return props;
		} catch (IOException e) {
			throw new RuntimeException();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {

				}
			}
		}
	}

	public static String readString(Properties props, String key) {
		return props.getProperty(key);
	}
	
	public static boolean readBoolean(Properties props, String key) {
		return Boolean.parseBoolean(readString(props, key));
	}
	
	public static int readInteger(Properties props, String key) {
		return Integer.parseInt(readString(props, key));
	}
	
}

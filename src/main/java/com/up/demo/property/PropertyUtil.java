package com.up.demo.property;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

	public static Properties getProperties(String resource, Class<?> clazz) {
		ClassLoader loader = clazz == null ? null : clazz.getClassLoader();
		return getResourceAsProperty(resource, loader);
	}

	public static Properties getResourceAsProperty(String resource, ClassLoader loader) {
		Properties prop = new Properties();
		InputStream in = null;
		try {
			in = getResourceAsStream(resource, loader);
			prop.load(in);
			return prop;
		} catch (IOException e) {
			throw new RuntimeException();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO
				}
			}
		}
	}

	public static InputStream getResourceAsStream(String resource, ClassLoader loader) {
		InputStream in = null;
		if (null != loader) {
			in = loader.getResourceAsStream(resource);
		} else {
			in = ClassLoader.getSystemResourceAsStream(resource);
		}
		return in;
	}

	public static String readString(Properties props, String key) {
		return props.getProperty(key);
	}

	public static int readInteger(Properties props, String key) {
		return Integer.parseInt(readString(props, key));
	}
}

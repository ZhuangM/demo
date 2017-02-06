package com.up.demo.property;

import java.util.Enumeration;
import java.util.Map.Entry;
import java.util.Properties;

public class Run {
	private static final String RESOURCE = "db.properties";
	
	public static void main(String[] args) {
		Properties props = PropertyUtil.getProperties(RESOURCE, Run.class);
		for (Entry<Object, Object> entry : props.entrySet()) {
			System.out.println("key=" + entry.getKey() + " | value=" + entry.getValue());
		}
		Enumeration<Object> keys = props.keys();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			String value = PropertyUtil.readString(props, key);
			System.out.println("key=" + key + " | value=" + value);
		}
	}
}

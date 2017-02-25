package com.up.demo;

import java.util.Properties;

import com.up.demo.utils.PropertiesUtil;

public class Run {
	public static void main(String[] args) {
		Properties props = PropertiesUtil.getProperties("db.properties", Run.class);
		String url = PropertiesUtil.readString(props, "url");
		System.out.println(url);
	}
}

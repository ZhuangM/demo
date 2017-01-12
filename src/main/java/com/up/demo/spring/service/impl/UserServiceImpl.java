package com.up.demo.spring.service.impl;

import org.springframework.stereotype.Component;

import com.up.demo.spring.service.IUserService;

@Component("userService")
public class UserServiceImpl implements IUserService {
	@Override
	public String query() {
		String str = "this is query method.";
		System.out.println(str);
		return str;
	}
}

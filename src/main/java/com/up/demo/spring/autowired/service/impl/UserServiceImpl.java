package com.up.demo.spring.autowired.service.impl;

import org.springframework.stereotype.Component;

import com.up.demo.spring.autowired.service.IUserService;

@Component("userService")
public class UserServiceImpl implements IUserService {
	@Override
	public String query() {
		String str = "this is query method.";
		System.out.println(str);
		return str;
	}
}

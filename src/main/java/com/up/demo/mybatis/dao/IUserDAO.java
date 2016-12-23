package com.up.demo.mybatis.dao;

import com.up.demo.mybatis.entity.User;

public interface IUserDAO {
	public User queryById(int id);
}

package com.up.demo.mybatis;

import org.apache.ibatis.session.SqlSession;

import com.up.demo.mybatis.dao.IUserDAO;
import com.up.demo.mybatis.entity.User;
import com.up.demo.mybatis.util.SessionUtil;

public class Run {

	public static void main(String[] args) {
		queryUser();
	}

	private static void queryUser() {
		SqlSession session = null;
		try {
			session = SessionUtil.getSession();
			IUserDAO userDAO = session.getMapper(IUserDAO.class);
			User user = userDAO.queryById(22);
			System.out.println(user.getId() + " | " + user.getName() + " | " + user.getAge());
		} finally {
			if (null != session) {
				session.close();
			}
		}
	}

}

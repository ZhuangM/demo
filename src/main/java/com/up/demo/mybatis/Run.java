package com.up.demo.mybatis;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.up.demo.mybatis.dao.IUserDAO;
import com.up.demo.mybatis.entity.User;

public class Run {
	private static final SqlSessionFactory sqlSessionFactory;

	static {
		InputStream is = Run.class.getClassLoader().getResourceAsStream("mybatis/mybatis-conf.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
	}

	public static void main(String[] args) {
		SqlSession session = null;
		try {
			session = getSession();
			IUserDAO userDAO = (IUserDAO) session.getMapper(IUserDAO.class);
			User user = userDAO.queryById(22);
			System.out.println(user.getId() + " | " + user.getName() + " | " + user.getAge());
		} finally {
			session.close();
		}
	}

	private static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
}

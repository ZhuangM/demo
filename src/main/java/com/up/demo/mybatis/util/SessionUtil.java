package com.up.demo.mybatis.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.up.demo.mybatis.Run;

public class SessionUtil {
	private static final SqlSessionFactory sqlSessionFactory;

	static {
		InputStream is = Run.class.getClassLoader().getResourceAsStream("mybatis/mybatis-conf.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
	}

	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
	
}

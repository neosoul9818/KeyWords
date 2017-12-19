package com.atguigu.factory;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlSessionFactory {

	private static SqlSessionFactory sqlSessionFactory = null;

	public static SqlSessionFactory getMyFactory() {
		if (sqlSessionFactory == null) {

			InputStream resourceAsStream = null;
			try {
				resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

			sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
		}

		return sqlSessionFactory;
	}

}

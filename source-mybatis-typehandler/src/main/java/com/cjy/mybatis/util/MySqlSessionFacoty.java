package com.cjy.mybatis.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlSessionFacoty {
	
	 private static String resource = "mybatis-config.xml";
	 private static SqlSessionFactory sqlSessionFactory = null;
	 
	 
	private MySqlSessionFacoty(){}
	
    public static SqlSessionFactory getSqlSessionFactory() {
       
        InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(sqlSessionFactory == null){
			synchronized (MySqlSessionFacoty.class) {
				if(sqlSessionFactory == null){
					sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				}
			}
		}
        return sqlSessionFactory;
    }
    
    public static SqlSession getSqlSession(){
    	if(sqlSessionFactory == null)
    		getSqlSessionFactory();
    	return sqlSessionFactory.openSession();
    }
    
}

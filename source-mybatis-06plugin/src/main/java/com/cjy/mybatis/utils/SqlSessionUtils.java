package com.cjy.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtils {

    private static String resource = "mybatis-config.xml";


    private static SqlSessionFactory sqlSessionFactory = null;

    private SqlSessionUtils(){}

    public static SqlSessionFactory createSqlSessionFactory() {

        InputStream stream = null;
        try {
            stream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(sqlSessionFactory == null){
            synchronized (Object.class){
                if(sqlSessionFactory == null){
                    sqlSessionFactory =  new SqlSessionFactoryBuilder().build(stream);
                }
            }
        }
        return sqlSessionFactory;
    }

    public static SqlSession openSqlSesion(){
        if(sqlSessionFactory == null)
            createSqlSessionFactory();

        return sqlSessionFactory.openSession();
    }
}

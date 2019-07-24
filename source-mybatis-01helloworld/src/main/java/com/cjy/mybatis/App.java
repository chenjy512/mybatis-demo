package com.cjy.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Time;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.cjy.mybatis.dao.EmployeeMapper;
import com.cjy.mybatis.entity.Employee;
import com.cjy.mybatis.util.MySqlSessionFacoty;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void before() throws IOException{
    	sqlSessionFactory = MySqlSessionFacoty.getSqlSessionFactory();
    }


    @Test
    public void add(){
    	SqlSessionFactory sqlSessionFactory = MySqlSessionFacoty.getSqlSessionFactory();
    	SqlSession openSession = sqlSessionFactory.openSession();
    	 Employee employee = new Employee(null, "wushi", "1", "wushi@163.com");
		 EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
		 int saveEmpOne = mapper.saveEmpOne(employee);
		 System.out.println(saveEmpOne+"-------------------");
	     openSession.commit();
	     openSession.close();
    }
    @Test
    public void query(){
    	SqlSessionFactory sqlSessionFactory = MySqlSessionFacoty.getSqlSessionFactory();
    	SqlSession openSession = sqlSessionFactory.openSession();
		 EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
		 Employee selectEmp = mapper.selectEmp(11);
		 System.out.println(selectEmp);
		 //Employee [id=11, userName=wushi, gender=1, email=wushi@163.com]
    }
}

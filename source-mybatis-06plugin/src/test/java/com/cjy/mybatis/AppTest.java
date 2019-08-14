package com.cjy.mybatis;

import static org.junit.Assert.assertTrue;

import com.cjy.mybatis.dao.EmployeeMapper;
import com.cjy.mybatis.entity.Employee;
import com.cjy.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Before
    public void before(){

    }
    @Test
    public void testMy1(){
        SqlSession sqlSession = SqlSessionUtils.openSqlSesion();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.queryEmpById(1);
        System.out.println(employee);
    }

    @Test
    public void save(){
        SqlSession sqlSession = SqlSessionUtils.openSqlSesion();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee emp = new Employee("lisi", "0", 21, "lisi@163.com");
            int i = mapper.saveEmp(emp);
            System.out.println(i);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }

    }
}

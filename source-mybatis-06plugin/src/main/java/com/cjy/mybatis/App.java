package com.cjy.mybatis;

import com.cjy.mybatis.dao.EmployeeMapper;
import com.cjy.mybatis.entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = employeeMapper.queryEmpById(1);
        System.out.println(employee);
    }


    @Test
    public void test() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        Random random = new Random();
        for (int i=0;i<500;i++){
            Employee emp = new Employee();
            emp.setAge(random.nextInt(35));
            emp.setSex(random.nextInt(2)+"");
            String uuid = UUID.randomUUID().toString();
            uuid = uuid.substring(0,12);
            emp.setUserName(uuid);
            emp.setEmail(uuid+"@163.com");
            employeeMapper.saveEmp(emp);
            System.out.println(emp);
        }
//        Employee employee = employeeMapper.queryEmpById(1);
//        List<Employee> allEmps = employeeMapper.findAllEmps();
//        System.out.println(allEmps.size());
//        System.out.println(employee);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test2(){

        Random random = new Random();

        System.out.println(random.nextInt(30));
        System.out.println(UUID.randomUUID());
    }
}

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
    public void testXml() throws IOException{
    
        //2.获取sqlSession实例，能直接执行已经映射的sql语句
        SqlSession openSession = sqlSessionFactory.openSession();
        
        try {
            //1.唯一标识符（namespace + id）
            //2.执行sql需要用到的参数
//            Employee employee = openSession.selectOne("com.cjy.mybatis.dao.EmployeeMapper.selectEmp", 1);
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.selectEmp(1);
            System.out.println(employee);
            List<String> hobbys = employee.getHobbys();
            for (String string : hobbys) {
				System.out.println(string);
			}
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            openSession.close();
        }
        
    }
    @Test
    public void test3(){
    	
        SqlSession openSession = sqlSessionFactory.openSession();
        
        try {
			Employee emp = new Employee(2, "zhaoliu", "1", "zhaoliu@163.com", Arrays.asList(new String[]{"yi","er","san","si"}));
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			System.out.println("------------");
			int saveEmpOne = mapper.saveEmpOne(emp);
			System.out.println("操作数据----"+saveEmpOne);
			openSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			 openSession.close();
		}
    }
    
    @Test
    public void test2(){
    	SqlSessionFactory sqlSessionFactory = MySqlSessionFacoty.getSqlSessionFactory();
    	SqlSession openSession = sqlSessionFactory.openSession();
    	 Employee employee = new Employee(null, "yanjiu", "1", "yanjiu@163.com", new Date(),Arrays.asList(new String[]{"yuwen","shuxue","yingyu","zhengzhi"}));
		 EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
		 int saveEmpOne = mapper.saveEmpOne(employee);
		 System.out.println(saveEmpOne+"-------------------");
	     openSession.commit();
	     openSession.close();
    }
    @Test
    public void test5(){
    	SqlSessionFactory sqlSessionFactory = MySqlSessionFacoty.getSqlSessionFactory();
    	SqlSession openSession = sqlSessionFactory.openSession();
		 EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
		 Employee selectEmp = mapper.selectEmp(10);
		 System.out.println(selectEmp);
/**
2019-07-24 15:08:02 INFO  com.cjy.mybatis.typehandler.ListTypeHandler - method ====>>> getResult(ResultSet rs, String columnName)
2019-07-24 15:08:02 INFO  com.cjy.mybatis.typehandler.MyDateTypeHandler - getResult(ResultSet rs, String columnName)....
Employee [id=10, userName=yanjiu, gender=1, email=yanjiu@163.com, createtime=Wed Jul 24 15:05:58 CST 2019, hobbys=[yuwen, shuxue, yingyu, zhengzhi]]
 */
    }
    @Test
    public void test4() throws IOException{
    	 String resource = "mybatis-config.xml";
    	 InputStream inputStream = null;
		 inputStream = Resources.getResourceAsStream(resource);
		 SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	     SqlSession openSession = sqlSessionFactory.openSession();
		 EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
         Employee employee = mapper.selectEmp(8);
         System.out.println(employee);
         openSession.commit();
         openSession.close();
         //Employee [id=1, userName=zhangsan , gender=0, email=zhangsan@163.com]
	}
    
}

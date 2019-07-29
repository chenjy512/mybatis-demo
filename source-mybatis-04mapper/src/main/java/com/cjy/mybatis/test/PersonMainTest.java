package com.cjy.mybatis.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.cjy.mybatis.dao.PersonMapper;
import com.cjy.mybatis.entity.Person;
import com.cjy.mybatis.util.MySqlSessionFacoty;

public class PersonMainTest {

	PersonMapper mapper = null;
	SqlSession openSession = null;
	@Before
	public void before(){
		SqlSessionFactory sqlSessionFactory = MySqlSessionFacoty.getSqlSessionFactory();
    	 openSession = sqlSessionFactory.openSession();
    	 mapper = openSession.getMapper(PersonMapper.class);
	}
	
	@Test
	public void queryPersonById(){
		if(mapper == null)
			return ;
    	Person person = mapper.queryPersonById(1);
    	System.out.println(person);
    	/**
2019-07-29 16:09:34 DEBUG mybatis.sql.com.cjy.mybatis.dao.PersonMapper.queryPersonById - <==      Total: 1
Person [id=1, userName=张三, marker=测试数据]
    	 */
	}
	@Test
	public void queryPersonByIdAndLikeNames(){
		if(mapper == null)
			return ;
    	Person person = mapper.queryPersonByIdAndLikeNames(1, "张");
    	System.out.println(person);
    	/**
2019-07-29 16:36:09 DEBUG mybatis.sql.com.cjy.mybatis.dao.PersonMapper.queryPersonByIdAndLikeNames - <==      Total: 1
Person [id=1, userName=张三, marker=测试数据]
    	 */
	}
	
	@Test
	public void queryPersonByIdAndLikeNamesToMap(){
		if(mapper == null)
			return ;
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("id", 1);
		map.put("userName", "张");
    	Person person = mapper.queryPersonByIdAndLikeNamesToMap(map);
    	System.out.println(person);
    	/**
2019-07-29 16:35:14 DEBUG mybatis.sql.com.cjy.mybatis.dao.PersonMapper.queryPersonByIdAndLikeNamesToMap - <==      Total: 1
Person [id=1, userName=张三, marker=测试数据] 
    	 */
	}
	
	@Test
	public void queryPersonByIdAndLikeNamesToVo(){
		if(mapper == null)
			return ;
    	Person person = mapper.queryPersonByIdAndLikeNamesToVo(new Person(2,"张",null));
    	System.out.println(person);
    	/**
2019-07-29 16:39:01 DEBUG mybatis.sql.com.cjy.mybatis.dao.PersonMapper.queryPersonByIdAndLikeNamesToVo - <==      Total: 1
Person [id=1, userName=张三, marker=测试数据]
    	 */
	}
	
	//----------------------insert
	@Test
	public void savePersonInfo(){
		try {
			if(mapper == null && openSession == null)
				return ;
			Person person = new Person(null,"张","插入数据测试");
			int count = mapper.savePersonInfo(person);
			System.out.println(person.getId());  //-- id=null
			openSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			openSession.close();
		}
		/**
2019-07-29 17:02:13 DEBUG mybatis.sql.com.cjy.mybatis.dao.PersonMapper.savePersonInfo - ==>  Preparing: insert into person(user_name,marker) values(?,?) 
2019-07-29 17:02:13 DEBUG mybatis.sql.com.cjy.mybatis.dao.PersonMapper.savePersonInfo - ==> Parameters: 张(String), 插入数据测试(String)
2019-07-29 17:02:13 DEBUG mybatis.sql.com.cjy.mybatis.dao.PersonMapper.savePersonInfo - <==    Updates: 1
		 */
	}
	
	@Test
	public void savePersonInfoLoadKey(){
		try {
			if(mapper == null && openSession == null)
				return ;
			Person person = new Person(null,"李四","插入数据测试，获取主键");
			int count = mapper.savePersonInfoLoadKey(person);
			System.out.println(person.getId());
			openSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			openSession.close();
		}
	}

	@Test
	public void savePersonInfoCreateAndLoadKey(){
		try {
			if(mapper == null && openSession == null)
				return ;
			Person person = new Person(null,"李四","插入数据测试，获取主键");
			int count = mapper.savePersonInfoCreateAndLoadKey(person);
			System.out.println(person.getId());
			openSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			openSession.close();
		}
	}
	
	
	@Test
	public void updatePersonInfoById(){
		try {
			if(mapper == null && openSession == null)
				return ;
			Person person = new Person(1,"zhangsan","插入数据测试，获取主键_xg");
			int count = mapper.updatePersonInfoById(person);
			openSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			openSession.close();
		}
	}
	@Test
	public void removePersonInfoById(){
		try {
			if(mapper == null && openSession == null)
				return ;
			int count = mapper.removePersonInfoById(1);
			System.out.println(count);
			openSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			openSession.close();
		}
	}
}

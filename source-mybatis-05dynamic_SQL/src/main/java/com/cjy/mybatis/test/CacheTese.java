package com.cjy.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.cjy.mybatis.dao.PersonMapper;
import com.cjy.mybatis.entity.Person;
import com.cjy.mybatis.util.MySqlSessionFacoty;

public class CacheTese {

	
	@Test
	public void cache1(){
	 SqlSessionFactory sqlSessionFactory = MySqlSessionFacoty.getSqlSessionFactory();
   	 SqlSession openSession = sqlSessionFactory.openSession();
   	 PersonMapper mapper = openSession.getMapper(PersonMapper.class);
   	 System.out.println("---------------");
   	 Person p1 = mapper.queryPersonById(10);
   	 System.out.println("---------------");
   	 Person p2 = mapper.queryPersonById(10);
/**
 * 可以看到中间只发送了一次sql
---------------
2019-07-29 21:29:21 DEBUG mybatis.sql.com.cjy.mybatis.dao.PersonMapper.queryPersonById - ==>  Preparing: select id,user_name,marker from person where id = ? 
2019-07-29 21:29:21 DEBUG mybatis.sql.com.cjy.mybatis.dao.PersonMapper.queryPersonById - ==> Parameters: 10(Integer)
2019-07-29 21:29:21 DEBUG mybatis.sql.com.cjy.mybatis.dao.PersonMapper.queryPersonById - <==      Total: 1
---------------
 */
	}
	@Test
	public void cache2(){
		SqlSessionFactory sqlSessionFactory = MySqlSessionFacoty.getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		SqlSession openSession2 = sqlSessionFactory.openSession();
		PersonMapper mapper = openSession.getMapper(PersonMapper.class);
		PersonMapper mapper2 = openSession2.getMapper(PersonMapper.class);
		System.out.println("---------------1");
		Person p1 = mapper.queryPersonById(10);
		System.out.println("---------------2");
		Person p2 = mapper2.queryPersonById(10);
		/**
---------------1
2019-07-29 21:30:57 DEBUG mybatis.sql.com.cjy.mybatis.dao.PersonMapper.queryPersonById - ==>  Preparing: select id,user_name,marker from person where id = ? 
2019-07-29 21:30:57 DEBUG mybatis.sql.com.cjy.mybatis.dao.PersonMapper.queryPersonById - ==> Parameters: 10(Integer)
2019-07-29 21:30:57 DEBUG mybatis.sql.com.cjy.mybatis.dao.PersonMapper.queryPersonById - <==      Total: 1
---------------2
2019-07-29 21:31:07 DEBUG mybatis.sql.com.cjy.mybatis.dao.PersonMapper.queryPersonById - ==>  Preparing: select id,user_name,marker from person where id = ? 
2019-07-29 21:31:07 DEBUG mybatis.sql.com.cjy.mybatis.dao.PersonMapper.queryPersonById - ==> Parameters: 10(Integer)
2019-07-29 21:31:07 DEBUG mybatis.sql.com.cjy.mybatis.dao.PersonMapper.queryPersonById - <==      Total: 1
		 */
	}
	@Test
	public void cache3(){
		SqlSessionFactory sqlSessionFactory = MySqlSessionFacoty.getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		SqlSession openSession2 = sqlSessionFactory.openSession();
		PersonMapper mapper = openSession.getMapper(PersonMapper.class);
		PersonMapper mapper2 = openSession2.getMapper(PersonMapper.class);
		System.out.println("---------------1");
		Person p1 = mapper.queryPersonById(10);
		
		openSession.commit(); //第一个sqlSession查询完commit才行
		
		System.out.println("---------------2");
		Person p2 = mapper2.queryPersonById(10);
/**
---------------1
2019-07-29 21:39:53 DEBUG mybatis.sql.com.cjy.mybatis.dao.PersonMapper.queryPersonById - ==>  Preparing: select id,user_name,marker from person where id = ? 
2019-07-29 21:39:53 DEBUG mybatis.sql.com.cjy.mybatis.dao.PersonMapper.queryPersonById - ==> Parameters: 10(Integer)
2019-07-29 21:39:53 DEBUG mybatis.sql.com.cjy.mybatis.dao.PersonMapper.queryPersonById - <==      Total: 1
---------------2	 
*/
	}
}

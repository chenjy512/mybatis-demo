package com.cjy.mybatis.test;

import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.cjy.mybatis.dao.StudentMapper;
import com.cjy.mybatis.entity.Student;
import com.cjy.mybatis.util.MySqlSessionFacoty;

public class StudentMainTest {

	StudentMapper mapper = null;
	SqlSession openSession = null;
	@Before
	public void before(){
		SqlSessionFactory sqlSessionFactory = MySqlSessionFacoty.getSqlSessionFactory();
    	 openSession = sqlSessionFactory.openSession();
    	 mapper = openSession.getMapper(StudentMapper.class);
	}
	
	// 多个if条件测试
	@Test
	public void test(){
		Student student = new Student();
		student.setAge(12);
		List<Student> queryStudentAll = mapper.queryStudentAll(student);
		for (Student stu : queryStudentAll) {
			System.out.println(stu);
		}
	}
	//多个条件中只选择其中第一个符合条件的
	@Test
	public void queryStudentChoose(){
		Student student = new Student();	
		//默认条件：id > 2 	Student [id=3, stuName=小强, age=12, email=xiaoqiang@163.com, grade=六年级]
//		student.setGrade("八年级");
		student.setEmail("xiaoming");
		List<Student> queryStudentAll = mapper.queryStudentChoose(student);
		for (Student stu : queryStudentAll) {
			System.out.println(stu);
		}
	}
	
	@Test
	public void queryStudentWhere(){
		Student student = new Student();	
		student.setGrade("六年级");
		student.setEmail("xiaoming");
		List<Student> queryStudentAll = mapper.queryStudentWhere(student);
		for (Student stu : queryStudentAll) {
			System.out.println(stu);
		}
	}
	@Test
	public void queryStudentInfoByBind(){
		Student student = new Student();	
		student.setEmail("xiaoming");
		List<Student> queryStudentAll = mapper.queryStudentInfoByBind(student);
		for (Student stu : queryStudentAll) {
			System.out.println(stu);
		}
	}
	@Test
	public void queryStudentTrim(){
		Student student = new Student();	
		student.setEmail("xiaoming");
		student.setGrade("六年级");
		List<Student> queryStudentAll = mapper.queryStudentTrim(student);
		for (Student stu : queryStudentAll) {
			System.out.println(stu);
		}
	}
	@Test
	public void updateStudentInfo(){
		Student student = new Student();
		student.setId(1);
		student.setStuName("小明_xg");
//		student.setEmail("xiaoming@163.com");
		student.setGrade("六年级");
		student.setAge(11);
		int res = mapper.updateStudentInfo(student);
		openSession.commit();
		System.out.println(res);
	}
	@Test
	public void queryStudentInfoByIn(){

		List<Student> queryStudentAll = mapper.queryStudentInfoByIn(Arrays.asList(new Integer[]{1,2}));
		for (Student stu : queryStudentAll) {
			System.out.println(stu);
		}
/**
2019-07-31 17:06:08 DEBUG mybatis.sql.com.cjy.mybatis.dao.StudentMapper.queryStudentInfoByIn - ==>  Preparing: select * from student where id in ( ? , ? ) 
2019-07-31 17:06:08 DEBUG mybatis.sql.com.cjy.mybatis.dao.StudentMapper.queryStudentInfoByIn - ==> Parameters: 1(Integer), 2(Integer)
 */
	}
}

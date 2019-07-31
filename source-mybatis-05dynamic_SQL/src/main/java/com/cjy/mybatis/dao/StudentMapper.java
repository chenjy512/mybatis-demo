package com.cjy.mybatis.dao;

import java.util.List;

import com.cjy.mybatis.entity.Student;

public interface StudentMapper {

	public Student queryStudentInfo(Student student);
	public int saveStudentInfo(Student student);
	public int updateStudentInfo(Student student);
	public List<Student> queryStudentAll(Student student);
	public List<Student> queryStudentChoose(Student student);
	public List<Student> queryStudentWhere(Student student);
	public List<Student> queryStudentTrim(Student student);
	public List<Student> queryStudentInfoByIn(List<Integer> list);
	public List<Student> queryStudentInfoByBind(Student student);
	
}

package com.cjy.mybatis.entity;

import org.apache.ibatis.type.Alias;

@Alias("student")
public class Student {

	private Integer id;
	private String stuName;
	private Integer age;
	private String email;
	private String grade;
	
	public Student() {
		super();
	}

	public Student(Integer id, String stuName, Integer age, String email,
			String grade) {
		super();
		this.id = id;
		this.stuName = stuName;
		this.age = age;
		this.email = email;
		this.grade = grade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", stuName=" + stuName + ", age=" + age
				+ ", email=" + email + ", grade=" + grade + "]";
	}
	
}

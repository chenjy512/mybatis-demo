package com.cjy.mybatis.entity;


public class Employee {

	private Integer id;
	private String userName;
	private String gender;
	private String email;
	
	
	
	public Employee(Integer id, String userName, String gender, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.gender = gender;
		this.email = email;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", userName=" + userName + ", gender="
				+ gender + ", email=" + email + "]";
	}
	
}

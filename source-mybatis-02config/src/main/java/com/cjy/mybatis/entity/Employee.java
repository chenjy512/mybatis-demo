package com.cjy.mybatis.entity;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;


//@Alias() ： 不设置别名名称会报错
@Alias("employee")
public class Employee {

	private Integer id;
	private String userName;
	private String gender;
	private String email;
	private Date createtime;
	private List<String> hobbys;
	
	private String objectFacotry;
	
	public Employee(Integer id, String userName, String gender, String email,
			Date createtime,List<String> hobbys) {
		super();
		this.id = id;
		this.userName = userName;
		this.gender = gender;
		this.email = email;
		this.createtime = createtime;
		this.hobbys = hobbys;
	}
	public Employee(Integer id, String userName, String gender, String email,
			Date createtime) {
		super();
		this.id = id;
		this.userName = userName;
		this.gender = gender;
		this.email = email;
		this.createtime = createtime;
	}
	public Employee(Integer id, String userName, String gender, String email,
			List<String> hobbys) {
		super();
		this.id = id;
		this.userName = userName;
		this.gender = gender;
		this.email = email;
		this.hobbys = hobbys;
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
	public List<String> getHobbys() {
		return hobbys;
	}
	public void setHobbys(List<String> hobbys) {
		this.hobbys = hobbys;
	}
	
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	
	public String getObjectFacotry() {
		return objectFacotry;
	}
	public void setObjectFacotry(String objectFacotry) {
		this.objectFacotry = objectFacotry;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", userName=" + userName + ", gender="
				+ gender + ", email=" + email + ", createtime=" + createtime
				+ ", hobbys=" + hobbys + "]";
	}

	
}

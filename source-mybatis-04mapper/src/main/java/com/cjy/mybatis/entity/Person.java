package com.cjy.mybatis.entity;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("person")
public class Person implements Serializable{

	private Integer id;
	private String userName;
	private String marker;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(Integer id, String userName, String marker) {
		super();
		this.id = id;
		this.userName = userName;
		this.marker = marker;
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
	public String getMarker() {
		return marker;
	}
	public void setMarker(String marker) {
		this.marker = marker;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", userName=" + userName + ", marker="
				+ marker + "]";
	}
}

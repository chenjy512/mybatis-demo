package com.cjy.mybatis.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cjy.mybatis.entity.Employee;

@Mapper
public interface EmployeeMapper {

	public Employee selectEmp(int id);
	
	public int saveEmpOne(Employee emp);
}

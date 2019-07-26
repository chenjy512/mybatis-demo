package com.cjy.mybatis.dao;

import com.cjy.mybatis.entity.Employee;

public interface EmployeeMapper {

	public Employee selectEmp(int id);
	
	public int saveEmpOne(Employee emp);
}

package com.cjy.mybatis.dao;

import com.cjy.mybatis.entity.Employee;


import java.util.List;

public interface EmployeeMapper {

    public Employee queryEmpById(Integer id);

    public List<Employee> findAllEmps();

    public int saveEmp(Employee employee);

    public int updateemp(Employee employee);

    public int deleteByEmpId(Integer id);
}

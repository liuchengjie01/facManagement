package com.dao;

import com.pojo.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> queryAllEmployee();
    int insert(Employee EmployeeRecord);
    int deleteByPrimaryKey(String id);
    int updateByPrimaryKey(Employee Employee);
    Employee queryByID(String id);
}

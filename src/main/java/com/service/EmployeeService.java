package com.service;

import com.pojo.Employee;

import java.util.List;


public interface EmployeeService {

    List<Employee> queryAllEmployee();

    int insert(Employee EmployeeRecord);

    int deleteByPrimaryKey(String id);

    int updateByPrimaryKey(Employee employee);

    Employee queryByID(String id);

}

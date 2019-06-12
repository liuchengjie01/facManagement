package com.service.impl;

import com.dao.EmployeeDao;
import com.pojo.Employee;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

    //注入Dao
    @Autowired
    private EmployeeDao eDao;

    @Override
    public List<Employee> queryAllEmployee()
    {
        return eDao.queryAllEmployee();
    }

    @Override
    public int insert(Employee EmployeeRecord){
        return eDao.insert(EmployeeRecord);
    }

    @Override
    public int  deleteByPrimaryKey(String id){
      return eDao.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Employee employee){return eDao.updateByPrimaryKey(employee);}

    @Override
    public Employee queryByID(String id){return eDao.queryByID(id);}


}

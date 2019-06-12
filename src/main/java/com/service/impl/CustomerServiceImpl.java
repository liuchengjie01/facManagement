package com.service.impl;

import com.dao.customerDao;
import com.pojo.Customer;
import com.service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements customerService{

    @Autowired
    private customerDao cDao;

    @Override
    public List<Customer> queryAllCustomer(){ return cDao.queryAllCustomer();}

    @Override
    public int addCustomer(Customer cst){ return cDao.addCustomer(cst);}

    @Override
    public int deleteCustomerByID(String customer_id){return cDao.deleteCustomerByID(customer_id);}

    @Override
    public int updateCustomer(Customer cst){return cDao.updateCustomer(cst);}

    @Override
    public Customer queryCustomerByID(String customer_id){ return cDao.queryCustomerByID(customer_id);}

}

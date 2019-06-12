package com.dao;

import com.pojo.Customer;

import java.util.List;

public interface customerDao {
    List<Customer> queryAllCustomer();

    int addCustomer(Customer cst);

    int deleteCustomerByID(String CustomerID);

    int updateCustomer(Customer cst);

    Customer queryCustomerByID(String CustomerID);
}

package com.service;

import com.pojo.Customer;

import java.util.List;

public interface customerService {

    List<Customer> queryAllCustomer();

    int addCustomer(Customer cst);

    int deleteCustomerByID(String customer_id);

    int updateCustomer(Customer cst);

    Customer queryCustomerByID(String customer_id);

}

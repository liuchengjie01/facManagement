package com.service;

import com.pojo.Pay;

import java.util.List;


public interface PayService {

    List<Pay> queryAllPay();
    int insert(Pay PayRecord);
    int deleteByPrimaryKey(String id1,String id2);
    int updateByPrimaryKey(Pay Pay);
    Pay selectByPrimaryKey(String id1,String id2);

}

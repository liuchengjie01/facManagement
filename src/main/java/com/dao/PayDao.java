package com.dao;

import com.pojo.Pay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayDao {
    List<Pay> queryAllPay();
    int insert(Pay PayRecord);
    int deleteByPrimaryKey(@Param("customerId")String customerId, @Param("projectId")String projectId);
    int updateByPrimaryKey(Pay Pay);
    Pay selectByPrimaryKey(@Param("customerId")String customerId, @Param("projectId")String projectId);
}

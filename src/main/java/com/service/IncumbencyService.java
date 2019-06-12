package com.service;

import com.pojo.Incumbency;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


public interface IncumbencyService {


    List<Incumbency> queryAllIncumbency();
    int insert(Incumbency IncumbencyRecord);
    int deleteByPrimaryKey(String id1,String id2,Date time);
    int updateByPrimaryKey(Incumbency Incumbency);
    Incumbency selectByPrimaryKey(String id1,String id2,Date time);


}

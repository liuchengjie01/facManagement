package com.service;

import com.pojo.Need;

import java.util.List;


public interface NeedService {

    List<Need> queryAllNeed();
    int insert(Need NeedRecord);
    int deleteByPrimaryKey(String id1,String id2);
    int updateByPrimaryKey(Need Need);
    Need selectByPrimaryKey(String id1,String id2);
}

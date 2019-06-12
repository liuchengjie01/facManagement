package com.service;

import com.pojo.RecordsOfManagers;

import java.util.Date;
import java.util.List;


public interface RMService {

    List<RecordsOfManagers> queryAllRecordsOfManagers();
    int insert(RecordsOfManagers RecordsOfManagersRecord);
    int deleteByPrimaryKey(String id1, String id2, Date time);
    int updateByPrimaryKey(RecordsOfManagers RecordsOfManagers);
    RecordsOfManagers selectByPrimaryKey(String id1,String id2,Date time);

}

package com.service.impl;

import com.dao.RMDao;
import com.pojo.RecordsOfManagers;
import com.service.RMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("RMService")
public class RMServiceImpl implements RMService {

    //注入Dao
    @Autowired
    private RMDao RDao;

    @Override
    public List<RecordsOfManagers> queryAllRecordsOfManagers()
    {
        return RDao.queryAllRecordsOfManagers();
    }

    @Override
    public int insert(RecordsOfManagers R){
        return RDao.insert(R);
    }

    @Override
    public int deleteByPrimaryKey(String id1, String id2, Date time){
        return RDao.deleteByPrimaryKey(id1,id2,time);
    }

    @Override
    public int updateByPrimaryKey(RecordsOfManagers RecordsofManagers){return RDao.updateByPrimaryKey(RecordsofManagers);}

    @Override
    public RecordsOfManagers selectByPrimaryKey(String id1, String id2, Date time){return RDao.selectByPrimaryKey(id1,id2,time);}


}

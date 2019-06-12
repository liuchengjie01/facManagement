package com.service.impl;

import com.dao.IncumbencyDao;
import com.pojo.Incumbency;
import com.service.IncumbencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("IncumbencyService")
public class IncumbencyServiceImpl implements IncumbencyService {

    //注入Dao
    @Autowired
    private IncumbencyDao inDao;

    @Override
    public List<Incumbency> queryAllIncumbency()
    {
        return inDao.queryAllIncumbency();
    }

    @Override
    public int insert(Incumbency IncumbencyRecord){
      return inDao.insert(IncumbencyRecord);
    }

    @Override
    public int deleteByPrimaryKey(String id1,String id2,Date time){
     return inDao.deleteByPrimaryKey(id1,id2,time);
    }

    @Override
    public int updateByPrimaryKey(Incumbency Incumbency){return inDao.updateByPrimaryKey(Incumbency);}

    @Override
    public Incumbency selectByPrimaryKey(String id1,String id2,Date time){return inDao.selectByPrimaryKey(id1,id2,time);}

}

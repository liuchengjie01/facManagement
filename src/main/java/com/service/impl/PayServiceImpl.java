package com.service.impl;

import com.dao.PayDao;
import com.pojo.Pay;
import com.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PayService")
public class PayServiceImpl implements PayService {

    //注入Dao
    @Autowired
    private PayDao pDao;

    @Override
    public List<Pay> queryAllPay()
    {
        return pDao.queryAllPay();
    }


    @Override
    public int insert(Pay PayRecord){
        return pDao.insert(PayRecord);
    }

    @Override
    public int deleteByPrimaryKey(String id1, String id2){
        return pDao.deleteByPrimaryKey(id1,id2);
    }

    @Override
    public int updateByPrimaryKey(Pay Pay){return pDao.updateByPrimaryKey(Pay);}

    @Override
    public Pay selectByPrimaryKey(String id1, String id2){return pDao.selectByPrimaryKey(id1,id2);}



}

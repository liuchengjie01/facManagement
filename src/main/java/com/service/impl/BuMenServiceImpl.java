package com.service.impl;

import com.dao.BuMenDao;
import com.pojo.BuMen;
import com.service.BuMenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BuMenService")
public class BuMenServiceImpl implements BuMenService {

    //注入Dao
    @Autowired
    private BuMenDao buDao;

    @Override
    public List<BuMen> queryAllBuMen()
    {
        return buDao.queryAllBuMen();
    }

    @Override
    public int addBumen(BuMen bumenRecord){
        return buDao.addBumen(bumenRecord);
    }

}

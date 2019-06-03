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

    @Override
    public int deleteBumenByID(String id){
      return buDao.deleteBumenByID(id);
    }

    @Override
    public int updateBumen(BuMen bumen){return buDao.updateBumen(bumen);}

    @Override
    public BuMen queryByID(String id){return buDao.queryByID(id);}

}

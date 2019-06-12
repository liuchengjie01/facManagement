package com.service.impl;


import com.dao.involveDao;
import com.pojo.Involve;
import com.service.involveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("involveService")
public class InvolveServiceImpl implements involveService {

    @Autowired
    private involveDao iDao;

    @Override
    public List<Involve> queryAllInvolve(){ return iDao.queryAllInvolve(); }

    @Override
    public int addInvolve(Involve Iv){
        return iDao.addInvolve(Iv);
    }

    @Override
    public int deleteInvolveByID(String employee_id,String project_id,String week_startdate){
        return iDao.deleteInvolveByID(employee_id,project_id,week_startdate);
    }

    @Override
    public int updateInvolve(Involve Iv){
        return iDao.updateInvolve(Iv);
    }

    @Override
    public Involve queryInvolveByID(String employee_id,String project_id,String week_startdate){
        return iDao.queryInvolveByID(employee_id,project_id,week_startdate);
    }

}

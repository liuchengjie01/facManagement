package com.service.impl;

import com.dao.dependantDao;
import com.pojo.Dependant;
import com.service.dependantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dependantService")
public class DependantServiceImpl implements dependantService {

    @Autowired
    private dependantDao dDao;

    @Override
    public List<Dependant> queryAllDependant(){ return dDao.queryAllDependant();}

    @Override
    public int addDependant(Dependant dp){ return dDao.addDependant(dp);}

    @Override
    public int deleteDependantByID(String dependant_id,String employee_id){ return dDao.deleteDependantByID(dependant_id,employee_id);}

    @Override
    public int updateDependant(Dependant dp){ return dDao.updateDependant(dp);};

    @Override
    public Dependant queryDependantByID(String dependant_id,String employee_id){ return dDao.queryDependantByID(dependant_id,employee_id);}
}
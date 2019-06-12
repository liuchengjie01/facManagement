package com.service.impl;


import com.dao.supplierDao;
import com.pojo.supplier;
import com.service.supplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("supplierService")
public class supplierServiceImpl implements supplierService {
    @Autowired
    private supplierDao sDao;

    @Override
    public List<supplier> queryAllSupplier(){ return sDao.queryAllSupplier(); }

    @Override
    public int addSupplier(supplier pj){
        return sDao.addSupplier(pj);
    }

    @Override
    public int deleteSupplierByID(String projectID){
        return sDao.deleteSupplierByID(projectID);
    }

    @Override
    public int updateSupplier(supplier pj){
        return sDao.updateSupplier(pj);
    }

    @Override
    public supplier querySupplierByID(String projectID){
        return sDao.querySupplierByID(projectID);
    }

}

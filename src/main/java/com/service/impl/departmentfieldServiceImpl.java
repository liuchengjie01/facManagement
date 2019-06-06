package com.service.impl;

import com.dao.departmentfieldDao;
import com.pojo.departmentfield;
import com.service.departmentfieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("departmentService")
public class departmentfieldServiceImpl implements departmentfieldService {

    @Autowired
    private departmentfieldDao dfieldDao;

    @Override
    public List<departmentfield> queryAllDepartmentfield(){
        return dfieldDao.queryAllDepartmentfield();
    }

    @Override
    public List<departmentfield> queryDepartmentfieldBydID(String departmentID){
        return dfieldDao.queryDepartmentfieldBydID(departmentID);
    }

    @Override
    public int adddepartmentfield(departmentfield dfield){
        return dfieldDao.adddepartmentfield(dfield);
    }

    @Override
    public int deletedepartmentfieldByID(String departid,String fieldid){
        return dfieldDao.deletedepartmentfieldByID(departid,fieldid);
    }

    @Override
    public int updatedepartmentfield(departmentfield dfield){
        return dfieldDao.updatedepartmentfield(dfield);

    }

    @Override
    public departmentfield queryByID(String departid,String fieldid){
        return dfieldDao.queryByID(departid,fieldid);
    }
}

package com.service.impl;

import com.dao.projectfieldDao;
import com.pojo.project;
import com.pojo.projectfield;
import com.service.projectfieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("projectfield")
public class projectfieldServiceImpl implements projectfieldService {

    @Autowired
    private projectfieldDao pjDao;

    @Override
    public List<projectfield> queryAllProjectfield(){
        return pjDao.queryAllProjectfield();
    }

    @Override
    public int addProjectfield(projectfield pj){
        return pjDao.addProjectfield(pj);
    }

    @Override
    public int deleteProjectfieldByID(String projectfield_id,String project_id){
        return pjDao.deleteProjectfieldByID(projectfield_id,project_id);
    }

    @Override
    public int updateProjectfield(projectfield pj){
        return pjDao.updateProjectfield(pj);
    }

    @Override
    public projectfield queryProjectfieldByID(String projectfield_id, String project_id){
        return pjDao.queryProjectfieldByID(projectfield_id,project_id);
    }
}

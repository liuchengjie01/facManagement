package com.service.impl;


import com.dao.projectDao;
import com.pojo.project;
import com.service.projectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("projectService")
public class projectServiceImpl implements projectService {

    @Autowired
    private projectDao pDao;

    @Override
    public List<project> queryAllProject(){ return pDao.queryAllProject(); }

    @Override
    public int addProject(project pj){
        return pDao.addProject(pj);
    }

    @Override
    public int deleteProjectByID(String projectID){
        return pDao.deleteProjectByID(projectID);
    }

    @Override
    public int updateProject(project pj){
        return pDao.updateProject(pj);
    }

    @Override
    public project queryProjectByID(String projectID){
        return pDao.queryProjectByID(projectID);
    }

}

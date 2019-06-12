package com.service.impl;

import com.dao.assignmentDao;
import com.pojo.Assignment;
import com.service.assignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("assignmentService")
public class AssignmentServiceImpl implements assignmentService {

    @Autowired
    private assignmentDao aDao;

    @Override
    public List<Assignment> queryAllAssignment(){ return aDao.queryAllAssignment();}

    @Override
    public int addAssignment(Assignment ag){ return aDao.addAssignment(ag);}

    @Override
    public int deleteAssignmentByID(String task_id, String project_id){ return aDao.deleteAssignmentByID(task_id,project_id);}

    @Override
    public int updateAssignment(Assignment ag){ return aDao.updateAssignment(ag);}

    @Override
    public Assignment queryAssignmentByID(String task_id, String project_id){ return aDao.queryAssignmentByID(task_id,project_id);}

}

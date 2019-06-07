package com.service;

import com.pojo.project;

import java.util.List;

public interface projectService {

    List<project> queryAllProject();

    int addProject(project pj);

    int deleteProjectByID(String projectID);

    int updateProject(project pj);

    project queryProjectByID(String projectID);

}

package com.service;
import com.pojo.projectfield;

import java.util.List;

public interface projectfieldService {
    List<projectfield> queryAllProjectfield();

    int addProjectfield(projectfield pj);

    int deleteProjectfieldByID(String projectfield_id,String project_id);

    int updateProjectfield(projectfield pj);

    projectfield queryProjectfieldByID(String projectfield_id,String project_id);
}

package com.dao;

import com.pojo.project;
import com.pojo.projectfield;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface projectfieldDao {
    List<projectfield> queryAllProjectfield();

    int addProjectfield(projectfield pj);

    int deleteProjectfieldByID(@Param("projectfield_id")String projectfield_id,@Param("project_id") String project_id);

    int updateProjectfield(projectfield pj);

    projectfield queryProjectfieldByID(@Param("projectfield_id")String projectfield_id,@Param("project_id") String project_id);
}

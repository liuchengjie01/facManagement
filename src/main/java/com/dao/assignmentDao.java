package com.dao;

import com.pojo.Assignment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface assignmentDao{
    List<Assignment> queryAllAssignment();

    int addAssignment(Assignment ag);

    int deleteAssignmentByID(@Param("task_id") String task_id,@Param("project_id") String project_id);

    int updateAssignment(Assignment ag);

    Assignment queryAssignmentByID(@Param("task_id") String task_id,@Param("project_id") String project_id);
}
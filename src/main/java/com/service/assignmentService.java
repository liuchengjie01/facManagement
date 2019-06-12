package com.service;

import com.pojo.Assignment;

import java.util.List;

public interface assignmentService {

    List<Assignment> queryAllAssignment();

    int addAssignment(Assignment ag);

    int deleteAssignmentByID(String task_id, String project_id);

    int updateAssignment(Assignment ag);

    Assignment queryAssignmentByID(String task_id, String project_id);

}

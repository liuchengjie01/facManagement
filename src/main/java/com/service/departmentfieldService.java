package com.service;

import com.pojo.departmentfield;

import java.util.List;

public interface departmentfieldService {

    List<departmentfield> queryAllDepartmentfield();

    List<departmentfield> queryDepartmentfieldBydID(String departmentID);

    int adddepartmentfield(departmentfield dfield);

    int deletedepartmentfieldByID(String departid,String fieldid);

    int updatedepartmentfield(departmentfield dfield);

    departmentfield queryByID(String departid,String fieldid);
}

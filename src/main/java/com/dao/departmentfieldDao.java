package com.dao;

import com.pojo.departmentfield;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface departmentfieldDao {
    List<departmentfield> queryAllDepartmentfield();

    List<departmentfield> queryDepartmentfieldBydID(String departmentID);

    int adddepartmentfield(departmentfield dfield);

    int deletedepartmentfieldByID(@Param("departmentID")String departmentID,@Param("departmentfieldID") String departmentfieldID);

    int updatedepartmentfield(departmentfield dfield);

    departmentfield queryByID(@Param("departmentID")String departmentID,@Param("departmentfieldID") String departmentfieldID);
}

package com.dao;

import com.pojo.Dependant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface dependantDao {

    List<Dependant> queryAllDependant();

    int addDependant(Dependant dp);

    int deleteDependantByID(@Param("dependant_id") String dependant_id,@Param("employee_id") String employee_id);

    int updateDependant(Dependant dp);

    Dependant queryDependantByID(@Param("dependant_id") String dependant_id,@Param("employee_id") String employee_id);

}
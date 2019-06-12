package com.service;

import com.pojo.Dependant;

import java.util.List;

public interface dependantService {

    List<Dependant> queryAllDependant();

    int addDependant(Dependant dp);

    int deleteDependantByID(String dependant_id,String employee_id);

    int updateDependant(Dependant dp);

    Dependant queryDependantByID(String dependant_id,String employee_id);

}
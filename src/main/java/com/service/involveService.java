package com.service;

import com.pojo.Involve;

import java.util.List;

public interface involveService {

    List<Involve> queryAllInvolve();

    int addInvolve(Involve Iv);

    int deleteInvolveByID(String employee_id,String project_id,String week_startdate);

    int updateInvolve(Involve Iv);

    Involve queryInvolveByID(String employee_id,String project_id,String week_startdate);

}

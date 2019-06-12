package com.dao;

import com.pojo.Involve;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface involveDao {
    List<Involve> queryAllInvolve();

    int addInvolve(Involve Iv);

    int deleteInvolveByID(@Param("employee_id") String employee_id,@Param("project_id") String project_id,@Param("week_startdate") String week_startdate);

    int updateInvolve(Involve Iv);

    Involve queryInvolveByID(@Param("employee_id") String employee_id,@Param("project_id") String project_id,@Param("week_startdate") String week_startdate);
}

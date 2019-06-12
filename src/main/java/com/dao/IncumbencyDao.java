package com.dao;

import com.pojo.Incumbency;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface IncumbencyDao {
    List<Incumbency> queryAllIncumbency();
    int insert(Incumbency IncumbencyRecord);
    int deleteByPrimaryKey(@Param("employeeId") String employeeId,@Param("departmentId") String departmentId,@Param("departmentEtime") Date departmentEtime);
    int updateByPrimaryKey(Incumbency Incumbency);
    Incumbency selectByPrimaryKey(@Param("employeeId") String employeeId,@Param("departmentId") String departmentId,@Param("departmentEtime") Date departmentEtime);

}

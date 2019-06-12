package com.dao;

import com.pojo.RecordsOfManagers;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface RMDao {
    List<RecordsOfManagers> queryAllRecordsOfManagers();
    int insert(RecordsOfManagers RecordsOfManagersRecord);
    int deleteByPrimaryKey(@Param("departmentId")String departmentId, @Param("employeeId")String employeeId,@Param("takeofficeDate")Date takeofficeDate);
    int updateByPrimaryKey(RecordsOfManagers RecordsOfManagers);
    RecordsOfManagers selectByPrimaryKey(@Param("departmentId")String departmentId, @Param("employeeId")String employeeId,@Param("takeofficeDate")Date takeofficeDate);
}

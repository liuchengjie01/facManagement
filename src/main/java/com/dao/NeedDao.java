package com.dao;

import com.pojo.Need;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NeedDao {
    List<Need> queryAllNeed();
   int insert(Need NeedRecord);
   int deleteByPrimaryKey(@Param("projectId")String projectId, @Param("materialId")String materialId);
   int updateByPrimaryKey(Need Need);
   Need selectByPrimaryKey(@Param("projectId")String projectId, @Param("materialId")String materialId);
}

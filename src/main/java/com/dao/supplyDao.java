package com.dao;

import com.pojo.supply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface supplyDao {
    List<supply> queryAllSupply();

    int addSupply(supply sp);

    int deleteSupplyByID(@Param("supplier_id")String supplier_id,@Param("material_id") String material_id);

    int updateSupply(supply sp);

    supply querySupplyByID(@Param("supplier_id")String supplier_id,@Param("material_id") String material_id);
}

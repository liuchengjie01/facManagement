package com.dao;

import com.pojo.supply;

import java.util.List;

public interface supplyDao {
    List<supply> queryAllSupply();

    int addSupply(supply sp);

    int deleteSupplyByID(String supplier_id,String material_id);

    int updateSupply(supply sp);

    supply querySupplyByID(String supplier_id,String material_id);
}

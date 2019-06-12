package com.service.impl;

import com.dao.supplyDao;
import com.pojo.supply;
import com.service.supplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("supplyService")
public class supplyServiceImpl implements supplyService {

    @Autowired
    private supplyDao sdao;

    @Override
    public List<supply> queryAllSupply(){
        return sdao.queryAllSupply();
    }

    @Override
    public int addSupply(supply sp){
        return sdao.addSupply(sp);
    }

    @Override
    public int deleteSupplyByID(String supplier_id,String material_id){
        return sdao.deleteSupplyByID(supplier_id,material_id);
    }

    @Override
    public int updateSupply(supply sp){
        return sdao.updateSupply(sp);
    }

    @Override
    public supply querySupplyByID(String supplier_id,String material_id){
        return sdao.querySupplyByID(supplier_id,material_id);
    }


}

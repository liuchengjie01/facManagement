package com.dao;

import com.pojo.BuMen;

import java.util.List;

public interface  BuMenDao {
    List<BuMen> queryAllBuMen();
    int addBumen(BuMen bumenRecord);

}
